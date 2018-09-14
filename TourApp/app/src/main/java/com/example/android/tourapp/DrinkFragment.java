package com.example.android.tourapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class DrinkFragment extends Fragment {

    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Data> data = new ArrayList<Data>();
        data.add(new Data(getString(R.string.drink_title1), getString(R.string.drink_descr1), R.drawable.drink_1));
        data.add(new Data(getString(R.string.drink_title2), getString(R.string.drink_descr2), R.drawable.drink_2));
        data.add(new Data(getString(R.string.drink_title3), getString(R.string.drink_descr3), R.drawable.drink_3));
        data.add(new Data(getString(R.string.drink_title4), getString(R.string.drink_descr4), R.drawable.drink_4));

        final DataAdapter adapter = new DataAdapter(getActivity(), data);

        // Find a reference to the {@link ListView} in the layout
        final ListView dataListView = (ListView) rootView.findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        dataListView.setAdapter(adapter);

        return rootView;
    }
}
