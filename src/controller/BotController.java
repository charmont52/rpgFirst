package controller;

import character.Bot;
import character.Player;

public class BotController {

    private Bot bot;

    public BotController(Bot bot) {
        this.bot = bot;
    }

    public void move() {
        bot.setMoving(true);
        double random = 4 * Math.random();
        switch (bot.getBehaviour()) {
            case RANDOM:
                if (random < 1) {
                    bot.setDirection(0);
                } else if (random < 2) {
                    bot.setDirection(1);
                } else if (random < 3) {
                    bot.setDirection(2);
                } else if (random < 4) {
                    bot.setDirection(3);
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
                            bot.setDirection(1);
                        if (xPlayer > bot.getX())
                            bot.setDirection(3);
                    } else {
                        if (yPlayer < bot.getY())
                            bot.setDirection(0);
                        if (yPlayer > bot.getY())
                            bot.setDirection(2);
                    }
                }
                break;
        }
    }
}
