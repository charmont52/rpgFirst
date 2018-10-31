package state;

import command.GameCommand;
import command.OptionsCommand;
import controller.OptionsController;
import graphics.BasicWindow;
import graphics.Text;
import hud.OptionsHud;
import org.newdawn.slick.*;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundEffect;

public class OptionsState extends BasicGameState implements ComponentListener {

    public static final int ID = StateID.getStateIDNumber(StateID.OPTIONS);
    private Image background;
    private StateBasedGame game;
    private OptionsController controller;
    private MouseOverArea startPageButton;
    private Image buttonImage;
    private OptionsHud optionsHud;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
        this.background = new Image("src/ressources/background/background29.jpg");
        this.controller = new OptionsController(game);
        InputProvider provider = new InputProvider(container.getInput());
        provider.addListener(controller);
        this.optionsHud = new OptionsHud(controller);
        optionsHud.init(container);
        this.buttonImage = new Image("src/ressources/hud/button.png");
        startPageButton = new MouseOverArea(container, buttonImage, container.getWidth() - 10 - buttonImage.getWidth(), 10, this);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.draw(0, 0, container.getWidth(), container.getHeight());
        startPageButton.render(container, g);
        Text.drawCenterString(g, startPageButton, "Menu");
        optionsHud.render(g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
    }

    @Override
    public void keyReleased(int key, char c) {
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) {
        HistoryState.addState(StateID.OPTIONS);
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == startPageButton) {
            controller.controlPressed(OptionsCommand.STARTPAGE);
        }
    }

}
