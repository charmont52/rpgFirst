package graphics;

import character.Bot;
import character.Character;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class LifeBar {

    public static void drawLifeBar(Graphics g, Character character) throws SlickException {
        float x = character.getX();
        float y = character.getY();
        if (character instanceof Bot) {
            x = x - ((Bot) character).getParamXLife();
            y = y - ((Bot) character).getParamYLife();
        }
        g.setColor(new Color(20,10,0));
        g.fillRect(x, y,32,8);
        g.setColor(Color.lightGray);
        g.fillRect(x+1, y+1,30,6);
        g.setColor(new Color(200,0,0,0.7f));
        int width = 28*character.getCurrentLife()/character.getLifeMax();
        g.fillRect(x + 2, y + 2,width, 4);
    }

}
