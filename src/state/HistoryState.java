package state;

import org.lwjgl.Sys;

import java.util.LinkedList;

public class HistoryState {

    private LinkedList allState = new LinkedList();

    private HistoryState() {
        allState.add(0);
    }

    private final static HistoryState instance = new HistoryState();

    public static HistoryState getInstance() {
        return instance;
    }

    public void addState(int lastState) {
        this.allState.add(lastState);
    }

    public int getLastState() {
        return (int) allState.getLast();
    }

}
