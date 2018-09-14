package com.example.android.tourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

class DataAdapter extends ArrayAdapter<Data> {

    DataAdapter(Context context, ArrayList<Data> dData) {
        super(context, 0, dData);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_data, parent, false);
        }

        Data currentPlace = getItem(position);

        // Find the TextView with view ID name
        TextView name = (TextView) listView.findViewById(R.id.item_name);
        assert currentPlace != null;
        name.setText(currentPlace.getName());

        // Find the TextView with view ID description
        TextView description = (TextView) listView.findViewById(R.id.item_description);
        description.setText(currentPlace.getmDescription());

        ImageView imageView = (ImageView) listView.findViewById(R.id.item_image);
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        return listView;


    }
}
