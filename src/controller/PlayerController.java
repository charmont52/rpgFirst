package controller;

import character.Player;
import map.Direction;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * Class for the player control
 */
public class PlayerController implements KeyListener {

    private Player player;

    public PlayerController() {
        this.player = Player.getInstance();
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
            case Input.KEY_SPACE:
                this.player.getStats().setCurrentSpeed(0.4f);
                break;
            case Input.KEY_Z:
                if (!player.isAtkable()) {
                    this.player.setDirection(Direction.NORTH);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_Q:
                if (!player.isAtkable()) {
                    this.player.setDirection(Direction.WEST);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_S:
                if (!player.isAtkable()) {
                    this.player.setDirection(Direction.SOUTH);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_D:
                if (!player.isAtkable()) {
                    this.player.setDirection(Direction.EAST);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_ENTER:
                this.player.setAtkable(true);
                this.player.setInfligeableDamage(true);
                this.player.setMoving(false);
                break;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_SPACE:
                this.player.getStats().setCurrentSpeed(0.2f);
                break;
            case Input.KEY_Z:
                if (player.getDirection() == Direction.NORTH)
                    player.setMoving(false);
                break;
            case Input.KEY_Q:
                if (player.getDirection() == Direction.WEST)
                    player.setMoving(false);
                break;
            case Input.KEY_S:
                if (player.getDirection() == Direction.SOUTH)
                    player.setMoving(false);
                break;
            case Input.KEY_D:
                if (player.getDirection() == Direction.EAST)
                    player.setMoving(false);
                break;
        }
    }

}
