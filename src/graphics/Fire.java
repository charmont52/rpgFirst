package graphics;

import map.Map;
import org.newdawn.slick.*;

public class Fire {

    private Animation[] animations = new Animation[2];
    private int x;
    private int y;
    private String nameMap;

    public Fire(int x, int y, String nameMap) throws SlickException {
        this.x = x;
        this.y = y;
        this.nameMap = nameMap;
        animations[0] = new Animation();
        SpriteSheet spriteSheet = new SpriteSheet("src/ressources/sprites/campFire.png", 64, 64);
        for (int i = 0; i < 5; i++) {
            animations[0].addFrame(spriteSheet.getSprite(i, 0), 150);
        }
        animations[1] = new Animation();
        animations[1].addFrame(spriteSheet.getSprite(0,0), 150);
    }

    public void render(Graphics g, boolean pause) throws SlickException {
        if (nameMap.equals(Map.getInstance().getNameMap())) {
            if (!pause) {
                g.drawAnimation(animations[0], x, y);
            } else {
                g.drawAnimation(animations[1], x, y);
            }
        }
    }

}
