package state;

import event.EventList;
import org.newdawn.slick.SlickException;

/**
 * Class using the singleton pattern and managing the time
 */

public class Clock {

    private double time;
    private int hour = 5000;

    /**
     * Default constructor and initialize the time to zero
     */
    private Clock() {
        this.time = 0;
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
     *
     * @return The current time
     */
    static public double getTime() {
        return instance.time;
    }

    /**
     * Add t milliseconds to the current time
     *
     * @param t The number of milliseconds to add
     */
    static public void addTime(double t) throws SlickException {
        instance.time += t;
        EventList.run();
    }

    /**
     * Check if it is the night
     *
     * @return True if it is the night
     */
    static public boolean isNight() {
        return (instance.time / instance.hour % 8 > 4);
    }

    @Override
    public String toString() {
        return "" + instance.time;
    }

}
