package testClassess;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageConstants.DashboardPageEvents;
import pageObjects.Dashboard_Page;

public class Dashboard_Test extends BaseTest implements DashboardPageEvents {

	Dashboard_Page dash = new Dashboard_Page();

	@Test
	public void DashboardEventsViewName() throws InterruptedException {
		
		dash.DashboardEventsView();
		List<WebElement> tabs = dash.DashboardEventsView();
		for (WebElement inputElement : tabs) {
			System.out.println(inputElement.getText());
			if (inputElement.getText().equalsIgnoreCase(headerName));
			String hText = inputElement.getText();
			Assert.assertEquals(hName, hText);
			break;

		}
			
		String time = dash.timeOfWorkDetails();
		String totalTime = dash.totalTime();
		List<WebElement> links = dash.myActionDetails();

		logger.info("Assertion checked");
		logger.info("Time of login/logout: " + time);
		//logger.info("Time of login/logout: " + time.subSequence(11, 38));
		logger.info("Total time of the day: " + totalTime);
		for (WebElement aName : links) {
			logger.info("My Actions :" +aName.getText());

		}
		List<WebElement> quicklinks = dash.quickLinks();
		Actions hover = new Actions(driver);
		for (WebElement webElement : quicklinks) {
			logger.info("Quick links :" +webElement.getText());
			hover.moveToElement(webElement).build().perform();
			Thread.sleep(500);
		}

		logger.info("Latest Buzz post is:-" + dash.buzzLatestPost());
		
		logger.info("Employee on leave today : "+dash.noEmployeeOnLeaveToday());
		
		
	}

}
