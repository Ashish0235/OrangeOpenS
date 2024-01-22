package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class SuitListner extends BaseTest implements ITestListener, IAnnotationTransformer {

	String date = new SimpleDateFormat("yyyy-MM-dd/hhmmss").format(new Date());

	public void onTestFailure(ITestResult result) {

		String filename = System.getProperty("user.dir") + File.separator + "\\screenshots\\" + File.separator
		        + result.getMethod().getMethodName();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourchPath = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(filename + ".png");
		try {
			FileUtils.copyFile(sourchPath, destinationPath);
		} catch (IOException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		}

	}

	/*
	 * public void transform(ITestAnnotation annotation, Class testClass,
	 * Constructor testConstructor, Method testMethod) {
	 * 
	 * annotation.setRetryAnalyzer(RetryAnalyzer.class);
	 * 
	 * }
	 */
}
