package site.ecommerce.breville;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import site.ecommerce.breville.base.CsvDataProviders;
import site.ecommerce.breville.base.TestUtilities;
import site.ecommerce.breville.pages.AddToCartPage;
import site.ecommerce.breville.pages.CheckoutAsGuestPage;
import site.ecommerce.breville.pages.ContinueToPaymentPage;
import site.ecommerce.breville.pages.ContinueToShippingPage;
import site.ecommerce.breville.pages.GoToCartPage;
import site.ecommerce.breville.pages.HomePageObject;
import site.ecommerce.breville.pages.SearchResultsPage;
import site.ecommerce.breville.pages.SubmitOrderPage;

@SuppressWarnings("unused")
public class PlaceOrders extends TestUtilities {

	static Properties properties;
	// FileInputStream fs;

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void placePositiveOrdersTests(Map<String, String> testData) throws IOException {


		String productNo = testData.get("skuCode");

//		open main page
		HomePageObject homePage = new HomePageObject(driver);
		homePage.openPage(url);

		System.out.println("Product Number is :" + productNo);
		

		
		SearchResultsPage searchResultsPage = homePage.searchProducts(productNo);
		// SearchResultsPage searchResultsPage = homePage.searchProducts(skuCode);

			
		AddToCartPage addToCartPage = searchResultsPage.clickOnProduct();
		
		Assert.assertTrue(addToCartPage.isAddToCartButtonVisible(), "Add To Cart Button is not visible");
		
		

		// Successful log in message
		String expectedSuccessMessage = "Add to Cart";
		String actualSuccessMessage = addToCartPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		GoToCartPage goToCartPage = addToCartPage.clickOnAddToCart();
		CheckoutAsGuestPage checkoutAsGuestPage = goToCartPage.clickOnGoToCart();
		ContinueToShippingPage continueToShipping = checkoutAsGuestPage.clickOnCheckOutAsGuest();
		ContinueToPaymentPage continueToPaymentPage = continueToShipping.clickOnContinueToShipping();
		SubmitOrderPage submitOrderPage = continueToPaymentPage.clickOnContinueToPayment();
		submitOrderPage.clickOnSubmitOrder();
		System.out.println("Test Case has Passed");
	}
	
	
	@Test(priority = 2)
	@Parameters({ "productNumber" })
	public void placeNegativeOrdersTests(String productNumber) throws IOException {

		System.out.println("Product Number is :" + productNumber);
		
//		open main page
		HomePageObject homePage = new HomePageObject(driver);
		homePage.openPage(url);
	
				
		SearchResultsPage searchResultsPage = homePage.searchProducts(productNumber);
		// SearchResultsPage searchResultsPage = homePage.searchProducts(skuCode);

		// Successful log in message
		String expectedMessage = "Search again";
		String actualMessage = searchResultsPage.getProductsearchResults();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"actualSuccessMessage does not contain expectedMessage\nexpectedSuccessMessage: "
						+ expectedMessage + "\nactualSuccessMessage: " + actualMessage);
        System.out.println("You have entered Wrong Product, Please try again");
        System.out.println("Test Case has Passed");
        
        
	}
	
	
	
	
	

}