package gui;

import java.awt.Graphics;

import graphic.Assets;

import graphic.Animation;

public class Loading {
	private static Animation loadAnim;
	public static boolean showing;
	public static int loadTimer = 0;
	
	public static void tick() {
		loadAnim = new Animation(80, Assets.loading);
	}
	public static void render(Graphics g) {
		if(showing){
		g.fillRect(0, 0, Settings.getFrameWidth(), Settings.getFrameHeight());
		g.drawImage(loadAnim.getCurrentFrame(), 1200, 650, 100, 100, null);
		}
	}
	
}
