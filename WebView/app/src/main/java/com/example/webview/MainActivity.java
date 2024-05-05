package com.example.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        link = (EditText) findViewById(R.id.editTextText);
        Button redirect = findViewById(R.id.button);

        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage();
            }
        });
    }

    private void openWebPage() {
        String l = link.getText().toString();
        String url = l.isEmpty() ? "https://www.google.com" : l;

        Intent webIntent = new Intent(this, WebViewActivity.class);
        webIntent.putExtra("url", url);
        startActivity(webIntent);
    }
}