package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Exam extends Event {
    private String location;
    private int colorValue;

    public Exam(String name, Date date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
        colorValue = Color.parseColor("#AEC6CF");
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
        nameTextView.setText("Exam: " + name);
        instructorTextView.setText(date.toString());
        timeTextView.setText(location);
        nameTextView.setTextColor(colorValue);
        return convertView;
    }
    @Override
    public Date getDate() {
        return date;
    }
}
