package entity.mob;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.Id;
import graphic.Assets;
import tile.Tile;

public class DoorOS extends Tile {
	private BufferedImage doorOpen, doorClosed;
	public static int serial;

	public DoorOS(int x, int y, int width, int height, boolean solid, Id id, Handler handler, int serial) {
		super(x, y, width, height, solid, id, handler);
		doorClosed = Assets.buttonNotClicked;
		doorOpen = Assets.buttonClicked;
		this.serial = serial;
	}

	public void render(Graphics g) {
		if (!Door.open)
			g.drawImage(doorClosed, x, y, width, height, null);
		else if (Door.open)
			g.drawImage(doorOpen, x, y, width, height, null);
	}

	public void tick() {
	}

}
