package hud;

import character.Player;
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

/**
 * Hud about the game page
 */
public class GameHud implements ComponentListener {

    private GameController controller;
    private MouseOverArea startPageButton;
    private MouseOverArea inventoryButton;
    private MouseOverArea statsPlayerButton;
    private Image backgroundUI;
    private boolean statsDisplay;
    private boolean inventoryDisplay;

    /**
     * The unique Constructor
     *
     * @param controller Controller for the game page
     */
    public GameHud(GameController controller) {
        this.controller = controller;
        statsDisplay = false;
        inventoryDisplay = false;
    }

    /**
     * Init the hud
     *
     * @param container Container
     * @param game      Game
     * @throws SlickException
     */
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        backgroundUI = new Image("src/ressources/hud/background.png");
        Image buttonImage = new Image("src/ressources/hud/littleButton.png");
        startPageButton = new MouseOverArea(container, buttonImage, container.getWidth() - 5 - buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
        inventoryButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - 2 * buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
        statsPlayerButton = new MouseOverArea(container, buttonImage, container.getWidth() - 15 - 3 * buttonImage.getWidth(), container.getHeight() - buttonImage.getHeight() - 5, this);
    }

    /**
     * Render the hud
     *
     * @param container Container
     * @param g         Graphics
     * @throws SlickException
     */
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.fillRect(0, container.getHeight() - 70, container.getWidth(), 70, backgroundUI, 0, 0);
        g.setColor(Color.black);
        g.drawLine(0, container.getHeight() - 70, container.getWidth(), container.getHeight() - 70);
        startPageButton.render(container, g);
        Text.drawCenterString(g, startPageButton, "Menu");
        inventoryButton.render(container, g);
        Text.drawCenterString(g, inventoryButton, "Sac");
        statsPlayerButton.render(container, g);
        Text.drawCenterString(g, statsPlayerButton, "Stats");
        Bar.drawLifeBarPlayer(container, g);
        Bar.drawManaBarPlayer(container, g);
        Bar.drawXpBarPlayer(container, g);
        drawStats(container, g);
        drawInventory(container, g);
    }

    private void drawStats(GameContainer container, Graphics g) throws SlickException {
        if (statsDisplay) {
            int width = 200;
            int height = 300;
            int x = container.getWidth() / 2 - width / 2;
            int y = container.getHeight() / 2 - height / 2;
            drawWindow(container, g, "Stats");

            int d = 30;
            Text.drawAlignString(g, "Level :", "" + Player.getInstance().getLevel(), x + d, y + 80, width - 2 * d);
            Text.drawAlignString(g, "Life :", "" + Player.getInstance().getStats().getLifeMax(), x + d, y + 100, width - 2 * d);
            Text.drawAlignString(g, "Mana :", "" + Player.getInstance().getStats().getManaMax(), x + d, y + 120, width - 2 * d);
            Text.drawAlignString(g, "Damage :", "" + Player.getInstance().getStats().getInfligeableDamage(), x + d, y + 140, width - 2 * d);
            Text.drawAlignString(g, "Reduction :", "" + Player.getInstance().getStats().getDamageReduction(), x + d, y + 160, width - 2 * d);
        }
    }

    private void drawInventory(GameContainer container, Graphics g) throws SlickException {
        if (inventoryDisplay) {
            drawWindow(container, g, "Sac");
        }
    }

    private void drawWindow(GameContainer container, Graphics g, String title) throws SlickException {
        int width = 200;
        int height = 300;
        int x = container.getWidth() / 2 - width / 2;
        int y = container.getHeight() / 2 - height / 2;
        g.fillRect(x, y, width, height, backgroundUI, 0, 0);
        Area.drawOutline(g, container, x, y, width, height);
        Text.drawCenterString(g, title, x, y, width, 100);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == startPageButton) {
            controller.controlPressed(GameCommand.STARTPAGE);
        } else if (source == inventoryButton) {
            inventoryDisplay = !inventoryDisplay;
            if (!statsDisplay) {
                controller.controlPressed(GameCommand.INVENTORY);
            } else {
                statsDisplay = false;
            }
        } else if (source == statsPlayerButton) {
            statsDisplay = !statsDisplay;
            if (!inventoryDisplay) {
                controller.controlPressed(GameCommand.STATSPLAYER);
            } else {
                inventoryDisplay = false;
            }
        }
    }

}
