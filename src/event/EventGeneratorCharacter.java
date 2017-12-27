package event;

import character.CharacterGenerator;
import map.Map;
import org.newdawn.slick.SlickException;

/**
 * Class to create an event of character generation
 */
public class EventGeneratorCharacter extends Event {

    private int nbBandit;
    private int nbSlime;
    private int x;
    private int y;
    private CharacterGenerator characterGenerator;

    /**
     * Default constructor
     *
     * @param latency  The latency between two instanciations
     * @param nbBandit The number of bandits
     * @param nbSlime  The number of slimes
     */
    public EventGeneratorCharacter(int latency, int nbBandit, int nbSlime) {
        super(latency);
        this.nbBandit = nbBandit;
        this.nbSlime = nbSlime;
        this.x = -1;
        this.y = -1;
        this.characterGenerator = new CharacterGenerator(Map.getInstance());
    }

    /**
     * Constructor with a specific position
     * @param latency The latency between two instanciations
     * @param nbBandit The number of bandits
     * @param nbSlime The number of slimes
     * @param x The abscissa
     * @param y The ordered
     */
    public EventGeneratorCharacter(int latency, int nbBandit, int nbSlime, int x, int y) {
        super(latency);
        this.nbBandit = nbBandit;
        this.nbSlime = nbSlime;
        this.x = x;
        this.y = y;
        this.characterGenerator = new CharacterGenerator(Map.getInstance());
    }

    @Override
    public void run() throws SlickException {
        super.run();
        if (isRunable()) {
            characterGenerator.generate(nbBandit, nbSlime, getLatency(), true, x, y);
            resetLastInstanciation();
        }
    }

    @Override
    public String toString() {
        return "(EventGeneratorCharacter) status: " + isRunable();
    }

}
