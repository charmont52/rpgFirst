package graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Area {

    /**
     * Draw an outline around a rectangle
     * @param g Graphics
     * @param container Container
     * @param x The abscissa
     * @param y The ordered
     * @param width The width
     * @param height the Height
     */
    public static void drawOutline(Graphics g, GameContainer container, int x, int y, int width, int height) {
        g.setColor(Color.black);
        g.drawLine(x, y, x + width, y);
        g.drawLine(x, y, x, y + height);
        g.drawLine(x + width, y, x + width, y + height);
        g.drawLine(x, y + height, x + width, y + height);
    }

}
