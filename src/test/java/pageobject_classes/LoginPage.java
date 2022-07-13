package pageobject_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	public WebElement ClickLogin;
	
	@FindBy(xpath="//ul[@class='navbar-nav ml-auto']/li/a/span[contains(text(),'Super Admin')]")
	public WebElement clickLgoutMenu;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement clikLogout;
	
	
	public void enterEmail(String email_ID) {
		
		email.sendKeys(email_ID);
	}
	
	public void enterPassword(String pswd) {
		
		password.sendKeys(pswd);
	}
	public void clickOnLogin() {
		
		ClickLogin.click();
	}
	
	public boolean verifyTitle(String act_title , String exp_title) {
		
		boolean titleValue = false;
		
		if(act_title.equals(exp_title)) {
			
			titleValue = true; 
		}
		return titleValue;
	}
	
	public void clickLogout() {
		
		clickLgoutMenu.click();
		clikLogout.click();
		
	}
}
