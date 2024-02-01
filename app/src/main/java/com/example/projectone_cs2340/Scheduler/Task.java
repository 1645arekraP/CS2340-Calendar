package com.example.projectone_cs2340.Scheduler;

import android.view.View;

import com.example.projectone_cs2340.R;

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

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
