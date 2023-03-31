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
public class scenario_02_Test extends baseTest {
	
	@Test(priority=3, description="Verifying the slider is dragged to get the value 95")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verifying the slider is dragged to get the value 95")
	public void validate_Dragged_Value() {
		homePage.clickOnDragSlider();
		String actualValue = slider.DragValue15(prop.getProperty("Xaxis"), prop.getProperty("Yaxis"));
		Assert.assertEquals(actualValue, prop.getProperty("DragValue"));
	}

}
