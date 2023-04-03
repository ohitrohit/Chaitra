package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rohit
 */
public class LoginPage {

	//rules 1: create a pom class for every web page
	//rules 2: identify the web elment with @FindBy , @FindBys , @FindAll
	
	@FindBy(name = "user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;
	
	//Rule 3: create a constructor to initialise these web elements
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver , this );
	}
	
	//rules 4: Provide getters to acess these element 
	
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}
	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Bussiness Liberary - genric methods specific to current project
	
	/**
	 * this method will login to app with username and password
	 * @param Username
	 * @param Password
	 */
	public void loginToApp(String Username , String Password) {
		UsernameEdt.sendKeys(Username);
		PasswordEdt.sendKeys(Password);
		SubmitBtn.click();
	}
}
