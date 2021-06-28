package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import game.DataBase;
import game.Game;
import graphic.Assets;
import graphic.ImageLoader;

public class Shop2{
	public static Button[] skins;
	private static Button back, exit, buy;
	private static int width, height;
	private static int buttonX, buttonY, raw = 0;
	private static final int buttonWidth = 213, buttonHeight = 123;
	private static BufferedImage background;
	public static boolean musroomAV , gAppleAV , rAppleAV , insectAV , girlAV ;
	private static int readingTimer = 0;
	public static int initTimer = 0;
//	public static boolean musroomAV = true, gAppleAV = true, rAppleAV = true, insectAV = true, girlAV = true;
	static int price = 500;
	public static boolean showing = false;
	static boolean buyScreen;

	
	public Shop2() {
//		bac
//		back = new Button(80, 35, 111, 62, "back",30, 20);
//		buttonX =  180;
//		buttonY = 190;
//		skins = new Button[8];
//		for(int j = 0; j < skins.length; j++) {
//			skins[j] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "open" + (j+1),40, 40);
//			raw++;
//			buttonX = buttonX+buttonWidth+60;
//			if(raw >= 4) {
//				buttonX = 180;
//				buttonY = buttonY+170;
//				raw = 0;
//			}
//			if(j >= 0 && j <6) {
//			if(DataBase.readShop(j)) {
//				skins[j].setPurchased(true);
//				skins[j].setTitle2("purchased");
//			}
//			if(DataBase.readSkin() == j) {
//				skins[j].setEquiped(true);
//				skins[j].setTitle2("equiped");
//			}
//			}
////			levels[j].isOpen = true;
//		}
//		for(int i = skins.length; i < skins.length; i++) {
//			skins[i] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "mystery" + (i+1),50, 0);
//			raw++;
//			buttonX = buttonX+buttonWidth+60;
//			if(raw >= 4) {
//				buttonX = 180;
//				buttonY = buttonY+170;
//				raw = 0;
//			}
//			skins[i].isOpen = false;
////			levels[0].isOpen = true;
//		}
//
//		skins[0].setTitle("regular");
//		skins[1].setTitle("Apple");
//		skins[2].setTitle("red Apple");
//		skins[5].setTitle("girl");
//		if(!skins[1].isPurchased())
//			skins[1].setTitle2("" +price);
//		if(!skins[2].isPurchased())
//			skins[2].setTitle2("" + price);
//		if(!skins[3].isPurchased())
//			skins[3].setTitle2("" + price);
//		
//		skins[1].setSpace(30);
//		skins[2].setSpace(10);
//		skins[5].setSpace(70);
//		
//		if(buyScreen) {
//			exit = new Button(410, 245, 45, 45, "x", 40, 12);
//			buy = new Button(520, 500, 290, 70, "buy", 60, 100);
//		}
	}
	public static void init() {
		width = Settings.getFrameWidth();
		height =Settings.getFrameHeight();
	}
	public static void tick() {
//		if(Loading.loadTimer < 10)
//			Loading.showing = true;
//		else 
//			Loading.showing = false;
		back = new Button(80, 35, 111, 62, "back",30, 20);
		back.tick();
		buttonX =  180;
		buttonY = 190;
		skins = new Button[8];
		for(int j = 0; j < skins.length; j++) {
			skins[j] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "open" + (j+1),40, 40);
			raw++;
			buttonX = buttonX+buttonWidth+60;
			if(raw >= 4) {
				buttonX = 180;
				buttonY = buttonY+170;
				raw = 0;
			}
			if(j >= 0 && j <6) {
			if(DataBase.readShop(j)) {
				skins[j].setPurchased(true);
				skins[j].setTitle2("purchased");
			}
			if(DataBase.readSkin() == j) {
				skins[j].setEquiped(true);
				skins[j].setTitle2("equiped");
			}
			}
//			levels[j].isOpen = true;
			skins[j].tick();
		}
/*		for(int i = skins.length; i < skins.length; i++) {
			skins[i] = new Button(buttonX, buttonY, buttonWidth, buttonHeight, "mystery" + (i+1),50, 0);
			raw++;
			buttonX = buttonX+buttonWidth+60;
			if(raw >= 4) {
				buttonX = 180;
				buttonY = buttonY+170;
				raw = 0;
			}
			skins[i].isOpen = false;
//			levels[0].isOpen = true;
			skins[i].tick();
		}*/

		skins[0].setTitle("regular");
		skins[1].setTitle("Apple");
		skins[2].setTitle("red Apple");
		skins[5].setTitle("girl");
		if(!skins[1].isPurchased())
			skins[1].setTitle2("" +price);
		if(!skins[2].isPurchased())
			skins[2].setTitle2("" + price);
		if(!skins[3].isPurchased())
			skins[3].setTitle2("" + price);
		
		skins[1].setSpaceX(30);
		skins[2].setSpaceX(10);
		skins[5].setSpaceX(70);
		
		if(buyScreen) {
			exit = new Button(410, 245, 45, 45, "x", 40, 12);
			buy = new Button(520, 500, 290, 70, "buy", 60, 100);
			buy.tick();
			exit.tick();
		}
		Loading.loadTimer++;
	}
	public static void render(Graphics g) {
		init();
		g.drawImage(Assets.shop, 0, 0, width, height, null);
		back.render(g);
		for(int i = 0 ; i < skins.length; i++) {
		skins[i].render(g);
	}
		g.setColor(Color.white);
		g.drawString("" + DataBase.readCoins(), 240, 735);
		if(buyScreen) {
			g.drawImage(Assets.buyScreen, 400, 235, Assets.buyScreen.getWidth(), Assets.buyScreen.getHeight(), null);
			exit.render(g);
			buy.render(g);
			g.setFont(new Font("Aharoni", Font.BOLD, 50));
			g.drawString("Accept the purchase", 435, 350);
		//	g.setColor(Color.cyan);
		//	g.fillRect(400, 300, 540, 361);
	//		System.out.println("true");
		}

}
}