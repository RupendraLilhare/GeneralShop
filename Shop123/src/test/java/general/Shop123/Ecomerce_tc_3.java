package general.Shop123;

import org.openqa.selenium.By;


import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;


public class Ecomerce_tc_3 extends BaseClass {
	
	@Test
	public void fillform() throws InterruptedException
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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).resourceID(\"com.androidsample.generalstore:id/rvProductList\").scrollIntoView(text(\"Jordan 6 Rings\"));"));

		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		String productName=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView\r\n")).getText();
		System.out.println(productName);
		
		if(productName.equalsIgnoreCase("Jordan 6 Rings"))
		{
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		}
		Thread.sleep(3000);

		/*int productCount=driver.findElements(By.xpath("com.androidsample.generalstore:id/productName")).size();
		
		System.out.println(productCount);
		
		for(int i=0;i<productCount;i++)
		{
			String productName= ((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/rvProductName")).get(i)).getText();
		
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
	   
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
			}
			
		}*/
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);
		
	}

}