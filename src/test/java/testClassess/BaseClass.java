package testClassess;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	String date = new SimpleDateFormat("yyyy-MM-dd/hhmmss").format(new Date());
	ReadConfig prop = new ReadConfig();
	public static Logger log;

	public WebDriver getDriver() {
		return driver;
	}

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

	// Take Full screen ScreenShot
	public void takeScreenshot(String Filename) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourchPath = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(
				System.getProperty("user.dir") + "\\screenshots\\" + Filename + "_" + date + ".png");
		try {
			FileUtils.copyFile(sourchPath, destinationPath);
		} catch (IOException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		}

	}
	// Take particular element screen ScreenShot

	public void takeElementScreenShot(WebElement element, String Filename) {

		File sourchPath = element.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(
				System.getProperty("user.dir") + "\\screenshots\\" + Filename + "_" + date + ".png");
		try {
			FileUtils.copyFile(sourchPath, destinationPath);
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		}

	}

}
