package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UsedCars;
import testBase.BaseTest;

public class TC_002 extends BaseTest{
	
	@Test(groups= {"regression","master"})
	public void test2() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.hoverUsedCars();
		hp.clickState();
		
		UsedCars uc = new UsedCars(driver);
		uc.scroll();
		uc.popularModels();
		uc.pushPopularCars();
		uc.takeScreenshot();
	}
}