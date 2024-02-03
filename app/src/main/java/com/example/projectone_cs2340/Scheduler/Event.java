package com.example.projectone_cs2340.Scheduler;

import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

public abstract class Event {
    protected String name;
    protected Date date;

    public abstract void createView(View view);

    public abstract int getLayout();
    public abstract View getView(View convertView, ViewGroup parent);

    public static Event stringToEvent(String data) {
        String type = data.substring(0, data.indexOf(','));
        if (type.equals("Lecture")) {
            return new Lecture(data.substring(data.indexOf(',') + 1));
        } else if (type.equals("Assignment")) {
            //return new Assignment(data);
        } else if (type.equals("Exam")) {
            //return new Exam(data);
        } else if (type.equals("Task")) {
            return new Task(data, "REMOVE LATER");
        }
        throw new IllegalArgumentException("Data type not supported");
    }
}
