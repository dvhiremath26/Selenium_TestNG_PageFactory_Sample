package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.baseTest;
import Listeners.TestAllureReportListeners;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({TestAllureReportListeners.class})
public class scenario_01_Test extends baseTest{


	@Test(priority=1, description="Verifying the Simple Form Demo page URL contains 'simple-form-demo'")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verifying the Simple Form Demo page URL contains 'simple-form-demo'")
	public void validate_Simple_Form_Demo_URL() {		
		homePage.clickOnSimpleFormDemo();
		String actualURL = simpleFormPage.getURL();
		System.out.println("Simple Form Page URL is: " +actualURL);
		Assert.assertTrue(actualURL.contains("simple-form-demo"));

	}
	
	
	@Test(priority=2, description="Verifying the entered message in the simple form text box is displyed under Your message section")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verifying the entered message in the simple form text box is displyed under Your message section")
	public void validate_Entered_Message() {	
		homePage.clickOnSimpleFormDemo();
		simpleFormPage.enterMessage(prop.getProperty("MessageToBeEntered"));
		simpleFormPage.clickOnButton();
		String actualEnteredMsg = simpleFormPage.validateTheEnteredMessage();
		Assert.assertEquals(actualEnteredMsg, prop.getProperty("MessageToBeEntered"));
	}


}
