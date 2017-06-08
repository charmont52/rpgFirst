package controller;

import character.Player;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class PlayerController implements KeyListener {

    private Player player;

    public PlayerController(Player player) {
        this.player = player;
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
                this.player.setSpeed(0.4f);
                break;
            case Input.KEY_Z:
                if (!player.isAtkable()) {
                    this.player.setDirection(0);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_Q:
                if (!player.isAtkable()) {
                    this.player.setDirection(1);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_S:
                if (!player.isAtkable()) {
                    this.player.setDirection(2);
                    this.player.setMoving(true);
                }
                break;
            case Input.KEY_D:
                if (!player.isAtkable()) {
                    this.player.setDirection(3);
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
                this.player.setSpeed(0.2f);
                break;
            case Input.KEY_Z:
                if (player.getDirection() == 0)
                    player.setMoving(false);
                break;
            case Input.KEY_Q:
                if (player.getDirection() == 1)
                    player.setMoving(false);
                break;
            case Input.KEY_S:
                if (player.getDirection() == 2)
                    player.setMoving(false);
                break;
            case Input.KEY_D:
                if (player.getDirection() == 3)
                    player.setMoving(false);
                break;
        }
    }

}
