package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import entity.Player;
import game.DataBase;
import game.Game;
import game.MouseInput;
import graphic.Assets;
import graphic.Sound;

public class Button {
	private int x, y, width, height, size, spaceX, space2X, spaceY;
	private Rectangle bounds;
	private boolean hovering = false;
	private Sound sound;
	public static boolean clicked = false;
	private int stars;
	private boolean purchased, equiped, gold;
	boolean isOpen = true;
	private String title = "";
	private String title2 = "";
	private int price;
	private boolean showPrice, canBuy;

	public Button(int x, int y, int width, int height, String title, int size, int spaceX) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.size = size;
		this.spaceX = spaceX;
		if (!title.equals(""))
			this.title = title;
		bounds = new Rectangle(x, y, width, height);
	}


	public void tick() {
		if (bounds != null && bounds.contains(MouseInput.x, MouseInput.y)) {
			hovering = true;
		}
		else {
			hovering = false;
		}
		if (hovering && clicked) {
			if (!isOpen)
				sound.start(Sound.incorrect);
			else if (isOpen)
				triggerEvent();
			// }
		}
	}

	public void render(Graphics g) {
		if (isOpen) {
			if(!purchased) {
			if (hovering)
				if(gold)
					g.drawImage(Assets.buttonGold_hovering, x, y, width, height, null);
				else
				g.drawImage(Assets.buttonActive_hovering, x, y, width, height, null);
			if (!hovering)
				if(gold)
					g.drawImage(Assets.buttonGold, x, y, width, height, null);
				else
				g.drawImage(Assets.buttonActive, x, y, width, height, null);
			g.setColor(Color.black);
			g.setFont(new Font("Matura MT Script Capitals", Font.BOLD, size));
			g.drawString(title, x + spaceX, y + height / 2);
			if(showPrice)
				g.drawString("" + price, x + spaceX, y + height / 2 + height / 4);
			else 
				g.drawString(title2, x + space2X, y + height / 2 + height / 4);
			}
			if(purchased) {
			if(!equiped) {
			if (hovering) {
				g.drawImage(Assets.buttonActive_hovering, x, y, width, height, null);
			}
			if (!hovering) {
				g.drawImage(Assets.buttonPurchased, x, y, width, height, null);
			}
			g.setColor(Color.black);
			g.setFont(new Font("Matura MT Script Capitals", Font.BOLD, size));
			g.drawString(title, x + spaceX, y + height / 2);
			g.drawString(title2, x + space2X, y + height / 2 + height / 4);
			}
			if(equiped) {
			if (hovering)
					g.drawImage(Assets.buttonEquiped_hovering, x, y, width, height, null);
			if (!hovering)
					g.drawImage(Assets.buttonEquiped, x, y, width, height, null);
			g.setColor(Color.black);
			g.setFont(new Font("Matura MT Script Capitals", Font.BOLD, size));
			g.drawString(title, x + spaceX, y + height / 2);
			g.drawString(title2, x + space2X, y + height / 2 + height / 4);
			}
			}
			if(stars == 1) {
				g.drawImage(Assets.star, x+10, y+height-60, 55, 55, null);
			}
			if(stars == 2) {
				g.drawImage(Assets.star, x+10, y+height-60, 55, 55, null);
				g.drawImage(Assets.star, x+70, y+height-60, 55, 55, null);

			}
			if(stars == 3) {
				g.drawImage(Assets.star, x+10, y+height-60, 55, 55, null);
				g.drawImage(Assets.star, x+75, y+height-60, 55, 55, null);
				g.drawImage(Assets.star, x+140, y+height-60, 55, 55, null);
			}
		}
		if (!isOpen) {
			if (hovering)
				g.drawImage(Assets.buttonNActive, x, y, width, height, null);
			if (!hovering)
				g.drawImage(Assets.buttonNActive, x, y, width, height, null);
		}
	}

	public void triggerEvent() {
		if (Launcher.showing) {
			if (title.toLowerCase().contains("start")) {
				LevelSelector.showing = true;
				Launcher.showing = false;

			}
			if (title.toLowerCase().contains("shop")) {
				Shop.showing = true;
				Launcher.showing = false;
			}

			if (title.toLowerCase().contains("settings")) {
				Settings.showing = true;
				Launcher.showing = false;
			}
			if (title.toLowerCase().contains("credit")) {
				Launcher.showing = false;
				Credits.showing = true;
			}
			if (title.toLowerCase().contains("exit")) {
				System.exit(0);
			}
		}

		if (LevelFinish.showing) {
			if (getTitle().toLowerCase().contains("next")) {
				Game.coinsTimer = 0;
				LevelFinish.showing = false;
				Game.switchLevel();
			}
			if (getTitle().toLowerCase().contains("back")) {
				Game.coinsTimer = 0;
				Game.playing = false;
				LevelFinish.showing = false;
				Launcher.showing = true;

			}
		}
		if (Settings.showing) {
			// quit , fullScreen, halfScreen, muteTheme, muteAll
			if (getTitle().toLowerCase().contains("back")) {
				Game.playing = false;
				Settings.showing = false;
				Launcher.showing = true;
			}
			if (getTitle().toLowerCase().contains("mute")) {
				System.out.println("mute");
				Settings.muted = true;
				DataBase.muteSound();
			}

		}


		if (Credits.showing) {
			if (getTitle().toLowerCase().contains("back")) {
				Credits.showing = false;
				Launcher.showing = true;
			}
		}
		if (Pause.showing) {
			if (getTitle().toLowerCase().contains("resume")) {
				Pause.showing = false;
			}
			if (getTitle().toLowerCase().contains("settings")) {
				Game.playing = false;
				Pause.showing = false;
				Settings.showing = true;
			}
			if (getTitle().toLowerCase().contains("back")) {
				if (Game.bossLevel)
					Game.bossLevel = false;
				Game.playing = false;
				Pause.showing = false;
				Launcher.showing = true;
			}

		}
		if (GameOver.showing) {
			if (getTitle().toLowerCase().contains("return")) {
				if (Game.bossLevel)
					Game.bossLevel = false;
				Game.playing = false;
				Game.lives = 5;
				GameOver.showing = false;
				Launcher.showing = true;
			}
		}
		if (LevelSelector.showing) {
			if (getTitle().toLowerCase().contains("back")) {
				LevelSelector.showing = false;
				Launcher.showing = true;
			}
			if (getTitle().toLowerCase().contains("level")) {
				for (int i = 0; i < LevelSelector.levels.length; i++) {
					if (getTitle().toLowerCase().contains("" + i)) {
						Game.specLevel(i);
						LevelSelector.showing = false;
						Game.playing = true;
					}
				}
			}
			if (getTitle().toLowerCase().contains("custom")) {
				Game.specLevel(11);
				LevelSelector.showing = false;
				Game.playing = true;
			}
		}
		if (Shop.showing) {
			if(!Shop.buyScreen) {
			if (getTitle().toLowerCase().contains("back")) {
				System.out.println("back");
				Shop.showing = false;
				Launcher.showing = true;
			}
			if (title.toLowerCase().contains("regular")) {
				if(Shop.skins[0].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(0);
				}
				System.out.println("regular");
			}

			if (getTitle().toLowerCase().contains("mushroom")) {
				Shop.mushroomAV = true;
				if(!Shop.skins[1].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[1].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(1);
				}

				}
			if (getTitle().toLowerCase().contains("green")) {
				Shop.gAppleAV = true;
				if(!Shop.skins[2].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[2].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(2);
				}
			}
			if (getTitle().toLowerCase().contains("red apple")) {
				Shop.rAppleAV = true;
				if(!Shop.skins[3].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[3].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(3);
				}
			}
			if (getTitle().toLowerCase().contains("candy")) {
				Shop.candyAV = true;
				if(!Shop.skins[4].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[4].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(4);
				}
			}
			if (getTitle().toLowerCase().contains("purple girl")) {
				Shop.girlAV = true;
				if(!Shop.skins[5].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[5].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(5);
				}
			}
			if (getTitle().toLowerCase().contains("red girl")) {
				Shop.rGirlAV = true;
				if(!Shop.skins[6].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[6].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(6);
				}
			}
			if (getTitle().toLowerCase().contains("boy")) {
				Shop.boy2AV = true;
				if(!Shop.skins[7].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[7].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(7);
				}
			}
			if (getTitle().toLowerCase().contains("rabbit")) {
				Shop.rabbitAV = true;
				if(!Shop.skins[8].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[8].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(8);
				}
			}
			if (getTitle().toLowerCase().contains("man")) {
				Shop.manAV = true;
				if(!Shop.skins[9].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[9].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(9);
				}
			}
			if (getTitle().toLowerCase().contains("goat")) {
				Shop.goatAV = true;
				if(!Shop.skins[10].isPurchased()) {
				Shop.buyScreen = true;
				}
				if(Shop.skins[10].isPurchased()) {
					Shop.equipped = true;
					DataBase.changeSkin(10);
				}
			}
			}
			if(Shop.buyScreen) {
				if (getTitle().toLowerCase().contains("x")) {
					Shop.buyScreen = false;
					Shop.gAppleAV = false;
					Shop.mushroomAV = false;
					Shop.candyAV = false;
					Shop.rAppleAV = false;
					Shop.girlAV = false;
					Shop.haveCoins = true;
				}
				if (getTitle().toLowerCase().contains("buy")) {
					if(Shop.mushroomAV) {
						if(Shop.skins[1].isCanBuy()) {
						Shop.skins[1].setPurchased(true);
						DataBase.addShop(1);
						DataBase.removeCoins(Shop.skins[1].getPrice());
						Shop.gAppleAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.gAppleAV) {
						if(Shop.skins[2].isCanBuy()) {
						Shop.skins[2].setPurchased(true);
						DataBase.addShop(2);
						DataBase.removeCoins(Shop.skins[2].getPrice());
						Shop.gAppleAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.rAppleAV) {
						if(Shop.skins[3].isCanBuy()) {
						Shop.skins[3].setPurchased(true);
						DataBase.addShop(3);
						DataBase.removeCoins(Shop.skins[3].getPrice());
						Shop.rAppleAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.candyAV) {
						if(Shop.skins[4].isCanBuy()) {
						Shop.skins[4].setPurchased(true);
						DataBase.addShop(4);
						DataBase.removeCoins(Shop.skins[4].getPrice());
						Shop.candyAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.girlAV) {
						if(Shop.skins[5].isCanBuy()) {
						Shop.skins[5].setPurchased(true);
						DataBase.addShop(5);
						DataBase.removeCoins(Shop.skins[5].getPrice());
						Shop.girlAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.rGirlAV) {
						if(Shop.skins[6].isCanBuy()) {
						Shop.skins[6].setPurchased(true);
						DataBase.addShop(6);
						DataBase.removeCoins(Shop.skins[6].getPrice());
						Shop.rGirlAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.boy2AV) {
						if(Shop.skins[7].isCanBuy()) {
						Shop.skins[7].setPurchased(true);
						DataBase.addShop(7);
						DataBase.removeCoins(Shop.skins[7].getPrice());
						Shop.boy2AV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.rabbitAV) {
						if(Shop.skins[8].isCanBuy()) {
						Shop.skins[8].setPurchased(true);
						DataBase.addShop(8);
						DataBase.removeCoins(Shop.skins[8].getPrice());
						Shop.rabbitAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.manAV) {
						if(Shop.skins[9].isCanBuy()) {
						Shop.skins[9].setPurchased(true);
						DataBase.addShop(9);
						DataBase.removeCoins(Shop.skins[9].getPrice());
						Shop.manAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
					if(Shop.goatAV) {
						if(Shop.skins[10].isCanBuy()) {
						Shop.skins[10].setPurchased(true);
						DataBase.addShop(10);
						DataBase.removeCoins(Shop.skins[10].getPrice());
						Shop.goatAV = false;
						Shop.buyScreen = false;
						Shop.bought = true;
						}
						else
							Shop.haveCoins = false;
					}
				}
			}
		}
		}
	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	
	public String getTitle2() {
		return title2;
	}

	public void setSpaceX(int spaceX) {
		this.spaceX = spaceX;
	}

	public int getX() {
//		Launcher.init();
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getStars() {
		return stars;
	}


	public void setStars(int addStars) {
		this.stars = addStars;
	}


	public int getSpaceY() {
		return spaceY;
	}


	public void setSpaceY(int spaceY) {
		this.spaceY = spaceY;
	}


	public boolean isOpen() {
		return isOpen;
	}


	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public boolean isShowPrice() {
		return showPrice;
	}


	public void setShowPrice(boolean showPrice) {
		this.showPrice = showPrice;
	}


	public boolean isCanBuy() {
		return canBuy;
	}


	public void setCanBuy(boolean canBuy) {
		this.canBuy = canBuy;
	}


	public int getSpace2X() {
		return space2X;
	}


	public void setSpace2X(int space2x) {
		space2X = space2x;
	}


	public int getSpaceX() {
		return spaceX;
	}


	public boolean isGold() {
		return gold;
	}


	public void setGold(boolean gold) {
		this.gold = gold;
	}

}
