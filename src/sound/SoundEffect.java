package sound;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import state.Options;

public class SoundEffect {

    private Sound click;
    private Sound levelUp;
    private Sound dagger;

    private SoundEffect() throws SlickException {
        click = new Sound("src/ressources/sound/click.wav");
        levelUp = new Sound("src/ressources/sound/levelUp.wav");
        dagger = new Sound("src/ressources/sound/dagger.wav");
    }

    public static SoundEffect instance;

    static {
        try {
            instance = new SoundEffect();
        } catch (SlickException e) {
            System.out.println(e);
        }
    }

    public static void click() {
        instance.click.play(1,0.4f * Options.getSoundLevel());
    }

    public static void levelUp() {
        instance.levelUp.play(1,0.6f * Options.getSoundLevel());
    }

    public static void dagger() {
        instance.dagger.play(1,0.8f * Options.getSoundLevel());
    }

}
