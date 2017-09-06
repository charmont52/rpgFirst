package state;

public class Options {

    private float soundLevel;

    private Options() {
        this.soundLevel = 1f;
    }

    private final static Options instance = new Options();

    public static Options getInstance() {
        return instance;
    }

    public static float getSoundLevel() {
        return instance.soundLevel;
    }

    public static void setSoundLevel(float soundLevel) {
        instance.soundLevel = soundLevel;
    }

}
