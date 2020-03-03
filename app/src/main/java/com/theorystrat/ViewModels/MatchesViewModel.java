package com.theorystrat.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.theorystrat.DataModels.Match;
import com.theorystrat.Repository;

import java.util.ArrayList;

public class MatchesViewModel extends ViewModel {
    private static final String TAG = "MatchesViewModel";

    @Override
    protected void onCleared() {
        Log.d(TAG, "onCleared: Matches View Model Destroyed");
        super.onCleared();

    }

    private LiveData<ArrayList<Match>> matches;
    private MutableLiveData<ArrayList<Match>> selectedTeamMatches;
    private Repository repo;
    private String selectedTeam;


    public MatchesViewModel() {
        this.repo = Repository.getInstance();
        this.matches = repo.getMatches();
        this.selectedTeamMatches = new MutableLiveData<>();

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
        Log.d(TAG, "setSelectedTeam: Matches size: " + String.valueOf(matches.getValue().size()));
        ArrayList<Match> update = matches.getValue();
        Log.d(TAG, "setSelectedTeam: matches val: " + matches.getValue().toString());
        update.removeIf(match -> {
            return !(String.valueOf(match.getTeamNumber()).equals(selectedTeam));
        });
        selectedTeamMatches.setValue(update);
        Log.d(TAG, "setSelectedTeam: ");
    }
}
