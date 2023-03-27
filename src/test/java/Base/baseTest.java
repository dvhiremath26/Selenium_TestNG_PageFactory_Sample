package Base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import Factory.driverFactory;
import Pages.Home_Page;
import Pages.InputFormPge;
import Pages.Simple_Form_Demo_Page;
import Pages.SliderPage;

public class baseTest {
	
	driverFactory df;
	protected WebDriver driver;
	public Properties prop;
	
	protected Home_Page homePage;
	protected Simple_Form_Demo_Page simpleFormPage;
	protected SliderPage slider;
	protected InputFormPge inputForm;
	
	
	@BeforeMethod
	public void initDriver() {
		df = new driverFactory();
		prop = df.initProperties();
		driver = df.driverSetUp(prop);
		
		homePage = new Home_Page(driver);
		simpleFormPage = new Simple_Form_Demo_Page(driver);	   
		slider = new SliderPage(driver);
		inputForm = new InputFormPge(driver);
		
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
}
