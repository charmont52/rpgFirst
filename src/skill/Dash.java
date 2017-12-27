package skill;

import character.Character;
import map.Direction;
import map.Map;
import org.newdawn.slick.*;

public class Dash extends Skill {

    public Dash(Character character) {
        super(character);
        setManaCost(1);
        setLifeCost(0);
        setRange(100);
    }

    @Override
    public void use(Graphics g) {
        super.use(g);
        if (isCastable()) {
            boolean casted = false;
            Direction direction = getCharacter().getDirection();
            float x = getCharacter().getX();
            float y = getCharacter().getY();
            switch (direction) {
                case NORTH:
                    y = y - getRange();
                    if (y >= 0 && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setY(y);
                        casted = true;
                    }
                    break;
                case SOUTH:
                    y = y + getRange();
                    if (y <= Map.getInstance().getHeight() && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setY(y);
                        casted = true;
                    }
                    break;
                case EAST:
                    x = x + getRange();
                    if (x <= Map.getInstance().getWidth() && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setX(x);
                        casted = true;
                    }
                    break;
                case WEST:
                    x = x - getRange();
                    if (x >= 0 && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setX(x);
                        casted = true;
                    }
                    break;
            }
            if (casted) {
                getCharacter().getStats().addCurrentMana(-getManaCost());
            }
            setUsed(false);
        }
    }

    @Override
    public String toString() {
        return "dash";
    }

}
