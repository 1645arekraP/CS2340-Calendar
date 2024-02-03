package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Exam extends Event {
    private String location;

    public Exam(String name, String location, Date date) {
        super(name, date, Color.parseColor("#AEC6CF"), location);
    }
}
