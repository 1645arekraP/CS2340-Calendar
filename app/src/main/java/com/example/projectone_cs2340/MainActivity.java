package com.example.projectone_cs2340;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.projectone_cs2340.Adapters.CourseList;
import com.example.projectone_cs2340.Adapters.EventsList;
import com.example.projectone_cs2340.Adapters.TodoList;
import com.example.projectone_cs2340.Adapters.ViewPageAdapter;
import com.example.projectone_cs2340.Scheduler.Assignment;
import com.example.projectone_cs2340.Scheduler.Course;
import com.example.projectone_cs2340.Scheduler.Date;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Exam;
import com.example.projectone_cs2340.Scheduler.Lecture;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AlertDialog;

import android.widget.ImageButton;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    List<Event> events;
    List<Event> tasks;
    List<Event> eventsOnDay;
    FloatingActionButton eventButton;
    TodoList todoList;
    EventsList eventsList;
    ImageButton sortButton;

    CourseList courseList;

    CalendarView calendar;
    Date selectedDate;

    Button showAllButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);

        events = new ArrayList<>();
        tasks = new ArrayList<>();
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );

        eventsList = new EventsList();
        todoList = new TodoList();
        courseList = new CourseList();

        viewPageAdapter.addFragment(courseList, "Courses");
        viewPageAdapter.addFragment(eventsList, "Events");
        viewPageAdapter.addFragment(todoList, "To-Do Tasks");

        viewPager.setAdapter(viewPageAdapter);

        eventButton = findViewById(R.id.toDoButton);
        eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.createCourseButton) {
                            courseAlertDialog(item);
                        }
                        if (item.getItemId() == R.id.createTodoButton) {
                            todoAlertDialog(item); // User Story 4
                        }
                        if (item.getItemId() == R.id.createLectureButton) {
                            eventAlertDialog(item, "L"); // User Story 1
                        }
                        if (item.getItemId() == R.id.createAssignmentButton) {
                            eventAlertDialog(item, "A"); // User Story 2
                        }
                        if (item.getItemId() == R.id.createExamButton) {
                            eventAlertDialog(item, "E"); // User Story 3
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        calendar = findViewById(R.id.calendarView);
        Calendar dateCalculator = Calendar.getInstance();
        dateCalculator.setTimeInMillis(calendar.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = sdf.format(dateCalculator.getTime());
        String[] curDateData = curDate.split("-");
        selectedDate = new Date(
                Integer.parseInt(curDateData[0]),
                Integer.parseInt(curDateData[1]),
                Integer.parseInt(curDateData[2])
        );
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate.setYear(year);
                selectedDate.setMonth(month + 1);
                selectedDate.setDay(dayOfMonth);

                updateViewList();
            }
        });


        sortButton = findViewById(R.id.sortButton);
        sortButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sortPopUpHelper(v);
            }
        });
        showAllButton = findViewById(R.id.showAllButton);
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventsList.setList(events);
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
                    //Add Toast if something doesn't sort. 
                    todoList.sortByNameASC();
                    eventsList.sortByNameASC();
                    courseList.sortByNameASC();
                } else if (item.getItemId() == R.id.nameDESCOption) {
                    todoList.sortByNameDESC();
                    eventsList.sortByNameDESC();
                    courseList.sortByNameDESC();
                } else if (item.getItemId() == R.id.dateASCOption) {
                    eventsList.sortByDateASC();
                    courseList.sortByDateASC();
                } else if (item.getItemId() == R.id.dateDESCOption) {
                    eventsList.sortByDateDESC();
                    courseList.sortByDateDESC();
                } else if (item.getItemId() == R.id.classType) {
                    eventsList.sortByType();
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void updateViewList() {
        eventsList.setList(getEventsByDate(selectedDate));
    }

    public List<Event> getEventsByDate(Date date) {
        List<Event> result = new ArrayList<>();
        for (Event it : events) {
            if (date.sameDay(it.getDate())) {
                result.add(it);
            }
        }
        return result;
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

    private void eventAlertDialog(MenuItem item, String type) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.event_popup, null);
        EditText eventName = (EditText) view.findViewById(R.id.name);
        EditText eventDescription = (EditText) view.findViewById(R.id.description);
        EditText eventDate = (EditText) view.findViewById(R.id.date);
        EditText eventTime = (EditText) view.findViewById(R.id.time);
        EditText eventCourse = (EditText) view.findViewById(R.id.course);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = eventName.getText().toString();
                        String description = eventDescription.getText().toString();
                        //String date = eventDate.getText().toString();
                        //String time = eventTime.getText().toString();
                        String courseName = eventCourse.getText().toString();

                        String dateStr = eventDate.getText().toString();
                        String timeStr = eventTime.getText().toString();
                        String[] dateData = dateStr.split("-");
                        String[] timeData = timeStr.split(":");
                        Date date = new Date(
                                Integer.parseInt(dateData[0]),
                                Integer.parseInt(dateData[1]),
                                Integer.parseInt(dateData[2]),
                                Integer.parseInt(timeData[0]),
                                Integer.parseInt(timeData[1]),
                                Integer.parseInt(timeData[2])
                        );

                        switch (type) {
                            case ("L"):
                                events.add(new Lecture(name, description, date, new Course(courseName)));
                                break;
                            case ("A"):
                                events.add(new Assignment(name, description, date, new Course(courseName)));
                                break;
                            case ("E"):
                                events.add(new Exam(name, description, date, new Course(courseName)));
                                break;
                        }
                        updateViewList();
                    }

                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void courseAlertDialog(MenuItem item) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.course_popup, null);
        EditText courseName = (EditText) view.findViewById(R.id.name);
        EditText courseDate = (EditText) view.findViewById(R.id.date);
        EditText courseTime = (EditText) view.findViewById(R.id.time);
        EditText courseInstructor = (EditText) view.findViewById(R.id.instructor);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = courseName.getText().toString();
                        String date = courseDate.getText().toString();
                        String time = courseTime.getText().toString();
                        String instructor = courseInstructor.getText().toString();
                        courseList.addToList(new Course(name, new Date(date, time), instructor));
                        //courseList.addToList(new Course(name, instructor));
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }
}