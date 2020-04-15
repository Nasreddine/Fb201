package com.example.fb201;

import Model.Order;
import RecyclerView.Trip;
import RecyclerView.Trip_Adapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DispatchActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTrips;
    private List<Trip> listTrips;
    private Trip_Adapter trip_adapter;
    private SearchView searchView;
    FirebaseDatabase database;
    DatabaseReference ref;
    long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);

        recyclerViewTrips = findViewById(R.id.recyler_layout);
        recyclerViewTrips.setHasFixedSize(true);
        searchView = findViewById(R.id.search_view);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Trip");
/*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxid = dataSnapshot.getChildrenCount()+1;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
/*
        aListTrip = new ArrayList<>();

        aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Alger", "30/01/2020 22:00", "30/01/2020 23:55", 16));
        aListTrip.add(new Trip("Paris", "Marseille", "31/01/2020 05:00", "31/01/2020 15:00", 35.75));
        aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Montreal", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Munich", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Casablana", "30/01/2020 22:00", "30/01/2020 23:55", 16));
        aListTrip.add(new Trip("Paris", "Marseille", "31/01/2020 05:00", "31/01/2020 15:00", 35.75));
        aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Yaounde", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Londre", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Stockholm", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Tunis", "30/01/2020 22:00", "30/01/2020 23:55", 16));
        aListTrip.add(new Trip("Paris", "Marseille", "31/01/2020 05:00", "31/01/2020 15:00", 35.75));
        aListTrip.add(new Trip("Tours", "Guadalajara", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Paris", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
        aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));

        Trip_Adapter trip_adapter = new Trip_Adapter(aListTrip);

        aRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        aRecyclerView.setAdapter(trip_adapter);
        */
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(ref != null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        //int testct = 0;
                        maxid = dataSnapshot.getChildrenCount()+1;
                        listTrips = new ArrayList<Trip>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()){
                            //new Trip("Tours"+ds.getValue(), "Paris"+testct, "30/01/2020 16:00", "30/01
                            //o = ds.getValue(Trip.class);
                            listTrips.add(ds.getValue(Trip.class));
                            //testct++;
                        }
                        trip_adapter = new Trip_Adapter(listTrips);
                        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerViewTrips.setAdapter(trip_adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(DispatchActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            Toast.makeText(DispatchActivity.this, "No Data Available !", Toast.LENGTH_LONG).show();
            /*
            List<Trip> trips = new ArrayList<>();

            trips.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            trips.add(new Trip("Paris", "Alger", "30/01/2020 22:00", "30/01/2020 23:55", 16));
            trips.add(new Trip("Paris", "Marseille", "31/01/2020 05:00", "31/01/2020 15:00", 35.75));
            trips.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            trips.add(new Trip("Paris", "Montreal", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Munich", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Casablana", "30/01/2020 22:00", "30/01/2020 23:55", 16));
            aListTrip.add(new Trip("Paris", "Marseille", "31/01/2020 05:00", "31/01/2020 15:00", 35.75));
            aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Yaounde", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Londre", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Stockholm", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Tunis", "30/01/2020 22:00", "30/01/2020 23:55", 16));
            aListTrip.add(new Trip("Paris", "Marseille", "31/01/2020 05:00", "31/01/2020 15:00", 35.75));
            aListTrip.add(new Trip("Tours", "Guadalajara", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Paris", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
            aListTrip.add(new Trip("Tours", "Paris", "30/01/2020 16:00", "30/01/2020 21:00", 15.5));
*/
        }
        if(searchView !=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
    }

    private void search(String str){
        ArrayList<Trip> trips_result = new ArrayList<>();
        for (Trip trip : listTrips){
            if (trip.getEnd().contains(str)){
                trips_result.add(trip);
            }
        }
        trip_adapter = new Trip_Adapter(trips_result);
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewTrips.setAdapter(trip_adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
