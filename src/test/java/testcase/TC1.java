package testcase;

import java.io.IOException;

import org.testng.annotations.Test;
import pageObjects.jdHomepage;
import testBase.baseclass;
import utilities.TakeScreenshot;

public class TC1 extends baseclass {

	@Test(priority = 1)

	public void makemytrip() throws InterruptedException, IOException {
		jdHomepage jd = new jdHomepage(driver);
		TakeScreenshot ts = new TakeScreenshot(driver);
		
		jd.cabs();
		jd.clkfrom();
		jd.etrdelhi();
		jd.clkto();
		jd.etrmanali();
		Thread.sleep(2000);
		jd.slctdate();
		jd.slcthour();
		jd.slctmin();
		jd.slctam();
		jd.clkapply();
		ts.takeScreenshot(driver, "HomePageCabs");
		jd.clksearch();
		jd.clksuv();
		jd.clkfilter();
		jd.slctlow();
		jd.carlist();
		jd.lowstprice();
		ts.takeScreenshot(driver, "CheapestSUV");
	}

}
