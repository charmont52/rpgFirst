package character;

import controller.BotController;
import graphics.LifeBar;
import map.Direction;
import map.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bot extends Character {

    protected BotController botController = new BotController(this);
    private Behaviour behaviour;
    protected int paramXAnimation = 32;
    protected int paramYAnimation = 60;
    protected int paramXLife = 16;
    protected int paramYLife = 56;

    public Bot(Map map, float x, float y, String sprite, Behaviour behaviour) {
        super(map,x,y,sprite);
        this.behaviour = behaviour;
    }

    public int getParamXLife() {
        return this.paramXLife;
    }

    public int getParamYLife() {
        return this.paramYLife;
    }

    public Behaviour getBehaviour() {
        return this.behaviour;
    }

    @Override
    public void render(Graphics g) throws SlickException {
        if (this.getNameMap().equals(Map.getInstance().getNameMap())) {
            botController.move();
            g.setColor(new Color(0, 0, 0, .5f));
            g.fillOval(getX() - 16, getY() - 8, 32, 16);
            g.drawAnimation(animationsWalk[Direction.getDirectionNumber(direction) + (isMoving() ? 4 : 0)], getX() - paramXAnimation, getY() - paramYAnimation);
            if (this.isLifeVisible()) {
                LifeBar.drawLifeBar(g, this);
            }
        }
    }

}
