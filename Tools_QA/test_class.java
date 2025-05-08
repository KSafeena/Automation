package Tools_QA;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class test_class {
	WebDriver driver;
	@BeforeClass
	void open()
	{
		driver=new ChromeDriver();
		driver.get(" https://demoqa.com/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	
	}
	@Test(priority=1)
	void test1() throws InterruptedException
	{
		main_class obj=new main_class( driver);
		obj.right_click(); 
		Thread.sleep(50);
		
	}
	@Test(priority=5)
	void test2()
	{
		main_class obj=new main_class( driver);
		obj.switch_frame();
		
	}
	@Test(priority=3)
	void test3()
	{
		main_class obj=new main_class( driver);
		obj.dynamic_web_ele();
	}
	@Test(priority=4)
	void test4()
	{
		main_class obj=new main_class( driver);
		obj.mouse_hover();
	}
	@Test(priority=6)
	void test5() throws InterruptedException
	{
		main_class obj=new main_class( driver);
		obj.dropdown();
		Thread.sleep(50);
	}
	@AfterClass
	void close()
	{
		driver.close();
	}

}
