package dev.iamfoodie.filehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText filenameEditText, contentEditText, getFilenameEditText;
    private Button saveButton, getButton;
    private TextView contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filenameEditText = findViewById(R.id.filename_edit_text);
        contentEditText = findViewById(R.id.content_edit_text);
        getFilenameEditText = findViewById(R.id.get_filename_edit_text);
        saveButton = findViewById(R.id.save_button);
        getButton = findViewById(R.id.get_button);
        contentText = findViewById(R.id.get_file_text);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveButtonClicked();
            }
        });

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getButtonClicked();
            }
        });
    }

    private void saveButtonClicked() {
        String filename = filenameEditText.getText().toString();
        String content = contentEditText.getText().toString();

        if (filename.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        File file = new File(getFilesDir(), filename);
        try {
            FileOutputStream fos = openFileOutput(filename, MODE_APPEND);
            fos.write(content.getBytes("utf-8"));
            Toast.makeText(this, "Content Added Successfully!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File does not exist", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getButtonClicked() {
        String filename = getFilenameEditText.getText().toString();

        if (filename.isEmpty()) {
            Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        String content = "";

        try {
            FileInputStream fis = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            StringBuilder stringBuilder = new StringBuilder();
            try(BufferedReader bufferedReader = new BufferedReader(isr)) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                Toast.makeText(this, "Error while reading from file!!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } finally {
                content = stringBuilder.toString();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        contentText.setText(content);

    }

}
