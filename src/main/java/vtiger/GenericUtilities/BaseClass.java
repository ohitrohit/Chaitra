package vtiger.GenericUtilities;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotations of TestNG
 * @author rohit
 *
 */
public class BaseClass {

	   public ExcelFileUtility eUtil = new ExcelFileUtility();
	   public PropertyFileUtility pUtil = new PropertyFileUtility();
	   public WebDriverUtility wUtil = new WebDriverUtility();
	   public  JavaUtility jUtil = new JavaUtility();
	   public static WebDriver sDriver;//only for listeners
	   
	   public WebDriver driver;
	    

		@BeforeSuite(groups = {"smokesuite" , "regressionsuite"})
		public void bsConfig()
		{
		   System.out.println("----- Database Connection successfull -----");
		}
		
	//	@Parameters("browser")
	//	@BeforeTest
		@BeforeClass(groups = {"smokesuite" , "regressionsuite"})
		public void bcConfig(/*String BROWSER*/) throws IOException
		{
		 String URL=pUtil.readDataFromPropertyFile("url");
		 String BROWSER = pUtil.readDataFromPropertyFile("browser");	 
			if (BROWSER.equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("----- "+BROWSER+" Launched succesfully-----");
				
			} else if (BROWSER.equalsIgnoreCase("edge")) 
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("----- "+BROWSER+" Launched successfully-----");
			}else if(BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("----- "+BROWSER+" Launched successfully-----");
			}else 
			{
				System.out.println("Invalid Browser name");
			}
			    sDriver=driver;
			    wUtil.maximizeWindow(driver);
		        wUtil.waitForPage(driver);
		        driver.get(URL);
		}
		
		@BeforeMethod(groups = {"smokesuite" , "regressionsuite"})
		public void bmConfig() throws IOException
		{
			   String USERNAME = pUtil.readDataFromPropertyFile("username");
			   String PASSWORD = pUtil.readDataFromPropertyFile("password");
			   LoginPage lp = new LoginPage(driver);
		       lp.loginToApp(USERNAME, PASSWORD);
		       System.out.println("----- Login successful -----");
		}
		
		@AfterMethod(groups = {"smokesuite" , "regressionsuite"})
		public void amConfig()
		{
			 HomePage hp = new HomePage(driver);
			 hp.clickOnSignoutLink(driver);
			 System.out.println("----- Logout successful -----");
		}
		
		@AfterClass(groups = {"smokesuite" , "regressionsuite"})
		public void acConfig()
		{
			driver.quit();
			System.out.println("----- Browser Closed successfully -----");
		}
		
		@AfterSuite(groups = {"smokesuite" , "regressionsuite"})
		public void asConfig()
		{
			System.out.println("----- Database Connection successfull -----");
			
		}
	  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
