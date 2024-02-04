package com.example.projectone_cs2340.Scheduler;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

public abstract class Event {
    protected String name;
    protected Date date;
    protected String description;
    protected int colorValue;

    protected String type;
    protected Course course;

    public Event(String name, Date date, int colorValue, String description, Course course, String type) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.colorValue = colorValue;
        this.course = course;
        this.type = type;
    }

    public int getLayout() {
        return R.layout.lecture_item;
    }
    public abstract View getView(View convertView, ViewGroup parent);

    public void updateText(String name, String description, Date date, Course course) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.course = course;
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

    public String getCourseName()
    {
        return course.getCourseName();
    }
}
