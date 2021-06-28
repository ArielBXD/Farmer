package graphic;

import java.awt.image.BufferedImage;


public class Assets {
	
	public static BufferedImage mario, boyPlayer, grass, tree, stone, snow, ngrass, dirt, rMushroom, gMushroom,flower, surpriseBlock, surpriseBlockHitted, pCoin, boss, doorC, doorO, buttonNotClicked, buttonClicked, star, frog, rabbit, end;
	public static BufferedImage levelCompleted, chooseLevel, shop, buttonActive, buttonActive_hovering, buttonNActive, buttonPurchased,buttonPurchased_hovering, buttonEquiped, buttonEquiped_hovering, buttonGold, buttonGold_hovering;
	public static BufferedImage bgFarm,bgRainbow, startBG, creditsBG, settingsBG, buyScreen;
	public static BufferedImage[] player_right, player_left, coin_anim, goomba_right, goomba_left, lives, extra_health, loading;
	public static BufferedImage[]  candy_right, candy_left, candy_jump_right, candy_jump_left;
	public static BufferedImage[] rApple_right, rApple_left, rApple_jump_right, rApple_jump_left;
	public static BufferedImage[] gApple_right, gApple_left, gApple_jump_right, gApple_jump_left;
	public static BufferedImage[] sGirl_right, sGirl_left, sGirl_jump_right, sGirl_jump_left;
	public static BufferedImage[] rGirl_right, rGirl_left, rabbit_right, rabbit_left, goat_right, goat_left, boy2_right, boy2_left, guy_right, guy_left;
	public static void init() {
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("res/textures/newspritesheet.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/sprite23.png"));
//		SpriteSheet Character = new SpriteSheet(ImageLoader.loadImage("res/textures/charactermov2.png"));
		SpriteSheet players = new SpriteSheet(ImageLoader.loadImage("res/textures/players.png"));
		SpriteSheet buttons = new SpriteSheet(ImageLoader.loadImage("res/textures/nbuttons12.png"));
		
		levelCompleted = ImageLoader.loadImage("res/textures/levelCompleted2.png");
		chooseLevel = ImageLoader.loadImage("res/textures/chooselevelnew.png");
		shop = ImageLoader.loadImage("res/textures/Shop.png");
		bgFarm = ImageLoader.loadImage("res/textures/backgroundFram.png");
		startBG = ImageLoader.loadImage("res/textures/menuBG.png");
		bgRainbow = ImageLoader.loadImage("res/textures/backgroundimage123.png");
		creditsBG = ImageLoader.loadImage("res/textures/credits2.png");
		settingsBG = ImageLoader.loadImage("res/textures/settings.png");
		buyScreen = ImageLoader.loadImage("res/textures/buyScreen.png");

		
		player_right = new BufferedImage[8];
		player_right[0] = players.getSprite(1, 7);
		player_right[1] = players.getSprite(2, 7);
		player_right[2] = players.getSprite(3, 7);
		player_right[3] = players.getSprite(4, 7);
		player_right[4] = players.getSprite(5, 7);
		player_right[5] = players.getSprite(6, 7);
		player_right[6] = players.getSprite(7, 7);
		player_right[7] = players.getSprite(8, 7);
		
		player_left = new BufferedImage[8];
		player_left[0] = players.getSprite(1, 8);
		player_left[1] = players.getSprite(2, 8);
		player_left[2] = players.getSprite(3, 8);
		player_left[3] = players.getSprite(4, 8);
		player_left[4] = players.getSprite(5, 8);
		player_left[5] = players.getSprite(6, 8);
		player_left[6] = players.getSprite(7, 8);
		player_left[7] = players.getSprite(8, 8);
		
		coin_anim = new BufferedImage[6];
		coin_anim[0] = sheet.getSprite(3, 1);
		coin_anim[1] = sheet.getSprite(4, 1);
		coin_anim[2] = sheet.getSprite(5, 1);
		coin_anim[3] = sheet.getSprite(6, 1);
		coin_anim[4] = sheet.getSprite(7, 1);
		coin_anim[5] = sheet.getSprite(8, 1);
	
		goomba_left = new BufferedImage[8];
		goomba_left[0] = players.getSprite(1, 15);
		goomba_left[1] = players.getSprite(2, 15);
		goomba_left[2] = players.getSprite(3, 15);
		goomba_left[3] = players.getSprite(4, 15);
		goomba_left[4] = players.getSprite(5, 15);
		goomba_left[5] = players.getSprite(6, 15);
		goomba_left[6] = players.getSprite(7, 15);
		goomba_left[7] = players.getSprite(8, 15);
		
