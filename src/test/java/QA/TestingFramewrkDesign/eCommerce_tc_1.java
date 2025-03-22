package QA.TestingFramewrkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import TestUtils.AndroidBasetest;

import java.util.HashMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.HidesKeyboard;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class eCommerce_tc_1 extends AndroidBasetest{
	//webDriver driver;
	@BeforeMethod
	public void preSetup()
	{
		//screen to home page
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
	
		driver.startActivity(activity);
		
	//	((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
	
		
	


	
	@Test
	public void FillForm_ErrorValidation() throws InterruptedException
	{
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Darshan");
		((HidesKeyboard) driver).hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		String toastMessage = driver.findElement(By.xpath("(/hierarchy/android.widget.Toast[1])")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please  your name");
	}
		
		
	@Test
	public void FillForm_ErrorValidation1() throws InterruptedException
	{
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Darshan");
		((HidesKeyboard) driver).hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		String toastMessage = driver.findElement(By.xpath("(/hierarchy/android.widget.Toast[1])")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please  your name");
	}
		
	
	
	
	
	
	
	

}
