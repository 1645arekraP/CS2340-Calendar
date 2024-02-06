package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

import java.sql.Time;

public class Lecture extends Event {
    private String location;
    private String instructor;
    private int colorValue;

    public Lecture(String location, String instructor, Date date) {
        this.location = location;
        this.instructor = instructor;
        this.date = date;
        //this.date = date;
        colorValue = Color.parseColor("#ff6961");
    }

    @Override
    public void createView(View view) {

    }

    @Override
    public int getLayout() {
        return R.layout.lecture_item;
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        TextView instructorTextView = (TextView) convertView.findViewById(R.id.instructor);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        nameTextView.setText("Lecture: " + instructor);
        instructorTextView.setText(location);
        timeTextView.setText(date.toString());
        nameTextView.setTextColor(colorValue);
        return convertView;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void promptAlert() {

    }

    @Override
    public String toString() {
        return "Lecture," + name + ',' + date.toString() + ',' + location;
    }
}
