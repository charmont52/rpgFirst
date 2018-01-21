package sound;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import state.Options;
import state.StateID;

import java.util.LinkedList;

/**
 * Class managing the soundtrack
 */
public class SoundTrack {

    private Music OveMelaaDarkBlue;
    private String path = "src/ressources/sound/music/";
    private static LinkedList<Music> musicList;

    private SoundTrack() throws SlickException {
        musicList = new LinkedList<>();
        OveMelaaDarkBlue = new Music(path + "OveMelaaDarkBlue.ogg");
        //addMusic("OveMelaaApproachingTheGreenGrass.ogg");
        //addMusic("littleTown.ogg");
        addMusic("CourtMinstrel.ogg");
        addMusic("BrownFoxInn.ogg");
        addMusic("MedievalWaltz.ogg");
        addMusic("RiverbardTavern.ogg");

    }

    private void addMusic(String name) throws SlickException {
        Music music = new Music(path + name);
        musicList.add(music);
    }

    public static SoundTrack instance;

    static {
        try {
            instance = new SoundTrack();
        } catch (SlickException e) {
            System.out.println(e);
        }
    }

    /**
     * Play the soundtrack
     *
     * @param stateID The state ID to play the correct soundtrack
     */
    public static void loop(StateID stateID) {
        int duration = 1500;
        switch (stateID) {
            case GAME:
                SoundEffect.click();
                int random = (int) (Math.random() * musicList.size());
                musicList.get(random).play(1 * Options.getSoundLevel(), 1 * Options.getSoundLevel());
                break;
            case STARTPAGE:
                instance.OveMelaaDarkBlue.loop(1 * Options.getSoundLevel(), 0);
                instance.OveMelaaDarkBlue.fade(duration, 0.8f * Options.getSoundLevel(), false);
                break;
        }
    }

}
