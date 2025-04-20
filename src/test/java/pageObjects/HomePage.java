package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Web Elements
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	

	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginMyaccount; //Login link added in step 5
	
	
	
	//Action Methods
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		loginMyaccount.click();
	}

	
	
	
	
	

}
