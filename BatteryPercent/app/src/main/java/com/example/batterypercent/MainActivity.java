package com.example.batterypercent;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,100);

            int batteryPercent = (level*100)/scale;
            progressBar.setProgress(batteryPercent);
            int color = getColorForBatteryLevel(batteryPercent);

            getWindow().getDecorView().setBackgroundColor(color);
        }
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    public int getColorForBatteryLevel(int batteryPercent){
        if(batteryPercent >= 0 && batteryPercent <=20){
            return Color.RED;
        }else if(batteryPercent>20 && batteryPercent<=60){
            return Color.BLUE;
        }else{
            return Color.GREEN;
        }
    } 
}