package zagg.admin;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(31)
public class AdminProductRegistration extends AdminMethods{
	
	
	
	
	@Test(priority=3101)
	public void adminLogin() throws Exception {
		logInfo("Entered into adminLogin() Test");	
		nav2adminWithCredentials(admin, adminPassword);	
		productAttributeTitle(sellerTitle);
	}
	
	
	
	
	
	@Test(priority=3103)
	public void searchProdRegistartionInAdmin() throws Exception {
		logInfo("Entered into searchProdRegistartionInAdmin() Test");	
		selectLeftTabsInAdmin(adProdReg);
		nav2PRInAdmin();
		productAttributeTitle(PRTitleText);
		adminSelectFilter();
		clearAllFilters();
		adminSelectFilter();
		filterItemsWith(prodNamed,productReg);
		verifyDataFromColumns(prodNamed, productReg);
		adminSelectFilter();
		clearAllFilters();
		adminSelectFilter();
		filterItemsWith(custName,unqName+" "+lastName);
		verifyDataFromColumns(custName, unqName+" "+lastName);
		adminSelectFilter();
		filterItemsWith(prodNamed,productReg);
		verifyDataFromColumns(prodNamed, productReg);
		verifyDataFromColumns(custName, unqName+" "+lastName);
		
	}	
	
	//bug-3772- In Admin - Order Creation - Changing form information removes payment info.
	@Test(priority=3104)
	public void verifyCCInfoIfShippingMethodChangesInAdmin() throws Exception {
		logInfo("Entered into verifyCCInfoIfShippingMethodChangesInAdmin() Test");
		selectLeftTabsInAdmin("CUSTOMERS");
		quickSearchCustomer();
		filterInQuickSearch(unqName,lastName,mailId);
//		editCustomer(mailId);
//		createOrder();
//		selectStore();
//		addProducts("7965");
	}
	
	
	
	
	

}
