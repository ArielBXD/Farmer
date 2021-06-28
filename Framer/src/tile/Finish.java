package tile;

import java.awt.Graphics;

import game.Handler;
import game.Id;
import graphic.Assets;

public class Finish extends Tile{

	public Finish(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Assets.end, x, y, width, height, null);
	}

	
	public void tick() {
		
		
	}
	

}
