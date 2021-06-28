package entity.mob;

import java.awt.Graphics;

import game.Handler;
import game.Id;
import graphic.Assets;
import tile.Tile;

public class Door extends Tile {
	public static boolean open = false;
	public static int serial;

	public Door(int x, int y, int width, int height, boolean solid, Id id, Handler handler, boolean open) {
		super(x, y, width, height, solid, id, handler);
		this.open = open;
	}

	public void render(Graphics g) {
		if (serial == DoorOS.serial) {
			if (!open)
				g.drawImage(Assets.doorC, x, y, width, height, null);
		}
	}

	public void tick() {

	}

}
