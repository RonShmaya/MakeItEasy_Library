package com.ron.common_rs_tools;

public class MyTime implements Comparable<MyTime> {
    private int hour;
    private int minutes;

    public MyTime() {
    }

    public MyTime(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }


    public int getHour() {
        return hour;
    }

    public MyTime setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public int getMinutes() {
        return minutes;
    }

    public MyTime setMinutes(int minutes) {
        this.minutes = minutes;
        return this;
    }

    @Override
    public int compareTo(MyTime time) {
        int compareHour = hour - time.hour;
        if (compareHour != 0) {
            return compareHour;
        }
        return minutes - time.minutes;
    }

    public boolean isBetweenByHours(MyTime start, MyTime end) {
        int startHour = start.getHour();
        int endHour = end.getHour();

        if (hour == startHour || hour == endHour) {
            return true;
        }
        if (hour >= startHour && hour <= endHour) {
            return true;
        }
        if (startHour > endHour && startHour > hour) {
            if (hour <= endHour)
                return true;
        }
        if (startHour > endHour && hour > endHour) {
            if (hour >= startHour)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String myHour;
        String myMinutes;
        if (hour < 10)
            myHour = "0" + hour;
        else
            myHour = "" + hour;
        if (minutes < 10)
            myMinutes = "0" + minutes;
        else
            myMinutes = "" + minutes;
        return myHour + " : " + myMinutes;
    }
}


