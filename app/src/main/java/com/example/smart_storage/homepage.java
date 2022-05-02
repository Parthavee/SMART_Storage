package com.example.smart_storage;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class homepage extends AppCompatActivity {
    TextView logout;
    Button foodgrn;
    Button alert;
    Button dg;
    Button security;
    Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        logout = findViewById(R.id.logout);
        foodgrn = findViewById(R.id.button2);
        alert = findViewById(R.id.button3);
        dg = findViewById(R.id.button4);
        security = findViewById(R.id.button5);
        profile = findViewById(R.id.button6);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(homepage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        foodgrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,Grainselect.class);
                startActivity(intent);
                finish();
            }
        });
        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,Security.class);
                startActivity(intent);

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,Profile.class);
                startActivity(intent);

            }
        });


    }
}