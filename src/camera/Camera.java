package camera;

import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Camera {

    private Player player;
    private float x;
    private float y;

    public Camera(Player player) {
        this.player = player;
        this.x = player.getX();
        this.y = player.getY();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void place(GameContainer container, Graphics g) {
        g.translate(container.getWidth() / 2 - (int) this.x, container.getHeight() / 2 - (int) this.y);
        //System.out.println("(" + x + "," + y + ")");
    }

    public void update(GameContainer container) {
        int w = container.getWidth() / 4;
        if (this.player.getX() > this.x + w && this.x + 2 * w < this.player.getMap().getWidth() * this.player.getMap().getTileWidth()) {
            this.x = this.player.getX() - w;
        } else if (this.player.getX() < this.x - w && this.x - 2 * w >= 0) {
            this.x = this.player.getX() + w;
        }
        int h = container.getHeight() / 4;
        int heightMenu = 35;
        if (this.player.getY() > this.y + h - heightMenu && this.y + 2 * (h - heightMenu) < this.player.getMap().getHeight() * this.player.getMap().getTileHeight()) {
            this.y = this.player.getY() - (h - heightMenu);
        } else if (this.player.getY() < this.y - h && this.y - 2 * h > 0) {
            this.y = this.player.getY() + h;
        }
    }

}
