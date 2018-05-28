package hud;

import character.Player;
import character.Stats;
import command.GameCommand;
import controller.GameController;
import graphics.BasicWindow;
import graphics.Text;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.MouseOverArea;

public class StatsHud extends BasicWindow {

    private GameController controller;

    private Image addButton;
    private Image subButton;
    private MouseOverArea addLifeButton;
    private MouseOverArea addManaButton;
    private MouseOverArea addPhysicalAtkButton;
    private MouseOverArea addFireAtkButton;
    private MouseOverArea addIceAtkButton;
    private MouseOverArea addEarthAtkButton;
    private MouseOverArea addPhysicalResButton;
    private MouseOverArea addFireResButton;

    public StatsHud(GameController controller) {
        super("Stats");
        this.controller = controller;
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        super.init(container);
        String path = "src/ressources/hud/";
        addButton = new Image(path + "addButton.png");
        subButton = new Image(path + "subButton.png");
        addLifeButton = new MouseOverArea(container, addButton, x + width - 17, y + 100, this);
        addManaButton = new MouseOverArea(container, addButton, x + width - 17, y + 120, this);
        addPhysicalAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 140, this);
        addFireAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 160, this);
        addIceAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 180, this);
        addEarthAtkButton = new MouseOverArea(container, addButton, x + width - 17, y + 200, this);
        addPhysicalResButton = new MouseOverArea(container, addButton, x + width - 17, y + 220, this);
        addFireResButton = new MouseOverArea(container, addButton, x + width - 17, y + 240, this);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        if (displayed) {
            if (Player.getInstance().getStats().getCharacteristicPoint() > 0) {
                addLifeButton.render(container, graphics);
                addManaButton.render(container, graphics);
                addPhysicalAtkButton.render(container, graphics);
                addFireAtkButton.render(container, graphics);
                addIceAtkButton.render(container, graphics);
                addEarthAtkButton.render(container, graphics);
                //addPhysicalResButton.render(container, graphics);
                //addFireResButton.render(container, graphics);
            }

            Stats stats = Player.getInstance().getStats();
            printCarac(graphics, "Level", Player.getInstance().getLevel(), 0);
            printCarac(graphics, "Life", stats.getLifeMax(), 1);
            printCarac(graphics, "Mana", stats.getManaMax(), 2);
            printCarac(graphics, "Physical damage", stats.getInfligeablePhysicalDamage(), 3);
            printCarac(graphics, "Fire damage", stats.getInfligeableFireDamage(), 4);
            printCarac(graphics, "Ice damage", stats.getInfligeableIceDamage(), 5);
            printCarac(graphics, "Earth damage", stats.getInfligeableEarthDamage(), 6);
            printCarac(graphics, "Physical resistance", stats.getPhysicalDamageResistance(), 7);
            printCarac(graphics, "Fire resistance", stats.getFireDamageResistance(), 8);
            printCarac(graphics, "Ice resistance", stats.getIceDamageResistance(), 9);
            printCarac(graphics, "Earth resistance", stats.getEarthDamageResistance(), 10);
            printCarac(graphics, "Life regenerate rate", stats.getRegenerateRateLife(), 11);
            printCarac(graphics, "Mana regenerate rate", stats.getRegenerateRateMana(), 12);
            printCarac(graphics, "Life leech", stats.getLifeLeech(), 13);
            printCarac(graphics, "Mana leech", stats.getManaLeech(), 14);
        }
    }

    private void printCarac(Graphics graphics, String name, int value, int order) {
        int d = 30;
        Text.drawAlignString(graphics, name + " :", "" + value, x + d, y + 80 + 20 * order, width - 2 * d);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        super.componentActivated(source);
        if (source == addLifeButton) {
            controller.controlPressed(GameCommand.ADDLIFE);
        } else if (source == addManaButton) {
            controller.controlPressed(GameCommand.ADDMANA);
        } else if (source == addPhysicalAtkButton) {
            controller.controlPressed(GameCommand.ADDPHYSICALATK);
        } else if (source == addFireAtkButton) {
            controller.controlPressed(GameCommand.ADDFIREATK);
        } else if (source == addIceAtkButton) {
            controller.controlPressed(GameCommand.ADDICEATK);
        } else if (source == addEarthAtkButton) {
            controller.controlPressed(GameCommand.ADDEARTHATK);
        } else if (source == addPhysicalResButton) {
            controller.controlPressed(GameCommand.ADDPHYSICALRES);
        } else if (source == addFireResButton) {
            controller.controlPressed(GameCommand.ADDFIRERES);
        }
    }

}
