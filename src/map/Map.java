package map;

import character.Player;
import graphics.Fire;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class using the singleton pattern and managing the map
 */
public class Map {

    private TiledMap tiledMap;
    private String nameMap;
    private LinkedList<Fire> fireLinkedList;

    private Map() {
        this.fireLinkedList = new LinkedList<>();
    }

    private final static Map instance = new Map();

    /**
     * Get the Map instance
     *
     * @return The Map instance
     */
    static public Map getInstance() {
        return instance;
    }

    /**
     * Get the height of map in pixel
     *
     * @return The height of map
     */
    public int getHeight() {
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    /**
     * Get the width of map in pixel
     *
     * @return The width of map
     */
    public int getWidth() {
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

    /**
     * Get the tile number for height of map
     *
     * @return The tile number for height of map
     */
    public int getHeightNbTile() {
        return tiledMap.getHeight();
    }

    /**
     * Get the tile number for width of map
     *
     * @return The tile number for width of map
     */
    public int getWidthNbTile() {
        return tiledMap.getWidth();
    }

    /**
     * Get the width of tiles
     *
     * @return The width of tiles
     */
    public int getTileWidth() {
        return tiledMap.getTileWidth();
    }

    /**
     * Get the height of tiles
     *
     * @return The height of tiles
     */
    public int getTileHeight() {
        return tiledMap.getTileHeight();
    }

    /**
     * Get the map name
     *
     * @return The map name
     */
    public String getNameMap() {
        return this.nameMap;
    }

    /**
     * Init the map
     *
     * @throws SlickException
     */
    public void init() throws SlickException {
        this.nameMap = "src/ressources/map/fullscreenMap.tmx";
        this.tiledMap = new TiledMap(nameMap);
        fireLinkedList.add(new Fire(200, 200, nameMap));
    }

    /**
     * Render the background
     */
    public void renderBackground() {
        this.tiledMap.render(0, 0, 0);
        this.tiledMap.render(0, 0, 1);
        this.tiledMap.render(0, 0, 2);
    }

    /**
     * Render the foreground
     *
     * @param g
     * @throws SlickException
     */
    public void renderForeground(Graphics g, boolean pause) throws SlickException {
        this.tiledMap.render(0, 0, 3);
        Iterator<Fire> iterator = fireLinkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next().render(g, pause);
        }
    }

    /**
     * Check if there is a collision with the position (x,y)
     *
     * @param x The abscissa
     * @param y The ordered
     * @return True if there is a collision
     */
    public boolean isCollision(float x, float y) {
        int tileW = this.tiledMap.getTileWidth();
        int tileH = this.tiledMap.getTileHeight();
        int logicLayer = this.tiledMap.getLayerIndex("logic");
        Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        return tile != null;
    }

    /**
     * Get the object count
     *
     * @return The object count
     */
    public int getObjectCount() {
        return this.tiledMap.getObjectCount(0);
    }

    /**
     * Get the object type
     *
     * @param objectID The objectID
     * @return The object type
     */
    public String getObjectType(int objectID) {
        return this.tiledMap.getObjectType(0, objectID);
    }

    /**
     * Get the object abscissa
     *
     * @param objectID The object ID
     * @return The object abscissa
     */
    public float getObjectX(int objectID) {
        return this.tiledMap.getObjectX(0, objectID);
    }

    /**
     * Get the object ordered
     *
     * @param objectID The object ID
     * @return The object ordered
     */
    public float getObjectY(int objectID) {
        return this.tiledMap.getObjectY(0, objectID);
    }

    /**
     * Get the object width
     *
     * @param objectID The object ID
     * @return The object width
     */
    public float getObjectWidth(int objectID) {
        return this.tiledMap.getObjectWidth(0, objectID);
    }

    /**
     * Get the object height
     *
     * @param objectID The object ID
     * @return The object ID
     */
    public float getObjectHeight(int objectID) {
        return this.tiledMap.getObjectHeight(0, objectID);
    }

    /**
     * Get the object property
     *
     * @param objectID     The object ID
     * @param propertyName The property name
     * @param def          Def
     * @return The object property
     */
    public String getObjectProperty(int objectID, String propertyName, String def) {
        return this.tiledMap.getObjectProperty(0, objectID, propertyName, def);
    }

    /**
     * Change the current map with a new map
     *
     * @param file The file containing the new map
     * @throws SlickException
     */
    public void changeMap(String file) throws SlickException {
        this.nameMap = file;
        Player.getInstance().setMapName(file);
        this.tiledMap = new TiledMap(file);
    }

    @Override
    public boolean equals(Object object) {
        return this.nameMap.equals(((Map) object).getNameMap());
    }

}
