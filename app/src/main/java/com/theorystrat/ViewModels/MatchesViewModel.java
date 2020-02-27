package com.theorystrat.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.theorystrat.DataModels.Match;
import com.theorystrat.Repository;

import java.util.ArrayList;

public class MatchesViewModel extends ViewModel {
    private static final String TAG = "MatchesViewModel";

    private LiveData<ArrayList<Match>> matches;
    private LiveData<ArrayList<Match>> selectedTeamMatches;
    private Repository repo;
    private String selectedTeam;


    public MatchesViewModel() {
        this.repo = Repository.getInstance();
    }


    public LiveData<ArrayList<Match>> getMatches() {
        return matches;
    }

    public LiveData<ArrayList<Match>> getSelectedTeamMatches() {
        return selectedTeamMatches;
    }

    public String getSelectedTeam() {
        return selectedTeam;
    }

    public void setSelectedTeam(String selectedTeam) {
        this.selectedTeam = selectedTeam;
    }
}
