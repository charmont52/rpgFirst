package character;

import map.Direction;
import map.Map;

public class Dash extends Skill {

    private int width;

    public Dash(Character character) {
        super(character);
        setManaCost(2);
        setLifeCost(0);
        this.width = 80;
    }

    @Override
    public void use() {
        super.use();
        if (isCastable()) {
            //getCharacter().getStats().setCurrentMana(getCharacter().getStats().getCurrentMana() - getManaCost());
            Direction direction = getCharacter().getDirection();
            float x = getCharacter().getX();
            float y = getCharacter().getY();
            switch (direction) {
                case NORTH:
                    y = y - width;
                    if (y >= 0 && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setY(y);
                    }
                    break;
                case SOUTH:
                    y = y + width;
                    if (y <= Map.getInstance().getHeight() * Map.getInstance().getTileHeight() && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setY(y);
                    }
                    break;
                case EAST:
                    x = x + width;
                    if (x <= Map.getInstance().getWidth() * Map.getInstance().getTileWidth() && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setX(x);
                    }
                    break;
                case WEST:
                    x = x - width;
                    if (x >= 0 && !Map.getInstance().isCollision(x, y)) {
                        getCharacter().setX(x);
                    }
                    break;
            }


        }
    }

    @Override
    public String toString() {
        return "dash";
    }

}
