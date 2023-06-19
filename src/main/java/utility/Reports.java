package utility;

import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.Status;

public class Reports {

	static ExtentReports extent;
	static ExtentTest test;
	static ITestResult result;
	

	public static ExtentReports GenrateReports(String EnterReportName) { // Write in @BeforeTest

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(EnterReportName + ".html");
		extent = new ExtentReports(); // also known as Engine
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Machine", "LenvoG50"); // add the System info like Build, system,tester
		extent.setSystemInfo("Env", "Testing");
		extent.setSystemInfo("Testing On", "Zeroda Project");
		extent.setSystemInfo("Build", "Functionl");
		extent.setSystemInfo("Tester", "Sandip");
		return extent;

	}

//	public static void TestName(String EnterMethodName) { // Write in @Test
//		test = extent.createTest(EnterMethodName);
//	}
	public static ExtentTest TestName(String EnterMethodName) { // Write in @Test
		return test = extent.createTest(EnterMethodName);
	}
	

	public static void PostExcution(ITestResult result) { // Write @AfterMethod
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, result.getName());
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			
		} else {

			test.log(Status.SKIP, result.getName());
		}
		

	}

	public static void PublishReport() { // Write @AfterTest
		extent.flush();
	}

}
