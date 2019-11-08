package dev.iamfoodie.tipit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amountEditText, tipPercentEditText;
    private Button tipButton, clearButton;
    private TextView tipText;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amount_edit_text);
        tipPercentEditText = findViewById(R.id.tip_percent_edit_text);
        tipButton = findViewById(R.id.calculate_tip_button);
        tipText = findViewById(R.id.tip_calculated_text);

        clearButton = findViewById(R.id.clear_tip_text_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
                tipText.setVisibility(View.GONE);
                amountEditText.getText().clear();
                tipPercentEditText.getText().clear();
            }
        });

        tipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipButtonClicked();
            }
        });

    }

    private void tipButtonClicked() {
        String amount, percent;
        amount = amountEditText.getText().toString();
        percent = tipPercentEditText.getText().toString();

        if (amount.isEmpty() || percent.isEmpty()) {
            Toast.makeText(this, "Empty text fields!", Toast.LENGTH_SHORT).show();
        } else {
            double tip = getTipValue(Integer.parseInt(amount), Integer.parseInt(percent));
            showTipMessage(tip);
        }

    }

    private double getTipValue(int amount, int percent) {
        double percent_amount = (double) percent / 100;
        double tip = percent_amount * amount;

        return tip;
    }

    private void showTipMessage(double tip) {
        tipText.setText("Tip the waiter: " + String.valueOf(tip));
        tipText.setVisibility(View.VISIBLE);
        clearButton.setVisibility(View.VISIBLE);
    }

}
