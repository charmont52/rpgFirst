package controller;

import command.GameCommand;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundEffect;
import state.GameState;
import state.HistoryState;
import state.StartPageState;
import state.StateID;

/**
 * Class for the game control
 */
public class GameController implements InputProviderListener, KeyListener {

    private StateBasedGame game;
    private GameState gameState;
    private GameCommand mode = GameCommand.NONE;

    /**
     * Constructor
     *
     * @param game      The state based game
     * @param gameState The game state
     */
    public GameController(StateBasedGame game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
    }

    @Override
    public void controlPressed(Command command) {
        this.mode = (GameCommand) command;
        switch (mode) {
            case STARTPAGE:
                SoundEffect.stopAll();
                game.enterState(StartPageState.ID);
                break;
            case INVENTORY:
                gameState.setPause(!gameState.isPause());
                break;
            case STATSPLAYER:
                gameState.setPause(!gameState.isPause());
                break;
            case PAUSE:
                gameState.setPause(!gameState.isPause());
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
            case Input.KEY_ESCAPE:
                SoundEffect.stopAll();
                HistoryState.addState(StateID.STARTPAGE);
                game.enterState(StartPageState.ID);
                break;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        switch (key) {
        }
    }

}
