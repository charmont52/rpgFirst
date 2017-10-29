package controller;

import character.Bot;
import character.Player;
import map.Direction;

/**
 * Class for the bot control
 */
public class BotController {

    private Bot bot;

    public BotController(Bot bot) {
        this.bot = bot;
    }

    /**
     * Move the bot
     */
    public void move() {
        bot.setMoving(true);
        double random = 4 * Math.random();
        switch (bot.getBehaviour()) {
            case RANDOM:
                moveRandom(random);
                break;
            case AGRESSIVE:
                moveAgressive();
                break;
        }
    }

    private void moveRandom(double random) {
        if (random < 1) {
            bot.setDirection(Direction.NORTH);
        } else if (random < 2) {
            bot.setDirection(Direction.WEST);
        } else if (random < 3) {
            bot.setDirection(Direction.SOUTH);
        } else if (random < 4) {
            bot.setDirection(Direction.EAST);
        }
    }

    private void moveAgressive() {
        float xPlayer = Player.getInstance().getX();
        float yPlayer = Player.getInstance().getY();
        float marge = 2;
        bot.setMoving(false);
        double distanceWithPlayer = Math.sqrt(Math.pow(xPlayer - bot.getX(), 2) + Math.pow(yPlayer - bot.getY(), 2));
        if (distanceWithPlayer < 140 && distanceWithPlayer > 32) {
            bot.setMoving(true);
            if (xPlayer + marge < bot.getX()) {
                bot.setDirection(Direction.WEST);
            } else if (xPlayer - marge > bot.getX()) {
                bot.setDirection(Direction.EAST);
            } else if (yPlayer + marge < bot.getY()) {
                bot.setDirection(Direction.NORTH);
            } else if (yPlayer - marge > bot.getY()) {
                bot.setDirection(Direction.SOUTH);
            }
        }
        if (distanceWithPlayer < 37) {
            bot.addAtkCount(1);
            if (bot.getAtkCount() == 1) {
                bot.setAtkable(true);
                bot.setInfligeableDamage(true);
            } else {
                if (bot.getAtkCount() == 70) {
                    bot.setAtkCount(0);
                }
            }
        }
    }

}
