package zagg.shop;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;

import zagg.warrantReplacement.WarrantReplacementMethods;

@Priority(9)
public class shoppingTests  extends shoppingMethods{
	
	
	
	@Test(priority=901)
	public void shop_placeOrderProduct() throws Exception {
		logInfo("Entered into shop_placeOrderProduct() Test");
		nav2Shop(USACountry);
		selectProduct(USACountry);
		wrm.handleCCPayment();
		defaultPlaceOrder();
		verifyOrderStatus();
		//getOrderNumber();
		
	}
	
	@Test(priority=902)
	public void shop_placeOrderWithAmazonPay() throws Exception {
		logInfo("Entered into shop_placeOrderWithAmazonPay() Test");
		nav2Shop(USACountry);
		selectProduct(USACountry);
		handleAmazonPayment();
    	defaultPlaceOrder();
    	verifyOrderStatus();
		//getOrderNumber();
		
	}
	
	
	
	@Test(priority=905)
	public void shop_placeOrderWithoutUser() throws Exception {
		logInfo("Entered into shop_placeOrderWithoutUser() Test");
		
		try {
		pr.nav2AccountDashboard();
		login.logoutAsCustomer();
		login.homePage();
		nav2Shop(USACountry);
		selectProductWithoutUser();	
		userAddressDetails();
		addressSuggestion();		
		wrm.handleCCPayment();
		defaultPlaceOrder();
		validateOrderWithoutUser();		
		login.selectSignIn(USACountry);
		login.existingUserLogin(mailId, mailPwd);
		validateHomeTitle(dashBrdTitle);		
		}catch (Exception ex) {
			System.out.println("Entered into catch method");
			login.selectSignIn(USACountry);
			login.existingUserLogin(mailId, mailPwd);
			validateHomeTitle(dashBrdTitle);
		}
		
	}
	
	

}
