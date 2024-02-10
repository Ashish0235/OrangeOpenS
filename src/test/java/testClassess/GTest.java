package testClassess;

import org.testng.annotations.Test;

import base.BaseClass;

public class GTest extends BaseClass {
	
	@Test
	
	public void test() {
		
		LoginTest test = new LoginTest();
		test.login();
	}

}
