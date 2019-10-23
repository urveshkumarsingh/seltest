package zagg.prodRegistration;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(8)
public class PRToolTipTests extends PRToolTipsMethod{	
	
	@Test(priority=801)
	public void PR_WarrantyExpiredProduct() throws Exception {
		logInfo("Entered into PR_WarrantyExpiredProduct() Test");	    	
		nav2AccountDashboard(USACountry);
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catBatteryCases);		
		selectproductUnderCategory(catBatteryCases,batteryTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-739);		
		selectExistingAddress("shipping");
    	registerProduct();
    	isRegisteredConfirmed();
		nav2AccountDashboard(USACountry);
		selectLeftTab(regProductTitle);
    	showProdItemsPerPage();
    	getToolTipOfProduct(getAttributeOptionsInProperty(catBatteryCases, batteryWrId),regExpiredText);
			
	
	}	
	
	@Test(priority=802)
	public void PR_OutOfStockForReplacement() throws Exception {
		logInfo("Entered into PR_OutOfStockForReplacement() Test");	    	
    	selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catReplacement);	
		storeDataInProrpertyFile(catReplacement,speakersTcId);
		selectproductUnderCategory(catReplacement,speakersTcId);
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-5);		
		selectExistingAddress("billing");
    	registerProduct();
    	isRegisteredConfirmed();
		selectLeftTab(regProductTitle);
    	showProdItemsPerPage();
    	getToolTipOfProduct(getAttributeOptionsInProperty(catReplacement, speakerWRId),regOutOfStock);
			
	
	}	
	
	@Test(priority=803)
	public void PR_OrderCompletedBfrReplace() throws Exception {
		logInfo("Entered into PR_OrderCompletedBfrReplace() Test");	
		selectLeftTab(regProductTitle);
    	showProdItemsPerPage();
    	getToolTipOfProduct(getAttributeOptionsInProperty(catScreenProt,screenTcIdWRId),regMustComplete);
		
	}
	

}
