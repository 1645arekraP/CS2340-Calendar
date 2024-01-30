package com.example.projectone_cs2340.Scheduler;

import android.view.View;

import androidx.fragment.app.Fragment;

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

    }

    @Override
    public String toString() {
        return "Lecture," + name + ',' + location + ',' + instructor + ',' + length;
    }
}
