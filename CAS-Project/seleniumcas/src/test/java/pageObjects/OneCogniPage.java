package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
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

	By inpSearch = By.id("oneC_searchAutoComplete"); // chrome
	By searcBtn = By.className("searchTopBar"); // edge
	By inputSearch = By.id("oneCSearchTop"); // edge
	By btnSearch = By.xpath("//li[@class = 'oneC_searchbar']/div");
	By btnTruTime = By.xpath("//div[@id = 'newSearchAppsLST']/div[1]/div//div[contains(text(), 'TruTime ')]");
	By txtTruTime = By.linkText("My TruTime");

	public void switchToOneCogniHandle() {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals("OneCognizant")) {
				System.out.println("Successfully Switches into 1C Page \n");
				break;
			} else {
				continue;
			}

		}
	}

	public void clickOnSearchChrome() {
		driver.findElement(inpSearch).click();
	}

	public void clickOnSearchEdge() {
		driver.findElement(searcBtn).click();
	}

	public void searchTruTimeChrome(String txt) throws InterruptedException {
		driver.findElement(inpSearch).sendKeys(txt);
		Thread.sleep(5000);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(btnTruTime));
		driver.findElement(btnTruTime).click();
		Thread.sleep(5000);

	}

	public void searchTruTimeEdge(String txt) throws InterruptedException {
		driver.findElement(inputSearch).sendKeys(txt);
		Thread.sleep(5000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(btnTruTime));
		driver.findElement(btnTruTime).click();
		Thread.sleep(5000);

	}

	public boolean verifyTruTimePage() {

		driver.switchTo().frame("appFrame");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement truTimeEle = wait2.until(ExpectedConditions.visibilityOfElementLocated(txtTruTime));
		return truTimeEle.isDisplayed();
	}

}
