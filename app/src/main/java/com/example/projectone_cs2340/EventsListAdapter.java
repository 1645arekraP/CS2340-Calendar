package com.example.projectone_cs2340;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Task;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(events.get(position).getLayout(), null);
        return events.get(position).getView(convertView, parent, events.get(position));
    }
}
