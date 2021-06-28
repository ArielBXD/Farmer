package entity.mob;

import java.awt.Graphics;
import java.util.Random;

import entity.Entity;
import game.Handler;
import game.Id;
import graphic.Assets;
import tile.Tile;

public class Mushroom extends Entity {

	private Random random = new Random();

	public Mushroom(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);

		int direction = random.nextInt(1);
		switch (direction) {
		case 0:
			setVelX(-2);
			break;
		case 1:
			setVelX(2);
			break;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.flower, x, y, width, height, null);

	}

	public void tick() {
		x += velX;
		y += velY;
		for (int i = 0; i < handler.tile.size(); i++) {
			Tile til = handler.tile.get(i);

			if (til.solid) {
				if (getBoundsButtom().intersects(til.getBounds())) {
					setVelY(0);
					if (falling)
						falling = false;
//				y = til.getY()-til.height;
				} else if (!falling) {
					gravity = 0.8;
					falling = true;
				}
				if (getBoundsLeft().intersects(til.getBounds())) {
					setVelX(5);
				}
				if (getBoundsRight().intersects(til.getBounds())) {
					setVelX(-5);
				}
			}
		}
		if (falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}
	}

}
