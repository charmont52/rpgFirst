package night;

import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import state.Clock;

public class Night {

    private static int tremble[] = {0, 0, 0, 0, 0};

    public static void render(GameContainer container, Graphics g, float x, float y) {
        int red = 0;
        int green = 0;
        int blue = 0;
        int alpha = 0;
        switch (Clock.getHour()) {
            case 21:
            case 22:
            case 23:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                red = 10;
                green = 10;
                blue = 25;
                alpha = 220;
                break;
            // poison color : (128,94,0,150)
            case 6:
                red = 14;
                green = 15;
                blue = 34;
                alpha = 200;
                break;
            case 7:
                red = 14;
                green = 15;
                blue = 47;
                alpha = 180;
                break;
            case 8:
                red = 14;
                green = 15;
                blue = 47;
                alpha = 120;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                alpha = 0;
                break;
            case 17:
                red = 102;
                green = 0;
                blue = 0;
                alpha = 30;
                break;
            case 18:
                red = 31;
                green = 0;
                blue = 77;
                alpha = 60;
                break;
            case 19:
                red = 0;
                green = 0;
                blue = 77;
                alpha = 100;
                break;
            case 20:
                red = 0;
                green = 0;
                blue = 54;
                alpha = 160;
                break;
        }
        Color color = new Color(red, green, blue, alpha);
        g.setColor(color);
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
        addTremble((int) (Math.random() * 10));
        for (int i = xPos - halo; i < xPos + halo; i += step) {
            for (int j = yPos - halo; j < yPos + halo; j += step) {
                int currAlpha = Math.min(getDistance(xPos, yPos, i, j) + 80 * alpha / 220 + renderTremble(), alpha);
                g.setColor(new Color(red, green, blue, currAlpha));
                g.fillRect(i, j, step, step);
            }
        }
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private static void addTremble(int t) {
        int length = tremble.length - 1;
        for (int i = 0; i < length; i++) {
            tremble[i] = tremble[i + 1];
        }
        tremble[length] = t;
    }

    private static int renderTremble() {
        int length = tremble.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += tremble[i];
        }
        return result / length;
    }

}
