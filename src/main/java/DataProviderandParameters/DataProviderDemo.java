package DataProviderandParameters;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.WebDriverFactory;

public class DataProviderDemo {
	
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(DataProviderDemo.class);
	
	// Locators
	private final By emailField = By.xpath("//input[@id='input-email']");
	private final By passwordField = By.xpath("//input[@id='input-password']");
	private final By loginButton = By.xpath("//input[@value='Login']");
	private final By accountHeader = By.xpath("//h2[normalize-space()='My Account']");
	private final By logoutLink = By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
	
	@BeforeClass
	void setup() {
		logger.info("Setting up WebDriver");
		driver = WebDriverFactory.createDriver("chrome");
	}
	
	@Test(dataProvider = "dp")
	void testLogin(String email, String password) {
		logger.info("Testing login with email: {}", email);
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		
		// Use explicit wait instead of Thread.sleep
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		
		try {
			boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(accountHeader)).isDisplayed();
			if (status) {
				logger.info("Login successful for user: {}", email);
				wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			logger.error("Login failed for user: {}", email);
			Assert.fail("Login failed for user: " + email);
		}
	}
	
	@DataProvider(name = "dp")
	Object[][] loginData() {
		return new Object[][] {
			{"kalai21@gmail.com", "test@123"},
			{"kalai21.it@gmail.com", "test@123"},
			{"kalai2121.it@gmail.com", "test@123"},
			{"john.it@gmail.com", "test@123"}
		};
	}
	
	@AfterClass
	void tearDown() {
		if (driver != null) {
			logger.info("Closing WebDriver");
			driver.quit(); // Use quit() instead of close() to ensure all browser windows are closed
		}
	}
}
