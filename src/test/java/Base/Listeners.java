//package Base;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.io.FileHandler;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.google.common.io.Files;
//
//import Factory.driverFactory;
//import Resources.ExtentReporteListeners;
//
//
//public class Listeners extends driverFactory implements ITestListener{
//
//	ExtentTest test;
//	ExtentReports extent = ExtentReporteListeners.getReporterObject();
//
//	@Override
//	public void onTestStart(ITestResult result) {
//		test = extent.createTest(result.getMethod().getMethodName());
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, "Test Passed");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		test.fail(result.getThrowable());
//		
//		try {
//			//driver = ((baseTest) result.getInstance()).driver;
//			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		} 
//		
//		String filePath = null;
//		try {
//			filePath = driverFactory.getScreenshot(result.getMethod().getMethodName(), driver);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
//		Reporter.log("<br><img src='" + filePath + "' height='400' width='700'/><br>");
//////////////////////////////////		
////		System.out.println("Test Failed: " + result.getName());
////        driver = ((baseTest) result.getInstance()).driver;
////        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////        String screenshotPath = "./Screenshots/" + result.getName() + ".png";
////        try {
////        	Files.copy(screenshotFile, screenshotPath);
////            //FileHandler.copy(screenshotFile, new File(screenshotPath));
////            Reporter.log("<br><img src='" + screenshotPath + "' height='400' width='700'/><br>");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        test.addScreenCaptureFromPath(screenshotPath);
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		extent.flush();
//	}
//	
//	
//
//
//}
