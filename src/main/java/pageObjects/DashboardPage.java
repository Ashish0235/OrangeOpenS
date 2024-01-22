package pageObjects;

import org.openqa.selenium.WebElement;

import base.BaseClass;
import pageConstants.DashboardPageEvents;
import utils.FetchElement;

public class DashboardPage extends BaseClass implements DashboardPageEvents {

	FetchElement ele = new FetchElement();

	public void DashboardEventsView() {

	ele.getWebElements("XPATH", listOfEvents).size();
		
		if(ele.getWebElements("XPATH", listOfEvents).size() != 0) 
		   {
			   System.out.println(ele.getWebElements("XPATH", listOfEvents).size() + " Elements found by xpath as tabs \n");
				
			   for(WebElement inputElement : ele.getWebElements("XPATH", listOfEvents)) 
			   {
				   System.out.println(inputElement.getText());
			   }
		   }
		

	}

}
