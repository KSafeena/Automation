package UOM;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class main_class {
	WebDriver driver;
	
	String randomUOM = generateRandomString(6);
	String randomcon = generateRandomString(6);
	String ran_state=generateRandomString(6);
	String rancity=generateRandomString(6);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
	main_class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"username\"]")WebElement user_name;
	@FindBy(xpath = "//input[@id=\"password\"]")WebElement psw;
	@FindBy(xpath = "//button[@id=\"login\"]")WebElement login;
	@FindBy(xpath = "//a[@id=\"getUnitPage\"]")WebElement uom;
	@FindBy(xpath = "//button[@id=\"createUnit\"]") WebElement create_uom;
	@FindBy(xpath = "//input[@id=\"unitName\"]")WebElement uom1;
	@FindBy(xpath = "//label[@id=\"unitName-error\"]") WebElement exits_msg;
	@FindBy(xpath = "//button[@id=\"createunit\"]")WebElement add;
	@FindBy(xpath = "//div[@class=\"alert alert-success\"]//strong") WebElement done_msg;
	@FindBy(xpath = "//td[contains(text(),'randomUOM')]")WebElement con_display;
	@FindBy(xpath = "//button[@id=\"cancel\"]") WebElement close;
	@FindBy(xpath = "//a[@id=\"getCountryPage\"]")WebElement country;
	@FindBy(xpath = "//button[@onclick=\"addCountry();\"]") WebElement add_con;
	@FindBy(xpath = "//input[@name=\"countryName\"]") WebElement text_con;
	@FindBy(xpath = "//button[@id=\"save\"]") WebElement save;
	@FindBy(xpath = "//label[@id=\"countryName-error\"]") WebElement con_exist;
	@FindBy(xpath = "//button[@onclick=\"back();\"]")WebElement close1;
	@FindBy(xpath = "//a[@id=\"getStatePage\"]")WebElement state;
	@FindBy(xpath = "//button[@onclick=\"addState();\"]")WebElement add_state;
	@FindBy(xpath = "//button[@onclick=\"back();\"]")WebElement close2;
	@FindBy(xpath = "//select[@id=\"countryId\"]")WebElement country_sel;
	@FindBy(xpath = "//input[@id=\"stateName\"]")WebElement state_txt;
	@FindBy(xpath = "//label[@for=\"stateName\"]")WebElement state_err;
	@FindBy(xpath = "//a[@id=\"getCityPage\"]")WebElement city;
	@FindBy(xpath = "//button[@onclick=\"addCity();\"]") WebElement city_add;
	@FindBy(xpath = "//select[@name=\"stateId\"]")WebElement state_sel;
	@FindBy(xpath = "//input[@name=\"cityName\"]")WebElement city_txt;
	@FindBy(xpath = "//label[@id=\"cityName-error\"]")WebElement city_err;
	@FindBy(xpath = "//button[@id=\"backId\"]")WebElement close3;

	void login()
	{
		user_name.sendKeys("subadmin@bob.com");
		psw.sendKeys("Bob@1234");
		login.click();
	}
	void uom()
	{
		uom.click();
		create_uom.click();
		uom1.sendKeys("grms");
		add.click();
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		String message=exits_msg.getText();
		if (message.equals("UOM Name Already Exist."))
		{
			
			uom1.clear();
			uom1.sendKeys(randomUOM);
			System.out.println("Entered random UOM: " + randomUOM);
			add.click();
		}
		String success=done_msg.getText();
		Assert.assertEquals(success, "Done!");
	    System.out.println("Validation Successfull");
	    String dynamicXpath = "//td[contains(text(),'" + randomUOM + "')]";
		WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
	    Boolean status=con_display.isDisplayed();
	    System.out.println("The Uom is diplayed   "+status);
	    close.click();
	}
	void country()
	{
	    country.click();
	    add_con.click();
	    text_con.sendKeys("India");
	    save.click();
	    try
	    {
	    	Thread.sleep(10);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	   String cnt_exist= con_exist.getText();
	   if(cnt_exist.equals("Country Already Exist."))
	   {
		   
			text_con.clear();
			text_con.sendKeys(randomcon);
			System.out.println("Entered random cntry: " + randomcon);
			save.click();
	   }
	   String success=done_msg.getText();
	   Assert.assertEquals(success, "Done!");
	    System.out.println("Validation Successfull");
	    String dynamicXpath = "//td[contains(text(),'" + randomcon + "')]";
		WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
	    Boolean status=con_display.isDisplayed();
	    System.out.println("The country is diplayed   "+status);
	    close1.click();
	}
	void state()
	{
		wait.until(ExpectedConditions.visibilityOf(state));
	    state.click();
	    add_state.click();
	    Select options=new Select(country_sel);
	    List<WebElement> op=options.getOptions();
	    for(int i=0;i<op.size();i++)
	    {
	    	String country=op.get(i).getText();
	    	if(country.equals("India"))
	    	{
	    		op.get(i).click();
	    		System.out.println("The selected country is:"+op.get(i).getText());
	    	}
	    }
	    state_txt.sendKeys("Karnataka");
	    save.click();
	    try
	    {
	    	Thread.sleep(50);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	    String err=state_err.getText();
	    if(err.equals("State Already Exist."))
	    {
	    	
	    	state_txt.clear();
	    	state_txt.sendKeys(ran_state);
	    	save.click();
	    }
	    String success=done_msg.getText();
		   Assert.assertEquals(success, "Done!");
		    System.out.println("Validation Successfull");
		    String dynamicXpath = "//td[contains(text(),'" + ran_state + "')]";
			WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
		    Boolean status=con_display.isDisplayed();
		    System.out.println("The state is diplayed   "+status);
		    close2.click();    
	}
	void city()
	{
		city.click();
		city_add.click();
		Select options=new Select(country_sel);
	    List<WebElement> op=options.getOptions();
	    for(int i=0;i<op.size();i++)
	    {
	    	String country=op.get(i).getText();
	    	if(country.equals("India"))
	    	{
	    		op.get(i).click();
	    		System.out.println("The selected country is:"+op.get(i).getText());
	    	}
	    }
	    Select options_state=new Select(state_sel);
	    List<WebElement> op1=options_state.getOptions();
	    for(int i=0;i<op1.size();i++)
	    {
	    	String state=op1.get(i).getText();
	    	if(state.equals("Karnataka"))
	    	{
	    		op1.get(i).click();
	    		System.out.println("The selected country is:"+op1.get(i).getText());
	    	}
	    }
	    city_txt.sendKeys("Banglore");
	    save.click();
	    try
	    {
	    	Thread.sleep(10);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	   String err= city_err.getText();
	   if(err.equals("City Already Exist."))
	   {
		   
		   city_txt.clear();
		   city_txt.sendKeys(rancity);
		   save.click();
	   }
	   String success=done_msg.getText();
	   Assert.assertEquals(success, "Done!");
	    System.out.println("Validation Successfull");
	    String dynamicXpath = "//td[contains(text(),'" + rancity + "')]";
		WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
	    Boolean status=con_display.isDisplayed();
	    System.out.println("The city is diplayed   "+status);
	    close3.click();   
	    
	}
	private String generateRandomString(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}

	

}
