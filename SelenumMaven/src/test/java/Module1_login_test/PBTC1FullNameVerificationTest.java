package Module1_login_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Liblarifiles.PBBaseClass;
import Liblarifiles.UtilityClass;
import Module1_login_POM.PBHomePage;
import Module1_login_POM.PBMobNumPage;
import Module1_login_POM.PBPasswordPage;
import Module1_login_POM.PBSignInPage;
import Module1_login_POM.ProfilePage;
import dev.failsafe.internal.util.Assert;

public class PBTC1FullNameVerificationTest extends PBBaseClass {
	PBSignInPage signin;
	PBMobNumPage mob;
	PBPasswordPage pwd;
	PBHomePage home;
	ProfilePage profile;
	int TCID;

	
	@BeforeClass
	public void InvokBrowser() throws InterruptedException, IOException {
		InvokBrowser();
		
		
		
		signin= new PBSignInPage(driver);
		 mob= new PBMobNumPage(driver);
		 pwd= new PBPasswordPage(driver);
		 home= new PBHomePage(driver);
		 profile= new ProfilePage(driver);
		
	}
	@BeforeMethod
	public void LoginToApp() throws EncryptedDocumentException, IOException, InterruptedException {
	
		System.out.println("driver = "+driver);
		signin.ClickOnPBSignInPageSigninBtn();
		mob.EnterPBMobNumPageMobFeild(UtilityClass.GetPFData("MobNo"));
		mob.ClickOnPBMobNumPageSigninwithPasswordBtn();
		pwd.EnterPBPasswordPagepassFeild(UtilityClass.GetPFData("Password"));
		pwd.ClickOnPBPasswordPageSigninBTN();
		Thread.sleep(2000);
		home.ShowAllOptionsMyAcc();
		home.ClickOnPBHomePageMyProfile();
		profile.MoveToProfilePage();
	}
	@Test
	public void VerifyFullname() throws EncryptedDocumentException, IOException {
		 TCID=101;
		 String acttext = profile.GetProfilePagefullname();
		 String exptext = UtilityClass.TestData(1, 2);
		 
		 org.testng.Assert.assertEquals(acttext, exptext,"Failed : both are diff");
		// Assert.assertEquals(acttext, exptext,"Failed : both are diff");
		
	}
	@AfterMethod
	public void LogoutfromApp(ITestResult s1) throws IOException {
		if (s1.getStatus()==ITestResult.FAILURE) {
			
			UtilityClass.CaptureSS(driver, TCID);
			
		}
		
		
	}
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
