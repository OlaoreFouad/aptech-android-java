package dev.foodie.androidsystemoverview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView textView;

    int number = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.hello_txt);
        textView.setText(String.valueOf(number));

        Button button = findViewById(R.id.add_one_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(String.valueOf(number+1));
            }
        });

        Log.i(TAG, "onCreate called!");
    }

    void addOne(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause called!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called!");
    }
}
