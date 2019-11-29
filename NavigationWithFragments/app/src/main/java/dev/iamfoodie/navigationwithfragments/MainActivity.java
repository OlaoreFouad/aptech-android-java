package dev.iamfoodie.navigationwithfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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

    public void setFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }

        transaction.commit();

    }

}
