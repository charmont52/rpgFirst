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

    protected float x = 500;
    protected float y = 500;
    protected Animation[] animationsWalk = new Animation[8];
    protected Direction direction = Direction.SOUTH;
    protected Direction lastDirection = Direction.SOUTH;
    protected boolean moving = false;
    protected Map map;
    private boolean onStair;
    protected String sprite;
    protected String mapName;
    protected boolean atkable = false;
    protected boolean infligeableDamage = false;
    protected int atkCount = 0;
    protected boolean lifeVisible = true;
    protected Stats stats;

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
        this.stats = new Stats();
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
     * Get the map name
     *
     * @return The map name
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * Set the map name
     *
     * @param mapName The map name
     */
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    /**
     * Get the character sprite
     *
     * @return The character sprite
     */
    public String getSprite() {
        return this.sprite;
    }

    /**
     * Set if the character can attack
     *
     * @param atkable True if the character can attack
     */
    public void setAtkable(boolean atkable) {
        this.atkable = atkable;
    }

    /**
     * Check if the character can attack
     *
     * @return True if the character can attack
     */
    public boolean isAtkable() {
        return this.atkable;
    }

    /**
     * Set if the character can inflict damage
     *
     * @param infligeableDamage True if the character can inflict damage
     */
    public void setInfligeableDamage(boolean infligeableDamage) {
        this.infligeableDamage = infligeableDamage;
    }

    /**
     * Get if the character can inflict damage
     *
     * @return True if the character can inflict damage
     */
    public boolean isInfligeableDamage() {
        return infligeableDamage;
    }

    /**
     * Set the attack counter
     *
     * @param atkCount The new attck counter
     * @return
     */
    public void setAtkCount(int atkCount) {
        this.atkCount = atkCount;
    }

    /**
     * Get the attack counter
     *
     * @return The attack counter
     */
    public int getAtkCount() {
        return atkCount;
    }

    /**
     * Add i to the attack counter
     *
     * @param i The number i to add
     */
    public void addAtkCount(int i) {
        this.atkCount += i;
    }

    /**
     * Set if the life is visible
     *
     * @param lifeVisible True if the life is visible
     */
    public void setLifeVisible(boolean lifeVisible) {
        this.lifeVisible = lifeVisible;
    }

    /**
     * Check if the life is visible
     *
     * @return True if the life is visible
     */
    public boolean isLifeVisible() {
        return this.lifeVisible;
    }

    public Stats getStats() {
        return this.stats;
    }

    /**
     * Init the character
     *
     * @throws SlickException The slick exception
     */
    public void init() throws SlickException {
        this.mapName = map.getNameMap();
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

    /**
     * Load the character animation
     *
     * @param spriteSheet The character sprite sheet
     * @param startX      The X start
     * @param endX        The X end
     * @param y           The Y
     * @return The animation
     */
    protected Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    /**
     * Render the character
     *
     * @param g     The current graphics context
     * @param pause True if the game is in pause
     * @throws SlickException The slick exception
     */
    public void render(Graphics g, boolean pause) throws SlickException {
        if (this.mapName.equals(Map.getInstance().getNameMap())) {
            g.setColor(new Color(0, 0, 0, .5f));
            g.fillOval(x - 16, y - 8, 32, 16);
            if (!pause) {
                g.drawAnimation(animationsWalk[Direction.getDirectionNumber(direction) + (moving ? 4 : 0)], x - 32, y - 60);
            }
            lastDirection = direction;
        }
    }

    /**
     * Update the character
     *
     * @param delta The delta of time
     */
    public void update(int delta) {
        if (this.moving) {
            float futurX = getFuturX(delta);
            float futurY = getFuturY(delta);
            if (this.mapName.equals(Map.getInstance().getNameMap())) {
                boolean collision = this.map.isCollision(futurX, futurY);
                Iterator<Character> iterator = CharacterList.getInstance().iterator();
                while (iterator.hasNext()) {
                    Character other = iterator.next();
                    if (Math.sqrt(Math.pow(other.getX() - futurX, 2) + Math.pow(other.getY() - futurY, 2)) < 30 && !other.equals(this)) {
                        collision = true;
                    }
                    if (!collision) {
                        this.x = futurX;
                        this.y = futurY;
                    }
                }
            }
        }
        updateAttack();
    }

    /**
     * Update the character attack
     */
    protected void updateAttack() {
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
                        c.getStats().setCurrentLife(c.getStats().getCurrentLife() - this.stats.getInfligeableDamage());
                }
            }
            this.setInfligeableDamage(false);
        }
    }

    /**
     * Get the future X
     *
     * @param delta The delta of time
     * @return The new X
     */
    private float getFuturX(int delta) {
        float futurX = this.x;
        switch (this.direction) {
            case WEST:
                futurX = this.x - stats.getCurrentSpeed() * delta;
                break;
            case EAST:
                futurX = this.x + stats.getCurrentSpeed() * delta;
                break;
        }
        return futurX;
    }

    /**
     * Get the future Y
     *
     * @param delta The delta of time
     * @return The new Y
     */
    private float getFuturY(int delta) {
        float futurY = this.y;
        switch (this.direction) {
            case NORTH:
                futurY = this.y - stats.getCurrentSpeed() * delta;
                break;
            case SOUTH:
                futurY = this.y + stats.getCurrentSpeed() * delta;
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
        return "position : (" + x + "," + y + "), current life : " + stats.getCurrentLife() + "/" + stats.getLifeMax();
    }

}
