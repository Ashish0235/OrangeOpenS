package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import configFiles.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	ReadConfig prop = new ReadConfig();
	public static Logger log;

	/*
	 * public WebDriver getDriver() { return driver; }
	 */

	@BeforeMethod
	public void setup() {

		log = LogManager.getLogger("Orange-HRM");

		if (prop.getBroserName().equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			log.info("Chrome browser launched");

		} else if (prop.getBroserName().equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			driver = new EdgeDriver(options);
			log.info("Edge browser launched");
		} else if (prop.getBroserName().equalsIgnoreCase("firefox")) {

			FirefoxOptions options = new FirefoxOptions();

			driver = new FirefoxDriver(options);
			log.info("Firefox browser launched");
		}

		driver.navigate().to(prop.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.quit();
	}

}
