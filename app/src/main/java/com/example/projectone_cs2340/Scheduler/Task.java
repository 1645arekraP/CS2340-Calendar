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

public class Task extends Event {
    private String title;
    private String description;
    private boolean completed;

    //public Task(String data) {
    //    String[] dataArray = data.split(",");
    //    title = dataArray[1];
    //    description = dataArray[2];
    //    completed = Boolean.parseBoolean(dataArray[3]);
    //}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        completed = false;
    }

    @Override
    public int getLayout() {
        return R.layout.todo_task;
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.description);
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        if (completed) {
            titleTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            descriptionTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }
        return convertView;
    }

    public void markCompleted() {
        completed = !completed;
    }

    public void updateText(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
