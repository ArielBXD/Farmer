package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DB {
	private static File shopDB, levelDB, coinsDB;
	private static BufferedWriter writerLevel, writerShop, writerCoins;
	private static String fileContant = "";
	public static char ar;
	static int le;
	public static int readLevelDB(){
		String s;
		int levelsAv = 0;
		try {
			BufferedReader scanLevel = new BufferedReader(new FileReader("/Users/Sigal/Desktop/DataBases/levelsDB.txt"));
			while((s = scanLevel.readLine()) != null) {
				levelsAv++;
}
			scanLevel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return levelsAv;	
	}
	public static int readShopDB(){
		String s;
		int skinsAv = 0;
		try {
			BufferedReader scanShop = new BufferedReader(new FileReader("/Users/Sigal/Desktop/DataBases/shopDB.txt"));
			while((s = scanShop.readLine()) != null) {
				skinsAv++;
}
			scanShop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return skinsAv;	
	}
	public static int readCoinsDB(){
		String s;
		int coinsAv = 0;
		try {
			BufferedReader scanCoins = new BufferedReader(new FileReader("/Users/Sigal/Desktop/DataBases/coinsDB.txt"));
			while((s = scanCoins.readLine()) != null) {
				coinsAv++;
}
			scanCoins.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return coinsAv;	
	}
	public static void addLevelDB() {
		int levels = readLevelDB();
		try {
			writerLevel = new BufferedWriter(new FileWriter("/Users/Sigal/Desktop/DataBases/levelsDB.txt"));
			for(int i = 0; i < levels; i++) {
				writerLevel.write("1" + "\n");
			}
			writerLevel.write("1");
			writerLevel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static void addShopDB() {
		int shop = readShopDB();
		try {
			writerShop = new BufferedWriter(new FileWriter("/Users/Sigal/Desktop/DataBases/shopDB.txt"));
			for(int i = 0; i < shop; i++) {
				writerShop.write("1" + "\n");
			}
			writerShop.write("1");
			writerShop.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static void addCoinsDB() {
		int coins = readCoinsDB();
		try {
			writerCoins = new BufferedWriter(new FileWriter("/Users/Sigal/Desktop/DataBases/coinsDB.txt"));
			for(int i = 0; i < coins; i++) {
				writerCoins.write("1" + "\n");
//				writerCoins.write("1");
			}
			writerCoins.write("1");
			writerCoins.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static void removeCoinsDB(int amount) {
		int coins = readCoinsDB();
		try {
			writerCoins = new BufferedWriter(new FileWriter("/Users/Sigal/Desktop/DataBases/coinsDB.txt"));
			for(int i = amount; i < coins; i++) {
				writerCoins.write("1" + "\n");
//				writerCoins.write("1");
			}
			writerCoins.write("1");
			writerCoins.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	
	
	
	
	
}
