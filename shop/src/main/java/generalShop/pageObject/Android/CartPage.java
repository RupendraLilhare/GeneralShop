package generalShop.pageObject.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidMobileGesture;

public class CartPage extends AndroidMobileGesture {
	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
	private WebElement terms;
	

	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(xpath="//*[@text='Visit to the website to complete purchase']")
	private WebElement proceed;

	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;

    public List<WebElement> getProductList()
    {
    	return productList;
    }
    
    public double getProductSum()
    {
    	int count=productList.size();
		double totalSum=0;
		for(int i=0;i<count;i++)
		{
			String amountString=productList.get(i).getText();
			double price=getAmount(amountString);
			totalSum=totalSum+price;
			System.out.println(totalSum);
		}
		return totalSum;
    }
    
    public double getTotalAmountDisplayed()
    {
    	return getAmount(totalAmount.getText());
    }
    
    public double getAmount(String amount) {
    	 amount=amount.substring(1);
 		double  price=Double.parseDouble(amount);
 		return price;
    }
     
    public void acceptTermsAndCondition()
    {
    	 logPressAction(terms);
    	acceptButton.click();
    }
    
    
    public void setSubmitOrder() {
    	proceed.click();
    }
	
    public void setCheckBox() {
    	checkBox.click();
    }
    
	
}
