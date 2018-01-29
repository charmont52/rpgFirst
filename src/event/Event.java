package event;

import org.newdawn.slick.SlickException;
import state.Clock;

/**
 * A pattern to manage the different events
 */
public class Event {

    private boolean runable;
    private int latency;
    private int lastInstanciation;

    /**
     * Default constructor
     */
    public Event(int latency) {
        this.runable = false;
        this.latency = latency;
        this.lastInstanciation = (int) Clock.getTime();
    }

    /**
     * Run the event
     *
     * @throws SlickException
     */
    public void run() throws SlickException {
        runable = (Clock.getTime() - lastInstanciation) > latency;
    }

    public boolean isRunable() {
        return runable;
    }

    public void setRunable(boolean runable) {
        this.runable = runable;
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public int getLastInstanciation() {
        return lastInstanciation;
    }

    public void setLastInstanciation(int lastInstanciation) {
        this.lastInstanciation = lastInstanciation;
    }

    public void resetLastInstanciation() {
        lastInstanciation += latency;
    }

}
