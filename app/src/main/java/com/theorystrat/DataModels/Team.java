package com.theorystrat.DataModels;

/*

 */

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Team implements Comparable<Team> {

    // Data for ViewHolder
    private String teamNum;
    //    private String teamCity;
//    private String teamName;
    private ArrayList<Match> matches;

    // Using doubles as an umbrella for all data values
    public enum TeamDataKeys {
        // AUTO
        //TODO HOW DO I GET THESE TWO?

        // TELE

        // ENDGAME

    }

    private HashMap<TeamDataKeys, Double> teamData;


    public Team(String teamNum) {
        this.teamNum = teamNum;
        this.matches = new ArrayList<>();
        this.teamData = new HashMap<>();
        // Set data values as non-null to allow incrementing
        for (TeamDataKeys key :
                TeamDataKeys.values()) {
            teamData.put(key, 0.0);
        }
    }

    public void updateTeam() {
        // Sum/update data for each data point
        for (Match match :
                matches) {
            HashMap<Match.DataKeys, Long> data = match.getMatchData();

        }


    }

    // Getters

    public String getTeamNum() {
        return teamNum;
    }

    public int getDataCount() {
        return matches.size();
    }

    public HashMap<TeamDataKeys, Double> getTeamData() {
        return teamData;
    }

    // Setters

    public void addMatch(Match match) {
        this.matches.add(match);
        updateTeam();
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
        updateTeam();
    }

    // Object method overrides
    @Override
    public int compareTo(Team o) {
        return Integer.valueOf(this.teamNum).compareTo(Integer.valueOf(o.teamNum));
    }

    public boolean equals(@Nullable Team team) {
        // Get an array of the fields in the object passed and in this current object
        Field[] compareFields = Team.class.getFields();
        Field[] fields = Team.class.getFields();
        // Compare them all and return false if any one of the fields doesn't match
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] != compareFields[i]) {
                return false;
            }
        }
        return true;
    }
}





