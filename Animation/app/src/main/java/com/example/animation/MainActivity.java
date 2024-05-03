package com.example.animation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        blink();
        moveImage();
        rotateImage();
        zoomImage();
    }

    private void blink() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(imageView.getVisibility() == View.VISIBLE ? View.INVISIBLE:View.VISIBLE);
                blink();
            }
        },500);
    }

    private void moveImage() {
        TranslateAnimation animation = new TranslateAnimation(0,200,0,100);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    private void rotateImage() {
        RotateAnimation animation = new RotateAnimation(0,90,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    private void zoomImage() {
        ScaleAnimation animation = new ScaleAnimation(1f,3f,1f,3f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }
}