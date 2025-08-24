package com.example.listviewapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    List<Person> data;
    PersonNamesRecyclerViewAdapter adapter;

    //----- ACTIVITY RESULT LAUNCHER ----//
    /*
    You've created an object of ActivityResultLauncher<Intent>
    The registerForActivityResult() method helps to create this object and define the
    call-back method executed when a result is returned to RecyclerViewActivity.
     */

    ActivityResultLauncher<Intent> getNewPersonName = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){ //call back method

                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intentData = result.getData();
                        assert intentData != null;
                        Person person = (Person) intentData.getSerializableExtra(
                                getResources().getString(R.string.person_object)
                        );

                        data.add(person);
                        adapter.updateData(data);

                    }
                }
            }

    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);

        generateDataList(); //create the array of baby Person class objects
        RecyclerView recyclerView = findViewById(R.id.personNamesRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonNamesRecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.addPersonNameButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddPersonNameActivity.class);
                getNewPersonName.launch(intent);
            }
        });


    }



    private void generateDataList(){
        data = new ArrayList<>();
        String [] personNames = getResources().getStringArray(R.array.baby_names); //retrieve baby names array from resources

        for(String nameString:personNames){
            String [] parts = nameString.split(","); //splitting string because it has name then gender
            Person person = new Person(parts[0],(parts[1].equals("girl"))); //create new person object for each baby name
            data.add(person);
        }
    }
}