package com.example.projectone_cs2340.Scheduler;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Schedule {
    private List<Event> events = new ArrayList<>();
    private String folderPath;

    public Schedule() {}
    public Schedule(String folderPath) {
        this.folderPath = folderPath;
        //readFile();
    }

    public List<Event> getEvents() {
        return events;
    }
    public String getFolderPath() {
        return folderPath;
    }

    /*
    public void addEvent(Event data) {
        events.add(data);
        updateFile();
    }

    private void readFile() {
        List<String> data = getDatabaseStrings();
        for (String it : data) {
            events.add(Event.stringToEvent(it));
        }
    }

    private List<String> getDatabaseStrings() {
        List<String> result = new ArrayList<>();

        try {
            File file = new File(Environment.getDataDirectory() + folderPath + "test.txt");
            System.out.println(file);
            if (!file.exists()) {
                System.out.println("Creating new file...");
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);

            System.out.println("Reading data... ");
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
            System.out.println("Done");

            scanner.close();
        } catch (Exception e) {
            System.out.println("Failed to get database::" + e);
        }

        return result;
    }

    private void updateFile() {
        System.out.println("updateFile():");
        try {
            File file = new File(Environment.getDataDirectory() + folderPath + "test.txt");
            if (!file.exists()) {
                System.out.println("Creating new file...");
                file.createNewFile();
            }
            FileWriter myWriter = new FileWriter(file);
            System.out.print("Writing... ");
            for (Event it : events) {
                myWriter.write(it + "\n");
            }
            myWriter.close();
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println("Failed to update file::" + e);
        }
    }
     */
}
