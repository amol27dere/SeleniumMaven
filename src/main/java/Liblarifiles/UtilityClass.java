package Liblarifiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	public static String TestData(int rowindex,int cellindex ) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("D:\\velocity class\\Automation\\Core_java\\.metadata\\SelenumMaven\\TestData\\DDF_testData.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;
	}
	
	public static void CaptureSS( WebDriver driver , int TCID ) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\velocity class\\Automation\\Core_java\\.metadata\\SelenumMaven\\FailedTCScreeShots\\TestCassID"+TCID+".jpg");
		FileHandler.copy(src, dest);
		
	}
	
	public static String getPFData(String Key) throws IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\Amol\\git2\\FrameWork\\FrameWorks\\Pro.properties");
		Properties p= new Properties();
		p.load(file);
		String value = p.getProperty(Key);
		return value;
		
	}
}
