package hud;

import command.OptionsCommand;
import controller.OptionsController;
import graphics.BasicWindow;
import graphics.Text;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.MouseOverArea;

public class OptionsHud extends BasicWindow {

    private MouseOverArea downSound;
    private MouseOverArea upSound;
    private int marge;
    private OptionsController controller;

    public OptionsHud(OptionsController controller) {
        super("Options", false);
        this.marge = 15;
        this.controller = controller;
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        super.init(container);
        downSound = new MouseOverArea(container, subButton, x + marge, y + height / 2 - subButton.getHeight() / 2, this);
        upSound = new MouseOverArea(container, addButton, x + width - (addButton.getWidth() + marge), y + height / 2 - subButton.getHeight() / 2, this);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        Text.drawCenterString(graphics, "Sound level", x, y, width, height);
        downSound.render(container, graphics);
        upSound.render(container, graphics);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        super.componentActivated(source);
        if (source == downSound) {
            controller.controlPressed(OptionsCommand.DOWNSOUND);
        } else if (source == upSound) {
            controller.controlPressed(OptionsCommand.UPSOUND);
        }
    }

}
