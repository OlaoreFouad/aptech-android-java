package dev.iamfoodie.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dev.iamfoodie.bottomnavigationview.fragments.HomeFragment;
import dev.iamfoodie.bottomnavigationview.fragments.MessagesFragment;
import dev.iamfoodie.bottomnavigationview.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottom_nav_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        setFragment(fragment, "fragmenthome", false);
                        break;
                    case R.id.nav_messages:
                        fragment = new MessagesFragment();
                        setFragment(fragment, "fragmentMessages", false);
                        break;
                    case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        setFragment(fragment, "fragmentProfile", false);
                        break;
                }
                return true;
            }
        });
        mBottomNavigationView.setSelectedItemId(R.id.nav_home);

    }

    private void setFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }

        fragmentTransaction.commit();
    }

}
