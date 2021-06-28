package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.Game;

public class GameOver {
	public static Button back;
	public static boolean showing = false;
	
	public static void init() {
		back = new Button(550, 500, 200, 100, "return",50, 20);
	}
	
	public static void tick() {
		init();
		back.tick();
	}
	
	
	public static void render(Graphics g) {
		init();
		Game.handler.clearLevel();
		g.setColor(Color.BLACK);
		g.setFont(new Font("Double Strunk", Font.BOLD, 170));
		g.drawString("Game", 400, 250);
		g.drawString("Over", 430, 410);
		back.render(g);
	}
	
	
}
