package generalShop.pageObject.Android;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.AndroidMobileGesture;

public class BaseClass{
	
	public AndroidDriver driver;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{

		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Readme Note 9");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity ");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}

}
