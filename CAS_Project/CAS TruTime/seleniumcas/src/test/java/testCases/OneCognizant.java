package testCases;

import java.io.IOException;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.OneCogniPage;

public class OneCognizant extends BaseTest{
	
	public OneCogniPage oneCogniPage;
	
	//Switching browser & navigate to trutime
	@Parameters({"browser"})
	@Test(priority = 1)
	public void searchTruTime(String br) throws InterruptedException, IOException {
		oneCogniPage = new OneCogniPage(driver);
		
		oneCogniPage.switchToOneCogniHandle();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(br.equalsIgnoreCase("chrome")) {
			oneCogniPage.clickOnSearchChrome();
			oneCogniPage.searchTruTimeChrome("TruTime");
		}else if(br.equalsIgnoreCase("edge")) {
			oneCogniPage.clickOnSearchEdge();
			oneCogniPage.searchTruTimeEdge("TruTime");
		}
	
	}
	
	//validating trutime page
	@Test(priority = 2, dependsOnMethods = {"searchTruTime"})
	public void validateTruTimePage() {
		Assert.assertEquals(oneCogniPage.verifyTruTimePage(), true, "TruTime page NOT found");
	}
	

}
