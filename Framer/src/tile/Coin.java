package tile;

import java.awt.Graphics;

import game.Handler;
import game.Id;
import graphic.Animation;
import graphic.Assets;

public class Coin extends Tile {

	public static Animation animCoin;

	public Coin(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		animCoin = new Animation(100, Assets.coin_anim);
	}

	public void render(Graphics g) {
		g.drawImage(animCoin.getCurrentFrame(), x, y, width, height, null);

	}

	public void tick() {
		animCoin.tick();

	}

}
