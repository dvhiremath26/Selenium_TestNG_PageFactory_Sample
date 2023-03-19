package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Simple_Form_Demo_Page {

	WebDriver driver;

	public Simple_Form_Demo_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-message")
	private WebElement textBox;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	private WebElement getCheckedValueButton;

	@FindBy(xpath = "//div[@id='user-message']//p[@id='message']")
	private WebElement displayedMessage;





	public String getURL() {
		return driver.getCurrentUrl();		
	}


	public void enterMessage() {
		textBox.sendKeys("Welcome to LambdaTest");
	}

	public void clickOnButton() {
		getCheckedValueButton.click();
	}

	public String validateTheEnteredMessage() {
		return displayedMessage.getText();
		
	}



}
