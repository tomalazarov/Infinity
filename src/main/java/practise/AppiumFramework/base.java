package practise.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer() throws IOException, InterruptedException {
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("/Users/tlaza/Library/Android/Sdk/emulator/emulator -avd InfinityEmulator");
				//System.getProperty("user.dir") + "/src/main/java/resources/startEmulator.sh");
		Thread.sleep(6000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/practise/AppiumFramework/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		File appDir = new File("/Users/tlaza/eclipse-workspace/AppiumFramework/src/main/java/practise/AppiumFramework/");
		File app = new File(appDir, (String) prop.get(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions(); 
		options.setCapability("w3c", false); 
		
		//String device = (String) prop.get("device");
		String device = System.getProperty("deviceName");
		if(device.contains("InfinityEmulator")) {
			startEmulator();
		}
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
//		cap.setCapability("platformName", "Android"); 
//		cap.setCapability("deviceName", "HUAWEI P40 Pro"); 
//		cap.setCapability("automationName", "UiAutomator2"); 
//		cap.setCapability("appPackage", "com.androidsample.generalstore");
//		cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
//		cap.setCapability("udid", "K5J0220623001527");
//		cap.setCapability("androidVersion", "10");
		
//		cap.setCapability("chromedriverArgs", options); 
//		cap.setCapability("platformName", "Android"); 
//		cap.setCapability("deviceName", "Lenovo TB-8504X"); 
//		cap.setCapability("chromedriverExecutable", "/Users/tlaza/Downloads/chromedriver");
//		cap.setCapability("automationName", "UiAutomator2"); 
//		cap.setCapability("appPackage", "com.androidsample.generalstore");
//		cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
//		cap.setCapability("udid", "HA10B059");
//		cap.setCapability("androidVersion", "8.1.0");
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void getScreenshot(String s) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/tlaza/Documents/TCfails/"+s+".png"));
	}
}
