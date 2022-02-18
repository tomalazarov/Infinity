package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver <AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	//driver.findElementById("com.androidsample.generalstore:id/nameField")
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	//driver.findElementByXPath("//android.widget.RadioButton[@text='Female']")
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	public WebElement femaleRadioBtn;
	
	//driver.findElementById("android:id/text1")
	@AndroidFindBy(id="android:id/text1")
	public WebElement countryDropdown;
	
	//driver.findElementByXPath("//*[@text='Bulgaria']")
	@AndroidFindBy(xpath="//*[@text='Bulgaria']")
	public WebElement countryName;
	
	//driver.findElementById("com.androidsample.generalstore:id/btnLetsShop")
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopBtn;
}
