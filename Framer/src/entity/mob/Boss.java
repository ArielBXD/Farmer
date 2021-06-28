package entity.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import entity.Entity;
import game.Game;
import game.Handler;
import game.Id;
import graphic.Assets;
import gui.LevelFinish;
import tile.Tile;

public class Boss extends Entity {
	private Random random;
	private BossState bossState;
	private int stateTime;
	private int jumpTime = 0, enemyTimer = 0;
	private BufferedImage skin;

	public Boss(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);
		hp = 100;
		random = new Random();
		bossState = BossState.ATTACKING;
	}

	public void render(Graphics g) {
		g.drawImage(Assets.boss, x, y, width, height, null);
	}

	public void tick() {
		x += velX;
		y += velY;
		if (Game.bossLevel)
			BossHealth.tick();

		if (hp <= 0) {
			kill();
			LevelFinish.showing = true;
		}
		stateTime++;

		if (stateTime >= 300)
			randomState();
		if (bossState == BossState.IDLE) {
			setVelY(0);
			setVelX(0);
			hp += 0.1;
		}
		if (bossState == BossState.JUMPING || bossState == BossState.RUNNING) {
			attackable = true;
		} else {
			attackable = false;
		}
		if(bossState == BossState.ATTACKING) {
			if(enemyTimer == 0)
				Game.handler.addEntity(new Enemy(x, y, 64, 64, Id.enemy, Game.handler));
			enemyTimer++;
			if(enemyTimer >= 120)
				enemyTimer = 0;
		}
		
		
		for (int i = 0; i < handler.tile.size(); i++) {
			Tile til = handler.tile.get(i);
			if (til.solid) {
				if (getBoundsTop().intersects(til.getBounds())) {
					setVelY(0);
					if (jumping) {
						jumping = false;
						gravity = 0.8;
						falling = true;
					}
				}
				if (getBoundsButtom().intersects(til.getBounds())) {
					setVelY(0);
					if (bossState == BossState.JUMPING) {
						while (!jumping)
							jumping = true;
					}
					if (falling) {
						falling = false;
					}

				} else if (!falling && !jumping) {
					gravity = 0.0;
					falling = false;
				}

				if (getBoundsLeft().intersects(til.getBounds())) {
					setVelX(0);
					if (bossState == BossState.RUNNING || bossState == BossState.ATTACKING)
						setVelX(5);

					x = til.getX() + til.width;
				}
				if (getBoundsRight().intersects(til.getBounds())) {
					setVelX(0);
					if (bossState == BossState.RUNNING || bossState == BossState.ATTACKING)
						setVelX(-5);

					x = til.getX() - 128;
				}
			}

		}
		for (int i = 0; i < handler.entity.size(); i++) {
			Entity e = handler.entity.get(i);
			if (e.getId() == Id.player) {
				if (bossState == BossState.JUMPING || bossState == BossState.RUNNING) {
					if (!jumping || !falling) {
						if (getX() >= e.getX() - 4 && getX() <= e.getX() + 4)
							setVelX(0);
						else if (e.getX() < getX())
							setVelX(-3);

						else if (e.getX() > getX())
							setVelX(3);
						else
							setVelX(0);
					}
				}

			}
		}
		if (jumping) {
			gravity -= 0.1;
			setVelY((int) -gravity);
			if (gravity <= 0.4) {
				jumping = false;
				falling = true;
			}
		}
		if (falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}
	}

	public void randomState() {
		int nextState = random.nextInt(4);
		if (nextState == 0) {
			bossState = BossState.RUNNING;
			int direction = 0;
			if (direction == 0)
				setVelX(-5);
			else if (direction == 1)
				setVelX(-5);
		}
		if (nextState == 1) {
			bossState = BossState.JUMPING;
			jumping = true;
			gravity = -5.0;
		}
		if (nextState == 2) {
			bossState = BossState.IDLE;
			attackable = false;
		}
		if (nextState == 3) {
			bossState = BossState.ATTACKING;
			int direction = 0;
			if (direction == 0)
				setVelX(-5);
			else if (direction == 1)
				setVelX(-5);
		}
		stateTime = 0;
	}
}