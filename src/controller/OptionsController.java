package controller;

import command.GameCommand;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;
import state.StartPageState;

public class OptionsController implements InputProviderListener {

    private StateBasedGame game;
    private GameContainer container;
    private GameCommand mode = GameCommand.NONE;

    public OptionsController(StateBasedGame game, GameContainer container) {
        this.game = game;
        this.container = container;
    }

    @Override
    public void controlPressed(Command command) {
        this.mode = (GameCommand) command;
        switch (mode) {
            case STARTPAGE:
                game.enterState(StartPageState.ID);
                break;
        }
    }

    @Override
    public void controlReleased(Command command) {
    }

}
