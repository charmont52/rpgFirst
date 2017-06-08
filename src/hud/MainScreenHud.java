package hud;

import command.MainScreenCommand;
import controller.MainScreenController;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

public class MainScreenHud implements ComponentListener {

    private MainScreenController controller;
    private MouseOverArea startButton;
    private MouseOverArea creditsButton;
    private MouseOverArea exitButton;

    public MainScreenHud(MainScreenController controller) {
        this.controller = controller;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Image buttonImage = new Image("src/ressources/hud/button.png");
        int centreX = container.getWidth()/2 - buttonImage.getWidth()/2;
        int centreY = container.getHeight()/2 - buttonImage.getHeight()/2;
        startButton = new MouseOverArea(container, buttonImage, centreX, centreY - 100, this);

        creditsButton = new MouseOverArea(container, buttonImage, centreX, centreY, this);
        exitButton = new MouseOverArea(container, buttonImage, centreX, centreY + 100, this);

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.black);
        startButton.render(container, g);
        g.drawString("Jouer",startButton.getX() + startButton.getWidth()/2 - g.getFont().getWidth("Jouer")/2,startButton.getY() + startButton.getHeight()/2 - g.getFont().getHeight("Jouer")/2);
        creditsButton.render(container, g);
        g.drawString("Crédits",creditsButton.getX() + creditsButton.getWidth()/2 - g.getFont().getWidth("Crédits")/2,creditsButton.getY() + creditsButton.getHeight()/2 - g.getFont().getHeight("Crédits")/2);
        exitButton.render(container, g);
        g.drawString("Quitter",exitButton.getX() + exitButton.getWidth()/2 - g.getFont().getWidth("Quitter")/2,exitButton.getY() + exitButton.getHeight()/2 - g.getFont().getHeight("Quitter")/2);
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        if (source == startButton) {
            controller.controlPressed(MainScreenCommand.START);
        } else if (source == creditsButton) {
            controller.controlPressed(MainScreenCommand.CREDITS);
        } else if (source == exitButton) {
            controller.controlPressed(MainScreenCommand.EXIT);
        }
    }

}
