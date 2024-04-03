package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UpcomingBikes;
import testBase.BaseTest;

public class TC_001 extends BaseTest{
	
	@Test
	public void test1() throws InterruptedException, IOException
	{
		logger.info("***** Starting Test-Case_001 *****");
		HomePage hp = new HomePage(driver);
		logger.info("Hover on NewBikes");
		hp.hoverNewBikes();
		logger.info("Clicking on Upcoming Bikes");
		hp.clickUpcomingBikes();
		
		UpcomingBikes ub = new UpcomingBikes(driver);
		logger.info("Selecting Manufactorer and Getting the model details");
		ub.selectBrand();
		ub.moreBikes();
		ub.getBikeModels();
		ub.getPrices();
		ub.getLaunchDates();
		ub.sortBikes();
		ub.pushUpcomingBikes();
		ub.takeScreenshot();
		logger.info("***** Test-Case_001 Finished *****");
	}
}