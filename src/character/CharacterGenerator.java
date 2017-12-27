package character;

import event.EventGeneratorCharacter;
import event.EventList;
import map.Map;
import org.newdawn.slick.SlickException;

/**
 * Class managing the character generation
 */
public class CharacterGenerator {

    private Map map;
    private String banditSprite = "src/ressources/sprites/monk.png";

    /**
     * Default generator
     *
     * @param map The map where the character is instanced
     */
    public CharacterGenerator(Map map) {
        this.map = map;
    }

    /**
     * Generate characters
     *
     * @param nbBandit The number of bandits
     * @param nbSlime  The number of slimes
     * @param latency  The latency between two instanciations
     * @param now      True if the instanciation must be now
     * @throws SlickException
     */
    public void generate(int nbBandit, int nbSlime, int latency, boolean now) throws SlickException {
        if (now) {
            addBandit(nbBandit, -1, -1);
            addSlime(nbSlime, -1, -1);
        } else {
            EventList.getInstance().add(new EventGeneratorCharacter(latency, nbBandit, nbSlime));
        }
    }

    /**
     * Generate characters
     *
     * @param nbBandit The number of bandits
     * @param nbSlime  The number of slimes
     * @param latency  The latency between two instanciations
     * @param now      True if the instanciation must be now
     * @param x        The abscissa
     * @param y        The ordered
     * @throws SlickException
     */
    public void generate(int nbBandit, int nbSlime, int latency, boolean now, int x, int y) throws SlickException {
        if (now) {
            addBandit(nbBandit, x, y);
            addSlime(nbSlime, x, y);
        } else {
            EventList.getInstance().add(new EventGeneratorCharacter(latency, nbBandit, nbSlime, x, y));
        }
    }

    /**
     * Private function to add bandits
     *
     * @param nbBandit The number of bandits
     * @param x        The abscissa to instanciation, if it is negative, the position is random
     * @param y        The ordered to instanciation, if it is negative, the position is random
     * @throws SlickException
     */
    private void addBandit(int nbBandit, int x, int y) throws SlickException {
        int width = map.getWidthNbTile() * map.getTileWidth();
        int height = map.getHeightNbTile() * map.getTileHeight();
        for (int i = 0; i < nbBandit; i++) {
            Bot bot;
            if (x < 0 || y < 0) {
                bot = new Bot(map, (float) Math.random() * width, (float) Math.random() * height, banditSprite, Behaviour.AGRESSIVE);
            } else {
                bot = new Bot(map, x, y, banditSprite, Behaviour.AGRESSIVE);
            }
            bot.init();
            CharacterList.getInstance().add(bot);
        }
    }

    /**
     * Private function to add bandits
     *
     * @param nbSlime The number of slimes
     * @param x       The abscissa to instanciation, if it is negative, the position is random
     * @param y       The ordered to instanciation, if it is negative, the position is random
     * @throws SlickException
     */
    private void addSlime(int nbSlime, int x, int y) throws SlickException {
        int width = map.getWidthNbTile() * map.getTileWidth();
        int height = map.getHeightNbTile() * map.getTileHeight();
        for (int i = 0; i < nbSlime; i++) {
            Slime slime;
            if (x < 0 || y < 0) {
                slime = new Slime(map, (float) Math.random() * width, (float) Math.random() * height, Behaviour.AGRESSIVE);
            } else {
                slime = new Slime(map, x, y, Behaviour.AGRESSIVE);
            }
            slime.init();
            CharacterList.getInstance().add(slime);
        }
    }
}
