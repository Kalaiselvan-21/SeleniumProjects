package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

/**
 * Page Object for the Account page
 */
public class AccountPage {
    private WebDriver driver;
    
    // Locators
    private By accountHeader = By.xpath("//h2[normalize-space()='My Account']");
    private By logoutLink = By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
    
    // Constructor
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Check if user is logged in by verifying the account header is displayed
     * 
     * @return true if logged in, false otherwise
     */
    public boolean isLoggedIn() {
        try {
            return WaitUtils.waitForElementVisible(driver, accountHeader, 10).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Click the logout link
     */
    public void logout() {
        WaitUtils.waitForElementClickable(driver, logoutLink, 10).click();
    }
}
