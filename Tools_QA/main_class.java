package Tools_QA;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class main_class {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
	main_class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@id=\"rightClickBtn\"]") WebElement right_btn;
	@FindBy(xpath = "//p[@id=\"rightClickMessage\"]") WebElement msg;	
	@FindBy(xpath = "(//div[@class=\"avatar mx-auto white\"])[1]")WebElement ele;
	@FindBy(xpath = "(//div[@class=\"header-text\"]//span[1])[1]")WebElement drop;
	@FindBy(xpath = "(//ul[@class=\"menu-list\"]//li[5])[1]")WebElement btn;
	@FindBy(xpath = "(//span[@class=\"pr-1\"])[3]")WebElement frame;
	@FindBy(xpath = "(//ul[@class=\"menu-list\"]//li[3])[2]")WebElement frame_click;
	@FindBy(xpath = "//div[@id=\"frame1Wrapper\"]//iframe")WebElement iframe1;
	@FindBy(xpath = "//div[@id=\"frame2Wrapper\"]//iframe")WebElement iframe2;
	@FindBy(xpath = "(//ul[@class=\"menu-list\"]//li[9])[1]")WebElement dyn;
	@FindBy(xpath = "//button[@id=\"visibleAfter\"]")WebElement dyn_btn;
	@FindBy(xpath = "//button[@id=\"colorChange\"]")WebElement ref_btn;	
	@FindBy(xpath = "//h1[@id=\"sampleHeading\"]") WebElement text;
	@FindBy(xpath = "//div[@class=\"accordion\"]//div[4]") WebElement widges;
	@FindBy(xpath = "(//ul[@class=\"menu-list\"]//li[9])[2]")WebElement menu;
	@FindBy(xpath = "(//div[@class=\" css-1wa3eu0-placeholder\"])[1]") WebElement value;
	@FindBy(xpath = "//div[@id=\"react-select-2-option-2\"]") WebElement op;
	void right_click() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();
		btn.click();
		js.executeScript("arguments[0].scrollIntoView(true);", right_btn);
		Actions ac=new Actions(driver);
		Thread.sleep(50);
		ac.contextClick(right_btn).perform();
		String msg1="You have done a right click";
		String msg2=msg.getText();
	Assert.assertEquals(msg2, msg1);
	System.out.println("Validation sucessfull");
	
	
	}
	void switch_frame()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",frame);
		frame.click();
		frame_click.click();
		driver.switchTo().frame(iframe1);
		System.out.println("The text in the frame 1:"+text.getText());
		System.out.println("Switched to frame 1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframe2);
		System.out.println("The text in the frame 2:"+text.getText());
		System.out.println("Switched to frame 2");
		driver.switchTo().defaultContent();
	}
	void dynamic_web_ele()
	{

		dyn.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ref_btn);
	WebElement btn=	wait.until(ExpectedConditions.visibilityOf(dyn_btn));
Boolean status=	btn.isEnabled();
System.out.println("The btn is enabled: "+status);
btn.click();
		
		
	}
	void mouse_hover()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(ref_btn);
		System.out.println("Mouse Hovered Successfully");
	}
	void dropdown() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",widges);
		widges.click();
		Thread.sleep(500);
		js.executeScript("arguments[0].scrollIntoView(true);",menu);
		menu.click();
		value.click();
		System.out.println("The selected value after click:"+value.getText());
		op.click();
		System.out.println("The updated Selected ele:" +value.getText());
}
	}

