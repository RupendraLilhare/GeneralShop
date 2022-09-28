package General.shop;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generalShop.pageObject.Android.BaseClass;
import generalShop.pageObject.Android.CartPage;
import generalShop.pageObject.Android.Formpage;
import generalShop.pageObject.Android.ProductCatolouge;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class Ecomerce_tc_5 extends BaseClass {
	
	@Test
	public void fillform(String name, String gender,String countryName) throws InterruptedException
	{
		Formpage pg=new Formpage(driver);
		pg.setNameField(name);
		pg.setGender(countryName);
		pg.setCountrySlection(countryName);
		pg.setsubmitForm();
		
		ProductCatolouge pc=new ProductCatolouge(driver);
		pc.setAddItemToCartByIndex(0);
		pc.setAddItemToCartByIndex(1);
		pc.goToCart();
		 
		CartPage cp=new CartPage(driver);
		double totalSum=cp.getProductSum();
		double displayFormatedSum=cp.getTotalAmountDisplayed();
		cp.setCheckBox();
		cp.acceptTermsAndCondition();
		cp.setSubmitOrder();
		
		Assert.assertEquals(totalSum,displayFormatedSum );
		
	}		
		@DataProvider
		public Object[][] getData()
		{
		return	new Object[][] {{"Himya","female","Argentina"}};
		}
}