package com.example.android.tourapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class EatFragment extends Fragment {

    public EatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Data> data = new ArrayList<Data>();
        data.add(new Data(getString(R.string.eat_title1), getString(R.string.eat_descr1), R.drawable.eat_1));
        data.add(new Data(getString(R.string.eat_title2), getString(R.string.eat_descr2), R.drawable.eat_2));
        data.add(new Data(getString(R.string.eat_title3), getString(R.string.eat_descr3), R.drawable.eat_3));
        data.add(new Data(getString(R.string.eat_title4), getString(R.string.eat_descr4), R.drawable.eat_4));

        final DataAdapter adapter = new DataAdapter(getActivity(), data);

        // Find a reference to the {@link ListView} in the layout
        final ListView dataListView = (ListView) rootView.findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        dataListView.setAdapter(adapter);

        return rootView;
    }
}