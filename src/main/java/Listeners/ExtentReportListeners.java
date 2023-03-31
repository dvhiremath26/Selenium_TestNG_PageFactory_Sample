package Listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Factory.driverFactory;



public class ExtentReportListeners extends driverFactory implements ITestListener{

	public static final String OUTPUT_FOLDER = "./reports/";
	public static final String FILE_NAME = "TestExecutionReport.html";
	//public static Object summary = new Object();

	private static ExtentReports extent = getReporterObject();
	private static ExtentReports extentReports;
	private static ExtentTest test;
	


	private static ExtentReports getReporterObject() {
		Path path = Paths.get(OUTPUT_FOLDER);
		if(!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		reporter.config().setReportName("LambdaTest Automation Test Results");

		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Author", "Deepak");
		//extentReports.setSystemInfo("Build#", "1.1");
		//extentReports.setSystemInfo("Team", "LTIM QA Team");
		extentReports.setSystemInfo("Customer Name", "P&G");

		return extentReports;
	}


	//	public static ExtentReports getReporterObject() {
	//		String path = "./Reports/extentTestReport.html";
	//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	//		reporter.config().setReportName("LambdaTest Playground Automation");
	//		reporter.config().setDocumentTitle("Test Results");
	//		
	//		ExtentReports extent = new ExtentReports();
	//		extent.attachReporter(reporter);
	//		extent.setSystemInfo("Tester", "Deepak");
	//		return extent;		
	//	}



	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Started!");

		test = extent.createTest(methodName);
	}


	@Override
	public void onTestSuccess(ITestResult result) {
	}


	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String base64imagePath = driverFactory.getScreenshot(methodName);
		test.fail( methodName + result.getThrowable() + " Test Failed!");
		test.addScreenCaptureFromBase64String(base64imagePath);

		//String imagePath = driverFactory.getScreenshotFile(methodName);
		//test.addScreenCaptureFromPath(imagePath);
		//		test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());

		//test.fail(MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		//Reporter.log("<br><img src='" + imagePath + "' height='800' width='800'/><br>");
		//test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}


	@Override
	public void onTestSkipped(ITestResult result) {
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}


	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}


	@Override
	public void onStart(ITestContext context) {
	}


	@Override
	public void onFinish(ITestContext context) {
		IResultMap passedTests = context.getPassedTests();
		IResultMap failedTests = context.getFailedTests();
		int passedCount = passedTests.size();
		int failedCount = failedTests.size();
		
		
		
		String summary = ("LambdaTest Test Summary:\n" 
				+ "Test Passed: " + passedCount +"\n"
				+"Test Failed: " + failedCount );
		//sendSMSTestReport(summary);
		//sendWATestReport(summary);
		System.out.println(summary);
		
		extent.flush();
	}


	

}
