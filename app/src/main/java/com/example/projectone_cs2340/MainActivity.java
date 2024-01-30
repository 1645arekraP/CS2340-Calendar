package com.example.projectone_cs2340;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.projectone_cs2340.Scheduler.Schedule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton eventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);
        CalendarFragment cf = new CalendarFragment();

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

}