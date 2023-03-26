package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;

public class scenario_01_Test extends baseTest{
	
	

	@Test
	public void validate_Simple_Form_Demo_URL() {		
		
		homePage.clickOnSimpleFormDemo();
		String actualURL = simpleFormPage.getURL();
		Assert.assertTrue(actualURL.contains(prop.getProperty("SimpleFormURL")));

	}
	
	
	@Test
	public void validate_Entered_Message() {	
		homePage.clickOnSimpleFormDemo();
		simpleFormPage.enterMessage(prop.getProperty("MessageToBeEntered"));
		simpleFormPage.clickOnButton();
		String actualEnteredMsg = simpleFormPage.validateTheEnteredMessage();
		Assert.assertEquals(actualEnteredMsg, prop.getProperty("MessageToBeEntered"));
	}



}
