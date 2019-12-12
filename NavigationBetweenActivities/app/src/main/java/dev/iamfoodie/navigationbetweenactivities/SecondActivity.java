package dev.iamfoodie.navigationbetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private ImageView backButton;
    private TextView sentText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backButton = findViewById(R.id.back_button);
        sentText = findViewById(R.id.sent_text);
        Intent launchedIntent = getIntent();
        Bundle extras = launchedIntent.getExtras();

        String text = "";
        if (extras != null) {
            text = extras.getString("text");
        }
        sentText.setText(text);


    }
}
