package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.ElementUtils;
import io.qameta.allure.Step;

public class Simple_Form_Demo_Page {

	WebDriver driver;
	protected ElementUtils elementUtils;
	
	
	public Simple_Form_Demo_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "user-message")
	private WebElement textBox;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	private WebElement getCheckedValueButton;

	@FindBy(xpath = "//div[@id='user-message']//p[@id='message']")
	private WebElement displayedMessage;
	
	///////////////////////////////////////////////////////////////////
	
	@Step("Getting Simple Form Demo page URL")
	public String getURL() {
		return driver.getCurrentUrl();		
	}

	@Step("Entering message: {0} into the Enter Message field")
	public void enterMessage(String text) {
		elementUtils.typeTextIntoElement(textBox, text);
	}

	@Step("Clicking on the Get Checked Value button")
	public void clickOnButton() {
		elementUtils.clickOnElement(getCheckedValueButton);
	}
	
	@Step("verifying the entered message is displayed under Your Message section.")
	public String validateTheEnteredMessage() {
		return elementUtils.getTextFromElement(displayedMessage);	
	}

}
