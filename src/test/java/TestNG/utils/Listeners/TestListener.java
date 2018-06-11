package TestNG.utils.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import TestNG.framework.ReadProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import TestNG.tests.BaseTest;
import TestNG.utils.ExtentReports.ExtentManager;
import TestNG.utils.ExtentReports.ExtentTestManager;


public class TestListener extends BaseTest implements ITestListener{

	private static String getTestMethodName(ITestResult iTestResult) {
		
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public void onStart(ITestContext iTestContext) {
		ReadProperties.LoadAllConfig();
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", driver);
	}

	public void onFinish(ITestContext iTestContext) {
		System.out.println(iTestContext.getFailedTests());
		System.out.println("I am in onFinish method " + iTestContext.getName());
		//Do tier down operations for extentreports reporting!
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
		//Start operation for extentreports.
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
		//Extentreports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS, iTestResult.getMethod()+" : Test Passed!");
		if(System.getProperty("test.WebApp").equalsIgnoreCase("true")) {
			//Take base64Screenshot screenshot.
			String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
					getScreenshotAs(OutputType.BASE64);

			//Extentreports log and screenshot operations for failed tests.
			ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed",
					ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		}
	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

		//Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();
		if(System.getProperty("test.WebApp").equalsIgnoreCase("true")) {
			//Take base64Screenshot screenshot.
			String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
					getScreenshotAs(OutputType.BASE64);
			//Extentreports log and screenshot operations for failed tests.
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
					ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		}
		System.out.println(iTestResult.getThrowable());
		//Extentreports log and screenshot operations for failed tests.
		ExtentTestManager.getTest().log(LogStatus.FAIL,getTestMethodName(iTestResult)+" : \nTest Failed due to Exception: "+ iTestResult.getThrowable());
	}

	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
		//Extentreports log operation for skipped tests.
		// ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}
