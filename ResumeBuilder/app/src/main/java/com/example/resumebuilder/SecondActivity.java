package com.example.resumebuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    RadioButton male, female;
    Button save;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
        save = findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = male.isChecked()?"Male":female.isChecked()?"Female":" ";
                if (!gender.equals(" "))
                    Toast.makeText(SecondActivity.this, "saved successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
