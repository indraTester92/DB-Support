package testcases_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	ReadConfig readconfig = new ReadConfig();
	String URL = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();
	String implicitWait = readconfig.getImplicitWait();
	
	
	static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		switch(browser.toLowerCase()){
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((Integer.parseInt(implicitWait))));
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}
}
