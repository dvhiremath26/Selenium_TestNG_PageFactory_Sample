package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public WebDriver driver;
	
	
	@FindBy(xpath = "//a[normalize-space()='Simple Form Demo']")
	private WebElement simpleFormDemo;
	
	@FindBy(xpath = "//a[normalize-space()='Drag & Drop Sliders']")
	private WebElement dragAndDroplink;
	
	
	/////////////////////////////////////////////////////////////////////
	
		
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnSimpleFormDemo() {
		simpleFormDemo.click();
	}
	
	public void clickOnDragSlider() {
		dragAndDroplink.click();
	}
	
}