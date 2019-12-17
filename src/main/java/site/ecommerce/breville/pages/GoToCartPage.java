package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoToCartPage extends BasePageObject {

	private By goToCartButton = By.cssSelector(".cart-modal-button .btn--primary");

	public GoToCartPage(WebDriver driver) {
		super(driver);
	}

	/** Execute log in */
	public CheckoutAsGuestPage clickOnGoToCart() {
		System.out.println("Click on the Add to Cart Button " + goToCartButton);
		waitForVisibilityOf(goToCartButton,90);
		//sleep(3000);
		click(goToCartButton); // driver.findElement(AddToCartButton).click();
		//sleep(2000);
		return new CheckoutAsGuestPage(driver);
	}


}