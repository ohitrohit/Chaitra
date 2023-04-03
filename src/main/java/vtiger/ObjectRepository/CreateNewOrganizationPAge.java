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
public class CreateNewOrganizationPAge extends WebDriverUtility{

	//declearation
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name= "button")
	private WebElement SaveBtn;
	
	@FindBy(name ="industry")
	private WebElement IndustryDropdwn;
	
	//initialisation
	public CreateNewOrganizationPAge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilisation
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getIndustryDropdwn() {
		return IndustryDropdwn;
	}
	//business liberary
	/**
	 * this methods help us to create org 
	 * @param OrgName
	 */
	public void CreateOrganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
		
	}
	
	/**
	 * this methods help us to create org with industry
	 * @param OrgName
	 */
	public void CreateOrganization(String OrgName ,String IndustryType) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropdown(IndustryDropdwn , IndustryType);
		SaveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
