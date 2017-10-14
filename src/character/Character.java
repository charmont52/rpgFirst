package character;

import map.Direction;
import map.Map;
import org.newdawn.slick.*;
import sound.SoundEffect;

import java.util.Iterator;

/**
 * Father class for any character
 */
public class Character {

    protected float x = 500, y = 500;
    protected Animation[] animationsWalk = new Animation[8];
    protected Direction direction = Direction.SOUTH;
    protected Direction lastDirection = Direction.SOUTH;
    protected boolean moving = false;
    protected Map map;
    private boolean onStair;
    protected float speed = 0.2f;
    protected String sprite;
    protected String nameMap;
    protected boolean atkable = false;
    protected boolean infligeableDamage = false;
    protected int lifeMax = 4;
    protected int currentLife = 4;
    protected int manaMax = 4;
    protected int currentMana = 3;
    protected boolean lifeVisible = true;

    /**
     * Constructor for Character
     *
     * @param map    Map where character is instanced
     * @param x      Abscissa where character is instanced
     * @param y      Ordered where character is instanced
     * @param sprite File containing the sprite character
     */
    public Character(Map map, float x, float y, String sprite) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    /**
     * Get the character map
     *
     * @return The character map
     */
    public Map getMap() {
        return this.map;
    }

    /**
     * Get the character abscissa
     *
     * @return The character abscissa
     */
    public float getX() {
        return x;
    }

    /**
     * Set the character abscissa
     *
     * @param x The new abscissa
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get the character ordered
     *
     * @return The character ordered
     */
    public float getY() {
        return y;
    }

    /**
     * Set the character ordered
     *
     * @param y The new ordered
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Get the character explicit direction
     *
     * @return The character explicit direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Set the character explicit direction
     *
     * @param direction The new character explicit direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Check if the character is moving
     *
     * @return True if the character is moving
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * Set if the character is moving
     *
     * @param moving True if the character needs to move
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * Check if the character is on stair
     *
     * @return True if the character is on stair
     */
    public boolean isOnStair() {
        return onStair;
    }

    /**
     * Set if the character is on stair
     *
     * @param onStair True if the character is on stair
     */
    public void setOnStair(boolean onStair) {
        this.onStair = onStair;
    }

