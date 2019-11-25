package dev.iamfoodie.notificationsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText title, description;
    private Button notifyButton;
    private NotificationManagerCompat managerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title_edit_text);
        description = findViewById(R.id.description_edit_text);
        notifyButton = findViewById(R.id.notify_button);
    }

    private void showNotification() {
        String titleValue = title.getText().toString();
        String descValue = description.getText().toString();

        if (titleValue.isEmpty() || descValue.isEmpty()) {
            Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
