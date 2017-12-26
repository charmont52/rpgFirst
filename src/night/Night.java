package night;

import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import state.Clock;

import java.util.Iterator;

public class Night {

    public static void render(GameContainer container, Graphics g, float x, float y) {
        if (Clock.isNight()) {
            Iterator<Light> iterator = LightList.iterator();
            Color blueNight = new Color(10, 10, 25, 220);
            g.setColor(blueNight);
            g.fillRect(container.getWidth() - 900, container.getHeight() - 700, 1800, 1400);
            /*g.setColor(Color.black);
            float abscisse = - (container.getWidthNbTile() / 2 - x);
            float ordonnee = - (container.getHeightNbTile() / 2 - y);
            g.drawString("(" + abscisse + "," + ordonnee + ")", 100f, 100f);
            g.fillRect(abscisse, ordonnee,50,50);
            LightList.clear();*/
            /*Color blueNight = new Color(10,10,25,220);
            g.setColor(blueNight);
            g.fillRect(Player.getInstance().getX()-900,Player.getInstance().getY()-700,1800,1400);*/
        }
    }

}
