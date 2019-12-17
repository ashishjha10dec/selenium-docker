package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePageObject {


	//private By theProduct = By.cssSelector(".item__image-area > img[alt='the Smart Oven®']");
	private By theProduct = By.xpath("//div[@class='item__image-area']");	
	private By noResultsFound = By.xpath("//button[@type='button' and contains(., 'Search again')]");
	//private By theProduct = By.xpath("//*[@id=\"BOV800XL\"]/a");	

			
			
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	/** Execute log in */
	public AddToCartPage clickOnProduct() {
		System.out.println("Click on the Product " + theProduct);
		waitForVisibilityOf(theProduct,90);
		sleep(3000);
		click(theProduct);
		System.out.println("Click on Product Successfull");
		sleep(3000);
		return new AddToCartPage(driver);
	}
	
	/** Verification if logOutButton is visible on the page */
	public boolean isProductVisible() {
		return find(theProduct).isDisplayed();
	}
	
	/** Return text from success message */
	public String getProductsearchResults() {
		return find(noResultsFound).getText();
	}


			
}