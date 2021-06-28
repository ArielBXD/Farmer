package graphic;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.sound.sampled.*;

import game.DataBase;



public class Sound{
	private static Clip clip;
	public static int loopCounter = 0;
	
	private static AudioInputStream audioStream;
	public static File mainTheme = new File("res/sounds/mainSound.wav");
	public static File bossTheme = new File("res/sounds/BossTheme.wav");
	public static File jump = new File("res/sounds/jump.wav");
	public static File enemyDefeat = new File("res/sounds/Popupsound.wav");
	public static File coin = new File("res/sounds/coin.wav");
	public static File door = new File("res/sounds/Door open.wav");
	public static File incorrect = new File("res/sounds/incorrect.wav");
	public static File ding = new File("res/sounds/ding.wav");
	public static File guitar = new File("res/sounds/guitar2.wav");
			public static void soundMaker(File path) {

			try {
				audioStream = AudioSystem.getAudioInputStream(path);
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}

			try {
				clip.open(audioStream);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			}
			public static void start(File path) {
			boolean mute = DataBase.readSound();
			if(!mute) {
			soundMaker(path);	
			clip.start();
			}
			if(mute) {
				stop(path);
			}
			}
			public static void loop(File path, int seconds) {
				if(loopCounter == 0) 
					start(path);
				loopCounter++;
				
				if(loopCounter >= seconds) {
					closesound(path);
					//loopCounter = 0;
				}
				
			}
			public static void stop(File path) {
			soundMaker(path);	
			clip.stop();
			}
			public static void restart(File path) {
			soundMaker(path);	
			clip.setMicrosecondPosition(0);
			}
			public static void closesound(File path) {
			soundMaker(path);	
			clip.close();
			}}
	