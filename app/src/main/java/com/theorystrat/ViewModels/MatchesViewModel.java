package com.theorystrat.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.theorystrat.DataModels.Match;
import com.theorystrat.Repository;

import java.util.ArrayList;

public class MatchesViewModel extends ViewModel {
    private static final String TAG = "MatchesViewModel";

    private LiveData<ArrayList<Match>> matches;
    private MutableLiveData<ArrayList<Match>> selectedTeamMatches;
    private Repository repo;
    private String selectedTeam;


    public MatchesViewModel() {
        this.repo = Repository.getInstance();
        this.matches = repo.getMatches();

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

    public void setSelectedTeam(final String selectedTeam) {
        this.selectedTeam = selectedTeam;
//        ArrayList<Match> update = matches.getValue();
//        update.removeIf(match -> String.valueOf(match.getTeamNumber()) != selectedTeam);
//        selectedTeamMatches.setValue(update);
    }
}
