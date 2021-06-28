package gui;

import java.awt.Font;
import java.awt.Graphics;

import game.DataBase;
import game.Game;
import graphic.Assets;
import graphic.ImageLoader;
import graphic.SpriteSheet;

public class LevelFinish {
	private static int x, y;
	public static boolean showing = false;
	private static Button nextLevel, back;
	private static int bX, bY, bWidth, bHeight;
	
	public static void tick() {
		x = Settings.getFrameWidth()/3-200;
		y = 30;
		System.out.println(DataBase.readLevel());
		if(Game.currentLevel+1 == DataBase.readLevel() && Game.currentLevel + 1 < 11) {
			DataBase.addLevel();
			LevelSelector.update = true;
		}
		if(Game.currentLevel + 1 >= 11) {
			Game.playing = false;
			LevelFinish.showing = false;
			Credits.showing = true;
		}
		
		System.out.println(DataBase.readLevel());
//			LevelSelector.levels[Game.currentLevel+1].isOpen = true;
//		}
		nextLevel = new Button(LevelFinish.getX()+245, LevelFinish.getY()+350, 350, 143, "Next Level",40, 30);
		back = new Button(LevelFinish.getX()+58, LevelFinish.getY()+571, 149, 71, "Back",30, 30);
	//	nextLevel.setTitle("Next Level");
	//	back.setTitle("Back");
		DataBase.addStars(Game.currentLevel, Game.stars);
		nextLevel.tick();
		back.tick();
	}
	
	public static void render(Graphics g) {
		g.drawImage(Assets.levelCompleted, x, y, 800, 700, null);
		nextLevel.render(g);
		back.render(g);
	//	g.setColor(Color.black);
	//	g.fillRect(x, y, 700, 400);
	//	g.setColor(Color.white);
	//	g.fillRect(x+400, y*4/3+200, 200, 100);
	//	g.fillRect(x+100, y*4/3+200+10, 100, 80);
	//	g.setFont(new Font("Double Strunk", Font.BOLD, 100));
	//	g.drawString("Level", 520, 300);
	//	g.drawString("Completed", 430, 410);
		if(Game.stars == 1) {
			g.drawImage(Assets.star, x+87, y+173, 128, 128, null);
		}
		if(Game.stars == 2) {
			g.drawImage(Assets.star,  x+87, y+173, 128, 128, null);
			g.drawImage(Assets.star, x+336, y+173, 128, 128, null);
		}
		if(Game.stars == 3) {
			g.drawImage(Assets.star,  x+87, y+173, 128, 128, null);
			g.drawImage(Assets.star, x+336, y+173, 128, 128, null);
			g.drawImage(Assets.star, x+559, y+173, 128, 128, null);
		}
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("Coins Collected: " + Game.coinsCollected, x+220, y+600);
	}
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
	
	
	
	
	
	
	
	
	
}
