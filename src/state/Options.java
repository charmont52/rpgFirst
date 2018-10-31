package state;

public class Options {

    private float soundLevel;

    private Options() {
        this.soundLevel = 0.5f;
    }

    private final static Options instance = new Options();

    public static Options getInstance() {
        return instance;
    }

    public static float getSoundLevel() {
        return instance.soundLevel;
    }

    public static void setSoundLevel(float soundLevel) {
        if (soundLevel < 0) {
            instance.soundLevel = 0;
        } else if (soundLevel > 1) {
            instance.soundLevel = 1;
        } else {
            instance.soundLevel = soundLevel;
        }
    }

    public static void upSoundLevel() {
        setSoundLevel(instance.soundLevel + 0.1f);
    }

    public static void downSoundLevel() {
        setSoundLevel(instance.soundLevel - 0.1f);
    }

}
