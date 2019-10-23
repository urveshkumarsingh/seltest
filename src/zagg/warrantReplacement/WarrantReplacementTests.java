package zagg.warrantReplacement;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;



@Priority(3)
public class WarrantReplacementTests extends WarrantReplacementMethods {
	
	
	String ship= "Ship";
	String invoice= "Invoice";
	String genShipLabel= "Generate Shipping Label";
	
	//this is depends on PR - 243- registerCasesProductForWR
	@Test(priority=301)
	public void validateWRScreens() throws Exception{	
		logInfo("Entered into validateWRScreens() Test.");
		try{
			myAccount();
			myAccount();
			selectBtnRegisterAProduct();
			selectRegisterHere();		
			selectCatgeory(catBatteryCases);		
			storeDataInProrpertyFile(catBatteryCases, batteryTcId);
			selectproductUnderCategory(catBatteryCases, batteryTcId);		
			popupSerialNumber(serialNumber);
			enterPurchasedDate(-2);		
			selectExistingAddress("shipping");
	    	registerProduct();
	    	isRegisteredConfirmed();	    	
	    	selectSideBarItems(regProductTitle);
			myAccount();
			selectSideBarItems(regProductTitle);			
			ag.showProdItemsPerPage();
			ag.selectWarrentForProduct(getAttributeOptionsInProperty(catBatteryCases, batteryWrId));
			verifyScreenReasonforReplacement();
			checkOutStatusBar();
			selectReasonFromDropdown(powerReason);
			optionsReviewScreen();
			paymentSummary();
			verifyShippingCodeDetails("sgdufgjsdgf"); 
			validateCheckoutScreen();
			verifyProductCost();
			verifyTermsText();
			myAccount();
			}catch (Exception ex) {
				myAccount();
				ex.printStackTrace();
			}
				
		}
	
	
	@Test(priority=302)
	public void validateBatteryReasonsInWR() throws Exception {		
		logInfo("Entered into validateBatteryReasonsInWR() Test.");
		myAccount();
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catBatteryCases);		
		storeDataInProrpertyFile(catBatteryCases, batteryTcId);
		selectproductUnderCategory(catBatteryCases, batteryTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();	    	
    	selectSideBarItems(regProductTitle);
    	ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catBatteryCases, batteryWrId));
		getReasons(powerReasons);		
		}
	
	/**Below 4 testcases are depended on Product Registration tests.**/
	
	@Test(priority=303)
	public void validateKeyboardReasonsInWR() throws Exception {	
		logInfo("Entered into validateKeyboardReasonsInWR() Test.");
		myAccount();
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catKeyboard);		
		storeDataInProrpertyFile(catKeyboard, keyBoardTcId);
		selectproductUnderCategory(catKeyboard, keyBoardTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();	  
		
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catKeyboard, keyboardWRId));
		getReasons(keyboardReasons);
	
		}
	
	@Test(priority=304)
	public void validatePortablePowerReasonsInWR() throws Exception {
		logInfo("Entered into validatePortablePowerReasonsInWR() Test.");		
		myAccount();
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catPortablePower);		
		storeDataInProrpertyFile(catPortablePower, powerTcId);
		selectproductUnderCategory(catPortablePower, powerTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catPortablePower, powerWRId));		
		getReasons(powerReasons);
		}
	
	@Test(priority=305)
	public void validateScreenProtectionReasonsInWR() throws Exception{	
		logInfo("Entered into validateScreenProtectionReasonsInWR() Test.");
		myAccount();
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catScreenProt);		
		storeDataInProrpertyFile(catScreenProt, screenTcId);
		selectproductUnderCategory(catScreenProt, screenTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();		
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catScreenProt, screenTcIdWRId));		
		getReasons(screenProtReasons);		
		}
	
	@Test(priority=306)
	public void validateWirelessDocksReasonsInWR() throws Exception{	
		logInfo("Entered into validateWirelessDocksReasonsInWR() Test.");
		myAccount();
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catWireless);		
		storeDataInProrpertyFile(catWireless, tc2);
		selectproductUnderCategory(catWireless, tc2);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();    	
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catWireless, wirelessWrId));		
		getReasons(powerReasons);		
		}
	
	//Bug- 4727 -Try to reOrder with previously canceled warranty product.
	@Test(priority=307)
	public void bug_4727_ReorderCanceledProductInWR() throws Exception{	
		logInfo("Entered into bug_4727_ReorderCanceledProductInWR() Test.");
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catScreenProt, screenTcIdWRId));	
		getReasons(screenProtReasons);
	
	 
	}
	
	
	@Test(priority=311)
	public void WR_replaceSameProductOnWarranty() throws Exception {	
		logInfo("Entered into WR_replaceSameProductOnWarranty() Test.");
		myAccount();
		selectLeftTab(myDash);
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catScreenProt);		
		storeDataInProrpertyFile(catScreenProt, screenTcId);
		selectproductUnderCategory(catScreenProt,screenTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();		
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catScreenProt, screenTcIdWRId));		
		selectReasonFromDropdown(screenProtReason);
		paymentSummary();
		shippingMethodDetails("Standard Shipping");		
		handleCCPaymentInWR();
		completeYourOrder();
		selectLeftTab(myDash);
		isRegisteredConfirmed(wrConfMsg);			
			String orderId=getOrderId() ;		
			nav2adminWithCredentials(admin, adminPassword);
			selectLeftTabsInAdmin("SALES");
			selectOrdersInAdmin();			
			boolean isIdPresent = handleOrderIDInAdmin(orderId);	
			if(isIdPresent==true){
				boolean isTabPresent = orderIdTabInAdmin(invoice);
				if(isTabPresent==true) {
				returnProduct();
				orderIdTabsInAdmin(ship);
				submitShippingInAdmin();
				orderIdTabsInAdmin(invoice);
				submitInvoiceInAdmin();	
				orderIdTabsInAdmin(genShipLabel);
				homePage();
				myAccount();
			}else {
				homePage();
				myAccount();
				System.err.println("suspected Fraud for this OrderId "+orderId);
				Assert.assertTrue(isTabPresent, invoice+" is not present");
			}}else {
				homePage();
				myAccount();
				System.err.println("Not able to submit order");
				Assert.assertTrue(isIdPresent, orderId + "is not present");
			}		
		}
	
	@Test(priority=312)
	public void WR_replaceUpgradeProduct() throws Exception {	
		logInfo("Entered into WR_replaceUpgradeProduct() Test.");		
//		selectLeftTab("Account Dashboard");
//		selectBtnRegisterAProduct();
//		selectRegisterHere();
//				
//		selectCatgeory(catBatteryCases);		
//		storeDataInProrpertyFile(catBatteryCases, batteryTcId);
//		selectproductUnderCategory(catBatteryCases,batteryTcId);		
//		popupSerialNumber(serialNumber);
//		enterPurchasedDate(-2);		
//		selectExistingAddress("shipping");
//    	registerProduct();
//    	isRegisteredConfirmed();		
		myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catBatteryCases, batteryWrId));		
		selectReasonFromDropdown(powerReason);
		identifyUgradeSection();
		verifyProductCost();
		shippingMethodDetails("Standard Shipping");
		paymentSummaryCalculationsInCheckout();
		handleCCPaymentInWR();
		completeYourOrder();
		selectLeftTab(myDash);
		isRegisteredConfirmed(wrConfMsg);	
		String orderId= getOrderId() ;
		nav2adminWithCredentials(admin, adminPassword);
		selectLeftTabsInAdmin("SALES");
		selectOrdersInAdmin();			
		boolean isIdPresent = handleOrderIDInAdmin(orderId);	
		if(isIdPresent==true){
			boolean isTabPresent = orderIdTabInAdmin(invoice);
			if(isTabPresent==true) {
			returnProduct();			
			orderIdTabsInAdmin(ship);
			submitShippingInAdmin();
			orderIdTabsInAdmin(invoice);
			submitInvoiceInAdmin();	
			orderIdTabsInAdmin(genShipLabel);
			homePage();
			myAccount();
		}else {
			homePage();
			myAccount();
			System.err.println("suspected Fraud for this OrderId "+orderId);
			Assert.assertTrue(isTabPresent, invoice+" is not present");
		}}else {
			homePage();
			myAccount();
			System.err.println("Not able to submit order");
			Assert.assertTrue(isIdPresent, orderId + "is not present");
		}
	
		}
	
	/**login in Admin and generate shipping code and store that code.
	 Register product and navigate to warranty replacement. apply above shipping code to replace a product.*/
	@Test(priority=313)
	public void WR_ReplaceProductWithShippingCode() throws Exception {	
		logInfo("Entered into WR_ReplaceProductWithShippingCode() Test.");
		String priceIs="1.00";
		nav2adminWithCredentials(admin, adminPassword);
		selectLeftTabsInAdmin("SALES");
		selectShippingCodeGeneratorInAdmin();
		productAttributeTitle(shippingCodeGenTitle);
		generatedShippingCode(priceIs);
		String actCode = getShippingCode(custName,unqName+" "+lastName);
		homePage();
		homePageByCountry(USACountry);
		myAccount();		
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catCases);		
		storeDataInProrpertyFile(catCases, casesTcId);
		selectproductUnderCategory(catCases,casesTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();
    	selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catCases, casesWrId));	
		enterReasons();
		//selectReasonFromDropdown(keyboardReason);
		paymentSummary();
		shippingMethodDetails("Standard Shipping");	
		handleShippingCode(actCode);
		validateShippingPrice(priceIs);
		handleCCPaymentInWR();
		completeYourOrder();
		selectLeftTab(myDash);
		isRegisteredConfirmed(wrConfMsg);	
		String orderId= getOrderId() ;
		nav2adminWithCredentials(admin, adminPassword);
		selectLeftTabsInAdmin("SALES");
		selectOrdersInAdmin();			
		boolean isIdPresent = handleOrderIDInAdmin(orderId);	
		if(isIdPresent==true){
			boolean isTabPresent = orderIdTabInAdmin(invoice);
			if(isTabPresent==true) {
			returnProduct();			
			orderIdTabsInAdmin(ship);
			submitShippingInAdmin();
			orderIdTabsInAdmin(invoice);
			submitInvoiceInAdmin();	
			orderIdTabsInAdmin(genShipLabel);
			selectLeftTabsInAdmin("SALES");
			selectShippingCodeGeneratorInAdmin();
			productAttributeTitle(shippingCodeGenTitle);	
			homePage();
			myAccount();
		}else {
			homePage();
			myAccount();
			System.err.println("suspected Fraud for this OrderId "+orderId);
			Assert.assertTrue(isTabPresent, invoice+" is not present");
		}}else {
			homePage();
			myAccount();
			System.err.println("Not able to submit order");
			Assert.assertTrue(isIdPresent, orderId + "is not present");
		}	
	
	}	
	
	
	/**If shipping address is related States of "Armed of ...." The shipping method will disappears and show info
	 as cannot ship to this location *  **/
	@Test(priority=321)
	public void WR_disableShippingMethod() throws Exception {
		logInfo("Entered into WR_disableShippingMethod() Test.");
		//loginWithAnotherUser(zaggUsermailId, mailPwd);
		nav2AccountDashboard();
		logoutAsCustomer();
		selectSignIn(USACountry);
		homePageByCountry(USACountry);
		homePageByCountry(USACountry);
		selectSignIn(USACountry);
		existingUserLogin(zaggUsermailId, mailPwd);		
		nav2AccountDashboard();
		nav2PRScreen();	
		selectRegisterHere();		
		selectCatgeory(catBatteryCases);		
		storeDataInProrpertyFile(catBatteryCases, batteryTcId);
		selectproductUnderCategory(catBatteryCases,batteryTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();
    	myAccount();
		selectSideBarItems(regProductTitle);
		ag.showProdItemsPerPage();
		ag.selectWarrentForProduct(getAttributeOptionsInProperty(catBatteryCases, batteryWrId));		
		selectReasonFromDropdown(powerReason);
		paymentSummary();
		noShippingMethod();
		handleCCPaymentInWR();
		completeYourOrder();
		validatePRTitle(wrTitle);
			
		
	}
	

}
