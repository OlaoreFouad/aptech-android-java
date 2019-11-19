package dev.iamfoodie.alertdialogsdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button basicDialogButton, progressDialogButton, datePickerDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicDialogButton = findViewById(R.id.basic_dialog_button);
        progressDialogButton = findViewById(R.id.prog_dialog_button);
        datePickerDialogButton = findViewById(R.id.datepicker_dialog_button);

        basicDialogButton.setOnClickListener(this);
        progressDialogButton.setOnClickListener(this);
        datePickerDialogButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.basic_dialog_button:
                 launchBasicDialog();
                break;
            case R.id.prog_dialog_button:
                launchProgessDialog();
                break;
            case R.id.datepicker_dialog_button:
                launchDateDialog();
                break;
            default:
                break;
        }
    }

    private void launchDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Log.d("MainActivity", String.valueOf(datePicker.getYear()));
            }
        }, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);

        datePickerDialog.show();
    }

    private void launchBasicDialog() {
        String message = "Are you sure you want to send a message";
        String title = "Basic Dialog";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("MainActivity", "Yes button was clicked!");
                        Toast.makeText(MainActivity.this, "Okay, bro!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("MainActivity", "No button was clicked!");
                        Toast.makeText(MainActivity.this, "Why you been open am before?", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.show();

    }

    private void launchProgessDialog(){
        String title = "Downloading (1/2)";
        String message = "Loading...";

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);

        progressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 2500L);
    }
}
