import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import state.StartPageState;
import state.GameState;
import state.OptionsState;

public class Game extends StateBasedGame {

    public static void main(String[] args) throws SlickException {
        int maxFPS = 60;
        AppGameContainer app = new AppGameContainer(new Game(), 640, 480, true);
        app.setTargetFrameRate(maxFPS);
        app.setShowFPS(false);
        app.setVSync(true);
        app.start();
    }

    public Game() {
        super("Game");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new StartPageState());
        addState(new OptionsState());
        addState(new GameState());
    }

}
