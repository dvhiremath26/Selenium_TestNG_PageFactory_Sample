package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.ElementUtils;


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
		
	public String DragValue15() {
		elementUtils.dragAndDropByAxis(value15, 118, 0);
		return elementUtils.getTextFromElement(draggedValue);
//		Actions action = new Actions(driver);
//		action.moveToElement(value15);
//		action.dragAndDropBy(value15, 118, 0).build().perform();
//		return draggedValue.getText();
	}

}
