package com.example.sharedpreference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "My_Prefs";
    private static final String KEY_NAME = "name";
    private EditText name;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);

        retrieveData();

        Button save = (Button) findViewById(R.id.button);
        Button delete = (Button) findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
    }

    public void saveData(){
        String n = name.getText().toString();
        if(!n.isEmpty()){
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_NAME,n);
            editor.apply();
            Toast.makeText(this,"Saved Data Successfully",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Failed to save Data",Toast.LENGTH_LONG).show();
        }
        retrieveData();
    }

    private void retrieveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedName = sharedPreferences.getString(KEY_NAME,"");
        textView.setText(savedName);
    }

    public void deleteData(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_NAME);
        editor.apply();
        retrieveData();
    }
}