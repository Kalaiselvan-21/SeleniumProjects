package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Utility class for WebDriver waits
 */
public class WaitUtils {
    
    /**
     * Wait for element to be visible
     * 
     * @param driver WebDriver instance
     * @param locator By locator for the element
     * @param timeoutInSeconds maximum time to wait in seconds
     * @return WebElement once it's visible
     */
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be clickable
     * 
     * @param driver WebDriver instance
     * @param locator By locator for the element
     * @param timeoutInSeconds maximum time to wait in seconds
     * @return WebElement once it's clickable
     */
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Wait for element to be present in DOM
     * 
     * @param driver WebDriver instance
     * @param locator By locator for the element
     * @param timeoutInSeconds maximum time to wait in seconds
     * @return WebElement once it's present
     */
    public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
