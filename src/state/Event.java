package state;

public class Event {

    Type type;

    public enum Type {
        GENERATEEVENT
    }

    public Event(Type type, int frequency, int nbBandit, int nbSlime) {
        this.type = type;
    }
}
