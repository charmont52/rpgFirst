package hud;

import command.StartPageCommand;
import controller.StartPageController;
import graphics.Text;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import sound.SoundEffect;

public class StartPageHud implements ComponentListener {

    private StartPageController controller;
    private MouseOverArea startButton;
    private MouseOverArea optionsButton;
    private MouseOverArea creditsButton;
    private MouseOverArea exitButton;

    public StartPageHud(StartPageController controller) {
        this.controller = controller;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Image buttonImage = new Image("src/ressources/hud/button.png");
        int centreX = container.getWidth()/2 - buttonImage.getWidth()/2;
        int centreY = container.getHeight()/2 - buttonImage.getHeight()/2;
        startButton = new MouseOverArea(container, buttonImage, centreX, centreY - 150, this);
        optionsButton = new MouseOverArea(container, buttonImage, centreX, centreY - 50, this);
        creditsButton = new MouseOverArea(container, buttonImage, centreX, centreY + 50, this);
        exitButton = new MouseOverArea(container, buttonImage, centreX, centreY + 150, this);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        startButton.render(container, g);
        Text.drawCenterString(startButton,"Jouer",g);
        optionsButton.render(container, g);
        Text.drawCenterString(optionsButton,"Options",g);
        creditsButton.render(container, g);
        Text.drawCenterString(creditsButton,"Crédits",g);
        exitButton.render(container, g);
        Text.drawCenterString(exitButton,"Quitter",g);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        SoundEffect.click();
        if (source == startButton) {
            controller.controlPressed(StartPageCommand.STARTGAME);
        } else if (source == optionsButton) {
            controller.controlPressed(StartPageCommand.OPTIONS);
        } else if (source == creditsButton) {
            controller.controlPressed(StartPageCommand.CREDITS);
        } else if (source == exitButton) {
            controller.controlPressed(StartPageCommand.EXIT);
        }
    }

}
