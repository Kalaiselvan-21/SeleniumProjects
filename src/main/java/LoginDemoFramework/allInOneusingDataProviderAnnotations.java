package LoginDemoFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class allInOneusingDataProviderAnnotations {


   String [][] data = {
        {"Admin","admin123"},
        {"Admin","admin1244"},
        {"admin123","admin123"},
        {"admin1234","admin1234"}
    };

    @DataProvider(name = "logindata")
    public String[][] loginData(){
        return data;
    }

    @Test(dataProvider = "logindata")
    public void allinOne(String uName, String pword) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriveaa  r.chrome.driver","/usr/local/bin/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        //driver.get("https:google.co.in");

        // Locate the username input field and enter "Admin"
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
        usernameInput.sendKeys(uName);

        // Locate the password input field and enter "admin123"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
        passwordInput.sendKeys(pword);

        WebElement login = driver.findElement(By.xpath("//*[@type='submit']"));
        login.click();

        /*WebElement searchterm = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchterm.sendKeys("Testing");
        Thread.sleep(2000);*/
        driver.close();

    }
}
