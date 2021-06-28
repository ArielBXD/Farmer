package entity.mob;
import java.awt.Color;
import java.awt.Graphics;
public class BossHealth {
//		public static int HEALTH = 100;

		public static void tick() {
			Boss.hp = clamp(Boss.hp, 0, 100);
		}
		
		public static void render(Graphics g) {
			g.setColor(Color.gray);
			g.fillRect(500, 15, 200, 32);
			g.setColor(Color.green);
			g.fillRect(500, 15, Boss.hp * 2, 32);
			g.setColor(Color.white);
			g.drawRect(500, 15, 200, 32);
		}
		
	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}


}
