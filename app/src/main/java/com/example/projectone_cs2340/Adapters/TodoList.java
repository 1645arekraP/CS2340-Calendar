package com.example.projectone_cs2340.Adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.projectone_cs2340.R;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoList extends Fragment {
    private ListView list;
    private View view;
    private ArrayList<Task> events;
    private TodoListAdapter adapter;

    public TodoList() {
        events = new ArrayList<>();
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        list = view.findViewById(R.id.itemList);

        adapter = new TodoListAdapter(
                view.getContext(),
                events);
        list.setAdapter(adapter);

        return view;
    }

    public void addToList(Task event) {
        events.add(event);
    }

    public void removeFromList(int position) {
        //adapter.removeEvent(position);
    }
}