package general.Shop123;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class Ecomerce_tc_5 extends BaseClass {
	
	@Test
	public void fillform() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.hideKeyboard();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Argentina\"));"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Argentina\");"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("samir");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		WebElement product1=(WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0);
		product1.click();
		WebElement product2=(WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1);
		product2.click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		int count =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum=0;
		for(int i=0;i<count;i++)
		{
			String amount1 =((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)).getText();
	
			double amount=getAmount(amount1);
			sum=sum+amount;
			System.out.println(sum);
		}
		
	String  total=	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	total=total.substring(1);
	double totalValue=Double.parseDouble(total);
	System.out.println(totalValue);
		
		assertEquals(totalValue,sum);
		
		//Mobile Gastore tap and logn Press
		
		WebElement checkBox=driver.findElement(By.className("android.widget.CheckBox"));
		
		TouchAction t=new TouchAction(driver);
		
		t.tap(ElementOption.element(checkBox)).perform();
		
		WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		//t.longPress(LongPressOptions().(element(tc)))checkBox.withDuration(ofSecond(2))).release().perform();
		t.longPress(ElementOption.element(tc)).perform();
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//*[@text='Visit to the website to complete purchase']")).click();
		Thread.sleep(4000);
		
		
		Set<String> contextNames=driver.getContextHandles();
		
		for(String contextName:contextNames)
		{
			System.out.println(contextName);
		}
	driver.context((String) contextNames.toArray()[1]);
	
	}
	
	
	public static  double getAmount(String value)
	{
		 value=value.substring(1);
		double  totalAmountvalue=Double.parseDouble(value);
		return totalAmountvalue;
	}
}