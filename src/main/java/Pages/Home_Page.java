package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class Home_Page {
	
	WebDriver driver;
	protected ElementUtils elementUtils;
	
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Simple Form Demo']")
	private WebElement simpleFormDemo;
	
	@FindBy(xpath = "//a[normalize-space()='Drag & Drop Sliders']")
	private WebElement dragAndDroplink;
	
	@FindBy(xpath = "//a[normalize-space()='Input Form Submit']")
	private WebElement inputFormSubmit;
	
	
	/////////////////////////////////////////////////////////////////////
	
	
	public void clickOnSimpleFormDemo() {
		elementUtils.clickOnElement(simpleFormDemo);
	}
	
	public void clickOnDragSlider() {
		elementUtils.clickOnElement(dragAndDroplink);
	}
	
	public void clickOnInputFormSubmit() {
		elementUtils.clickOnElement(inputFormSubmit);
	}
}