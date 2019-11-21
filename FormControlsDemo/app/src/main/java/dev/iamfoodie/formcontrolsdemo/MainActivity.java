package dev.iamfoodie.formcontrolsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username, pwd;
    private RadioGroup group;
    private CheckBox marriedCheckbox;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username_edit_text);
        pwd = findViewById(R.id.password_edit_text);
        group = findViewById(R.id.gender_radio_group);
        marriedCheckbox = findViewById(R.id.married_check_box);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_button: 
                formSubmitted();
                break;
        }
    }

    private void formSubmitted() {
        String _username, _pwd;
        boolean married;
        String gender;

        _username = username.getText().toString();
        _pwd = pwd.getText().toString();
        married = marriedCheckbox.isSelected();

        if (_username.isEmpty() ||  _pwd.isEmpty()) {
            Toast.makeText(this, "Empty text fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.male_radio_btn:
                gender = "Male";
                break;
            case R.id.female_radio_btn:
                gender = "Female";
                break;
            default:
                Toast.makeText(this, "Select a gender value", Toast.LENGTH_SHORT).show();
                return;
        }

        Log.d("MainActivity", "Username: " + _username + ", Password: " + _pwd + ", Gender: " + gender+ ", Married: " + married);

    }
}
