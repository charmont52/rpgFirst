package map;

import character.Character;

/**
 * Class using the singleton pattern and managing the distance
 */
public class Distance {

    // ratio = pixels/meter
    private double ratio = 70;

    private Distance() {
    }

    private final static Distance instance = new Distance();

    public static Distance getInstance() {
        return instance;
    }

    /**
     * Convert the distance in pixel
     *
     * @param distance the distance in meter
     * @return the distance in pixel
     */
    public static int meterToPixel(double distance) {
        return (int) Math.floor(distance * instance.ratio);
    }

    /**
     * Convert the distance in meter
     *
     * @param distance the distance in pixel
     * @return the distance in meter
     */
    public static double pixelToMeter(double distance) {
        return distance / instance.ratio;
    }

    public static double getRadius(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return pixelToMeter(distance);
    }

    public static double getRadius(Character character, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(character.getX() - x2, 2) + Math.pow(character.getY() - y2, 2));
        return pixelToMeter(distance);
    }

    /**
     * Euclidian distance
     *
     * @param character1 the first character
     * @param character2 the second character
     * @return the euclidian distance between two characters
     */
    public static double getRadius(Character character1, Character character2) {
        double distance = Math.sqrt(Math.pow(character1.getX() - character2.getX(), 2) + Math.pow(character1.getY() - character2.getY(), 2));
        return pixelToMeter(distance);
    }

    /**
     * Manhattan distance
     *
     * @param character1 the first character
     * @param character2 the second character
     * @return the Manhattan distance between two characters
     */
    public static double getSquare(Character character1, Character character2) {
        double distance = Math.abs(character1.getX() - character2.getX()) + Math.abs(character1.getY() - character2.getY());
        return pixelToMeter(distance);
    }

}
