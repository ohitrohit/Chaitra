package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author rohit
 *
 */
public class OrganizationPage {
    
	//Declearation
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateNewOrganizationLookUpIcon;
	
	//inicialisation
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
    //utiliazation
	public WebElement getCreateNewOrganizationLookUpIcon() {
		return CreateNewOrganizationLookUpIcon;
	}
	//BussinessLiberary
	/**
	 * this methods will provide click action on craete new org look up icon
	 */
	public void clickOnCreateNewOrgLookUp() {
		CreateNewOrganizationLookUpIcon.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
