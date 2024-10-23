package LoginDemoFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CorrectUserNameCorrectPassword {

    @Test
    public void CorrectUserName() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        //driver.get("https:google.co.in");

        // Locate the username input field and enter "Admin"
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
        usernameInput.sendKeys("Admin");

        // Locate the password input field and enter "admin123"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
        passwordInput.sendKeys("admin123");

        WebElement login = driver.findElement(By.xpath("//*[@type='submit']"));
        login.click();

        /*WebElement searchterm = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchterm.sendKeys("Testing");
        Thread.sleep(2000);*/
        driver.quit();

    }
}
