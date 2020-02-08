package com.ModaserMojadiddi;

/*

Modaser Mojadiddi
2020-02-08

 */

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class MatchCard {
    // matches and teams array instances
    public static Matches matches = new Matches();
    public static Teams teams = new Teams();

    // fields 6 teams
    Team red1;
    Team red2;
    Team red3;
    Team blue1;
    Team blue2;
    Team blue3;

    // Two constructors one takes 6 teams, other takes a match number

    public MatchCard(String red1, String red2, String red3, String blue1, String blue2, String blue3) {
       if(red1 == null){
           this.red1 = null;
       }
        if(red2 == null){
            this.red2 = null;
        }
        if(red3 == null){
            this.red3 = null;
        }
        if(blue1 == null){
            this.blue1 = null;
        }
        if(blue2 == null){
            this.blue2 = null;
        }
        if(blue3 == null){
            this.blue3 = null;
        }
        this.red1 = teams.getTeam(red1);
        this.red2 = teams.getTeam(red2);
        this.red3 = teams.getTeam(red3);
        this.blue1 = teams.getTeam(blue1);
        this.blue2 = teams.getTeam(blue2);
        this.blue3 = teams.getTeam(blue3);

    }

    public MatchCard(String matchNum) {

        this.red1 = matches.getMatch(matchNum).getTeams().get(0);
        this.red2 = matches.getMatch(matchNum).getTeams().get(1);
        this.red3 = matches.getMatch(matchNum).getTeams().get(2);
        this.blue1 = matches.getMatch(matchNum).getTeams().get(3);
        this.blue2 = matches.getMatch(matchNum).getTeams().get(4);
        this.blue3 = matches.getMatch(matchNum).getTeams().get(5);

    }


    /*
    ---------------------------------------getters for the stats-----------------------------------------------------

     */
// Get the names of the teams
    public String getRed1Name(){
        return red1.getName();
    }
    public String getRed2Name(){
        return red2.getName();
    }
    public String getRed3Name(){
        return red3.getName();
    }
    public String getBlue1Name(){
        return blue1.getName();
    }
    public String getBlue2Name(){
        return blue2.getName();
    }public String getBlue3Name(){
        return blue3.getName();
    }




    /*
    -----------------------------------------------Auto---------------------------------------------------------------------
     */
    // starting postion in Auto
    public String getRed1AutoStartPosition() {
        return red1.getautoStartPosition();
    }

    public String getRed2AutoStartPosition() {
        return red2.getautoStartPosition();
    }

    public String getRed3AutoStartPosition() {
        return red3.getautoStartPosition();
    }

    public String getBlue1AutoStartPosition() {
        return blue1.getautoStartPosition();
    }

    public String getBlue2AutoStartPosition() {
        return blue2.getautoStartPosition();
    }

    public String getBlue3AutoStartPosition() {
        return blue3.getautoStartPosition();
    }
    //  Auto high goal inner/outer/miss in auto

    public String getRed1AutoHighGoalInnerOuterMiss() {
        return red1.getautoHighGoalInnerOuterMiss();
    }

    public String getRed2AutoHighGoalInnerOuterMiss() {
        return red2.getautoHighGoalInnerOuterMiss();
    }

    public String getRed3AutoHighGoalInnerOuterMiss() {
        return red3.getautoHighGoalInnerOuterMiss();
    }

    public String getBlue1AutoHighGoalInnerOuterMiss() {
        return blue1.getautoHighGoalInnerOuterMiss();
    }

    public String getBlue2AutoHighGoalInnerOuterMiss() {
        return blue2.getautoHighGoalInnerOuterMiss();
    }

    public String getBlue3AutoHighGoalInnerOuterMiss() {
        return blue3.getautoHighGoalInnerOuterMiss();
    }

    // Auto high goal ave balls
    public int getRed1AutoHighGoalAveBalls() {
        return red1.getautoHighGoalAveBalls();
    }

    public int getRed2AutoHighGoalAveBalls() {
        return red2.getautoHighGoalAveBalls();
    }

    public int getRed3AutoHighGoalAveBalls() {
        return red3.getautoHighGoalAveBalls();
    }

    public int getBlue1AutoHighGoalAveBalls() {
        return blue1.getautoHighGoalAveBalls();
    }

    public int getBlue2AutoHighGoalAveBalls() {
        return blue2.getautoHighGoalAveBalls();
    }

    public int getBlue3AutoHighGoalAveBalls() {
        return blue3.getautoHighGoalAveBalls();
    }

    // Auto low goal s/m
    public String getRed1AutoLowGoalSM() {
        return red1.getautoLowGoalSM();
    }

    public String getRed2AutoLowGoalSM() {
        return red2.getautoLowGoalSM();
    }

    public String getRed3AutoLowGoalSM() {
        return red3.getautoLowGoalSM();
    }

    public String getBlue1AutoLowGoalSM() {
        return blue1.getautoLowGoalSM();
    }

    public String getBlue2AutoLowGoalSM() {
        return blue2.getautoLowGoalSM();
    }

    public String getBlue3AutoLowGoalSM() {
        return blue3.getautoLowGoalSM();
    }

    // Auto low goal ave balls
    public int getRed1AutoLowGoalAveBalls() {
        return red1.getautoLowGoalAveBalls();
    }

    public int getRed2AutoLowGoalAveBalls() {
        return red2.getautoLowGoalAveBalls();
    }

    public int getRed3AutoLowGoalAveBalls() {
        return red3.getautoLowGoalAveBalls();
    }

    public int getBlue1AutoLowGoalAveBalls() {
        return blue1.getautoLowGoalAveBalls();
    }

    public int getBlue2AutoLowGoalAveBalls() {
        return blue2.getautoLowGoalAveBalls();
    }

    public int getBlue3AutoLowGoalAveBalls() {
        return blue3.getautoLowGoalAveBalls();
    }


    // Auto trench balls picked up
    public int getRed1AutoTrenchBallsPickedUp() {
        return red1.getautoTrenchBallsPickedUp();
    }

    public int getRed2AutoTrenchBallsPickedUp() {
        return red2.getautoTrenchBallsPickedUp();
    }

    public int getRed3AutoTrenchBallsPickedUp() {
        return red3.getautoTrenchBallsPickedUp();
    }

    public int getBlue1AutoTrenchBallsPickedUp() {
        return blue1.getautoTrenchBallsPickedUp();
    }

    public int getBlue2AutoTrenchBallsPickedUp() {
        return blue2.getautoTrenchBallsPickedUp();
    }

    public int getBlue3AutoTrenchBallsPickedUp() {
        return blue3.getautoTrenchBallsPickedUp();
    }

    // Auto rendezvous balls picked up
    public int getRed1AutoRendezvousBallsPickedUp() {
        return red1.getautoRendezvousBallsPickedUp();
    }

    public int getRed2AutoRendezvousBallsPickedUp() {
        return red2.getautoRendezvousBallsPickedUp();
    }

    public int getRed3AutoRendezvousBallsPickedUp() {
        return red3.getautoRendezvousBallsPickedUp();
    }

    public int getBlue1AutoRendezvousBallsPickedUp() {
        return blue1.getautoRendezvousBallsPickedUp();
    }

    public int getBlue2AutoRendezvousBallsPickedUp() {
        return blue2.getautoRendezvousBallsPickedUp();
    }

    public int getBlue3AutoRendezvousBallsPickedUp() {
        return blue3.getautoRendezvousBallsPickedUp();
    }

    // Auto Robot Regurgitation Feed balls picked up
    public int getRed1AutoRobotRegurgitationFeedBallsPickedUp() {
        return red1.getautoRobotRegurgitationFeedBallsPickedUp();
    }

    public int getRed2AutoRobotRegurgitationFeedBallsPickedUp() {
        return red2.getautoRobotRegurgitationFeedBallsPickedUp();
    }

    public int getRed3AutoRobotRegurgitationFeedBallsPickedUp() {
        return red3.getautoRobotRegurgitationFeedBallsPickedUp();
    }

    public int getBlue1AutoRobotRegurgitationFeedBallsPickedUp() {
        return blue1.getautoRobotRegurgitationFeedBallsPickedUp();
    }

    public int getBlue2AutoRobotRegurgitationFeedBallsPickedUp() {
        return blue2.getautoRobotRegurgitationFeedBallsPickedUp();
    }

    public int getBlue3AutoRobotRegurgitationFeedBallsPickedUp() {
        return blue3.getautoRobotRegurgitationFeedBallsPickedUp();
    }

    // Auto trench shot amount of balls
    public int getRed1AutoTrenchShot() {
        return red1.getAutoTrenchShot();
    }

    public int getRed2AutoTrenchShot() {
        return red2.getAutoTrenchShot();
    }

    public int getRed3AutoTrenchShot() {
        return red3.getAutoTrenchShot();
    }

    public int getBlue1AutoTrenchShot() {
        return blue1.getAutoTrenchShot();
    }

    public int getBlue2AutoTrenchShot() {
        return blue2.getAutoTrenchShot();
    }

    public int getBlue3AutoTrenchShot() {
        return blue3.getAutoTrenchShot();
    }

    // Auto rendezvous shot amount of balls
    public int getRed1AutoRendezvousShot() {
        return red1.getAutoRendezvousShot();
    }

    public int getRed2AutoRendezvousShot() {
        return red2.getAutoRendezvousShot();
    }

    public int getRed3AutoRendezvousShot() {
        return red3.getAutoRendezvousShot();
    }

    public int getBlue1AutoRendezvousShot() {
        return blue1.getAutoRendezvousShot();
    }

    public int getBlue2AutoRendezvousShot() {
        return blue2.getAutoRendezvousShot();
    }

    public int getBlue3AutoRendezvousShot() {
        return blue3.getAutoRendezvousShot();
    }

    // Auto target zone shot amount of balls
    public int getRed1AutoTargetZoneShot() {
        return red1.getAutoTargetZoneShot();
    }

    public int getRed2AutoTargetZoneShot() {
        return red2.getAutoTargetZoneShot();
    }

    public int getRed3AutoTargetZoneShot() {
        return red3.getAutoTargetZoneShot();
    }

    public int getBlue1AutoTargetZoneShot() {
        return blue1.getAutoTargetZoneShot();
    }

    public int getBlue2AutoTargetZoneShot() {
        return blue2.getAutoTargetZoneShot();
    }

    public int getBlue3AutoTargetZoneShot() {
        return blue3.getAutoTargetZoneShot();
    }

    // Auto mid range shot amount of balls
    public int getRed1AutoMidRangeShot() {
        return red1.getAutoMidRangeShot();
    }

    public int getRed2AutoMidRangeShot() {
        return red2.getAutoMidRangeShot();
    }

    public int getRed3AutoMidRangeShot() {
        return red3.getAutoMidRangeShot();
    }

    public int getBlue1AutoMidRangeShot() {
        return blue1.getAutoMidRangeShot();
    }

    public int getBlue2AutoMidRangeShot() {
        return blue2.getAutoMidRangeShot();
    }

    public int getBlue3AutoMidRangeShot() {
        return blue3.getAutoMidRangeShot();
    }

    /*
    ---------------------------------------------------Tele-------------------------------------------------------
     */

    // Tele high goal accuracy
    public String getRed1TeleHighGoalAccuracy(){
        return red1.getTeleHighGoalAccuracy();
    }
    public String getRed2TeleHighGoalAccuracy(){
        return red2.getTeleHighGoalAccuracy();
    }
    public String getRed3TeleHighGoalAccuracy(){
        return red3.getTeleHighGoalAccuracy();
    }
    public String getBlue1TeleHighGoalAccuracy(){
        return blue1.getTeleHighGoalAccuracy();
    }
    public String getBlue2TeleHighGoalAccuracy(){
        return blue2.getTeleHighGoalAccuracy();
    }
    public String getBlue3TeleHighGoalAccuracy(){
        return blue3.getTeleHighGoalAccuracy();
    }

    // Tele high goal ave balls
    public int getRed1TeleHighGoalAveBalls(){
        return red1.getTeleHighGoalAveBalls();
    }
    public int getRed2TeleHighGoalAveBalls(){
        return red2.getTeleHighGoalAveBalls();
    }
    public int getRed3TeleHighGoalAveBalls(){
        return red3.getTeleHighGoalAveBalls();
    }
    public int getBlue1TeleHighGoalAveBalls(){
        return blue1.getTeleHighGoalAveBalls();
    }
    public int getBlue2TeleHighGoalAveBalls(){
        return blue2.getTeleHighGoalAveBalls();
    }public int getBlue3TeleHighGoalAveBalls(){
        return blue3.getTeleHighGoalAveBalls();
    }

    // Tele low goal accuracy
    public String getRed1TeleLowGoalAccuracy(){
        return red1.getTeleLowGoalAccuracy();
    }
    public String getRed2TeleLowGoalAccuracy(){
        return red2.getTeleLowGoalAccuracy();
    }
    public String getRed3TeleLowGoalAccuracy(){
        return red3.getTeleLowGoalAccuracy();
    }
    public String getBlue1TeleLowGoalAccuracy(){
        return blue1.getTeleLowGoalAccuracy();
    }
    public String getBlue2TeleLowGoalAccuracy(){
        return blue2.getTeleLowGoalAccuracy();
    }
    public String getBlue3TeleLowGoalAccuracy(){
        return blue3.getTeleLowGoalAccuracy();
    }

    // Tele low goal ave balls
    public int getRed1TeleLowGoalAveBalls(){
        return red1.getTeleLowGoalAveBalls();
    }
    public int getRed2TeleLowGoalAveBalls(){
        return red2.getTeleLowGoalAveBalls();
    }
    public int getRed3TeleLowGoalAveBalls(){
        return red3.getTeleLowGoalAveBalls();
    }
    public int getBlue1TeleLowGoalAveBalls(){
        return blue1.getTeleLowGoalAveBalls();
    }
    public int getBlue2TeleLowGoalAveBalls(){
        return blue2.getTeleLowGoalAveBalls();
    }
    public int getBlue3TeleLowGoalAveBalls(){
        return blue3.getTeleLowGoalAveBalls();
    }

    // OUTPUT: attempted balls per location / accuracy
    // Tele trench shot amount of balls
    public String getRed1TeleTrenchShot() {
        return red1.getTeleTrenchShot();
    }

    public String getRed2TeleTrenchShot() {
        return red2.getTeleTrenchShot();
    }

    public String getRed3TeleTrenchShot() {
        return red3.getTeleTrenchShot();
    }

    public String getBlue1TeleTrenchShot() {
        return blue1.getTeleTrenchShot();
    }

    public String getBlue2TeleTrenchShot() {
        return blue2.getTeleTrenchShot();
    }

    public String getBlue3TeleTrenchShot() {
        return blue3.getTeleTrenchShot();
    }

    // Tele target zone shot amount of balls
    public String getRed1TeleTargetZoneShot() {
        return red1.getTeleTargetZoneShot();
    }

    public String getRed2TeleTargetZoneShot() {
        return red2.getTeleTargetZoneShot();
    }

    public String getRed3TeleTargetZoneShot() {
        return red3.getTeleTargetZoneShot();
    }

    public String getBlue1TeleTargetZoneShot() {
        return blue1.getTeleTargetZoneShot();
    }

    public String getBlue2TeleTargetZoneShot() {
        return blue2.getTeleTargetZoneShot();
    }

    public String getBlue3TeleTargetZoneShot() {
        return blue3.getTeleTargetZoneShot();
    }
    // Tele rendezvous + mid range shot amount of balls
    public String getRed1TeleRendezvousAndMidRangeShot() {
        return red1.getTeleRendezvousAndMidRangeShot();
    }

    public String getRed2TeleRendezvousAndMidRangeShot() {
        return red2.getTeleRendezvousAndMidRangeShot();
    }

    public String getRed3TeleRendezvousAndMidRangeShot() {
        return red3.getTeleRendezvousAndMidRangeShot();
    }

    public String getBlue1TeleRendezvousAndMidRangeShot() {
        return blue1.getTeleRendezvousAndMidRangeShot();
    }

    public String getBlue2TeleRendezvousAndMidRangeShot() {
        return blue2.getTeleRendezvousAndMidRangeShot();
    }

    public String getBlue3TeleRendezvousAndMidRangeShot() {
        return blue3.getTeleRendezvousAndMidRangeShot();
    }

    // Tele control panel rotation success/miss
    public String getRed1TeleControlPanelRotationSuccessMiss(){
        return red1.getTeleControlPanelRotationSUccessMiss();
    }
    public String getRed2TeleControlPanelRotationSuccessMiss(){
        return red2.getTeleControlPanelRotationSUccessMiss();
    }public String getRed3TeleControlPanelRotationSuccessMiss(){
        return red3.getTeleControlPanelRotationSUccessMiss();
    }
    public String getBlue1TeleControlPanelRotationSuccessMiss(){
        return blue1.getTeleControlPanelRotationSUccessMiss();
    }
    public String getBlue2TeleControlPanelRotationSuccessMiss(){
        return blue2.getTeleControlPanelRotationSUccessMiss();
    }
    public String getBlue3TeleControlPanelRotationSuccessMiss(){
        return blue3.getTeleControlPanelRotationSUccessMiss();
    }

    // Tele control panel rotation time
    public String getRed1TeleControlPanelRotationTime(){
        return red1.getTeleControlPanelRotationTime();
    }
    public String getRed2TeleControlPanelRotationTime(){
        return red2.getTeleControlPanelRotationTime();
    }public String getTeleRed3ControlPanelRotationTime(){
        return red3.getTeleControlPanelRotationTime();
    }
    public String getBlue1TeleControlPanelRotationTime(){
        return blue1.getTeleControlPanelRotationTime();
    }
    public String getBlue2TeleControlPanelRotationTime(){
        return blue2.getTeleControlPanelRotationTime();
    }
    public String getBlue3TeleControlPanelRotationTime(){
        return blue3.getTeleControlPanelRotationTime();
    }

    // Tele control panel Position success/miss
    public String getRed1TeleControlPanelPositionSuccessMiss(){
        return red1.getTeleControlPanelPositionSUccessMiss();
    }
    public String getRed2TeleControlPanelPositionSuccessMiss(){
        return red2.getTeleControlPanelPositionSUccessMiss();
    }
    public String getRed3TeleControlPanelPositionSuccessMiss(){
        return red3.getTeleControlPanelPositionSUccessMiss();
    }
    public String getBlue1TeleControlPanelPositionSuccessMiss(){
        return blue1.getTeleControlPanelPositionSUccessMiss();
    }
    public String getBlue2TeleControlPanelPositionSuccessMiss(){
        return blue2.getTeleControlPanelPositionSUccessMiss();
    }
    public String getBlue3TeleControlPanelPositionSuccessMiss(){
        return blue3.getTeleControlPanelPositionSUccessMiss();
    }

    // Tele control panel Position time
    public String getRed1TeleControlPanelPositionTime(){
        return red1.getTeleControlPanelPositionTime();
    }
    public String getRed2TeleControlPanelPositionTime(){
        return red2.getTeleControlPanelPositionTime();
    }public String getRed3TeleControlPanelPositionTime(){
        return red3.getTeleControlPanelPositionTime();
    }
    public String getBlue1TeleControlPanelPositionTime(){
        return blue1.getTeleControlPanelPositionTime();
    }
    public String getBlue2TeleControlPanelPositionTime(){
        return blue2.getTeleControlPanelPositionTime();
    }
    public String getBlue3TeleControlPanelPositionTime(){
        return blue3.getTeleControlPanelPositionTime();
    }

    // Tele Cycle time average shot to shot
    public String getRed1TeleCycleTimeAverageShotToShot(){
        return red1.getTeleCycleTimeAverageShotToShot();
    }
    public String getRed2TeleCycleTimeAverageShotToShot(){
        return red2.getTeleCycleTimeAverageShotToShot();
    }public String getRed3TeleCycleTimeAverageShotToShot(){
        return red3.getTeleCycleTimeAverageShotToShot();
    }
    public String getBlue1TeleCycleTimeAverageShotToShot(){
        return blue1.getTeleCycleTimeAverageShotToShot();
    }
    public String getBlue2TeleCycleTimeAverageShotToShot(){
        return blue2.getTeleCycleTimeAverageShotToShot();
    }
    public String getBlue3TeleCycleTimeAverageShotToShot(){
        return blue3.getTeleCycleTimeAverageShotToShot();
    }

    // Tele Intake % feeder
    public String getRed1TeleIntakePercentFeeder(){
        return red1.getTelentakePercentFeeder();
    }
    public String getRed2TeleIntakePercentFeeder(){
        return red2.getTelentakePercentFeeder();
    }
    public String getRed3TeleIntakePercentFeeder(){
        return red3.getTelentakePercentFeeder();
    }
    public String getBlue1TeleIntakePercentFeeder(){
        return blue1.getTelentakePercentFeeder();
    }
    public String getBlue2TeleIntakePercentFeeder(){
        return blue2.getTelentakePercentFeeder();
    }
    public String getBlue3TeleIntakePercentFeeder(){
        return blue3.getTelentakePercentFeeder();
    }

    // Tele Intake % Sector
    public String getRed1TeleIntakePercentSector(){
        return red1.getTelentakePercentSector();
    }
    public String getRed2TeleIntakePercentSector(){
        return red2.getTelentakePercentSector();
    }
    public String getRed3TeleIntakePercentSector(){
        return red3.getTelentakePercentSector();
    }
    public String getBlue1TeleIntakePercentSector(){
        return blue1.getTelentakePercentSector();
    }
    public String getBlue2TeleIntakePercentSector(){
        return blue2.getTelentakePercentSector();
    }
    public String getBlue3TeleIntakePercentSector(){
        return blue3.getTelentakePercentSector();
    }
    // Tele Intake % Mid + OppSector
    public String getRed1TeleIntakePercentMidOppSector(){
        return red1.getTelentakePercentMidOppSector();
    }
    public String getRed2TeleIntakePercentMidOppSector(){
        return red2.getTelentakePercentMidOppSector();
    }
    public String getRed3TeleIntakePercentMidOppSector(){
        return red3.getTelentakePercentMidOppSector();
    }
    public String getBlue1TeleIntakePercentMidOppSector(){
        return blue1.getTelentakePercentMidOppSector();
    }
    public String getBlue2TeleIntakePercentMidOppSector(){
        return blue2.getTelentakePercentMidOppSector();
    }
    public String getBlue3TeleIntakePercentMidOppSector(){
        return blue3.getTelentakePercentMidOppSector();
    }

    /*
    ------------------------------------------------EndGame-----------------------------------------------------------
     */
   // EndGame climb success and attempt
    public String getRed1EndGameClimbSucessAttempt(){
        return red1.getEndGameClimbSucessAttempt();
    }
    public String getRed2EndGameClimbSucessAttempt(){
        return red2.getEndGameClimbSucessAttempt();
    }
    public String getRed3EndGameClimbSucessAttempt(){
        return red3.getEndGameClimbSucessAttempt();
    }
    public String getBlue1EndGameClimbSucessAttempt(){
        return blue1.getEndGameClimbSucessAttempt();
    }
    public String getBlue2EndGameClimbSucessAttempt(){
        return blue2.getEndGameClimbSucessAttempt();
    }
    public String getBlue3EndGameClimbSucessAttempt(){
        return blue3.getEndGameClimbSucessAttempt();
    }

    // EndGame Position N/C/F
    public String getRed1EndGameClimbPositionNCF(){
        return red1.getEndGameClimbPositionNCF();
    }
    public String getRed2EndGameClimbPositionNCF(){
        return red2.getEndGameClimbPositionNCF();
    }
    public String getRed3EndGameClimbPositionNCF(){
        return red3.getEndGameClimbPositionNCF();
    }
    public String getBlue1EndGameClimbPositionNCF(){
        return blue1.getEndGameClimbPositionNCF();
    }
    public String getBlue2EndGameClimbPositionNCF(){
        return blue2.getEndGameClimbPositionNCF();
    }
    public String getBlue3EndGameClimbPositionNCF(){
        return blue3.getEndGameClimbPositionNCF();
    }

    // EndGame Level success and attempt
    public String getRed1EndGameClimbLevelSuccessAttempt(){
        return red1.getEndGameClimbLevelSuccessAttempt();
    }
    public String getRed2EndGameClimbLevelSuccessAttempt(){
        return red2.getEndGameClimbLevelSuccessAttempt();
    }
    public String getRed3EndGameClimbLevelSuccessAttempt(){
        return red3.getEndGameClimbLevelSuccessAttempt();
    }
    public String getBlue1EndGameClimbLevelSuccessAttempt(){
        return blue1.getEndGameClimbLevelSuccessAttempt();
    }
    public String getBlue2EndGameClimbLevelSuccessAttempt(){
        return blue2.getEndGameClimbLevelSuccessAttempt();
    }
    public String getBlue3EndGameClimbLevelSuccessAttempt(){
        return blue3.getEndGameClimbLevelSuccessAttempt();
    }

    // EndGame ave time
    public String getRed1EndGameClimbAveTime(){
        return red1.getEndGameClimbAveTime();
    }
    public String getRed2EndGameClimbAveTime(){
        return red2.getEndGameClimbAveTime();
    }
    public String getRed3EndGameClimbAveTime(){
        return red3.getEndGameClimbAveTime();
    }
    public String getBlue1EndGameClimbAveTime(){
        return blue1.getEndGameClimbAveTime();
    }
    public String getBlue2EndGameClimbAveTime(){
        return blue2.getEndGameClimbAveTime();
    }
    public String getBlue3EndGameClimbAveTime(){
        return blue3.getEndGameClimbAveTime();
    }

    // EndGame Climb Carry Someone: Successes total over whole comp
    public String getRed1EndGameClimbCarrySomeoneSuccessesTotalAllCompt(){
        return red1.getEndGameClimbCarrySomeoneSuccessesTotalAllCompt();
    }
    public String getRed2EndGameClimbCarrySomeoneSuccessesTotalAllCompt(){
        return red2.getEndGameClimbCarrySomeoneSuccessesTotalAllCompt();
    }
    public String getRed3EndGameClimbCarrySomeoneSuccessesTotalAllCompt(){
        return red3.getEndGameClimbCarrySomeoneSuccessesTotalAllCompt();
    }
    public String getBlue1EndGameClimbCarrySomeoneSuccessesTotalAllCompt(){
        return blue1.getEndGameClimbCarrySomeoneSuccessesTotalAllCompt();
    }
    public String getBlue2EndGameClimbCarrySomeoneSuccessesTotalAllCompt(){
        return blue2.getEndGameClimbCarrySomeoneSuccessesTotalAllCompt();
    }
    public String getBlue3EndGameClimbCarrySomeoneSuccessesTotalAllCompt(){
        return blue3.getEndGameClimbCarrySomeoneSuccessesTotalAllCompt();
    }

    // EndGame Park success and attempts
    public String getRed1EndGameParkSuccessAttempts(){
        return red1.getEndGameParkSuccessAttempts();
    }
    public String getRed2EndGameParkSuccessAttempts(){
        return red2.getEndGameParkSuccessAttempts();
    }
    public String getRed3EndGameParkSuccessAttempts(){
        return red3.getEndGameParkSuccessAttempts();
    }
    public String getBlue1EndGameParkSuccessAttempts(){
        return blue1.getEndGameParkSuccessAttempts();
    }
    public String getBlue2EndGameParkSuccessAttempts(){
        return blue2.getEndGameParkSuccessAttempts();
    }
    public String getBlue3EndGameParkSuccessAttempts(){
        return blue3.getEndGameParkSuccessAttempts();
    }

    /*
    --------------------------------------------------THE END----------------------------------------------------------
     */
}
