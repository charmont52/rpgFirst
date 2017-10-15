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
                if (random < 1) {
                    bot.setDirection(Direction.NORTH);
                } else if (random < 2) {
                    bot.setDirection(Direction.WEST);
                } else if (random < 3) {
                    bot.setDirection(Direction.SOUTH);
                } else if (random < 4) {
                    bot.setDirection(Direction.EAST);
                }
                break;
            case AGRESSIVE:
                float xPlayer = Player.getInstance().getX();
                float yPlayer = Player.getInstance().getY();
                bot.setMoving(false);
                if (Math.pow(xPlayer - bot.getX(),2) + Math.pow(yPlayer - bot.getY(),2) < 20000) {
                    bot.setMoving(true);
                    if (random < 2) {
                        if (xPlayer < bot.getX())
                            bot.setDirection(Direction.WEST);
                        if (xPlayer > bot.getX())
                            bot.setDirection(Direction.EAST);
                    } else {
                        if (yPlayer < bot.getY())
                            bot.setDirection(Direction.NORTH);
                        if (yPlayer > bot.getY())
                            bot.setDirection(Direction.SOUTH);
                    }
                }
                break;
        }
    }
}
