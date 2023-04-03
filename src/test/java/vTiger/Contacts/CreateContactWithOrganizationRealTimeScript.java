package vTiger.Contacts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPAge;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateContactWithOrganizationRealTimeScript {

	public static void main(String[] args) throws IOException {
		
		    ExcelFileUtility eUtil = new ExcelFileUtility();
		    PropertyFileUtility pUtil = new PropertyFileUtility();
		    WebDriverUtility wUtil = new WebDriverUtility();
		    JavaUtility jUtil = new JavaUtility();
		    
		    String URL=pUtil.readDataFromPropertyFile("url");
		    String BROWSER = pUtil.readDataFromPropertyFile("browser");
		    String USERNAME = pUtil.readDataFromPropertyFile("username");
		    String PASSWORD = pUtil.readDataFromPropertyFile("password");
		    
		    String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
	        String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
	        
	        
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
	        
	        LoginPage lp = new LoginPage(driver);
	        lp.loginToApp(USERNAME, PASSWORD);
	        
	        HomePage hp = new HomePage(driver);
	        hp.clickOnOrganizationLink();
	        
	        OrganizationPage op = new OrganizationPage(driver);
	        op.clickOnCreateNewOrgLookUp();
	        
	        CreateNewOrganizationPAge cnop = new CreateNewOrganizationPAge(driver);
	        cnop.CreateOrganization(ORGNAME);
	        
	        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	        String OrgHeader = oip.getOrgHeader();
	        
	        if(OrgHeader.contains(ORGNAME)) {
	        	System.out.println("ORG CREATED");
	        }else {
	        	System.out.println("NOT CREATED ORG");
	        }
	        
	        hp.clickOnContactsLink();
	        
	        ContactsPage cp = new ContactsPage(driver);
	        cp.clickOnCreateNewContactIcon();
	        
	        CreateNewContactPage cncp = new CreateNewContactPage(driver);
	        cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
	        
	        ContactInfoPage cip = new ContactInfoPage(driver);
	        String getContactHeader = cip.getContactPageHeaderText();
	        
	        if(getContactHeader.contains(LASTNAME)) {
	        	System.out.println("CONTACT CREATED WITH ORG");
	        }else{
	        	System.out.println("CONTACT NOT CREATED");
	        }
	        
	        hp.getSignoutLnk();
	        
	        driver.quit();
	        
	}
}
