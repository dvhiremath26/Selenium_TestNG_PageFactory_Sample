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
import org.openqa.selenium.chrome.ChromeOptions;


public class driverFactory {

	public static WebDriver driver;
	Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();


	// Returning the driver instance
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	// Initialize the browser and open the base URL
	public WebDriver driverSetUp(Properties prop) {
		ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("-incognito");
		opt.addArguments("disable-popup-blocking");
		opt.addArguments("--start-maximized");
		opt.addArguments("--headless");
		opt.addArguments("window-size=1280,720");

		// driver = new ChromeDriver(opt);
		tlDriver.set(new ChromeDriver(opt));
		// getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
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
