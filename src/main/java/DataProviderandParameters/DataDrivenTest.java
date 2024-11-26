package DataProviderandParameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	WebDriver driver;
	
	@DataProvider(name = "loginData")
	public Object[] loginwithDataProvider() throws IOException{
		
		String filepath = "/Users/kalai/Downloads/testdata.xlsx";
		String Sheetname = "Sheet1";
		return readExcelData(filepath, Sheetname);	
	}
	
	public static Object[] readExcelData(String filepath, String Sheetname) throws IOException {
		
		//Declare the variables for file, workbook, sheet
		FileInputStream file = new FileInputStream(filepath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(Sheetname);
		
		
		//Get the number of rows and columns
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();	
		
		//Initialize the data array
		Object[][] data = new Object[rowCount-1][colCount];
		
		// Read the values
		for(int i=1; i<rowCount; i++) {
			Row row = sheet.getRow(i);
		for(int j=0; j<colCount; j++) {
			Cell cell = row.getCell(j);
			data[i-1][j] = getCellValue(cell);		
		}
		}	
		
		workbook.close();
		return data;
		
	}
	
	//Get the cell value based on Cell Type
	private static Object getCellValue(Cell cell) {
		
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return cell.getNumericCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			return null;		
		}
		
	}
	
	@Test(dataProvider = "loginData")
	public void LoginTest(String username, String password) throws InterruptedException {
		
		 	driver = new ChromeDriver();
	        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
	    
	        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
	        usernameInput.sendKeys(username);
	        
	        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
	        passwordInput.sendKeys(password);

	        WebElement login = driver.findElement(By.xpath("//*[@type='submit']"));
	        login.click();
	        
	        driver.close();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
