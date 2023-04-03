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
public class ContactsPage {

	//declearation
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateNewContactLookUpIcon;
	
	//initialation
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilisation
	public WebElement getCreateNewContactLookUpIcon() {
		return CreateNewContactLookUpIcon;
	}
	
	//bussiness liberary
	/**
	 * this methods help us to click action on create new look up icon
	 */
	public void clickOnCreateNewContactIcon() {
		CreateNewContactLookUpIcon.click();
	}
	
	
	
	
	
	
	
	
	
	
}
