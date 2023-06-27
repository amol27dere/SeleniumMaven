package Module1_login_POM;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	@FindBy (xpath="//input[@name='personName']") private WebElement fullname;
	WebDriver driver1;
	
	public ProfilePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		driver1=driver;
		
	}
	
	public void MoveToProfilePage() {
		Set<String> allids = driver1.getWindowHandles();
		
		ArrayList<String> id= new ArrayList<String>(allids);
	
		driver1.switchTo().window(id.get(1));
	}
	
	public String GetProfilePagefullname() {
		String value = fullname.getAttribute("value");
		return value;
	}
	
	
	
}
