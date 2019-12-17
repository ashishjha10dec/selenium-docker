package site.ecommerce.breville.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitOrderPage extends BasePageObject {

	private By submitOrder = By.xpath("//input[@id='ccPayment']");
	private By cardHolderName = By.xpath("//input[@id='cardholder-name']");
	private By creditCardNumber = By.xpath("//input[@id='credit-card-number']");
	private By expiryDate = By.xpath("//input[@id='expiration']");
	private By cvv = By.xpath("//input[@id='cvv']");
	private By termsAndConditions = By.xpath("//form[@id='payment-form']/div[@class='js-credit-card']//label[@class='js-tnc-label']");
	private By search_Products = By.xpath("//div[@class='wrapper']//header/div[@class='header--full-height']//span[@class='header__search-link-group']/a[1]//span[@class='header__icon-text']");

	public SubmitOrderPage(WebDriver driver) {
		super(driver);
	}

	/** Execute log in 
	 * @return */
	public  void clickOnSubmitOrder() {
		System.out.println("Click on submitOrder Button" + submitOrder);
		waitForVisibilityOf(cardHolderName,90);
		sleep(2000);
		type("Ashish Kumar", cardHolderName);
	
		driver.switchTo().frame("braintree-hosted-field-number");
		waitForVisibilityOf(creditCardNumber,90);
		//sleep(2000);
		type("4111 1111 1111 1111", creditCardNumber);

		driver.switchTo().defaultContent();
		//sleep(2000);
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		waitForVisibilityOf(expiryDate,90);
		//sleep(2000);
		type("02 / 22", expiryDate);
		//sleep(2000);
		driver.switchTo().defaultContent();
		//sleep(2000);
		driver.switchTo().frame("braintree-hosted-field-cvv");
		waitForVisibilityOf(cvv,90);
		//sleep(2000);
		type("227", cvv);
		//sleep(2000);
		driver.switchTo().defaultContent();
		//sleep(2000);
		waitForVisibilityOf(termsAndConditions,90);
		//sleep(2000);
		click(termsAndConditions);
		//sleep(2000);
		waitForVisibilityOf(submitOrder,90);
		//sleep(2000);
		click(submitOrder);
		//sleep(5000);
		waitForVisibilityOf(search_Products,90);
		

		// return new ContinueToPaymentPage(driver, log);
	}

}