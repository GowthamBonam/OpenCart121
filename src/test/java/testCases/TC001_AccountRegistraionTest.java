package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistraionTest extends BaseClass{

	

	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("*******Stating TC001_AccountRegistrationTest***");
		
		try {

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on My Account Link");

		hp.clickRegister();
		logger.info("clicked on My Register Link");

		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toLowerCase());
		regPage.setemail(randomString()+ "@gmail.com"); // Randomly generated email
		regPage.setTelphone(randomNumber());

		
		String password =  randomAlphaNumeric();
		
		
		regPage.setpassword(password);
		regPage.setconfirmpassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		logger.info("Valdating expected Message");
		
		String confmsg = regPage.getConfirmationMsg();
		
		if (confmsg.equals("Your Account Has Been Created!"))
		{
			
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug logs.");
			Assert.assertTrue(false);
		}	
	   }
	 	catch (Exception e) {
			Assert.fail();
		}
		logger.info("****Finished TC-001");
	}
}



		
		
		
		
		
		
		
		
		