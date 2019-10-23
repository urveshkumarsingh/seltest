package zagg.accountGeneral;

import org.testng.annotations.Test;

import com.lib.Priority;


@Priority(5)
public class RegisteredProducts extends AccountGeneralMethods{
	
	
	@Test(priority=501)
	public void registeredProductsPagination() throws Exception {
		logInfo("Enter into registeredProductsPagination() test");
		nav2AccountDashboard(USACountry);
		validateTitlScreen("Account Dashboard");
		selectSideBarItems(regProductTitle);		
		paginationOfRegisteredProd();
		
	}
}
