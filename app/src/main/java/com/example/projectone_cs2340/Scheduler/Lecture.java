package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Lecture extends Event {
    private String location;
    private String instructor;
    private String time;
    private int colorValue;

    public Lecture(String data) {
        name = data.substring(0, data.indexOf(','));
    }

    public Lecture(String location, String instructor, String time) {
        this.location = location;
        this.instructor = instructor;
        this.time = time;
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
        timeTextView.setText(time);
        nameTextView.setTextColor(colorValue);
        return convertView;
    }

    public void promptAlert() {

    }

    @Override
    public String toString() {
        //return "Lecture," + name + ',' + date.toString() + ',' + location + ',' + length;
        return "asdasd";

    }
}
