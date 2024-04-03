package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BeCogniPage;

public class BeCognizant extends BaseTest {
	
	public BeCogniPage beCogniPage; 
	
	//login to beCognizant and verifying user details
	@Test(priority = 1)
	public void getInfo() throws InterruptedException {
		
		beCogniPage = new BeCogniPage(driver);
		beCogniPage.clickAccDetails();

		Assert.assertEquals(beCogniPage.getAccManagerName(), "Devanagasai, Geepalem (Contractor)");
		Assert.assertEquals(beCogniPage.getAccManagerEmail(), "2308397@cognizant.com");
		try {
			beCogniPage.takeScreenShot();
		} catch (IOException e) {
			System.out.println("Screenshot not taken");
		}
	}
	
	//navigate to OneCognizant
	@Test(priority = 2, dependsOnMethods = {"getInfo"})
	public void verifyOneCogni() throws InterruptedException {
		
		Assert.assertEquals(beCogniPage.verifyOneCogni(), "OneCognizant", "One Cognizant NOT found");
		beCogniPage.clickOnOneCogni();
		
	}
	
}
