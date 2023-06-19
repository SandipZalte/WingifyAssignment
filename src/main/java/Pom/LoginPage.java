package Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseClass;

public class LoginPage extends BaseClass {

	// object Repository Or PageFactory

	@FindBy(xpath = "//div[@class='logo-w']//img")
	private WebElement logo;

	@FindBy(id = "username")
	// xpath = "//input [@placeholder='Enter your username']")
	private WebElement username;

	@FindBy(id = "password")
	// "//input [@placeholder='Enter your password']")
	private WebElement password;

	@FindBy(xpath = "//button[@id='log-in' and contains(text(),'Log In')]")
	private WebElement loginbutton;

	@FindBy(xpath = "//input[@class='form-check-input']")
	private WebElement checkbox;

	@FindBy(xpath = "//div[@id='random_id_8' and  contains(text(),'')]")
	WebElement errormsg;

	@FindBy(xpath = "//img[@src='img/twitter.png']")
	private WebElement twitter;

	@FindBy(xpath = "//img[@src='img/facebook.png']")
	private WebElement fb;

	@FindBy(xpath = "	//img[@src='img/linkedin.png']")
	private WebElement in;

	
	// Initializing the Page Objects

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	Page Action

	public String ValidateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean ValidateLogo() {
		return logo.isDisplayed();

	}

	public HomePage loginWithValidCreditals(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		return new HomePage();
	}

	public HomePage loginWithValidCreditalsWithCheckbox(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		checkbox.click();
		loginbutton.click();
		return new HomePage();
	}

	public String loginWithoutCreditals() {
		loginbutton.click();
		return "Both Username and Password must be present ";

	}

	public String loginWithOnlyUsername(String un) {
		username.sendKeys(un);
		loginbutton.click();
		return "Password must be present";
	}

	public String loginWithOnlyPassword(String pwd) {
		password.sendKeys(pwd);
		loginbutton.click();
		return "Username must be present";
	}

	public boolean displayTwitterImg() {
		return twitter.isDisplayed();
	}

	public boolean displayFacebookImg() {
		return fb.isDisplayed();

	}

	public boolean displaylinkedinImg() {
		return in.isDisplayed();
	}


}
