package hud;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hud {

    protected String nomHud;
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

    public String getNomHud() {
        return nomHud;
    }

    public Image getImage() {
        return image;
    }

    public Hud(String nomHud, Image image, int positionX, int positionY) throws SlickException {
        this.nomHud = nomHud;
        this.image = image;
        this.positionX = positionX;
        this.positionY = positionY;
        this.visible = true;
    }

    public void render(Graphics g) {
        g.resetTransform();
        if (isVisible())
            g.drawImage(this.image, positionX, positionY);
    }

}
