package Auction;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class English_auction {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	English_auction(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name=\"login\"]") WebElement username;
	@FindBy(xpath = "//input[@name=\"password\"]") WebElement psw;
	@FindBy(xpath = "//input[@name=\"sighIn\"]") WebElement login;
	@FindBy(xpath = "//div[@class=\"side-nav\"]//ul//li[15]//a") WebElement suppliers;
	@FindBy(xpath = "//a[@href='getSupplierCreationPage']")WebElement vendor_invitation;
	@FindBy(xpath = "//input[@placeholder=\"Enter full name of the company\"]") WebElement company;
	@FindBy(xpath = "//select[@id=\"vendorcompanyRegisterCountry\"]")WebElement RegisterCountry;
	@FindBy(xpath = "//select[@name=\"vendorcompanyRegisterState\"]") WebElement RegisterState;
	@FindBy(xpath = "//button[@id=\"verifyBtn\"]")WebElement verify;
	@FindBy(xpath = "//button[@id=\"verifyBtn1\"]")WebElement create;
	@FindBy(xpath = "//select[@name=\"companyType\"]") WebElement companytype;
	@FindBy(xpath = "//input[@name=\"panNum\"]")WebElement pannum;
	@FindBy(xpath = "//select[@name=\"typeOfVendor\"]")WebElement vendortype;
	@FindBy(xpath = "//input[@id=\"siteName\"]")WebElement sitename;
	@FindBy(xpath = "//textarea[@name=\"regiAddress\"]")WebElement address;
	@FindBy(xpath = "//input[@name=\"city\"]") WebElement city;
	@FindBy(xpath = "//input[@name=\"postalCode\"]")WebElement postalcode;
	@FindBy(xpath = "//input[@name=\"companyEmail\"]")WebElement company_mail;
	@FindBy(xpath = "//input[@name=\"contactPerson\"]")WebElement contact_person;
	@FindBy(xpath="//input[@name=\"contactPersonDesig\"]")WebElement Desig;
	@FindBy(xpath = "//input[@name=\"mobileNum\"]") WebElement contact_no;
	@FindBy(xpath = "//input[@name=\"email\"]") WebElement email;
	@FindBy(xpath = "//input[@name=\"loginuser\"]")WebElement userid;
	@FindBy(xpath = "//div[@class=\"text-right\"]//a[@href=\"#\"]")WebElement submit;
	@FindBy(xpath = "//input[@name=\"login\"]") WebElement ad_username;
	@FindBy(xpath = "//input[@name=\"password\"]") WebElement ad_psw;
	@FindBy(xpath = "//button[@onclick=\"submitLogin();\"]") WebElement ad_login;
	@FindBy(xpath = "//a[@id=\"changePasswordPageForAllusers\"]")WebElement change_psw;
	@FindBy(xpath = "//select[@id=\"roleId\"]") WebElement role;
	@FindBy(xpath = "//form[@action=\"changePasswordPage\"]//input[1]") WebElement name;
	@FindBy(xpath = "//input[@value=\"Search\"]") WebElement search;
	@FindBy(xpath = "//input[@id='password_1']")WebElement psw3;
	@FindBy(xpath = "//div[@class=\"table-responsive\"]//tbody//tr[2]//td[7]//input[1]") WebElement reset;
	@FindBy(xpath = "//input[@placeholder=\"Enter New Password\"]")WebElement psw1;
	@FindBy(xpath = "//input[@name=\"login\"]") WebElement vendor_username;
	@FindBy(xpath = "//input[@name=\"password\"]") WebElement vendor_psw;
	@FindBy(xpath = "//input[@name=\"sighIn\"]") WebElement vendor_login;
	@FindBy(xpath = "//input[@placeholder=\"Old Password\"]")WebElement old_psw;
	@FindBy(xpath = "//input[@placeholder=\"New Password\"]")WebElement new_psw;
	@FindBy(xpath = "//input[@placeholder=\"Confirm Password\"]")WebElement confirm_psw;
	@FindBy(xpath = "//input[@type=\"submit\"]")WebElement submit1;
	@FindBy(xpath = "//input[@name=\"login\"]") WebElement vendor_newusername;
	@FindBy(xpath = "//input[@name=\"password\"]") WebElement vendor_newpsw;
	@FindBy(xpath = "//input[@name=\"sighIn\"]") WebElement vendor_newlogin;
	
	void login()
	{
		username.sendKeys("Rahul");
		psw.sendKeys("Bob@1234");
		login.click();
	}
	void inviting_vendors() throws InterruptedException
	{
		suppliers.click();
		Thread.sleep(50);
		JavascriptExecutor js=(JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView(true);" ,vendor_invitation);
		vendor_invitation.click();
		company.sendKeys("Bindinging");
		Select op=new Select(RegisterCountry);
		List<WebElement> options=op.getOptions();
		for(int i=0;i<options.size();i++)
		{
			if(options.get(i).getText().equals("India"))
			{
				options.get(i).click();
				System.out.println("The option selected is"+options.get(i).getText());
			}
		}
		Select op1=new Select(RegisterState);
		List<WebElement> options_state=op1.getOptions();
		for(int i=0;i<options_state.size();i++)
		{
			if(options_state.get(i).getText().equals("Karnataka"))
			{
				options_state.get(i).click();
				System.out.println("The option selected is"+options_state.get(i).getText());
			}
		}
		verify.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);" ,create);	
		wait.until(ExpectedConditions.elementToBeClickable(create));
		create.click();	
	}
		void company_details()
		{
		Select op2=new Select(companytype);
		List<WebElement> options_type=op2.getOptions();
		for(int i=0;i<options_type.size();i++)
		{
			if(options_type.get(i).getText().equals("Proprietary"))
			{
				options_type.get(i).click();
				System.out.println("The option selected is"+options_type.get(i).getText());
			}
		}
		pannum.sendKeys("ABCDE1234F");
		
		Select op3=new Select(vendortype);
		List<WebElement> options_typevendor=op3.getOptions();
		for(int i=0;i<options_typevendor.size();i++)
		{
			if(options_typevendor.get(i).getText().equals("Manufacturer"))
			{
				options_typevendor.get(i).click();
				System.out.println("The option selected is"+options_typevendor.get(i).getText());
			}
		}
		}
		void address()
		{
		sitename.sendKeys("Banglore");
		address.sendKeys("hsr layout, Banglore");
		city.sendKeys("Banglore");
		postalcode.sendKeys("583212");
		company_mail.sendKeys("rahul@gmail.com");
		}
		void contact_info() throws InterruptedException
		{
			JavascriptExecutor js=(JavascriptExecutor) driver; 
			contact_person.sendKeys("Rahul");
			Desig.sendKeys("Tester");
			contact_no.sendKeys("1234567890");
			email.clear();
			email.sendKeys("rahul@gmail.com");
			userid.sendKeys("Anandi");
			js.executeScript("arguments[0].scrollIntoView(true);" ,submit);	
			wait.until(ExpectedConditions.elementToBeClickable(submit));
			submit.click();	
			Alert al=driver.switchTo().alert();
			al.getText();
			Assert.assertEquals("Do you want to submit vendor invitation ?",al.getText() );
			al.accept();
			System.out.println("Validation passed");
			Thread.sleep(5000);
		}
		void change_psw()
		{
			ad_username.sendKeys("subadmin@bob.com");
			ad_psw.sendKeys("Bob@1234");
			ad_login.click();
			change_psw.click();
			Select op4=new Select(role);
			List<WebElement> options_role=op4.getOptions();
			for(int i=0;i<options_role.size();i++)
			{
				if(options_role.get(i).getText().equals("Suppliers"))
				{
					options_role.get(i).click();
					System.out.println("The option selected is"+options_role.get(i).getText());
				}
			}
			name.sendKeys("rahul");
			search.click();
			psw3.sendKeys("111");
			reset.click();
					
		}
		void vendor_login() throws InterruptedException
		{
			vendor_username.sendKeys("rahul");
			vendor_psw.sendKeys("111");
			vendor_login.click();
			old_psw.sendKeys("111");
			new_psw.sendKeys("Bob@1234");
			confirm_psw.sendKeys("Bob@1234");
			submit1.click();
			vendor_newusername.sendKeys("rahul");
			vendor_newpsw.sendKeys("Bob@1234");
			vendor_newlogin.click();
			Thread.sleep(50);
			driver.switchTo().alert().accept();
		}
}
