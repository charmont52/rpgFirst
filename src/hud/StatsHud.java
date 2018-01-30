package hud;

import character.Player;
import command.GameCommand;
import controller.GameController;
import graphics.Area;
import graphics.Text;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import sound.SoundEffect;

public class StatsHud implements ComponentListener {

    private GameController controller;
    private int width;
    private int height;
    private int x;
    private int y;
    private GameContainer container;
    private Image backgroundUI;
    private MouseOverArea addLifeButton;
    private MouseOverArea addManaButton;
    private MouseOverArea addAtkButton;
    private MouseOverArea addDefButton;

    public StatsHud(GameController controller) {
        this.controller = controller;
        this.width = 200;
        this.height = 300;
    }

    public void init(GameContainer container) throws SlickException {
        this.x = container.getWidth() / 2 - width / 2;
        this.y = container.getHeight() / 2 - height / 2;
        this.container = container;
        backgroundUI = new Image("src/ressources/hud/background.png");
        Image addButton = new Image("src/ressources/hud/addButton.png");
        addLifeButton = new MouseOverArea(container, addButton, x + width - 17, y + 100, this);
        addManaButton = new MouseOverArea(container, addButton, x + width - 17, y + 120, this);
        addAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 140, this);
        addDefButton = new MouseOverArea(container, addButton, x + width - 17, y + 160, this);
    }

    public void render(Graphics graphics, boolean isDisplayed) {
        if (isDisplayed) {
            graphics.fillRect(x, y, width, height, backgroundUI, 0, 0);
            Area.drawOutline(graphics, container, x, y, width, height);
            Text.drawCenterString(graphics, "Stats", x, y, width, 100);
            int d = 30;

            if (Player.getInstance().getStats().getCharacteristicPoint() > 0) {
                addLifeButton.render(container, graphics);
                addManaButton.render(container, graphics);
                addAtkButton.render(container, graphics);
                addDefButton.render(container, graphics);
            }

            Text.drawAlignString(graphics, "Level :", "" + Player.getInstance().getLevel(), x + d, y + 80, width - 2 * d);
            Text.drawAlignString(graphics, "Life :", "" + Player.getInstance().getStats().getLifeMax(), x + d, y + 100, width - 2 * d);
            Text.drawAlignString(graphics, "Mana :", "" + Player.getInstance().getStats().getManaMax(), x + d, y + 120, width - 2 * d);
            Text.drawAlignString(graphics, "Damage :", "" + Player.getInstance().getStats().getInfligeableDamage(), x + d, y + 140, width - 2 * d);
            Text.drawAlignString(graphics, "Reduction :", "" + Player.getInstance().getStats().getDamageReduction(), x + d, y + 160, width - 2 * d);
        }
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == addLifeButton) {
            controller.controlPressed(GameCommand.ADDLIFE);
        } else if (source == addManaButton) {
            controller.controlPressed(GameCommand.ADDMANA);
        }else if (source == addAtkButton) {
            controller.controlPressed(GameCommand.ADDATK);
        }else if (source == addDefButton) {
            controller.controlPressed(GameCommand.ADDDEF);
        }
    }

}
