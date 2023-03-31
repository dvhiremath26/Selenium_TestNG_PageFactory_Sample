package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtils;
import io.qameta.allure.Step;

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
	
	@FindBy(css = ".success-msg.hidden")
	private WebElement successMessage;
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	@Step("Entering name: {0} into the Name field")
	public void enterName(String nameText) {
		elementUtils.typeTextIntoElement(name, nameText);
	}
	
	@Step("Entering email id: {0} into the Email field")
	public void enterEmail(String emailID) {
		elementUtils.typeTextIntoElement(email, emailID);
	}
	
	@Step("Entering password: {0} into the Password field")
	public void enterPassword(String pwd) {
		elementUtils.typeTextIntoElement(password, pwd);
	}
	
	@Step("Entering company: {0} into the Company field")
	public void enterCompany(String comp) {
		elementUtils.typeTextIntoElement(company, comp);
	}
	
	@Step("Entering website: {0} into the Website field")
	public void enterWebsite(String web) {
		elementUtils.typeTextIntoElement(website, web);
	}
	
	@Step("Selecting the country: {0} from the Country drop down")
	public void selectCountry(String countries) {
		elementUtils.selectFromDropDown(country, countries);
	}
	
	@Step("Entering city: {0} into the City field")
	public void enterCity(String cityName) {
		elementUtils.typeTextIntoElement(city, cityName);
	}
	
	@Step("Entering address1: {0} into the Address1 field")
	public void enterAddress1(String Add1) {
		elementUtils.typeTextIntoElement(address1, Add1);
	}
	
	@Step("Entering address2: {0} into the Address2 field")
	public void enterAddress2(String Add2) {
		elementUtils.typeTextIntoElement(address2, Add2);
	}
	
	@Step("Entering state: {0} into the State field")
	public void enterState(String stateName) {
		elementUtils.typeTextIntoElement(state, stateName);
	}
	
	@Step("Entering zipcode: {0} into the Zipcode field")
	public void enterZipcode(String zipcode) {
		elementUtils.typeTextIntoElement(zip, zipcode);
	}
	
	@Step("Clicking on the Submit button")
	public void clickOnSubmitButton() {
		elementUtils.clickOnElement(submitButton);
	}
	
	@Step("Getting error message on submitting empty form.")
	public String getErrorMessage() {
		return name.getAttribute("validationMessage");
	}
	
	@Step("Getting success message by submitting Input Form.")
	public String getSuccessMessage() {
		return elementUtils.getTextFromElement(successMessage);
	}
	
	
	

}
