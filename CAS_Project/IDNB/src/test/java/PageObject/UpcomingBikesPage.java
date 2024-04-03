package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class UpcomingBikesPage extends BasePage {

	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}

	// Manufacturer Element
	//@FindBy(xpath="//li[@class='gscr_lslide']/a[contains(normalize-space(),'Honda')]")
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]/select[1]")
	public WebElement locateManufacturer;

	// View More Bikes Button to view more bikes
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	public WebElement viewMoreBikesButton;

	// Model names of all the Honda bikes
	@FindBy(css = ".lnk-hvr.block.of-hid.h-height")
	public List<WebElement> modelName;

	// Prices of all the Honda bikes
	@FindBy(xpath = "//li[contains(@class,'modelItem')]")
	public List<WebElement> bikePrice;

	// Launch date of all the Honda bikes
	@FindBy(css = ".clr-try.fnt-14")
	public List<WebElement> dateOfBikes;

	// Element to scroll based on it
	@FindBy(xpath = "//a[normalize-space()='Latest Bikes']")
	public WebElement scrollElement;

	// Select Manufacturer Honda and click
	public void clickManufacturer() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locateManufacturer);
		Select s=new Select(locateManufacturer);
		s.selectByIndex(3);
	}

	/*// Locate the view more bikes button and click on it
	public void clickViewMoreButton() throws InterruptedException {
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", viewMoreBikesButton);
		Thread.sleep(2000);
	}

	// Get the details of the bikes and store in the excel file
	public void bikeDetails() throws IOException {
		int row = 1;
		for (int i = 0; i < modelName.size(); i++) {
			String bikeName = modelName.get(i).getText();
			String launchDate = dateOfBikes.get(i).getText();
			int price = Integer.parseInt(bikePrice.get(i).getAttribute("data-price"));
			if (price < 400000) {
				System.out.println(bikeName + "\n" + price + "\n" + launchDate);
				System.out.println("****************************");
				row++;
			}
		}
	}*/
}
