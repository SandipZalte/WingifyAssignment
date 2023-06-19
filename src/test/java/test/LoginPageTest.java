package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.BaseClass;
import Pom.HomePage;
import Pom.LoginPage;


public class LoginPageTest extends BaseClass {

	static ExtentReports extent;
	static ExtentTest test;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {

		initlization();
		loginPage = new LoginPage();
	}
	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

	@Test(priority = 0)
	public void testLoginPageTitle() {
		String Exp = loginPage.ValidateLoginPageTitle();
		String Act = "Demo App";
		Assert.assertEquals(Act, Exp, "Title Not Match");

	}

	@Test(priority = 1)
	public void testLoginPageLogo() {
		boolean ExpLogo = loginPage.ValidateLogo();
		Assert.assertTrue(ExpLogo);
	}

	@Test(priority = 2)
	public void testLoginWithValidCreditals() {
		String uername = prop.getProperty("Username");
		String password = prop.getProperty("Password");
		homePage = loginPage.loginWithValidCreditals(uername, password);
	}

	@Test(priority = 0)
	public void testLoginValidCreditalsWithCheckbox() {

		String uername = prop.getProperty("Username");
		String password = prop.getProperty("Password");
		homePage = loginPage.loginWithValidCreditalsWithCheckbox(uername, password);

	}

	@Test(priority = 0)
	public void testLoginWithoutCreditals() {

		String Act = loginPage.loginWithoutCreditals();
		String Exp = "Both Username and Password must be present ";
		Assert.assertEquals(Act, Exp, "Error Msg is Missmatch");

	}

	@Test(priority = 0)
	public void testLoginWithOnlyUsername() {

		String Exp = loginPage.loginWithOnlyUsername(prop.getProperty("Username"));
		String Act = "Password must be present";
		Assert.assertEquals(Act, Exp, "Error Msg is Missmatch");

	}

	@Test(priority = 0)
	public void testLoginWithOnlyPassword() {

		String Exp = loginPage.loginWithOnlyPassword(prop.getProperty("Password"));
		String Act = "Username must be present";
		Assert.assertEquals(Act, Exp, "Error Msg is Missmatch");

	}

	@Test(priority = 0)
	public void testDisplayTwitterImg() {
		boolean Exp = loginPage.displayTwitterImg();
		Assert.assertTrue(Exp);
	}

	@Test(priority = 0)
	public void testDisplayFacebookImg() {
		boolean Exp = loginPage.displayFacebookImg();
		Assert.assertTrue(Exp);
	}

	@Test(priority = 0)
	public void TestDisplaylinkedinImg() {
		boolean Exp = loginPage.displaylinkedinImg();
		Assert.assertTrue(Exp);
	}
}
