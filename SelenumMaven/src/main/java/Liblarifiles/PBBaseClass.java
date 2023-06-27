package Liblarifiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PBBaseClass {
	
	public WebDriver driver;
	
	public void initializeBrowser() throws IOException {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.GetPFData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

}
