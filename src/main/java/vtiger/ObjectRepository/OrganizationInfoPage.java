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
public class OrganizationInfoPage {

	//declearation
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//initialation
	public OrganizationInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	//utilisation
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	//business liberary
	/**
	 * this methods use for get header Text
	 * @return
	 */
	public String getOrgHeader() {
		return OrgHeaderText.getText();
	}
	
	
	
	
	
	
	
	
	
}
