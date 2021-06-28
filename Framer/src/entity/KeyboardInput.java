package entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import game.Id;
import graphic.Sound;
import gui.Launcher;
import gui.Pause;
import gui.Shop;

public class KeyboardInput implements KeyListener{
	private static Launcher launcher;
	private static Sound sound;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_ESCAPE:
		//	pauseMenu.renderM();
	//		Pause.showing = true;
		//	launcher.game.pause = true;
			if(Game.playing)
				Pause.showing = true;
			
			break;
		}
		for(Entity ent: Game.handler.entity) {
		if(ent.getId() == Id.player) {
			Player.animate = true;
		switch(key) {
		case KeyEvent.VK_W:
			if(ent.jumpable) {
				if(!launcher.game.bossLevel)
					ent.falling = false;
				sound.start(Sound.jump);
				ent.jumping = true;
				if(ent.jumpBoost)
					ent.gravity = -9;
				if(!ent.jumpBoost)
						ent.gravity = -6;
				}
				break;

/*		case KeyEvent.VK_S:
			ent.setVelY(5);
			break;*/
		case KeyEvent.VK_A:
			if(ent.runBoost)
				ent.setVelX(-12);
			else
				ent.setVelX(-8);
			ent.facing = 1;
			break;
		case KeyEvent.VK_D:			
			if(ent.runBoost)
			ent.setVelX(12);
		else
			ent.setVelX(8);
			ent.facing = 0;
			break;
		case KeyEvent.VK_SPACE:
			if(ent.jumpable) {
				if(!launcher.game.bossLevel)
					ent.falling = false;
				sound.start(Sound.jump);
				ent.jumping = true;
				if(ent.jumpBoost)
					ent.gravity = -9;
				if(!ent.jumpBoost)
						ent.gravity = -6;
				}
			break;
		case KeyEvent.VK_UP:
			if(ent.jumpable) {
				if(!launcher.game.bossLevel)
					ent.falling = false;
				sound.start(Sound.jump);
				ent.jumping = true;
				if(ent.jumpBoost)
					ent.gravity = -9;
				if(!ent.jumpBoost)
						ent.gravity = -6;
				}
			break;
/*		case KeyEvent.VK_DOWN:
			ent.setVelY(5);
			break;*/
		case KeyEvent.VK_LEFT:
			if(ent.runBoost)
				ent.setVelX(-12);
			else
				ent.setVelX(-8);
			ent.facing = 1;
			break;
		case KeyEvent.VK_RIGHT:		
			if(ent.runBoost)
			ent.setVelX(12);
		else
			ent.setVelX(8);
			ent.facing = 0;
			break;
		
		//Skin Changer
		case KeyEvent.VK_F1:
			Player.skin = 0;
			Game.restart();
			break;
		case KeyEvent.VK_F2:
			if(Shop.mushroomAV) {
			Player.skin = 1;
			Game.restart();
			}
			break;
		case KeyEvent.VK_F3:
			if(Shop.gAppleAV) {
			Player.skin = 2;
			Game.restart();
			}
			break;
		case KeyEvent.VK_F4:
			if(Shop.candyAV) {
			Player.skin = 3;
			Game.restart();
			}
			break;
		case KeyEvent.VK_F5:
			if(Shop.rAppleAV) {
			Player.skin = 4;
			Game.restart();
			}
			break;
		case KeyEvent.VK_F6:
			if(Shop.girlAV) {
			Player.skin = 5;
			Game.restart();
			break;
		}
		}
		}
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity ent: Game.handler.entity) {
		if(ent.getId() == Id.player) {
//			Player.animate = false;
		switch(key) {
		case KeyEvent.VK_W:
			ent.setVelY(0);
			break;
		case KeyEvent.VK_S:
			ent.setVelY(0);
			break;
		case KeyEvent.VK_A:
			ent.setVelX(0);
			break;
		case KeyEvent.VK_D:
			ent.setVelX(0);
			break;
		case KeyEvent.VK_UP:
			ent.setVelY(0);
			break;
		case KeyEvent.VK_DOWN:
			ent.setVelY(0);
			break;
		case KeyEvent.VK_LEFT:
			ent.setVelX(0);
			break;
		case KeyEvent.VK_RIGHT:
			ent.setVelX(0);
			break;
		}
		}
	}
		
		}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	
	
}
