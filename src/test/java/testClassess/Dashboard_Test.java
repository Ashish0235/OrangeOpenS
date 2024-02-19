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

	Dashboard_Page dashboardPage = new Dashboard_Page();

	@Test
	public void testDashboardEvents() throws InterruptedException {
		// Verify Dashboard Events view
		List<WebElement> tabs = dashboardPage.getDashboardEvents();
		Assert.assertFalse(tabs.isEmpty(), "Dashboard events are not displayed");

		// Verify Header Name
		for (WebElement tab : tabs) {
			String headerText = tab.getText().trim();
			Assert.assertEquals(headerText, headerName, "Header name doesn't match");
			break; // Assuming only the first tab header needs to be checked
		}

		// Get time of work details and total time
		String timeOfWorkDetails = dashboardPage.getTimeOfWorkDetails();
		String totalTime = dashboardPage.getTotalTime();
		logger.info("Time of login/logout: " + timeOfWorkDetails);
		logger.info("Total time of the day: " + totalTime);

		// Get My Action details
		List<WebElement> myActionDetails = dashboardPage.getMyActionDetails();
		logger.info("My Actions:");
		for (WebElement action : myActionDetails) {
			logger.info(action.getText());
		}

		// Hover over Quick Links
		List<WebElement> quickLinks = dashboardPage.getQuickLinks();
		Actions actions = new Actions(driver);
		for (WebElement link : quickLinks) {
			actions.moveToElement(link).build().perform();
			logger.info("Hovered over Quick Link: " + link.getText());
			Thread.sleep(500);
		}

		// Get latest Buzz post
		String latestBuzzPost = dashboardPage.getLatestBuzzPost();
		logger.info("Latest Buzz post: " + latestBuzzPost);

		// Check if any employee is on leave today
		String employeeOnLeave = dashboardPage.getNoEmployeeOnLeaveMessage();
		logger.info("Employee on leave today: " + employeeOnLeave);
	}
}
