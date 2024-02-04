package com.example.projectone_cs2340.Adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.projectone_cs2340.R;
import com.example.projectone_cs2340.Scheduler.Course;
import com.example.projectone_cs2340.Scheduler.Date;
import com.example.projectone_cs2340.Scheduler.Event;
import com.example.projectone_cs2340.Scheduler.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseList extends Fragment {
    private ListView list;
    private View view;
    private ArrayList<Course> events;
    private CourseListAdapter adapter;

    public CourseList() {
        events = new ArrayList<>();
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        list = view.findViewById(R.id.itemList);

        adapter = new CourseListAdapter(
                view.getContext(),
                events);
        list.setAdapter(adapter);

        return view;
    }

    public void addToList(Course course) {
        events.add(course);
    }

    public void sortByNameASC() {
        if(!events.isEmpty())
        {
            events.sort(Comparator.comparing(Course::getCourseName));
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByNameDESC() {
        if(!events.isEmpty())
        {
            events.sort(Comparator.comparing(Course::getCourseName));
            Collections.reverse(events);
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByDateASC() {
        if(!events.isEmpty())
        {
            events.sort(Comparator.comparing(Course::getDate));
            adapter.notifyDataSetChanged();
        }
    }

    public void sortByDateDESC() {
        if(!events.isEmpty())
        {
            events.sort(Comparator.comparing(Course::getDate));
            Collections.reverse(events);
            adapter.notifyDataSetChanged();
        }
    }

    public void removeFromList(int position) {
        //adapter.removeEvent(position);
    }

}