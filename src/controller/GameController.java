package controller;

import command.MapGameCommand;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;
import state.StartPageState;

public class GameController implements InputProviderListener {

    private StateBasedGame game;
    private GameContainer container;
    private MapGameCommand mode = MapGameCommand.NONE;

    public GameController(StateBasedGame game, GameContainer container) {
        this.game = game;
        this.container = container;
    }

    @Override
    public void controlPressed(Command command) {
        this.mode = (MapGameCommand) command;
        switch (mode) {
            case MAINSCREEN:
                game.enterState(StartPageState.ID);
                break;
            case INVENTORY:
                break;
        }
    }

    @Override
    public void controlReleased(Command command) {

    }
}
