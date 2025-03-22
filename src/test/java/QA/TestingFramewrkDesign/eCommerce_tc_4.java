package QA.TestingFramewrkDesign;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import TestUtils.AndroidBasetest;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.appium.java_client.AppiumBy;





public class eCommerce_tc_4 extends AndroidBasetest{
//	private FormPage formPage;
    
//	WebDriver driver;
//    FormPage formPage;
	//capabilities.setCapability("chromedriverAutodownload", true);
//	@Test()
//	public void FillForm() throws InterruptedException
//	{
//		
//		formPage.setNameField("darshan");
//		formPage.setGender("female");
//		formPage.setCountrySelection("Argentina");
//		
//		ProductCatalogue productCatalogue = formPage.submitForm();
//		productCatalogue.addItemToCartByIndex(0);
//		productCatalogue.addItemToCartByIndex(0);
//		CartPage cartPage =productCatalogue.goToCartPage();
//		
//		double totalSum = cartPage.getProductsSum();
//		double displayFormattedSum =  cartPage.getTotalAmountDisplayed();
//		Assert.assertEquals((double) totalSum, (double) displayFormattedSum, 0.01);
//		cartPage.acceptTermsConditions();
//		cartPage.submitOrder();
//	//	Assert.assertEquals(totalSum, displayFormattedSum, 0.01);
//
////		driver.findElement(By.xpath("(//android.widget.TextView[@text = 'ADD TO CART'])[1]")).click();	
//		
//		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//		longPressAction(ele);
//		driver.findElement(By.id("android:id/button1")).click();
//		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//		Thread.sleep(2000);
//		
//		Set<String> contexts =driver.getContextHandles();
//		for(String contextName :contexts)
//		{
//			System.out.println(contextName);
//		}
//		
//		driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver
//		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.context("NATIVE_APP");

		
//	}
// Dataprovider
@Test(dataProvider = "getData", groups = {"Smoke"})
public void FillForm(HashMap<String, String> input) throws InterruptedException
{
	
	
	formPage.setNameField(input.get("name"));
	formPage.setGender(input.get("gender"));
	formPage.setCountrySelection(input.get("country"));
	
	ProductCatalogue productCatalogue = formPage.submitForm();
	productCatalogue.addItemToCartByIndex(0);
	productCatalogue.addItemToCartByIndex(0);
	CartPage cartPage =productCatalogue.goToCartPage();
	
	double totalSum = cartPage.getProductsSum();
	double displayFormattedSum =  cartPage.getTotalAmountDisplayed();
	Assert.assertEquals((double) totalSum, (double) displayFormattedSum, 0.01);
	cartPage.acceptTermsConditions();
	cartPage.submitOrder();
}

//@BeforeMethod (alwaysRun = true)
//public void preSetup()
//{
//	formPage.setActivity();
//		
//}
public void preSetup() {
    System.out.println("Checking driver: " + (driver != null ? "Initialized" : "NULL"));

    if (driver == null) {
        throw new IllegalStateException("Driver is not initialized. Appium server may not be running.");
    }

    formPage = new FormPage(driver);
    System.out.println("Checking formPage: " + (formPage != null ? "Initialized" : "NULL"));

    if (formPage == null) {
        throw new NullPointerException("FormPage object is null. Check if driver is properly initialized.");
    }

    formPage.setActivity();  // This is where the failure occurs
}

//@BeforeMethod (alwaysRun = true)
//public void preSetup() {
//    if (driver == null) {
//        System.out.println("Driver is null. Ensure it is initialized properly.");
//    } else {
//        formPage = new FormPage(driver);
//        formPage.setActivity();
//    }
//}

//@BeforeMethod (alwaysRun = true)
//public void preSetup() {
//	System.out.println("Executing preSetup...");
//    driver = new ChromeDriver();  // Or Appium driver
//    formPage = new FormPage(driver);  // Ensure formPage is initialized
//    System.out.println("formPage initialized: " + (formPage != null));
//    formPage.setActivity();
//}
//
//@Test
//public void testMethod() {
//    formPage.setActivity(); // This should not be null now
//}




	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List <HashMap<String, String>> data =getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\eCommerce.json");
	//	return new Object[][] {  { "darshan", "female", "Argentina" }, {"darshan K N", "Male", "India"} };
		return new Object[][] {  { data.get(0)}, {data.get(1)} };
	}//src//test//java//org//rahulshettyacademy//testData//eCommerce.json
	
	
	
//	@AfterMethod
//	public void tearDown() {
//	    if (driver != null) {
//	        driver.quit();
//	    }
	
}

		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	


