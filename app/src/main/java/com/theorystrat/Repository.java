package com.theorystrat;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theorystrat.DataModels.Roster;
import com.theorystrat.DataModels.Team;
import com.theorystrat.DataModels.Tourny;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


//TODO add retrofit to call TBA apiV3 and get team info
public class Repository {

    private static Repository mInstance;
    private MutableLiveData<Tourny> tournyLiveData;
    private MutableLiveData<ArrayList<String>> eventList;
    //    private ArrayList<String> teamNumList = new ArrayList<>(); // Holds a every team # we've made an object for easier tracking
//    private MutableLiveData<ArrayList<Team>> teamList = new MutableLiveData<>();
    private Roster roster = new Roster();
    private String selectedEvent;
    private DataSnapshot latestSnap; //Top Level Reference

    public static Repository getInstance() {
        if (mInstance == null) {
            mInstance = new Repository();
        }
        return mInstance;
    }

    private Repository() {
        tournyLiveData = new MutableLiveData<>();
        eventList = new MutableLiveData<>();
        roster = new Roster();

//        // Enable Local Persistence
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference firebaseDB = FirebaseDatabase.getInstance().getReference();

        // Add Listener
        //TODO get this data only once and make a new listener for tournament child
        firebaseDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> mEventList = new ArrayList<>();
                // If an event hasn't been selected, refresh the list of events
                try {
                    // Clear the event list then refill it with the event list
                    mEventList.clear();
                    for (DataSnapshot child :
                            dataSnapshot.getChildren()) {
                        mEventList.add(child.getKey());
                        Log.d(TAG, "onDataChange: " + child.getKey());
                    }
                    eventList.postValue(mEventList);
                    latestSnap = dataSnapshot;
                }
                //TODO make this more descriptive once more listeners are added
                catch (NullPointerException e) {
                    Log.e(TAG, "onDataChange:", e);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });


    }

    public LiveData<ArrayList<String>> getEventList() {
        return eventList;
    }


    //TODO do we need to figure out the schedule for this all to work?

    // Sets the event once its selected and takes care of creating the tourny object if necessary
    public void setSelectedEvent(String s) {
        selectedEvent = s;
        if (tournyLiveData.getValue() == null) { // tourny hasnt been set yet
            Tourny currentT = new Tourny(selectedEvent, null);
            tournyLiveData.setValue(currentT);
        } else { // The the tourny is already set
            Tourny currentT = tournyLiveData.getValue();
            currentT.setEventName(selectedEvent);
            tournyLiveData.setValue(currentT);
        }
    }

    // TODO put this method into a listener, specific to the competition

    // This method is used when it is required to update and refresh the WHOLE list of teams AND their stats
    public void refreshTeamList() {
        // If there is an event selected
        if (selectedEvent != null) {
            // For every direct child within the currently held snapshot
            for (DataSnapshot teamSnap : latestSnap.child(selectedEvent).getChildren()
            ) {
                // Get the key of the child (the team #)
                Log.d(TAG, "refreshTeamList: " + teamSnap.getKey());
                // If we've already made an object for this team, dont make another one (done by the roster class)
                if (!roster.contains(teamSnap.getKey())) {
                    // Create a new team instance an populate its data
                    Team newTeam = new Team(teamSnap.getKey());
                    // Populate stats
                    roster.addTeam(newTeam);
                }
            }
        }
        // No event selected, display an error message
        else {
            Log.d(TAG, "refreshTeamList: NO EVENT SELECTED");
        }
    }

    // Letting the ArrayList of our Team objects bubble up
    public LiveData<ArrayList<Team>> getTeams() {

        return roster.getTeamList();
    }

    public LiveData<Tourny> getTourny() {
        return tournyLiveData;
    }


}