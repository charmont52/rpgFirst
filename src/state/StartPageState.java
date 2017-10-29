package state;

import controller.StartPageController;
import hud.StartPageHud;
import org.newdawn.slick.*;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundTrack;

public class StartPageState extends BasicGameState {

    public static final int ID = StateID.getStateIDNumber(StateID.STARTPAGE);
    private Image background;
    private StateBasedGame game;
    private StartPageHud hud;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
        this.background = new Image("src/ressources/background/background29.jpg");

        InputProvider provider = new InputProvider(container.getInput());
        StartPageController controller = new StartPageController(game, container);
        provider.addListener(controller);
        this.hud = new StartPageHud(controller);
        this.hud.init(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.draw(0, 0, container.getWidth(), container.getHeight());
        this.hud.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
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
        if (HistoryState.getLastState() != StateID.OPTIONS) {
            SoundTrack.loop(StateID.STARTPAGE);
        }
        HistoryState.addState(StateID.STARTPAGE);
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
    }


}
