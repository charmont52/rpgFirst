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
public class SoundTrack implements MusicListener {

    private StateID currentState = StateID.STARTPAGE;

    private Music OveMelaaApproachingTheGreenGrass;
    private Music OveMelaaDarkBlue;
    private Music littleTown;
    private Music click;
    private LinkedList<Music> musicList;

    private SoundTrack() throws SlickException {
        OveMelaaApproachingTheGreenGrass = new Music("src/ressources/sound/OveMelaaApproachingTheGreenGrass.ogg");
        OveMelaaDarkBlue = new Music("src/ressources/sound/OveMelaaDarkBlue.ogg");
        littleTown = new Music("src/ressources/sound/littleTown.ogg");
        click = new Music("src/ressources/sound/click.wav");

        click.addListener(this);
        OveMelaaApproachingTheGreenGrass.addListener(this);
        littleTown.addListener(this);

        musicList = new LinkedList<>();
        musicList.add(this.OveMelaaApproachingTheGreenGrass);
        musicList.add(this.littleTown);
    }

    public static SoundTrack instance;

    static {
        try {
            instance = new SoundTrack();
        } catch (SlickException e) {
            System.out.println(e);
        }
    }

    @Override
    public void musicEnded(Music music) {
        switch (currentState) {
            case GAME:
                int random = (int) (Math.random() * musicList.size());
                musicList.get(random).play(1 * Options.getSoundLevel(), 1 * Options.getSoundLevel());
                break;
        }
    }

    @Override
    public void musicSwapped(Music music, Music newMusic) {
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
                instance.currentState = StateID.GAME;
                instance.click.play();
                break;
            case STARTPAGE:
                instance.currentState = StateID.STARTPAGE;
                instance.OveMelaaDarkBlue.loop(1 * Options.getSoundLevel(), 0);
                instance.OveMelaaDarkBlue.fade(duration, 0.8f * Options.getSoundLevel(), false);
                break;
        }
    }

}
