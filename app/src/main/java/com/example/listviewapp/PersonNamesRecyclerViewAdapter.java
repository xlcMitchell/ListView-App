package com.example.listviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonNamesRecyclerViewAdapter extends RecyclerView.Adapter<PersonNameViewHolder> {

    List<Person> data;

    public PersonNamesRecyclerViewAdapter(List<Person> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PersonNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_recycler_view_list_item, parent, false);
        return new PersonNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonNameViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());

        if (data.get(position).isGender()) { // true means girl
            holder.image.setImageResource(R.drawable.girl);
        } else {
            holder.image.setImageResource(R.drawable.boy);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List <Person> newData){
          this.data = newData;
          notifyDataSetChanged();
    }

}