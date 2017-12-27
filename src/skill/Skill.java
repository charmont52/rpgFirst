package skill;

import character.Character;
import org.newdawn.slick.*;

public class Skill {

    private Character character;
    private int manaCost;
    private int lifeCost;
    private int range;
    private boolean castable;
    private boolean used;

    public Skill(Character character) {
        this.character = character;
        this.manaCost = 0;
        this.lifeCost = 0;
        this.range = 0;
        this.castable = false;
        this.used = false;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getLifeCost() {
        return lifeCost;
    }

    public void setLifeCost(int lifeCost) {
        this.lifeCost = lifeCost;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public boolean isCastable() {
        return castable;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void use(Graphics g) {
        int currentMana = character.getStats().getCurrentMana();
        int currentLife = character.getStats().getCurrentLife();
        if (currentLife >= lifeCost && currentMana >= manaCost) {
            castable = used;
        } else {
            castable = false;
            used = false;
        }
    }

}
