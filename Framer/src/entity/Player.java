package entity;

import java.awt.Graphics;
import java.util.Random;

import entity.mob.Door;
import game.DataBase;
import game.Game;
import game.Handler;
import game.Id;
import graphic.Animation;
import graphic.Assets;
import graphic.Sound;
import gui.LevelFinish;
import tile.SurpriseBlock;
import tile.Tile;

public class Player extends Entity {
	private Animation animRight, animLeft, animjumpRight, animjumpLeft;
	private Random random;
	public static boolean animate = false;
	public static int skin;
	private int boostTimer = 0;
	private PlayerState playerState;
	private Sound sound;

	public Player(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);
		skin = DataBase.readSkin();
		if (skin == 0) {
			animRight = new Animation(105, Assets.player_right);
			animjumpRight = new Animation(105, Assets.player_right);
			animLeft = new Animation(105, Assets.player_left);
			animjumpLeft = new Animation(105, Assets.player_left);
		}
		if (skin == 1) {
			animRight = new Animation(105, Assets.goomba_right);
			animjumpRight = new Animation(105, Assets.goomba_right);
			animLeft = new Animation(105, Assets.goomba_left);
			animjumpLeft = new Animation(105, Assets.goomba_left);
		}
		if (skin == 2) {
			animRight = new Animation(110, Assets.gApple_right);
			animjumpRight = new Animation(105, Assets.gApple_right);
			animLeft = new Animation(110, Assets.gApple_left);
			animjumpLeft = new Animation(110, Assets.gApple_left);
		}
		if (skin == 4) {
			animRight = new Animation(110, Assets.candy_right);
			animjumpRight = new Animation(105, Assets.candy_jump_right);
			animLeft = new Animation(110, Assets.candy_left);
			animjumpLeft = new Animation(110, Assets.candy_jump_left);
		}
		if (skin == 3) {
			animRight = new Animation(110, Assets.rApple_right);
			animjumpRight = new Animation(105, Assets.rApple_jump_right);
			animLeft = new Animation(110, Assets.rApple_left);
			animjumpLeft = new Animation(110, Assets.rApple_jump_left);
		}
		if (skin == 5) {
			animRight = new Animation(110, Assets.sGirl_right);
			animjumpRight = new Animation(105, Assets.sGirl_jump_right);
			animLeft = new Animation(110, Assets.sGirl_left);
			animjumpLeft = new Animation(110, Assets.sGirl_jump_left);
		}
		if (skin == 6) {
			animRight = new Animation(110, Assets.rGirl_right);
			animjumpRight = new Animation(110, Assets.rGirl_right);
			animLeft = new Animation(110, Assets.rGirl_left);
			animjumpLeft = new Animation(110, Assets.rGirl_left);
		}
		if (skin == 7) {
			animRight = new Animation(110, Assets.boy2_right);
			animjumpRight = new Animation(110, Assets.boy2_right);
			animLeft = new Animation(110, Assets.boy2_left);
			animjumpLeft = new Animation(110, Assets.boy2_left);
		}
		if (skin == 8) {
			animRight = new Animation(110, Assets.rabbit_right);
			animjumpRight = new Animation(110, Assets.rabbit_right);
			animLeft = new Animation(110, Assets.rabbit_left);
			animjumpLeft = new Animation(110, Assets.rabbit_left);
		}
		if (skin == 9) {
			animRight = new Animation(100, Assets.guy_right);
			animjumpRight = new Animation(110, Assets.guy_right);
			animLeft = new Animation(110, Assets.guy_left);
			animjumpLeft = new Animation(110, Assets.guy_left);
		}
		if (skin == 10) {
			animRight = new Animation(120, Assets.goat_right);
			animjumpRight = new Animation(120, Assets.goat_right);
			animLeft = new Animation(120, Assets.goat_left);
			animjumpLeft = new Animation(120, Assets.goat_left);
		}
		random = new Random();
	}

	public void render(Graphics g) {
		if (!jumping) {
			if (facing == 0) {
				g.drawImage(animRight.getCurrentFrame(), x, y, width, height, null);
			}
			if (facing == 1) {
				g.drawImage(animLeft.getCurrentFrame(), x, y, width, height, null);
			}
		}
		if (jumping) {
			if (facing == 0) {
				g.drawImage(animjumpRight.getCurrentFrame(), x, y, width, height, null);
			}
			if (facing == 1) {
				g.drawImage(animjumpLeft.getCurrentFrame(), x, y, width, height, null);
			}
		}
	}

	public void tick() {
		playerState = PlayerState.start;
		if (animate == true) {
			animRight.tick();
			animLeft.tick();
		}
		x += velX;
		y += velY;
		if (y <= 0)
			y = 0;
		if (jumpBoost || runBoost)
			boostTimer++;
		if (boostTimer == 320) {
			runBoost = false;
			jumpBoost = false;
		}

		for (int i = 0; i < handler.tile.size(); i++) {
			Tile til = handler.tile.get(i);
			if (til.solid) {
				if (til.getId() != Id.coin && til.getId() != id.surpriseBlock && til.getId() != Id.doorOS
						&& til.getId() != Id.door) {
					if (getBoundsTop().intersects(til.getBounds())) {
						setVelY(0);
						if (jumping) {
							jumping = false;
							gravity = 15;
							falling = true;
						}
						y = til.getY() + til.height;
					}
					if (getBoundsButtom().intersects(til.getBounds())) {
						setVelY(0);
						jumpable = true;
						if (falling)
							falling = false;
						if (playerState == PlayerState.big)
							y = til.getY() - til.height;

						if (!falling && !jumping) {
							gravity = 0.8;
							falling = true;
						}

					}

					if (getBoundsLeft().intersects(til.getBounds())) {
						setVelX(0);
						x = til.getX() + width;
					}

					if (getBoundsRight().intersects(til.getBounds())) {
						setVelX(0);
						x = til.getX() - width;
					}

				}
				if (getBounds().intersects(til.getBounds()) && til.getId() == Id.coin && til.getId() != id.surpriseBlock
						&& til.getId() != id.door) {
					til.kill();
					sound.start(Sound.coin);
					Game.coinsCollected++;
				}
				if (getBounds().intersects(til.getBounds()) && til.getId() == Id.voidBlock
						&& til.getId() != id.surpriseBlock && til.getId() != id.door) {
					kill();
				}
				if (getBounds().intersects(til.getBounds()) && til.getId() == Id.Finish && til.getId() != id.surpriseBlock
						&& til.getId() != id.door) {
					LevelFinish.showing = true;
					Game.coins += Game.coinsCollected;
				}
				if (getBounds().intersects(til.getBounds()) && til.getId() == Id.eHealth && til.getId() != Id.Finish
						&& til.getId() != id.surpriseBlock && til.getId() != id.door) {
					til.kill();
					Game.lives++;
					sound.start(Sound.ding);
				}
				if (getBoundsTop().intersects(til.getBoundsBottom()) && til.getId() == Id.surpriseBlock) {
					if (!SurpriseBlock.hitted) {
						int mode = random.nextInt(2);
						switch(mode) {
						case 0:
							jumpBoost = true;
							break;
						case 1:
							runBoost = true;
							break;
						}
						
						SurpriseBlock.hitted = true;
					}
				}
				if (getBounds().intersects(til.getBounds()) && til.getId() == Id.doorOS) {
					if (!Door.open) {
						sound.start(Sound.door);
						Door.open = true;
					}
				}
				if (getBoundsRight().intersects(til.getBounds()) && til.getId() == Id.door) {
					if (!Door.open) {
						setVelX(0);
						x = til.getX() - width;
					}
				}

				if (getBoundsLeft().intersects(til.getBounds()) && til.getId() == Id.door) {
					if (!Door.open) {
						setVelX(0);
						x = til.getX() + width;
					}
				}

			}

		}
		for (int i = 0; i < handler.entity.size(); i++) {
			Entity e = handler.entity.get(i);
			if (e.getId() == Id.Mushroom) {
				if (getBounds().intersects(e.getBounds())) {
					playerState = PlayerState.big;
					int tpX = getX();
					int tpY = getY();
					setX(tpX - width);
					setY(tpY - height * 2);
					e.kill();
				}
			}
			if (e.getId() == Id.enemy || e.getId() == Id.advancedEnemy) {
				if (getBoundsButtom().intersects(e.getBoundsTop())) {
					e.kill();
					sound.start(Sound.enemyDefeat);
				} else if (getBounds().intersects(e.getBounds())) {
					if (playerState == PlayerState.big) {
						e.kill();
						playerState = PlayerState.regular;
					} else
						kill();
				}
			}
			if (e.getId() == Id.Boss) {
				if (getBoundsButtom().intersects(e.getBoundsTop())) {
					e.hp -= 15;
					int tpX = getX();
					int tpY = getY();
					setX(tpX - width - 200);
					setY(tpY - height * 2);
				} else if (getBounds().intersects(e.getBounds())) {
					int tpX = getX();
					int tpY = getY();
					setX(tpX - width);
					setY(tpY - height * 2);
					kill();
				}
			}

		}
		if (playerState == PlayerState.big) {
			width *= 2;
			height *= 2;
		}
		if (playerState == PlayerState.regular) {
			width /= 2;
			height /= 2;
		}

		/* jumping and falling settings */
		if (jumping && jumpable) {
			if (jumpBoost) {
				gravity -= 0.01;
			}
			if (!jumpBoost) {
				gravity -= 0.1;
			}
			jumpable = false;
			setVelY((int) -gravity);
			if (gravity <= 0.3) {
				jumping = false;
				falling = true;
			}

		}
		if (falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}

	}
}
