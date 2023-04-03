package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice5thScript {

	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/index.php");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("lodhi2");
	
	driver.findElement(By.xpath("//td[contains(text(),'First Name')]//following::td[9]/img[@src=\"themes/softed/images/select.gif\"]")).click();
	
	String parentId = driver.getWindowHandle();
	Set<String> windowIDs = driver.getWindowHandles();
	for(String id: windowIDs) {
		driver.switchTo().window(id);
	}
	driver.findElement(By.xpath("//a[text()='TCS']")).click();
	driver.switchTo().window(parentId);
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	String header= driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	if(header.contains(header))
		System.out.println("pass");
	else
		System.out.println("fail");
	
	System.out.println(header.contains(header));
	
	WebElement log=driver.findElement(By.xpath("//td[@class=\"small\"]/img[@style='padding: 0px;padding-left:5px']"));
    Actions a = new Actions(driver);
    a.moveToElement(log).perform();
    
    driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
}

	
	
}