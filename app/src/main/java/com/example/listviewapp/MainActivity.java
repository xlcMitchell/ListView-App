package com.example.listviewapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //--- VARIABLES ---

        ListView destinationList;
        List<TouristDestination> data = new ArrayList<>();
        Button recyclerBtn = findViewById(R.id.btn);
        createDataList(data);
        destinationList = findViewById(R.id.myListView); //may need updating??
        TouristDestinationAdapter adapter = new TouristDestinationAdapter(getApplicationContext(),data); //new Adapter object with our destination data
        destinationList.setAdapter(adapter); //adapter set to the list view

        //event listener for the destinations in the list view
        destinationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), TouristDestinationDetailsActivity.class);
                intent.putExtra(getResources().getString(R.string.tourist_destination_object), data.get(i));
                startActivity(intent); //start new activity -- go to selected destination
            }
        });

        recyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starting the RecyclerViewActivity
                Intent intent = new Intent(getApplicationContext(),RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }
    //Method below creates the list of all of the tourist destinations
    //to be displayed on the activity_main
    private void createDataList(List<TouristDestination> data){
        //retrieve destinations and store as arrays
        TypedArray imageResources = getResources().obtainTypedArray(R.array.images);
        String [] imageTitles = getResources().getStringArray(R.array.titles);
        String [] descriptions = getResources().getStringArray(R.array.descriptions);
        //for loop to create a new TouristDestination object for each destination
        //and add it to the List
        for(int i = 0; i < imageTitles.length; i++){
            TouristDestination item = new TouristDestination(imageResources.getResourceId(i, -1),
                    imageTitles[i],
                    descriptions[i]);
            data.add(item);
        }
    }
}