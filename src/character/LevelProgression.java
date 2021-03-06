package character;

import sound.SoundEffect;

/**
 * Class managing the level progression
 */
public class LevelProgression {

    private int currentLevel;
    private int currentXp;
    private Character character;

    /**
     * Default constructor
     *
     * @param character The character
     */
    public LevelProgression(Character character) {
        this.currentLevel = 1;
        this.currentXp = 0;
        this.character = character;
    }

    /**
     * An other constructor
     *
     * @param currentLevel The current level
     * @param currentXp    The current XP
     * @param character    The character
     */
    public LevelProgression(int currentLevel, int currentXp, Character character) {
        this.currentLevel = currentLevel;
        this.currentXp = currentXp;
        this.character = character;
    }

    /**
     * Get the current XP
     *
     * @return The current XP
     */
    public int getCurrentXp() {
        return currentXp;
    }

    /**
     * Set the current XP
     *
     * @param currentXp The new current XP
     */
    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    /**
     * Get the current level
     *
     * @return The current level
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Set the current level
     *
     * @param currentLevel The new current level
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Add XP to the progression
     *
     * @param xp The new quantity of XP
     */
    public void addXp(int xp) {
        if (currentXp + xp > xpForNextLevel()) {
            currentXp = (currentXp + xp) % xpForNextLevel();
            levelUp();
        } else {
            currentXp += xp;
        }
    }

    /**
     * Get the XP needed to reach the next level. The XP progression follows an exponential law.
     *
     * @return The XP needed to reach the next level
     */
    public int xpForNextLevel() {
        return (int) (10 * Math.exp(currentLevel / 8.));
    }

    /**
     * Upgrade the level with all implications
     */
    public void levelUp() {
        currentLevel++;
        SoundEffect.levelUp();
        character.getStats().setCurrentLife(character.getStats().getLifeMax());
        character.getStats().setCurrentMana(character.getStats().getManaMax());
        character.getStats().addSkillPoint(1);
        character.getStats().addCharacteristicPoint(1);
    }

}
