package state;

import camera.Camera;
import character.*;
import controller.GameController;
import controller.PlayerController;
import controller.TriggerController;
import hud.GameHud;
import map.Map;
import night.Night;
import org.newdawn.slick.*;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundTrack;

public class GameState extends BasicGameState {

    public static final int ID = StateID.getStateIDNumber(StateID.GAME);
    private GameContainer container;
    private Map map = Map.getInstance();
    private Player player = Player.getInstance();
    private CharacterList characterList = CharacterList.getInstance();
    private Camera camera = new Camera();
    private TriggerController triggers = new TriggerController(map);
    private GameHud hud;
    private boolean pause;

    /**
     * Check if the game is in pause
     *
     * @return True if the game is in pauset
     */
    public boolean isPause() {
        return pause;
    }

    /**
     * Set the value of the pause parameter
     *
     * @param value The value of the pause parameter
     */
    public void setPause(boolean value) {
        pause = value;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // container.setMouseCursor("src/ressources/hud/dwarven_gauntlet.png", 0, 0);
        this.map.init();
        // Generate the bots
        CharacterGenerator characterGenerator = new CharacterGenerator(map);
        characterGenerator.generate(8,8,0,true);
        //characterGenerator.generate(5,5,10,false, 100, 100);
        this.container = container;
        this.characterList.init();
        PlayerController playerController = new PlayerController();
        container.getInput().addKeyListener(playerController);

        InputProvider provider = new InputProvider(container.getInput());
        GameController gameController = new GameController(game, this);
        provider.addListener(gameController);
        container.getInput().addKeyListener(gameController);
        this.hud = new GameHud(gameController);
        this.hud.init(container, game);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        this.camera.place(container, g);
        this.map.renderBackground();
        this.characterList.render(g, pause);
        this.map.renderForeground(g, pause);
        this.player.renderHudList(g);
        Night.render(container, g, this.camera.getX(), this.camera.getY());
        this.hud.render(container, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (!pause) {
            Clock.addTime(delta);
            this.triggers.update();
            this.characterList.update(delta);
            this.camera.update(container);
        }
    }

    @Override
    public void keyReleased(int key, char c) {
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        SoundTrack.loop(StateID.GAME);
        HistoryState.addState(StateID.GAME);
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
    }

}
