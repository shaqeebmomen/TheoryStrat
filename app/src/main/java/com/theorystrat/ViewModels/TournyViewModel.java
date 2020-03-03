package com.theorystrat.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.theorystrat.DataModels.Tourny;
import com.theorystrat.Repository;

import java.util.ArrayList;

/*
This class is the view model that will contain the data about the chosen tournament and the list of events on firebase
 */

//TODO move the iterations through the firebase snapshots to here from the repository
public class TournyViewModel extends ViewModel {
    private static final String TAG = "TournyViewModel";

    private Repository repo;


    public TournyViewModel() {
        repo = Repository.getInstance();

    }

    @Override
    protected void onCleared() {
        Log.d(TAG, "onCleared: Tourny View Model Destroyed");
        super.onCleared();
    }

    public LiveData<Tourny> getTourny() {
        return repo.getTourny();
    }


    public LiveData<ArrayList<String>> getEventList() {
        return repo.getEvents();
    }

    public void setSelectedEvent(String s) {
        repo.setSelectedEvent(s);
    }

}
