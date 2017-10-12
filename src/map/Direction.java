package map;

/**
 * Class containing the direction ID with explicit name
 */
public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    /**
     * Convert the direction name to a direction number
     *
     * @param direction The direction name
     * @return The direction number
     */
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
