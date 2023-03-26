package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;
import Utils.constData;

public class scenario_03_Test extends baseTest{



	@Test
	public void validate_Error_Message() {
		homePage.clickOnInputFormSubmit();
		inputForm.clickOnSubmitButton();
		String actualMsg = inputForm.getErrorMessage();
		Assert.assertEquals(actualMsg, prop.getProperty("ErrorMessage"));		
	}


	@Test
	public void validate_Success_Message() {
		homePage.clickOnInputFormSubmit();
		inputForm.enterName(constData.name);
		inputForm.enterEmail(constData.emaiID);
		inputForm.enterPassword(constData.password);
		inputForm.enterCompany(constData.comapnyName);
		inputForm.enterWebsite(constData.website);
		inputForm.selectCountry("India");
		inputForm.enterCity(constData.cityName);
		inputForm.enterAddress1(constData.addrees01);
		inputForm.enterAddress2(constData.address02);
		inputForm.enterState(constData.stateName);
		inputForm.enterZipcode(constData.zipcode);
		inputForm.clickOnSubmitButton();
		String actualMsg = inputForm.getSuccessMessage();
		Assert.assertTrue(actualMsg.contains(prop.getProperty("SuccessMessage")));
		System.out.println(constData.website);
	}

}