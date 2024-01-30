package com.example.projectone_cs2340.Scheduler;

import android.view.View;

import java.util.Date;

public abstract class Event {
    protected int ID;
    protected String name;
    protected Date date;

    public abstract void createView(View view);

    public static Event stringToEvent(String data) {
        String type = data.substring(0, data.indexOf(','));
        if (type.equals("Lecture")) {
            return new Lecture(data.substring(data.indexOf(',') + 1));
        } else if (type.equals("Assignment")) {
            return new Assignment(data);
        } else if (type.equals("Exam")) {
            return new Exam(data);
        } else if (type.equals("Task")) {
            return new Task(data);
        }
        throw new IllegalArgumentException("Data type not supported");
    }
}
