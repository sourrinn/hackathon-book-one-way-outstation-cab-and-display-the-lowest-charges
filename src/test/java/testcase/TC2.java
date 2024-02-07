package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.giftcard;
import testBase.baseclass;
import utilities.TakeScreenshot;

public class TC2 extends baseclass {

	@Test(priority = 2)
	public void secondcase() throws InterruptedException, IOException {
		giftcard gc=new giftcard(driver);
		TakeScreenshot ts = new TakeScreenshot(driver);
		gc.clkgift();
		ts.takeScreenshot(driver, "GiftCardPage");
		gc.sndrname();
		gc.etrphno();
		gc.etrmail();
		gc.clkbuynow();
		ts.takeScreenshot(driver, "InvalidUserData");
	}

}
