package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstScriptUsingDDT {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p1 = new Properties();
		p1.load(fis);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p1.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(p1.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(p1.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet s1 = wb.getSheet("Contacts");
		Row r1 = s1.getRow(1);
		Cell c1 = r1.getCell(2);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(c1.getStringCellValue());
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
