package pageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends BasePage{
	
	List<String> popularCarModels = new ArrayList<String>();
	
	public UsedCars(WebDriver driver)
	{
		super(driver);
	}
	
	//Finding Webelements
	@FindBy(xpath = "//label[contains(@for,'bycarid')]") List<WebElement> popModel;
	
	//Method to scroll
	public void scroll()
	{
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	//Method to get popular car models
	public void popularModels()
	{
		for(WebElement l : popModel)
		{
			popularCarModels.add(l.getText());
		}
	}
	
	//Method to push cars data into excel sheet
	public void pushPopularCars() throws IOException
	{
		FileOutputStream file = new FileOutputStream("C:\\Users\\2308397\\eclipse-workspace\\2308397_Identifying-New-Bikes_Hackathon\\Hackathon\\TestData\\popularModels.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet ws = wb.createSheet();
		for(int i=0;i<popularCarModels.size();i++)
		{
			XSSFRow rows = ws.createRow(i);
			XSSFCell cell = rows.createCell(0);
			cell.setCellValue(popularCarModels.get(i));
		}
		wb.write(file);
		wb.close();
		file.close();
	}
	
	//Method to take screenshot
	public void takeScreenshot() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2308397\\eclipse-workspace\\2308397_Identifying-New-Bikes_Hackathon\\Hackathon\\screenshots\\cars.png"); 
		FileUtils.copyFile(src, trg);
	}
}