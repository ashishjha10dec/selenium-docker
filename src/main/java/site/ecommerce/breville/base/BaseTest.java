package site.ecommerce.breville.base;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	// protected Logger log;
	static Properties properties;

	String env = "uat";
	String country = "us";
	String language = "en";
	protected String url = "https://" + env + ".breville.com/" + country + "/" + language + "/home/index.html";

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {

		// BROWSER => chrome / firefox
		// HUB_HOST => localhost / 10.0.1.3 / hostname

		String host = "localhost";
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
			/*
			 * String completeUrl = "http://" + host + ":4444/wd/hub"; this.driver = new
			 * RemoteWebDriver(new URL(completeUrl), dc);
			 * driver.manage().window().maximize();
			 */
		} /*
			 * else {
			 * 
			 * DesiredCapabilities dc1 = DesiredCapabilities.chrome(); String completeUrl =
			 * "http://" + host + ":4444/wd/hub"; this.driver = new RemoteWebDriver(new
			 * URL(completeUrl), dc1); driver.manage().window().fullscreen();
			 * 
			 * }
			 */

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		System.out.println("host is :" + host);
		String completeUrl = "http://" + host + ":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
		driver.manage().window().fullscreen();

		if (System.getProperty("ENVIRONMENT") != null) {
			env = System.getProperty("ENVIRONMENT");
		}
		/*
		 * if (System.getProperty("COUNTRY") != null) { country =
		 * System.getProperty("COUNTRY"); }
		 * 
		 * if (System.getProperty("LANGUAGE") != null) { language =
		 * System.getProperty("LANGUAGE"); }
		 */

	}

	protected void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		System.out.println("Close driver"); // Close browser
		driver.quit();
	}

}
