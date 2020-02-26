package com.theorystrat.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.theorystrat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamMatchesFragment extends Fragment {


    public TeamMatchesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_matches, container, false);
    }

}
