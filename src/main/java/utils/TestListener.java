package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TestNG listener for test execution events
 */
public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName());
        
        // Take screenshot on failure
        Object currentClass = result.getInstance();
        WebDriver driver = null;
        
        // Try to get the driver instance from the test class
        try {
            driver = (WebDriver) currentClass.getClass().getDeclaredField("driver").get(currentClass);
        } catch (Exception e) {
            logger.error("Could not capture screenshot: " + e.getMessage());
            return;
        }
        
        if (driver != null) {
            captureScreenshot(driver, result.getName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test suite finished: " + context.getName());
    }
    
    /**
     * Capture screenshot and save to screenshots directory
     * 
     * @param driver WebDriver instance
     * @param testName name of the test
     */
    private void captureScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            
            // Create screenshots directory if it doesn't exist
            File directory = new File("screenshots");
            if (!directory.exists()) {
                directory.mkdir();
            }
            
            // Create unique filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshots/" + testName + "_" + timestamp + ".png";
            
            File destination = new File(fileName);
            FileUtils.copyFile(source, destination);
            
            logger.info("Screenshot saved: " + fileName);
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
