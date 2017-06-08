package state;

import camera.Camera;
import character.*;
import controller.MapGameController;
import controller.PlayerController;
import controller.TriggerController;
import hud.MapGameHud;
import map.Map;
import org.newdawn.slick.*;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MapGameState extends BasicGameState {

    public static final int ID = 2;

    private GameContainer container;
    private Map map = Map.getInstance();
    private Player player = Player.getInstance();
    private CharacterList characterList = CharacterList.getInstance();
    private Camera camera = new Camera(player);
    private TriggerController triggers = new TriggerController(map, player);
    private Music music;
    private MapGameHud hud;


    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.map.init();
        for (int j = 0; j<10; j++) {
            Bot bot = new Bot(map,(float) Math.random()*1920,(float) Math.random()*1080,"src/ressources/sprites/sprite1.png", Behaviour.AGRESSIVE);
            characterList.add(bot);
            Slime slime = new Slime(map,(float) Math.random()*1920,(float) Math.random()*1080,"", Behaviour.AGRESSIVE);
            characterList.add(slime);
        }
        this.container = container;
        this.characterList.init();
        PlayerController playerController = new PlayerController(this.player);
        container.getInput().addKeyListener(playerController);
        music = new Music("src/ressources/sound/OveMelaaApproachingTheGreenGrass.ogg");

        InputProvider provider = new InputProvider(container.getInput());
        MapGameController mapGameController = new MapGameController(game, container);
        provider.addListener(mapGameController);
        this.hud = new MapGameHud(mapGameController);
        this.hud.init(container,game);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        this.camera.place(container,g);
        this.map.renderBackground();
        this.characterList.render(g);
        this.map.renderForeground();
        this.player.renderHudList(g);
        this.hud.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        this.triggers.update();
        this.characterList.update(delta);
        this.camera.update(container);
    }

    @Override
    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_ESCAPE:
                this.container.exit();
                break;
        }
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        music.loop(1,0);
        music.fade(1500,1,false);
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
        music.stop();
    }

}
