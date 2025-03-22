package QA.TestingFramewrkDesign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;




public class FormPage extends AndroidActions {
	
AndroidDriver driver;
//WebDriver driver;
AppiumDriver driver1;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
		
	}
//public FormPage(AndroidDriver driver) {
//    this.driver = driver;
//    PageFactory.initElements(driver, this);
//}

public void setActivity() {
    System.out.println("Setting activity...");
    ((InteractsWithApps) driver).terminateApp("com.androidsample.generalstore");
    
    	    // Re-launch the app
    	    ((InteractsWithApps) driver).activateApp("com.androidsample.generalstore");
    // Your implementation
}



	
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
	
	
	

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"))
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		((HidesKeyboard) driver).hideKeyboard();
		
	}
	
//	public void setActivity()
//	{
//		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//		driver.startActivity(activity);
//	}
	
	
//	public void setActivity()
//	{
//		
//		driver.terminateApp("com.androidsample.generalstore");
//
//	    // Re-launch the app
//	    driver.activateApp("com.androidsample.generalstore");
//	}
//	public void setActivity() {
//		 System.out.println("Activity set successfully!");
//    }

	public void setGender(String gender)
	{
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
			
	}
	
	
	
	public void setCountrySelection(String countryName)
	
	{
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	
	
	public ProductCatalogue submitForm()
	{
		shopButton.click();
		return	new ProductCatalogue(driver);
		
	}
	
	}
	
	
	
	
	
	
	
	
	


