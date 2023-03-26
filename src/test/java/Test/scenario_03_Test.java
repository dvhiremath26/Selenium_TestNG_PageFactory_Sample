package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;

public class scenario_03_Test extends baseTest{



	@Test
	public void validate_Error_Message() {
		homePage.clickOnInputFormSubmit();
		inputForm.clickOnSubmitButton();
		String actualMsg = inputForm.getErrorMessage();
		Assert.assertEquals(actualMsg, "Please fill out this field.");		
	}


	@Test
	public void validate_Success_Message() {
		homePage.clickOnInputFormSubmit();
		inputForm.enterName();
		inputForm.enterEmail();
		inputForm.enterPassword();
		inputForm.enterCompany();
		inputForm.enterWebsite();
		inputForm.selectCountry();
		inputForm.enterCity();
		inputForm.enterAddress1();
		inputForm.enterAddress2();
		inputForm.enterState();
		inputForm.enterZipcode();
		inputForm.clickOnSubmitButton();
		String actualMsg = inputForm.getSuccessMessage();
		Assert.assertTrue(actualMsg.contains("Thanks for contacting us"));
	}

}