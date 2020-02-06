package com.theorystrat.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.theorystrat.R;
import com.theorystrat.ViewModels.TournyDataViewModel;


public class WelcomePage extends Fragment {

    NavController navController = null;
    TournyDataViewModel tournyDataViewModel;
    Button next;

    private static final String TAG = "WelcomePage";


    public WelcomePage() {
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

        return inflater.inflate(R.layout.fragment_welcome_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tournyDataViewModel = ViewModelProviders.of(requireActivity()).get(TournyDataViewModel.class);

        tournyDataViewModel.selected.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.d(TAG, "onChanged: ");
                if (aBoolean){
                    Log.d(TAG, "onChanged: changing to new view");
                    navController.navigate(R.id.action_welcomePage_to_matchCardSelector);
                }
            }
        });

        navController = Navigation.findNavController(view);
        next = (Button)view.findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                navController.navigate(R.id.action_welcomePage_to_matchCardSelector);
                tournyDataViewModel.selected.setValue(true);
                Log.d(TAG, "onClick: logged and set to true");
            }
        });


    }
}
