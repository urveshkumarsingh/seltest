package zagg.accountGeneral;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(6)
public class PurchaseHistory extends AccountGeneralMethods{	
	
	@Test(priority=601)
	public void purchaseHistoryGrid() throws Exception {
		logInfo("Entered into pruchaseHistoryGrid() method");
		selectSideBarItems(phTitle);
		verifyColumnName();
		paginationOfPuchaseHistory();
		
		
		
	}
	

}
