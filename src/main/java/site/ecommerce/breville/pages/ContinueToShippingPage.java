package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContinueToShippingPage extends BasePageObject {
	
	private By continueToShipping  = By.cssSelector(".btn.btn--primary.email-checkout__shipping-btn.js-shipping-btn");
	private By emailAddress = By.xpath("//input[@id='email-address']");
	//private By promotionalInfo = By.cssSelector(".js-promo-msg-label");
	
	public ContinueToShippingPage(WebDriver driver) {
		super(driver);
	}
	
	/** Execute log in */
	public ContinueToPaymentPage clickOnContinueToShipping() {
		System.out.println("Click on clickOnContinueToShipping Button" + continueToShipping);
		waitForVisibilityOf(emailAddress,90);
		sleep(3000);
		type("asishm002@gmail.com", emailAddress);
		//sleep(2000);
		//waitForVisibilityOf(promotionalInfo,60);
		//click(promotionalInfo);
		//sleep(2000);
		waitForVisibilityOf(continueToShipping,90);
		sleep(5000);
		click(continueToShipping);
		//sleep(3000);
		return new ContinueToPaymentPage(driver);
	}

}