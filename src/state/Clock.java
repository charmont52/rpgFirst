package state;

import java.util.LinkedList;

/**
 * Class using the singleton pattern and managing the time
 */

public class Clock {

    private double time;
    private LinkedList<Event> eventsList;
    private int hour = 5000;

    private Clock() {
        this.time = 0;
        this.eventsList = new LinkedList<Event>();
    }

    private final static Clock instance = new Clock();

    /**
     * Get the clock instance
     *
     * @return The clock instance
     */
    static public Clock getInstance() {
        return instance;
    }

    /**
     * Get the current time
     * @return The current time
     */
    static public double getTime() {
        return instance.time;
    }

    /**
     * Add t milliseconds to the current time
     * @param t The number of milliseconds to add
     */
    static public void addTime(double t) {
        instance.time += t;
    }

    /**
     * Check if it is the night
     * @return True if it is the night
     */
    static public boolean isNight() {
        return (instance.time/instance.hour % 8 > 4);
    }

    public void addEvent(Event event) {
        eventsList.add(event);
    }

    @Override
    public String toString() {
        return "" + instance.time;
    }

}
