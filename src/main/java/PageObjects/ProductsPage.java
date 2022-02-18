package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {
	
	public ProductsPage(AndroidDriver <AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	//driver.findElementsById("com.androidsample.generalstore:id/productAddCart")
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> addToCart;
	
//	driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart")
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartBtn;

}
