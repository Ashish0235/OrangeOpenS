package testClassess;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.DashboardPage;

public class DashboardTest extends BaseTest {

	LoginTest login = new LoginTest();
	DashboardPage dash = new DashboardPage();

	@Test
	public void DashboardEventsViewName() {

		login.login();
		dash.DashboardEventsView();

	}
}
