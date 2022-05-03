package com.example.smart_storage;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button signup;
    TextView tologin;
    FirebaseAuth auth;
    FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_sign);
        password = findViewById(R.id.password_sign);
        signup = findViewById(R.id.signup);
        tologin = findViewById(R.id.tologin);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(MainActivity.this,homepage.class);
            startActivity(intent);
            finish();
        }
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter All Details!", Toast.LENGTH_LONG).show();
                }
                else{
                    String newemail = email.getText().toString();
                    String newpass = password.getText().toString();
                    signupUser(newemail,newpass);
                }
            }
        });
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void signupUser(String newemail,String newpass){

        if(newemail.isEmpty() || newpass.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Fill all the Details!", Toast.LENGTH_LONG).show();
        }
        else {
            auth.createUserWithEmailAndPassword(newemail, newpass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Usermodels userModel = new Usermodels(newemail, newpass);
                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("Admin").child(id).setValue(userModel);
                                Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                Intent backtostart = new Intent(MainActivity.this, Login.class);
                                startActivity(backtostart);
                            } else {
                                Toast.makeText(MainActivity.this, "Error:" + task.getException(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }
    }
}