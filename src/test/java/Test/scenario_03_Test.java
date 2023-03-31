package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.baseTest;
import Listeners.TestAllureReportListeners;
import Utils.constData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({TestAllureReportListeners.class})
public class scenario_03_Test extends baseTest{

	@Test(priority=4, description="Verifying the Input Form error message while submitting empty form.")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verifying the Input Form error message while submitting empty form.")
	public void validate_Error_Message() {
		homePage.clickOnInputFormSubmit();
		inputForm.clickOnSubmitButton();
		String actualMsg = inputForm.getErrorMessage();
		Assert.assertEquals(actualMsg, prop.getProperty("ErrorMessage"));	
	}


	@Test(priority=5, description="Verifying the success message after submitting the Input Form.")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verifying the success message after submitting the Input Form.")
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
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains(prop.getProperty("SuccessMessage")));		
	}

}