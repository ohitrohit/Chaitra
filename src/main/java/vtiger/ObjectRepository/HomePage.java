package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

/**
 * 
 * @author rohit
 *
 */
public class HomePage extends WebDriverUtility {
    
	/**
	 * Declearartion
	 */
	@FindBy(xpath= "//td[@class='tabUnSelected']/a[text()='Organizations']")
	private WebElement OrganizationLnk;
	
	@FindBy(xpath= "//a[text()='Contacts']")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministerImageLnk;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutLnk;
	/**
	 * constructor
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    /**
     * Getter methods
     * @return
     */
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getAdministerImageLnk() {
		return AdministerImageLnk;
	}

	public WebElement getSignoutLnk() {
		return SignoutLnk;
	}
	/**
	 * Business liberaries
	 */
	public void clickOnOrganizationLink() {
		OrganizationLnk.click();
	}
	public void clickOnContactsLink() {
		ContactsLnk.click();
	}
	public void clickOnLeadLink() {
		LeadsLnk.click();
	}
	public void clickOnSignoutLink(WebDriver driver) {
		mouseHoverAction(driver, AdministerImageLnk);
		SignoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
