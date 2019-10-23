package zagg.accountGeneral;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(4)
public class AccountGeneralTests extends AccountGeneralMethods{
	
	
	@Test(priority=401)
	public void accountInformation() throws Exception {	
		logInfo("Enter into accountInformation() method");
		nav2AccountDashboard(USACountry);
		validateTitlScreen("Account Dashboard");
		accountInfoOnDashboard();
		addressBookOnDashboard();
		
		
		
//		
//		selectSideBarItems("Registered Products");
//		showProdItemsPerPage();
		
		
	}
	
	@Test(priority=402)
	public void validatRegisteredProducts() throws Exception {
		accountDashboard();
		selectSideBarItems("Registered Products");
		
		
		
		
	}
	
	
	@Test(priority=403)
	public void deleteExistingAddress() throws Exception {
		logInfo("Entered into deleteExistingAddress() Test");
		accountDashboard();
		selectSideBarItems("Address Book");
		handleAddress();	
		
	}
	
	
	

}
