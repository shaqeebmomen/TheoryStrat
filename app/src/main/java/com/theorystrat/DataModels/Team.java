package com.theorystrat.DataModels;

/*



 */

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Team implements Comparable<Team> {

    // Data for ViewHolder
    private String teamNum;
    //    private String teamCity;
//    private String teamName;
    private int dataCount;
    private ArrayList<Match> matches;

    /* AUTO DATA */
//    private String startingPos;

//    // High
//    private int autoInnerBalls;
//    private int autoOuterBalls;
//    private int autoMissedHBalls;
//    private double autoAvgHBalls;
//
//    // Low
//    private int autoLowBalls;
//    private int autoMissedLBalls;
//    private double autoAvgLBalls;
//
//    // Mobility
//    private int mobSuccesses;
//    private int mobAttempts;
//
//    // Ball Picked Up
//    private int autoTrenchPickup;
//    private int autoRendezPickup;
//    private int autoRegurgePickup;
//
//    // Shot Locations
//    private int autoTrenchBalls;
//    private int autoRendezBalls;
//    private int autoTargetZBalls;
//    private int autoMidBalls;
//
//    /* TELEOP DATA */
//
//    // High
//    private double teleAvgHigh;
//    private double teleAccHigh;
//
//    // Low
//    private double teleAvgLow;
//    private double teleAccLow;
//
//    // Shot Locations
//    private int teleTrenchBalls;
//    private int teleTargetZBalls;
//    private int teleMidBalls;
//
//    // Control Panel
//    private double rotationTime;
//    private int rotationSuccesses;
//    private int rotationFails;
//
//    private double positionTime;
//    private int positionSuccesses;
//    private int positionFails;
//
//    // Shot to shot avg cycle time
//    private double cycleTime;
//
//    // Intaking
//    private double feederPickupRate;
//    private double sectorPickupRate;
//    private double midPickupRate;
//
//    /* ENDGAME */
//
//    // Climb
//    private int climbSuccesses;
//    private int climbFails;
//    private int nearClimbAttempts;
//    private int centerClimbAttempts;
//    private int farClimbAttempts;
//    private int levelSuccesses;
//    private int levelFails;
//    private double climbTime;
//    private int carries;
//    private int parks;


    public Team(String teamNum) {
        this.teamNum = teamNum;
        this.matches = new ArrayList<>();

    }


    // Getters

    public String getTeamNum() {
        return teamNum;
    }

    public int getDataCount() {
        return dataCount;
    }
    // Setters

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public void addMatch(Match match) {
        this.matches.add(match);
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }
    // Object method overrides

    @Override
    public int compareTo(Team o) {
        return Integer.valueOf(this.teamNum).compareTo(Integer.valueOf(o.teamNum));
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        // Get an array of the fields in the object passed and in this current object
        Field[] compareFields = obj.getClass().getFields();
        Field[] fields = this.getClass().getFields();
        // Compare them all and return false if any one of the fields doesn't match
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] != compareFields[i]) {
                return false;
            }
        }
        return true;
    }
}





