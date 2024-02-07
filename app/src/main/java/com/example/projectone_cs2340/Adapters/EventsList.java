package com.example.projectone_cs2340.Adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.widget.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.projectone_cs2340.R;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class EventsList extends Fragment {
    private ListView list;
    private View view;
    private List<Event> events;
    private List<Event> allEvents;
    private EventsListAdapter adapter;

    public EventsList() {
        events = new ArrayList<>();
    }
    public EventsList(List<Event> allEvents) {
        this.allEvents = allEvents;
        events = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        list = view.findViewById(R.id.itemList);

        adapter = new EventsListAdapter(view.getContext(), events, allEvents);
        list.setAdapter(adapter);

        return view;
    }

    public void addToList(Event event) {
        events.add(event);
    }

    public void removeFromList(int position) {
        //adapter.removeEvent(position);
    }


    public void sortByNameASC() {
        if (!events.isEmpty()) {
            events.sort(Comparator.comparing(Event::getCourseName));
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByNameDESC() {
        if (!events.isEmpty()) {
            events.sort(Comparator.comparing(Event::getCourseName));
            Collections.reverse(events);
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByDateASC() {
        if (!events.isEmpty()) {
            events.sort(Comparator.comparing(Event::getDate));
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByDateDESC() {
        if (!events.isEmpty()) {
            events.sort(Comparator.comparing(Event::getDate));
            Collections.reverse(events);
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByType() {
        if (!events.isEmpty()) {
            events.sort(Comparator.comparing(Event::getType));
            adapter.notifyDataSetChanged();
        }
    }

    public void setList(List<Event> data) {
        events.clear();
        events.addAll(data);
        adapter.notifyDataSetChanged();
    }

    public EventsListAdapter getAdapter() {
        return adapter;
    }

    public String toString() {
        return events.toString();
    }
}