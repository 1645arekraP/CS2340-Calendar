package com.example.projectone_cs2340;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.projectone_cs2340.Adapters.EventsList;
import com.example.projectone_cs2340.Adapters.TodoList;
import com.example.projectone_cs2340.Adapters.ViewPageAdapter;
import com.example.projectone_cs2340.Scheduler.Assignment;
import com.example.projectone_cs2340.Scheduler.Exam;
import com.example.projectone_cs2340.Scheduler.Lecture;
import com.example.projectone_cs2340.Scheduler.Task;
import com.example.projectone_cs2340.Scheduler.Date;
import com.example.projectone_cs2340.Scheduler.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AlertDialog;

import android.widget.ImageButton;
import android.widget.PopupMenu;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton eventButton;
    TodoList todoList;
    EventsList calendarListView;

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

        calendarListView = new EventsList();
        todoList = new TodoList();

        viewPageAdapter.addFragment(calendarListView, "Events");
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
                        else if (item.getItemId() == R.id.createLectureButton) {
                            lectureAlertDialog(item); // User Story 1
                        }
                        else if (item.getItemId() == R.id.createAssignmentButton) {
                            assignmentAlertDialog(item); // User Story 2
                        }
                        else if (item.getItemId() == R.id.createExamButton) {
                            examAlertDialog(item); // User Story 3
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

        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Date selectedDay = new Date(year, month, dayOfMonth);
                List<Event> eventsOnDay = calendarListView.getEventsByDate(selectedDay);
                calendarListView.getAdapter().setEvents(eventsOnDay);
            }
        });
    }

    private void sortPopUpHelper(View v)
    {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.sort_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.nameASCOption) {
                    todoList.sortByNameASC();
                }
                else if (item.getItemId() == R.id.nameDESCOption) {
                    todoList.sortByNameDESC();
                }
                else if (item.getItemId() == R.id.dateASCOption) {
                    todoList.sortByNameASC();
                }
                else if (item.getItemId() == R.id.dateDESCOption) {
                    todoList.sortByNameASC();
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

    private void lectureAlertDialog(MenuItem item) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.event_popup, null);
        EditText lectureName = (EditText) view.findViewById(R.id.name);
        EditText lectureInstructor = (EditText) view.findViewById(R.id.description);
        EditText lectureTime = (EditText) view.findViewById(R.id.time);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = lectureName.getText().toString();
                        String instructor = lectureInstructor.getText().toString();
                        String time = lectureTime.getText().toString();

                        calendarListView.addToList(new Lecture(name, instructor, time));
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void assignmentAlertDialog(MenuItem item) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.event_popup, null);
        EditText courseName = (EditText) view.findViewById(R.id.name);
        EditText courseInstructor = (EditText) view.findViewById(R.id.description);
        EditText courseTime = (EditText) view.findViewById(R.id.time);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = courseName.getText().toString();
                        String instructor = courseInstructor.getText().toString();
                        String time = courseTime.getText().toString();

                        calendarListView.addToList(new Assignment(name, instructor, time));
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void examAlertDialog(MenuItem item) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.exam_popup, null);
        EditText examName = (EditText) view.findViewById(R.id.name);
        EditText examDate = (EditText) view.findViewById(R.id.date);
        EditText examTime = (EditText) view.findViewById(R.id.time);
        EditText examLocation = (EditText) view.findViewById(R.id.location);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = examName.getText().toString();
                        String date = examDate.getText().toString();
                        String time = examTime.getText().toString();
                        String location = examLocation.getText().toString();

                        calendarListView.addToList(new Exam(name, date, time, location));
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

}