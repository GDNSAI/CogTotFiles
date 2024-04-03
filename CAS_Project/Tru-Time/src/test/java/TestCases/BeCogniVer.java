package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.BeCognizant;
import TestBase.BaseClass;

public class BeCogniVer extends BaseClass{
	public BeCognizant beCogniPage;

	@Test(priority = 1)
	public void getInfo() throws InterruptedException {

		beCogniPage = new BeCognizant(driver);
		beCogniPage.clickAccDetails();

		Assert.assertEquals(beCogniPage.getAccManagerName(), "Devanagasai, Geepalem (Contractor)");
		Assert.assertEquals(beCogniPage.getAccManagerEmail(), "2308397@cognizant.com");

	}

	@Test(priority = 2, dependsOnMethods = { "getInfo" })
	public void verifyOneCogni() throws InterruptedException {

		Assert.assertEquals(beCogniPage.verifyOneCogni(), "OneCognizant", "One Cognizant NOT found");
		beCogniPage.clickOnOneCogni();

	}

}
