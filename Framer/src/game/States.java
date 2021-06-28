package game;

import java.awt.Color;
import java.awt.Graphics;

import graphic.Assets;
import gui.Credits;
import gui.GameOver;
import gui.Launcher;
import gui.LevelFinish;
import gui.Pause;
import gui.Settings;
import gui.Shop;
import gui.LevelSelector;
import gui.Loading;

public class States {
	
	public static void init() {
		if (GameOver.showing) {
			GameOver.init();
		}
		if (LevelFinish.showing) {
			DataBase.readLevel();
			DataBase.addLevel();
		}
		if (LevelSelector.showing) {
			DataBase.readLevel();
		}
		if(Shop.showing)
			Shop.init();

	}

	public static void tick() {
		if (Launcher.showing) {
			Launcher.tick();
		}
		if (LevelFinish.showing)
			LevelFinish.tick();
		if (Settings.showing)
			Settings.tick();
		if (Credits.showing)
			Credits.tick();
		if (Pause.showing)
			Pause.tick();
		if (GameOver.showing)
			GameOver.tick();
		if (LevelSelector.showing) {
			Game.playing = false;
			LevelSelector.tick();
		}

//			Loading.tick();
		if (Shop.showing)
			Shop.tick();
		if(Loading.showing)
			Loading.tick();
	}

	public static void currentState(Graphics g) {

		if (Launcher.showing)
			Launcher.render(g);

		if (LevelSelector.showing)
			LevelSelector.render(g);

		if (Settings.showing)
			Settings.render(g);

		if (Credits.showing)
			Credits.render(g);
		if (Shop.showing)
			Shop.render(g);

		if (Game.playing) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Game.width, Game.height);
			g.drawImage(Assets.bgRainbow, 0, 0, null);
			if (LevelFinish.showing) {
				Game.handler.clearLevel();
				if (Game.coinsCollected == Game.levelCoins)
					Game.stars = 3;
				else if ((Game.coinsCollected < Game.levelCoins) && Game.coinsCollected > Game.levelCoins / 2)
					Game.stars = 2;
				else
					Game.stars = 1;
				LevelFinish.render(g);

			}
		}

		if (GameOver.showing) {
			Game.handler.clearLevel();
			GameOver.render(g);
		}
		if(Loading.showing)
			Loading.render(g);
	}
}
