package generalShop.pageObject.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidMobileGesture;

public class ProductCatolouge extends AndroidMobileGesture {
	
	AndroidDriver driver;
	
	public ProductCatolouge(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void setAddItemToCartByIndex(int index)
	{
		addToCart.get(index).click();;
	}
	
	public void goToCart()
	{
		cart.click();
	}

}
