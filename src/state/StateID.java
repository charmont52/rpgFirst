package state;

/**
 * Class containing the stateID with explicit name
 */
public enum StateID {
    GAME, OPTIONS, STARTPAGE;

    /**
     * Convert the stateID name to a stateID number
     * @param stateID The stateID name
     * @return The stateID number
     */
    public static int getStateIDNumber(StateID stateID) {
        switch (stateID) {
            case GAME:
                return 2;
            case OPTIONS:
                return 3;
            case STARTPAGE:
                return 1;
            default:
                return 1;
        }
    }

}
