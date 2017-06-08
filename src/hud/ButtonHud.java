package hud;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class ButtonHud extends Hud implements ComponentListener {

    private MouseOverArea button;
    private String text;

    public MouseOverArea getButton() {
        return button;
    }

    public ButtonHud(String nomHud, Image image, int positionX, int positionY, String text) throws SlickException {
        super(nomHud, image, positionX, positionY);
        this.text = text;
    }

    public void init(GameContainer container) throws SlickException {
        button = new MouseOverArea(container,this.image,positionX, positionY, this);
    }

    public void render(GameContainer container, Graphics g) {
        g.resetTransform();
        g.drawImage(this.image, positionX, positionY);
        g.setColor(Color.black);
        button.render(container,g);
        g.drawString(text,button.getX() + image.getWidth()/3,button.getY() + image.getHeight()/2);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        if (source == button) {

        }
    }

}
