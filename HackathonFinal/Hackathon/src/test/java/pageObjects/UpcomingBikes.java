package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtils;

public class UpcomingBikes extends BasePage{
	
	public List<String> bikeModels = new ArrayList<String>();
	public List<String> prices = new ArrayList<String>();
	public List<String> launchDate = new ArrayList<String>();
	
	public UpcomingBikes(WebDriver driver)
	{
		super(driver);
	}
	
	//Finding Webelements
	@FindBy(id = "makeId") WebElement manufacturers;
	String brand = "Honda";
	@FindBy(xpath = "//div[@class='zw-con pb-0 mb-20 stickyRhs']//li[4]") WebElement view;
	@FindBy(xpath = "//ul[@id='modelList']/li/span") WebElement viewMoreBikes;
	
	@FindBy(xpath = "//Strong[contains(text(),'Honda')]") List<WebElement> model;
	@FindBy(xpath = "//li[contains(@class,'col-lg-4')]") List<WebElement> price;
	@FindBy(xpath = "//div[@class='clr-try fnt-14']") List<WebElement> dates;
	
	//Method to select required brand
	public void selectBrand()
	{
		Select manufacture = new Select(manufacturers);
		manufacture.selectByVisibleText(brand);
	}
	
	//Method to click on view more bikes
	public void moreBikes() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView();", view);
		Thread.sleep(5000);
		viewMoreBikes.click();
	}
	
	//Method to get bike models
	public void getBikeModels()
	{
		for(WebElement i : model)
		{
			bikeModels.add(i.getText());
		}
	}
	
	//Method to get bike prices
	public void getPrices()
	{
		for(WebElement j : price)
		{
			prices.add(j.getAttribute("data-price"));
		}
	}
	
	//Method to get launch dates
	public void getLaunchDates()
	{
		for(WebElement k : dates)
		{
			launchDate.add(k.getText());
		}
	}
	
	//Method to eliminate bikes that costs more than 4 lakh
	public void sortBikes()
	{
		for(int k=prices.size()-1;k>=0;k--)
		{			
			if(Integer.parseInt(prices.get(k))>400000)
			{
				bikeModels.remove(k);
				prices.remove(k);
				launchDate.remove(k);
			}
		}
	}
	
	//Method to take screenshot
	public void takeScreenshot() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2308397\\eclipse-workspace\\HackathonFinal\\Hackathon\\screenshots\\bikes.png"); 
		FileUtils.copyFile(src, trg);
	}
	
	//Method to push bikes data into excel sheet
	public void pushUpcomingBikes() throws IOException, InterruptedException
	{	
		String path = "C:\\Users\\2308397\\eclipse-workspace\\HackathonFinal\\Hackathon\\TestData\\newBikes.xlsx";
		for(int i=0;i<prices.size();i++) 
		{
			ExcelUtils.createRow(path, "sheet1", i);
			ExcelUtils.setCellData(path, "sheet1", i, 0, bikeModels.get(i));
			ExcelUtils.setCellData(path, "sheet1", i, 1, launchDate.get(i));
			ExcelUtils.setCellData(path, "sheet1", i, 2, prices.get(i));
		}
	}
}