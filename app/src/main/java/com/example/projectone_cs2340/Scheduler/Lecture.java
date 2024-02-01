package com.example.projectone_cs2340.Scheduler;

import android.view.View;

public class Lecture extends Event {
    private String location;
    private String instructor;
    private String time;
    private String days;

    public Lecture(String data) {
        name = data.substring(0, data.indexOf(','));
    }

    public Lecture(String location, String instructor, String time, String days) {
        this.location = location;
        this.instructor = instructor;
        this.time = time;
        this.days = days;
    }

    public Lecture(String location, String instructor) {
        this.location = location;
        this.instructor = instructor;
    }

    @Override
    public void createView(View view) {

    }

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public String toString() {
        //return "Lecture," + name + ',' + date.toString() + ',' + location + ',' + length;
        return "asdasd";

    }
}
