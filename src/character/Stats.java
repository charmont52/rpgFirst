package character;

public class Stats {

    /**
     * Life
     */
    private int lifeMax;
    private int currentLife;
    private int regenerateRateLife;
    private int lifeLeech;

    /**
     * Mana
     */
    private int manaMax;
    private int currentMana;
    private int regenerateRateMana;
    private int manaLeech;

    /**
     * Speed
     */
    private float speedMax;
    private float currentSpeed;

    /**
     * Gain on kill
     */
    private int xpOnKill;
    private int goldOnKill;

    /**
     * Damage
     */
    private int infligeablePhysicalDamage;
    private int infligeableMagicDamage;
    private int physicalDamageReduction;
    private int magicDamageReduction;

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
        this.lifeLeech = 0;
        this.manaMax = 5;
        this.currentMana = 5;
        this.manaLeech = 0;
        this.speedMax = 0.2f;
        this.currentSpeed = 0.2f;
        this.xpOnKill = 5;
        this.goldOnKill = 2;
        this.infligeablePhysicalDamage = 1;
        this.infligeableMagicDamage = 1;
        this.physicalDamageReduction = 0;
        this.magicDamageReduction = 0;
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
        this.lifeMax = Math.max(lifeMax, 0);
    }

    /**
     * Get the maximum of life
     *
     * @return The maximum of life
     */
    public int getLifeMax() {
        return this.lifeMax;
    }

    /**
     * Increase the maximum of life
     *
     * @param life The quantity of life added
     */
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

    /**
     * Add life to the current life
     *
     * @param life The quantity of life added
     */
    public void addCurrentLife(int life) {
        setCurrentLife(life + getCurrentLife());
    }

    /**
     * Get the life leech in percentage
     *
     * @return The life leech
     */
    public int getLifeLeech() {
        return lifeLeech;
    }

    /**
     * Set the life leech in percentage
     *
     * @param lifeLeech The new life leech
     */
    public void setLifeLeech(int lifeLeech) {
        this.lifeLeech = Math.max(lifeLeech, 0);
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

    /**
     * Add mana to the current mana
     *
     * @param mana The quantity of mana added
     */
    public void addCurrentMana(int mana) {
        setCurrentMana(getCurrentMana() + mana);
    }

    /**
     * Set the maximum of mana
     *
     * @param manaMax The new maximum of mana
     */
    public void setManaMax(int manaMax) {
        this.manaMax = Math.max(manaMax, 0);
    }

    /**
     * Get the maximum of mana
     *
     * @return The maximum of mana
     */
    public int getManaMax() {
        return this.manaMax;
    }

    /**
     * Increase the maximum of mana
     *
     * @param mana The quantity of mana added
     */
    public void addManaMax(int mana) {
        setManaMax(mana + getManaMax());
    }

    /**
     * Get the mana leech in percentage
     *
     * @return The mana leech
     */
    public int getManaLeech() {
        return manaLeech;
    }

    /**
     * Set the mana leech in percentage
     *
     * @param manaLeech The new mana leech
     */
    public void setManaLeech(int manaLeech) {
        this.manaLeech = Math.max(manaLeech, 0);
    }

    /**
     * Get the life regenerate rate
     *
     * @return The life regenerate rate
     */
    public int getRegenerateRateLife() {
        return regenerateRateLife;
    }

    /**
     * Set the life regenerate rate
     *
     * @param regenerateRateLife The new life regenerate rate
     */
    public void setRegenerateRateLife(int regenerateRateLife) {
        this.regenerateRateLife = regenerateRateLife;
    }

    /**
     * Get the mana regenerate rate
     *
     * @return The mana regenerate rate
     */
    public int getRegenerateRateMana() {
        return regenerateRateMana;
    }

    /**
     * Set the mana regenerate rate
     *
     * @param regenerateRateMana The new mana regenerate rate
     */
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
        this.xpOnKill = Math.max(xpOnKill, 0);
    }

    /**
     * Get gold won when the bot is killed
     *
     * @return The gold won
     */
    public int getGoldOnKill() {
        return goldOnKill;
    }

    /**
     * Set gold won when the bot is killed
     *
     * @param goldOnKill The new gold won
     */
    public void setGoldOnKill(int goldOnKill) {
        this.goldOnKill = Math.max(goldOnKill, 0);
    }

    /**
     * Get the infligeable physical damage
     *
     * @return The infligeable physical damage
     */
    public int getInfligeablePhysicalDamage() {
        return this.infligeablePhysicalDamage;
    }

    /**
     * Set the new infligeable physical damage
     *
     * @param infligeablePhysicalDamage The new infligeable physical damage
     */
    public void setInfligeablePhysicalDamage(int infligeablePhysicalDamage) {
        this.infligeablePhysicalDamage = infligeablePhysicalDamage;
    }

    /**
     * Add a number of physical damage to the current physical damage
     *
     * @param infligeableDamage The number of physical damage
     */
    public void addInfligeablePhysicalDamage(int infligeableDamage) {
        setInfligeablePhysicalDamage(infligeableDamage + getInfligeablePhysicalDamage());
    }

    /**
     * Get the infligeable magic damage
     *
     * @return The infligeable magic damage
     */
    public int getInfligeableMagicDamage() {
        return infligeableMagicDamage;
    }

    /**
     * Set the new infligeable magic damage
     *
     * @param infligeableMagicDamage The new infligeable magic damage
     */
    public void setInfligeableMagicDamage(int infligeableMagicDamage) {
        this.infligeableMagicDamage = infligeableMagicDamage;
    }

    /**
     * Add a number of magic damage to the current physical damage
     *
     * @param infligeableDamage The number of magic damage
     */
    public void addInfligeableMagicDamage(int infligeableDamage) {
        setInfligeableMagicDamage(infligeableDamage + getInfligeableMagicDamage());
    }

    /**
     * Get the physical damage reduction
     *
     * @return The physical damage reduction
     */
    public int getPhysicalDamageReduction() {
        return this.physicalDamageReduction;
    }

    /**
     * Set the new physical damage reduction
     *
     * @param physicalDamageReduction The new physical damage reduction
     */
    public void setPhysicalDamageReduction(int physicalDamageReduction) {
        this.physicalDamageReduction = physicalDamageReduction;
    }

    /**
     * Add a number of physical damage reduction to the current physical damage reduction
     *
     * @param damageReduction The number of physical damage reduction
     */
    public void addPhysicalDamageReduction(int damageReduction) {
        setPhysicalDamageReduction(damageReduction + getPhysicalDamageReduction());
    }

    /**
     * Get the magic damage reduction
     *
     * @return The magic damage reduction
     */
    public int getMagicDamageReduction() {
        return magicDamageReduction;
    }

    /**
     * Set the new magic damage reduction
     *
     * @param magicDamageReduction The new magic damage reduction
     */
    public void setMagicDamageReduction(int magicDamageReduction) {
        this.magicDamageReduction = magicDamageReduction;
    }

    /**
     * Add a number of magic damage reduction to the current magic damage reduction
     *
     * @param damageReduction The number of magic damage reduction
     */
    public void addMagicDamageReduction(int damageReduction) {
        setMagicDamageReduction(damageReduction + getMagicDamageReduction());
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

    /**
     * Add or sub a skill point
     *
     * @param skillPoint The number of skill point won or used
     */
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

    /**
     * Add or sub a characteristic point
     *
     * @param characteristicPoint The number of characteristic point won or used
     */
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

    /**
     * Add a quantity of gold to the current gold
     *
     * @param gold The quantity of gold
     */
    public void addGold(int gold) {
        this.gold += gold;
    }

}
