package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Finding webelements
	@FindBy(linkText = "New Bikes") WebElement newBikes;
	@FindBy(xpath = "//span[text()='Upcoming Bikes']") WebElement upcomingBikes;
	
	@FindBy(linkText = "Used Cars") WebElement usedCars;
	@FindBy(xpath = "//div[@class='h-dd-r']//Span[text()='Chennai']") WebElement state;
	
	@FindBy(id= "forum_login_title_lg") WebElement login;
	@FindBy(xpath= "//span[text()='Google']") WebElement google;
	
	//Method to hover on New Bikes
	public void hoverNewBikes()
	{
		action.moveToElement(newBikes).perform();
	}
	
	//Method to click on upcoming bikes
	public void clickUpcomingBikes()
	{
		upcomingBikes.click();
	}
	
	//Method to hover on Used Cars
	public void hoverUsedCars()
	{
		action.moveToElement(usedCars).perform();
	}
	
	//Method to click on state
	public void clickState()
	{
		state.click();
	}
	
	//Method to click on login
	public void clickLogin()
	{
		login.click();
	}
	
	//Method to click on login through google
	public void clickGoogle()
	{
		google.click();
	}
}