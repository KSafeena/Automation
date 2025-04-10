package UOM;
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
	void setup()
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
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.get("https://training1.effigo.in/admin/");
	}
	@Test(priority=1)
	void login()
	{
		main_class obj=new main_class(driver);
		obj.login();
	}
	@Test(priority=2)
	void add_uom()
	{
		main_class obj=new main_class(driver);
		obj.uom();
	}
	@Test(priority=3)
	void country()
	{
		main_class obj=new main_class(driver);
		obj.country();
	}
	@Test(priority=4)
	void state()
	{
		main_class obj=new main_class(driver);
		obj.state();
	}
	@Test(priority=5)
	void city()
	{
		main_class obj=new main_class(driver);
		obj.city();
	}
	@AfterClass
	void close()
	{
		driver.close();
	}
}
