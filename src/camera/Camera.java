package camera;

import character.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Class managing the camera
 */
public class Camera {

    private Player player;
    private float x;
    private float y;

    /**
     * Default constructor
     */
    public Camera() {
        this.player = Player.getInstance();
        this.x = player.getX();
        this.y = player.getY();
    }

    /**
     * Get the camera abscissa
     *
     * @return The camera abscissa
     */
    public float getX() {
        return x;
    }

    /**
     * Set the abscissa camera
     *
     * @param x The new camera abscissa
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get the camera ordered
     *
     * @return The camera ordered
     */
    public float getY() {
        return y;
    }

    /**
     * Set the camera ordered
     *
     * @param y The new camera ordered
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Place correctly the camera with the position player
     *
     * @param container The current game container
     * @param g         The current graphics context
     */
    public void place(GameContainer container, Graphics g) {
        g.translate(container.getWidth() / 2 - (int) this.x, container.getHeight() / 2 - (int) this.y);
    }

    /**
     * Update the camera position
     *
     * @param container The current game container
     */
    public void update(GameContainer container) {
        int w = container.getWidth() / 4;
        if (this.player.getX() > this.x + w && this.x + 2 * w < this.player.getMap().getWidth()) {
            this.x = this.player.getX() - w;
        } else if (this.player.getX() < this.x - w && this.x - 2 * w >= 0) {
            this.x = this.player.getX() + w;
        }
        int h = container.getHeight() / 4;
        int heightMenu = 35;
        if (this.player.getY() > this.y + h - heightMenu && this.y + 2 * (h - heightMenu) < this.player.getMap().getHeight()) {
            this.y = this.player.getY() - (h - heightMenu);
        } else if (this.player.getY() < this.y - h && this.y - 2 * h > 0) {
            this.y = this.player.getY() + h;
        }
    }

    private double getSpeed(GameContainer container) {
        double distance = Math.sqrt(Math.pow(player.getX() - (container.getWidth() / 2 - (int) this.x), 2) + Math.pow(player.getY() - y, 2));
        System.out.println(distance);
        return distance;
    }

}
