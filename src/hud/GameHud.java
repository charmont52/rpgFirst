package hud;

import command.GameCommand;
import controller.GameController;
import graphics.Bar;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundEffect;

public class GameHud implements ComponentListener {

    private GameController controller;
    private MouseOverArea homePageButton;
    private MouseOverArea inventoryButton;

    public GameHud(GameController controller) {
        this.controller = controller;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Image buttonImage = new Image("src/ressources/hud/littleButton.png");
        homePageButton = new MouseOverArea(container, buttonImage, container.getWidth() - 5 - buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
        inventoryButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - 2*buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Image backgroundUI = new Image("src/ressources/hud/background.png");
        g.fillRect(0,container.getHeight()-70,container.getWidth(),70,backgroundUI,0,0);
        g.setColor(Color.black);
        g.drawLine(0,container.getHeight()-70,container.getWidth(),container.getHeight()-70);
        homePageButton.render(container, g);
        drawCenterString(homePageButton,"Menu",g);
        inventoryButton.render(container, g);
        drawCenterString(inventoryButton, "Sac", g);
        Bar.drawLifeBarPlayer(container, g);
        Bar.drawManaBarPlayer(container, g);
    }

    private void drawCenterString(MouseOverArea area, String s, Graphics g) {
        g.drawString(s,area.getX() + area.getWidth()/2 - g.getFont().getWidth(s)/2,area.getY() + area.getHeight()/2 - g.getFont().getHeight(s)/2);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == homePageButton) {
            controller.controlPressed(GameCommand.STARTPAGE);
        } else if (source == inventoryButton) {
            controller.controlPressed(GameCommand.INVENTORY);
        }
    }

}
