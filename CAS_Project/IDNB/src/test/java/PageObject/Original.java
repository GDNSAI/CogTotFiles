package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Original {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();

		driver.get("https://www.zigwheels.com/");
		
		WebElement we=driver.findElement(By.xpath("//a[normalize-space()='New Bikes']"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(we).perform();
		
		WebElement we1=driver.findElement(By.xpath("//span[normalize-space()='Upcoming Bikes']"));
		Thread.sleep(2000);
		we1.click();
		
		WebElement we2=driver.findElement(By.id("makeId"));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", we2);
		
		Select s=new Select(we2);
		Thread.sleep(2000);
		s.selectByIndex(3);
		
	}

}
