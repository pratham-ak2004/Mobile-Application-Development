package com.example.webview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class WebViewActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        WebView webView = (WebView) findViewById(R.id.webView);

        String url = getIntent().getStringExtra("url");
        if(!Objects.requireNonNull(url).isEmpty()){
            webView.loadUrl(url);

            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}
