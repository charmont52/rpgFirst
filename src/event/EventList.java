package event;

import org.newdawn.slick.SlickException;

import java.util.Iterator;
import java.util.LinkedList;

public class EventList {

    private LinkedList<Event> eventList = new LinkedList<>();

    private final static EventList instance = new EventList();

    private EventList() {

    }

    public static EventList getInstance() {
        return instance;
    }

    public Iterator<Event> iterator() {
        return eventList.iterator();
    }

    public void add(Event event) {
        eventList.add(event);
    }

    public static void run() throws SlickException {
        Iterator<Event> iterator = instance.iterator();
        while (iterator.hasNext()) {
            iterator.next().run();
        }
    }

}
