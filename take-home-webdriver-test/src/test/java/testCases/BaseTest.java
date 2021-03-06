package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Utils;
import org.testng.annotations.BeforeClass;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;

public class BaseTest {
	//https://github.com/swtestacademy?tab=repositories
	public WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		String baseDir = System.getProperty(Utils.USER_DIR);
		String browserDriver = baseDir + Utils.DRIVER_PATH;
		System.setProperty(Utils.WEB_DRIVER_PATH, browserDriver);
		
		//Only for Download file 
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
		//
		driver = new ChromeDriver(options); //options
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(Utils.BASE_URLS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Method is passing!");
		
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
		
	}
	//Global Sleep
	public static void sleepTest(long sleeptime) {
		try {Thread.sleep(sleeptime);
		}catch(Exception e) {
			}
		}
	
	//Global switchIframe
	public int switchIframe(int number) {
		driver.switchTo().frame(number); 
		return number;
		
	}
	
	//https://stackoverflow.com/questions/51176912/capture-console-error-using-javascriptexecutor-class-in-selenium
	//Global JavaScript application console error message
	public void javascriptConsoleError() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
		    System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		}
	}
}
