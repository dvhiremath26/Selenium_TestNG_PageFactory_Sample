package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;

public class InputFormPge {
	
	WebDriver driver;
	protected ElementUtils elementUtils;
	
	
	public InputFormPge (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	@FindBy(css = "#name")
	private WebElement name;
	
	@FindBy(css = "#inputEmail4")
	private WebElement email;
	
	@FindBy(css = "#inputPassword4")
	private WebElement password;
	
	@FindBy(css = "#company")
	private WebElement company;
	
	@FindBy(name = "website")
	private WebElement website;
	
	@FindBy(css = "select[name='country']")
	private WebElement country;
	
	@FindBy(css = "#inputCity")
	private WebElement city;
	
	@FindBy(css = "#inputAddress1")
	private WebElement address1;
	
	@FindBy(css = "#inputAddress2")
	private WebElement address2;
	
	@FindBy(css = "#inputState")
	private WebElement state;
	
	@FindBy(css = "#inputZip")
	private WebElement zip;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//p[@class='success-msg hidden']")
	private WebElement successMessage;
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	
	public void enterName() {
		elementUtils.typeTextIntoElement(name, "nameText");
	}
	
	
	public void enterEmail() {
		elementUtils.typeTextIntoElement(email, "email@test.com");
	}
	
	
	public void enterPassword() {
		elementUtils.typeTextIntoElement(password, "Test@123");
	}
	
	public void enterCompany() {
		elementUtils.typeTextIntoElement(company, "Testing");
	}
	
	
	public void enterWebsite() {
		elementUtils.typeTextIntoElement(website, "www.testing.com");
	}
	
	
	public void selectCountry() {
		elementUtils.selectFromDropDown(country, "India");
	}
	
	
	public void enterCity() {
		elementUtils.typeTextIntoElement(city, "Bengaluru");
	}
	
	
	public void enterAddress1() {
		elementUtils.typeTextIntoElement(address1, "Bengaluru 01");
	}
	
	
	public void enterAddress2() {
		elementUtils.typeTextIntoElement(address2, "Bengaluru 02");
	}
	
	
	public void enterState() {
		elementUtils.typeTextIntoElement(state, "Karnataka");
	}
	
	
	public void enterZipcode() {
		elementUtils.typeTextIntoElement(zip, "560060");
	}
	
	
	public void clickOnSubmitButton() {
		elementUtils.clickOnElement(submitButton);
	}
	
	
	public String getErrorMessage() {
		return name.getAttribute("validationMessage");
	}
	
	
	public String getSuccessMessage() {
		return elementUtils.getTextFromElement(successMessage);
	}
	
	
	

}
