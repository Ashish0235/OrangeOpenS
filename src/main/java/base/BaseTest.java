package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import configFiles.ReadConfig;
import pageObjects.LoginPage;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	String date = new SimpleDateFormat("yyyy-MM-dd/hhmmss").format(new Date());
	ReadConfig prop = new ReadConfig();
	public static Logger log;


	
public WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	public void mainBeforeTestMethod() {
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + "OrangeHRM Report.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "ASHISH");
		extent.setSystemInfo("UserName", "ADMIN");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation-Test Result by Ashish");
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser, Method testMethod) {

		log = LogManager.getLogger("Orange-HRM");
		logger = extent.createTest(testMethod.getName());

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			log.info("Chrome browser launched");

		} else if (browser.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			driver = new EdgeDriver(options);
			log.info("Edge browser launched");
		} else if (browser.equalsIgnoreCase("firefox")) {

			FirefoxOptions options = new FirefoxOptions();

			driver = new FirefoxDriver(options);
			log.info("Firefox browser launched");
		}

		driver.navigate().to(prop.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		LoginPage first = new LoginPage();
		first.loginpageTest();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "- Test Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case PASS", ExtentColor.GREEN));
		}
		Thread.sleep(2000);
		driver.quit();
	}

	@AfterTest

	public void afterTest() {

		extent.flush();

	}

	// Take Full screen ScreenShot
	public void takeScreenshot(String Filename) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourchPath = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + Filename + "_" + date + ".png");
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
