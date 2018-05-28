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
    private float moveSpeedMax;
    private float currentMoveSpeed;
    private float currentAtkSpeed;
    private float currentCastSpeed;

    /**
     * Gain on kill
     */
    private int xpOnKill;
    private int goldOnKill;

    /**
     * Damage
     */
    private int infligeablePhysicalDamage;
    private int infligeableFireDamage;
    private int infligeableIceDamage;
    private int infligeableEarthDamage;
    private int physicalDamageResistance;
    private int fireDamageResistance;
    private int iceDamageResistance;
    private int earthDamageResistance;

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
        this.moveSpeedMax = 0.2f;
        this.currentMoveSpeed = 0.2f;
        this.currentAtkSpeed = 1.0f;
        this.currentCastSpeed = 1.0f;
        this.xpOnKill = 5;
        this.goldOnKill = 2;
        this.infligeablePhysicalDamage = 1;
        this.infligeableFireDamage = 1;
        this.infligeableIceDamage = 1;
        this.infligeableEarthDamage = 1;
        this.physicalDamageResistance = 0;
        this.fireDamageResistance = 0;
        this.iceDamageResistance = 0;
        this.earthDamageResistance = 0;
        this.skillPoint = 0;
        this.characteristicPoint = 0;
        this.gold = 0;
        this.regenerateRateLife = 1;
        this.regenerateRateMana = 1;
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
     * Get the max speed
     *
     * @return The max speed
     */
    public float getMoveSpeedMax() {
        return this.moveSpeedMax;
    }

    /**
     * Set the max speed
     *
     * @param speed The new max speed
     */
    public void setMoveSpeedMax(float speed) {
        this.moveSpeedMax = speed;
    }

    /**
     * Get the current speed
     *
     * @return The current speed
     */
    public float getCurrentMoveSpeed() {
        return this.currentMoveSpeed;
    }

    /**
     * Set the current speed
     *
     * @param speed The new current speed
     */
    public void setCurrentMoveSpeed(float speed) {
        this.currentMoveSpeed = speed;
    }

    /**
     * Get the current attack speed
     *
     * @return The current attack speed
     */
    public float getCurrentAtkSpeed() {
        return currentAtkSpeed;
    }

    /**
     * Set the current attack speed
     *
     * @param currentAtkSpeed The new current attack speed
     */
    public void setCurrentAtkSpeed(float currentAtkSpeed) {
        this.currentAtkSpeed = currentAtkSpeed;
    }

    /**
     * Get the current cast speed
     *
     * @return The current cast speed
     */
    public float getCurrentCastSpeed() {
        return currentCastSpeed;
    }

    /**
     * Set the current cast speed
     *
     * @param currentCastSpeed The new current cast speed
     */
    public void setCurrentCastSpeed(float currentCastSpeed) {
        this.currentCastSpeed = currentCastSpeed;
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
     * @param infligeablePhysicalDamage The number of physical damage
     */
    public void addInfligeablePhysicalDamage(int infligeablePhysicalDamage) {
        setInfligeablePhysicalDamage(infligeablePhysicalDamage + getInfligeablePhysicalDamage());
    }

    /**
     * Get the infligeable fire damage
     *
     * @return The infligeable fire damage
     */
    public int getInfligeableFireDamage() {
        return infligeableFireDamage;
    }

    /**
     * Set the new infligeable fire damage
     *
     * @param infligeableFireDamage The new infligeable fire damage
     */
    public void setInfligeableFireDamage(int infligeableFireDamage) {
        this.infligeableFireDamage = infligeableFireDamage;
    }

    /**
     * Add a number of fire damage to the current fire damage
     *
     * @param infligeableFireDamage The number of fire damage
     */
    public void addInfligeableFireDamage(int infligeableFireDamage) {
        setInfligeableFireDamage(infligeableFireDamage + getInfligeableFireDamage());
    }

    /**
     * Get the infligeable ice damage
     *
     * @return The infligeable ice damage
     */
    public int getInfligeableIceDamage() {
        return infligeableIceDamage;
    }

    /**
     * Set the new infligeable ice damage
     *
     * @param infligeableIceDamage The new infligeable ice damage
     */
    public void setInfligeableIceDamage(int infligeableIceDamage) {
        this.infligeableIceDamage = infligeableIceDamage;
    }

    /**
     * Add a number of ice damage to the current ice damage
     *
     * @param infligeableIceDamage The number of ice damage
     */
    public void addInfligeableIceDamage(int infligeableIceDamage) {
        setInfligeableIceDamage(infligeableIceDamage + getInfligeableIceDamage());
    }

    /**
     * Get the infligeable earth damage
     *
     * @return The infligeable earth damage
     */
    public int getInfligeableEarthDamage() {
        return infligeableEarthDamage;
    }

    /**
     * Set the new infligeable earth damage
     *
     * @param infligeableEarthDamage The new infligeable earth damage
     */
    public void setInfligeableEarthDamage(int infligeableEarthDamage) {
        this.infligeableEarthDamage = infligeableEarthDamage;
    }

    /**
     * Add a number of earth damage to the current earth damage
     *
     * @param infligeableEarthDamage The number of earth damage
     */
    public void addInfligeableEarthDamage(int infligeableEarthDamage) {
        setInfligeableEarthDamage(infligeableEarthDamage + getInfligeableEarthDamage());
    }

    /**
     * Get the physical damage resistance
     *
     * @return The physical damage resistance
     */
    public int getPhysicalDamageResistance() {
        return this.physicalDamageResistance;
    }

    /**
     * Set the new physical damage resistance
     *
     * @param physicalDamageResistance The new physical damage resistance
     */
    public void setPhysicalDamageResistance(int physicalDamageResistance) {
        this.physicalDamageResistance = physicalDamageResistance;
    }

    /**
     * Add a number of physical damage reduction to the current physical damage resistance
     *
     * @param damageResistance The number of physical damage resistance
     */
    public void addPhysicalDamageResistance(int damageResistance) {
        setPhysicalDamageResistance(damageResistance + getPhysicalDamageResistance());
    }

    /**
     * Get the fire damage resistance
     *
     * @return The fire damage resistance
     */
    public int getFireDamageResistance() {
        return fireDamageResistance;
    }

    /**
     * Set the new fire damage resistance
     *
     * @param fireDamageResistance The new fire damage resistance
     */
    public void setFireDamageResistance(int fireDamageResistance) {
        this.fireDamageResistance = fireDamageResistance;
    }

    /**
     * Add a number of fire damage reduction to the current fire damage resistance
     *
     * @param damageFireResistance The number of fire damage resistance
     */
    public void addFireDamageResistance(int damageFireResistance) {
        setFireDamageResistance(damageFireResistance + getFireDamageResistance());
    }

    /**
     * Get the ice damage resistance
     *
     * @return The ice damage resistance
     */
    public int getIceDamageResistance() {
        return iceDamageResistance;
    }

    /**
     * Set the new ice damage resistance
     *
     * @param iceDamageResistance The new ice damage resistance
     */
    public void setIceDamageResistance(int iceDamageResistance) {
        this.iceDamageResistance = iceDamageResistance;
    }

    /**
     * Add a number of ice damage reduction to the current ice damage resistance
     *
     * @param damageIceResistance The number of ice damage resistance
     */
    public void addIceDamageResistance(int damageIceResistance) {
        setIceDamageResistance(damageIceResistance + getIceDamageResistance());
    }

    /**
     * Get the earth damage resistance
     *
     * @return The earth damage resistance
     */
    public int getEarthDamageResistance() {
        return earthDamageResistance;
    }

    /**
     * Set the new earth damage resistance
     *
     * @param earthDamageResistance The new earth damage resistance
     */
    public void setEarthDamageResistance(int earthDamageResistance) {
        this.earthDamageResistance = earthDamageResistance;
    }

    /**
     * Add a number of earth damage reduction to the current earth damage resistance
     *
     * @param damageEarthResistance The number of earth damage resistance
     */
    public void addEarthDamageResistance(int damageEarthResistance) {
        setEarthDamageResistance(damageEarthResistance + getEarthDamageResistance());
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
