package hud;

import command.GameCommand;
import controller.OptionsController;
import graphics.Text;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundEffect;

/**
 * Hud about the options page
 */
public class OptionsHud implements ComponentListener {

    private OptionsController controller;
    private MouseOverArea startPageButton;
    private Image buttonImage;

    /**
     * The unique Constructor
     *
     * @param controller Controller for the options page
     */
    public OptionsHud(OptionsController controller) {
        this.controller = controller;
    }

    /**
     * Init the hud
     *
     * @param container Container
     * @param game      Game
     * @throws SlickException
     */
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.buttonImage = new Image("src/ressources/hud/button.png");
        startPageButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - buttonImage.getWidth(), 10, this);
    }

    /**
     * Render the hud
     *
     * @param container Container
     * @param game      Game
     * @param g         Graphics
     * @throws SlickException
     */
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        startPageButton.render(container, g);
        Text.drawCenterString(g, startPageButton, "Menu");
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == startPageButton) {
            controller.controlPressed(GameCommand.STARTPAGE);
        }
    }

}
