package tile;

import java.awt.Graphics;

import game.Handler;
import game.Id;
import graphic.Assets;

public class SurpriseBlock extends Tile{
	public static boolean hitted;
	public static boolean popped = false;
	private int coinY = getY();
	public SurpriseBlock(int x, int y, int width, int height, boolean solid, Id id, Handler handler, boolean hitted) {
		super(x, y, width, height, solid, id, handler);
		this.hitted = hitted;
	}

	
	public void render(Graphics g) {	
		if(!hitted)
			g.drawImage(Assets.surpriseBlock ,x, y, width, height, null);
		else if(hitted) 
			g.drawImage(Assets.surpriseBlockHitted,x , y, width, height, null);
		

	}

	
	public void tick() {
		if(hitted && !popped)
			coinY--;
		if(coinY <= y-height) {
			handler.addTile(new Coin(x*64, coinY, 64, 64, true, Id.coin, handler));
			popped = true;
		}
	}

}
