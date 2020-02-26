package com.theorystrat.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.theorystrat.Adapters.TeamDisplaysAdapter;
import com.theorystrat.R;


public class TeamDisplayFragment extends Fragment {

    private ViewPager2 viewPager;
    private TeamDisplaysAdapter teamDisplaysAdapter;


    public TeamDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_display, container, false);
    }

}
