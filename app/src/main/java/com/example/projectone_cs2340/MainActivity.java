package com.example.projectone_cs2340;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.xmlpull.v1.XmlPullParser;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton eventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment);
        CalendarFragment cf = new CalendarFragment();

        eventButton = findViewById(R.id.toDoButton);
        eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.course)
                        {
                            showClassPopUp(R.layout.course_pop_up);
                        }
                        if(item.getItemId() == R.id.exam)
                        {
                            showExamPopUp(R.layout.exam_pop_up);
                        }
                        if(item.getItemId() == R.id.assignment)
                        {
                            showAssignmentPopUp(R.layout.assignment_pop_up);
                        }
                        if(item.getItemId() == R.id.toDoItem)
                        {
                            showToDoPopUp(R.layout.to_do_pop_up);
                        }
                        return false;
                    }
                });


                popupMenu.show();
            }
        });
    }

    private void showClassPopUp(int xmlFile)
    {
        View view = LayoutInflater.from(MainActivity.this).inflate(xmlFile, null);
        EditText className = (EditText) view.findViewById(R.id.name);
        EditText classDay = (EditText) view.findViewById(R.id.day);
        EditText classTime = (EditText) view.findViewById(R.id.time);
        EditText location = (EditText) view.findViewById(R.id.location);
        EditText professorName = (EditText) view.findViewById(R.id.professor);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String cName = className.getText().toString();
                        String eDate = classDay.getText().toString();
                        String eTime = classTime.getText().toString();
                        String loc = location.getText().toString();
                        String prof = professorName.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showExamPopUp(int xmlFile)
    {
        View view = LayoutInflater.from(MainActivity.this).inflate(xmlFile, null);
        EditText className = (EditText) view.findViewById(R.id.name);
        EditText examDay = (EditText) view.findViewById(R.id.day);
        EditText examTime = (EditText) view.findViewById(R.id.time);
        EditText location = (EditText) view.findViewById(R.id.location);
        EditText professorName = (EditText) view.findViewById(R.id.professor);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String cName = className.getText().toString();
                        String eDate = examDay.getText().toString();
                        String eTime = examTime.getText().toString();
                        String loc = location.getText().toString();
                        String prof = professorName.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showAssignmentPopUp(int xmlFile)
    {
        View view = LayoutInflater.from(MainActivity.this).inflate(xmlFile, null);
        EditText className = (EditText) view.findViewById(R.id.name);
        EditText dueDay = (EditText) view.findViewById(R.id.day);
        EditText dueTime = (EditText) view.findViewById(R.id.time);
        EditText notes = (EditText) view.findViewById(R.id.notes);
        EditText professorName = (EditText) view.findViewById(R.id.professor);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String cName = className.getText().toString();
                        String eDate = dueDay.getText().toString();
                        String eTime = dueTime.getText().toString();
                        String note = notes.getText().toString();
                        String prof = professorName.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showToDoPopUp(int xmlFile)
    {
        View view = LayoutInflater.from(MainActivity.this).inflate(xmlFile, null);
        EditText className = (EditText) view.findViewById(R.id.name);
        EditText dueDay = (EditText) view.findViewById(R.id.day);
        EditText dueTime = (EditText) view.findViewById(R.id.time);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String cName = className.getText().toString();
                        String eDate = dueDay.getText().toString();
                        String eTime = dueTime.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

}