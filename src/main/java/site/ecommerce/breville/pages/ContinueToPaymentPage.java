package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContinueToPaymentPage extends BasePageObject {
	
	private By continueToPayment   = By.cssSelector(".btn.btn--block.btn--primary.js-submit-btn");
	private By firstNameShipping    = By.xpath("//input[@id='firstName_shipping']"); 
	private By lastNameShipping    = By.xpath("//input[@id='lastName_shipping']");
	private By address1Shipping    = By.xpath("//input[@id='streetAddress1_shipping']");
	private By address2Shipping    = By.xpath("//input[@id='aptSuiteLabel_shipping']");
	private By cityTownShipping    = By.xpath("//input[@id='city_shipping']");
	private By zipCodeShipping    = By.xpath("//input[@id='zipCode_shipping']");
	private By stateShipping    = By.xpath("//select[@id='state_shipping']");
	private By phoneNumberShipping    = By.xpath("//input[@id='phoneNumber_shipping']");

	public ContinueToPaymentPage(WebDriver driver) {
		super(driver);
	}
	
	/** Execute log in */
	public SubmitOrderPage clickOnContinueToPayment() {
		System.out.println("Click on continueToPayment Button" + continueToPayment);
		type("Ashish", firstNameShipping);
		type("Kumar", lastNameShipping);
		type("Testing12345", address1Shipping);
		type("Sunnyvale", address2Shipping);
		type("Sunnyvale", cityTownShipping);
		type("94089", zipCodeShipping);
		type("California", stateShipping);
		type("1212456824", phoneNumberShipping);
		//sleep(3000);
		waitForVisibilityOf(continueToPayment,90);
		click(continueToPayment);
		//sleep(3000);

		return new SubmitOrderPage(driver);
	}

}