package graphics;

import character.Bot;
import character.Character;
import character.LevelProgression;
import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Bar {

    /**
     * Draw the life bar for a character
     *
     * @param g         Graphics
     * @param character The selected character
     * @throws SlickException
     */
    public static void drawLifeBar(Graphics g, Character character) throws SlickException {
        float x = character.getX();
        float y = character.getY();
        if (character instanceof Bot) {
            x = x - ((Bot) character).getParamXLife();
            y = y - ((Bot) character).getParamYLife();
        }
        g.setColor(new Color(20, 10, 0));
        g.fillRect(x, y, 32, 8);
        g.setColor(Color.lightGray);
        g.fillRect(x + 1, y + 1, 30, 6);
        g.setColor(new Color(200, 0, 0, 0.7f));
        int width = 28 * character.getStats().getCurrentLife() / character.getStats().getLifeMax();
        g.fillRect(x + 2, y + 2, width, 4);
    }

    /**
     * Draw the life player bar in the menu
     *
     * @param container Container
     * @param g         Graphics
     * @throws SlickException
     */
    public static void drawLifeBarPlayer(GameContainer container, Graphics g) throws SlickException {
        drawBarPlayer(container, g, new Color(240, 0, 0, 200), container.getHeight() - 60, Player.getInstance().getStats().getCurrentLife(), Player.getInstance().getStats().getLifeMax());
    }

    /**
     * Draw the mana player bar in the menu
     *
     * @param container Container
     * @param g         Graphics
     * @throws SlickException
     */
    public static void drawManaBarPlayer(GameContainer container, Graphics g) throws SlickException {
        drawBarPlayer(container, g, new Color(0, 0, 240, 200), container.getHeight() - 30, Player.getInstance().getStats().getCurrentMana(), Player.getInstance().getStats().getManaMax());
    }

    private static void drawBarPlayer(GameContainer container, Graphics g, Color color, int yPosition, int current, int max) {
        int x = 10;
        int y = yPosition;
        int width = 100;
        int height = 20;
        g.setColor(new Color(20, 10, 0));
        g.fillRect(x, y, width, height);
        g.setColor(Color.lightGray);
        g.fillRect(x + 1, y + 1, width - 2, height - 2);
        g.setColor(color);
        g.fillRect(x + 2, y + 2, (width - 4) * current / max, height - 4);
        Text.drawCenterString(current + "/" + max, g, x, y, width, height);
    }

    public static void drawXpBarPlayer(GameContainer container, Graphics g) throws SlickException {
        int x = 0;
        int y = container.getHeight() - 73;
        int width = container.getWidth();
        LevelProgression levelProgression = Player.getInstance().getLevelProgression();
        int widthXp = (int) (((float) levelProgression.getCurrentXp() / levelProgression.xpForNextLevel()) * width);
        int height = 5;
        g.setColor(Color.lightGray);
        g.fillRect(x, y, width, height);
        g.setColor(Color.yellow);
        g.fillRect(x, y, widthXp, height);
    }

}
