package dev.iamfoodie.navigationbetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView passedInText = findViewById(R.id.passed_in_txt);
        final EditText passedInEditText = findViewById(R.id.pass_in_edit_txt);
        Button sendBackButton = findViewById(R.id.send_back_button);

        Bundle extras = getIntent().getExtras();
        String text = extras.getString("text");
        passedInText.setText(text);

        sendBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passedInEditText.getText().toString().isEmpty()) {
                    Toast.makeText(ResultActivity.this, "Empty fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                String text = passedInEditText.getText().toString();
                Intent goBackIntent = getIntent();
                goBackIntent.putExtra("text", text);
                setResult(RESULT_OK, goBackIntent);
                finish();
            }
        });

    }
}
