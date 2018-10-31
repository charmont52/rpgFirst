package graphics;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import sound.SoundEffect;

/**
 * Class to draw basic windows
 */
public class BasicWindow implements ComponentListener {

    protected int width;
    protected int height;
    protected int x;
    protected int y;
    private String title;
    protected GameContainer container;
    private Image backgroundUI;
    private Image woodBackgroundUI;
    protected Image addButton;
    protected Image subButton;
    private MouseOverArea closeButton;
    protected boolean displayed;
    private boolean isClosable;

    public BasicWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.displayed = false;
        this.isClosable = true;
    }

    public BasicWindow(String title) {
        this(300, 400, title);
    }

    public BasicWindow(String title, boolean isClosable) {
        this(title);
        this.isClosable = isClosable;
        // If the window is not closable, always display the window
        if (!isClosable) {
            this.displayed = true;
        }
    }

    public void init(GameContainer container) throws SlickException {
        this.container = container;
        this.x = container.getWidth() / 2 - width / 2;
        this.y = container.getHeight() / 2 - height / 2;
        String path = "src/ressources/hud/";
        backgroundUI = new Image(path + "background.png");
        woodBackgroundUI = new Image(path + "wood_background.png");
        addButton = new Image(path + "addButton.png");
        subButton = new Image(path + "subButton.png");
        closeButton = new MouseOverArea(container, new Image(path + "close.png"), x + width - 19, y + 8, this);
    }

    public void render(Graphics graphics) {
        if (displayed) {
            int heightTitle = graphics.getFont().getHeight(title) + 10;
            graphics.fillRect(x, y, width, height, backgroundUI, 0, 0);
            graphics.fillRect(x, y, width, heightTitle + 8, woodBackgroundUI, 0, 0);
            Area.drawOutline(graphics, container, x, y, width, height);
            Area.drawOutline(graphics, container, x, y, width, heightTitle + 8);
            Area.drawOutline(graphics, container, x + 2, y + 2, width - 4, heightTitle + 4);
            Text.drawCenterString(graphics, title, x + 2, y + 2, width - 4, heightTitle + 4);
            if (isClosable) {
                closeButton.render(container, graphics);
            }
        }
    }

    public void setDisplayed(boolean displayed) {
        if (isClosable) {
            this.displayed = displayed;
        }
    }

    public boolean getDisplayed() {
        return this.displayed;
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == closeButton && isClosable) {
            displayed = false;
        }
    }

}
