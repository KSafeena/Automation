package Vendor_invitation;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class test_class {
	WebDriver driver;
	@BeforeClass
	void set_up()
	{
		WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--no-default-browser-check");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--incognito");
	    driver = new ChromeDriver(options);
		driver.get("https://training1.effigo.in/portal/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));		
	}
	@Test(priority=1)
	void login()
	{
		main_class mn=new main_class(driver);
		mn.login();
		
	}
	@Test(priority=2)
	void fill_details()
	{
		main_class mn=new main_class(driver);
		mn.info();
	}
	@Test(priority=3)
	void key_contact()
	{
		main_class mn=new main_class(driver);
		mn.key_contact();
	}
	@Test(priority=4)
	void dec_names()
	{
		main_class mn=new main_class(driver);
		mn.dec_names();
	}
	@Test(priority=5)
	void financial_info() throws InterruptedException
	{
		main_class mn=new main_class(driver);
		mn.financial_info();
		Thread.sleep(2000);
	}
	
	@AfterClass
	void close()
	{
		driver.close();
	}

}
