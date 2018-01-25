package night;

import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.svg.Gradient;
import state.Clock;

import java.util.Iterator;

public class Night {

    public static void render(GameContainer container, Graphics g, float x, float y) {
        if (true) {//Clock.isNight()) {
            Color blueNight = new Color(10, 10, 25, 220);
            g.setColor(blueNight);
            int xPos = (int) (Player.getInstance().getX() - x);
            int yPos = (int) (Player.getInstance().getY() - 8 - y);
            int halo = 180;
            int width = container.getWidth();
            int height = container.getHeight();

            g.fillRect(0, 0, xPos - halo, height);
            g.fillRect(xPos + halo, 0, width - xPos - halo, height);
            g.fillRect(xPos - halo, 0, 2 * halo, yPos - halo);
            g.fillRect(xPos - halo, yPos + halo, 2 * halo, height);
            int step = 4;
            for (int i = xPos - halo; i < xPos + halo; i += step) {
                for (int j = yPos - halo; j < yPos + halo; j += step) {
                    int alpha = Math.min(getDistance(xPos, yPos, i, j) + 80, 220);
                    g.setColor(new Color(10, 10, 25, alpha));
                    g.fillRect(i, j, step, step);
                }
            }
        }
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

}
