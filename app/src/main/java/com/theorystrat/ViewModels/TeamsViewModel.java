package com.theorystrat.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.theorystrat.DataModels.Team;
import com.theorystrat.Repository;

import java.util.ArrayList;


public class TeamsViewModel extends ViewModel {
    private static final String TAG = "TeamsViewModel";
    private Repository repo;

    public TeamsViewModel() {
        repo = Repository.getInstance();
        repo.refreshTeamList();

    }

    // Void Methods


    // Setters


    // Getters

    // Bubble up team list to UI
    public LiveData<ArrayList<Team>> getTeams() {
        return repo.getTeams();
    }


}
