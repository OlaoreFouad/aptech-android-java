package dev.iamfoodie.animationsandtransitions;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private Button translateButton, alphaButton, rotateButton, scaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.steering_wheel_image);

        translateButton = findViewById(R.id.translate_button); translateButton.setOnClickListener(this);
        alphaButton = findViewById(R.id.alpha_button); alphaButton.setOnClickListener(this);
        rotateButton = findViewById(R.id.rotate_button); rotateButton.setOnClickListener(this);
        scaleButton = findViewById(R.id.scale_button); scaleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.translate_button) {
            translate();
        } else if (view.getId() == R.id.rotate_button) {
            rotate();
        } else if (view.getId() == R.id.scale_button) {
            scale();
        } else if (view.getId() == R.id.alpha_button) {
            alpha();
        }
    }

    private void translate() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.translate);
        animator.setTarget(image);
        animator.start();
    }

    private void rotate() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
        animator.setTarget(image);
        animator.start();
    }

    private void alpha() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        animator.setTarget(image);
        animator.start();
    }

    private void scale() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale);
        animator.setTarget(image);
        animator.start();
    }
}
