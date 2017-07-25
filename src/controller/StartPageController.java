package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;
import command.*;
import state.GameState;
import state.OptionsState;

public class StartPageController implements InputProviderListener {

    private StateBasedGame game;
    private GameContainer container;
    private MainScreenCommand mode = MainScreenCommand.NONE;

    public StartPageController(StateBasedGame game, GameContainer container) {
        this.game = game;
        this.container = container;
    }

    @Override
    public void controlPressed(Command command) {
        this.mode = (MainScreenCommand) command;
        switch (mode) {
            case START:
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

}
