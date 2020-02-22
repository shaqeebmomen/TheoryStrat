package com.theorystrat.ViewModels;

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


    private Repository repo;


    public TournyViewModel() {
        repo = Repository.getInstance();

    }


    public LiveData<Tourny> getTourny() {
        return repo.getTourny();
    }


    public LiveData<ArrayList<String>> getEventList() {
        return repo.getEventList();
    }

    public void setSelectedEvent(String s) {
        repo.setSelectedEvent(s);
    }

}
