package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HondaBikes extends BasePage{

	public HondaBikes(WebDriver driver) {
		super(driver);
	}

		@FindBy(xpath="//strong[@class='lnk-hvr block of-hid h-height']")
		List<WebElement> hondaBikes;
		
		public void HondaBik()
		{
			for(WebElement hb:hondaBikes)
			{
				System.out.println(hb.getText());
			}
		}
		
}
