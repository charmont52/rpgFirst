package event;

import org.newdawn.slick.SlickException;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class using the singleton pattern and managing the events set
 */
public class EventList {

    private static LinkedList<Event> eventList;

    private final static EventList instance = new EventList();

    private EventList() {
        this.eventList = new LinkedList<>();
    }

    public static EventList getInstance() {
        return instance;
    }

    public Iterator<Event> iterator() {
        return eventList.iterator();
    }

    /**
     * Add a new event to the list
     *
     * @param event The new event
     */
    public static void add(Event event) {
        eventList.add(event);
    }

    /**
     * Remove the event to the list
     *
     * @param event The removed event
     */
    public static void remove(Event event) {
        eventList.remove(event);
    }

    /**
     * Run the events set
     *
     * @throws SlickException
     */
    public static void run() throws SlickException {
        Iterator<Event> iterator = instance.iterator();
        while (iterator.hasNext()) {
            iterator.next().run();
        }
    }

}
