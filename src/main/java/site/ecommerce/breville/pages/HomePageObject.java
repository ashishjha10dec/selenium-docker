package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePageObject extends BasePageObject {
	



	//private String url = "https://uat.breville.com/us/en/home/index.html";
	//private By searchProducts = By.cssSelector(".header--full-height.header__search-icon  .header__icon-text");
	private By searchProducts = By.xpath("//div[@class='wrapper']//header/div[@class='header--full-height']//span[@class='header__search-link-group']/a[1]//span[@class='header__icon-text']");
	private By searchBox = By.cssSelector("input#c-searchbar__search-box");
	private By errorMessageLocator = By.cssSelector(".c-no-result-found.js-no-result-found.o-section  h2");

	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	/** Open WelcomePage with it's url */
	public void openPage(String pageUrl) {
		System.out.println("Opening page: " + pageUrl);
		openUrl(pageUrl);
		System.out.println("Page opened!");
		//sleep(30000);
	}
	
	/** Open LoginPage by clicking on Form Authentication Link */
	public SearchResultsPage searchProducts(String skuCode) {
		System.out.println("Searching for the Product");
		//sleep(70000);
		waitForVisibilityOf(searchProducts,90);
		click(searchProducts);
		System.out.println("Clicked on the Search box");
		waitForVisibilityOf(searchBox,90);
		System.out.println("Search box appeared");
		type(skuCode, searchBox);
		System.out.println("typed skuCode in the Search box");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(3000);
		return new SearchResultsPage(driver);
	}


	
	/** Open LoginPage by clicking on Form Authentication Link */
	public void searchWrongProducts(String skuCode) {
		System.out.println("Searching for the Product");
		waitForVisibilityOf(searchProducts,90);
		click(searchProducts);
		waitForVisibilityOf(searchBox,90);
		type(skuCode, searchBox);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(3000);
	}
	
	/** Wait for error message to be visible on the page */
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}

	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}


}