package com.example.projectone_cs2340.Scheduler;

import android.view.View;
import android.view.ViewGroup;

import com.example.projectone_cs2340.Scheduler.Date;

public abstract class Event {
    protected String name;
    protected Date date;

    public abstract void createView(View view);

    public abstract int getLayout();
    public abstract View getView(View convertView, ViewGroup parent);

    public abstract Date getDate();
}
