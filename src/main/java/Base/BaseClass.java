package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Listener;
import utility.WebEventListener;

//@Listeners(Listener.class)
@Listeners(utility.ExtentListenerClass.class)
@SuppressWarnings("deprecation")

public class BaseClass {
	protected static WebDriver driver;
	protected static Properties prop;
	static EventFiringWebDriver e_driver;
	public static utility.WebEventListener eventListener;
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/Config/Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initlization() {

		String browserName = prop.getProperty("Browser");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		  
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);			
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please enter the correct Browser Name");
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
				// EventFiringWebDriver
				eventListener = new WebEventListener();
				e_driver.register(eventListener);
				driver = e_driver;
				
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MILLISECONDS);
		String url=prop.getProperty("Url");
		driver.get(url);

	}
}
