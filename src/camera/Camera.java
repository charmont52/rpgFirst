package camera;

import character.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Camera {

    private Player player;
    private float xCamera, yCamera;

    public Camera(Player player) {
        this.player = player;
        this.xCamera = player.getX();
        this.yCamera = player.getY();
    }

    public void place(GameContainer container, Graphics g) {
        g.translate(container.getWidth() / 2 - (int) this.xCamera,container.getHeight() / 2 - (int) this.yCamera);
    }

    public void update(GameContainer container) {
        //if (!container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            int w = container.getWidth() / 4;
            if (this.player.getX() > this.xCamera + w && this.xCamera + 2*w < this.player.getMap().getWidth()*this.player.getMap().getTileWidth()) {
                this.xCamera = this.player.getX() - w;
            } else if (this.player.getX() < this.xCamera - w && this.xCamera - 2*w >= 0) {
                this.xCamera = this.player.getX() + w;
            }
            int h = container.getHeight() / 4;
            int heightMenu = 35;
            if (this.player.getY() > this.yCamera + h - heightMenu && this.yCamera + 2*(h - heightMenu) < this.player.getMap().getHeight()*this.player.getMap().getTileHeight()) {
                this.yCamera = this.player.getY() - (h - heightMenu);
            } else if (this.player.getY() < this.yCamera - h && this.yCamera - 2*h > 0) {
                this.yCamera = this.player.getY() + h;
            }
        //}
    }

}
