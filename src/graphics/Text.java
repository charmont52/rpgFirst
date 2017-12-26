package graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.MouseOverArea;

public class Text {

    /**
     * Draw a centered black string
     *
     * @param area The area
     * @param s    The string
     * @param g    Graphics
     */
    public static void drawCenterString(MouseOverArea area, String s, Graphics g) {
        drawCenterString(area, s, g, Color.black);
    }

    /**
     * Draw a centered colored string
     *
     * @param area  The area
     * @param s     The string
     * @param g     Graphics
     * @param color The color
     */
    public static void drawCenterString(MouseOverArea area, String s, Graphics g, Color color) {
        g.setColor(color);
        //drawCenterString(s, g, area.getX(), area.getY(), area.getWidthNbTile(), area.getHeightNbTile());
        g.drawString(s, area.getX() + area.getWidth() / 2 - g.getFont().getWidth(s) / 2, area.getY() + area.getHeight() / 2 - g.getFont().getHeight(s) / 2);
    }

    /**
     * Draw a center black string
     *
     * @param s      The string
     * @param g      Graphics
     * @param x      The abscissa
     * @param y      The ordered
     * @param width  The width
     * @param height The height
     */
    public static void drawCenterString(String s, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.black);
        g.drawString(s, x + width / 2 - g.getFont().getWidth(s) / 2, y + height / 2 - g.getFont().getHeight(s) / 2);
    }

}