		goomba_right = new BufferedImage[8];
		goomba_right[0] = players.getSprite(1, 16);
		goomba_right[1] = players.getSprite(2, 16);
		goomba_right[2] = players.getSprite(3, 16);
		goomba_right[3] = players.getSprite(4, 16);
		goomba_right[4] = players.getSprite(5, 16);
		goomba_right[5] = players.getSprite(6, 16);
		goomba_right[6] = players.getSprite(7, 16);
		goomba_right[7] = players.getSprite(8, 16);
		
		gApple_right = new BufferedImage[6];
		gApple_right[0] = players.getSprite(1, 13);
		gApple_right[1] = players.getSprite(2, 13);
		gApple_right[2] = players.getSprite(3, 13);
		gApple_right[3] = players.getSprite(4, 13);
		gApple_right[4] = players.getSprite(5, 13);
		gApple_right[5] = players.getSprite(6, 13);
		 
		gApple_left = new BufferedImage[6];
		gApple_left[0] = players.getSprite(7, 13);
		gApple_left[1] = players.getSprite(8, 13);
		gApple_left[2] = players.getSprite(9, 13);
		gApple_left[3] = players.getSprite(10, 13);
		gApple_left[4] = players.getSprite(11, 13);
		gApple_left[5] = players.getSprite(12, 13);
		
		gApple_jump_right = new BufferedImage[6];
		gApple_jump_right[0] = players.getSprite(1, 14); 
		gApple_jump_right[1] = players.getSprite(2, 14); 
		gApple_jump_right[2] = players.getSprite(3, 14); 
		gApple_jump_right[3] = players.getSprite(4, 14); 
		gApple_jump_right[4] = players.getSprite(5, 14); 
		gApple_jump_right[5] = players.getSprite(6, 14); 
		
		gApple_jump_left = new BufferedImage[6];
		gApple_jump_left[0] = players.getSprite(7, 14);
		gApple_jump_left[1] = players.getSprite(8, 14);
		gApple_jump_left[2] = players.getSprite(9, 14);
		gApple_jump_left[3] = players.getSprite(10, 14);
		gApple_jump_left[4] = players.getSprite(11, 14);
		gApple_jump_left[5] = players.getSprite(12, 14);
				
		candy_right = new BufferedImage[6];
		candy_right[0] = players.getSprite(1, 1);
		candy_right[1] = players.getSprite(2, 1);
		candy_right[2] = players.getSprite(3, 1);
		candy_right[3] = players.getSprite(4, 1);
		candy_right[4] = players.getSprite(5, 1);
		candy_right[5] = players.getSprite(6, 1);
		 
		candy_left = new BufferedImage[6];
		candy_left[0] = players.getSprite(7, 1);
		candy_left[1] = players.getSprite(8, 1);
		candy_left[2] = players.getSprite(9, 1);
		candy_left[3] = players.getSprite(10, 1);
		candy_left[4] = players.getSprite(11, 1);
		candy_left[5] = players.getSprite(12, 1);
		
		candy_jump_right = new BufferedImage[6];
		candy_jump_right[0] = players.getSprite(1, 2); 
		candy_jump_right[1] = players.getSprite(2, 2); 
		candy_jump_right[2] = players.getSprite(3, 2); 
		candy_jump_right[3] = players.getSprite(4, 2); 
		candy_jump_right[4] = players.getSprite(5, 2); 
		candy_jump_right[5] = players.getSprite(6, 2); 
		
		candy_jump_left = new BufferedImage[6];
		candy_jump_left[0] = players.getSprite(7, 2);
		candy_jump_left[1] = players.getSprite(8, 2);
		candy_jump_left[2] = players.getSprite(9, 2);
		candy_jump_left[3] = players.getSprite(10, 2);
		candy_jump_left[4] = players.getSprite(11, 2);
		candy_jump_left[5] = players.getSprite(12, 2);
		
		rApple_right = new BufferedImage[6];
		rApple_right[0] = players.getSprite(1, 3);
		rApple_right[1] = players.getSprite(2, 3);
		rApple_right[2] = players.getSprite(3, 3);
		rApple_right[3] = players.getSprite(4, 3);
		rApple_right[4] = players.getSprite(5, 3);
		rApple_right[5] = players.getSprite(6, 3);
		 
		rApple_left = new BufferedImage[6];
		rApple_left[0] = players.getSprite(7, 3);
		rApple_left[1] = players.getSprite(8, 3);
		rApple_left[2] = players.getSprite(9, 3);
		rApple_left[3] = players.getSprite(10, 3);
		rApple_left[4] = players.getSprite(11, 3);
		rApple_left[5] = players.getSprite(12, 3);
		
