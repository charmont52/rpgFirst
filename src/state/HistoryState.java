package state;

import java.util.LinkedList;

public class HistoryState {

    private LinkedList<StateID> allState = new LinkedList();

    private HistoryState() {
        allState.add(StateID.STARTPAGE);
    }

    private final static HistoryState instance = new HistoryState();

    public static HistoryState getInstance() {
        return instance;
    }

    public static void addState(StateID stateID) {
        getInstance().allState.add(stateID);
    }

    public static StateID getLastState() {
        return getInstance().allState.getLast();
    }

    public static boolean contains(StateID stateID) {
        return getInstance().allState.contains(stateID);
    }

}
