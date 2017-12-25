package event;

import character.CharacterGenerator;
import map.Map;
import org.newdawn.slick.SlickException;
import state.Clock;

public class EventGenerator extends Event {

    private int latency;
    private int nbBandit;
    private int nbSlime;
    private CharacterGenerator characterGenerator;

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
