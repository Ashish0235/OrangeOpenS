package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageConstants.DashboardPageEvents;
import utils.FetchElement;

public class Dashboard_Page extends BaseTest implements DashboardPageEvents {

    private final FetchElement fetchElement;

    public Dashboard_Page() {
        this.fetchElement = new FetchElement();
    }

    public List<WebElement> getDashboardEvents() {
        List<WebElement> tabs = fetchElement.getWebElements("XPATH", listOfEventsXpath);
        printElements(tabs);
        return tabs;
    }

    public String getTimeOfWorkDetails() {
        return fetchElement.getWebElement("XPATH", punchTimeXpath).getText();
    }

    public String getTotalTime() {
        return fetchElement.getWebElement("XPATH", fullTimeCheckXpath).getText();
    }

    public List<WebElement> getMyActionDetails() {
        return fetchElement.getWebElements("XPATH", myActionXpath);
    }

    public List<WebElement> getQuickLinks() {
        return fetchElement.getWebElements("XPATH", quickLaunchXpath);
    }

    public String getLatestBuzzPost() {
        return fetchElement.getWebElement("XPATH", buzzLatestPostsXpath).getText();
    }

    public WebElement getEmployeeOnLeaveToday() {
        return fetchElement.getWebElement("XPATH", employeeOnLeaveXpath);
    }

    public String getNoEmployeeOnLeaveMessage() {
        return fetchElement.getWebElement("CSS", noLeaveHistoryCss).getText();
    }

    //Fetching all the options available in the List
    private void printElements(List<WebElement> elements) {
        if (!elements.isEmpty()) {
            System.out.println(elements.size() + " Elements found by xpath as tabs \n");
            for (WebElement element : elements) {
                System.out.println("- "+element.getText());
            }
        }
    }
}
