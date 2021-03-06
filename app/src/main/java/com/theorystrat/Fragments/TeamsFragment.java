package com.theorystrat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theorystrat.Adapters.TeamListAdapter;
import com.theorystrat.DataModels.Team;
import com.theorystrat.R;
import com.theorystrat.ViewModels.MatchesViewModel;
import com.theorystrat.ViewModels.TeamsViewModel;

import java.util.ArrayList;


public class TeamsFragment extends Fragment implements TeamListAdapter.OnTeamListener {
    private static final String TAG = "TeamsFragment";

    // ViewModel
    private TeamsViewModel teamsViewModel;
    private MatchesViewModel matchesViewModel;

    // UI
    private RecyclerView recyclerView;
    private TeamListAdapter teamListAdapter;

    // Navigation
    NavController navController;


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

        // Navigaton
        navController = Navigation.findNavController(view);

        // ViewModels
        teamsViewModel = new ViewModelProvider(requireActivity()).get(TeamsViewModel.class);

        teamsViewModel.getTeams().observe(this.getViewLifecycleOwner(), new Observer<ArrayList<Team>>() {
            @Override
            public void onChanged(ArrayList<Team> teams) {
                teamListAdapter.submitList(teams);
            }
        });

        matchesViewModel = new ViewModelProvider(requireActivity()).get(MatchesViewModel.class);

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
        teamListAdapter.submitList(teamsViewModel.getTeams().getValue());
    }

    // Overriding the onClick() method for the interface defined in the adapter
    @Override
    public void onClick(int pos, View v) {
        TextView teamNumTextView = v.findViewById(R.id.team_list_item_num);
        matchesViewModel.setSelectedTeam(teamNumTextView.getText().toString());
        navController.navigate(R.id.action_teams_to_teamDisplayFragment);
    }
}
