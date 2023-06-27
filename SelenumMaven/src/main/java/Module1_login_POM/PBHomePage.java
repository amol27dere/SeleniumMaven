package Module1_login_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage {

	@FindBy (xpath="//div[text()='My Account']") private WebElement Myacc;
	
	@FindBy (xpath="//span[text()=' My profile ']") private WebElement MyProfile;
	
	WebDriver driver1;
	
	public PBHomePage (WebDriver driver){
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void ShowAllOptionsMyAcc() {
		
		Actions act= new Actions(driver1);
		act.moveToElement(Myacc).perform();
	}
	
	public void ClickOnPBHomePageMyProfile() {
		MyProfile.click();
	}
	
	
	
}
