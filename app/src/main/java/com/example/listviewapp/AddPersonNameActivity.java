package com.example.listviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddPersonNameActivity extends AppCompatActivity {
    boolean gender = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_person_name);

        EditText nameEt = findViewById(R.id.addPersonNameET);
        RadioButton girlRadioButton = findViewById(R.id.girlRadioButton);

        girlRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                setGender(view);

            }

        });

        RadioButton boyRadioButton = findViewById(R.id.boyRadioButton);

        boyRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                setGender(view);

            }

        });

        Button button = findViewById(R.id.addNameButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();

                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"You need to enter a name",Toast.LENGTH_LONG)
                            .show();
                }else{
                    Person person = new Person(name,gender);
                    Intent intent = new Intent();
                    intent.putExtra("PERSON_OBJECT",person);
                    setResult(RESULT_OK,intent);
                    finish(); //terminates this activity

                }
            }
        });

    }

    private void setGender(View view){
        if(view.getId() == R.id.girlRadioButton)
            gender = true;
        else if (view.getId() == R.id.boyRadioButton)
            gender = false;
    }
}