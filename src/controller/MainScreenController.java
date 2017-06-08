package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;
import command.*;
import state.MapGameState;

public class MainScreenController implements InputProviderListener {

    private StateBasedGame game;
    private GameContainer container;
    private MainScreenCommand mode = MainScreenCommand.NONE;

    public MainScreenController(StateBasedGame game, GameContainer container) {
        this.game = game;
        this.container = container;
    }

    @Override
    public void controlPressed(Command command) {
        this.mode = (MainScreenCommand) command;
        switch (mode) {
            case START:
                game.enterState(MapGameState.ID);
                break;
            case OPTIONS:
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
