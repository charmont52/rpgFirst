package sound;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import state.Options;
import state.StateID;

public class SoundTrack {

    private Music music1;

    public enum Type {RANDOM, LOOP}

    private SoundTrack() throws SlickException {
        music1 = new Music("src/ressources/sound/OveMelaaApproachingTheGreenGrass.ogg");
    }

    public static SoundTrack instance;

    static {
        try {
            instance = new SoundTrack();
        } catch (SlickException e) {
            System.out.println(e);
        }
    }

    public static void loop(StateID stateID, Type type) {
        if (stateID == StateID.GAME) {
            instance.music1.loop(1 * Options.getSoundLevel(), 0);
            instance.music1.fade(1500, 1 * Options.getSoundLevel(), false);
        }
    }

}
