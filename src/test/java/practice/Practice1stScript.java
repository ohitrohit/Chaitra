package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice1stScript {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/index.php");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("lodhi");
	driver.findElement(By.name("button")).click();
		
	String status = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	if(status.contains(status))
		System.out.println("pass");
	else
		System.out.println("fail");
	
	WebElement log=driver.findElement(By.xpath("//td[@class=\"small\"]/img[@style='padding: 0px;padding-left:5px']"));
	
	Actions a = new Actions(driver);
	a.moveToElement(log).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("finish");
	driver.quit();
	
}
}
