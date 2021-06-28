package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.DataBase;
import graphic.Assets;

public class Settings {
	private static int gameWIDTH = 1368, gameHEIGHT = 768;
	private static Button back, mute;
	static boolean muted;
	public static boolean showing = false;

	static void init() {
		muted = DataBase.readSound();
		back = new Button(40, 30, 120, 80, "back", 40, 20);
//		muteTheme = new Button(150, 200, 275, 100, "Mute Music", 40, 10);
//		muteFX = new Button(550, 200, 275, 100, "MuteFX", 40, 20);
//		mute = new Button(950, 200, 275, 100, "Mute", 40, 20);
		mute = new Button(400, 200, 575, 100, "Mute", 70, 120);
		if(muted) {
			mute.setTitle("sound muted");
		}
	}

	public static void tick() {
		if(muted) {
			if(DataBase.readSound()) {
				mute.setTitle("sound muted");
				mute.setSpaceX(100);
			}
			if(!DataBase.readSound()) {
				mute.setTitle("Mute");
				mute.setSpaceX(170);
			}
				muted = false;
		}
		back.tick();
//		muteTheme.tick();
//		muteFX.tick();
		mute.tick();
	}

	public static void render(Graphics g) {
		g.drawImage(Assets.settingsBG, 0, 0, gameWIDTH, gameHEIGHT, null);
		back.render(g);
//		muteTheme.render(g);
//		muteFX.render(g);
		mute.render(g);
	}
	public static int getFrameWidth() {
		return gameWIDTH;
	}
	public static int getFrameHeight() {
		return gameHEIGHT;
	}

}
