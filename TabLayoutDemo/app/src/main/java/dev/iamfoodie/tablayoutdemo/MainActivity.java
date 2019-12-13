package dev.iamfoodie.tablayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import dev.iamfoodie.tablayoutdemo.fragments.CallsFragment;
import dev.iamfoodie.tablayoutdemo.fragments.ChatsFragment;
import dev.iamfoodie.tablayoutdemo.fragments.StatusFragment;
import dev.iamfoodie.tablayoutdemo.listeners.OnFragmentNavigatedListener;

public class MainActivity extends AppCompatActivity implements OnFragmentNavigatedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    @Override
    public void nextFragment(String tag) {
        if (tag == "fragmentChats") {
            setFragment(new ChatsFragment(), tag, false);
        } else if (tag == "fragmentStatus") {
            setFragment(new StatusFragment(), tag, false);
        } else if (tag == "fragmentCalls") {
            setFragment(new CallsFragment(), tag, false);
        }
    }

    private void init() {
        setFragment(new ChatsFragment(), "fragmentChats", false);
    }

    private void setFragment(Fragment fragment, String tag, boolean addToBackStack) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

}
