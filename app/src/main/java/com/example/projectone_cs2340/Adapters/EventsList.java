package com.example.projectone_cs2340.Adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.projectone_cs2340.R;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Date;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoList} factory method to
 * create an instance of this fragment.
 */
public class EventsList extends Fragment {
    private ListView list;
    private View view;
    private List<Event> events;
    private EventsListAdapter adapter;

    public EventsList() {
        events = new ArrayList<>();
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        list = view.findViewById(R.id.itemList);

        adapter = new EventsListAdapter(
                view.getContext(),
                events);
        list.setAdapter(adapter);

        return view;
    }

    public void addToList(Event event) {
        events.add(event);
    }
    public void setList(List<Event> data) {
        events.clear();
        events.addAll(data);
        adapter.notifyDataSetChanged();
    }
    public void removeFromList(int position) {
        //adapter.removeEvent(position);
    }
    public EventsListAdapter getAdapter() {return adapter;}

    public String toString() {
        return events.toString();
    }
}