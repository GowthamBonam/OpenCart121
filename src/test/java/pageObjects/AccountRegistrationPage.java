package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelphone;
	
	
	

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setemail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setpassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setconfirmpassword(String password) {
		txtconfirmPassword.sendKeys(password);
	}
	
	
	public void setTelphone(String Telphone) {
		txtTelphone.sendKeys(Telphone);
	}
	
	

	
	
	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}

	public void clickContinue() {
		// sol1
		btnContinue.click();

//		//sol2
//		btnContinue.submit();
//		
//		//sol3
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();
//		//input[@id='input-firstname']
//		
//		//sol4
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();",btnContinue);
//		
//		//sol5
//		btnContinue.sendKeys(Keys.RETURN);
//		
//		//sol6
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
//		
	}


	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
