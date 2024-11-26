package DataProviderandParameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Parameters {
	
	WebDriver driver;
	
	@BeforeClass
	@org.testng.annotations.Parameters({"browser"})
	void setup(String br)
	{	
		switch (br) {
		case "chrome": driver = new ChromeDriver(); break; 
		case "safari": driver = new SafariDriver(); break;
		default:
			throw new IllegalArgumentException("Unexpected browser value: " + br);
		}
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}
	
	@Test (priority = 1)
	void testLogo()
	{
		driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();		
	}
	
	@Test
	void testTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	@Test
	void testUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
