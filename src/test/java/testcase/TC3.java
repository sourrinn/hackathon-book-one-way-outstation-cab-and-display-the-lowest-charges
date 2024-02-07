package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.hotels;
import testBase.baseclass;
import utilities.TakeScreenshot;

public class TC3 extends baseclass {

	@Test(priority = 2)
	public void thirdcase() throws InterruptedException, IOException {
		TakeScreenshot ts = new TakeScreenshot(driver);
		hotels hs=new hotels(driver);
		hs.clkHotels();
		ts.takeScreenshot(driver, "HotelsPage");
	}

}
