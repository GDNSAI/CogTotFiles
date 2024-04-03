package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	public Properties p;
	public Logger logger;

	// For selecting specified browser
	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browser) throws IOException {
		FileReader file = new FileReader(".//src/test/resources/data.properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());

		// Conditions for selecting browser
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter a valid browser");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}

	// Quitting the browser
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}