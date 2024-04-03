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
		HomePage hp = new HomePage(driver);
		hp.hoverNewBikes();
		hp.clickUpcomingBikes();
		
		UpcomingBikes ub = new UpcomingBikes(driver);
		ub.selectBrand();
		ub.moreBikes();
		ub.getBikeModels();
		ub.getPrices();
		ub.getLaunchDates();
		ub.sortBikes();
		ub.pushUpcomingBikes();
		ub.takeScreenshot();
	}
}