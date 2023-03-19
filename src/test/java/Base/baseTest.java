package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Factory.driverFactory;
import Pages.Home_Page;
import Pages.Simple_Form_Demo_Page;

public class baseTest {
	
	driverFactory df;
	WebDriver driver;
	
	protected Home_Page homePage;
	protected Simple_Form_Demo_Page simpleFormPage;
	
	
	@BeforeMethod
	public void initDriver() {
		df = new driverFactory();
		driver = df.driverSetUp();
		
		homePage = new Home_Page(driver);
		simpleFormPage = new Simple_Form_Demo_Page(driver);	               
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

}
