package skill;

import character.Character;

public class Skill {

    private Character character;
    private int manaCost;
    private int lifeCost;
    private boolean castable;

    public Skill(Character character) {
        this.character = character;
        this.manaCost = 0;
        this.lifeCost = 0;
        this.castable = false;
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

    public boolean isCastable() {
        return castable;
    }

    public void use() {
        int currentMana = character.getStats().getCurrentMana();
        int currentLife = character.getStats().getCurrentLife();
        if (currentLife >= lifeCost && currentMana >= manaCost) {
            castable = true;
        } else {
            castable = false;
        }
    }

}
