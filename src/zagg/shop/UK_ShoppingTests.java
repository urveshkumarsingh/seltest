package zagg.shop;

import org.testng.annotations.Test;

import com.lib.Priority;

import zagg.prodRegistration.ProductRegistartionMethods;

@Priority(22)
public class UK_ShoppingTests extends shoppingMethods{
	ProductRegistartionMethods pr = new ProductRegistartionMethods();
	
	
	/**Login with UK credentials in UK webSite**/
	@Test(priority=2201)
	public void loginIntoUKCustomer() throws Exception {
		logInfo("Entered into loginIntoUKCustomer() Test");
		pr.loginWithAnotherUserByLocale(UKCountry, mailId, mailPwd);
		
		
		
		
	}
	
	/**Navigates to PR screen and validates all fields, titles, Alert messages**/
	@Test(priority=2202, dependsOnMethods = {"loginIntoUKCustomer"} )
	public void UK_PlaceOrderWithCreditCard() throws Exception {
		logInfo("Entered into UK_PlaceOrderWithCreditCard() Test");
		nav2Shop(UKCountry);
		handleOfferPopUp();
		nav2Shop(UKCountry);		
    	selectProduct(UKCountry);
		wrm.handleCCPayment();
		defaultPlaceOrder();
		verifyOrderStatus();
		
		
		
		
	}

}
