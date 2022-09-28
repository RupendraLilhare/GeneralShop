package general.Shop123;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class Ecomerce_tc_4 extends BaseClass {
	
	@Test
	public void fillform() throws InterruptedException
	{
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("samir");
		//driver.hideKeyboard();
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
	
			

	/*	String amount1 =((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0)).getText();	
		//$120.0 convert to integer
		
		amount1=amount1.substring(1);
		double amountValue1=Double.parseDouble(amount1);
		
		 
		String amount2 =((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1)).getText();	
		//$120.0 convert to integer
		
		amount2=amount2.substring(1);
		double amountValue2=Double.parseDouble(amount2);
		
		double sumofAmount=amountValue1+amountValue2;
		System.out.println(sumofAmount);*/
		
	String  total=	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	total=total.substring(1);
	double totalValue=Double.parseDouble(total);
	System.out.println(totalValue);
		
		assertEquals(totalValue,sum);
	
		
	}
	public static  double getAmount(String value)
	{
		 value=value.substring(1);
		double  totalAmountvalue=Double.parseDouble(value);
		return totalAmountvalue;
	}
}