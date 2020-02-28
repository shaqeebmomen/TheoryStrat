package com.theorystrat.DataModels;


import java.util.HashMap;
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
    private Map<String, Long> endgameTasks;
    private String startingPosition;
    private String comments;

    public enum Actions {
        SHOOT_HIGH,
        SHOOT_LOW,
        INTAKE,
        PLAYED_DEFENSE,
        GOT_DEFENDED,
        CONTROL_PANEL,
        FED;

        public static Actions fromInt(int val) {
            switch (val) {
                case 0:
                    return SHOOT_HIGH;
                case 1:
                    return SHOOT_LOW;
                case 2:
                    return INTAKE;
                case 3:
                    return PLAYED_DEFENSE;
                case 4:
                    return GOT_DEFENDED;
                case 5:
                    return CONTROL_PANEL;
                case 6:
                    return FED;
            }
            return null;
        }

    }

    public enum Locations {
        TARGET_ZONE,
        INITIATION_LINE,
        RENDEZVOUS_ZONE,
        CLOSE_TRENCH,
        FAR_TRENCH,
        CONTROL_PANEL,
        LOADING_ZONE,
        OPPONENT_SECTOR,
        OPEN_FLOOR,
        OPPONENT_TRENCH;

        public static Locations fromInt(int val) {
            switch (val) {
                case 0:
                    return TARGET_ZONE;
                case 1:
                    return INITIATION_LINE;
                case 2:
                    return RENDEZVOUS_ZONE;
                case 3:
                    return CLOSE_TRENCH;
                case 4:
                    return FAR_TRENCH;
                case 5:
                    return CONTROL_PANEL;
                case 6:
                    return LOADING_ZONE;
                case 7:
                    return OPPONENT_SECTOR;
                case 8:
                    return OPEN_FLOOR;
                case 9:
                    return OPPONENT_TRENCH;
            }
            return null;
        }
    }

    public enum ClimbTypes {
        NO_ATTEMPT,
        FAR,
        CENTER,
        NEAR,
        PARK;

        public static ClimbTypes fromInt(int val) {
            switch (val) {
                case 0:
                    return NO_ATTEMPT;
                case 1:
                    return FAR;
                case 2:
                    return CENTER;
                case 3:
                    return NEAR;
                case 4:
                    return PARK;
            }
            return null;
        }
    }

    // Fields processed for display
    private HashMap<String, Long> data = new HashMap<>();

    // Required no argument instructor
    public Match() {
        initialize();
    }

    public Match(int matchNumber, int teamNumber, String alliance, String scoutName, int initiationLine, List<Map<String, Object>> autoTasks, List<Map<String, Object>> teleTasks, Map<String, Long> endgameTasks, String startingPosition, String comments) {
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

    public Map<String, Long> getEndgameTasks() {
        return endgameTasks;
    }

    public String getStartingPosition() {
        return startingPosition;
    }

    public String getComments() {
        return comments;
    }


    private void initialize() {
        for (Map<String, Object> autoTask :
                autoTasks) {
            int action = (int) autoTask.get("action");
            int location = (int) autoTask.get("location");
            int time = (int) autoTask.get("time");
            Object data = autoTask.get("data");

            switch (Actions.fromInt(action)) {
                case INTAKE:
                    switch (Locations.fromInt(location)) {
                        case RENDEZVOUS_ZONE:
                            break;
                        case FAR_TRENCH:
                            break;
                        case CLOSE_TRENCH:
                            break;

                    }
            }


        }
    }
}
