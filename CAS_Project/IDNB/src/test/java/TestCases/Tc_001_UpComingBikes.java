package TestCases;

import org.testng.annotations.Test;

import PageObject.MainPage;
import PageObject.UpcomingBikesPage;
import TestBase.BaseClass;

public class Tc_001_UpComingBikes extends BaseClass {

	@Test
	public void upComingBikeValidation() throws InterruptedException {
		try {
			MainPage mp = new MainPage(driver);
			mp.ClickNewBikes();
			mp.UpComingBikes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void manufactorsHonda() {
		try {
			UpcomingBikesPage upb = new UpcomingBikesPage(driver);
			upb.clickManufacturer();
//			upb.clickViewMoreButton();
//			upb.bikeDetails();
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
