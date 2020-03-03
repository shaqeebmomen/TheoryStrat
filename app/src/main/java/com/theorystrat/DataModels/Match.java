package com.theorystrat.DataModels;


import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Match {

    private static final String TAG = "Match";

    // Fields mapped to data from firebase
    private Long matchNumber;
    private Long teamNumber;
    private String alliance;
    private String scoutName;
    private Long initiationLine;
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
        OPP_SECTOR,
        OPEN_FLOOR,
        OPP_TRENCH;

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
                    return OPP_SECTOR;
                case 8:
                    return OPEN_FLOOR;
                case 9:
                    return OPP_TRENCH;
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

        public static ClimbTypes fromDouble(double val) {
            return fromInt((int) val);
        }
    }

    public enum DataKeys {
        TOTAL_HIGH_AUTO,
        INTAKE_RENDEZVOUS_AUTO,
        INTAKE_FAR_TRENCH_AUTO,
        INTAKE_OPP_TRENCH_AUTO,
        BALLS_SCORED_RENDEZVOUS_AUTO,
        BALLS_SCORED_INITIATION_AUTO,
        BALLS_SCORED_CLOSE_TRENCH_AUTO,
        BALLS_SCORED_HIGH_TARGET_AUTO,
        BALLS_MISSED_RENDEZVOUS_AUTO,
        BALLS_MISSED_INITIATION_AUTO,
        BALLS_MISSED_CLOSE_TRENCH_AUTO,
        BALLS_MISSED_HIGH_TARGET_AUTO,
        BALLS_SCORED_LOW_TARGET_AUTO,
        BALLS_MISSED_LOW_TARGET_AUTO,
        FED_BALLS_AUTO,
        TIMES_DEFENDED_TELE,
        TIMES_DEFENDING_TELE,
        TIME_DEFENDING_TELE,
        CONTROL_PANEL_TELE,
        INTAKE_OPP_SECTOR_TELE,
        INTAKE_LOADING_TELE,
        INTAKE_OPEN_FLOOR_TELE,
        TOTAL_HIGH_TELE,
        BALLS_SCORED_CLOSE_TRENCH_TELE,
        BALLS_SCORED_FAR_TRENCH_TELE,
        BALLS_SCORED_OPEN_FLOOR_TELE,
        BALLS_SCORED_HIGH_TARGET_TELE,
        BALLS_MISSED_CLOSE_TRENCH_TELE,
        BALLS_MISSED_FAR_TRENCH_TELE,
        BALLS_MISSED_OPEN_FLOOR_TELE,
        BALLS_MISSED_HIGH_TARGET_TELE,
        BALLS_SCORED_LOW_TARGET_TELE,
        BALLS_MISSED_LOW_TARGET_TELE,
        BUDDIED,
        LEVELED,
        CARRIED,
        CLIMB_SUCCESS,
        CLIMB_TYPE
    }

    // Fields processed for display
    private HashMap<DataKeys, Long> matchData = new HashMap<>();


    // Required no argument instructor
    public Match() {

    }

    public Match(Long matchNumber, Long teamNumber, String alliance, String scoutName, Long initiationLine, List<Map<String, Object>> autoTasks, List<Map<String, Object>> teleTasks, Map<String, Long> endgameTasks, String startingPosition, String comments) {
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

    public Long getMatchNumber() {
        return matchNumber;
    }

    public Long getTeamNumber() {
        return teamNumber;
    }

    public String getAlliance() {
        return alliance;
    }

    public String getScoutName() {
        return scoutName;
    }

    public Long getInitiationLine() {
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

    public HashMap<DataKeys, Long> getMatchData() {
        return matchData;
    }

    @SuppressWarnings("ConstantConditions")
    public void initialize() {
        // Set all values to 0, but non-null to allow incrementing
        for (DataKeys key :
                DataKeys.values()) {
            matchData.put(key, 0L);
        }
        // Inputing auto data
        if (autoTasks != null) {
            for (Map<String, Object> autoTask :
                    autoTasks) {
                Actions action = Actions.fromInt(((Long) autoTask.get("action")).intValue());
                Locations location = Locations.fromInt(((Long) autoTask.get("location")).intValue());
                int time = ((Long) autoTask.get("time")).intValue();
                Object data = autoTask.get("data");
                HashMap<String, Long> shotData = null;
                if (action == Actions.SHOOT_HIGH || action == Actions.SHOOT_LOW) {
                    shotData = (HashMap<String, Long>) data;
                }
                switch (action) {
                    case INTAKE:
                        // Type of value from data key isn't guaranteed until action is known, this is to avoid compile errors
                        Long intakeCount = (Long) data;
                        switch (location) {
                            case RENDEZVOUS_ZONE:
                                matchData.put(DataKeys.INTAKE_RENDEZVOUS_AUTO, matchData.get(DataKeys.INTAKE_RENDEZVOUS_AUTO) + intakeCount);
                                break;
                            case FAR_TRENCH:
                                matchData.put(DataKeys.INTAKE_FAR_TRENCH_AUTO, matchData.get(DataKeys.INTAKE_FAR_TRENCH_AUTO) + intakeCount);
                                break;
                            case OPP_TRENCH:
                                matchData.put(DataKeys.INTAKE_OPP_TRENCH_AUTO, matchData.get(DataKeys.INTAKE_OPP_TRENCH_AUTO) + intakeCount);
                                break;

                            default:
                                Log.d(TAG, "initialize: Error reading intake location");
                                break;
                        }
                        break;
                    case SHOOT_HIGH:
                        matchData.put(DataKeys.TOTAL_HIGH_AUTO, matchData.get(DataKeys.TOTAL_HIGH_AUTO) + shotData.get("scored"));
                        switch (location) {
                            case RENDEZVOUS_ZONE:
                                matchData.put(DataKeys.BALLS_SCORED_RENDEZVOUS_AUTO, matchData.get(DataKeys.BALLS_SCORED_RENDEZVOUS_AUTO) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_RENDEZVOUS_AUTO, matchData.get(DataKeys.BALLS_MISSED_RENDEZVOUS_AUTO) + shotData.get("missed"));
                                break;
                            case INITIATION_LINE:
                                matchData.put(DataKeys.BALLS_SCORED_INITIATION_AUTO, matchData.get(DataKeys.BALLS_SCORED_INITIATION_AUTO) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_INITIATION_AUTO, matchData.get(DataKeys.BALLS_MISSED_INITIATION_AUTO) + shotData.get("missed"));
                                break;

                            case CLOSE_TRENCH:
                                matchData.put(DataKeys.BALLS_SCORED_CLOSE_TRENCH_AUTO, matchData.get(DataKeys.BALLS_SCORED_CLOSE_TRENCH_AUTO) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_CLOSE_TRENCH_AUTO, matchData.get(DataKeys.BALLS_MISSED_CLOSE_TRENCH_AUTO) + shotData.get("missed"));
                                break;
                            case TARGET_ZONE:
                                matchData.put(DataKeys.BALLS_SCORED_HIGH_TARGET_AUTO, matchData.get(DataKeys.BALLS_SCORED_HIGH_TARGET_AUTO) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_HIGH_TARGET_AUTO, matchData.get(DataKeys.BALLS_MISSED_HIGH_TARGET_AUTO) + shotData.get("missed"));
                                break;
                            default:
                                Log.d(TAG, "initialize: Error reading shoot high location");
                                break;
                        }
                        break;
                    case SHOOT_LOW:

                        if (location == Locations.TARGET_ZONE) {
                            matchData.put(DataKeys.BALLS_SCORED_LOW_TARGET_AUTO, matchData.get(DataKeys.BALLS_SCORED_LOW_TARGET_AUTO) + shotData.get("scored"));
                            matchData.put(DataKeys.BALLS_MISSED_LOW_TARGET_AUTO, matchData.get(DataKeys.BALLS_MISSED_LOW_TARGET_AUTO) + shotData.get("missed"));
                        }
                        break;
                    case FED:
                        matchData.put(DataKeys.FED_BALLS_AUTO, 1L);
                        break;

                    default:
                        Log.d(TAG, "initialize: Error reading auto action");
                        break;
                }// End of Auto actions
            } // Auto Tasks
        }
        if (teleTasks != null) {
            // Inputing tele data
            for (Map<String, Object> teleTask :
                    teleTasks) {
                Actions action = Actions.fromInt(((Long) teleTask.get("action")).intValue());
                Locations location = Locations.fromInt(((Long) teleTask.get("location")).intValue());
                int time = ((Long) teleTask.get("time")).intValue();
                Object data = teleTask.get("data");
                HashMap<String, Long> shotData = null;
                if (action == Actions.SHOOT_HIGH || action == Actions.SHOOT_LOW) {
                    shotData = (HashMap<String, Long>) data;
                }
                switch (action) {
                    case INTAKE:
                        Long intakeCount = (Long) data;
                        switch (location) {
                            case OPP_SECTOR:
                                matchData.put(DataKeys.INTAKE_OPP_SECTOR_TELE, matchData.get(DataKeys.INTAKE_OPP_SECTOR_TELE) + intakeCount);
                                break;
                            case LOADING_ZONE:
                                matchData.put(DataKeys.INTAKE_LOADING_TELE, matchData.get(DataKeys.INTAKE_LOADING_TELE) + intakeCount);
                                break;

                            case OPEN_FLOOR:
                                matchData.put(DataKeys.INTAKE_OPEN_FLOOR_TELE, matchData.get(DataKeys.INTAKE_OPEN_FLOOR_TELE) + intakeCount);
                                break;

                            default:
                                Log.d(TAG, "initialize: Error Reading Intake Location");
                                break;
                        }
                        break;
                    case SHOOT_HIGH:
                        matchData.put(DataKeys.TOTAL_HIGH_TELE, matchData.get(DataKeys.TOTAL_HIGH_TELE) + shotData.get("scored"));
                        switch (location) {
                            case CLOSE_TRENCH:
                                matchData.put(DataKeys.BALLS_SCORED_CLOSE_TRENCH_TELE, matchData.get(DataKeys.BALLS_SCORED_CLOSE_TRENCH_TELE) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_CLOSE_TRENCH_TELE, matchData.get(DataKeys.BALLS_MISSED_CLOSE_TRENCH_TELE) + shotData.get("missed"));
                                break;

                            case FAR_TRENCH:
                                matchData.put(DataKeys.BALLS_SCORED_FAR_TRENCH_TELE, matchData.get(DataKeys.BALLS_SCORED_FAR_TRENCH_TELE) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_FAR_TRENCH_TELE, matchData.get(DataKeys.BALLS_MISSED_FAR_TRENCH_TELE) + shotData.get("missed"));
                                break;

                            case OPEN_FLOOR:
                                matchData.put(DataKeys.BALLS_SCORED_OPEN_FLOOR_TELE, matchData.get(DataKeys.BALLS_SCORED_OPEN_FLOOR_TELE) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_OPEN_FLOOR_TELE, matchData.get(DataKeys.BALLS_MISSED_OPEN_FLOOR_TELE) + shotData.get("missed"));
                                break;

                            case TARGET_ZONE:
                                matchData.put(DataKeys.BALLS_SCORED_HIGH_TARGET_TELE, matchData.get(DataKeys.BALLS_SCORED_HIGH_TARGET_TELE) + shotData.get("scored"));
                                matchData.put(DataKeys.BALLS_MISSED_HIGH_TARGET_TELE, matchData.get(DataKeys.BALLS_MISSED_HIGH_TARGET_TELE) + shotData.get("missed"));
                                break;
                        }
                        break;
                    case SHOOT_LOW:
                        if (location == Locations.TARGET_ZONE) {
                            matchData.put(DataKeys.BALLS_SCORED_LOW_TARGET_TELE, matchData.get(DataKeys.BALLS_SCORED_LOW_TARGET_TELE) + shotData.get("scored"));
                            matchData.put(DataKeys.BALLS_MISSED_LOW_TARGET_TELE, matchData.get(DataKeys.BALLS_SCORED_LOW_TARGET_TELE) + shotData.get("missed"));
                        }
                        break;
                    case PLAYED_DEFENSE:
                        Long defenseTime = (Long) data;
                        matchData.put(DataKeys.TIMES_DEFENDING_TELE, matchData.get(DataKeys.TIMES_DEFENDING_TELE) + 1);
                        matchData.put(DataKeys.TIME_DEFENDING_TELE, matchData.get(DataKeys.TIME_DEFENDING_TELE) + defenseTime);
                        break;

                    case GOT_DEFENDED:
                        matchData.put(DataKeys.TIMES_DEFENDED_TELE, matchData.get(DataKeys.TIMES_DEFENDED_TELE) + 1);
                        break;

                    case CONTROL_PANEL:
                        matchData.put(DataKeys.CONTROL_PANEL_TELE, matchData.get(DataKeys.CONTROL_PANEL_TELE) + 1);
                        break;
                    default:
                        Log.d(TAG, "initialize: Error reading tele actions");
                        break;
                } // Tele actions
            } // Tele Tasks
        }

        // Inputing endgame data
        if (endgameTasks != null) {
            matchData.put(DataKeys.BUDDIED, endgameTasks.get("buddy"));
            matchData.put(DataKeys.CARRIED, endgameTasks.get("carried"));
            matchData.put(DataKeys.CLIMB_TYPE, endgameTasks.get("climbType"));
            matchData.put(DataKeys.LEVELED, endgameTasks.get("level"));
            matchData.put(DataKeys.CLIMB_SUCCESS, endgameTasks.get("success"));
        }

//        Log.d(TAG, "initialize: " + matchData.toString());
    }


}
