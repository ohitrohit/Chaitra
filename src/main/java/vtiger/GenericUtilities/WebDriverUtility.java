package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class consists of generic methods related to Webdriver actions
 * @author rohit
 *
 */
public class WebDriverUtility {

	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * this methods will wait for the page load
	 * @param driver
	 */
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * this method will wait until the element becomes visible.
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBevisible(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait until the element becomes clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will handle the drop down based on index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element , int index) {
		
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will handle the drop down based on value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element , String value) {
		
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * this method will handle the drop down based on visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text , WebElement element) {
		
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * this method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver , WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * this method will perform right click anywhere in webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform right click on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickActions(WebDriver driver , WebElement element) {
		
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this method will perform double click anywhere on the webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will perform doubleclick on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver , WebElement element) {
		
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * this method will perform drag and drop action
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropAction(WebDriver driver , WebElement srcElement,WebElement dstElement) {
		
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}
	/**
	 * this method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	/**
	 * this methods will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will capture the text from alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		
		return driver.switchTo().alert().getText();
	}
	/**
	 * this method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver , int index) {
		
		driver.switchTo().frame(index);
	}
	/**
	 * this method will handle frame based on name or id  
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver , String nameOrId) {
		
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will handle frame based on a web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver , WebElement element) {
		
		driver.switchTo().frame(element);
	}
	/**
	 * this method will switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will switch the window based on partial window title
	 * @param driver
	 * @param PartialWinTitle
	 */
	public void switchToWindow(WebDriver driver , String PartialWinTitle) {
		
		//step1 Capture all the window ids
		Set<String> winIDs = driver.getWindowHandles();
		
		// step2 Navigate to each window
		for(String win:winIDs) {
			//step3 : switch to window and capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
		
			//step4 :compare the title with required partial title
			if(winTitle.contains(PartialWinTitle)) {
				break;
			}
		
		}
	}
	/**
	 * this method will take screen shot and save it in folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver , String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File (".\\ScreenShots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath(); //used for extentreports
	}
	
	/**
	 * this method will perform random scroll downwards vertically
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	/**
	 * this method will scroll until the element is identified in DOM
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver , WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
	
	
	
	
	
	
	
	
	
	
}
