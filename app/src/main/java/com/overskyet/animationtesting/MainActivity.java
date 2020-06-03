package com.overskyet.animationtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animateButton();
    }

    private void animateButton() {
        final Button movingButton = findViewById(R.id.moving_button);
        movingButton.setOnClickListener(view -> {

            ObjectAnimator animWidth = ObjectAnimator.ofInt(view, "width", view.getWidth() + getScreenWidth());
            animWidth.addUpdateListener(animation -> {
                view.getLayoutParams().width = (Integer) animation.getAnimatedValue();
                view.requestLayout();
            });
            animWidth.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    startActivity();
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.play(animWidth);
            animatorSet.start();

        });
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public void startActivity() {
        Intent myIntent = new Intent(this, BlankActivity.class);
        startActivity(myIntent);
    }
}