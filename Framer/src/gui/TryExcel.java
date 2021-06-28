package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TryExcel {
	/*https://mkyong.com/java/apache-poi-reading-and-writing-excel-file-in-java/
	 * https://www.tutorialspoint.com/apache_poi/apache_poi_cells.htm
	 * https://www.youtube.com/watch?v=nmum2jEwOUA
	 * https://www.youtube.com/watch?v=xabbFBBn6T8
	 * https://www.youtube.com/watch?v=rDNGhcKnnqA*/
	private static int levelsAV = 0, coinsAV = 0, skinsAV = 0, currentSkin = 0;
    private static final String file = "res/databases/sqlnew.xlsx";
 //   private static FileOutputStream outputStream;
 //   private static XSSFWorkbook workbook;
//    private static XSSFSheet sheet;
 /*   public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DataBase");
        Object[][] datatypes = {
                {"levels", "coins", "skins"},
                {levelsAV, coinsAV, skinsAV},
                {"", "", currentSkin}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                	if(field.equals("skins"))
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
        
    }*/
    public static void main(String[]args) {
    	readLevel();
    	readShop(4);
    	readSkin();
    	readCoins();
 //   	addCoins();
   // 	readDB();
  //  	addCoins();
    }
/*    private static void init() {
    	workbook = new XSSFWorkbook();
    	sheet = workbook.getSheet("INFo");
    	try {
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	private static void readDB() {
  // 		public static void main(String[] args){
    	XSSFWorkbook workbook = new XSSFWorkbook();
    	XSSFSheet sheet = workbook.createSheet("INFo");
    	
    	XSSFRow rowLevel, rowShop, rowCoins;
    	
    	 rowLevel = sheet.createRow(0);
    	 Cell cellLevel = rowLevel.createCell(0);
    	 rowShop = sheet.createRow(1);
     	Cell cellShop = rowShop.createCell(0);
     	Cell cellSkin = rowShop.createCell(1);
    	 rowCoins = sheet.createRow(2);
     	Cell cellCoins = rowCoins.createCell(0);

    	
    	cellLevel.setCellValue(levelsAV);
    	cellShop.setCellValue(skinsAV);
    	cellSkin.setCellValue(currentSkin);
    	cellCoins.setCellValue(coinsAV);
    	System.out.println("levels: " + cellLevel.getNumericCellValue() + "shop: " + cellShop.getNumericCellValue() +"nowskin:  " + cellSkin.getNumericCellValue() +"coins: " + cellCoins.getNumericCellValue());
    	
        try {
        	FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	System.out.println("levels: " + cellLevel.getNumericCellValue() + "shop: " + cellShop.getNumericCellValue() +"nowskin:  " + cellSkin.getNumericCellValue() +"coins: " + cellCoins.getNumericCellValue());

    }*/
    public static void readLevel() {
    	double levels = 0;
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("INFo");
			levels = sheet.getRow(0).getCell(0).getNumericCellValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Levels: " + levels);
    }
    public static void readShop(int skin) {
    	boolean shop = false;
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("INFo");
			shop = sheet.getRow(1).getCell(skin).getBooleanCellValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Shop: " + shop);
    }
    public static void readSkin() {
    	double skin = 0;
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("INFo");
			skin = sheet.getRow(2).getCell(0).getNumericCellValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("skin: " + skin);
    }
    public static void readCoins() {
    	double coins = 0;
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("INFo");
			coins = sheet.getRow(3).getCell(0).getNumericCellValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("coins: " + coins);
    }
   	
    public static void addLevel() {
    	readLevel();
    	double levels = 0;
    	
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet("INFo");
			levels = sheet.getRow(0).getCell(0).getNumericCellValue();
			sheet.getRow(0).getCell(0).setCellValue(levels + 1);
        	FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
            workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	cellCoins.setCellValue();
    }
    public static void addShop(int skin) {
    	readShop(skin);
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet("INFo");
			sheet.getRow(1).getCell(skin).setCellValue(true);
        	FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
            workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	cellCoins.setCellValue();
    }
    
    public static void changeSkin(int skin) {
    	readSkin();
    	if(skin < 0)
    		skin = 0;
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet("INFo");
			sheet.getRow(2).getCell(0).setCellValue(skin);
        	FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
            workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	cellCoins.setCellValue();
    }
    public static void addCoins() {
    	readCoins();
    	double coins = 0;
    	
		try {
	    	XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet("INFo");
			coins = sheet.getRow(3).getCell(0).getNumericCellValue();
			sheet.getRow(3).getCell(0).setCellValue(coins + 1);
        	FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
            workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	cellCoins.setCellValue();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}