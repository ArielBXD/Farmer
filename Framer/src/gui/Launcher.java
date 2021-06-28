package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.States;

import game.DataBase;
import game.Game;
import graphic.Assets;

public class Launcher {
	public static int buttonX = 30, buttonY = 335, buttonWidth = 300, buttonHeight = 70;
	public static boolean showing = true;
	public static JFrame mainFrame;
	static JPanel mainPanel;
	static JLabel background, backLabel;
	static JButton start, settings, quit, shop;
	static Canvas states;
	static int gameWidth, gameHeight;
	public static Game game;
	public static boolean stateSelector = false;
	public static Button[] buttons;

	public static void main(String[] args) {
		Settings.init();
		Shop.init();
		LevelSelector.init();
		init();
		game.start();
	}

	public static void init() {
		gameWidth = Settings.getFrameWidth();
		gameHeight = Settings.getFrameHeight();
		game = new Game("my new game!", gameWidth, gameHeight);
		buttons = new Button[5];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "", 50, 17);
			buttonY += 90;
		}
		buttons[0].setTitle("Start Game");
		buttons[1].setTitle("shop");
		buttons[2].setTitle("settings");
		buttons[3].setTitle("credits");
		buttons[4].setTitle("Exit");
		buttons[1].setSpaceX(100);
		buttons[2].setSpaceX(70);
		buttons[3].setSpaceX(72);
		buttons[4].setSpaceX(95);

	}

	public static void tick() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].tick();
			buttons[i].isOpen = true;
		}
	}

	public static void render(Graphics g) {

		if (showing) {
			g.drawImage(Assets.startBG, 0, 0, gameWidth, gameHeight, null);
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].render(g);
			}
		}

	}

}
