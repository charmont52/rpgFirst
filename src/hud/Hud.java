package hud;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hud {

    protected String name;
    protected Image image;
    protected int positionX;
    protected int positionY;
    protected boolean visible;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Hud(String name, Image image, int positionX, int positionY) throws SlickException {
        this.name = name;
        this.image = image;
        this.positionX = positionX;
        this.positionY = positionY;
        this.visible = true;
    }

    public void render(Graphics g) {
        g.resetTransform();
        if (this.visible)
            g.drawImage(this.image, positionX, positionY);
    }

}
