package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public  WebDriver driver;
	public Properties prop;
	public Logger logger;
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		FileReader file=new FileReader("C:\\Users\\2308397\\eclipse-workspace\\CAS_Project\\IDNB\\src\\test\\resource\\config.properties");
		prop=new Properties();
		prop.load(file);
		logger=LogManager.getLogger(this.getClass());
		try {
			if(br.equalsIgnoreCase("Chrome"))
			{
				driver=new ChromeDriver();
			}
			else
			{
				driver=new EdgeDriver();
			}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("appUrl"));
			driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@AfterClass
	public void flush()
	{
		driver.quit();
	}

}
