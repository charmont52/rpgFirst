package hud;

import character.Player;
import character.Stats;
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
    private Image addButton;
    private Image subButton;
    private MouseOverArea addLifeButton;
    private MouseOverArea addManaButton;
    private MouseOverArea addPhysicalAtkButton;
    private MouseOverArea addMagicAtkButton;
    private MouseOverArea addPhysicalDefButton;
    private MouseOverArea addMagicDefButton;

    public StatsHud(GameController controller) {
        this.controller = controller;
        this.width = 300;
        this.height = 400;
    }

    public void init(GameContainer container) throws SlickException {
        this.x = container.getWidth() / 2 - width / 2;
        this.y = container.getHeight() / 2 - height / 2;
        this.container = container;
        String path = "src/ressources/hud/";
        backgroundUI = new Image(path + "background.png");
        addButton = new Image(path + "addButton.png");
        subButton = new Image(path + "subButton.png");
        addLifeButton = new MouseOverArea(container, addButton, x + width - 17, y + 100, this);
        addManaButton = new MouseOverArea(container, addButton, x + width - 17, y + 120, this);
        addPhysicalAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 140, this);
        addMagicAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 160, this);
        addPhysicalDefButton = new MouseOverArea(container, addButton, x + width - 17, y + 180, this);
        addMagicDefButton = new MouseOverArea(container, addButton, x + width - 17, y + 200, this);
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
                addPhysicalAtkButton.render(container, graphics);
                addMagicAtkButton.render(container, graphics);
                addPhysicalDefButton.render(container, graphics);
                addMagicDefButton.render(container, graphics);
            }

            Stats stats = Player.getInstance().getStats();
            Text.drawAlignString(graphics, "Level :", "" + Player.getInstance().getLevel(), x + d, y + 80, width - 2 * d);
            Text.drawAlignString(graphics, "Life :", "" + stats.getLifeMax(), x + d, y + 100, width - 2 * d);
            Text.drawAlignString(graphics, "Mana :", "" + stats.getManaMax(), x + d, y + 120, width - 2 * d);
            Text.drawAlignString(graphics, "Physical damage :", "" + stats.getInfligeablePhysicalDamage(), x + d, y + 140, width - 2 * d);
            Text.drawAlignString(graphics, "Magical damage :", "" + stats.getInfligeableMagicDamage(), x + d, y + 160, width - 2 * d);
            Text.drawAlignString(graphics, "Physical reduction :", "" + stats.getPhysicalDamageReduction(), x + d, y + 180, width - 2 * d);
            Text.drawAlignString(graphics, "Magical reduction :", "" + stats.getMagicDamageReduction(), x + d, y + 200, width - 2 * d);
        }
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == addLifeButton) {
            controller.controlPressed(GameCommand.ADDLIFE);
        } else if (source == addManaButton) {
            controller.controlPressed(GameCommand.ADDMANA);
        } else if (source == addPhysicalAtkButton) {
            controller.controlPressed(GameCommand.ADDPHYSICALATK);
        } else if (source == addMagicAtkButton) {
            controller.controlPressed(GameCommand.ADDMAGICATK);
        } else if (source == addPhysicalDefButton) {
            controller.controlPressed(GameCommand.ADDPHYSICALDEF);
        } else if (source == addMagicDefButton) {
            controller.controlPressed(GameCommand.ADDMAGICDEF);
        }
    }

}
