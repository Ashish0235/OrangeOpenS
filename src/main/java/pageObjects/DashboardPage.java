package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import pageConstants.DashboardPageEvents;
import utils.FetchElement;

public class DashboardPage extends BaseClass implements DashboardPageEvents {

	FetchElement ele = new FetchElement();

	public void DashboardEventsView() {

		ele.getWebElements("XPATH", listOfEvents).size();

		if (ele.getWebElements("XPATH", listOfEvents).size() != 0) {
			// System.out.println(ele.getWebElements("XPATH", listOfEvents).size() + "
			// Elements found by xpath as tabs \n");

			for (WebElement inputElement : ele.getWebElements("XPATH", listOfEvents)) {
				System.out.println(inputElement.getText());
				if (inputElement.getText().equalsIgnoreCase(headerName));
				String hText = inputElement.getText();
				Assert.assertEquals(hName, hText);
				break;

			}

		}

	}

	public String timeOfWorkDetails() {

		String time = ele.getWebElement("XPATH", punchTime).getText();

		return time;

	}

	public String totalTime() {

		String tottime = ele.getWebElement("XPATH", fullTimeCheck).getText();
		return tottime;

	}

	public List<WebElement> myActionDetails() {
		
		List<WebElement> actNames = ele.getWebElements("XPATH", myAction);
		for (WebElement aName : actNames) {
			
			System.out.println(aName + "My Actions \n");
			
		}
		
		return actNames;
		

	}

	public String quickLaunchLinkds() {
		
		String qLinks = ele.getWebElement("XPATH", quickLaunch).getText();
		return qLinks;
		

	}

	public void buzzLatestPost() {

	}

	public void employeeOnLeaveToday() {

	}

	public void employeeDisctrubutionBySubUnit() {

	}

	public void employeeDisctrubutionBylocation() {

	}

}
