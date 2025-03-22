package QA.TestingFramewrkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ProductCatalogue extends AndroidActions{
	AndroidDriver driver;
//	WebDriver driver;
//	private AppiumDriver driver;

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ADD TO CART")
	public List<WebElement> addToCart;

	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;
	

	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
		 
	}
	
//	public void addItemToCartByIndex(int index) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")));
//
//	    System.out.println("Products found: " + productList.size());
//
//	    if (productList.isEmpty()) {
//	        throw new RuntimeException("No products found! Check XPath or page loading.");
//	    }
//
//	    if (index < 0 || index >= productList.size()) {
//	        throw new IndexOutOfBoundsException("Invalid index: " + index + ". List size: " + productList.size());
//	    }
//
//	    productList.get(index).click();
//	}
	
	public CartPage goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

	


