package com.example.listviewapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TouristDestinationAdapter extends BaseAdapter {
    List<TouristDestination> data;
    Context context;

    public TouristDestinationAdapter(Context context, List<TouristDestination> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    class Elements{
        ImageView image;
        TextView title;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Elements elements = null;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_destination_list_item,null);
        }

        elements = new Elements();
        elements.image = view.findViewById(R.id.destinationCardImage);
        elements.title = view.findViewById(R.id.destinationCardTitle);
        TouristDestination destination = data.get(position);
        elements.image.setImageResource(destination.getImageSource());
        elements.title.setText(destination.getTitle());
        return view;
    }
}
