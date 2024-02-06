package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Lecture extends Event {
    public Lecture(String name, String description, Date date, Course c) {
        super(name, date, Color.parseColor("#498eb9"), description, c,"Lecture");
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        TextView instructorTextView = (TextView) convertView.findViewById(R.id.instructor);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        nameTextView.setText(name + "\nType: " + type + "\nCourse: " + course.getCourseName());
        instructorTextView.setText(description);
        timeTextView.setText(date.toString());
        nameTextView.setTextColor(colorValue);
        return convertView;
    }

    public void updateText(String name, String instructor, Date date) {
        this.name = name;
        this.description = instructor;
        this.date = date;
    }
}
