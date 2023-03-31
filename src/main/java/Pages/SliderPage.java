package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.ElementUtils;
import io.qameta.allure.Step;


public class SliderPage {
	
	WebDriver driver;
	protected ElementUtils elementUtils;
	
	

	public SliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);			
	}
	
	
	
	@FindBy(xpath = "//input[@value='15']")
	private WebElement value15;
	
	
	@FindBy(xpath = "//div[@class='sp__range sp__range-success']//output")
	private WebElement draggedValue;
	
	///////////////////////////////////////////////////////////////////////////
	
	@Step("Verifying the slider is dragged to get the value 95.")
	public String DragValue15(String Xaxis, String Yaxis) {
		elementUtils.dragAndDropByAxis(value15, Integer.parseInt(Xaxis), Integer.parseInt(Yaxis));
		return elementUtils.getTextFromElement(draggedValue);
	}

}
