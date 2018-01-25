package camera;

import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Class managing the camera, the camera position is in the left top corner
 */
public class Camera {

    private Player player;
    private int x;
    private int y;

    /**
     * Default constructor
     */
    public Camera() {
        this.player = Player.getInstance();
        this.x = (int) player.getX();
        this.y = (int) player.getY();
    }

    /**
     * Get the camera abscissa
     *
     * @return The camera abscissa
     */
    public int getX() {
        return x;
    }

    /**
     * Set the abscissa camera
     *
     * @param x The new camera abscissa
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the camera ordered
     *
     * @return The camera ordered
     */
    public int getY() {
        return y;
    }

    /**
     * Set the camera ordered
     *
     * @param y The new camera ordered
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Place correctly the camera with the position player
     *
     * @param container The current game container
     * @param g         The current graphics context
     */
    public void place(GameContainer container, Graphics g) {
        g.translate(-x, -y);
    }

    /**
     * Update the camera position
     *
     * @param container The current game container
     */
    public void update(GameContainer container) {
        int w = container.getWidth() / 4;

        if (x + 3 * w < player.getX()) {
            x = (int) player.getX() - 3 * w;
        } else if (player.getX() < x + w) {
            x = (int) player.getX() - w;
        }

        int h = container.getHeight() / 4;
        int heightMenu = 70;

        if (y + 3 * h - heightMenu < player.getY()) {
            y = (int) player.getY() - 3 * h + heightMenu;
        } else if (player.getY() < y + h) {
            y = (int) player.getY() - h;
        }

        x = Math.max(x, 0);
        x = Math.min(x, this.player.getMap().getWidth() - container.getWidth());
        y = Math.max(y, 0);
        y = Math.min(y, player.getMap().getHeight() - container.getHeight() + heightMenu);
    }

    private int getDistance() {
        return (int) Math.sqrt(Math.pow(player.getX() - x, 2) + Math.pow(player.getY() - y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
