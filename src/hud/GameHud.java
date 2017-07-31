package hud;

import command.GameCommand;
import controller.GameController;
import graphics.Area;
import graphics.Bar;
import graphics.Text;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundEffect;

public class GameHud implements ComponentListener {

    private GameController controller;
    private MouseOverArea startPageButton;
    private MouseOverArea inventoryButton;
    private MouseOverArea statsPlayerButton;
    private boolean statsPlayerDisplay;

    public GameHud(GameController controller) {
        this.controller = controller;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Image buttonImage = new Image("src/ressources/hud/littleButton.png");
        startPageButton = new MouseOverArea(container, buttonImage, container.getWidth() - 5 - buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
        inventoryButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - 2 * buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
        statsPlayerButton = new MouseOverArea(container, buttonImage, container.getWidth() - 15 - 3 * buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
        statsPlayerDisplay = false;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Image backgroundUI = new Image("src/ressources/hud/background.png");
        g.fillRect(0, container.getHeight() - 70, container.getWidth(), 70, backgroundUI, 0, 0);
        g.setColor(Color.black);
        g.drawLine(0, container.getHeight() - 70, container.getWidth(), container.getHeight() - 70);
        startPageButton.render(container, g);
        Text.drawCenterString(startPageButton, "Menu", g);
        inventoryButton.render(container, g);
        Text.drawCenterString(inventoryButton, "Sac", g);
        statsPlayerButton.render(container, g);
        Text.drawCenterString(statsPlayerButton, "Stats", g);
        Bar.drawLifeBarPlayer(container, g);
        Bar.drawManaBarPlayer(container, g);
        if (statsPlayerDisplay) {
            int width = 200;
            int height = 300;
            g.fillRect(container.getWidth() / 2 - width / 2, container.getHeight() / 2 - height / 2, width, height, backgroundUI, 0, 0);
            Area.drawOutline(g,container,container.getWidth() / 2 - width / 2,container.getHeight() / 2 - height / 2, width, height);
        }
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == startPageButton) {
            controller.controlPressed(GameCommand.STARTPAGE);
        } else if (source == inventoryButton) {
            controller.controlPressed(GameCommand.INVENTORY);
        } else if (source == statsPlayerButton) {
            statsPlayerDisplay = !statsPlayerDisplay;
            controller.controlPressed(GameCommand.STATSPLAYER);
        }
    }

}
