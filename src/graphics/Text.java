package graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.MouseOverArea;

public class Text {

    /**
     * Draw a centered black string
     *
     * @param g    Graphics
     * @param area The area
     * @param s    The string
     */
    public static void drawCenterString(Graphics g, MouseOverArea area, String s) {
        drawCenterString(g, area, s, Color.black);
    }

    /**
     * Draw a centered colored string
     *
     * @param g     Graphics
     * @param area  The area
     * @param s     The string
     * @param color The color
     */
    public static void drawCenterString(Graphics g, MouseOverArea area, String s, Color color) {
        g.setColor(color);
        //drawCenterString(s, g, area.getX(), area.getY(), area.getWidthNbTile(), area.getHeightNbTile());
        g.drawString(s, area.getX() + area.getWidth() / 2 - g.getFont().getWidth(s) / 2, area.getY() + area.getHeight() / 2 - g.getFont().getHeight(s) / 2);
    }

    /**
     * Draw a center black string
     *
     * @param g      Graphics
     * @param s      The string
     * @param x      The abscissa
     * @param y      The ordered
     * @param width  The width
     * @param height The height
     */
    public static void drawCenterString(Graphics g, String s, int x, int y, int width, int height) {
        g.setColor(Color.black);
        g.drawString(s, x + width / 2 - g.getFont().getWidth(s) / 2, y + height / 2 - g.getFont().getHeight(s) / 2);
    }

    /**
     * Align two strings : distance between the string1 start and the string2 end is equals to distance
     *
     * @param g        Graphics
     * @param s1       The first string
     * @param s2       The last string
     * @param x        The abscissa
     * @param y        The ordered
     * @param distance The distance the s1 start and the s2 end
     */
    public static void drawAlignString(Graphics g, String s1, String s2, int x, int y, int distance) {
        g.setColor(Color.black);
        g.drawString(s1, x, y);
        g.drawString(s2, x + distance - g.getFont().getWidth(s2), y);
    }

}
