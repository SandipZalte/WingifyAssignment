package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements  ITestListener {
	public void onStart(ITestContext result) {
		System.out.println("On Start");
		
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test has Started -->" + " " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success fully Completed--> " + " " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test has been Failed Please Chcek Screenshot Folder-->" +System.getProperty("user.dir") + " " + result.getName());
		utility.Util.TakeScreenshot(result.getName());
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test has been Failed due to timeout-->");
		

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has been Skipped -->" + " " + result.getName());
		
		}

	public void onFinish(ITestContext result) {
		System.out.println("on Finish");
	
		
		
		
	}

}
