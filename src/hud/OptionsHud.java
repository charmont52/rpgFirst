package hud;

import command.GameCommand;
import controller.OptionsController;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

public class OptionsHud implements ComponentListener {

    private OptionsController controller;
    private MouseOverArea mainScreenButton;
    private Image buttonImage;

    public OptionsHud(OptionsController controller) {
        this.controller = controller;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.buttonImage = new Image("src/ressources/hud/button.png");
        int centreX = container.getWidth()/2 - buttonImage.getWidth()/2;
        int centreY = container.getHeight()/2 - buttonImage.getHeight()/2;
        mainScreenButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - buttonImage.getWidth(), 10, this);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.black);
        mainScreenButton.render(container, g);
        g.drawString("Menu",mainScreenButton.getX() + mainScreenButton.getWidth()/2 - g.getFont().getWidth("Menu")/2,mainScreenButton.getY() + mainScreenButton.getHeight()/2 - g.getFont().getHeight("Menu")/2);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        if (source == mainScreenButton) {
            controller.controlPressed(GameCommand.STARTPAGE);
        }
    }

}
