package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
	WebDriver driver;

	BaseTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
