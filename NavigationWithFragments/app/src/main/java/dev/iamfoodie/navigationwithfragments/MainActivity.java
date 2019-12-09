package dev.iamfoodie.navigationwithfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import dev.iamfoodie.navigationwithfragments.fragments.OneFragment;
import dev.iamfoodie.navigationwithfragments.fragments.TwoFragment;
import dev.iamfoodie.navigationwithfragments.listeners.OnDataSentListener;

public class MainActivity extends AppCompatActivity implements OnDataSentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public void send(String text, String tag) {
        if (tag.equals("fragmentOne")) {
            TwoFragment twoFragment = new TwoFragment();

            Bundle bundle = new Bundle();
            bundle.putString("text", text);

            twoFragment.setArguments(bundle);
            setFragment(twoFragment, "fragmentTwo", true);
        }
    }

    public void init() {
        OneFragment oneFragment = new OneFragment();
        setFragment(oneFragment, "fragmentOne", false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_contact:
                Toast.makeText(this, "Contacts Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                Toast.makeText(this, "About Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(this, "Settings Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_search:
                Toast.makeText(this, "Search clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
    }

    public void setFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }

        transaction.commit();

    }

}
