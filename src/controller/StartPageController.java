package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;
import command.*;
import state.GameState;
import state.OptionsState;

/**
 * Class for the start page control
 */
public class StartPageController implements InputProviderListener, KeyListener {

    private StateBasedGame game;
    private GameContainer container;
    private StartPageCommand mode = StartPageCommand.NONE;

    public StartPageController(StateBasedGame game, GameContainer container) {
        this.game = game;
        this.container = container;
    }

    @Override
    public void controlPressed(Command command) {
        this.mode = (StartPageCommand) command;
        switch (mode) {
            case STARTGAME:
                game.enterState(GameState.ID);
                break;
            case OPTIONS:
                game.enterState(OptionsState.ID);
                break;
            case CREDITS:
                break;
            case EXIT:
                container.exit();
                break;
        }
    }

    @Override
    public void controlReleased(Command command) {
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        switch (key) {
        }
    }

}
