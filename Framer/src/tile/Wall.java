package tile;

import java.awt.Graphics;

import game.Handler;
import game.Id;
import graphic.Assets;

public class Wall extends Tile {

	public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	public void render(Graphics g) {
		g.drawImage(Assets.dirt, x, y, width, height, null);
	}

	public void tick() {

	}

}
