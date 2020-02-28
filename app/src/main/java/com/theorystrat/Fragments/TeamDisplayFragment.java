package com.theorystrat.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.theorystrat.Adapters.TeamDisplayAdapter;
import com.theorystrat.R;
import com.theorystrat.ViewModels.MatchesViewModel;


public class TeamDisplayFragment extends Fragment {

    private ViewPager2 viewPager;
    private TeamDisplayAdapter teamDisplaysAdapter;
    private MatchesViewModel matchesViewModel;
    private static final String TAG = "TeamDisplayFragment";

    public TeamDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_display, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        // View Model
        matchesViewModel = new ViewModelProvider(requireActivity()).get(MatchesViewModel.class);


        teamDisplaysAdapter = new TeamDisplayAdapter(this, matchesViewModel);
        viewPager = view.findViewById(R.id.team_display_pager);
        viewPager.setAdapter(teamDisplaysAdapter);
        TabLayout tabLayout = view.findViewById(R.id.team_display_tabs);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("TeamSummary");
                        break;
                    case 1:

                        tab.setText("Matches");
                        break;
                }
            }
        }).attach();
    }


    private void setSelectedTeam(String teamNum) {
        matchesViewModel.setSelectedTeam(teamNum);
    }


}
