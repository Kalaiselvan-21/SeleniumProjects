package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import utils.ConfigManager;

/**
 * Test class for login functionality
 */
public class LoginTest extends BaseTest {
    
    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) {
        logger.info("Testing login with email: " + email);
        
        // Get URL from config
        String url = ConfigManager.getProperty("tutorialsninja.url");
        
        // Initialize page objects and perform login
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = loginPage
                .navigateTo(url)
                .login(email, password);
        
        // Verify login was successful
        boolean isLoggedIn = accountPage.isLoggedIn();
        Assert.assertTrue(isLoggedIn, "Login failed for user: " + email);
        
        // Logout if login was successful
        if (isLoggedIn) {
            accountPage.logout();
            logger.info("Successfully logged out");
        }
    }
    
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"kalai21@gmail.com", "test@123"},
            {"kalai21.it@gmail.com", "test@123"},
            {"kalai2121.it@gmail.com", "test@123"},
            {"john.it@gmail.com", "test@123"}
        };
    }
}
