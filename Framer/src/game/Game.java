package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.newproject.gui.Launcher;

import entity.Entity;
import entity.KeyboardInput;
import entity.mob.BossHealth;
import graphic.Assets;
import graphic.Camera;
import graphic.Display;
import graphic.ImageLoader;
import graphic.Sound;
import gui.GameOver;
import gui.LevelFinish;
import gui.Pause;
import gui.Settings;

public class Game implements Runnable {
	private Display display;
	private Thread thread;
	public static Handler handler;

	static boolean running = false;
	public static boolean isDead = false;
	public static boolean bossLevel = false;

	private Sound sound;

	public static boolean playing = false;
	public static boolean restart = false;

	private BufferStrategy bs;
	private Graphics g;
	public static Camera camera;
	private static MouseInput mouse;
	public static BufferedImage sheet;
	public static BufferedImage[] levels;

	public static int width;
	public static int height;
	public String title;
	public static int coins = 0;
	public static int levelCoins = 0;
	public static int coinsCollected = 0;
	public static int coinsTimer = 0;
	public static int levelMax;
	public static int lives = 5;
	public static int stars;
	public static int currentLevel;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init() {
		handler = new Handler();
		Assets.init();
//		States.init();
		levelMax = DataBase.readLevel();
		levels = new BufferedImage[12];
/*		levels[1] = ImageLoader.loadImage("res/maps/bossLevel.png");
		levels[0] = ImageLoader.loadImage("res/maps/testLevel1234.png");
		levels[7] = ImageLoader.loadImage("res/maps/testLevel1234.png");
		levels[8] = ImageLoader.loadImage("res/maps/testLevel1234.png");
		levels[9] = ImageLoader.loadImage("res/maps/testLevel1234.png");
		levels[2] = ImageLoader.loadImage("res/maps/level11.png");
		levels[3] = ImageLoader.loadImage("res/maps/testLevel13.png");
		levels[4] = ImageLoader.loadImage("res/maps/level10.png");
		levels[11] = ImageLoader.loadImage("res/maps/testLevel1234.png");*/
		levels[0] = ImageLoader.loadImage("res/maps/level1.png");
		levels[1] = ImageLoader.loadImage("res/maps/level2.png");
		levels[2] = ImageLoader.loadImage("res/maps/level3.png");
		levels[3] = ImageLoader.loadImage("res/maps/level4.png");
		levels[4] = ImageLoader.loadImage("res/maps/level5.png");
		levels[5] = ImageLoader.loadImage("res/maps/level6.png");
		levels[6] = ImageLoader.loadImage("res/maps/level7.png");
		levels[7] = ImageLoader.loadImage("res/maps/level8.png");
		levels[8] = ImageLoader.loadImage("res/maps/level9.png");
		levels[9] = ImageLoader.loadImage("res/maps/level10.png");
		levels[10] = ImageLoader.loadImage("res/maps/bossLevel.png");
		levels[11] = ImageLoader.loadImage("res/maps/costumLevel.png");
		camera = new Camera();
		mouse = new MouseInput();
		display = new Display(title, width, height);
		display.GetCanvas().addKeyListener(new KeyboardInput());
		display.GetCanvas().addMouseListener(mouse);
		display.GetCanvas().addMouseMotionListener(mouse);
	}

	public static void switchLevel() {
		currentLevel++;
		handler.clearLevel();
		handler.createLevel(levels[currentLevel]);
	}

	public static void specLevel(int l) {
		if (l >= 0) {
			currentLevel = l;
			handler.clearLevel();
			handler.createLevel(levels[l]);
		}
	}

	private void tick() {
		if (isDead)
			coinsCollected = 0;
		if (playing && !Pause.showing) {
			handler.tick();
		}
		States.tick();
		if (Pause.showing) {
			Pause.tick();
		}
		for (Entity entity : handler.entity) {
			if (entity.getId() == Id.player) {
				camera.tick(entity);
			}
		}
		if (lives > 5) {
			lives = 5;
		}
		if (playing) {
			restart = false;
		}

		if (LevelFinish.showing && currentLevel == levelMax) {
			DataBase.addLevel();
		}
		if (LevelFinish.showing) {
			if(coinsTimer == 0) {
			for (int i = 0; i < coinsCollected; i++) {
				DataBase.addCoins();
			}
			coinsTimer++;
			}
		}
		if (lives <= 0) {
			GameOver.showing = true;
		}
	}
	private void render() {
		bs = display.GetCanvas().getBufferStrategy();
		if (bs == null) {
			display.GetCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		States.currentState(g);
		if (bossLevel) {
			BossHealth.render(g);
		}
		if (playing) {
			if (!Pause.showing) {
				g.translate(camera.getX(), camera.getY());
				handler.render(g);
			}
		}
		if (Pause.showing) {
			Pause.render(g);
		}
		bs.show();

		g.dispose();
	}

	public static void restart() {
		restart = true;
		isDead = false;
		playing = false;
		handler.clearLevel();
		handler.createLevel(levels[currentLevel]);
		playing = true;
	}

	public static Rectangle getVisibleArea() {
		if (playing) {
			for (int i = 0; i < handler.entity.size(); i++) {
				Entity e = handler.entity.get(i);

				if (e.getId() == Id.player)
					return new Rectangle(e.getX() - (Settings.getFrameWidth() / 2 - 5),
							e.getY() - (Settings.getFrameHeight() / 2 - 5), Settings.getFrameWidth() + 10,
							Settings.getFrameHeight() + 10);
			}
		}
		return null;
	}
	
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0.0;
		long lastTime = System.nanoTime();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			while (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		stop();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
