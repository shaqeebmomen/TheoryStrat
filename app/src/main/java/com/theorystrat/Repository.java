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
import com.theorystrat.DataModels.Match;
import com.theorystrat.DataModels.Roster;
import com.theorystrat.DataModels.Team;
import com.theorystrat.DataModels.Tourny;

import java.util.ArrayList;
import java.util.Collections;


//TODO add retrofit to call TBA apiV3 and get team info
public class Repository {
    private static final String TAG = "Repository";

    private static Repository mInstance;
    private MutableLiveData<Tourny> tournyLiveData;
    private MutableLiveData<ArrayList<String>> events;
    private MutableLiveData<ArrayList<Match>> matches;
    private Roster roster;
    private String selectedEvent;
    private DataSnapshot latestSnap; //Top Level Reference

    public static Repository getInstance() {
        if (mInstance == null) {
            mInstance = new Repository();
        }
        return mInstance;
    }

    private Repository() {
        this.tournyLiveData = new MutableLiveData<>();
        this.events = new MutableLiveData<>();
        this.roster = new Roster();
        this.matches = new MutableLiveData<>();

//        // Enable Local Persistence
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference firebaseDB = FirebaseDatabase.getInstance().getReference();

        // Add Listener
        //TODO get this data only once and make a new listener for tournament child
        // TODO deal with a cleared comp
        firebaseDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> mEventList = new ArrayList<>();
                // Refresh the list of events
                try {
                    // Clear the event list then refill it with the event list
                    mEventList.clear();
                    for (DataSnapshot child :
                            dataSnapshot.getChildren()) {
                        mEventList.add(child.getKey());
                        Log.d(TAG, "onDataChange: " + child.getKey());
                    }
                    events.postValue(mEventList);
                    latestSnap = dataSnapshot;
                    refreshData();
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

    // Getters

    public LiveData<ArrayList<String>> getEvents() {
        return events;
    }

    // Letting the ArrayList of our Team objects bubble up
    public LiveData<ArrayList<Team>> getTeams() {

        return roster.getTeamList();
    }

    public LiveData<Tourny> getTourny() {
        return tournyLiveData;
    }

    public LiveData<ArrayList<Match>> getMatches() {
        return matches;
    }

    // Setters

    //TODO do we need to figure out the schedule for this all to work? or dont make a tourny obj and just hold a list of comp keys

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

    public void setMatches(ArrayList<Match> matches) {
        this.matches.setValue(matches);
    }

    // TODO put this method into a listener, specific to the competition

    // This method is used when it is required to update and refresh the WHOLE list of teams AND their stats
    public void refreshData() {
        // If there is an event selected
        if (selectedEvent != null) {
            // For every direct child within the currently held snapshot
            ArrayList<Team> teamsUpdate = new ArrayList<>();
            ArrayList<Match> matchesUpdate = new ArrayList<>();
            for (DataSnapshot teamSnap : latestSnap.child(selectedEvent).getChildren()
            ) {
                // Create a new team instance an populate its data
                Team newTeam = new Team(teamSnap.getKey());
                // Populate stats
                for (DataSnapshot matchSnap :
                        teamSnap.getChildren()) {
                    // Use firebase to serialize the JSON on the cloud to a local class instance
                    Match newMatch = matchSnap.getValue(Match.class);
                    // Process data loaded
                    newMatch.initialize();
                    // Add match data to newTeam
                    newTeam.addMatch(newMatch);
                    // Add match to the full list
                    matchesUpdate.add(newMatch);
                }
                // Add it to the holder of the output
                teamsUpdate.add(newTeam);
            }
            // Push the new list at once;
            Collections.sort(teamsUpdate);
            roster.setTeamList(teamsUpdate);
            matches.setValue(matchesUpdate);
        }
        // No event selected, display an error message
        else {
            Log.d(TAG, "refreshData: NO EVENT SELECTED");
        }
        Log.d(TAG, "refreshData: Finished");

    }






}
