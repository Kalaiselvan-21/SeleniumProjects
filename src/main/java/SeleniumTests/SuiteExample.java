package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SuiteExample {

    WebDriver driver;

    @BeforeClass
    public void launchBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() throws InterruptedException {
        driver.get("http://www.google.co.in");
       Thread.sleep(2000);
    }

    @Test
    public void openYahoo() throws InterruptedException {
        driver.get("http://www.yahoo.co.in");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
}
