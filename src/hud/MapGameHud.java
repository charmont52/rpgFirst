package hud;

import command.MapGameCommand;
import controller.MapGameController;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

public class MapGameHud implements ComponentListener {

    private MapGameController controller;
    private MouseOverArea mainScreenButton;
    private MouseOverArea inventoryButton;
    private Music click;

    public MapGameHud(MapGameController controller) {
        this.controller = controller;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Image buttonImage = new Image("src/ressources/hud/button.png");
        click = new Music("src/ressources/sound/astrub.ogg");
        int centreX = container.getWidth()/2 - buttonImage.getWidth()/2;
        int centreY = container.getHeight()/2 - buttonImage.getHeight()/2;
        mainScreenButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - buttonImage.getWidth(), 10, this);

        inventoryButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - buttonImage.getWidth(), buttonImage.getHeight() + 20, this);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.black);
        mainScreenButton.render(container, g);
        g.drawString("Menu",mainScreenButton.getX() + mainScreenButton.getWidth()/2 - g.getFont().getWidth("Menu")/2,mainScreenButton.getY() + mainScreenButton.getHeight()/2 - g.getFont().getHeight("Menu")/2);
        inventoryButton.render(container, g);
        g.drawString("Inventaire",inventoryButton.getX() + inventoryButton.getWidth()/2 - g.getFont().getWidth("Inventaire")/2,inventoryButton.getY() + inventoryButton.getHeight()/2 - g.getFont().getHeight("Inventaire")/2);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        //click.play();
        if (source == mainScreenButton) {
            controller.controlPressed(MapGameCommand.MAINSCREEN);
        } else if (source == inventoryButton) {
            controller.controlPressed(MapGameCommand.INVENTORY);
        }
    }

}
