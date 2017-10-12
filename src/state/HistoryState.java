package state;

import java.util.LinkedList;

/**
 * Class using the singleton pattern and saving the state history
 */
public class HistoryState {

    private LinkedList<StateID> allState = new LinkedList();

    private HistoryState() {
        allState.add(StateID.STARTPAGE);
    }

    private final static HistoryState instance = new HistoryState();

    /**
     * Get the history state instance
     *
     * @return The history state instance
     */
    public static HistoryState getInstance() {
        return instance;
    }

    /**
     * Add a state in the history state
     *
     * @param stateID The state ID to add in the history state
     */
    public static void addState(StateID stateID) {
        getInstance().allState.add(stateID);
    }

    /**
     * Get the last state in the history state
     *
     * @return The last state
     */
    public static StateID getLastState() {
        return getInstance().allState.getLast();
    }

    /**
     * Check if a specific state ID is in the history state
     *
     * @param stateID The state ID
     * @return True if the history state contains this state ID
     */
    public static boolean contains(StateID stateID) {
        return getInstance().allState.contains(stateID);
    }

}
