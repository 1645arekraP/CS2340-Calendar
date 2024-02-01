package com.example.projectone_cs2340.Scheduler;

public class Course extends Event {
    private String location;
    private String instructor;
    private int length;

    public Course(String name, Date date, String location, String instructor, int length) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.instructor = instructor;
        this.length = length;
    }
    public Course(String data) {
        String[] dataArr = data.split(",");
        name = dataArr[0];
    }

    @Override
    public String toString() {
        return "Lecture," + name + ',' + location + ',' + instructor + ',' + length;
    }
}
