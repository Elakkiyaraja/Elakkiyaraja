package com.wal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	public static long IMPLICIT_WAIT_TIME  = 30;
	public static long PAGE_LOAD_WAIT_TIME  = 20;
	public static long THREAD_SLEEP_MIN = 3000;
	public static long THREAD_SLEEP_AVG = 6000;
	public static long THREAD_SLEEP_MAX = 10000;
	public static String SCREENSHOT_PATH = "./ScreenShots/";
	
	public static String PICKUPPAGE_SLIDE0_TEXT_XPATH = "Stretch your tax refund with cool, tech toys. Pickup for free at store as soon as today.";
	

	//Data Provider
	public static Object[][] getTestData(String sheetName) throws IOException{
		
		Object[][] data = null;
		
		try {
			FileInputStream fis =new FileInputStream(new File("./src/main/java/com/wal/testdata/"+sheetName+".xlsx")); 
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//get number of rows
			int rowCount = sheet.getLastRowNum();
			
			//get column count
			int columnCount = sheet.getRow(0).getLastCellNum();
			
			 data = new String[rowCount][columnCount];
			
			for(int i=1; i<=rowCount; i++) {
				try {
				XSSFRow row = sheet.getRow(i);
				 for(int j=0; j<columnCount; j++) {
					try { 
					 String cellValue = "";
					 try {
					  cellValue = row.getCell(j).getStringCellValue();
					 		}
					catch(NullPointerException e) {
						
					}
					data[i-1][j] = cellValue;
					}
					
				 catch(Exception e) {
						e.printStackTrace();
					}
			
				 }
				}
				catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return data;
	}
	
	//Get Screen Shots
	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException
	{
		TakesScreenshot scrn =  ((TakesScreenshot)driver);
		File src = scrn.getScreenshotAs(OutputType.FILE);
		File dst = new File(TestUtil.SCREENSHOT_PATH +System.currentTimeMillis()+".png");
		FileUtils.copyFile(src, dst);
		
	}
}
