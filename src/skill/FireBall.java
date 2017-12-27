package skill;

import character.Character;
import map.Direction;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class FireBall extends Skill {

    private Animation[] animations = new Animation[4];

    public FireBall(Character character) throws SlickException {
        super(character);
        setManaCost(2);
        setLifeCost(0);
        setRange(100);
        SpriteSheet spriteSheet = new SpriteSheet("src/ressources/sprites/fireball.png", 64, 64);
        this.animations[1] = loadAnimation(spriteSheet, 0, 8, 0);
        this.animations[0] = loadAnimation(spriteSheet, 0, 8, 2);
        this.animations[3] = loadAnimation(spriteSheet, 0, 8, 4);
        this.animations[2] = loadAnimation(spriteSheet, 0, 8, 6);
    }

    /**
     * Load the character animation
     *
     * @param spriteSheet The character sprite sheet
     * @param startX      The X start
     * @param endX        The X end
     * @param y           The Y
     * @return The animation
     */
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    @Override
    public void use(Graphics g) {
        super.use(g);
        if (isCastable()) {
            Direction direction = getCharacter().getDirection();
            int x = (int) getCharacter().getX();
            int y = (int) getCharacter().getY();
            switch (direction) {
                case WEST:
                    y -= 50;
                    x = x - 70 - (int) (animations[Direction.getDirectionNumber(direction)].getFrame() * getRange() / 8.0);
                    break;
                case NORTH:
                    x -= 30;
                    y = y - 70 - (int) (animations[Direction.getDirectionNumber(direction)].getFrame() * getRange() / 8.0);
                    break;
                case EAST:
                    y -= 50;
                    x = x + (int) (animations[Direction.getDirectionNumber(direction)].getFrame() * getRange() / 8.0);
                    break;
                case SOUTH:
                    x -= 30;
                    y = y - 20 + (int) (animations[Direction.getDirectionNumber(direction)].getFrame() * getRange() / 8.0);
            }
            g.drawAnimation(animations[Direction.getDirectionNumber(direction)], x, y);
            if (animations[Direction.getDirectionNumber(direction)].getFrame() == animations[Direction.getDirectionNumber(direction)].getFrameCount() - 1) {
                setUsed(false);
                animations[Direction.getDirectionNumber(direction)].restart();
                getCharacter().getStats().addCurrentMana(-getManaCost());
            }
        }
    }

    @Override
    public String toString() {
        return "fireball";
    }

}
