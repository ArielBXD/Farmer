package entity.mob;

import java.awt.Graphics;
import java.util.Random;

import entity.Entity;
import game.Handler;
import game.Id;
import graphic.Animation;
import graphic.Assets;
import tile.Tile;

public class Enemy extends Entity {
	private Animation animRight, animLeft;
	private Random random = new Random();

	public Enemy(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);
		animRight = new Animation(130, Assets.goomba_right);
		animLeft = new Animation(130, Assets.goomba_left);

		int direction = random.nextInt(1);
		switch (direction) {
		case 0:
			setVelX(-2);
			facing = 1;
			break;
		case 1:
			setVelX(2);
			facing = 0;
			break;
		}
	}

	public void render(Graphics g) {
		if (facing == 0)
			g.drawImage(animRight.getCurrentFrame(), x, y, width, height, null);
		else if (facing == 1)
			g.drawImage(animLeft.getCurrentFrame(), x, y, width, height, null);
	}

	public void tick() {
		animRight.tick();
		animLeft.tick();
		x += velX;
		y += velY;

		for (int i = 0; i < handler.tile.size(); i++) {
			Tile til = handler.tile.get(i);
			if (til.isSolid() && til.getId() != Id.coin) {
				if (getBoundsButtom().intersects(til.getBounds())) {
					setVelY(0);
					if (falling)
						falling = false;
				} else if (!falling) {
					falling = true;
					gravity = 0.8;
				}
				if (getBoundsLeft().intersects(til.getBounds())) {
					setVelX(3);
					facing = 0;
				}
				if (getBoundsRight().intersects(til.getBounds())) {
					setVelX(-3);
					facing = 1;
				}
			}
			if (til.getId() == Id.coin) {

			}
		}

		if (falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}

	}

}
