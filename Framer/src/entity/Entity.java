package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Game;
import game.Handler;
import game.Id;

public abstract class Entity {

	public int x, y;
	public int width, height;
	public int velX, velY;

	public boolean jumping = false;
	public boolean falling = true;
	public boolean attackable = false;
	public boolean jumpable = false;
	public static boolean jumpBoost, runBoost;
	public double gravity = 0.0;
	public int facing; // 0 = right, 1 = left, 2 = jumpRight, 3 = jumpLeft;
	public static int hp;

	public Handler handler;
	public Id id;

	public Entity(int x, int y, int width, int height, Id id, Handler handler) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.handler = handler;
	}

	public abstract void render(Graphics g);

	public abstract void tick();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public Id getId() {
		return id;
	}

	public void kill() {
		if (getId() != Id.player)
			handler.removeEntity(this);
		if (getId() == Id.player) {
			Game.isDead = true;
			Game.lives--;
			Game.restart();
		}
		if (getId() == Id.Boss) {
			Game.bossLevel = false;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(getX() + 10, getY(), width - 20, 5);
	}

	public Rectangle getBoundsButtom() {
		return new Rectangle(getX() + 10, getY() + height - 5, width - 20, 5);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY() + 10, 5, height - 20);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(getX() + width - 5, getY() + 10, 5, height - 20);
	}

	public Rectangle getBossBoundsTop() {
		return new Rectangle(getX() + 10, getY() - 5, width - 20, 5);
	}

}
