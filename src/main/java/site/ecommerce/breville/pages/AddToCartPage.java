package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePageObject {

	private By addToCartButton = By.cssSelector(".c_product-detail__add-to-cart.js-add-cart-wrapper > .btn.btn--primary.c_product-detail__add-cart-btn.js-addToCartBtn");
	//private By addToCartButton = By.xpath("//div/div[3]/div[1]/div[2]/div[3]/div[9]/button");

	
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	/** Execute log in */
	public GoToCartPage clickOnAddToCart() {
		System.out.println("Click on the Add to Cart Button " + addToCartButton);
		waitForVisibilityOf(addToCartButton,90);
		sleep(4000);
		click(addToCartButton); // driver.findElement(AddToCartButton).click(); 
		return new GoToCartPage(driver);
	}

	/** Verification if logOutButton is visible on the page */
	public boolean isAddToCartButtonVisible() {
		return find(addToCartButton).isDisplayed();
	}

	/** Return text from success message */
	public String getSuccessMessageText() {
		return find(addToCartButton).getText();
	}

}