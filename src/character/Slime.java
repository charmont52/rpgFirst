package character;

import map.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Slime extends Bot{

    public Slime(Map map, float x, float y, String sprite, Behaviour behaviour) {
        super(map,x,y,"src/ressources/sprites/slime.png",behaviour);
        this.paramXAnimation = 16;
        this.paramYAnimation = 30;
        this.paramXLife = 16;
        this.paramYLife = 38;
    }

    @Override
    public void init() throws SlickException {
        this.nameMap = map.getNameMap();
        SpriteSheet spriteSheet = new SpriteSheet(sprite, 32, 32);
        this.animationsWalk[0] = loadAnimation(spriteSheet, 0, 1, 0);
        this.animationsWalk[1] = loadAnimation(spriteSheet, 0, 1, 1);
        this.animationsWalk[2] = loadAnimation(spriteSheet, 0, 1, 2);
        this.animationsWalk[3] = loadAnimation(spriteSheet, 0, 1, 3);
        this.animationsWalk[4] = loadAnimation(spriteSheet, 1, 2, 0);
        this.animationsWalk[5] = loadAnimation(spriteSheet, 1, 2, 1);
        this.animationsWalk[6] = loadAnimation(spriteSheet, 1, 2, 2);
        this.animationsWalk[7] = loadAnimation(spriteSheet, 1, 2, 3);
    }

    @Override
    public String toString() {
        return super.toString() + " (slim)";
    }

}
