package Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("-incognito");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.xpath("//a[normalize-space()='Input Form Submit']")).click();
		
				WebElement ele = driver.findElement(By.id("name"));
				ele.sendKeys("name");
				driver.findElement(By.id("inputEmail4")).sendKeys("email@test.com");
				driver.findElement(By.id("inputPassword4")).sendKeys("password");
				driver.findElement(By.id("company")).sendKeys("company");
				driver.findElement(By.name("website")).sendKeys("www.website.com");
				Thread.sleep(3000);
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				//wait.until(ExpectedConditions.invisibilityOf(ele));
				// Locate the hidden element
				//WebElement element = driver.findElement(By.id("exit_popup_close"));

				// Use JavaScriptExecutor to make the element visible
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.getElementById('exit_popup_close').click();");
				
				//js.executeScript("arguments[0].click();", element);
				//js.executeScript("arguments[0].style.visibility='visible'; arguments[0].style.height='auto';", element);

				// Click on the visible element
				//element.click();
 
			
		

	
}





}

