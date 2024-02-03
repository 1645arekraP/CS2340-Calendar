package com.example.projectone_cs2340.Scheduler;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public abstract class Event {
    protected String name;
    protected Date date;
    protected String extraInfo;
    protected int colorValue;

    protected String type;

    public Event(String name, Date date, int colorValue, String extraInfo, String type) {
        this.name = name;
        this.date = date;
        this.extraInfo = extraInfo;
        this.colorValue = colorValue;
        this.type = type;
    }

    public int getLayout() {
        return R.layout.lecture_item;
    }
    public abstract View getView(View convertView, ViewGroup parent);

    public void updateText(String name, String instructor, Date date) {
        this.name = name;
        this.extraInfo = instructor;
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public Date getDate()
    {
        return date;
    }

    public String getType()
    {
        return type;
    }
}
