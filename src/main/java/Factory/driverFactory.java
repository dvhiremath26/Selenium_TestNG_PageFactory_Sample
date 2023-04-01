package Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class driverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();


	// Returning the driver instance
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	// Initialize the browser and open the base URL
	public WebDriver driverSetUp(Properties prop) {

		String browsername = prop.getProperty("browser").toLowerCase();
		System.out.println("Browser name is " + browsername);

		optionsManager = new OptionsManager(prop);

		if(browsername.equals("chrome")){
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}

		else if(browsername.equals("edge")){
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		}

		else if(browsername.equals("firefox")){
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}

		else {
			System.out.println("Please pass the right browser name as chrome, edge, and firefox in the config properties file.");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}



	// Initializing the properties file to read the data from the object prop
	public Properties initProperties() {
		prop = new Properties();
		File file = new File("./src/test/resources/config/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
	}



	// Taking screenshot and converting into base64 output type
	public static String getScreenshot(String imageName) {

		TakesScreenshot ts = ((TakesScreenshot) getDriver());
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String destFile = "./screenshots/" + imageName + ".png";
		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		File screenshotFile = new File(destFile);
		byte[] bytes = null;
		try {
			bytes = FileUtils.readFileToByteArray(screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String base64Encoded = Base64.getEncoder().encodeToString(bytes);

		return base64Encoded;
	}

}
