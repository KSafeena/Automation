package adding_modules;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class adding_modules {
	WebDriver driver;
	String randominco = generateRandomString(6);
	String randomcost = generateRandomString(6);
	String randomaddress=generateRandomString(6);
	adding_modules(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id=\"username\"]")WebElement user_name;
	@FindBy(xpath = "//input[@id=\"password\"]")WebElement psw;
	@FindBy(xpath = "//button[@id=\"login\"]")WebElement login;
	@FindBy(xpath = "//a[@id=\"getIncoTermsPage\"]")WebElement inco_term;
	@FindBy(xpath = "//a[@id=\"adduser\"]")WebElement add;
	@FindBy(xpath = "//input[@name=\"incoType\"]")WebElement text_inco;
	@FindBy(xpath = "//button[@id=\"addBtn\"]")WebElement add_inco;
	@FindBy(xpath = "//label[@id=\"incoType-error\"]")WebElement err;
	@FindBy(xpath = "//div[@class=\"alert alert-success\"]//strong")WebElement done_msg;
	@FindBy(xpath = "//button[@id=\"closeBtn\"]")WebElement close;
	//cost
	@FindBy(xpath = "//a[@id=\"getCostingAccountPage\"]")WebElement cost;
	@FindBy(xpath = "//button[@onclick=\"getCostingAccountCreatePage();\"]")WebElement add_cost;
	@FindBy(xpath = "//input[@id=\"account\"]") WebElement cost_cntr;
	@FindBy(xpath = "//textarea[@id=\"description\"]") WebElement desc;
	@FindBy(xpath = "//select[@name=\"companyCode\"]")WebElement sel_com;
	@FindBy(xpath = "//option[@value=\"1\"]")WebElement trai;
	@FindBy(xpath = "//select[@name=\"companyId\"]")WebElement coId;
	@FindBy(xpath = "//option[@value=\"11\"]")WebElement therm;
	@FindBy(xpath = "//input[@name=\"plantId\"]")WebElement plantId;
	@FindBy(xpath = "//button[@id=\"addBtn\"]")WebElement addcost;
	@FindBy(xpath = "//label[@id=\"account-error\"]")WebElement accn_err;
	@FindBy(xpath = "//button[@onclick=\"closeCategory();\"]")WebElement close_cost;
	//adress
	@FindBy(xpath = "//a[@id=\"getDeliveryAddressPage\"]")WebElement address;
	@FindBy(xpath = "//button[@id=\"create\"]")WebElement add_add;
	@FindBy(xpath = "//input[@name=\"addressName\"]")WebElement add_name;
	@FindBy(xpath = "//textarea[@name=\"address\"]")WebElement add_des;
	@FindBy(xpath = "//select[@id=\"state\"]")WebElement sel_state;
	@FindBy(xpath = "//option[@value=\"KA\"]")WebElement karn;
	@FindBy(xpath = "//label[@for=\"deliveryAddress\"]")WebElement del_add;
	@FindBy(xpath = "//input[@id=\"gstNumber\"]")WebElement gst;
	@FindBy(xpath = "//button[@id=\"addBtn\"]")WebElement addbu;
	@FindBy(xpath = "//label[@id=\"addressName-error\"]")WebElement error;
	@FindBy(xpath = "//button[@onclick=\"closeCategory();\"]")WebElement clo;
	
	void login()
	{
		user_name.sendKeys("subadmin@bob.com");
		psw.sendKeys("Bob@1234");
		login.click();
	}
	
	void add_inco_terms()
	{
		inco_term.click();
		add.click();
		text_inco.sendKeys("Delivery Duty Paid");
		add_inco.click();
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		String inco_err=err.getText();
		if (inco_err.equals("INCO Type Already Exist."))
		{
			
			text_inco.clear();
			text_inco.sendKeys(randominco);
			System.out.println("Entered random UOM: " + randominco);
			add_inco.click();
			String success=done_msg.getText();
			Assert.assertEquals(success, "Done!");
		    System.out.println("Validation Successfull");
		    String dynamicXpath = "//td[contains(text(),'" + randominco + "')]";
			WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
		    Boolean status=con_display.isDisplayed();
		    System.out.println("The Uom is diplayed   "+status);
		    close.click();
		}
		
		
		
	}
	void add_cost_center()
	{
		cost.click();
		add_cost.click();
		cost_cntr.sendKeys("01");
		desc.sendKeys("Cost center");
		sel_com.click();
		trai.click();
		coId.click();
		therm.click();
		plantId.sendKeys("1");
		addcost.click();
		String cost_err=accn_err.getText();
		
		if (cost_err.equals("Cost Center Number Already Exist."))
		{
			
		 cost_cntr.clear();
		 cost_cntr.sendKeys(randomcost);
			System.out.println("Entered random UOM: " + randomcost);
			addcost.click();
			String success=done_msg.getText();
			Assert.assertEquals(success, "Done!");
		    System.out.println("Validation Successfull");
		    String dynamicXpath = "//td[contains(text(),'" + randomcost + "')]";
			WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
		    Boolean status=con_display.isDisplayed();
		    System.out.println("The Uom is diplayed   "+status);
		    close_cost.click();
		}
		
		
	}
	void add_address()
	{
		address.click();
		add_add.click();
		add_name.sendKeys("attapur");
		add_des.sendKeys("sadfdghjku");
		sel_state.click();
		karn.click();
		del_add.click();
		gst.sendKeys("12345");
		addbu.click();
String error_msg=error.getText();
try {
	Thread.sleep(1000);
} 
catch (InterruptedException e) {
	System.out.println(e.getMessage());
}
		
		if (error_msg.equals("Address Name already exist"))
		{
			
		 add_name.clear();
		 add_name.sendKeys(randomaddress);
			System.out.println("Entered random UOM: " + randomaddress);
			addbu.click();
			String success=done_msg.getText();
			Assert.assertEquals(success, "Done!");
		    System.out.println("Validation Successfull");
		    String dynamicXpath = "//td[contains(text(),'" + randomaddress + "')]";
			WebElement con_display = driver.findElement(By.xpath(dynamicXpath));
		    Boolean status=con_display.isDisplayed();
		    System.out.println("The Uom is diplayed   "+status);
		    clo.click();
		}
		
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
