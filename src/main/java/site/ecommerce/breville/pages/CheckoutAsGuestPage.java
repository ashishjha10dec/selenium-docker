package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutAsGuestPage extends BasePageObject{
	
	private By checkoutAsGuest = By.cssSelector(".btn.btn--primary.js-checkout-btn");

	public CheckoutAsGuestPage(WebDriver driver) {
		super(driver);
	}

	/** Execute log in */
	public ContinueToShippingPage clickOnCheckOutAsGuest() {
		System.out.println("Click on checkoutAsGuest Button" + checkoutAsGuest);
		waitForVisibilityOf(checkoutAsGuest,90);
		//sleep(3000);
		click(checkoutAsGuest);
		//sleep(5000);
		return new ContinueToShippingPage(driver);
	}

}