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

import com.example.projectone_cs2340.Scheduler.Lecture;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AlertDialog;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton eventButton;
    ItemList todoList;
    ItemList calendarListView;
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

        calendarListView = new ItemList();
        todoList = new ItemList();


        viewPageAdapter.addFragment(calendarListView, "Events");
        viewPageAdapter.addFragment(todoList, "Todo");

        todoList.addToList(new Task("CS2340", "Finish project"));
        todoList.addToList(new Task("MATH1554", "Study for test"));
        todoList.addToList(new Task("PSYC1101", "Study for test," +
                " review study guide"));

        viewPager.setAdapter(viewPageAdapter);

        eventButton = findViewById(R.id.todoButton);
        eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.createTodoButton) {
                            todoAlertDialog(item);
                        }
                        if (item.getItemId() == R.id.createEventButton) {
                            eventAlertDialog(item);
                        }
                        return false;
                    }
                });

                popupMenu .show();
            }
        });
    }
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
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void eventAlertDialog(MenuItem item) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.event_popup, null);
        EditText eventName = (EditText) view.findViewById(R.id.name);
        EditText eventLocation = (EditText) view.findViewById(R.id.description);
        EditText  eventType = (EditText) view.findViewById(R.id.type);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = eventName.getText().toString();
                        String location = eventLocation.getText().toString();
                        String type = eventType.getText().toString();

                        calendarListView.addToList(new Lecture(title, location));
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }
}