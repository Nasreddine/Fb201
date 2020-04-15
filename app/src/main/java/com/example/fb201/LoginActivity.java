package com.example.fb201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText email, pass;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener auth_listener;
    private Button signin, signupaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        signupaccount = findViewById(R.id.signupaccount);
        signin = findViewById(R.id.signin);

        auth = FirebaseAuth.getInstance();// create user and log in
        auth_listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(LoginActivity.this, OrderManagerActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please Login", Toast.LENGTH_LONG).show();
                }
            }
        };

        signupaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString();
                String passValue = pass.getText().toString();

                auth.createUserWithEmailAndPassword(emailValue, passValue).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Registration FAILED !", Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString();
                String passValue = pass.getText().toString();

                auth.signInWithEmailAndPassword(emailValue, passValue).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Cannot Login ! Check Credentials !", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(auth_listener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(auth_listener);
    }
}
