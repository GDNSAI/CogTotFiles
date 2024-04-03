package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneCogniPage {
	public WebDriver driver;
	public static String beHandle, oneCogniHandle;
	
	public OneCogniPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page elements
	By inpSearch = By.id("oneC_searchAutoComplete"); //chrome	
	By searchBtn = By.className("searchTopBar"); //edge
	By inputSearch = By.id("oneCSearchTop"); //edge	
	By btnTruTime = By.xpath("//div[@id = 'newSearchAppsLST']/div[1]/div//div[contains(text(), 'TruTime ')]");
	By txtTruTime = By.linkText("My TruTime");
	
	//Switching window
	public void switchToOneCogniHandle() {
		Set<String> handles = driver.getWindowHandles();	
		for(String handle: handles) {			
			driver.switchTo().window(handle);
			if(driver.getTitle() == "Be.Cognizant - Home") {
				continue;
			} else {
				oneCogniHandle = handle;
			}
			
		}
	}
	
	//click search input in chrome
	public void clickOnSearchChrome() {
		driver.findElement(inpSearch).click();
	}
	//click search button in chrome
	public void clickOnSearchEdge() {
		driver.findElement(searchBtn).click(); 
	}
	
	//pass "trutime"
	public void searchTruTimeChrome(String txt) throws InterruptedException, IOException {
		driver.findElement(inpSearch).sendKeys(txt);  
		Thread.sleep(5000);
		
		takeScreenShot("Chrome");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(btnTruTime));
		driver.findElement(btnTruTime).click();
		Thread.sleep(5000);
	}
	
	//pass "trutime"
	public void searchTruTimeEdge(String txt) throws InterruptedException, IOException {
		driver.findElement(inputSearch).sendKeys(txt);
		Thread.sleep(5000);
		
		takeScreenShot("Edge");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(btnTruTime));
		driver.findElement(btnTruTime).click();
		Thread.sleep(5000);		
	}
	
	//Switching to frame
	public boolean verifyTruTimePage() {
		driver.switchTo().frame("appFrame");
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement truTimeEle = wait2.until(ExpectedConditions.visibilityOfElementLocated(txtTruTime));
		return truTimeEle.isDisplayed();
	}
	
	public void takeScreenShot(String str) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"\\screenshots\\OneCognizant"+str+".png");		
		FileUtils.copyFile(src,dest);
	}
}
