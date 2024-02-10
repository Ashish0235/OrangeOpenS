package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import pageConstants.DashboardPageEvents;
import utils.FetchElement;

public class Dashboard_Page implements DashboardPageEvents {

	FetchElement ele = new FetchElement();

	public List<WebElement> DashboardEventsView() {
		
		List<WebElement> tabs = ele.getWebElements("XPATH", listOfEvents);

		if (tabs.size() != 0) {
			System.out.println(ele.getWebElements("XPATH", listOfEvents).size() + " Elements found by xpath as tabs \n");
			
			for (WebElement inputElement : tabs) {
				System.out.println(inputElement.getText());

			}

		}
		return tabs;

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
		
		return actNames;

	}
	
	//Fetching all the elements under the quick Lanuch tab
	public List<WebElement> quickLinks() {
		
		List<WebElement> qLinks = ele.getWebElements("XPATH", quickLaunch);
		return qLinks;

	}

	public String buzzLatestPost() {

		String buzzPost = ele.getWebElement("XPATH", buzzLatestPosts).getText();
		return buzzPost;

	}

	public WebElement employeeOnLeaveToday() {

		WebElement leaveInfo = ele.getWebElement("XPATH", employeeOnLeave);

		return leaveInfo;

	}
	
	public String noEmployeeOnLeaveToday() {

		String onLeave = ele.getWebElement("CSS", noLeaveHistory).getText();

		return onLeave;

	}


}
