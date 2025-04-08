package Auction;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class test_class {
	WebDriver driver;
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();

	    // ✅ Disable password manager & credential service
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);

	    // ✅ Disable Chrome security checks that show 'change your password' popup
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--no-default-browser-check");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-save-password-bubble");

	    // ✅ Use incognito to avoid Chrome remembering old sessions
	    options.addArguments("--incognito");

	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.get("https://training1.effigo.in/upeg/");
	}
	@Test(priority=1)
	void user_login()
	{
		English_auction obj=new English_auction( driver);
		obj.login();
	}
	@Test(priority=2)
	void inviting_vendor() throws InterruptedException
	{
		English_auction obj=new English_auction( driver);
		obj.inviting_vendors();	
		Thread.sleep(50);
	}
	@Test(priority=3)
	void company_details()
	{
		English_auction obj=new English_auction( driver);
		obj.company_details();	
	}
	@Test(priority=4)
	void adress()
	{
		English_auction obj=new English_auction( driver);
		obj.address();
	}
	@Test(priority=5)
	void contact_info() throws InterruptedException
	{
		English_auction obj=new English_auction( driver);
		obj.contact_info();
		Thread.sleep(5000);
	}
	@Test(priority=6)
	void change_psw() throws InterruptedException
	{
		driver.get("https://training1.effigo.in/admin/");
		driver.manage().window().maximize();
		English_auction obj=new English_auction( driver);
		obj.change_psw();	
		Thread.sleep(50);
	}
	@Test(priority=7)
	void portal_login() throws InterruptedException
	{
		driver.get("https://training1.effigo.in/upeg/");
		driver.manage().window().maximize();
		English_auction obj=new English_auction( driver);
		obj.user_login();
		Thread.sleep(50);
	}
	@AfterClass
	void close()
	{
		driver.close();
	}
}
