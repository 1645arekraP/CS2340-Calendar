package com.example.projectone_cs2340.Scheduler;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.projectone_cs2340.Adapters.TodoList;
import com.example.projectone_cs2340.MainActivity;
import com.example.projectone_cs2340.R;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class Course {
    private String courseName;
    private String instructor;
    private Date date;

    private int colorValue;
    public Course(String name, Date date, String instructor) {
        this.courseName = name;
        this.date = date;
        this.instructor = instructor;
        colorValue = Color.parseColor("#9fd3c7");
    }

    public Course(String name)
    {
        this.courseName = name;
        this.date = new Date();
        this.instructor = "";
    }
    public Course(String name, String instructor) {
        this.courseName = name;
        this.instructor = instructor;
    }
    public View getView(View convertView, ViewGroup parent) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        TextView instructorTextView = (TextView) convertView.findViewById(R.id.instructor);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time);
        nameTextView.setText(courseName);
        timeTextView.setText(date.toString());
        nameTextView.setTextColor(colorValue);
        instructorTextView.setText(instructor);
        return convertView;
    }

    public int getLayout() {
        return R.layout.course_item;
    }
    public void updateText(String name, Date date, String instructor) {
        this.courseName = name;
        this.date = date;
        this.instructor = instructor;
    }

    public void updateText(String name, String instructor) {
        this.courseName = name;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName.toLowerCase();
    }
    public Date getDate()
    {
        return date;
    }
}
