package test;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Table extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://sakshingp.github.io/assignment/home.html");
		Thread.sleep(1000);

		List<WebElement> amtEle=driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]"));
		
		// get the All Element list before clicking 
		String [] expected=new String [amtEle.size()];
		
		
		for (int i = 0; i < amtEle.size(); i++) {
			expected[i] = amtEle.get(i).getText();
		}
		
		for(String j:expected) 
		{
			System.out.println("Unsorted List ->");
			System.out.println(j);
			}
			
			Arrays.sort(expected,new Comparator<String >() {

				public int compare(String o1, String o2) {
					String no1= o1.replaceAll("[a-zA-Z,\\s]","");
					String no2 = o2.replaceAll("[a-zA-Z, \\s]","");
					double num1 = Double.parseDouble(no1);
					double num2 = Double.parseDouble(no2);

					if (num1 < num2) return -1;
					else if (num1 > num2) return 1;
					return 0;
				}
			});

			System.out.println("Expected List "+Arrays.toString(expected));
			
		
		System.out.println("-------------------------------------------");
		// Click on Amount Element 
		driver.findElement(By.xpath("//table[@id='transactionsTable']/thead/tr/th[5]")).click();

		// Capture all the Element into list   --> Orginal 
		amtEle=driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]"));

		String[] actual = new String[amtEle.size()];

		for (int i = 0; i < amtEle.size(); i++) {
			actual[i] = amtEle.get(i).getText();
		}

		// Printing  sorted List using for each loop
		for (String k : actual) {
			System.out.println(" Actual List-->"+k);
		}
		
		
		Assert.assertEquals(actual, expected, "Given List Is UnSorted" );
	

	}
}
