package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;
import io.qameta.allure.Step;

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
	
	@Step("Clicking on the Simple Form Demo link")
	public void clickOnSimpleFormDemo() {
		elementUtils.clickOnElement(simpleFormDemo);
	}
	
	@Step("Clicking on the Drag And Drop link")
	public void clickOnDragSlider() {
		elementUtils.clickOnElement(dragAndDroplink);
	}
	
	@Step("Clicking on the Input Form Submit link")
	public void clickOnInputFormSubmit() {
		elementUtils.clickOnElement(inputFormSubmit);
	}
}