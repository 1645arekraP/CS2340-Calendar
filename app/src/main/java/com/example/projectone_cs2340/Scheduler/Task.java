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

public class Task {
    private String name;
    private String description;
    private boolean completed;

    protected int colorValue;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        completed = false;
        colorValue = Color.parseColor("#1f6f78");
    }

    public int getLayout() {
        return R.layout.todo_task;
    }

    public View getView(View convertView, ViewGroup parent) {
        TextView nameTextView = (TextView) convertView.findViewById(R.id.title);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.description);
        nameTextView.setText(name);
        descriptionTextView.setText(description);
        nameTextView.setTextColor(colorValue);
        if (completed) {
            nameTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            descriptionTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }
        return convertView;
    }

    public void markCompleted() {
        completed = !completed;
    }

    public void updateText(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public String getStringTitle() {
        return name.toLowerCase();
    }
}
