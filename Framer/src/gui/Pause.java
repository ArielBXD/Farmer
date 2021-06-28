package gui;

import java.awt.Graphics;

public class Pause {
	private static Button resume, back, settings;
	public static boolean showing = false;
	private static int x, y;

	public static void init() {
		back = new Button(x + 450, y + 450, 400, 100, "Back", 50, 20);
		resume = new Button(x + 450, y + 150, 400, 100, "resume", 50, 20);
		settings = new Button(x + 450, y + 300, 400, 100, "settings", 50, 20);
		y = 0;
		x = 0;
	}

	public static void tick() {
		init();
		back.tick();
		resume.tick();
		settings.tick();
	}

	public static void render(Graphics g) {
		init();
		back.render(g);
		resume.render(g);
		settings.render(g);
	}

}
