package testClassess;

import org.testng.annotations.Test;

import base.BaseTest;
import pageConstants.PunchInPunchOut;
import pageObjects.PunchInPunchOut_Page;

public class PunchInPunchOut_Test extends BaseTest implements PunchInPunchOut {
	

	PunchInPunchOut_Page time = new PunchInPunchOut_Page();
	
	@Test
	
	public void InAndOutPunch() throws InterruptedException {
		
		logger.info("Current status of punching:- "+time.punchInOutforCheck());
		
		time.clockButton();
		time.notedetails();
		time.Button();
		driver.navigate().back();
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(500);
		logger.info("Punching out time is:- "+time.punchInOutforCheck());
	}

}
