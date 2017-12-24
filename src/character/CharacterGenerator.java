package character;

import map.Map;
import org.newdawn.slick.SlickException;
import state.Clock;

public class CharacterGenerator {

    private Map map;
    private String banditSprite = "src/ressources/sprites/monk.png";

    public CharacterGenerator(Map map) {
        this.map = map;
    }

    public void generate(int nbBandit, int nbSlime, int frequency, boolean now) throws SlickException {
        if (now) {
            addBandit(nbBandit);
            addSlime(nbSlime);
        } else {
            if (Clock.getTime() % frequency == 0) {
                addBandit(nbBandit);
                addSlime(nbSlime);
            }
        }
    }

    private void addBandit(int nbBandit) throws SlickException {
        int width = map.getWidth() * map.getTileWidth();
        int height = map.getHeight() * map.getTileHeight();
        for (int i = 0; i < nbBandit; i++) {
            Bot bot = new Bot(map, (float) Math.random() * width, (float) Math.random() * height, banditSprite, Behaviour.AGRESSIVE);
            bot.init();
            CharacterList.getInstance().add(bot);
        }
    }

    private void addSlime(int nbSlime) throws SlickException {
        int width = map.getWidth() * map.getTileWidth();
        int height = map.getHeight() * map.getTileHeight();
        for (int i = 0; i < nbSlime; i++) {
            Slime slime = new Slime(map, (float) Math.random() * width, (float) Math.random() * height, Behaviour.AGRESSIVE);
            slime.init();
            CharacterList.getInstance().add(slime);
        }
    }
}
