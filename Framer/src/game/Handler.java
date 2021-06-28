package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Entity;
import entity.Player;
import entity.mob.AdvancedEnemy;
import entity.mob.Boss;
import entity.mob.Door;
import entity.mob.DoorOS;
import entity.mob.ExtraHealth;
import entity.mob.Enemy;
import entity.mob.Mushroom;
import graphic.Assets;
import gui.GameOver;
import gui.LevelFinish;
import tile.Coin;
import tile.SurpriseBlock;
import tile.Finish;
import tile.Tile;
import tile.VoidBlock;
import tile.Wall;

public class Handler {
	public CopyOnWriteArrayList<Entity> entity = new CopyOnWriteArrayList<Entity>();
	public CopyOnWriteArrayList<Tile> tile = new CopyOnWriteArrayList<Tile>();

	public void render(Graphics g) {

		for (int i = 0; i < entity.size(); i++) {
			Entity ent = entity.get(i);
			if (Game.getVisibleArea() != null && ent.getBounds().intersects(Game.getVisibleArea()))
				ent.render(g);

		}
		for (Tile til : tile) {
			if (Game.getVisibleArea() != null && til.getBounds().intersects(Game.getVisibleArea()))
				til.render(g);

		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 50));
		if (Game.playing && !Game.restart && !LevelFinish.showing && !GameOver.showing) {
			g.drawImage(Assets.coin_anim[0], Game.getVisibleArea().x - 25, Game.getVisibleArea().y - 25, 128, 128,
					null);
			g.drawString("x" + Game.coinsCollected, Game.getVisibleArea().x + 85, Game.getVisibleArea().y + 45);
			g.drawImage(Assets.lives[Game.lives - 1], Game.getVisibleArea().x + 20, Game.getVisibleArea().y + 50, null);

			if (Player.jumpBoost) {
	//			g.setColor(Color.black);
	//			g.fillRect(Game.getVisibleArea().x + 20, Game.getVisibleArea().y + 150, 80, 80);
				g.drawImage(Assets.frog, Game.getVisibleArea().x + 35, Game.getVisibleArea().y + 150, 80, 80, null);
			}
			if(Player.runBoost) {
				g.drawImage(Assets.rabbit, Game.getVisibleArea().x + 35, Game.getVisibleArea().y + 150, 80, 80, null);
				
			}

		}

	}

	public void tick() {
		for (int i = 0; i < entity.size(); i++) {
			Entity ent = entity.get(i);
			if (Game.getVisibleArea() != null && ent.getBounds().intersects(Game.getVisibleArea()))
				ent.tick();

		}
		for (Tile til : tile) {
			if (Game.getVisibleArea() != null && til.getBounds().intersects(Game.getVisibleArea()))
				til.tick();

		}

	}

	public void addEntity(Entity ent) {
		entity.add(ent);
	}

	public void removeEntity(Entity ent) {
		entity.remove(ent);
	}

	public void addTile(Tile til) {
		tile.add(til);
	}

	public void removeTile(Tile til) {
		tile.remove(til);
	}

	public void createLevel(BufferedImage level) {
		Game.levelCoins = 0;
		Game.coinsCollected = 0;
		int width = level.getWidth();
		int height = level.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int pixel = level.getRGB(x, y);

				int blue = (pixel) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int red = (pixel >> 16) & 0xff;

				if (red == 0 && green == 0 && blue == 0)
					addTile(new Wall(x * 64, y * 64, 64, 64, true, Id.wall, this));
				if (red == 0 && green == 0 && blue == 255)
					addEntity(new Player(x * 64, y * 64, 64, 64, Id.player, this));
				if (red == 255 && green == 255 && blue == 0) {
					addTile(new Coin(x * 64, y * 64, 64, 64, true, Id.coin, this));
					Game.levelCoins++;
				}
				if (red == 255 && green == 100 && blue == 100)
					addEntity(new Enemy(x * 64, y * 64, 64, 64, Id.enemy, this));
				if (red == 255 && green == 0 && blue == 255)
					addTile(new VoidBlock(x * 64, y * 64, 64, 64, true, Id.voidBlock, this));
				if (red == 220 && green == 220 && blue == 20)
					addTile(new Finish(x * 64, y * 64, 64, 64, true, Id.Finish, this));
				if (red == 255 && green == 1 && blue == 1)
					addEntity(new AdvancedEnemy(x * 64, y * 64, 64, 64, Id.advancedEnemy, this));
//					addEntity(new Mushroom(x * 64, y * 64, 64, 64, Id.Mushroom, this));
				if (red == 255 && green == 125 && blue == 25)
					addTile(new SurpriseBlock(x * 64, y * 64, 64, 64, true, Id.surpriseBlock, this, false));
				if (red == 255 && green == 175 && blue == 200) {
					addEntity(new Boss(x * 64, y * 64, 128, 128, Id.Boss, this));
					Game.bossLevel = true;
				}
				if (red == 255 && green == 155 && blue == 55)
					addTile(new Door(x * 64, y * 64, 64, 64, true, Id.door, this, false));
				if (red == 155 && green == 255 && blue == 55)
					addTile(new DoorOS(x * 64, y * 64, 64, 64, true, Id.doorOS, this, 0));
				if (red == 255 && green == 0 && blue == 0)
					addTile(new ExtraHealth(x * 64, y * 64, 64, 64, true, Id.eHealth, this));
			}
		}
	}

	public void clearLevel() {
//		Game.levelCoins = 0;
		entity.clear();
		tile.clear();
	}
}
