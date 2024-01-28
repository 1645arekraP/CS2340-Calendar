package com.example.projectone_cs2340.Scheduler;

import android.view.View;

public class Lecture extends Event {
    private String location;
    private String instructor;
    private int length;

    public Lecture(String data) {
        name = data.substring(0, data.indexOf(','));
    }

    @Override
    public void createView(View view) {

    }

    @Override
    public String toString() {
        return "Lecture," + name + ',' + date.toString() + ',' + location + ',' + length;
    }
}
