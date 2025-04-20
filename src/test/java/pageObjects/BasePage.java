package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/*This is reusable concept of all page object files*/
public class BasePage {
	
	//Constructor
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
