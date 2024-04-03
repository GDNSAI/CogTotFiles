package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilityMethods.CalenderDDMMYYY;

public class TruTimePageObj {

	public WebDriver driver;

	public TruTimePageObj(WebDriver driver) {
		this.driver = driver;

	}

	ArrayList<String> legendAl = new ArrayList<String>();
	ArrayList<String> truTimeDates = new ArrayList<String>();
	CalenderDDMMYYY myCalender = new CalenderDDMMYYY();
	By truTimeMonth = By.xpath("//div[@class = 'ui-datepicker-title']/span[1]");
	By truTimeYear = By.xpath("//div[@class = 'ui-datepicker-title']/span[2]");
	By txtBackdated = By.cssSelector("span.topupavailablefromDate");
	By legends = By.xpath("//ul[@class = 'legend-labels']/li");
	By txtHighlighted = By.xpath("//div[@ng-if = 'item.Date==activeDate']");

	public String getMonth() {
		String mon = driver.findElement(truTimeMonth).getText();
		System.out.println(mon);
		return mon;
	}

	public String getYear() {
		String year = driver.findElement(truTimeYear).getText();
		System.out.println(year + "\n");
		return year;
	}

	public String backDatedTopUp() {

		return driver.findElement(txtBackdated).getText();
	}

	public int getLegends() {
		System.out.println("Leagends are: \n");
		for (int i = 2; i <= 30; i += 2) {
			WebElement legends = driver.findElement(By.xpath("//ul[@class = 'legend-labels']/li[" + i + "]"));
			String txtLegend = legends.getText();
			legendAl.add(txtLegend);
			System.out.println(txtLegend);
		}
		System.out.println("Total no of Legends : \n" + legendAl.size() + "\n");
		

		return legendAl.size();

	}

	public String getCurrentHighlightedDay() {
		System.out.println("Today's date : \n");

		return driver.findElement(txtHighlighted).getText();
	}

	public boolean getCurrentWeekDatesInTruTime() {

		List<WebElement> currentTruTimeDates = driver
				.findElements(By.xpath("//div[@class='weekContainer']//div[contains(@class,'dayHeadr')]"));

		for (int i = 0; i < 7; i++) {
			truTimeDates.add(currentTruTimeDates.get(i).getText());
		}

		System.out.println("TruTime Dates size for the forward " + truTimeDates.size() + " days \n");

		boolean flag = true;
		for (int j = 0; j < 7; j++) {
			if (truTimeDates.get(j).equals(myCalender.localWeekDates().get(j))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		System.out.println(truTimeDates);
		return flag;
	}
}
