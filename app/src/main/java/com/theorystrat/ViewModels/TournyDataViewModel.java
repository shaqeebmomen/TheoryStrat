package com.theorystrat.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TournyDataViewModel extends ViewModel {


    public final MutableLiveData<Boolean> selected = new MutableLiveData<>();

    public TournyDataViewModel(){

        selected.setValue(false);
    }


}
