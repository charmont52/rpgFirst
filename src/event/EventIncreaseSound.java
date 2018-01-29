package event;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 * Class managing the increase sound after a dt time
 */
public class EventIncreaseSound extends Event {

    private Music music;
    private float volume;

    public EventIncreaseSound(int latency, Music music, float volume) {
        super(latency);
        this.music = music;
        this.volume = volume;
    }

    @Override
    public void run() throws SlickException {
        super.run();
        if (isRunable()) {
            music.setVolume(volume);
            EventList.remove(this);
        }
    }

}
