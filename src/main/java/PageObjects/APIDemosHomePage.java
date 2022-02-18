package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// all the objects belonging to one page will be defined in one java class
public class APIDemosHomePage {
	//below is defined Constructor of the object APIDemosHomePage in basics
	//1. Is to call the driver object from testcase to Pageobject file
	//Concatenate driver
	public APIDemosHomePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //this - referring to this page..you can pass whatever other page is needed
		//PageFactory initElements will just initialize all the defined elements on this page.. like below Preferences
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences; 
	//here I'm just giving a name Preferences of the above row
	//and AndroidFindBy is the same as findElementByXpath.... for IOS it will be IOSFindBy
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	public WebElement Views; 

}
 