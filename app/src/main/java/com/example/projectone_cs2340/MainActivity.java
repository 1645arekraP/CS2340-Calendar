package com.example.projectone_cs2340;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.projectone_cs2340.Scheduler.Schedule;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);

        createLists(savedInstanceState);

        Schedule schedule = new Schedule("C:\\testData.txt");
    }

    private void createLists(Bundle savedInstanceState) {
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );

        ItemList calendarListView = new ItemList();
        ItemList todoList = new ItemList();


        viewPageAdapter.addFragment(calendarListView, "Events");
        viewPageAdapter.addFragment(todoList, "Todo");

        todoList.addToList(new Task("CS2340", "Finish project"));
        todoList.addToList(new Task("MATH1554", "Study for test"));
        todoList.addToList(new Task("PSYC1101", "Study for test," +
                " review study guide"));
        todoList.addToList(new Task("Personal", "Get mixers from Publix"));

        viewPager.setAdapter(viewPageAdapter);
    }
}