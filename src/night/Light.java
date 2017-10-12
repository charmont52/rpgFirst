package night;

import org.newdawn.slick.Color;

public class Light {

    private float x;
    private float y;
    private int intensity;
    private Color color;
    private int tremble;

    public Light(float x, float y, int intensity) {
        this.x = x;
        this.y = y;
        this.intensity = intensity;
        this.color = Color.white;
        this.tremble = intensity / 10;
    }

    public Light(float x, float y) {
        this.x = x;
        this.y = y;
        this.intensity = 10;
        this.color = Color.white;
        this.tremble = 1;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getIntensity() {
        return intensity;
    }

    public Color getColor() {
        return color;
    }

    public int getTremble() {
        return tremble;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setTremble(int tremble) {
        this.tremble = tremble;
    }

    public int getEffect(int xPos, int yPos) {
        float dx = (this.x - xPos);
        float dy = (this.y - yPos);
        double distance = Math.sqrt(dx * dx + dy * dy);
        double newIntensity = this.tremble * Math.random();
        int effect = (int) (1 - (distance / newIntensity));
        if (effect < 0) {
            effect = 0;
        }
        return effect;
    }

}
