package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZigWeelsPage extends BasePage{

	ZigWeelsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Bikes']") 
	public WebElement newBikes;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	public WebElement upCommoingBikes;
	
	

}
