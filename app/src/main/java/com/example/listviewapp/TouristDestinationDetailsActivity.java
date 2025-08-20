package com.example.listviewapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TouristDestinationDetailsActivity extends AppCompatActivity {
    private static final String TAG = "Details Lifecycle";
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
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity is now visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity has focus and is ready for user interaction");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Another activity is taking focus (this one is partially obscured)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity is no longer visible");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: Activity is restarting after being stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity is being destroyed and removed from memory");
    }
    }
