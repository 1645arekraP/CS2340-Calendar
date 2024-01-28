package com.example.projectone_cs2340.Scheduler;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Schedule {
    private List<Event> events;
    private String filePath;

    public Schedule(String filePath) {
        events = new ArrayList<>();
        this.filePath = filePath;
        readFile();
    }

    public List<Event> getEvents() {
        return events;
    }
    public String getFilePath() {
        return filePath;
    }

    private void readFile() {
        try {
            File file = new File("/data/test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Failed to read file::" + e);
        }
    }
}
