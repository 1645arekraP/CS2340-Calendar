package com.example.projectone_cs2340;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.projectone_cs2340.Adapters.EventsList;
import com.example.projectone_cs2340.Adapters.TodoList;
import com.example.projectone_cs2340.Adapters.ViewPageAdapter;
import com.example.projectone_cs2340.Scheduler.Assignment;
import com.example.projectone_cs2340.Scheduler.Date;
import com.example.projectone_cs2340.Scheduler.Exam;
import com.example.projectone_cs2340.Scheduler.Lecture;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AlertDialog;

import android.widget.ImageButton;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton eventButton;
    TodoList todoList;
    EventsList eventsList;

    ImageButton sortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );

        eventsList = new EventsList();
        todoList = new TodoList();


        viewPageAdapter.addFragment(eventsList, "Events");
        viewPageAdapter.addFragment(todoList, "Todo");

        viewPager.setAdapter(viewPageAdapter);

        eventButton = findViewById(R.id.toDoButton);
        eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.createTodoButton) {
                            todoAlertDialog(item); // User Story 4
                        }
                        if (item.getItemId() == R.id.createLectureButton) {
                            lectureAlertDialog(item, "L"); // User Story 1
                        }
                        if (item.getItemId() == R.id.createAssignmentButton) {
                            lectureAlertDialog(item, "A"); // User Story 2
                        }
                        if (item.getItemId() == R.id.createExamButton) {
                            lectureAlertDialog(item, "E"); // User Story 3
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        sortButton = findViewById(R.id.sortButton);
        sortButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sortPopUpHelper(v);
            }
        });
    }

    private void sortPopUpHelper(View v) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.sort_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.nameASCOption) {
                    todoList.sortByNameASC();
                    eventsList.sortByNameASC();
                } else if (item.getItemId() == R.id.nameDESCOption) {
                    todoList.sortByNameDESC();
                    eventsList.sortByNameDESC();
                } else if (item.getItemId() == R.id.dateASCOption) {
                    eventsList.sortByDateASC();
                } else if (item.getItemId() == R.id.dateDESCOption) {
                    eventsList.sortByDateDESC();
                }
                return false;
            }
        });
        popupMenu.show();
    }

    // All of these methods below could probably be combined into a class
    // Some attributes probably need to be renamed, I can do this later tonight
    private void todoAlertDialog(MenuItem item) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.task_popup, null);
        EditText todoName = (EditText) view.findViewById(R.id.name);
        EditText toDoDescription = (EditText) view.findViewById(R.id.description);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = todoName.getText().toString();
                        String desc = toDoDescription.getText().toString();

                        todoList.addToList(new Task(title, desc));
                        //todoList.sortByName();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void lectureAlertDialog(MenuItem item, String type) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.event_popup, null);
        EditText eventName = (EditText) view.findViewById(R.id.name);
        EditText eventDescription = (EditText) view.findViewById(R.id.description);
        EditText eventDate = (EditText) view.findViewById(R.id.date);
        EditText eventTime = (EditText) view.findViewById(R.id.time);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = eventName.getText().toString();
                        String instructor = eventDescription.getText().toString();
                        String date = eventDate.getText().toString();
                        String time = eventTime.getText().toString();

                        switch (type) {
                            case ("L"):
                                eventsList.addToList(new Lecture(name, instructor, new Date(date, time)));
                                break;
                            case ("A"):
                                eventsList.addToList(new Assignment(name, instructor, new Date(date, time)));
                                break;
                            case ("E"):
                                eventsList.addToList(new Exam(name, instructor, new Date(date, time)));
                                break;
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }
}