package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC_003 extends BaseTest{
	
	@Test(groups= {"smoke","master"})
	public void test3() throws InterruptedException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		Thread.sleep(5000);
		hp.clickGoogle();
		
		LoginPage lp = new LoginPage(driver);
		lp.windowSwitch();		
		lp.enterEmail();
		lp.next();
		lp.getErrorMsg();
		lp.takeScreenshot();
	}
}