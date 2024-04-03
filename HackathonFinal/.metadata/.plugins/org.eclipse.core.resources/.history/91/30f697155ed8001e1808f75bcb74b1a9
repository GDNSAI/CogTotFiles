package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
	
	Set<String> windows;
	List<String> wind;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Finding Webelements
	@FindBy(xpath = "//input[@type='email']") WebElement email;
	@FindBy(xpath = "//span[text()='Next']") WebElement submit;
	@FindBy(xpath = "//div[@class='o6cuMc Jj6Lae']") WebElement errorMsg;
	
	//Method to switch windows
	public void windowSwitch() throws InterruptedException
	{
		windows = driver.getWindowHandles();
		wind = new ArrayList<String> (windows);
		
		driver.switchTo().window(wind.get(1));
		driver.manage().window().maximize();
	}
	
	//Method to enter email in email field
	public void enterEmail() throws InterruptedException 
	{
		Thread.sleep(5000);
		email.sendKeys("aefwf");
	}
	
	//Method to click on next
	public void next() 
	{
		submit.click();
	}
	
	//Method to get error message
	public void getErrorMsg()
	{
		errorMsg.getText();
		System.out.println(errorMsg.getText());
	}
	
	//Method to take screenshot
	public void takeScreenshot() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2309118\\eclipse-workspace\\Hackathon\\screenshots\\error.png"); 
		FileUtils.copyFile(src, trg);
	}
}