package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.DataBase;
import game.Game;
import graphic.Assets;
import graphic.ImageLoader;

public class LevelSelector{
	Game game  = new Game("My game", 1200, 600);
	public static Button[] levels;
//	private static int currentLevel;
	private static Button back;
	private static int buttonX, buttonY, raw = 0, levelsAv, lastLevel = 0;
	private static final int buttonWidth = 213, buttonHeight = 123;
	private static int width, height;
	private static BufferedImage background;
	public static boolean showing = false, update;
	
	public static void init() {
		width = Settings.getFrameWidth();
		height = Settings.getFrameHeight();
		background = ImageLoader.loadImage("res/textures/chooselevelnew.png");
		levelsAv = DataBase.readLevel();
		back = new Button(80, 35, 111, 62, "back",30,20);
		levels = new Button[12];
		buttonX =  180;
		buttonY = 190;
		for(int i = 0; i < levelsAv; i++) {
			levels[i] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "level "+ i,40,50);
			raw++;
			buttonX = buttonX+buttonWidth+60;
			if(raw >= 4) {
				buttonX = 180;
				buttonY = buttonY+170;
				raw = 0;
			}
			if(levels[i].getStars() == 3)
				levels[i].setGold(true);
		}
		for(int j = levelsAv; j < levels.length; j++) {
			levels[j] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "level "+ j,40,50);
			raw++;
			lastLevel++;
			buttonX = buttonX+buttonWidth+60;
			if(raw >= 4) {
				buttonX = 180;
				buttonY = buttonY+170;
				raw = 0;
			}
		}
		}
	public static void tick() {
		back.tick();
//			levels[j].isOpen = true;
		for(int i = 0; i < levelsAv; i++) {
			if(update) {
				levelsAv = DataBase.readLevel();
				init();
				update = false;
			}
/*			if(DataBase.readStars(DataBase.readLevel()) > 0) {
				DataBase.addLevel2();
			}*/
			int stars = 0;
			stars = DataBase.readStars(i);
			levels[i].setStars(stars);
			if(levels[i].getStars() == 3)
				levels[i].setGold(true);
			levels[i].tick();
		}
		
		for(int j = levelsAv; j < levels.length-1; j++) {
			levels[j].setOpen(false);
//			levels[0].isOpen = true;
			levels[j].tick();
			
		}
		levels[11].setOpen(true);
		levels[11].tick();
		levels[11].setSpaceX(0);
		levels[11].setWidth(240);
		levels[11].setTitle("custom level");
/*		for(int j = 0; j < DataBase.readLevelDB(); j++) {
			levels[j].isOpen = false;
			}
		levels[0].isOpen = true;
*/
	}
	
	public static void render(Graphics g) {
		g.drawImage(Assets.chooseLevel, 0, 0, width, height, null);
		back.render(g);
		for(int i = 0 ; i < levels.length; i++) {
		levels[i].render(g);
		}
		
	}
	
/*	public static JPanel newMenu(JPanel panel) {
	//	JLabel backLabel = new JLabel(new ImageIcon(Assets.chooseLevel));
		JButton[] levels = new JButton[12];
		panel.add(backLabel);
		return panel;
	}*/
	
/*	public static void levelMenu() {
		init();
		/*main frame configuration*/
/*		mainFrame = new JFrame("My Game");
		mainFrame.setSize(new Dimension(Settings.getFrameWidth(), Settings.getFrameHeight()));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setUndecorated(true);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		backLabel = new JLabel(new ImageIcon(background));
		backLabel.setBounds(0, 0, Launcher.gameWidth+5, Launcher.gameHeight+50);
		
		mainPanel = new JPanel();
		mainPanel.setSize(new Dimension(Settings.getFrameWidth(), Settings.getFrameHeight()));
	//	mainPanel.setBackground(Color.ORANGE);
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
	*/
	/*	levels = new JButton[12];
		buttonX =  125;
		buttonY = 75;
		for(int i = 0; i < levels.length; i++) {
			levels[i] = new JButton();
			levels[i].setText("level " + Integer.toString(i));
			levels[i].setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
			raw++;
			buttonX = buttonX+250;
			mainPanel.add(levels[i]);
			if(raw >= 4) {
				buttonX = 250;
				buttonY = buttonY+150;
				raw = 0;
			}
		}
		*/
	/*	quit = new JButton();
		quit.setBounds(25, 10, 75, 50);
		quit.addActionListener(new StateSelector());
		quit.setFont(new Font("Arial", Font.BOLD, 32));
		quit.setText("<-");
		
		mainPanel.add(quit);
		mainPanel.add(backLabel);
		mainFrame.setVisible(true);
	}
*/

	
/*	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quit) {
			mainFrame.setVisible(false);
			Launcher.mainMenu();
			game.stop();
		}
		if(e.getSource() == levels[0]) {
			mainFrame.setVisible(false);
			currentLevel = 0;
			game.start();
		}
	} 
	
	public static int getCurrentLevel() {
		return currentLevel;
	}

}*/
}
