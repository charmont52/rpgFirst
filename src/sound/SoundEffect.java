package sound;

import character.Player;
import graphics.Fire;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import state.Options;

/**
 * Class managing the sound effect
 */
public class SoundEffect {

    private Sound click;
    private Sound levelUp;
    private Sound dagger;
    private Sound fire;
    private Sound gold;

    private SoundEffect() throws SlickException {
        click = new Sound("src/ressources/sound/click.wav");
        levelUp = new Sound("src/ressources/sound/levelUp.wav");
        dagger = new Sound("src/ressources/sound/dagger.wav");
        fire = new Sound("src/ressources/sound/campfire.wav");
        gold = new Sound("src/ressources/sound/gold.wav");
    }

    /**
     * The SoundEffect instance
     */
    public static SoundEffect instance;

    static {
        try {
            instance = new SoundEffect();
        } catch (SlickException e) {
            System.out.println(e);
        }
    }

    /**
     * Play a click sound
     */
    public static void click() {
        instance.click.play(1, 0.4f * Options.getSoundLevel());
    }

    /**
     * Play a level up sound
     */
    public static void levelUp() {
        instance.levelUp.play(1, 0.6f * Options.getSoundLevel());
    }

    /**
     * Play a blow of dagger sound
     */
    public static void dagger() {
        instance.dagger.play(1, 0.8f * Options.getSoundLevel());
    }

    /**
     * Play a fire sound
     */
    public static void fireLoop(Fire fire) {
        double distance = Math.sqrt(Math.pow(fire.getX() - Player.getInstance().getX(), 2) + Math.pow(fire.getY() - Player.getInstance().getY(), 2));
        double distanceMax = 200;
        float distanceMultiplier = (float) Math.min(0, distanceMax - distance);
        if (!instance.fire.playing()) {
            instance.fire.play(1, 1f * Options.getSoundLevel() * distanceMultiplier);
        }
    }

    /**
     * Stop the fire sound
     */
    public static void fireStop() {
        instance.fire.stop();
    }

    /**
     * Play a gold sound
     */
    public static void gold() {
        instance.gold.play(1, 0.8f * Options.getSoundLevel());
    }

    /**
     * Stop all the sounds
     */
    public static void stopAll() {
        fireStop();
        instance.dagger.stop();
        instance.levelUp.stop();
        instance.gold.stop();
    }

}
