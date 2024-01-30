package com.example.projectone_cs2340;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.projectone_cs2340.Scheduler.Lecture;
import com.example.projectone_cs2340.Scheduler.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> listItems;
    private ArrayAdapter<String> adapter;

    public MainActivity() {
        listItems = new ArrayList<>();
        listItems.add("Hello!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);

        Schedule schedule = new Schedule("/data/com.example.projectone_cs2340/");
        //schedule.addEvent(new Lecture("CS 2110", LocalDate.of(1,1,1), "Skiles", "Bob", 75));
        System.out.println("");
    }
}