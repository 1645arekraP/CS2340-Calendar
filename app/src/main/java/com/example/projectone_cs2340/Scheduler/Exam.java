package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Exam extends Event {
    private String location;

    public Exam(String name, String location, Date date) {
        super(name, date, Color.parseColor("#003459"), location, "Exam");
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
}
