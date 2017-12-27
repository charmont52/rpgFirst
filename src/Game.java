import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import state.*;

/**
 * Main class of the game
 */
public class Game extends StateBasedGame {

    public static void main(String[] args) throws SlickException {
        int maxFPS = 60;
        AppGameContainer app = new AppGameContainer(new Game(), 800, 600, true);
        app.setTargetFrameRate(maxFPS);
        app.setShowFPS(false);
        app.setVSync(true);
        app.start();
    }

    /**
     * Default constructor
     */
    public Game() {
        super("Game");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new StartPageState());
        addState(new OptionsState());
        addState(new GameState());
        enterState(StateID.getStateIDNumber(StateID.STARTPAGE));
    }

}
