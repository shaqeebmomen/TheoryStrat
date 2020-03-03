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
        INNER_SCORED_AUTO,
        OUTER_SCORED_AUTO,
        BALLS_MISSED_AUTO,
        AVG_HIGH_AUTO,
        LOW_SCORED_AUTO,
        LOW_MISSED_AUTO,
        AVG_LOW_AUTO,
        MOBILITY_SUCCESS,
        MOBILITY_ATTEMPTS,
        INTAKE_TRENCH_AUTO,
        INTAKE_RENDEZVOUS_AUTO,
        FED_AUTO,
        SHOTS_TRENCH_AUTO,
        SHOTS_RENDEZVOUS_AUTO,
        SHOTS_TARGET_AUTO,
        SHOTS_INITIATION_AUTO,
        // TELE
        AVG_HIGH_TELE,
        ACC_HIGH_TELE,
        ACC_LOW_TELE,
        AVG_LOW_TELE,
        TRENCH_BALLS_TELE,
        TRENCH_ACC_TELE,
        TARGET_BALLS_TELE,
        TARGET_ACC_TELE,
        RENDEZVOUS_BALLS_TELE,
        RENDEZVOUS_ACC_TELE,
        CONTROL_PANEL_INTERACTIONS,
        TIMES_DEFENDING,
        TIME_DEFENDING,
        TIMES_DEFENDED,
        // ENDGAME
        BUDDIES,
        LEVEL_SUCCESSES,
        LEVEL_ATTEMPTS,
        CARRIES,
        PARK_SUCCESSES,
        PARK_ATTEMPTS,
        NEAR_CLIMB_SUCCESSES,
        NEAR_CLIMB_ATTEMPTS,
        CENTER_CLIMB_SUCCESSES,
        CENTER_CLIMB_ATTEMPTS,
        FAR_CLIMB_SUCCESES,
        FAR_CLIMB_ATTEMPTS
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
            teamData.put(TeamDataKeys.AVG_HIGH_AUTO, teamData.get(TeamDataKeys.AVG_HIGH_AUTO) + data.get(Match.DataKeys.TOTAL_HIGH_AUTO));
            teamData.put(TeamDataKeys.LOW_SCORED_AUTO, teamData.get(TeamDataKeys.LOW_SCORED_AUTO) + data.get(Match.DataKeys.BALLS_SCORED_LOW_TARGET_AUTO));
            teamData.put(TeamDataKeys.LOW_MISSED_AUTO, teamData.get(TeamDataKeys.LOW_MISSED_AUTO) + data.get(Match.DataKeys.BALLS_MISSED_LOW_TARGET_AUTO));
            teamData.put(TeamDataKeys.LOW_SCORED_AUTO, teamData.get(TeamDataKeys.AVG_LOW_AUTO) + data.get(Match.DataKeys.BALLS_SCORED_LOW_TARGET_AUTO));
        }

        // Divide out averages
        teamData.put(TeamDataKeys.AVG_HIGH_AUTO, teamData.get(TeamDataKeys.AVG_HIGH_AUTO) / getDataCount());

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





