package character;

public class Stats {

    /**
     * Life
     */
    private int lifeMax;
    private int currentLife;
    private int regenerateRateLife;

    /**
     * Mana
     */
    private int manaMax;
    private int currentMana;
    private int regenerateRateMana;

    /**
     * Speed
     */
    private float speedMax;
    private float currentSpeed;

    /**
     * XP on kill
     */
    private int xpOnKill;

    /**
     * Damage
     */
    private int infligeableDamage;
    private int damageReduction;

    /**
     * SkillSet and Characteristic points
     */
    private int skillPoint;
    private int characteristicPoint;

    /**
     * Number of gold piece
     */
    private int gold;

    public Stats() {
        this.lifeMax = 5;
        this.currentLife = 5;
        this.manaMax = 5;
        this.currentMana = 5;
        this.speedMax = 0.2f;
        this.currentSpeed = 0.2f;
        this.xpOnKill = 5;
        this.infligeableDamage = 1;
        this.damageReduction = 0;
        this.skillPoint = 0;
        this.characteristicPoint = 0;
        this.gold = 0;
        this.regenerateRateLife = 1;
        this.regenerateRateMana = 1;
    }

    /**
     * Get the max speed
     *
     * @return The max speed
     */
    public float getSpeedMax() {
        return this.speedMax;
    }

    /**
     * Set the max speed
     *
     * @param speed The new max speed
     */
    public void setSpeedMax(float speed) {
        this.speedMax = speed;
    }

    /**
     * Get the current speed
     *
     * @return The current speed
     */
    public float getCurrentSpeed() {
        return this.currentSpeed;
    }

    /**
     * Set the current speed
     *
     * @param speed The new current speed
     */
    public void setCurrentSpeed(float speed) {
        this.currentSpeed = speed;
    }

    /**
     * Set the maximum of life
     *
     * @param lifeMax The new maximum of life
     */
    public void setLifeMax(int lifeMax) {
        if (lifeMax < 0) {
            this.lifeMax = 0;
        } else {
            this.lifeMax = lifeMax;
        }
    }

    /**
     * Get the maximum of life
     *
     * @return The maximum of life
     */
    public int getLifeMax() {
        return this.lifeMax;
    }

    public void addLifeMax(int life) {
        setLifeMax(life + getLifeMax());
    }

    /**
     * Set the current life
     *
     * @param currentLife The new current life
     */
    public void setCurrentLife(int currentLife) {
        if (currentLife > this.getLifeMax()) {
            this.currentLife = this.getLifeMax();
        } else if (this.currentLife + currentLife < 0) {
            this.currentLife = 0;
        } else {
            this.currentLife = currentLife;
        }
    }

    /**
     * Get the current life
     *
     * @return The current life
     */
    public int getCurrentLife() {
        return this.currentLife;
    }

    public void addCurrentLife(int life) {
        setCurrentLife(life + getCurrentLife());
    }

    /**
     * Set the current mana
     *
     * @param currentMana The new current mana
     */
    public void setCurrentMana(int currentMana) {
        if (currentMana > this.manaMax) {
            this.currentMana = this.manaMax;
        } else if (this.currentMana + currentMana < 0) {
            this.currentMana = 0;
        } else {
            this.currentMana = currentMana;
        }
    }

    /**
     * Get the current mana
     *
     * @return The current mana
     */
    public int getCurrentMana() {
        return this.currentMana;
    }

    public void addCurrentMana(int mana) {
        setCurrentMana(getCurrentMana() + mana);
    }

    /**
     * Set the maximum of mana
     *
     * @param manaMax The new maximum of mana
     */
    public void setManaMax(int manaMax) {
        if (manaMax < 0) {
            this.manaMax = 0;
        } else {
            this.manaMax = manaMax;
        }
    }

    /**
     * Get the maximum of mana
     *
     * @return The maximum of mana
     */
    public int getManaMax() {
        return this.manaMax;
    }

    public void addManaMax(int mana) {
        setManaMax(mana + getManaMax());
    }

    public int getRegenerateRateLife() {
        return regenerateRateLife;
    }

    public void setRegenerateRateLife(int regenerateRateLife) {
        this.regenerateRateLife = regenerateRateLife;
    }

    public int getRegenerateRateMana() {
        return regenerateRateMana;
    }

    public void setRegenerateRateMana(int regenerateRateMana) {
        this.regenerateRateMana = regenerateRateMana;
    }

    /**
     * Get XP won when the bot is killed
     *
     * @return The XP won
     */
    public int getXpOnKill() {
        return this.xpOnKill;
    }

    /**
     * Set XP won when the bot is killed
     *
     * @param xpOnKill The new XP won
     */
    public void setXpOnKill(int xpOnKill) {
        this.xpOnKill = xpOnKill;
    }

    /**
     * Get the infligeable damage
     *
     * @return The infligeable damage
     */
    public int getInfligeableDamage() {
        return this.infligeableDamage;
    }

    /**
     * Set the new infligeable damage
     *
     * @param infligeableDamage The new infligeable damage
     */
    public void setInfligeableDamage(int infligeableDamage) {
        this.infligeableDamage = infligeableDamage;
    }

    public void addInfligeableDamage(int infligeableDamage) {
        setInfligeableDamage(infligeableDamage + getInfligeableDamage());
    }

    /**
     * Get the damage reduction
     *
     * @return The damage reduction
     */
    public int getDamageReduction() {
        return this.damageReduction;
    }

    /**
     * Set the new damage reduction
     *
     * @param damageReduction The new damage reduction
     */
    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public void addDamageReduction(int damageReduction) {
        setDamageReduction(damageReduction + getDamageReduction());
    }

    /**
     * Get the number of skill point
     *
     * @return The number of skill point
     */
    public int getSkillPoint() {
        return this.skillPoint;
    }

    /**
     * Set the new number of skill point
     *
     * @param skillPoint The new number of skill point
     */
    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    public void addSkillPoint(int skillPoint) {
        this.skillPoint += skillPoint;
    }

    /**
     * Get the number of characteristic point
     *
     * @return The number of characteristic point
     */
    public int getCharacteristicPoint() {
        return this.characteristicPoint;
    }

    /**
     * Set the nex number of characteristic point
     *
     * @param characteristicPoint The new number of characteristic point
     */
    public void setCharacteristicPoint(int characteristicPoint) {
        this.characteristicPoint = characteristicPoint;
    }

    public void addCharacteristicPoint(int characteristicPoint) {
        this.characteristicPoint += characteristicPoint;
    }

    /**
     * Get the number of gold piece
     *
     * @return The number of gold piece
     */
    public int getGold() {
        return gold;
    }

    /**
     * Set a new number of gold piece
     *
     * @param gold The new number of gold piece
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

}
