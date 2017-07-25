package map;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static int getDirectionNumber(Direction direction) {
        switch (direction) {
            case NORTH:
                return 0;
            case WEST:
                return 1;
            case SOUTH:
                return 2;
            case EAST:
                return 3;
            default:
                return 2;
        }
    }
}
