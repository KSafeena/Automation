package Vendor_invitation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
public class main_class {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	main_class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id=\"userNameId\"]") WebElement name;
	@FindBy(xpath = "//input[@id=\"passwordId\"]")WebElement psw;
	@FindBy(xpath = "//input[@id=\"sighInId\"]") WebElement login;
	@FindBy(xpath = "//div[@id=\"side-wrapper\"]//ul//li[12]//a") WebElement company_info;
	@FindBy(xpath = "//a[@id=\"BusinessDetails-tab\"]") WebElement bussiness_tab;
	@FindBy(xpath = "//a[@id=\"addBDID\"]")WebElement edit;
	@FindBy(xpath = "//textarea[@name=\"corresAddress\"]")WebElement address;
	@FindBy(xpath = "//select[@name=\"corresCountry\"]")WebElement country;
	@FindBy(xpath = "//select[@id=\"corresState\"]")WebElement state;
	@FindBy(xpath = "//input[@name=\"corresCity\"]")WebElement city;
	@FindBy(xpath = "//input[@name=\"corrpostalCode\"]")WebElement pin;
	@FindBy(xpath = "//input[@id=\"sameRegAddress11\"]")WebElement same_address;
	@FindBy(xpath = "//input[@id=\"VendorPocName\"]")WebElement vendor_name;
	@FindBy(xpath = "//input[@id=\"VendorPocDesignation\"]")WebElement designation;
	@FindBy(xpath = "//input[@id=\"VendorPocPhoneNo\"]")WebElement ph;
	@FindBy(xpath = "//input[@id=\"VendorPocEmail\"]")WebElement email;
	@FindBy(xpath = "//button[@onclick=\"updateAddressDetails()\"]")WebElement update;
	@FindBy(xpath = "//a[@id=\"addManagementID\"]")WebElement add2;
	@FindBy(xpath = "//select[@name=\"keyContactType\"]")WebElement contact_type;
	@FindBy(xpath = "//input[@name=\"contactName\"]")WebElement cont_name;
	@FindBy(xpath = "//input[@name=\"contactDesignation\"]") WebElement cont_designation;
	@FindBy(xpath = "//input[@id=\"contactPanNo\"]")WebElement cont_pan;
	@FindBy(xpath = "//input[@id=\"contactPhoneNo\"]")WebElement cont_ph;
	@FindBy(xpath = "//input[@id=\"contactEmail\"]")WebElement con_email;
	@FindBy(xpath = "//button[@id=\"mangContact-update\"]")WebElement save;
	@FindBy(xpath = "//a[@id=\"addVendorEntityID\"]")WebElement dec_names;
	@FindBy(xpath = "//input[@id=\"anyOtherEntities2\"]")WebElement relations_no;
	@FindBy(xpath = "//button[@id=\"thermxRelation-save\"]")WebElement save_rel;
	@FindBy(xpath = "//a[@id=\"FinancialInfo-tab\"]")WebElement financial;
	@FindBy(xpath = "//a[@id=\"addFDID\"]")WebElement fin_add;
	@FindBy(xpath = "//input[@name=\"bankName\"]") WebElement bank_name;
	@FindBy(xpath = "//input[@name=\"branch\"]") WebElement branch_name;
	@FindBy(xpath = "//input[@id=\"acountNumber\"]")WebElement acc_no;
	@FindBy(xpath = "(//input[@name=\"ifsc\"])[2]") WebElement ifsc;
	@FindBy(xpath = "(//img[@src=\"vendor-images/delete.png\"])[2]")WebElement delete;
