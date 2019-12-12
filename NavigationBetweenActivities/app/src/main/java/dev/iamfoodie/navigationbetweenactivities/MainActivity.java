package dev.iamfoodie.navigationbetweenactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button sendButton, sendForResultButton;
    private EditText inputField;
    private TextView sentBack;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.send_button);
        inputField = findViewById(R.id.edit_text);
        sendForResultButton = findViewById(R.id.send_button_result);
        sentBack = findViewById(R.id.sent_bac);

        sendForResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                if (getEditText() != null) {
                    resultIntent.putExtra("text", getEditText());
                    startActivityForResult(resultIntent, REQUEST_CODE);
                }
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                if (getEditText() != null) {
                    intent.putExtra("text", getEditText());
                    startActivity(intent);
                }
            }
        });

    }

    private String getEditText() {
        if (inputField.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Empty fields!", Toast.LENGTH_SHORT).show();
            return null;
        }

        return inputField.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode ==  RESULT_OK) {
                Bundle extras = data.getExtras();
                String text = extras.getString("text");
                sentBack.setText(text);
            }
        }
    }
}
