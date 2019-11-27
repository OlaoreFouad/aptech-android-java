package dev.iamfoodie.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BuildCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText savePreferenceKey, savePreferenceVal, getPreferenceKey;
    private Button saveButton, getButton;
    private TextView getText;

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferenceEditor;

    public static final String APP_NAME = "SP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savePreferenceKey = findViewById(R.id.preference_key);
        savePreferenceVal = findViewById(R.id.preference_val);
        getPreferenceKey = findViewById(R.id.get_prefrence_key);
        saveButton = findViewById(R.id.save_button);
        getButton = findViewById(R.id.get_button);
        getText = findViewById(R.id.get_text);

        preferences = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
        preferenceEditor = preferences.edit();

        saveButton.setOnClickListener(this);
        getButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.save_button:
                savePreference();
                break;
            case R.id.get_button:
                getPreference();
                break;
            default:
                break;
        }
    }

    private void savePreference() {
        String key = savePreferenceKey.getText().toString();
        String val = savePreferenceVal.getText().toString();

        if (key.isEmpty() || val.isEmpty()) {
            Toast.makeText(this, "Emoty fields!!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            preferenceEditor.putString(key, val);
            preferenceEditor.commit();
            Toast.makeText(this, "Preference successfully saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getPreference() {
        String key = getPreferenceKey.getText().toString();
        if (key.isEmpty()) {
            Toast.makeText(this, "Empty get field!!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            String val = preferences.getString(key, "Preference does not exist!");
            getText.setText("Val: " + val);
        }
    }


}
