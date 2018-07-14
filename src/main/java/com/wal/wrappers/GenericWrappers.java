package com.wal.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.DataProvider;

import com.wal.util.TestUtil;
import com.wal.util.WebEventListener;

public class GenericWrappers implements wrappers{
	
	public static WebDriver driver;
	public static Properties prop;
	public static String sUrl;
	public static String sUsername;
	public static String sPassword;
	public static String sBrowser;
	public static String datasheet;
	public static EventFiringWebDriver e_driver;
	public static String sHub;
	public static String sMode;
	
	public GenericWrappers(){
		 try {
			 prop = new Properties();
			 prop.load(new FileInputStream(new File("./src/main/java/com/wal/config/config.properties")));
			 sUrl =  prop.getProperty("url");
			 sUsername = prop.getProperty("username");
			 sPassword = prop.getProperty("password");
			 sBrowser = prop.getProperty("browser");
			 sHub = prop.getProperty("hub");
			 sMode = prop.getProperty("mode");
			 
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		}
	
//	@Override
//	public void invokeApp(String browser)
//	{
//		invokeApp(browser);
//	}
	public void invokeApp(String browser, String mode) {
		// TODO Auto-generated method stub
		if(mode.equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.WINDOWS);
			
			try {
				driver = new RemoteWebDriver(new URL(sHub),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(mode.equalsIgnoreCase("local")){
		if(browser.equalsIgnoreCase("chrome")) {
		      System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		      driver = new ChromeDriver();              
		      
		}else if(browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		      driver = new FirefoxDriver();     
		}else if(browser.equalsIgnoreCase("ie")){
			 System.setProperty("webdriver.ie.driver", "./driver/InternetExplorerDriver.exe");
		      driver = new InternetExplorerDriver(); 
		}
		}
		// WebDriverEventListner, EventFiringWebDriver
		// object creation for Event firing WD and assign to driver
		e_driver = new EventFiringWebDriver(driver);
		
		// register our event  listener class to Event firing WD
		e_driver.register(new WebEventListener());
		
		// assign back Event firing WD to this WebDriver
		driver = e_driver;
		
		driver.get(sUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME,TimeUnit.SECONDS);
		
	}
	
	@DataProvider (name = "fetch")
	public Object[][] getData() throws IOException
	{
		Object data[][] = TestUtil.getTestData(datasheet);
		return data;
	}


	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
		//driver.quit();
	}


}
