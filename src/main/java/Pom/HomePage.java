package Pom;

import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.*;

import Base.BaseClass;
import utility.CompareAndSort;

public class HomePage extends BaseClass {
	
	//Page Factory or Object Repository
	@FindBy(xpath = "//div[@class='logo-element']")
	private WebElement logo;
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
		int len=amtColEle.size();

		for (int i = 0; i < len; i++) {
			ColEle[i] = amtColEle.get(i).getText().trim();
			// System.out.println("fetech Amt_Col_Ele->"+ ColEle[i]);
		}
		return ColEle;
	}

	public void clickTheAmt() { // Click the Amt Header
		amountEle.click();
	}

	public String[] getActualSortedColEle() { // Get the Actual Sorted Col Ele
		String[] actual;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
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

	public String[] getExpectedColEleSorted() {// Sort as Expected Col Ele
		String[] expected = new String[amtColEle.size()];

		for (int i = 0; i < amtColEle.size(); i++) {
			expected[i] = amtColEle.get(i).getText();
		}

		for (String j : expected) {
//			System.out.println("Unsorted List ->");
//			System.out.println(j);
		}

		Arrays.sort(expected, new Comparator<String>() {

			public int compare(String o1, String o2) {
				String no1 = o1.replaceAll("[a-zA-Z,\\s]", "");
				String no2 = o2.replaceAll("[a-zA-Z, \\s]", "");
				double num1 = Double.parseDouble(no1);
				double num2 = Double.parseDouble(no2);

				if (num1 < num2)
					return -1;
				else if (num1 > num2)
					return 1;
				return 0;
			}
		});
		return expected;

		// System.out.println("Expected List "+Arrays.toString(expected));

	
	}
	public String[] getSortedColumnValue() {
		String[] list = new String[amtColEle.size()];
		list=CompareAndSort.Comparator_To_SORT(amtColEle);
		return list;
		
		
	
		
		
	}

}
