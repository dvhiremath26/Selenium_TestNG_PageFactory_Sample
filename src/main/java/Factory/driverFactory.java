package Factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class driverFactory {

	private WebDriver driver;
	Properties prop;


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




}

