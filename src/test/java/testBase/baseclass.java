package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

public class baseclass {
static	public WebDriver driver;
	public Properties p;
	public Logger logger;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException, InterruptedException {
		// Loading properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		// Loading log4j file
		logger = LogManager.getLogger(this.getClass());

		// Launching browser based on choice
		if (br.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (br.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		} else {
			System.out.println("No matching browser");
			return;
		}

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(p.getProperty("PageURL"));
		

	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
