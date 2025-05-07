package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

/**
 * Factory class for creating WebDriver instances
 */
public class WebDriverFactory {
    
    /**
     * Creates and returns a WebDriver instance based on the browser name
     * 
     * @param browser the browser to create a driver for
     * @return WebDriver instance
     */
    public static WebDriver createDriver(String browser) {
        WebDriver driver;
        
        switch(browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        
        // Set default timeouts and window size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        return driver;
    }
}
