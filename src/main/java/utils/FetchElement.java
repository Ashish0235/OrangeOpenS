package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class FetchElement {

	//private WebDriver driver;

	public WebElement getWebElement(String locatorType, String locatorValue) {

		switch (locatorType) {

		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(locatorValue));

		case "ID":
			return BaseTest.driver.findElement(By.id(locatorValue));

		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(locatorValue));

		case "NAME":
			return BaseTest.driver.findElement(By.name(locatorValue));

		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(locatorValue));

		case "LINKTEXT":
			return BaseTest.driver.findElement(By.linkText(locatorValue));

		default:

			return null;

		}
	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {

		switch (locatorType) {

		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(locatorValue));

		case "ID":
			return BaseTest.driver.findElements(By.id(locatorValue));

		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(locatorValue));

		case "NAME":
			return BaseTest.driver.findElements(By.name(locatorValue));

		case "CLASSNAME":
			return BaseTest.driver.findElements(By.className(locatorValue));

		case "LINKTEXT":
			return BaseTest.driver.findElements(By.linkText(locatorValue));

		default:

			return null;

		}

	}
}
