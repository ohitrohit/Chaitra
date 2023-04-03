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
public class ContactInfoPage {

	//declearation
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	

	//initialation
	public ContactInfoPage(WebDriver driver){
	
		PageFactory.initElements(driver, this);
	}


	//utiliasation
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//businessLibary
	/**
	 * this method help us to get contact page header Text
	 * @return
	 */
	public String getContactPageHeaderText() {
		return ContactHeaderText.getText();
	}
	
}
