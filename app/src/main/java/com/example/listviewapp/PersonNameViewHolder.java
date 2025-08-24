package com.example.listviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonNameViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView name;

    public PersonNameViewHolder(@NonNull View itemView){
         super(itemView);
         image = itemView.findViewById(R.id.personCardImage);
         name = itemView.findViewById(R.id.personCardName);
    }


}
