package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Assignment extends Event {
    private String dueDate;
    private String course;
    private int colorValue;

    public Assignment(String name, String course, Date date) {
        super(name, date, Color.parseColor("#77dd77"), course);
    }
}
