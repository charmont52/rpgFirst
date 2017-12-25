package event;

import character.CharacterGenerator;
import map.Map;
import org.newdawn.slick.SlickException;
import state.Clock;

/**
 * Class to create an event of character generation
 */
public class EventGenerator extends Event {

    private int latency;
    private int nbBandit;
    private int nbSlime;
    private CharacterGenerator characterGenerator;

    /**
     * Default constructor
     *
     * @param latency  The latency between two instanciations
     * @param nbBandit The number of bandits
     * @param nbSlime  The number of slimes
     */
    public EventGenerator(int latency, int nbBandit, int nbSlime) {
        super();
        this.latency = latency;
        this.nbBandit = nbBandit;
        this.nbSlime = nbSlime;
        this.characterGenerator = new CharacterGenerator(Map.getInstance());
    }

    @Override
    public void run() throws SlickException {
        if (Clock.getTime() % latency < 5) {
            characterGenerator.generate(nbBandit, nbSlime, latency, true);
        }
    }

}
