package sound;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import state.Options;
import state.StateID;

import java.util.LinkedList;

public class SoundTrack {

    private Music OveMelaaApproachingTheGreenGrass;
    private Music OveMelaaDarkBlue;
    private Music littleTown;
    private LinkedList<Music> musicLinkedList;

    public enum Type {RANDOM, LOOP}

    private SoundTrack() throws SlickException {
        OveMelaaApproachingTheGreenGrass = new Music("src/ressources/sound/OveMelaaApproachingTheGreenGrass.ogg");
        OveMelaaDarkBlue = new Music("src/ressources/sound/OveMelaaDarkBlue.ogg");
        littleTown = new Music("src/ressources/sound/littleTown.ogg");
        musicLinkedList = new LinkedList<>();
        musicLinkedList.add(this.OveMelaaApproachingTheGreenGrass);
        musicLinkedList.add(this.littleTown);
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
        int duration = 1500;
        switch (stateID) {
            case GAME:
                if (type == Type.RANDOM) {
                    instance.OveMelaaApproachingTheGreenGrass.loop(1 * Options.getSoundLevel(), 0);
                    instance.OveMelaaApproachingTheGreenGrass.fade(duration, 1 * Options.getSoundLevel(), false);
                }
                break;
            case STARTPAGE:
                instance.OveMelaaDarkBlue.loop(1 * Options.getSoundLevel(), 0);
                instance.OveMelaaDarkBlue.fade(duration, 0.8f * Options.getSoundLevel(), false);
                break;
        }
    }

    public static void loop(StateID stateID) {
        loop(stateID,Type.LOOP);
    }

}
