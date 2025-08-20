package com.example.listviewapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        ListView destinationList;
        List<TouristDestination> data = new ArrayList<>();

        createDataList(data);
        destinationList = findViewById(R.id.myListView); //may need updating??
        TouristDestinationAdapter adapter = new TouristDestinationAdapter(getApplicationContext(),data);
        destinationList.setAdapter(adapter);

        destinationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), TouristDestinationDetailsActivity.class);
                intent.putExtra(getResources().getString(R.string.tourist_destination_object), data.get(i));
                startActivity(intent);
            }
        });
    }

    private void createDataList(List<TouristDestination> data){
        TypedArray imageResources = getResources().obtainTypedArray(R.array.images);
        String [] imageTitles = getResources().getStringArray(R.array.titles);
        String [] descriptions = getResources().getStringArray(R.array.descriptions);
        for(int i = 0; i < imageTitles.length; i++){
            TouristDestination item = new TouristDestination(imageResources.getResourceId(i, -1),
                    imageTitles[i],
                    descriptions[i]);
            data.add(item);
        }
    }
}