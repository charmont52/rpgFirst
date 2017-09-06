package state;

import java.util.LinkedList;

public class Clock {

    private double time;
    private LinkedList eventsList;
    private int hour = 5000;

    private Clock() {
        this.time = 0;
        this.eventsList = new LinkedList();
    }

    private final static Clock instance = new Clock();

    static public Clock getInstance() {
        return instance;
    }

    static public double getTime() {
        return instance.time;
    }

    static public void addTime(double t) {
        instance.time += t;
    }

    static public boolean isNight() {
        return (instance.time/instance.hour % 8 > 4);
    }

    @Override
    public String toString() {
        return "" + instance.time;
    }

}
