package com.example.projectone_cs2340.Scheduler;

public class Date implements Comparable {
    private long data = 0;

    public Date() {}

    public Date(String data){
        String[] halves = data.split("T");
        String[] date = halves[0].split("-");
        String[] time = halves[1].split(":");

        setYear(Integer.parseInt(date[0]));
        setMonth(Integer.parseInt(date[1]));
        setDay(Integer.parseInt(date[2]));

        setHour(Integer.parseInt(time[0]));
        setMinutes(Integer.parseInt(time[1]));
        setSeconds(Integer.parseInt(time[2]));
    }

    public Date(String date, String time) {
        String[] dates = date.split("/");
        String[] times = time.split(":");

        setDay(Integer.parseInt(dates[1]));
        setMonth(Integer.parseInt(dates[0]));
        setYear(Integer.parseInt(dates[2]));
        setHour(Integer.parseInt(times[0]));
        setMinutes(Integer.parseInt(times[1]));
        setSeconds(Integer.parseInt(times[2]));
    }
    public Date(int year, int month, int day, int hour, int minutes, int seconds) {
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(hour);
        setMinutes(minutes);
        setSeconds(seconds);
    }
    public Date(int year, int month, int day) {
        this(year, month, day, 0, 0, 0);
    }
    public Date(long data) {
        this.data = data;
    }

    public int getYear() {
        return (int)getBits(26, 16);
    }
    public int getMonth() {
        return (int)getBits(22, 4);
    }
    public int getDay() {
        return (int)getBits(17, 5);
    }
    public int getHour() {
        return (int)getBits(12, 5);
    }
    public int getMinutes() {
        return (int)getBits(6, 6);
    }
    public int getSeconds() {
        return (int)getBits(0, 6);
    }

    public int setYear(int data) {
        if (data < 0 || data > 65536 ) {
            throw new IllegalArgumentException("Year out of bounds: " + data);
        }

        return (int)setBits(data, 26, 16);
    }
    public int setMonth(int data) {
        if (data < 0 || data > 12) {
            throw new IllegalArgumentException("Month out of bounds: " + data);
        }

        return (int)setBits(data, 22, 4);
    }
    public int setDay(int data) {
        if (data < 0 || data > 31) {
            throw new IllegalArgumentException("Day out of bounds: " + data);
        }

        return (int)setBits(data, 17, 5);
    }
    public int setHour(int data) {
        if (data < 0 || data > 24) {
            throw new IllegalArgumentException("Hour out of bounds: " + data);
        }

        return (int)setBits(data, 12, 5);
    }
    public int setMinutes(int data) {
        if (data < 0 || data > 60) {
            throw new IllegalArgumentException("Minutes out of bounds: " + data);
        }

        return (int)setBits(data, 6, 6);
    }
    public int setSeconds(int data) {
        if (data < 0 || data > 60) {
            throw new IllegalArgumentException("Seconds out of bounds: " + data);
        }

        return (int)setBits(data, 0, 6);
    }
    public long getData() {
        return data;
    }

    private long getBits(int s, int n) {
        return ((data >> s) & ~((~(long)0) << n));
    }
    private long setBits(long bits, int s, int n) {
        long temp = getBits(s, n);
        this.data = data & ~(((data >> s) & ~(~0 << n)) << s);
        this.data = (this.data | (bits << s));
        return temp;
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d %02d:%02d:%02d", getYear(), getMonth(), getDay(), getHour(), getMinutes(), getSeconds());
    }

    /*
     * Does not properly represent magnitude of difference but does get "greater/less than" and "equal to" cases correct.
     */
    public int compareTo(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot compare to null");
        }
        if (!this.getClass().equals(obj.getClass())) {
            throw new IllegalArgumentException("Cannot compare objects not of the same type");
        }

        return Long.compare(data, ((Date)obj).getData());
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return compareTo(obj) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sameDay(Date date) {
        return getYear() == date.getYear() && getMonth() == date.getMonth() && getDay() == date.getDay();
    }


}