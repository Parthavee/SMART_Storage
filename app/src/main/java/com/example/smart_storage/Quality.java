package com.example.smart_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Quality extends AppCompatActivity {
    EditText Hardness;
    EditText Hard;
    TextView  R1;
    TextView R2;
    TextView R3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality);
        Hardness = findViewById(R.id.editTextTextPersonName4);
        Hard = findViewById(R.id.editTextTextPersonName3);
        R1 = findViewById(R.id.textView7);
        R2 = findViewById(R.id.textView8);
        R3 = findViewById(R.id.textView6);
    }
}