package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;

public class scenario_01_Test extends baseTest{
	
	

	@Test
	public void validate_Simple_Form_Demo_URL() {		
		
		homePage.clickOnSimpleFormDemo();
		String actualURL = simpleFormPage.getURL();
		Assert.assertEquals(actualURL, "https://www.lambdatest.com/selenium-playground/simple-form-demo");

	}
	
	
	@Test
	public void validate_Entered_Message() {	
		homePage.clickOnSimpleFormDemo();
		simpleFormPage.enterMessage();
		simpleFormPage.clickOnButton();
		String actualEnteredMsg = simpleFormPage.validateTheEnteredMessage();
		Assert.assertEquals(actualEnteredMsg, "Elcome to LambdaTest");
	}



}
