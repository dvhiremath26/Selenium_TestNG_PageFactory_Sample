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
	
	
	public void enterName(String nameText) {
		elementUtils.typeTextIntoElement(name, nameText);
	}
	
	
	public void enterEmail(String emailID) {
		elementUtils.typeTextIntoElement(email, emailID);
	}
	
	
	public void enterPassword(String pwd) {
		elementUtils.typeTextIntoElement(password, pwd);
	}
	
	public void enterCompany(String comp) {
		elementUtils.typeTextIntoElement(company, comp);
	}
	
	
	public void enterWebsite(String web) {
		elementUtils.typeTextIntoElement(website, web);
	}
	
	
	public void selectCountry(String countries) {
		elementUtils.selectFromDropDown(country, countries);
	}
	
	
	public void enterCity(String cityName) {
		elementUtils.typeTextIntoElement(city, cityName);
	}
	
	
	public void enterAddress1(String Add1) {
		elementUtils.typeTextIntoElement(address1, Add1);
	}
	
	
	public void enterAddress2(String Add2) {
		elementUtils.typeTextIntoElement(address2, Add2);
	}
	
	
	public void enterState(String stateName) {
		elementUtils.typeTextIntoElement(state, stateName);
	}
	
	
	public void enterZipcode(String zipcode) {
		elementUtils.typeTextIntoElement(zip, zipcode);
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
