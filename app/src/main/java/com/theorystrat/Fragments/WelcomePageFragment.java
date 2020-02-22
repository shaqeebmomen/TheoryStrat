package com.theorystrat.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import com.theorystrat.Adapters.TournyListAdapter;
import com.theorystrat.R;
import com.theorystrat.ViewModels.TournyViewModel;

import java.util.ArrayList;


public class WelcomePageFragment extends Fragment implements TournyListAdapter.OnTournyListener {

    private Button next; //Temp
    private RecyclerView recyclerView;
    private TournyListAdapter tournyListAdapter;
    private TournyViewModel tournyViewModel;
    private NavController navController;


    private static final String TAG = "WelcomePageFragment";


    public WelcomePageFragment() {
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

        // ViewModel
        tournyViewModel = new ViewModelProvider(requireActivity()).get(TournyViewModel.class);
        tournyViewModel.getEventList().observe(this.getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                tournyListAdapter.setEvents(strings);
                tournyListAdapter.notifyDataSetChanged();
                Log.d(TAG, "onChanged: EVENT LIST CHANGED");
            }
        });


        // Recycler View
        recyclerView = view.findViewById(R.id.tourny_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tournyListAdapter = new TournyListAdapter(this);
        recyclerView.setAdapter(tournyListAdapter);

        // Navigation
        navController = Navigation.findNavController(view);
        next = view.findViewById(R.id.button);
        next.setEnabled(false);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                // Tell ViewModel to update the list of team
//                tournyViewModel.refreshTeamList();


                // Navigate to main nav
                navController.navigate(R.id.action_welcomePage_to_mainNav);
                getActivity().findViewById(R.id.nav_view).setVisibility(View.VISIBLE);


            }
        });


    }

    @Override
    public void onTournyClick(int pos, View v) {
        // Set the selected event
        TextView eventTextView = v.findViewById(R.id.tourny_item_text);
        String event = eventTextView.getText().toString();
        Log.d(TAG, "onTournyClick: Clicked item " + event);
        tournyViewModel.setSelectedEvent(event);

        // VisuallyHighlight the selected event
        tournyListAdapter.setSelectedPos(pos);
        tournyListAdapter.notifyDataSetChanged();

        // Enable button
        next.setEnabled(true);


    }
}
