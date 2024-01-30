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
import android.widget.Toast;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AlertDialog;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton eventButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);

        createLists(savedInstanceState);

        eventButton = findViewById(R.id.todoButton);
        eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.one) {
                            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment_pop_up, null);
                            EditText eventName = (EditText) view.findViewById(R.id.name);
                            EditText eventDate = (EditText) view.findViewById(R.id.time);
                            EditText courseName = (EditText) view.findViewById(R.id.course);
                            EditText location = (EditText) view.findViewById(R.id.location);
                            EditText professorName = (EditText) view.findViewById(R.id.professor);
                            EditText isCompleted = (EditText) view.findViewById(R.id.completed);

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Enter event details here:")
                                    .setView(view)
                                    .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String eName = eventName.getText().toString();
                                            String eDate = eventDate.getText().toString();
                                            String cName = courseName.getText().toString();
                                            String loc = location.getText().toString();
                                            String prof = professorName.getText().toString();
                                            String complete = isCompleted.getText().toString();

                                            Toast myToast = Toast.makeText(MainActivity.this, "Hello toast!", Toast.LENGTH_SHORT);
                                            myToast.show();
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .setCancelable(false);
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
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