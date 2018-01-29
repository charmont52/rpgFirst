package event;

import character.Character;
import org.newdawn.slick.SlickException;

public class EventRegenerate extends Event {

    private Character character;
    private Type type;

    public enum Type {LIFE, MANA}

    public EventRegenerate(int latency, Character character, Type type) {
        super(latency);
        this.character = character;
        this.type = type;
    }

    @Override
    public void run() throws SlickException {
        super.run();
        if (isRunable()) {
            switch (type) {
                case LIFE:
                    character.getStats().addCurrentLife(character.getStats().getRegenerateRateLife());
                    break;
                case MANA:
                    character.getStats().addCurrentMana(character.getStats().getRegenerateRateMana());
                    break;
            }
            resetLastInstanciation();
        }
    }

    @Override
    public String toString() {
        return "(EventRegenerate) status: " + isRunable();
    }

}
