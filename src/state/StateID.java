package state;

public enum StateID {
    GAME, OPTIONS, STARTPAGE;

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
