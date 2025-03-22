package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.AppiumUtils;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import QA.TestingFramewrkDesign.FormPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class AndroidBasetest extends AppiumUtils{
	
	


	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
//	public WebDriver driver;
//	private AppiumDriver driver;

	@BeforeClass (alwaysRun = true)
	public void ConfigureAppium() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties");
		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress"):prop.getProperty("ipAddress");
		System.out.println(ipAddress);
		prop.load(fis);
	//	String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
				
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("darshan")); //emulator
		//options.setDeviceName("Android Device");// real device		
		options.setChromedriverExecutable("C:\\Users\\Dashan K N\\eclipse-workspace\\TestingFramewrkDesign\\src\\test\\java\\Resources\\chromedriver.exe");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\General-Store.apk");
		
		 driver = new AndroidDriver(service.getUrl(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 formPage= new FormPage(driver);
}
		
		
//			UiAutomator2Options options = new UiAutomator2Options();
//			options.setDeviceName(prop.getProperty("AndroidDeviceNames"));
//			options.setPlatformName("Android");
//			options.setAutomationName("UIAutomator2");
//	//		Capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Dashan K N\\Documents\\chromedriver_win32\\chromedriver.exe");
//    //		options.setChromedriverExecutable("C:\\Users\\Dashan K N\\eclipse-workspace\\testing\\src\\test\\java\\resources\\chromedriver.exe");
//	//		options.setCapability("browserName", "Chrome");
////	//		options.setApp("C:\\Users\\Dashan K N\\eclipse-workspace\\testing\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//			options.setApp(System.getProperty("user.dir")+ "\\src\\test\\java\\Resources\\General-Store.apk");
//			  driver = new AndroidDriver(service.getUrl(), options);
//			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			 formPage = new FormPage(driver);
//		
		
//}
	
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	
	@AfterClass (alwaysRun = true)
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	

}
