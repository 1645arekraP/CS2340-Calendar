package com.example.projectone_cs2340.Scheduler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public abstract class Event {
    protected String name;
    protected Date date;
    protected String extraInfo;
    protected int colorValue;

    public Event(String name, Date date, int colorValue, String extraInfo) {
        this.name = name;
        this.date = date;
        this.extraInfo = extraInfo;
        this.colorValue = colorValue;
    }

    public int getLayout() {
        return R.layout.lecture_item;
    }
    public View getView(View convertView, ViewGroup parent) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        TextView instructorTextView = (TextView) convertView.findViewById(R.id.instructor);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        nameTextView.setText(name);
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
