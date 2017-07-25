package graphics;

import character.Bot;
import character.Character;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class LifeBar {

    public static void drawLifeBar(Graphics g, Character character) throws SlickException {
        g.setColor(Color.darkGray);
        float x = character.getX();
        float y = character.getY();
        if (character instanceof Bot) {
            x = x - ((Bot) character).getParamXLife();
            y = y - ((Bot) character).getParamYLife();
        }
        g.fillRoundRect(x, y,32,8,2);
        g.setColor(Color.red);
        int width = 28*character.getCurrentLife()/character.getLifeMax();
        g.fillRoundRect(x + 2, y + 2,width, 4,2);
    }

}
