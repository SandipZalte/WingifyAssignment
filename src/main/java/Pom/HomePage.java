package Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import utility.Util;
import utility.Wait;

public class HomePage extends BaseClass {
	
	//Page Factory or Object Repository
	@FindBy(xpath = "//div[@class='logo-element']")
	private WebElement logo;
	//a[@class="logo"]
	@FindBy(xpath = "//table[@id='transactionsTable']")
	private WebElement transactionsTable;
	@FindBy(id = "amount")
	private WebElement amountEle;
	@FindBy(xpath = "//td[@class='text-right bolder nowrap']")
	private WebElement colvalue;
	@FindBy(xpath = "//table[@id='transactionsTable']/tbody/tr/td[5]")
	private List<WebElement> amtColEle;
	
	@FindBy(xpath = "//div[@id='logged-user-name' and contains(text(),'John Doe')]")
	private WebElement username;
	
	
	// HomePage constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Page Action
	public String verfiyHomePageTitle() {
		
		return driver.getTitle();
	}

	public boolean ValidateLogo() {
		
		return logo.isDisplayed();

	}

	public String UserNameText() {
		
		return username.getText();

	}

	
	public boolean transactionsTable() { // validate Tran.Table
		boolean table = transactionsTable.isDisplayed();
		
		return table;

	}

	public String[] getColEle() { // get as it Amt Col Ele value
		String[] ColEle = new String[amtColEle.size()];
		Wait.waitUntilvisibilityOfAllElements(30, amtColEle);
		int len=amtColEle.size();

		for (int i = 0; i < len; i++) {
			ColEle[i] = amtColEle.get(i).getText().trim();
			// System.out.println("fetech Amt_Col_Ele->"+ ColEle[i]);
		}
		return ColEle;
	}

	public void clickTheAmt() { // Click the Amt Header
		
		amountEle.click();
		Wait.waitUntilvisibilityOfAllElements(20, amtColEle);
	}
	// Get the Actual Sorted Col Ele

	public String[] getActualSortedColEle() { 		String[] actual;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(transactionsTable));

		// get All the Element and Store in List
		actual = new String[amtColEle.size()];

		for (int i = 0; i < amtColEle.size(); i++) {
			actual[i] = amtColEle.get(i).getText();
		}

		// Printing sorted List using for each loop
		for (String k : actual) {
			// System.out.println("Actual List-->"+k);
		}
		return actual;
	}


	public String[] getSortedColumnValue() {
		Wait.waitUntilvisibilityOfAllElements(30, amtColEle);
		String[] list = new String[amtColEle.size()];
		
		list=Util.Comparator_To_SORT(amtColEle);
		return list;
		
		
	
		
		
	}

}
