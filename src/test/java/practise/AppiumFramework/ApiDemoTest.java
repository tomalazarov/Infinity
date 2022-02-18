package practise.AppiumFramework;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.APIDemosHomePage;
import PageObjects.DependenciesPage;
import PageObjects.PreferencesPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoTest extends base{
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Thread.sleep(3000);
	}

	@Test(dataProvider="InputData", dataProviderClass = TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException {
		
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		
		APIDemosHomePage h = new APIDemosHomePage(driver);
		//Constructor of class will be invoked when you create object for the class
		//default constructor will be called... if I haven't defind it
		//constructor can be defined with arguments (driver in my case)
		
		//tagName[@attribute='value']
//		driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
//		driver.findElementById("android:id/button1").click();
//		driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();
		//driver.findElementByAndroidUIAutomator("text(\"API Demos\")").click();
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		h.Preferences.click();
		PreferencesPage p = new PreferencesPage(driver);
		
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		//below row is equal to the above row but in page object concept
		p.dependencies.click();
		
		DependenciesPage d = new DependenciesPage(driver);
		//driver.findElementById("android:id/checkbox").click();
		d.checkbox.click();
		d.wifiSettings.click();
		//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		d.editText.sendKeys(input);
		//driver.findElementByClassName("android.widget.EditText").sendKeys("test");
		d.buttons.get(1).click();
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		service.stop();
	}

}
