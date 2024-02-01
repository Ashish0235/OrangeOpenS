package testClassess;

import org.testng.annotations.Test;

import base.BaseTest;
import pageConstants.DashboardPageEvents;
import pageObjects.DashboardPage;

public class DashboardTest extends BaseTest implements DashboardPageEvents {

	
	DashboardPage dash = new DashboardPage();

	@Test
	public void DashboardEventsViewName() {

		dash.DashboardEventsView();
		String time = dash.timeOfWorkDetails();
		String totalTime = dash.totalTime();
		logger.info("Assertion checked");
		logger.info("Time of login/logout: " +time.subSequence(11, 39));
		logger.info("Total time of the day: " +totalTime);
		logger.info("My Actions : " +dash.myActionDetails());
		logger.info("Quick Launch linkds : " +dash.quickLaunchLinkds());

	}
}
