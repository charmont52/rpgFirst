package map;

import character.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.tiled.TiledMap;
import state.Clock;

import java.util.Objects;

public class Map {

    private TiledMap tiledMap;
    private String nameMap;

    private Map() {}

    private final static Map instance = new Map();

    static public Map getInstance() {
        return instance;
    }

    public int getHeight() {
        return tiledMap.getHeight();
    }

    public int getWidth() {
        return tiledMap.getWidth();
    }

    public int getTileWidth() {
        return tiledMap.getTileWidth();
    }

    public int getTileHeight() {
        return tiledMap.getTileHeight();
    }

    public String getNameMap() {
        return this.nameMap;
    }

    public void init() throws SlickException {
        this.nameMap = "src/ressources/map/fullscreenMap.tmx";
        this.tiledMap = new TiledMap(nameMap);
    }

    public void renderBackground() {
        this.tiledMap.render(0, 0, 0);
        this.tiledMap.render(0, 0, 1);
        this.tiledMap.render(0, 0, 2);
    }

    public void renderForeground(Graphics g) throws SlickException {
        this.tiledMap.render(0, 0, 3);
        if (Clock.isNight()) {
            Color blueNight = new Color(10,10,25,220);
            g.setColor(blueNight);
            g.fillRect(Player.getInstance().getX()-900,Player.getInstance().getY()-700,1800,1400);
            /*g.setDrawMode(g.MODE_ADD);
            g.setColor(new Color(50,50,50));
            g.fillOval(Player.getInstance().getX()-16,Player.getInstance().getY()-32,50,50);
            g.setDrawMode(g.MODE_NORMAL);*/
            //Color reset = new Color(255,255,255,150);
            //g.setColor(reset);
            //g.fillOval(Player.getInstance().getX(),Player.getInstance().getY(),100,100);
        }
    }

    public boolean isCollision(float x, float y) {
        int tileW = this.tiledMap.getTileWidth();
        int tileH = this.tiledMap.getTileHeight();
        int logicLayer = this.tiledMap.getLayerIndex("logic");
        Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        return collision;
    }

    public int getObjectCount() {
        return this.tiledMap.getObjectCount(0);
    }
    public String getObjectType(int objectID) {
        return this.tiledMap.getObjectType(0, objectID);
    }
    public float getObjectX(int objectID) {
        return this.tiledMap.getObjectX(0, objectID);
    }
    public float getObjectY(int objectID) {
        return this.tiledMap.getObjectY(0, objectID);
    }
    public float getObjectWidth(int objectID) {
        return this.tiledMap.getObjectWidth(0, objectID);
    }
    public float getObjectHeight(int objectID) {
        return this.tiledMap.getObjectHeight(0, objectID);
    }
    public String getObjectProperty(int objectID, String propertyName, String def) {
        return this.tiledMap.getObjectProperty(0, objectID, propertyName, def);
    }

    public void changeMap(String file) throws SlickException {
        this.nameMap = file;
        Player.getInstance().setNameMap(file);
        this.tiledMap = new TiledMap(file);
    }

    @Override
    public boolean equals(Object object) {
        return (this.nameMap == ((Map) object).getNameMap());
    }

}
