package com.theorystrat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.theorystrat.R;
import com.theorystrat.ViewModels.MatchesViewModel;

public class MatchesFragment extends Fragment {

    private MatchesViewModel matchesViewModel;


    private static final String TAG = "MatchesFragment";
    public MatchesFragment() {
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
        return inflater.inflate(R.layout.fragment_matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.test);

        matchesViewModel = new ViewModelProvider(requireActivity()).get(MatchesViewModel.class);

        tv.setText(matchesViewModel.getSelectedTeam());
    }
}


// Setters

