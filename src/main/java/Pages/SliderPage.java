package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@value='15']")
	private WebElement value15;
	
	
	@FindBy(xpath = "//div[@class='sp__range sp__range-success']//output")
	private WebElement draggedValue;
	
	///////////////////////////////////////////////////////////////////////////
	
	public SliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String DragValue15() {
		Actions action = new Actions(driver);
		action.moveToElement(value15);
		action.dragAndDropBy(value15, 118, 0).build().perform();
		return draggedValue.getText();
	}

}
