package Liblarifiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	
	public static String TestData(int RowId, int Cellid) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream("D:\\Study\\velocity class\\Automation\\Topics\\Selenium3_Frameworks\\DDF\\DDF_testData.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(RowId).getCell(Cellid).getStringCellValue();
		return value;
	
	}
	
	public static void CaptureSS(WebDriver driver , int TCID) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Dest= new File("D:\\Study\\velocity class\\Automation\\Topics\\Selenium3_Frameworks\\TestNg_ProposeriesFile\\TestCases"+TCID+".jpg");
		
		FileHandler.copy(src, Dest);
	}
	
	public static String GetPFData(String Key) throws IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\Amol\\git\\selenium_prac\\Selenium_prac\\src\\POM_DDF_TestNG_BaseClass_UtilityClass_CaptureSSOfFailedTCes_PropertyFile\\PRO1.properties");
		Properties p= new Properties();
		p.load(file);
		 String value = p.getProperty(Key);
		 
		 return value; 
		
	}

}
