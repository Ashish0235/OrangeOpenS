package pageConstants;

public interface DashboardPageEvents {
	
	String headerName = "Time at Work";	
	//String headerName = "//*[@class='oxd-text oxd-text--p']";
	String listOfEventsXpath = "//div[@class='oxd-grid-3 orangehrm-dashboard-grid']/div";
	String dashboardXpath = "//h6[normalize-space()=\"Dashboard\"]";
	String punchTimeXpath = "//*[@class='oxd-text oxd-text--p orangehrm-attendance-card-details']";
	String fullTimeCheckXpath = "//*[@class='oxd-text oxd-text--span orangehrm-attendance-card-fulltime']";
	String myActionXpath = "//*[@class='orangehrm-todo-list']//div";
	String quickLaunchXpath = "//*[@class='oxd-grid-3 orangehrm-quick-launch']/div";
	String buzzLatestPostsXpath = "//*[@class='oxd-text oxd-text--p orangehrm-buzz-widget-body']";
	String onLeaveXpath = "//*[@class='orangehrm-dashboard-widget-body']";
	String employeeOnLeaveXpath = "//*[@class='orangehrm-leave-card']";
	String noLeaveHistoryCss = "div[class='orangehrm-dashboard-widget-body-nocontent'] p[class='oxd-text oxd-text--p']";
	

}
