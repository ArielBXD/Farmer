package entity.mob;

import java.awt.Graphics;

import game.Handler;
import game.Id;
import graphic.Animation;
import graphic.Assets;
import tile.Tile;

public class ExtraHealth extends Tile {
	private Animation healthAnim;

	public ExtraHealth(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		healthAnim = new Animation(110, Assets.extra_health);
	}

	public void render(Graphics g) {
		g.drawImage(healthAnim.getCurrentFrame(), x, y, width, height, null);
	}

	public void tick() {
		healthAnim.tick();
	}

}
