package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login(){
		
		logger.info("**** Strating TC_002_LoginTest*****");
			try 
			{
				
		//Homepage 
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
//			My Account
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			Assert.assertTrue(targetPage); //Assert.asserEquals(Target page, true, "Login Failed");
			}
			catch(Exception e) 
			{
				Assert.fail();
			}

			logger.info("********Finished TC_002_LoginTest*****");
	}
}
			
