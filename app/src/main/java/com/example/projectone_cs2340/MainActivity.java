package com.example.projectone_cs2340;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.projectone_cs2340.Scheduler.Schedule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Schedule schedule = new Schedule("C:\\CodeProjects\\Android Studio\\CS2340-Calendar\\app\\src\\main\\java\\com\\example\\projectone_cs2340\\Scheduler\\testData.txt");
    }
}