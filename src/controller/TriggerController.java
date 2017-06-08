package controller;

import character.Player;
import map.Map;
import org.newdawn.slick.SlickException;

public class TriggerController {

    private Map map;
    private Player player;

    public TriggerController(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    public void update() throws SlickException {
        this.player.setOnStair(false);
        for (int objectID = 0; objectID < this.map.getObjectCount(); objectID++) {
            if (isInTrigger(objectID)) {
                String type = this.map.getObjectType(objectID);
                if ("teleport".equals(type)) {
                    teleport(objectID);
                } else if ("stair".equals(type)) {
                    this.player.setOnStair(true);
                } else if ("changeMap".equals(type)) {
                    changeMap(objectID);
                }
            }
        }
    }

    private void changeMap(int objectID) throws SlickException {
        teleport(objectID);
        String newMap = this.map.getObjectProperty(objectID, "destMap", "undefined");
        if (!"undefined".equals(newMap)) {
            this.map.changeMap("src/ressources/map/" + newMap);
        }
    }

    private boolean isInTrigger(int id) {
        return player.getX() > map.getObjectX(id)
                && player.getX() < map.getObjectX(id) + map.getObjectWidth(id)
                && player.getY() > map.getObjectY(id)
                && player.getY() < map.getObjectY(id) + map.getObjectHeight(id);
    }

    private void teleport(int id) {
        this.player.setX(Float.parseFloat(this.map.getObjectProperty(id, "destX", Float.toString(this.player.getX()))));
        this.player.setY(Float.parseFloat(this.map.getObjectProperty(id, "destY", Float.toString(this.player.getY()))));
    }

}