		rApple_jump_right = new BufferedImage[6];
		rApple_jump_right[0] = players.getSprite(1, 4); 
		rApple_jump_right[1] = players.getSprite(2, 4); 
		rApple_jump_right[2] = players.getSprite(3, 4); 
		rApple_jump_right[3] = players.getSprite(4, 4); 
		rApple_jump_right[4] = players.getSprite(5, 4); 
		rApple_jump_right[5] = players.getSprite(6, 4); 
		
		rApple_jump_left = new BufferedImage[6];
		rApple_jump_left[0] = players.getSprite(7, 4);
		rApple_jump_left[1] = players.getSprite(8, 4);
		rApple_jump_left[2] = players.getSprite(9, 4);
		rApple_jump_left[3] = players.getSprite(10, 4);
		rApple_jump_left[4] = players.getSprite(11, 4);
		rApple_jump_left[5] = players.getSprite(12, 4);
		
		sGirl_right = new BufferedImage[6];
		sGirl_right[0] = players.getSprite(1, 5);
		sGirl_right[1] = players.getSprite(2, 5);
		sGirl_right[2] = players.getSprite(3, 5);
		sGirl_right[3] = players.getSprite(4, 5);
		sGirl_right[4] = players.getSprite(5, 5);
		sGirl_right[5] = players.getSprite(6, 5);
		 
		sGirl_left = new BufferedImage[6];
		sGirl_left[0] = players.getSprite(7, 5);
		sGirl_left[1] = players.getSprite(8, 5);
		sGirl_left[2] = players.getSprite(9, 5);
		sGirl_left[3] = players.getSprite(10, 5);
		sGirl_left[4] = players.getSprite(11, 5);
		sGirl_left[5] = players.getSprite(12, 5);
		
		sGirl_jump_right = new BufferedImage[6];
		sGirl_jump_right[0] = players.getSprite(1, 6); 
		sGirl_jump_right[1] = players.getSprite(2, 6); 
		sGirl_jump_right[2] = players.getSprite(3, 6); 
		sGirl_jump_right[3] = players.getSprite(4, 6); 
		sGirl_jump_right[4] = players.getSprite(5, 6); 
		sGirl_jump_right[5] = players.getSprite(6, 6); 
		
		sGirl_jump_left = new BufferedImage[6];
		sGirl_jump_left[0] = players.getSprite(7, 6);
		sGirl_jump_left[1] = players.getSprite(8, 6);
		sGirl_jump_left[2] = players.getSprite(9, 6);
		sGirl_jump_left[3] = players.getSprite(10, 6);
		sGirl_jump_left[4] = players.getSprite(11, 6);
		sGirl_jump_left[5] = players.getSprite(12, 6);
		
		rGirl_right = new BufferedImage[6];
		rGirl_right[0] = players.getSprite(1, 9);
		rGirl_right[1] = players.getSprite(2, 9);
		rGirl_right[2] = players.getSprite(3, 9);
		rGirl_right[3] = players.getSprite(4, 9);
		rGirl_right[4] = players.getSprite(5, 9);
		rGirl_right[5] = players.getSprite(6, 9);
		 
		rGirl_left = new BufferedImage[6];
		rGirl_left[0] = players.getSprite(7, 9);
		rGirl_left[1] = players.getSprite(8, 9);
		rGirl_left[2] = players.getSprite(9, 9);
		rGirl_left[3] = players.getSprite(10, 9);
		rGirl_left[4] = players.getSprite(11, 9);
		rGirl_left[5] = players.getSprite(12, 9);
		
		boy2_right = new BufferedImage[6];
		boy2_right[0] = players.getSprite(1, 10);
		boy2_right[1] = players.getSprite(2, 10);
		boy2_right[2] = players.getSprite(3, 10);
		boy2_right[3] = players.getSprite(4, 10);
		boy2_right[4] = players.getSprite(5, 10);
		boy2_right[5] = players.getSprite(6, 10);
		 
		boy2_left = new BufferedImage[6];
		boy2_left[0] = players.getSprite(7, 10);
		boy2_left[1] = players.getSprite(8, 10);
		boy2_left[2] = players.getSprite(9, 10);
		boy2_left[3] = players.getSprite(10, 10);
		boy2_left[4] = players.getSprite(11, 10);
		boy2_left[5] = players.getSprite(12, 10);
		
		guy_right = new BufferedImage[4];
		guy_right[0] = players.getSprite(7, 11);
		guy_right[1] = players.getSprite(8, 11);
		guy_right[2] = players.getSprite(9, 11);
		guy_right[3] = players.getSprite(10, 11);
		