    /**
     * Get the character speed
     *
     * @return The character speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Set the character speed
     *
     * @param speed The new character speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }


    public String getNameMap() {
        return nameMap;
    }

    public void setNameMap(String nameMap) {
        this.nameMap = nameMap;
    }

    public String getSprite() {
        return this.sprite;
    }

    public void setAtkable(boolean atkable) {
        this.atkable = atkable;
    }

    public boolean isAtkable() {
        return this.atkable;
    }

    public void setInfligeableDamage(boolean infligeableDamage) {
        this.infligeableDamage = infligeableDamage;
    }

    public boolean isInfligeableDamage() {
        return infligeableDamage;
    }

    public void setLifeMax(int lifeMax) {
        this.lifeMax = lifeMax;
    }

    public int getLifeMax() {
        return this.lifeMax;
    }

    public void setCurrentLife(int currentLife) {
        if (currentLife > this.getLifeMax()) {
            this.currentLife = this.getLifeMax();
        } else {
            this.currentLife = currentLife;
        }
    }

    public int getCurrentLife() {
        return this.currentLife;
    }

    public void setCurrentMana(int currentMana) {
        if (currentMana > this.manaMax) {
            this.currentMana = this.manaMax;
        } else {
            this.currentMana = currentMana;
        }
    }

    public int getCurrentMana() {
        return this.currentMana;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getManaMax() {
        return this.manaMax;
    }

    public void setLifeVisible(boolean lifeVisible) {
        this.lifeVisible = lifeVisible;
    }

    public boolean isLifeVisible() {
        return this.lifeVisible;
    }

    public void init() throws SlickException {
        this.nameMap = map.getNameMap();
        SpriteSheet spriteSheet = new SpriteSheet(sprite, 64, 64);
        this.animationsWalk[0] = loadAnimation(spriteSheet, 0, 1, 0);
        this.animationsWalk[1] = loadAnimation(spriteSheet, 0, 1, 1);
        this.animationsWalk[2] = loadAnimation(spriteSheet, 0, 1, 2);
        this.animationsWalk[3] = loadAnimation(spriteSheet, 0, 1, 3);
        this.animationsWalk[4] = loadAnimation(spriteSheet, 1, 9, 0);
        this.animationsWalk[5] = loadAnimation(spriteSheet, 1, 9, 1);
        this.animationsWalk[6] = loadAnimation(spriteSheet, 1, 9, 2);
        this.animationsWalk[7] = loadAnimation(spriteSheet, 1, 9, 3);
    }

    protected Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public void render(Graphics g, boolean pause) throws SlickException {
        if (this.nameMap.equals(Map.getInstance().getNameMap())) {
            g.setColor(new Color(0, 0, 0, .5f));
            g.fillOval(x - 16, y - 8, 32, 16);
            if (!pause) {
                g.drawAnimation(animationsWalk[Direction.getDirectionNumber(direction) + (moving ? 4 : 0)], x - 32, y - 60);
            }
            lastDirection = direction;
        }
    }

    public void update(int delta) {
        if (this.moving) {
            float futurX = getFuturX(delta);
            float futurY = getFuturY(delta);
            if (this.nameMap.equals(Map.getInstance().getNameMap())) {
                boolean collision = this.map.isCollision(futurX, futurY);
                Iterator<Character> iterator = CharacterList.getInstance().iterator();
                while (iterator.hasNext()) {
                    Character other = iterator.next();
                    if (Math.sqrt(Math.pow(other.getX() - futurX, 2) + Math.pow(other.getY() - futurY, 2)) < 30 && !other.equals(this))
                        collision = true;
                    if (collision) {
                        //this.moving = false;
                    } else {
                        this.x = futurX;
                        this.y = futurY;
                    }
                }
            }
        }
        if (this.isInfligeableDamage()) {
            SoundEffect.dagger();
            Iterator<Character> iterator = CharacterList.getInstance().iterator();
            while (iterator.hasNext()) {
                Character c = iterator.next();
                if (!c.equals(this) && Math.sqrt(Math.pow(c.getX() - this.getX(), 2) + Math.pow(c.getY() - this.getY(), 2)) < 60) {
                    boolean correctDirection = false;
                    switch (getDirection()) {
                        case NORTH:
                            if (Math.abs(c.getX() - this.getX()) < this.getY() - c.getY())
                                correctDirection = true;
                            break;
                        case WEST:
                            if (this.getX() - c.getX() > Math.abs(this.getY() - c.getY()))
                                correctDirection = true;
                            break;
                        case SOUTH:
                            if (-Math.abs(c.getX() - this.getX()) > this.getY() - c.getY())
                                correctDirection = true;
                            break;
                        case EAST:
                            if (this.getX() - c.getX() < -Math.abs(this.getY() - c.getY()))
                                correctDirection = true;
                            break;
                    }
                    if (correctDirection)
                        c.setCurrentLife(c.getCurrentLife() - 1);
                }
            }
            this.setInfligeableDamage(false);
        }
    }


    private float getFuturX(int delta) {
        float futurX = this.x;
        switch (this.direction) {
            case WEST:
                futurX = this.x - speed * delta;
                break;
            case EAST:
                futurX = this.x + speed * delta;
                break;
        }
        return futurX;
    }

    private float getFuturY(int delta) {
        float futurY = this.y;
        switch (this.direction) {
            case NORTH:
                futurY = this.y - speed * delta;
                break;
            case SOUTH:
                futurY = this.y + speed * delta;
                break;
        }
        return futurY;
    }

    @Override
    public boolean equals(Object o) {
        return (this.sprite.equals(((Character) o).getSprite()) && this.x == ((Character) o).getX() && this.y == ((Character) o).getY());
    }

    @Override
    public String toString() {
        return "position : (" + x + "," + y + "), current life : " + currentLife + "/" + lifeMax;
    }

}
