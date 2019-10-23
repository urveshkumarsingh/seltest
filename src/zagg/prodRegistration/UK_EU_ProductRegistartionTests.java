package zagg.prodRegistration;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;

import zagg.accountGeneral.AccountGeneralMethods;

@Priority(21)
public class UK_EU_ProductRegistartionTests extends ProductRegistartionMethods{
	AccountGeneralMethods ag= new AccountGeneralMethods();
	
	String leftNavTabOrders = "Registered Products";
	String accountDashboard= "Account Dashboard";
	
	
	/**Navigates to PR screen and validates all fields, titles, Alert messages**/
	@Test(priority=2101)
	public void loginIntoUKCustomer() throws Exception {
		logInfo("Entered into loginIntoUKCustomer() Test");
		loginWithAnotherUserByLocale(UKCountry, mailId, mailPwd);
		nav2RegisterScreen();
		
		
		
	}
	
	

	/**Navigates to PR screen and validates all fields, titles, Alert messages**/
	@Test(priority=2102)
	public void UK_verifyAllFields() throws Exception {
		logInfo("Entered into ukVerifyAllFields() Test");	
		nav2PRScreenInCountry(UKCountry);
		validatePRTitle("Product Registration");		
		validateAllFieldsforPR();
		
		
	}
	
	
	@Test(priority=2103)
	public void UK_RegisterProdThruSerialNumberForUK() throws Exception {
		logInfo("Entered into UK_RegisterProdThruSerialNumberForUK() Test");			
		nav2PRScreenInCountry(UKCountry);	
		registerSerialNumberWithDate(serialNumber);
		addAddress();
		reviewProductAndRegister(serialNumber);		
		validateWarrentOptions();
	}
	
	//SCREEN PROTECTION - Register a product thru Brand-->Device--->product . User passes data in excel sheet with testcase ID.
			@Test(priority=2104)
			public void UK_RegisterBatteryProduct() throws Exception {
				logInfo("Entered into UK_RegisterBatteryProduct() Test");
			try { 
				selectLeftTab("Account Dashboard");
				selectBtnRegisterAProduct();
				selectRegisterHere();
				selectCatgeory(catBatteryCases);					
				storeDataInProrpertyFile(catBatteryCases, batteryTcId);				
				selectproductUnderCategory(catBatteryCases, batteryTcId);	
				popupSerialNumber(serialNumber);
	    		enterPurchasedDate(-2);
	    		selectExistingAddress("shipping");
	    		checkPrivacyPolicy();
				registerProduct();
				isRegisteredConfirmed();
				}catch(WebDriverException wd) {
					nav2PRScreenInCountry(UKCountry);
					System.err.println(batteryTcId + "- related product is not able to select");
					}
			}
			
			
			
		@Test(priority=2105)
		public void UK_CompareAddressFieldswithExisting() throws Exception {
			logInfo("Entered into UK_CompareAddressFieldswithExisting() Test");
			String serialNumber = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689); 
			System.out.println(serialNumber);
			nav2PRScreenInCountry(UKCountry);	
			registerSerialNumberWithDate(serialNumber);
			compareAddress(State_uk);		
			
		}
		
		@Test(priority=2106)
		public void UK_ValidateScreenProtectAccordions() throws Exception {
			logInfo("Entered into UK_ValidateScreenProtectAccordions() Test");		
			nav2PRScreenInCountry(UKCountry);	
			selectRegisterHere();
			selectCatgeory(catScreenProt);		
			getAccoundiansBasedOnCategory(DeviceTypeAccordion);
			
		}
		
		@Test(priority=2107)
		public void UK_ValidateStatesForUSA() throws Exception {
			logInfo("Entered into UK_ValidateStatesForUSA() Test");
			String serialNumber = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689); 
			System.out.println(serialNumber);
			nav2PRScreenInCountry(UKCountry);	
			registerSerialNumberWithDate(serialNumber);
			getStatesOfUSA(UKCountry);		
			
		}
		
		
		
		
		
		/**Navigates to PR screen and validates all fields, titles, Alert messages**/
		@Test(priority=2121)
		public void loginAsEUCustomer() throws Exception {
			logInfo("Entered into loginAsEUCustomer() Test");
			loginWithAnotherUserByLocale(EUCountry, mailId, mailPwd);
			nav2RegisterScreen();		
			
		}
		
		@Test(priority=2122)
		public void EU_ValidateStatesForUSA() throws Exception {
			logInfo("Entered into EU_ValidateStatesForUSA() Test");
			String serialNumber = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689); 
			System.out.println(serialNumber);
			nav2PRScreenInCountry(EUCountry);	
			registerSerialNumberWithDate(serialNumber);
			getStatesOfUSA(EUCountry);		
			
		}
		
		
		@Test(priority=2123)
		public void EU_RegisterProdThruSerialNumberForEU() throws Exception {
			logInfo("Entered into EU_RegisterProdThruSerialNumberForEU() Test");			
			nav2PRScreenInCountry(EUCountry);	
			registerSerialNumberWithDate(serialNumberForEU);
			addAddress();
			reviewProductAndRegister(serialNumberForEU);		
			validateWarrentOptions();
		}
		
		
		@Test(priority=2124)
		public void EU_CompareAddressFieldswithExistingInEU() throws Exception {
			logInfo("Entered into EU_CompareAddressFieldswithExistingInEU() Test");
			String serialNumber = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689); 
			System.out.println(serialNumber);
			nav2PRScreenInCountry(EUCountry);	
			registerSerialNumberWithDate(serialNumber);
			compareAddress(State_eu);		
			
		}
		
		
			
	
	
	

}
