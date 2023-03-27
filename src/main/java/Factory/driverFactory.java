package Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.reporter.configuration.util.IOUtil;


public class driverFactory {

	protected static WebDriver driver;
	Properties prop;
	
	public static WebDriver getBrowserInstance()
	{
		return driver;	
	}


	public WebDriver driverSetUp(Properties prop) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("-incognito");
		opt.addArguments("disable-popup-blocking");

		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));		

		return driver;
	}


	public Properties initProperties() {
		prop = new Properties();
		File file = new File("./Resources\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;

	}
	
	
	
	public String getScreenshotFile(String imageName) {
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String destFile = "./screenshots/" + imageName + ".png";
		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return destFile;
	}
	
	public String getScreenshotBase64(String imageName) {
		TakesScreenshot ts = ((TakesScreenshot)driver);
		String srcFile = ts.getScreenshotAs(OutputType.BASE64);
		String destFile = "./screenshots/" + imageName + ".jpg";
		try {
			FileUtils.copyFile(new File(srcFile), new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return destFile;
	}
	
	
	
}

