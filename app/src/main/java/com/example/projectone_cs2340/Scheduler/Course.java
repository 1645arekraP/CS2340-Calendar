package com.example.projectone_cs2340.Scheduler;

import android.view.View;
import android.view.ViewGroup;

public class Course {
    private String location;
    private String instructor;
    private int length;
    private Date date;

    public Course(String name, Date date, String location, String instructor, int length) {
        //this.name = name;
        this.date = date;
        this.location = location;
        this.instructor = instructor;
        this.length = length;
    }
    public Course(String data) {
        String[] dataArr = data.split(",");
        //name = dataArr[0];
    }

    @Override
    public String toString() {
        return "Lecture," + ',' + location + ',' + instructor + ',' + length;
    }


    public int getLayout() {
        return 0;
    }


    public View getView(View convertView, ViewGroup parent) {
        return null;
    }
}
