package com.theorystrat.DataModels;


import java.util.List;
import java.util.Map;

public class Match {

    // Fields mapped to data from firebase
    private int matchNumber;
    private int teamNumber;
    private String alliance;
    private String scoutName;
    private int initiationLine;
    private List<Map<String, Object>> autoTasks;
    private List<Map<String, Object>> teleTasks;
    private Map<String, Integer> endgameTasks;
    private String startingPosition;
    private String comments;

    // Fields processed for display


    // Required no argument instructor
    public Match() {
        initialize();
    }

    public Match(int matchNumber, int teamNumber, String alliance, String scoutName, int initiationLine, List<Map<String, Object>> autoTasks, List<Map<String, Object>> teleTasks, Map<String, Integer> endgameTasks, String startingPosition, String comments) {
        this.matchNumber = matchNumber;
        this.teamNumber = teamNumber;
        this.alliance = alliance;
        this.scoutName = scoutName;
        this.initiationLine = initiationLine;
        this.autoTasks = autoTasks;
        this.teleTasks = teleTasks;
        this.endgameTasks = endgameTasks;
        this.startingPosition = startingPosition;
        this.comments = comments;
    }


    public int getMatchNumber() {
        return matchNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public String getAlliance() {
        return alliance;
    }

    public String getScoutName() {
        return scoutName;
    }

    public int getInitiationLine() {
        return initiationLine;
    }

    public List<Map<String, Object>> getAutoTasks() {
        return autoTasks;
    }

    public List<Map<String, Object>> getTeleTasks() {
        return teleTasks;
    }

    public Map<String, Integer> getEndgameTasks() {
        return endgameTasks;
    }

    public String getStartingPosition() {
        return startingPosition;
    }

    public String getComments() {
        return comments;
    }


    private void initialize() {

    }
}
