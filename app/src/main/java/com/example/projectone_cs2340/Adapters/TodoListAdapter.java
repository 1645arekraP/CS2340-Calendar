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
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Task;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Comparator;

public class TodoListAdapter extends BaseAdapter {
    private ArrayList<Task> events;
    private LayoutInflater layoutInflater;

    public TodoListAdapter(Context context, ArrayList<Task> eventData) {
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
                popupMenu.getMenuInflater().inflate(R.menu.todo_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.deleteOption) {
                            events.remove(position);
                        }
                        if (item.getItemId() == R.id.completeOption) {
                            events.get(position).markCompleted();
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

    public void addButtonListener() {

    }


    public void addEvent(Task event) {
        events.add(event);
    }

    public void removeEvent(int position) {
        events.remove(position);
    }

    private void todoAlertDialog(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getView(position, convertView, parent).getContext()).inflate(R.layout.task_popup, null);
        EditText todoName = (EditText) view.findViewById(R.id.name);
        EditText toDoDescription = (EditText) view.findViewById(R.id.description);

        AlertDialog.Builder builder = new AlertDialog.Builder(getView(position, convertView, parent).getContext());
        builder.setMessage("Enter event details here:")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = todoName.getText().toString();
                        String desc = toDoDescription.getText().toString();
                        events.get(position).updateText(title, desc);
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }


}