package com.example.fb201;

import Model.Order;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener auth_listener;
    private Button signout;
    Button getDataButton;
    Button addDataButton;
    Button clearDataButton;
    TextView dataFromDb;
    FirebaseDatabase database;
    DatabaseReference ref;
    long maxid;
    Order o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataButton = findViewById(R.id.button2);
        addDataButton = findViewById(R.id.button);
        clearDataButton = findViewById(R.id.button3);
        dataFromDb = findViewById(R.id.textview1);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Order");

//        Order o1 = new Order(1, "16", 1000);
//        ref.child("1").setValue(o1);
//
//        Order o2 = new Order(1, "18", 2500);
//        ref.child("2").setValue(o2);
//
//        Order o3 = new Order(1, "31", 800);
//        ref.child("3").setValue(o3);

        o = new Order(1, "19", 7000);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxid = dataSnapshot.getChildrenCount()+1;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child(""+maxid).setValue(o);
                Toast.makeText(MainActivity.this, "Data Added Succesfully !", Toast.LENGTH_SHORT).show();
            }
        });

        clearDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.removeValue();
            }
        });

        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve specific id
                ref.child("2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String childvalue = String.valueOf(dataSnapshot.getValue());
                        dataFromDb.setText(childvalue);
                        Toast.makeText(MainActivity.this, "Data displayed succesfully !", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                auth.signOut();
            }
        });

    }
}
