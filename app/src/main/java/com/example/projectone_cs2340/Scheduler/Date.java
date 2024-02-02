package com.example.projectone_cs2340.Scheduler;

public class Date implements Comparable {
    private long data = 0;

    public Date() {}
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
        return (int)getBits(0, 16);
    }
    public int getMonth() {
        return (int)getBits(16, 4);
    }
    public int getDay() {
        return (int)getBits(20, 5);
    }
    public int getHour() {
        return (int)getBits(25, 5);
    }
    public int getMinutes() {
        return (int)getBits(30, 6);
    }
    public int getSeconds() {
        return (int)getBits(36, 6);
    }

    public int setYear(int data) {
        if (data < 0 || data > 65536 ) {
            throw new IllegalArgumentException("Year out of bounds: " + data);
        }

        return (int)setBits(data, 0, 16);
    }
    public int setMonth(int data) {
        if (data < 0 || data > 12) {
            throw new IllegalArgumentException("Month out of bounds: " + data);
        }

        return (int)setBits(data, 16, 4);
    }
    public int setDay(int data) {
        if (data < 0 || data > 31) {
            throw new IllegalArgumentException("Day out of bounds: " + data);
        }

        return (int)setBits(data, 20, 5);
    }
    public int setHour(int data) {
        if (data < 0 || data > 24) {
            throw new IllegalArgumentException("Hour out of bounds: " + data);
        }

        return (int)setBits(data, 25, 5);
    }
    public int setMinutes(int data) {
        if (data < 0 || data > 60) {
            throw new IllegalArgumentException("Minutes out of bounds: " + data);
        }

        return (int)setBits(data, 30, 6);
    }
    public int setSeconds(int data) {
        if (data < 0 || data > 60) {
            throw new IllegalArgumentException("Seconds out of bounds: " + data);
        }

        return (int)setBits(data, 36, 6);
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
        return String.format("%d-%02d-%02dT%02d:%02d:%02d", getYear(), getMonth(), getDay(), getHour(), getMinutes(), getSeconds());
    }

    /*
     * Does not properly represent magnitude of difference but does get "greater/less than" and "equal to" cases correct.
     */
    @Override
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
}