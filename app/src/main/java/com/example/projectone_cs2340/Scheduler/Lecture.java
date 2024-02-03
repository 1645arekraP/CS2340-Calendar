package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Lecture extends Event {
    public Lecture(String name, String instructor, Date date) {
        super(name, date, Color.parseColor("#ff6961"), instructor);
    }

    public void updateText(String name, String instructor, Date date) {
        this.name = name;
        this.extraInfo = instructor;
        this.date = date;
    }
}
