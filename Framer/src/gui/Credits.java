package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphic.Assets;

public class Credits {
	private static Button back;
	public static boolean showing = false;
	
	public static void tick() {
		back = new Button(Settings.getFrameWidth()/2-600, Settings.getFrameHeight()/2+250, 400, 100, "Back",50, 20);
		back.tick();
	}
	public static void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawImage(Assets.creditsBG, 0, 0, Settings.getFrameWidth(), Settings.getFrameHeight(), null);
//		g.fillRect(0, 0, Settings.getFrameWidth(), Settings.getFrameHeight());
		back.render(g);
//		g.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 72));
//		g.setColor(Color.WHITE);
//		g.drawString("Thanks for Playing 'Farmer'", 200, 100);
//		g.drawString("By Ariel", 500, 300);
//		back.render(g);
	//	g.drawString("Thanks for Playing 'Farmer'", Font.BOLD, 30);
	//	g.drawString("By Ariel", Font.BOLD, 30);
	
	}

}
