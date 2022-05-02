package com.example.smart_storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    FirebaseAuth auth;
    Button signup;
    TextView tologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_log);
        password = findViewById(R.id.pass_log);
        signup = findViewById(R.id.login);
        tologin = findViewById(R.id.to_sign);
        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "Please Enter All Details!", Toast.LENGTH_LONG).show();
                }
                else{
                    loginUser();
                }
            }
        });
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void loginUser() {
        String inputuser = email.getText().toString();
        String inputpass = password.getText().toString();
        if (inputuser.isEmpty() || inputpass.isEmpty()) {
            Toast.makeText(Login.this, "Please Enter All The Details!", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(inputuser, inputpass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "Log-In Successfull!", Toast.LENGTH_SHORT).show();
                                Intent logMain = new Intent(Login.this, homepage.class);
                                startActivity(logMain);
                            } else {
                                Toast.makeText(Login.this, "Error:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}