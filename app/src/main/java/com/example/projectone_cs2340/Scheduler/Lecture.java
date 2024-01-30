package com.example.projectone_cs2340.Scheduler;

import android.view.View;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Lecture extends Event {
    private String location;
    private String instructor;
    private int length;

    public Lecture(String name, LocalDate date, String location, String instructor, int length) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.instructor = instructor;
        this.length = length;
    }
    public Lecture(String data) {
        int start = 0;
        int end = data.indexOf(',');

        /*
        ID = Integer.getInteger(data.substring(start, end));
        start = end + 1;
        end = data.indexOf(',', start);
         */

        name = data.substring(start, end);
        start = end + 1;
        end = data.indexOf(',', start);

        //date = LocalDateTime.parse(data.substring(start, end));
        location = data.substring(start, end);
        start = end + 1;
        end = data.indexOf(',', start);

        instructor = data.substring(start, end);
        start = end + 1;
        end = data.indexOf(',', start);

        length = Integer.getInteger(data.substring(start, end));
    }

    @Override
    public void createView(View view) {

    }

    @Override
    public String toString() {
        return "Lecture," + name + ',' + location + ',' + instructor + ',' + length;
    }
}
