package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void sampleTest() {
        // Set the path to the ChromeDriver executable manually
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.amazon.com");

        // Print the page title
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("Page title is: " + driver.getTitle());


        // Close the browser
        driver.quit();
    }
}
