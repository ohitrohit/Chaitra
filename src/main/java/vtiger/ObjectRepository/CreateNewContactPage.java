package vtiger.ObjectRepository;

import org.openqa.selenium.By;
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
public class CreateNewContactPage extends WebDriverUtility{

	//declearartion
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']//following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookUpIcon;
	
	@FindBy(name = "search_text")
	private WebElement SearchBarForOrg;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSaveBtn;
	
	//initiliations
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilisations
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}


	public WebElement getOrgLookUpIcon() {
		return OrgLookUpIcon;
	}


	public WebElement getSearchBarForOrg() {
		return SearchBarForOrg;
	}


	public WebElement getSearchBtn() {
		return SearchBtn;
	}


	public WebElement getClickOnSaveBtn() {
		return ClickOnSaveBtn;
	}
	
	//business Liberary
	/**
	 * this method help to create contact
	 * @param LastName
	 */
	public void CreateNewContact(String LastName ) {
		LastNameEdt.sendKeys(LastName);
		ClickOnSaveBtn.click();
	}
	
	/**
	 * this method help to create contact with organization
	 * @param LastName
	 */
	public void CreateNewContact(WebDriver driver ,String LastName , String OrgName) {
		LastNameEdt.sendKeys(LastName);
		OrgLookUpIcon.click();
		switchToWindow(driver,"Accounts");
		SearchBarForOrg.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		ClickOnSaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
