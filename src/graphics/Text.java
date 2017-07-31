package graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.MouseOverArea;

public class Text {

    public static void drawCenterString(MouseOverArea area, String s, Graphics g) {
        drawCenterString(area, s, g, Color.black);
    }

    public static void drawCenterString(MouseOverArea area, String s, Graphics g, Color color) {
        g.setColor(color);
        //drawCenterString(s, g, area.getX(), area.getY(), area.getWidth(), area.getHeight());
        g.drawString(s,area.getX() + area.getWidth()/2 - g.getFont().getWidth(s)/2,area.getY() + area.getHeight()/2 - g.getFont().getHeight(s)/2);
    }

    public static void drawCenterString(String s, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.black);
        g.drawString(s, x + width/2 - g.getFont().getWidth(s)/2, y + height/2 - g.getFont().getHeight(s)/2);
    }

}
