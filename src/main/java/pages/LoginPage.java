package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

/**
 * Page Object for the Login page
 */
public class LoginPage {
    private WebDriver driver;
    
    // Locators
    private By emailField = By.xpath("//input[@id='input-email']");
    private By passwordField = By.xpath("//input[@id='input-password']");
    private By loginButton = By.xpath("//input[@value='Login']");
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Navigate to login page
     * 
     * @param url the URL of the login page
     * @return LoginPage instance
     */
    public LoginPage navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }
    
    /**
     * Enter email in the email field
     * 
     * @param email email to enter
     * @return LoginPage instance
     */
    public LoginPage enterEmail(String email) {
        WaitUtils.waitForElementVisible(driver, emailField, 10).sendKeys(email);
        return this;
    }
    
    /**
     * Enter password in the password field
     * 
     * @param password password to enter
     * @return LoginPage instance
     */
    public LoginPage enterPassword(String password) {
        WaitUtils.waitForElementVisible(driver, passwordField, 10).sendKeys(password);
        return this;
    }
    
    /**
     * Click the login button
     * 
     * @return AccountPage instance
     */
    public AccountPage clickLogin() {
        WaitUtils.waitForElementClickable(driver, loginButton, 10).click();
        return new AccountPage(driver);
    }
    
    /**
     * Login with email and password
     * 
     * @param email email to use
     * @param password password to use
     * @return AccountPage instance
     */
    public AccountPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLogin();
    }
}
