package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;

public class scenario_02_Test extends baseTest {
	
	@Test
	public void validate_Dragged_Value() {
		homePage.clickOnDragSlider();
		String actualValue = slider.DragValue15(prop.getProperty("Xaxis"), prop.getProperty("Yaxis"));
		Assert.assertEquals(actualValue, prop.getProperty("DragValue"));
	}

}
