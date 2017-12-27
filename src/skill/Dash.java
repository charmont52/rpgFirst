package skill;

import character.Character;
import map.Direction;
import map.Map;

public class Dash extends Skill {

    private int width;

    public Dash(Character character) {
        super(character);
        setManaCost(1);
        setLifeCost(0);
        this.width = 100;
    }

    @Override
    public void use() {
        super.use();
        if (isCastable()) {
            boolean casted = false;
            Direction direction = getCharacter().getDirection();
            float x = getCharacter().getX();
            float y = getCharacter().getY();
            switch (direction) {
                case NORTH:
                    y = y - width;
                    if (y >= 0 && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setY(y);
                        casted = true;
                    }
                    break;
                case SOUTH:
                    y = y + width;
                    if (y <= Map.getInstance().getHeight() && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setY(y);
                        casted = true;
                    }
                    break;
                case EAST:
                    x = x + width;
                    if (x <= Map.getInstance().getWidth() && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setX(x);
                        casted = true;
                    }
                    break;
                case WEST:
                    x = x - width;
                    if (x >= 0 && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setX(x);
                        casted = true;
                    }
                    break;
            }
            if (casted) {
                getCharacter().getStats().addCurrentMana(-getManaCost());
            }
        }
    }

    @Override
    public String toString() {
        return "dash";
    }

}
