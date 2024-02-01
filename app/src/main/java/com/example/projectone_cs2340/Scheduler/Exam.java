package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Exam extends Event {
    private String title;
    private String date;
    private String time;
    private String location;
    private int colorValue;

    public Exam(String title, String date, String time, String location) {
        this.title = title;
        this.date = date;
        this.time = time;
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
    public View getView(View convertView, ViewGroup parent, Event event) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        TextView instructorTextView = (TextView) convertView.findViewById(R.id.instructor);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        nameTextView.setText("Exam: " + title);
        instructorTextView.setText(date + " : " + time);
        timeTextView.setText(location);
        nameTextView.setTextColor(colorValue);
        return convertView;
    }
}
