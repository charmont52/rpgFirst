package character;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Iterator;
import java.util.LinkedList;

public class CharacterList {

    private LinkedList<Character> characterList = new LinkedList<>();
    private Player player;

    private final static CharacterList instance = new CharacterList(Player.getInstance());

    private CharacterList(Player player) {
        characterList = new LinkedList<>();
        this.player = player;
        characterList.add(player);
    }

    public static CharacterList getInstance() {
        return instance;
    }

    public Iterator<Character> iterator() {
        return characterList.iterator();
    }

    public void add(Character character) {
        if (!character.getMap().isCollision(character.getX(), character.getY())) {
            characterList.add(character);
        }
    }

    public void init() throws SlickException {
        Iterator<Character> iterator = characterList.iterator();
        while (iterator.hasNext()) {
            iterator.next().init();
        }
    }

    public void render(Graphics g, boolean pause) throws SlickException {
        Iterator<Character> iterator = characterList.iterator();
        while (iterator.hasNext()) {
            iterator.next().render(g, pause);
        }
    }

    public void update(int delta) {
        Iterator<Character> iterator = characterList.iterator();
        while (iterator.hasNext()) {
            Character character = iterator.next();
            character.update(delta);
            if (character.getCurrentLife() <= 0) {
                int xp = character.getXpOnKill();
                Player.getInstance().getLevelProgression().addXp(xp);
                iterator.remove();
            }
        }
    }

}
