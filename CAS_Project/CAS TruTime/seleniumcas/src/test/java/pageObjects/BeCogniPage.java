package pageObjects;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeCogniPage {
	public WebDriver driver;
	
	public BeCogniPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Page Elements
	By settingLogo = By.xpath("//button[@title = 'Settings']/div/span");
	By accManagerLogo = By.xpath("//div[@class='ohcfXYh6LUBy5DS5kNUjRQ==']");
	By nameElement = By.id("mectrl_currentAccount_primary");
	By emailElement = By.id("mectrl_currentAccount_secondary");
	By oneCogniApp = By.xpath("//div[@title='OneCognizant' ]");
	
	//Action methods
	//To click acc details
	public void clickAccDetails() throws InterruptedException {
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(settingLogo));
		Thread.sleep(5000);
		WebElement btn= driver.findElement(accManagerLogo);
		btn.click();
	}
    
	//To retrieve user name
	public String getAccManagerName() throws InterruptedException {
		WebElement txtName = null;
		try{
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		txtName= wait2.until(ExpectedConditions.visibilityOfElementLocated(nameElement));

		}catch(TimeoutException e) {
			try{
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
				txtName= wait2.until(ExpectedConditions.visibilityOfElementLocated(nameElement));
			} catch(NoSuchElementException v) {
				v.getMessage();
			}
		}
		return txtName.getText();
	}
	
	//To retrieve user email
	public String getAccManagerEmail() throws InterruptedException {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement txtEmail= wait3.until(ExpectedConditions.visibilityOfElementLocated(emailElement));
		Thread.sleep(5000);
		
		
		Thread.sleep(5000);
	
		return txtEmail.getText();
	}
	
	//To verify OneCognizant 
	public String verifyOneCogni() throws InterruptedException {
		WebElement AroundCogni = driver.findElement(oneCogniApp);
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", AroundCogni);
		Thread.sleep(5000); 
		WebElement webapp = driver.findElement(oneCogniApp);
		return webapp.getText();
	}
	
	//To navigate to OneCognizant
	public void clickOnOneCogni() throws InterruptedException {
		Thread.sleep(5000);
		WebElement cog=driver.findElement(oneCogniApp);
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].click();", cog);
		
	}
	
	public void takeScreenShot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"\\screenshots\\BeCognizant.png");		
		FileUtils.copyFile(src,dest);
	}
	
}
