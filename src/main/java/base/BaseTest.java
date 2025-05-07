package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigManager;
import utils.WebDriverFactory;

/**
 * Base test class that all test classes should extend
 */
public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    
    /**
     * Set up method to initialize WebDriver before test class
     * 
     * @param browser browser to use, defaults to value from config if not provided
     */
    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("") String browser) {
        // If browser parameter is not provided or empty, get from config
        if (browser == null || browser.isEmpty()) {
            browser = ConfigManager.getProperty("default.browser", "chrome");
        }
        
        logger.info("Initializing WebDriver for browser: " + browser);
        driver = WebDriverFactory.createDriver(browser);
    }
    
    /**
     * Tear down method to close WebDriver after test class
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing WebDriver");
            driver.quit();
        }
    }
}
