package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;


/**
 * 
 * @author Admin
 * Implcit wait class 
 *
 */
public class Wait extends BaseClass {
	
	public static WebElement waitVisibilityOfAllElements(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}
	public static WebElement waitAlertIsPresent(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.alertIsPresent());
		return element;
	}
	public static WebElement waitElementToBeClickable(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	public static WebElement waitElementToBeSelected(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		return element;
	}
	public static WebElement waitFrameToBeAvailableAndSwitchToIt(int timeInMillsec,WebElement framelocatorelement)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocatorelement));
		return framelocatorelement;
	}
	public static By waitVisibilityOfElementLocated(int timeInMillsec,By element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return element;
	}
	public static WebElement waitVisibilityOfElementLocated(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public static String waitVisibilityOftitleIs(int timeInMillsec,String title)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.titleIs(title));
		return title;
	}
	public static WebElement waitVisibilityOfElement(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public static WebElement waitUntilTextToBePresentInElementValue(int timeInMillsec,WebElement element,String text)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		return element;
	}
	public static List<WebElement> waitUntilvisibilityOfAllElements(int timeInMillsec,List<WebElement>element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}
	public static boolean waitElementSelectionStateToBe(int timeInMillsec,WebElement element)
	{
		WebDriverWait wait= new  WebDriverWait(driver, Duration.ofMillis(timeInMillsec));
		return wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
		 
	}

}
