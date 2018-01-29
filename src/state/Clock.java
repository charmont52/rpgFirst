package state;

import event.EventList;
import org.newdawn.slick.SlickException;

/**
 * Class using the singleton pattern and managing the time
 */

public class Clock {

    private double time;
    private int hour = 4000;

    /**
     * Default constructor and initialize the time to zero
     */
    private Clock() {
        this.time = hour * 2;
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
     * Get the current hour
     *
     * @return The current hour
     */
    static public int getHour() {
        return (int) (instance.time / instance.hour % 24);
    }

    /**
     * Add t milliseconds to the current time and run the events
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
        return (instance.time / instance.hour % 24 < 7) || (instance.time / instance.hour % 24 > 19);
    }

    @Override
    public String toString() {
        return "time: " + instance.time;
    }

}
