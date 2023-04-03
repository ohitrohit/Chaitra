package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.DatabaseUtility;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class DemoTestScriptUsingDDTAndGU {

	public static void main(String[] args) throws IOException {
		
	
	//step 1: create object for all utility
	
	DatabaseUtility dbUtil = new DatabaseUtility();
    ExcelFileUtility eUtil = new ExcelFileUtility();
    PropertyFileUtility pUtil = new PropertyFileUtility();
    WebDriverUtility wUtil = new WebDriverUtility();
    JavaUtility jUtil = new JavaUtility();
    
    //step 2: read all necessary data 
    //read data from properties file -common data
   
    String URL=pUtil.readDataFromPropertyFile("url");
    String BROWSER = pUtil.readDataFromPropertyFile("browser");
    String USERNAME = pUtil.readDataFromPropertyFile("username");
    String PASSWORD = pUtil.readDataFromPropertyFile("password");
    
    //read all the data from excel sheet
    
    String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
    
    WebDriver driver = null;
    if(BROWSER.equalsIgnoreCase("chrome")) {
    	WebDriverManager.chromedriver().setup();
    	driver =new ChromeDriver();
    }else if(BROWSER.equalsIgnoreCase("firefox")) {
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
    }else if(BROWSER.equalsIgnoreCase("edge")) {
    	WebDriverManager.edgedriver().setup();
    	driver = new EdgeDriver();
    }else {
    	System.out.println("invalid browser name");
    }
    
    wUtil.maximizeWindow(driver);
    wUtil.waitForPage(driver);
    driver.get(URL);
    
        // Step 3:Login to Application
 		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 		driver.findElement(By.id("submitButton")).click();

 		// Step 4: Click on Organizations link
 		driver.findElement(By.linkText("Organizations")).click();

 		// Step 5: Click on Create Organization look up image
 		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

 		// Step 6: Create Organization with mandatory details
 		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

 		// Step 7: save
 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

 		// Step 8: Validate
 		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 		if (orgHeader.contains(ORGNAME)) {
 			System.out.println(orgHeader + " PASS");
 		} else {
 			System.out.println("FAIL");
 		}

 		// Step 9: Logout of App
 		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 		wUtil.mouseHoverAction(driver, ele);
 		driver.findElement(By.linkText("Sign Out")).click();
 		
 		driver.quit();
 	}    
}
