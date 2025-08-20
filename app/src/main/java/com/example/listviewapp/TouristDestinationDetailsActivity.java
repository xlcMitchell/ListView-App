package com.example.listviewapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TouristDestinationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tourist_destination_details);
        TouristDestination destination;
        destination = (TouristDestination) getIntent().getSerializableExtra(getResources().getString(R.string.tourist_destination_object));
        ImageView imageView = findViewById(R.id.destinationDetailsImage);
        TextView title = findViewById(R.id.destinationTitleText);
        TextView description = findViewById(R.id.destinationDescriptionText);

        imageView.setImageResource(destination.getImageSource());
        title.setText(destination.getTitle());
        description.setText(destination.getDescription());

      }
    }
