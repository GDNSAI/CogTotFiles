package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement NewBikes;

	// Upcoming Bikes element
	@FindBy(xpath = "//span[normalize-space()='Upcoming Bikes']")
	public WebElement upcomingBikes;

	public void ClickNewBikes() {
		Actions act = new Actions(driver);
		act.moveToElement(NewBikes).perform();
	}

	public void UpComingBikes() {
		// hover
		Actions actions = new Actions(driver);
		actions.moveToElement(upcomingBikes).perform();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", upcomingBikes);
	}

}
