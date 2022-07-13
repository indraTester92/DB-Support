package testcases_Class;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobject_classes.LoginPage;

public class VerifyLoginFunctionality extends BaseClass{

	 LoginPage loginpage;
	 SoftAssert Softassert = new SoftAssert();
	 
	 @Test(priority=1)
	 public void launchUrl() throws InterruptedException {
		 
		 driver.get(URL);
		 Thread.sleep(2000);
	 }

	@Test(priority=2)
	public void writeEmailAddress() {

		loginpage = new LoginPage(BaseClass.driver);
		loginpage.enterEmail("superadmin@gmail.com");

	}

	@Test(priority=3)
	public void writePassword() {

		loginpage = new LoginPage(BaseClass.driver);
		loginpage.enterPassword("12345678");

	}
	
	@Test(priority=4)
	public void clickLoginButton() {

		loginpage = new LoginPage(BaseClass.driver);
		loginpage.clickOnLogin();

	}
	
	@Test(priority=5)
	public void titleVerify() {
		loginpage = new LoginPage(BaseClass.driver);
		String actualTitle = driver.getTitle();
		String expectedTitle ="OPDBSupport Dashboard";
		boolean title = loginpage.verifyTitle(actualTitle,expectedTitle);
		
		if(title == true) {
			
			Softassert.assertTrue(true);
			Softassert.assertAll();
		}
		else {
			
			Softassert.assertTrue(false);
			Softassert.assertAll();
		}
	}
	
	@Test(priority=6)
	public void logOut() {
		
		loginpage = new LoginPage(BaseClass.driver);
		loginpage.clickLogout();
	}
}
