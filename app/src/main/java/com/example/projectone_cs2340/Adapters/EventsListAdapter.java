package com.example.projectone_cs2340.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectone_cs2340.MainActivity;
import com.example.projectone_cs2340.R;
import com.example.projectone_cs2340.Scheduler.Course;
import com.example.projectone_cs2340.Scheduler.Date;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Lecture;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EventsListAdapter extends BaseAdapter {
    private List<Event> events;
    private LayoutInflater layoutInflater;

    public EventsListAdapter(Context context, List<Event> eventData)
    {
        this.events = eventData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Put button code into this method

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(events.get(position).getLayout(), null);
        ImageButton eventButton = convertView.findViewById(R.id.eventSettingsButton);

        View finalConvertView = convertView;
        eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(parent.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.events_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.deleteOption) {
                            events.remove(position);
                        }
                        if (item.getItemId() == R.id.editOption) {
                            todoAlertDialog(position, finalConvertView, parent);
                        }
                        notifyDataSetChanged();
                        return false;
                    }
                });

                popupMenu.show();
            }
        });


        return events.get(position).getView(convertView, parent);
    }

    private void todoAlertDialog(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getView(position, convertView, parent).getContext()).inflate(R.layout.event_popup, null);
        EditText eventName = (EditText) view.findViewById(R.id.name);
        EditText eventDescription = (EditText) view.findViewById(R.id.description);
        EditText eventDate = (EditText) view.findViewById(R.id.date);
        EditText eventTime = (EditText) view.findViewById(R.id.time);
        EditText eventCourse = (EditText) view.findViewById(R.id.course);

        AlertDialog.Builder builder = new AlertDialog.Builder(getView(position, convertView, parent).getContext());
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = eventName.getText().toString();
                        String description = eventDescription.getText().toString();
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


                        events.get(position).updateText(name, description, date, new Course(courseName));
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public String toString() {
        return events.toString();
    }
}
/*eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(finalConvertView.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.todo_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.deleteOption) {
                            System.out.println("Clicked!");
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });*/