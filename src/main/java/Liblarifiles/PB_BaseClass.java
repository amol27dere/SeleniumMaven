package Liblarifiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PB_BaseClass {
	
	WebDriver driver;

	public void initializeBrowser() throws IOException {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPFData("Url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
}
