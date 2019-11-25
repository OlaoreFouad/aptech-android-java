package dev.iamfoodie.notificationsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText title, content;
    private Button channel1Button, channel2Button;

    private NotificationManagerCompat managerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title_edit_text);
        content = findViewById(R.id.content_edit_text);
        channel1Button = findViewById(R.id.channel_one_button);
        channel2Button = findViewById(R.id.channel_two_button);

        managerCompat = NotificationManagerCompat.from(this);

        channel1Button.setOnClickListener(this);
        channel2Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.channel_one_button:
                sendNotifOnChannelOne();
                break;
            case R.id.channel_two_button:
                sendNotifOnChannelTwo();
                break;
            default:
                break;
        }
    }

    private void sendNotifOnChannelOne() {

        String _title = title.getText().toString();
        String _content = content.getText().toString();

        if (_title.isEmpty() || _content.isEmpty()) {
            Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MyApplication.CHANNEL_1_ID)
                    .setContentTitle(_title)
                    .setContentText(_content)
                    .setSmallIcon(R.drawable.ic_launcher_background);

            Notification notification = builder.build();
            managerCompat.notify(1, notification);
        }
    }

    private void sendNotifOnChannelTwo() {
        String _title = title.getText().toString();
        String _content = content.getText().toString();

        if (_title.isEmpty() || _content.isEmpty()) {
            Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MyApplication.CHANNEL_2_ID)
                    .setContentTitle(_title)
                    .setContentText(_content)
                    .setSmallIcon(R.drawable.ic_launcher_background);

            Notification notification = builder.build();
            managerCompat.notify(2, notification);
        }
    }
}
