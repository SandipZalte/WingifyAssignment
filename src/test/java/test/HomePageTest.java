package test;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.BaseClass;
import Pom.HomePage;
import Pom.LoginPage;
import bsh.util.Util;
import utility.Wait;

public class HomePageTest extends BaseClass {
	// Global Variable
	LoginPage loginPage;
	HomePage homePage;
	ExtentReports extent;
	ExtentTest test;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initlization();
		loginPage = new LoginPage();
		String Username = prop.getProperty("Username");
		String pwd = prop.getProperty("Username");
		loginPage.loginWithValidCreditals(Username, pwd);
		homePage = new HomePage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void testHomePagelogo() {
		Boolean flag = homePage.ValidateLogo();
		
		Assert.assertTrue(flag);

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {

		String Act = homePage.verfiyHomePageTitle();
		String Exp = "Demo App";
		Assert.assertEquals(Act, Exp, "Home Page Title is Mismatch");
	}

	@Test(priority = 2 ,dependsOnMethods ="verifyHomePageTitleTest" )
	public void testUserNameText() {

		String Exp = homePage.UserNameText();
		String Act = "John Doe";
		assertEquals(Act, Exp, " User Name Text is not Match");

	}

	@Test(priority = 3 ,dependsOnMethods ="testUserNameText")
	public void testTransactionsTable() {
		Boolean flag = homePage.transactionsTable();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4 ,dependsOnMethods="testTransactionsTable")
	public void AmountColValueTest() {
		String[] actualAmtCol = homePage.getColEle();

		String[] ExpctedAmtCol = { "- 244.00 USD", "+ 340.00 USD", "+ 1,250.00 USD", "+ 952.23 USD", "- 320.00 USD",
				"+ 17.99 USD" };

		System.out.println(Arrays.toString(actualAmtCol));
		System.out.println("ExpctedAmtCol-->" + Arrays.toString(ExpctedAmtCol));

		Assert.assertEqualsNoOrder(actualAmtCol, ExpctedAmtCol,
				"Amount Column Value is Not present OR correct Amount Column Value");
	}

	@Test(priority = 5 ,dependsOnMethods ="testTransactionsTable")
	public void sortAmtColValueTest() {
		/*
		 * Sort using Utility class Method Expected Sorted value
		 */

		String[] expectedAmtColValue = homePage.getSortedColumnValue();
		System.out.println("expectedAmtColValue-->" + Arrays.toString(expectedAmtColValue));

		// After click on the Amount Element

		homePage.clickTheAmt();
		/*
		 * Actual Sorted value
		 */
		String[] actualAmtColValue = homePage.getActualSortedColEle();
		System.out.println("actualAmtColValue-->" + Arrays.toString(actualAmtColValue));

		Assert.assertEquals(actualAmtColValue, expectedAmtColValue, "Amount column are Not Sorted");

	}

}
