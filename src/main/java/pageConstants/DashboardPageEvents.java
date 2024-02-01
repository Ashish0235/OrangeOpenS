package pageConstants;

public interface DashboardPageEvents {
	
	String hName = "Time at Work";	
	String headerName = "//*[@class='oxd-text oxd-text--p']";
	String listOfEvents = "//div[@class='oxd-grid-3 orangehrm-dashboard-grid']/div"; //Xpath
	String dashboard = "//h6[normalize-space()=\"Dashboard\"]"; // XPATH
	String punchTime = "//*[@class='oxd-text oxd-text--p orangehrm-attendance-card-details']";
	String fullTimeCheck = "//*[@class='oxd-text oxd-text--span orangehrm-attendance-card-fulltime']";
	String myAction = "//*[@class='orangehrm-todo-list']//div";
	String quickLaunch = "//*[@class='oxd-grid-3 orangehrm-quick-launch']";
	

}
