package Utils;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver){
		this.driver = driver;
	}


	public WebElement waitForElement(WebElement element) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}


	public void clickOnElement(WebElement element) {
		while(true) {
			try {
				WebElement webElement = waitForElement(element);
				webElement.click();
				break;
			}catch(Exception e) {
				handlePopup();
			}
		}

	}


	public void typeTextIntoElement(WebElement element, String text) {
		while(true) {
			try {
				WebElement webElement = waitForElement(element);
				webElement.click();
				webElement.clear();
				webElement.sendKeys(text);
				break;
			}catch(Exception e) {
				handlePopup();
			}
		}

	}


	public String getTextFromElement(WebElement element) {
		WebElement webElement = waitForElement(element);
		return webElement.getText();
	}


	public boolean displayStatusOfElement(WebElement element) {
		try {
			WebElement webElement = waitForElement(element);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
	}


	public void selectFromDropDown(WebElement element, String dropDownOption) {
		while(true) {
			try {
				WebElement webElement = waitForElement(element);
				Select select = new Select(webElement);
				select.selectByVisibleText(dropDownOption);
				break;
			}catch(Exception e) {
				handlePopup();
			}
		}
		
	}


	public void mouseHover(WebElement element) {
		WebElement webElement = waitForElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).build().perform();
	}


	public void dragAndDropByAxis(WebElement element, int Xaxis, int Yaxis) {
		while(true) {
			try {
				WebElement webElement = waitForElement(element);
				Actions action = new Actions(driver);
				action.moveToElement(webElement);
				action.dragAndDropBy(webElement, Xaxis, Yaxis).build().perform();
				break;
			}catch(Exception e) {
				handlePopup();
			}
		}
		
	}


	public Alert waitForAlert() {
		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}


	public void acceptAlert() {
		Alert alert = waitForAlert();
		alert.accept();
	}


	public void dismissAlert() {
		Alert alert = waitForAlert();
		alert.dismiss();
	}


	public void handlePopup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('exit_popup_close').click();");
	}


}
