package com.theorystrat.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theorystrat.Adapters.TeamListAdapter;
import com.theorystrat.DataModels.Team;
import com.theorystrat.R;
import com.theorystrat.ViewModels.TeamsViewModel;

import java.util.ArrayList;


public class TeamsFragment extends Fragment implements TeamListAdapter.OnTeamListener {
    private static final String TAG = "TeamsFragment";

    // ViewModel
    private TeamsViewModel teamsViewModel;

    // UI
    private RecyclerView recyclerView;
    private TeamListAdapter teamListAdapter;


    public TeamsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ViewModel
        teamsViewModel = new ViewModelProvider(requireActivity()).get(TeamsViewModel.class);

        teamsViewModel.getTeams().observe(this.getViewLifecycleOwner(), new Observer<ArrayList<Team>>() {
            @Override
            public void onChanged(ArrayList<Team> teams) {
                Log.d(TAG, "teamsList changed");
                teamListAdapter.setTeams(teams);
                Log.d(TAG, "adapter count: " + teamListAdapter.getItemCount());
            }
        });

        // Recycler View
        // Link the view
        recyclerView = view.findViewById(R.id.teams_list_view);
        // Attach a layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Create the adapter
        teamListAdapter = new TeamListAdapter(this);
        // Attach the adapter to the Recycler View
        recyclerView.setAdapter(teamListAdapter);
        // Fill the adapter with the list of teams
        teamListAdapter.setTeams(teamsViewModel.getTeams().getValue());


    }

    @Override
    public void onTeamClick(int pos, View v) {
        TextView t = v.findViewById(R.id.team_list_item_num);
        Log.d(TAG, "onTeamClick: " + t.getText());
    }
}
