package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public Properties p;
	
	//For selecting specified browser
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) throws IOException
	{
		FileReader file = new FileReader(".//src/test/resources/data.properties");
		p = new Properties();
		p.load(file);
		
		//Conditions for selecting browser
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter a valid browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	//Quitting the browser
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}