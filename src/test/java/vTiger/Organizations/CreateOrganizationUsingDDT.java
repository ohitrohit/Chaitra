package vTiger.Organizations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationUsingDDT {

	public static void main(String[] args) throws IOException {
		
		Random r = new Random();
		int random = r.nextInt(1000);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream  fie =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fie);	
		String ORGNAME = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+random;
		
		WebDriver driver = null ;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		else{
			System.out.println("invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.name("button")).click();
		
		String status=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(status.contains(status))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		WebElement log=driver.findElement(By.xpath("//td[@class=\"small\"]/img[@style='padding: 0px;padding-left:5px']"));
	    Actions a = new Actions(driver);
	    a.moveToElement(log).perform();
	    
	    driver.findElement(By.linkText("Sign Out")).click();
	    driver.quit();
		
	}

	
}
