package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.ObjectRepository.LoginPage;

public class POMClassPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php");
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("admin");
//		lp.getSubmitBtn().click();
	
		lp.loginToApp("admin", "admin");
	}
}
