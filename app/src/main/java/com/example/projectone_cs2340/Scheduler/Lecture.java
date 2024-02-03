package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Lecture extends Event {
    public Lecture(String name, String instructor, Date date) {
        super(name, date, Color.parseColor("#ff6961"), instructor, "Lecture");
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        TextView instructorTextView = (TextView) convertView.findViewById(R.id.instructor);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        nameTextView.setText(name + "\nType: " + type);
        instructorTextView.setText(extraInfo);
        timeTextView.setText(date.toString());
        nameTextView.setTextColor(colorValue);
        return convertView;
    }

    public void updateText(String name, String instructor, Date date) {
        this.name = name;
        this.extraInfo = instructor;
        this.date = date;
    }
}