//	@FindBy(xpath = "//input[@id=\"fileDocument_8\"]")WebElement upload;
	@FindBy(xpath = "//button[@id=\"registration_document_upload_button_8\"]") WebElement start_upload;
	@FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary updateFinacialButton\"]")WebElement update1;
	@FindBy(xpath = "//a[@id=\"addATID\"]")WebElement add;
	@FindBy(xpath = "//select[@name=\"currencySU\"]")WebElement currency;
	@FindBy(xpath = "//textarea[@name=\"projectDetails\"]")WebElement pro_text;
	@FindBy(xpath = "//textarea[@name=\"ongingLitigation\"]")WebElement on_text;
	@FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary saveAnualButton\"]")WebElement save1;
	void login()
	{
		name.sendKeys("Rahul");
		psw.sendKeys("Bob@1234");
		login.click();
		driver.switchTo().alert().accept();
	}
	void info()
	{
		company_info.click();
		bussiness_tab.click();
		edit.click();
		address.clear();
		address.sendKeys("HSR Layout Banglore");
		Select options=new Select(country);
		List<WebElement> op=options.getOptions();
		for(int i=0;i<op.size();i++)
		{
			if(op.get(i).getText().equals("India"))
			{
				op.get(i).click();
				System.out.println("The selected country is:"+op.get(i).getText());
			}
		}
		Select options1=new Select(state);
		List<WebElement> op1=options1.getOptions();
		for(int i=0;i<op1.size();i++)
		{
			if(op1.get(i).getText().equals("India"))
			{
				op1.get(i).click();
				System.out.println("The selected State is:"+op1.get(i).getText());
			}
		}
		city.clear();
		city.sendKeys("Banglore");
		pin.clear();
		pin.sendKeys("583212");
		same_address.click();
		vendor_name.clear();
		vendor_name.sendKeys("John");
		designation.clear();
		designation.sendKeys("Tester");
		ph.clear();
		ph.sendKeys("1234567890");
		email.clear();
		email.sendKeys("John@gmail.com");
		update.click();
		driver.switchTo().alert().accept();
	}
		void key_contact()
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			wait.until(ExpectedConditions.visibilityOf(add2));
			add2.click();
			Select options1=new Select(contact_type);
			List<WebElement> op1=options1.getOptions();
			for(int i=0;i<op1.size();i++)
			{
				if(op1.get(i).getText().equals("keyAccount_Manager"))
				{
					op1.get(i).click();
					System.out.println("The selected State is:"+op1.get(i).getText());
				}
			}
			cont_name.clear();
			cont_name.sendKeys("John");
			cont_designation.clear();
			cont_designation.sendKeys("Tester");
			cont_pan.clear();
			cont_pan.sendKeys("AAAPA1234A");
			cont_ph.clear();
			cont_ph.sendKeys("1234567890");
			con_email.clear();
			con_email.sendKeys("john@gmail.com");
			save.click();
			driver.switchTo().alert().accept();
			
		}
		void dec_names()
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", dec_names);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			wait.until(ExpectedConditions.visibilityOf(dec_names));
			dec_names.click();
			relations_no.click();
			save_rel.click();
			driver.switchTo().alert().accept();
			
		}
		void financial_info() throws InterruptedException
		{
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			wait.until(ExpectedConditions.visibilityOf(financial));
			financial.click();
			Thread.sleep(2000);
			fin_add.click();
			Thread.sleep(2000);
			bank_name.clear();
			bank_name.sendKeys("State Bank Of India");
			Thread.sleep(2000);
			branch_name.clear();
			branch_name.sendKeys("Banglore");
			Thread.sleep(2000);
			acc_no.clear();
			acc_no.sendKeys("12345678990");
			Thread.sleep(2000);
			ifsc.clear();
			ifsc.sendKeys("SBIN0000813");
	
			delete.click();
			System.out.println("Clicked delete. Waiting for upload input to be re-rendered...");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for file input to be present in DOM
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileDocument_8")));

			WebElement uploadInput = driver.findElement(By.id("fileDocument_8"));

			// Use JavaScript to make sure it's interactable (even if hidden)
			
			js.executeScript("arguments[0].style.display='block';", uploadInput); // Force show if hidden

			// Now send the file
			uploadInput.sendKeys("C:\\Users\\REDMI\\Contacts\\Downloads\\Bank declation1.pdf");
			System.out.println("File path sent.");

			// Optional: wait a moment before hitting upload
			Thread.sleep(1000);
			start_upload.click();
			System.out.println("Clicked Start Upload.");


//			update1.click();
//			driver.switchTo().alert().accept();
//			add.click(); 
//			Select options1=new Select(currency);
//			List<WebElement> op1=options1.getOptions();
//			for(int i=0;i<op1.size();i++)
//			{
//				if(op1.get(i).getText().equals("INR"))
//				{
//					op1.get(i).click();
//					System.out.println("The selected State is:"+op1.get(i).getText());
//				}
//			}
//			pro_text.sendKeys("fdghjklm");
//			on_text.sendKeys("sdfghjkl");
//			save1.click();
//			driver.switchTo().alert().accept();
			
			
		}
}
