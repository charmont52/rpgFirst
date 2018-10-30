package controller;

import character.Bot;
import character.Player;
import map.Direction;
import map.Distance;
import map.Map;

/**
 * Class for the bot control
 */
public class BotController {

    private Bot bot;
    private boolean unlimitedMove;
    // TO DO : upgrade the movement
    private boolean goNorth;
    private boolean goSouth;
    private boolean goWest;
    private boolean goEast;


    public BotController(Bot bot) {
        this.bot = bot;
        this.unlimitedMove = false;
        setLastDir(bot.getDirection());
    }

    private void setLastDir(Direction direction) {
        bot.setDirection(direction);
        goEast = false;
        goWest = false;
        goNorth = false;
        goSouth = false;
        switch (direction) {
            case SOUTH:
                goSouth = true;
                break;
            case NORTH:
                goNorth = true;
                break;
            case EAST:
                goEast = true;
                break;
            case WEST:
                goWest = true;
                break;
        }
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
        double marge = 0.1;
        int distColl = 20;
        double distAggro = 2.2;
        double distAggroMax = 10;
        double lebensraum = 0.5;
        bot.setMoving(false);
        double distanceWithPlayer = Distance.getRadius(Player.getInstance(), bot);
        // Disable the unlimited move mode if the bot is too near of player
        if (distanceWithPlayer < distAggro) {
            this.unlimitedMove = false;
        }
        if (unlimitedMove) {
            if (distanceWithPlayer < distAggroMax) {
                distanceWithPlayer = 1;
            } else {
                // Disable the unlimited move mode if the bot is too far of player
                unlimitedMove = false;
            }
        }
        if (distanceWithPlayer < distAggro && distanceWithPlayer > lebensraum) {
            bot.setMoving(true);

            if (marge < Distance.pixelToMeter(bot.getX() - xPlayer)) {
                if (!Map.getInstance().isCollision(bot.getX() - distColl, bot.getY())) {
                    bot.setDirection(Direction.WEST);
                } else {
                    unlimitedMove = true;
                    if (!Map.getInstance().isCollision(bot.getX(), bot.getY() - distColl)) {
                        bot.setDirection(Direction.NORTH);
                    } else if (!Map.getInstance().isCollision(bot.getX(), bot.getY() + distColl)) {
                        bot.setDirection(Direction.SOUTH);
                    }
                }
            } else if (Distance.pixelToMeter(xPlayer - bot.getX()) > marge) {
                if (!Map.getInstance().isCollision(bot.getX() + distColl, bot.getY())) {
                    bot.setDirection(Direction.EAST);
                } else {
                    unlimitedMove = true;
                    if (!Map.getInstance().isCollision(bot.getX(), bot.getY() - distColl)) {
                        bot.setDirection(Direction.NORTH);
                    } else if (!Map.getInstance().isCollision(bot.getX(), bot.getY() + distColl)) {
                        bot.setDirection(Direction.SOUTH);
                    }
                }
            } else if (marge < Distance.pixelToMeter(bot.getY() - yPlayer)) {
                if (!Map.getInstance().isCollision(bot.getX(), bot.getY() - distColl)) {
                    bot.setDirection(Direction.NORTH);
                } else {
                    unlimitedMove = true;
                    if (!Map.getInstance().isCollision(bot.getX() - distColl, bot.getY())) {
                        bot.setDirection(Direction.WEST);
                    } else if (!Map.getInstance().isCollision(bot.getX() + distColl, bot.getY())) {
                        bot.setDirection(Direction.EAST);
                    }
                }
            } else if (Distance.pixelToMeter(yPlayer - bot.getY()) > marge) {
                if (!Map.getInstance().isCollision(bot.getX(), bot.getY() + distColl)) {
                    bot.setDirection(Direction.SOUTH);
                } else {
                    unlimitedMove = true;
                    if (!Map.getInstance().isCollision(bot.getX() - distColl, bot.getY())) {
                        bot.setDirection(Direction.WEST);
                    } else if (!Map.getInstance().isCollision(bot.getX() + distColl, bot.getY())) {
                        bot.setDirection(Direction.EAST);
                    }
                }
            }
        }
        if (distanceWithPlayer < 0.6) {
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
