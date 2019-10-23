package zagg.prodRegistration;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;

@Priority(2)
public class ProductRegistartionTests extends ProductRegistartionMethods{
	
	
	String leftNavTabOrders = "Registered Products";
	String accountDashboard= "Account Dashboard";
	
	/**Navigates to PR screen and validates all fields, titles, Alert messages**/
	@Test(priority=201)
	public void verifyAllFields() throws Exception {
		logInfo("Entered into verifyAllFields() Test");
		nav2PRScreen();
		validatePRTitle(PRTitleText);
		handleOfferPopUp();
		validateAllFieldsforPR();		
	}
	
	
	/**Navigates to PR screen and validates all fields, titles, Alert messages**/
	@Test(priority=202)
	public void serialNumberValidationInSections() throws Exception {
		logInfo("Entered into serialNumberValidationInSections() Test");
		nav2PRScreen();			
		serialValidation(serialNumber);
		
	}
	
	@Test(priority=203)
	public void calender_FutureDateValidation() throws Exception {
		logInfo("Entered into calender_FutureDateValidation() Test");
		nav2PRScreen();	
		validateCalenderDates(serialNumber);
	}
	
	@Test(priority=204)
	public void addressMandatoryFields() throws Exception {
		logInfo("Entered into calender_FutureDateValidation() Test");
		nav2PRScreen();	
		registerSerialNumberWithDate(serialNumber);
		validateaddAddressMandatories();
		
	}
	
	
	@Test(priority=205)
	public void registerProdThruSerialNumber() throws Exception {
		logInfo("Entered into registerProdThruSerialNumber() Test");			
		nav2AccountDashboard();
		nav2PRScreen();	
		System.out.println(serialNumber);
		registerSerialNumberWithDate(serialNumber);
		addAddress();
		reviewProductAndRegister(serialNumber);
		registeredProducts(noOfDays);
    	validateWarrentOptions();
	}
	
