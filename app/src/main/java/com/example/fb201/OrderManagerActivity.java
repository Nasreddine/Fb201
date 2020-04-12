package com.example.fb201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OrderManagerActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_manager);

        tview = findViewById(R.id.textView2);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        tview.setText("current user "+user.getEmail()+ " "+user.getUid());

        tview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(OrderManagerActivity.this, ""+auth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                auth.signOut();
                Intent intent = new Intent(OrderManagerActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
