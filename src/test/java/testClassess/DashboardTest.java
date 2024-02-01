package testClassess;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.DashboardPage;

public class DashboardTest extends BaseTest {

	
	DashboardPage dash = new DashboardPage();

	@Test
	public void DashboardEventsViewName() {

		dash.DashboardEventsView();

	}
}
