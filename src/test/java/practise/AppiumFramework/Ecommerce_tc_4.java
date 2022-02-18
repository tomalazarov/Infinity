package practise.AppiumFramework;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.FormPage;
import PageObjects.ProductsPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_tc_4 extends base{
	
		@Test
		public void totalValidation() throws InterruptedException, IOException {
			service = startServer();
			
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage formPage = new FormPage(driver);
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Toma Lazarov");
		formPage.nameField.sendKeys("Toma Lazarov");
		driver.hideKeyboard();
		//driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		formPage.femaleRadioBtn.click();
		//driver.findElementById("android:id/text1").click();
		formPage.countryDropdown.click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bulgaria\"));");
		Utilities u = new Utilities(driver);
		u.scrollToText("Bulgaria");
		//driver.findElementByXPath("//*[@text='Bulgaria']").click();
		formPage.countryName.click();
		//driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		formPage.shopBtn.click();
		//driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		//driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		ProductsPage p = new ProductsPage(driver);
		p.addToCart.get(0).click();
		p.addToCart.get(1).click();
		//driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		p.cartBtn.click();
		Thread.sleep(2000);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		int count = checkoutPage.productList.size();
		double sum = 0;
		for(int i=0; i<count;i++) {
			String currentValue = checkoutPage.productList.get(i).getText();
			double amount = getAmount(currentValue);
			sum = sum + amount;
		}
		
	String totalSum = checkoutPage.totalAmount.getText();
	totalSum = totalSum.substring(2);
	double totalVal = Double.parseDouble(totalSum);

	System.out.println("bravooo " + sum + "=" + totalVal);
	
	Assert.assertEquals(sum, totalVal);
	service.stop();
	}
		
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Thread.sleep(3000);
	}
	
	public static double getAmount(String value) {
		value = value.substring(1);
		double secondValue = Double.parseDouble(value);
		return secondValue;
	}
}
