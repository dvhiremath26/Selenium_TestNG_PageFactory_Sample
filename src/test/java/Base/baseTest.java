package Base;

import java.util.Properties;

import javax.management.ConstructorParameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Factory.driverFactory;
import Pages.Home_Page;
import Pages.InputFormPge;
import Pages.Simple_Form_Demo_Page;
import Pages.SliderPage;
import Factory.driverFactory;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;


public class baseTest {
	
	driverFactory df;
	public WebDriver driver;
	public Properties prop;
	
	protected Home_Page homePage;
	protected Simple_Form_Demo_Page simpleFormPage;
	protected SliderPage slider;
	protected InputFormPge inputForm;
	
	
	@Parameters("browser")
	@Step("Start the application")
	@BeforeMethod
	public void initDriver(String browser) {
		df = new driverFactory();
		prop = df.initProperties();

		if(browser!=null){
			prop.setProperty("browser", browser);
		}

		driver = df.driverSetUp(prop);
		
		homePage = new Home_Page(driver);
		simpleFormPage = new Simple_Form_Demo_Page(driver);	   
		slider = new SliderPage(driver);
		inputForm = new InputFormPge(driver);

	}
	
	@AfterMethod
	public void closeDriver() {
		driverFactory.getDriver().quit();
	}
	
}
