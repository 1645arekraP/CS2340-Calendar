package com.example.projectone_cs2340.Scheduler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectone_cs2340.R;

import java.util.ArrayList;

public class Task extends Event {
    private boolean completed;
    private String title;
    private String description;

    //public Task(String data) {
    //    String[] dataArray = data.split(",");
    //    title = dataArray[1];
    //    description = dataArray[2];
    //    completed = Boolean.parseBoolean(dataArray[3]);
    //}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
    @Override
    public void createView(View view) {

    }

    @Override
    public int getLayout() {
        return R.layout.todo_task;
    }

    @Override
    public View getView(View convertView, ViewGroup parent, Event event) {
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.description);
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        return convertView;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
