package com.example.projectone_cs2340.Scheduler;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public class Assignment extends Event {
    private String lecture;
    private int colorValue;

    public Assignment(String name, String lecture, Date date) {
        this.name = name;
        this.date = date;
        this.lecture = lecture;
        colorValue = Color.parseColor("#77dd77");
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
        nameTextView.setText("Assignment: " + name);
        instructorTextView.setText(date.toString());
        timeTextView.setText(lecture);
        nameTextView.setTextColor(colorValue);
        return convertView;
    }

    @Override
    public Date getDate() {
        return date;
    }
}
