package com.theorystrat.DataModels;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Tourny {


    // Schedule
    private ArrayList<String[]> schedule;
    // Event Name
    private String eventName;

    //TODO remove nullable annotaion and handle schedule features
    public Tourny(String eventName, @Nullable ArrayList<String[]> schedule) {
        this.schedule = schedule;
        this.eventName = eventName;
    }


    // Setters

    public void setSchedule(ArrayList<String[]> schedule) {
        this.schedule = schedule;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // Getters

    public ArrayList<String[]> getSchedule() {
        return schedule;
    }


    public String getEventName() {
        return eventName;
    }
}