		guy_left = new BufferedImage[4];
		guy_left[0] = players.getSprite(7, 12);
		guy_left[1] = players.getSprite(8, 12);
		guy_left[2] = players.getSprite(9, 12);
		guy_left[3] = players.getSprite(10, 12);
			
		rabbit_right = new BufferedImage[3];
		rabbit_right[0] = players.getSprite(1, 11);
		rabbit_right[1] = players.getSprite(2, 11);
		rabbit_right[2] = players.getSprite(3, 11);
		
		rabbit_left = new BufferedImage[3];
		rabbit_left[0] = players.getSprite(4, 11);
		rabbit_left[1] = players.getSprite(5, 11);
		rabbit_left[2] = players.getSprite(6, 11);
		
		goat_right = new BufferedImage[3];
		goat_right[0] = players.getSprite(1, 12);
		goat_right[1] = players.getSprite(2, 12);
		goat_right[2] = players.getSprite(3, 12);
		
		goat_left = new BufferedImage[3];
		goat_left[0] = players.getSprite(4, 12);
		goat_left[1] = players.getSprite(5, 12);
		goat_left[2] = players.getSprite(6, 12);
		
		extra_health = new BufferedImage[5];
		extra_health[0] = sheet.getSprite(6, 6);
		extra_health[1] = sheet.getSprite(7, 6);
		extra_health[2] = sheet.getSprite(8, 6);
		extra_health[3] = sheet.getSprite(9, 6);
		extra_health[4] = sheet.getSprite(10, 6);

		lives = new BufferedImage[5];
		lives[0] = sheet.getSprite(5, 4);
		lives[1] = sheet.getSprite(4, 4);
		lives[2] = sheet.getSprite(3, 4);
		lives[3] = sheet.getSprite(2, 4);
		lives[4] = sheet.getSprite(1, 4);
		
		loading = new BufferedImage[16];
		loading[0] = buttons.getSprite(1, 4);
		loading[1] = buttons.getSprite(2, 4);
		loading[2] = buttons.getSprite(3, 4);
		loading[3] = buttons.getSprite(4, 4);
		loading[4] = buttons.getSprite(1, 5);
		loading[5] = buttons.getSprite(2, 5);
		loading[6] = buttons.getSprite(3, 5);
		loading[7] = buttons.getSprite(4, 5);
		loading[8] = buttons.getSprite(1, 6);
		loading[9] = buttons.getSprite(2, 6);
		loading[10] = buttons.getSprite(3, 6);
		loading[11] = buttons.getSprite(4, 6);
		loading[12] = buttons.getSprite(1, 7);
		loading[13] = buttons.getSprite(2, 7);
		loading[14] = buttons.getSprite(3, 7);
		loading[15] = buttons.getSprite(4, 7);
			
		mario = sheet1.getSprite(1, 1);
		boyPlayer = sheet1.getSprite(3 ,1);
		grass = sheet1.getSprite(2, 2);
//		tree = sheet1.getSprite(1, 2);
		dirt = sheet.getSprite(2, 5);
		rMushroom = sheet.getSprite(6, 4);
		gMushroom = sheet.getSprite(7, 4);
		flower = sheet.getSprite(8, 4);
		surpriseBlock = sheet.getSprite(1, 1);
		surpriseBlockHitted = sheet.getSprite(2, 1);
		pCoin = sheet.getSprite(3, 1);
		buttonNotClicked = sheet.getSprite(6, 5);
		buttonClicked = sheet.getSprite(7, 5);
		doorC = sheet.getSprite(2, 1);
		doorO = sheet.getSprite(5, 6);
		star = sheet.getSprite(4, 5);
		boss = sheet.getSprite(8, 8);
		stone = sheet.getSprite(5, 6);
		snow = sheet.getSprite(4, 6);
		frog = sheet.getSprite(6, 10);
		rabbit = sheet.getSprite(7, 10);
		buttonActive = buttons.getSprite(1, 1);
		buttonActive_hovering = buttons.getSprite(1, 2);
		buttonNActive = buttons.getSprite(2, 1);
		buttonPurchased = buttons.getSprite(2, 2);
		buttonPurchased_hovering = buttons.getSprite(2, 3);
		buttonEquiped = buttons.getSprite(3, 2);
		buttonEquiped_hovering = buttons.getSprite(3, 3);
		buttonGold = buttons.getSprite(4, 1);
		buttonGold_hovering = buttons.getSprite(4, 2);
		end = sheet.getSprite(8, 5);
		
	}
	
	
}
