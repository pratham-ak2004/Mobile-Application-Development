package com.example.confirmchanges;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View view;
    private Button change;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.view);
        change = findViewById(R.id.button);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmChange();
            }
        });
    }

    private void confirmChange() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        @SuppressLint("InflateParams")
        View dialogView = getLayoutInflater().inflate(R.layout.dialogbox,null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btnYes = dialogView.findViewById(R.id.button2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btnNo = dialogView.findViewById(R.id.button3);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int color = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
                view.setBackgroundColor(color);
                dialog.dismiss();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}