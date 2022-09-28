package general.Shop123;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class Ecomerce_tc_1 extends BaseClass {
	
	@Test
	public void fillform()
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("samir");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.hideKeyboard();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Argentina\"));"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Argentina\");"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	}

}