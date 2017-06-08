import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import state.MainScreenGameState;
import state.MapGameState;

public class StateGame extends StateBasedGame {

    public static void main(String[] args) throws SlickException {
        int maxFPS = 60;
        AppGameContainer app = new AppGameContainer(new StateGame(), 640, 480, true);
        app.setTargetFrameRate(maxFPS);
        app.setShowFPS(false);
        app.setVSync(true);
        app.start();
    }

    public StateGame() {
        super("Game");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MainScreenGameState());
        addState(new MapGameState());
    }

}