	@Test(priority=206)
	public void validateSerialNumberWithAnotherUser() throws Exception {
		logInfo("Entered into validateSerialNumberWithAnotherUser() Test");		
		loginWithAnotherUser(secondUsermailId, mailPwd);
		nav2AccountDashboard();
		nav2PRScreen();	
		System.out.println("sconfd "+serialNumber);
		verifyRegisteredSerialNumber(serialNumber);		
    	boolean isPresent= leftTabItems(leftNavTabOrders);
    	if(isPresent==false) {
    		loginWithAnotherUser(mailId, mailPwd);    		
    	}else {
    		
			logoutAsCustomer();			
			selectSignIn(USACountry);
			existingUserLogin(mailId, mailPwd);
			Assert.assertTrue(isPresent, leftNavTabOrders+ " is not able to Registered");
    	}
    	
	}	
	

	
	//bug-3010  Bleow 5 tests verifies All the accodions are displaying as per selected Category.
	@Test(priority=208)
	public void validateBatteryAndCablesAccordions() throws Exception {
		logInfo("Entered into validateBatteryAndCasesAccordions() Test");		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catBatteryCases);
		getAccoundiansBasedOnCategory(brandAccoridon);	
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catCablesAdapters);
		getAccoundiansBasedOnCategory(productLineAccordion);
	
		
	}
	
	
	@Test(priority=209)
	public void validateCasesAndHeadPhonesAccordions() throws Exception {
		logInfo("Entered into validateCasesAndHeadPhonesAccordions() Test");		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catCases);
		getAccoundiansBasedOnCategory(brandAccoridon);	
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catHeadPhones);
		getAccoundiansBasedOnCategory(productLineAccordion);
		
	}
	
	
	@Test(priority=210)
	public void validatekeyboardAndPortablePowerAccordions() throws Exception {
		logInfo("Entered into validatekeyboardAndPortablePowerAccordions() Test");		
		nav2PRScreenInCountry(USACountry);
		selectRegisterHere();
		Thread.sleep(3000);
		selectCatgeory(catKeyboard);
		getAccoundiansBasedOnCategory(deviceAccoridon);		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catPortablePower);
		getAccoundiansBasedOnCategory(productLineAccordion);
		
	}
	
	
	@Test(priority=211)
	public void validateReplacementAndScreenProtectAccordions() throws Exception {
		logInfo("Entered into validateReplacementAndScreenProtectAccordions() Test");		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catReplacement);
		getAccoundiansBasedOnCategory(productLineAccordion);		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catScreenProt);		
		getAccoundiansBasedOnCategory(DeviceTypeAccordion);
		
	}
	
	
	@Test(priority=212)
	public void validateSpeakersAndWirelessDocksAccordions() throws Exception {
		logInfo("Entered into validateWirelessDocksAccordions() Test");		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catSpeakers);
		getAccoundiansBasedOnCategory(productLineAccordion);		
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catWireless);		
		getAccoundiansBasedOnCategory(productLineAccordion);
		
	}
	
	
	
	
	
	//Enter serial number which mismatched with sku number 
	@Test(priority=215)
	public void mismatchedSerialNumber() throws Exception {
		logInfo("Entered into mismatchedSerialNumber() Test");		
		nav2PRScreen();	
		verifyRegisteredSerialNumber(serialNumberNotValid);
		getMsgOfMismatchedSKU();		
	}
	
	//BUG- 4031 - PR - Addresses are being saved as duplicates again
	//Once Product is registered, verifies duplicated address is generated or not
		@Test(priority=216)
		public void bug_4031_validateDuplicateAddress() throws Exception {
			logInfo("Entered into bug_4031_validateDuplicateAddress() Test");		
			selectLeftTab("Account Dashboard");
			selectBtnRegisterAProduct();
			selectRegisterHere();		
			selectCatgeory(catBatteryCases);		
			storeDataInProrpertyFile(catBatteryCases, tc2);
			selectproductUnderCategory(catBatteryCases,tc2);		
			popupSerialNumber(serialNumber);
			enterPurchasedDate(-2);		
			int beforeRegister = getAllAddressCount();
	    	registerProduct();
	    	isRegisteredConfirmed();
	    	selectLeftTab("Account Dashboard");
			selectBtnRegisterAProduct();
			selectRegisterHere();		
			selectCatgeory(catBatteryCases);		
			storeDataInProrpertyFile(catBatteryCases, tc2);
			selectproductUnderCategory(catBatteryCases,tc2);		
			popupSerialNumber(serialNumber);
			enterPurchasedDate(-2);		
			int afteRegisteration = getAllAddressCount();
			Assert.assertEquals(beforeRegister, afteRegisteration);
	    	
		}
		
		//Bug_3000 - Device Type Options should be Smartphones, Tablets, Laptops, Watches, Other
		
		@Test(priority=217)
		public void bug_3000_VerifyDeviceTypeForScreenProtection() throws Exception {
			logInfo("Entered into verifyDeviceTypeForScreenProtection() Test");				
				nav2PRScreen();
				selectRegisterHere();
				selectCatgeory(catScreenProt);	
				listOfDeviceType();
		
		}	
		
		
		@Test(priority=218)
		public void compareAddressFieldswithExistingInUSA() throws Exception {
			logInfo("Entered into compareAddressFieldswithExistingInUSA() Test");
			String serialNumber = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689); 
			System.out.println(serialNumber);
			nav2PRScreenInCountry(USACountry);	
			registerSerialNumberWithDate(serialNumber);
			compareAddress(StateUS);		
			
		}
	
	
	
		
	/**Work Flow-2 - Navigate to till Review page then back navigation , verifies all page titles in reverse order. **/
	@Test(priority=230)
	public void bug_3407_backToOptionsFromReveiw() throws Exception {
		logInfo("Entered into bug_3407_backToOptionsFromReveiw() Test");
		nav2PRScreen();
		selectRegisterHere();
		selectCatgeory(catBatteryCases);
		//storeDataInProrpertyFile(catBatteryCases, tc2);
		selectproductUnderCategory(catBatteryCases,tc2);		
		popupSerialNumber(serialNumber);		
		enterPurchasedDate(-2);
		selectExistingAddress("shipping");
		validatebackToOptions();		
		
	}	
	//BATTERY CASES - Register a product thru Brand-->Device--->product . User passes data in excel sheet with testcase ID.
		@Test(priority=231)
		public void registerMultiBatteryCasesProducts() throws Exception {
			logInfo("Entered into registerMultiBatteryCasesProducts() Test");			
			int rowsCount = getRowsCoutFromSheet(catBatteryCases);
			for(int i= 1; i<=rowsCount; i++) {
			try {
				selectLeftTab("Account Dashboard");
				selectBtnRegisterAProduct();
				selectRegisterHere();		
				selectCatgeory(catBatteryCases);		
				storeDataInProrpertyFile(catBatteryCases, tc+i);
				selectproductUnderCategory(catBatteryCases,tc+i);		
				popupSerialNumber(serialNumber);
				enterPurchasedDate(-2);		
				selectExistingAddress("shipping");
		    	registerProduct();
		    	isRegisteredConfirmed();				
				}catch(WebDriverException wd) {
				nav2PRScreen();
				System.err.println(tc+i + "- related product is not able to select");
			}
			
			}
		}
		
		
		//CABLES AND ADAPTERS : Register a product thru Device--->product . User passes data in excel sheet with testcase ID.
		@Test(priority=232)
		public void registerMultiCable$AdaptersProducts() throws Exception {
			logInfo("Entered into registerMultiCable$AdaptersProducts() Test");
			int rowsCount = getRowsCoutFromSheet(catCablesAdapters);			
			for(int i= 1; i<=rowsCount; i++) {
			try { 
			selectLeftTab("Account Dashboard");
			selectBtnRegisterAProduct();
			selectRegisterHere();
			selectCatgeory("Cables, Adapters & Accessories");					
			storeDataInProrpertyFile(catCablesAdapters, tc+i);	
			selectproductUnderCategory(catCablesAdapters, tc+i);		
			popupSerialNumber(serialNumber);
			enterPurchasedDate(-2);
			selectExistingAddress("shipping");
			registerProduct();
			isRegisteredConfirmed();
			}catch(WebDriverException wd) {
				nav2PRScreen();
				System.err.println(tc+i + "- related product is not able to select");
			}	}
			
		}
	
	//CASES : Register a product thru product . User passes data in excel sheet with testcase ID.
	@Test(priority=233)
	public void registerMultiCasesProducts() throws Exception {
		logInfo("Entered into registerMultiCasesProducts() Test");
		int rowsCount = getRowsCoutFromSheet(catCases);
		for(int i= 1; i<=rowsCount; i++) {
		try {
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();			
		selectCatgeory(catCases);		
		storeDataInProrpertyFile(catCases,tc+i);	
		selectproductUnderCategory(catCases, tc+i);
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);
		selectExistingAddress("billing");
		registerProduct();
		isRegisteredConfirmed();
		}catch(WebDriverException wd) {
			nav2PRScreen();
			System.err.println(tc+i + "- related product is not able to select");
		}	}
	}
	
	
	//HEADPHONES: Register a product thru product . User passes data in excel sheet with testcase ID.
	@Test(priority=234)
	public void registerMultiHeadphonesProducts() throws Exception {
		logInfo("Entered into registerMultiHeadphonesProducts() Test");
		int rowsCount =getRowsCoutFromSheet(catHeadPhones);
		for(int i= 1; i<=rowsCount; i++) {
		try {
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();
		selectCatgeory(catHeadPhones);		
		storeDataInProrpertyFile(catHeadPhones,tc+i);	
		selectproductUnderCategory(catHeadPhones,tc+i);						
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);
		selectExistingAddress("shipping");
		registerProduct();	
		isRegisteredConfirmed();
		}catch(WebDriverException wd) {
			nav2PRScreen();
			System.err.println(tc+i + "- related product is not able to select");
		}	}
		
	}
	
	//KEYBOARDS - Register a product thru Device--->product . User passes data in excel sheet with testcase ID.
	@Test(priority=235)
	public void registerMultiKeyboardsProducts() throws Exception {
		logInfo("Entered into registerMultiKeyboardsProducts() Test");	
		int rowsCount = getRowsCoutFromSheet(catKeyboard);
		for(int i= 1; i<=rowsCount; i++) {
		try {
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();
		selectCatgeory(catKeyboard);			
		storeDataInProrpertyFile(catKeyboard, tc+i);
		selectproductUnderCategory(catKeyboard,tc+i);
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);
		selectExistingAddress("billing");
		registerProduct();
		isRegisteredConfirmed();
		}catch(WebDriverException wd) {
			nav2PRScreen();
			System.err.println(tc+i + "- related product is not able to select");
		}	}
		
	}
			
	//PROTABLE POWER: Register a product thru product . User passes data in excel sheet with testcase ID.
	@Test(priority=236)
	public void registerMultiProtablePowerProducts() throws Exception {
		logInfo("Entered into registerProtablePowerProducts() Test");
		int rowsCount =getRowsCoutFromSheet(catPortablePower);
		for(int i= 1; i<=rowsCount; i++) {
		try {
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();
		selectCatgeory(catPortablePower);		
		storeDataInProrpertyFile(catPortablePower,tc+i);	
		selectproductUnderCategory(catPortablePower, tc+i);					
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);
		selectExistingAddress("shipping");
		registerProduct();
		isRegisteredConfirmed();
		}catch(WebDriverException wd) {
			nav2PRScreen();
			System.err.println(tc+i + "- related product is not able to select");
		}	}
	}
	
	
	//REPLACMENT PARTS: Register a product thru product . User passes data in excel sheet with testcase ID.
		@Test(priority=237)
		public void registerMultiReplacementPartsProducts() throws Exception {
			logInfo("Entered into registerMultiReplacementPartsProducts() Test");
			int rowsCount =getRowsCoutFromSheet(catReplacement);
			for(int i= 1; i<=rowsCount; i++) {
			try {
			selectLeftTab("Account Dashboard");
			selectBtnRegisterAProduct();
			selectRegisterHere();
			selectCatgeory(catReplacement);		
			storeDataInProrpertyFile(catReplacement,tc+i);	
			selectproductUnderCategory(catReplacement, tc+i);					
			popupSerialNumber(serialNumber);
			enterPurchasedDate(-256);
			selectExistingAddress("billing");
			registerProduct();
			isRegisteredConfirmed();
			}catch(WebDriverException wd) {
				nav2PRScreen();
				System.err.println(tc+i + "- related product is not able to select");
			}	}
		}
	
	//SCREEN PROTECTION - Register a product thru Brand-->Device--->product . User passes data in excel sheet with testcase ID.
		@Test(priority=238)
		public void registerMultiScreenProtectionProduct() throws Exception {
			logInfo("Entered into registerMultiScreenProtectionProduct() Test");
			int rowsCount =getRowsCoutFromSheet(catScreenProt);
			System.out.println("rowsCount "+rowsCount);
			for(int i= 1; i<=rowsCount; i++) 
			{
			try { System.out.println("loop "+i);
			selectLeftTab("Account Dashboard");
			selectBtnRegisterAProduct();
			selectRegisterHere();
			selectCatgeory(catScreenProt);					
			storeDataInProrpertyFile(catScreenProt, tc+i);				
			selectproductUnderCategory(catScreenProt, tc+i);	
			popupSerialNumber(serialNumber);
    		enterPurchasedDate(-2);
    		selectExistingAddress("shipping");
			registerProduct();
			isRegisteredConfirmed();
			}catch(WebDriverException wd) {
				nav2PRScreen();
				System.err.println(tc+i + "- related product is not able to select");
			}	}
		}
	
		
		//SPEAKERS: Register a product thru product . User passes data in excel sheet with testcase ID.
		@Test(priority=239)
		public void registerMultiSpeakersProducts() throws Exception {
			logInfo("Entered into registerMultiSpeakersProducts() Test");
			int rowsCount = getRowsCoutFromSheet(catSpeakers);
			for(int i= 1; i<=rowsCount; i++) {
			try {
			selectLeftTab("Account Dashboard");
			selectBtnRegisterAProduct();
			selectRegisterHere();
			selectCatgeory(catSpeakers);		
			storeDataInProrpertyFile(catSpeakers,tc+i);	
			selectproductUnderCategory(catSpeakers,tc+i);						
			popupSerialNumber(serialNumber);
			enterPurchasedDate(-365);
			selectExistingAddress("shipping");
			registerProduct();	
			isRegisteredConfirmed();
			}catch(WebDriverException wd) {
				nav2PRScreen();
				System.err.println(tc+i + "- related product is not able to select");
			}	}
			
		}
		
	//WIRELESS DOCKS: Register a product thru product . User passes data in excel sheet with testcase ID.
	@Test(priority=240)
	public void registerMultiWirelessDocksProducts() throws Exception {
		logInfo("Entered into registerSpeakersProducts() Test");
		int rowsCount = getRowsCoutFromSheet(catWireless);
		for(int i= 1; i<=rowsCount; i++) {
		try {
		nav2PRScreen();		
		selectLeftTab("Registered Products");
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();
		selectCatgeory(catWireless);		
		storeDataInProrpertyFile(catWireless,tc+i);	
		selectproductUnderCategory(catWireless,tc+i);						
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-365);
		selectExistingAddress("shipping");
		registerProduct();	
		isRegisteredConfirmed();
		}catch(WebDriverException wd) {
			nav2PRScreen();
			System.err.println(tc+i + "- related product is not able to select");
		}	}
		
	}
	
	
	
	//Bug-4034  - Verify that US states has dot for state names. 
	@Test(priority=242)
	public void bug_4034_DoesStateHasDot() throws Exception {
		logInfo("Entered into bug_4034_DoesStateHasDot() Test");	
		selectLeftTab("Account Dashboard");
		selectBtnRegisterAProduct();
		selectRegisterHere();		
		selectCatgeory(catBatteryCases);		
		storeDataInProrpertyFile(catBatteryCases, batteryTcId);
		selectproductUnderCategory(catBatteryCases,batteryTcId);		
		popupSerialNumber(serialNumber);
		enterPurchasedDate(-2);	
		states();
		
			
	
	}
	
	
	//Below Testcases have to execute for WR module.	
	//BATTERY CASES - Register a product thru Brand-->Device--->product . User passes data in excel sheet with testcase ID.
			@Test(priority=243)
			public void PR_RegisteredProductEmail() throws Exception {
				logInfo("Entered into PR_RegisteredProductEmail() Test");	
				selectLeftTab("Account Dashboard");
				selectBtnRegisterAProduct();
				selectRegisterHere();		
				selectCatgeory(catBatteryCases);		
				storeDataInProrpertyFile(catBatteryCases, batteryTcId);
				selectproductUnderCategory(catBatteryCases,batteryTcId);		
				popupSerialNumber(serialNumber);
				enterPurchasedDate(-2);		
				selectExistingAddress("shipping");
		    	registerProduct();
		    	isRegisteredConfirmed();		    	
		    	gmailLogin(mailId,mailPRAccount );	
		    	homePage();
			
			}		
			
			@Test(priority=270)
			public void bug_3969_RegisterProductFromAdmin() throws Exception {
				logInfo("Entered into bug_3969_RegisterProductFromAdmin() Test");								
					try {
					nav2adminWithCredentials(admin, adminPassword);
					selectLeftTabsInAdmin("CUSTOMERS");
					quickSearchCustomer();
					filterInQuickSearch(unqName,lastName,mailId);
					editCustomer(mailId);
					loginAsCust();
										
					selectLeftTab("Registered Products");
					selectLeftTab("Account Dashboard");
					selectBtnRegisterAProduct();
					selectRegisterHere();		
					selectCatgeory(catCases);		
					storeDataInProrpertyFile(catCases, casesTcId);
					selectproductUnderCategory(catCases,casesTcId);		
					popupSerialNumber(serialNumber);
					enterPurchasedDate(-2);		
					selectExistingAddress("shipping");
					//checkPrivacyPolicy();
			    	registerProduct();
			    	isRegisteredConfirmed();
			    	loginWithAnotherUser(mailId, mailPwd);			    	
			    	}catch(Exception ex) {
			    		//loginWithAnotherUser(mailId, mailPwd);	
			    		ex.printStackTrace();
			    	}				
			}	

}
