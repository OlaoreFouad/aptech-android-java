package dev.iamfoodie.tablayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import dev.iamfoodie.tablayoutdemo.adapters.ViewPagerAdapter;
import dev.iamfoodie.tablayoutdemo.fragments.CallsFragment;
import dev.iamfoodie.tablayoutdemo.fragments.ChatsFragment;
import dev.iamfoodie.tablayoutdemo.fragments.StatusFragment;
import dev.iamfoodie.tablayoutdemo.listeners.OnFragmentNavigatedListener;

public class MainActivity extends AppCompatActivity
//        implements OnFragmentNavigatedListener
{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new ChatsFragment(), "Chats");
        adapter.add(new StatusFragment(), "Status");
        adapter.add(new CallsFragment(), "Calls");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
