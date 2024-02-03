package com.example.projectone_cs2340.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectone_cs2340.R;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EventsListAdapter extends BaseAdapter {
    private ArrayList<Event> events;
    private LayoutInflater layoutInflater;

    public EventsListAdapter(Context context, ArrayList<Event> eventData) {
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
        //FloatingActionButton eventButton = convertView.findViewById(R.id.eventSettingsButton);

        /* eventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(parent.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.todo_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.deleteOption) {
                            events.remove(position);
                            notifyDataSetChanged();
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        }); */


        return events.get(position).getView(convertView, parent);
    }

    public void addButtonListener() {

    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(int position) {
        events.remove(position);
    }


}
/*
* eventButton.setOnClickListener(new View.OnClickListener() {
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