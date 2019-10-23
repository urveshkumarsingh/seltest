package zagg.prodRegistration;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lib.TestBase;

import zagg.accountRegistration.LoginMethods;

public class ProductRegistartionMethods extends LoginMethods{	
	SoftAssert softAssert = new SoftAssert();	
	public int noOfDays= -2;
	String accountDashboard= "Account Dashboard";
	
	public void existingUserLogin(String emailId, String password) throws Exception {
		logInfo("Enter into existingUserLogin() method");	
		clearText("cssSelector", existEmail);
		clearText("cssSelector", existPwd);
		enterText("cssSelector", existEmail, emailId);		
		enterText("cssSelector", existPwd, password);
		Thread.sleep(2000);
		clickOnButton("cssSelector", exSignInBtn);
//		driver.navigate().refresh();
		
	}
	
	
	/** Navigates to Product Registration Screen*/
	public void nav2PRScreen() throws Exception {
        logInfo("Enter into nav2PRScreen() method");        
        driver.navigate().to(appUrl+"en_us/product_registration/");  
        
	}
	
	/** Navigates to Product Registration Screen*/
	public void nav2PRScreenInCountry(String country) throws Exception {
        logInfo("Enter into nav2PRScreen() method");        
        driver.navigate().to(appUrl+"en_"+country+"/product_registration/");  
        
	}
	
	/** Navigates to Product Registration Screen*/
	public void nav2AccountDashboard() throws Exception {
        logInfo("Enter into nav2AccountDashboard() method");
        driver.navigate().to(appUrl+"en_us/customer/account/");        
	}
	
	
	public boolean leftTabItems(String tabName) throws Exception {
		boolean isPresent = false;
		wdWait("cssSelector", lftTabs);
		List<WebElement> tabs = driver.findElements(By.cssSelector(lftTabs));
		for(WebElement tab :tabs) {
			System.out.println(tab.getText().trim());
			if(tab.getText().trim().equalsIgnoreCase(tabName)) {
				isPresent=true;
				tab.click();
				break;
			}
		}
		return isPresent;
		
	}
	
	public boolean nav2RegisterScreen() throws Exception {
		logInfo("Enter into nav2RegisterScreen() method");
		validateHomeTitle(accountDashboard);
		boolean isPresent = false;
		wdWait("cssSelector", prRegisterBtn);
		List<WebElement> tabs = driver.findElements(By.cssSelector(prRegisterBtn));
		for(WebElement tab :tabs) {
			System.out.println(tab.getText().trim());
			if(tab.getText().trim().equalsIgnoreCase(RegisterBtnText)) {
				isPresent=true;
				tab.click();
				validatePRTitle(PRTitleText);	
				break;
			}
		}
		return isPresent;
		
	}
	
	 /** Navigates to Product Registration Screen with login  credentials*/
		public void nav2adminWithCredentials(String userName, String pwd) throws Exception {
	        logInfo("Enter into nav2adminWithCredentials() method");
	        driver.navigate().to(appUrl+adminAccess); 
	        waitOnSpinner();
	        wdWait("cssSelector", adminUserName);
	        clearText("cssSelector", adminUserName);
	        clearText("cssSelector", adminUserPwd);
	        enterText("cssSelector", adminUserName, userName);
	        enterText("cssSelector", adminUserPwd, pwd);
	        clickOnButton("cssSelector", adminSignIn);
	        List<WebElement> error= driver.findElements(By.cssSelector(adminLoginError));
	        if(error.size()==1) {clearText("cssSelector", adminUserName);
	        clearText("cssSelector", adminUserPwd);
	        enterText("cssSelector", adminUserName, userName);
	        enterText("cssSelector", adminUserPwd, pwd);
	        clickOnButton("cssSelector", adminSignIn);      	
	        System.out.println("Entered getremkl");	
	        }
	        
	        
	        
	        //submitObject("cssSelector", adminUserPwd);	        
	        //clickOnObject("cssSelector", closeIncommingMsg);
	        driver.navigate().to(appUrl+adminAccess+"catalog/product_attribute/"); 
	        waitOnSpinner();
	        
		}
		
		/**Selects Quick Search tab and verify screen
		 * @throws Exception **/
		public void quickSearchCustomer() throws Exception {
			logInfo("Entered into quickSearchCustomer() method.");
			wdWait("cssSelector", custQuickSearch);
			clickOnObject("cssSelector", custQuickSearch);
			waitOnSpinner();
			productAttributeTitle("Customer Quick Search");
			waitOnSpinner();
				
		}
		
		public void filterInQuickSearch(String firstname, String lastName, String emailId) throws Exception {
			logInfo("Entered into filterInQuickSearch() method.");
			Thread.sleep(5000);
			waitOnSpinner();
			wdWait("cssSelector", filter);
			JavascriptExecutor jse = (JavascriptExecutor)driver;	
			WebElement filters = driver.findElement(org.openqa.selenium.By.cssSelector(filter));
			System.out.println(filters.getText());
			jse.executeScript("arguments[0].click();", filters);
		
//			clearText("cssSelector", filterFName);
//			clearText("cssSelector", filterLName);
//			clearText("cssSelector", filterEmail);
//			enterText("cssSelector", filterFName,firstname);
//			enterText("cssSelector", filterLName,lastName);
//			enterText("cssSelector", filterEmail,emailId);
			List<WebElement> fields = driver.findElements(By.cssSelector(filterFieldTitle));
			for(int i=2;i<=fields.size()+1;i++) {
				String fieldName = driver.findElement(By.cssSelector(filterFieldTitleBfr+i+filterFieldTitleAfr)).getText().trim();
				if(fieldName.equalsIgnoreCase("First Name")) {
					WebElement fn= driver.findElement(By.cssSelector(filterFieldTitleBfr+i+fliterFieldTextAft));
					clearText("cssSelector", filterFieldTitleBfr+i+fliterFieldTextAft);
					fn.sendKeys(firstname);
				}if(fieldName.equalsIgnoreCase("Last Name")) {
					WebElement ln= driver.findElement(By.cssSelector(filterFieldTitleBfr+i+fliterFieldTextAft));
					clearText("cssSelector", filterFieldTitleBfr+i+fliterFieldTextAft);
					ln.sendKeys(lastName);					
				}else if(fieldName.equalsIgnoreCase("Email")){
					WebElement ln= driver.findElement(By.cssSelector(filterFieldTitleBfr+i+fliterFieldTextAft));
					clearText("cssSelector", filterFieldTitleBfr+i+fliterFieldTextAft);
					ln.sendKeys(emailId);
				}
			}			
			clickOnButton("cssSelector", filterApply);
			waitOnSpinner();
			Thread.sleep(3000);
			
		}
		
		
		
		
		
		/**validates the PR Screen title 
		 * @throws Exception **/
		public void validatePRTitle(String expTitle) throws Exception {
			wdWait("cssSelector", PRTitle);
			String actTitle = driver.findElement(By.cssSelector(PRTitle)).getText();
			Assert.assertEquals(actTitle, expTitle);
		}
		
		
	/**Validates PR home screen with labels , fields, alert message ***/
	public void validateAllFieldsforPR() throws Exception {
		logInfo("Enter into validateAllFieldsforPR() method");
		//Serial Number fields and labels validation
		wdWait("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		clickOnButton("xpath", contBtn);
		wdWait("xpath", serialErr);		
		String actMandatoryMsg= getText("xpath", serialErr);		
		softAssert.assertEquals(actMandatoryMsg, errorDiscount);
		clearText("cssSelector", noSerialNoFieldTitle);
		String actSerialTitle = getText("cssSelector", serialSecTitle);		
		softAssert.assertEquals(actSerialTitle, serialSecTitleText);
		wdWait("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		enterText("cssSelector", noSerialNoFieldTitle, "abcdef");
		clickOnButton("xpath", contBtn);
		wdWait("xpath", contBtn);
		clickOnButton("xpath", contBtn);
		Thread.sleep(4000);
		wdWait("xpath", serialErr);
		String actErrorMsg= getText("xpath", serialErr);		
		softAssert.assertEquals(actErrorMsg, serialErrText);
		clearText("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		enterText("cssSelector", noSerialNoFieldTitle, "123");
		clickOnButton("xpath", contBtn);
		wdWait("xpath", contBtn);
		clickOnButton("xpath", contBtn);
		Thread.sleep(4000);
		wdWait("xpath", serialErr);
		String actAlertMsg= getText("xpath", serialErr);	
		softAssert.assertEquals(actAlertMsg, serialAlertMsg);
		String actSerialSubTitle = getText("cssSelector", serialSecSubTitle);
		softAssert.assertEquals(actSerialSubTitle, serialSecSubTitleText);
		String actAttOfSerial= getAttribute("cssSelector", noSerialNoFieldTitle, "placeholder");
		softAssert.assertEquals(actAttOfSerial, serialPlaceholderText);
		String actContinueText= getText("xpath", contBtn);
		softAssert.assertEquals(actContinueText, contBtnText);		
		String findSerialLnk=getText("cssSelector", howFindSerialLnk);		
		softAssert.assertEquals(findSerialLnk, findSerialText);

		/**Don't have serial Number labels validation      ***/		
		String actNoSerialTitle = getText("cssSelector", noSerialSecTitle);		
		Assert.assertEquals(actNoSerialTitle, noSerialSecTitleText);		
		String actNoSerialSubTitle = getText("cssSelector", noSerialSecSubTitle);		
		Assert.assertEquals(actNoSerialSubTitle, noSerialSecSubTitleText);
		String registerText  = getText("cssSelector", registerBtn);	
		softAssert.assertEquals(registerText, registerBtnText);	
		softAssert.assertAll();
		
	}	
	
	
	
	/**Enter product serialNumber or Reg Code and enter Date of purchase, then continue
	 * @throws Exception **/
	public void registerSerialNumberWithDate(String serialOrRegCode) throws Exception {
		logInfo("Enter into registerSerialNumberWithDate() method");
		wdWait("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		enterText("cssSelector", noSerialNoFieldTitle, serialOrRegCode);
		clickOnButton("xpath", contBtn);
		Thread.sleep(5000);
		waitOnSpinnerInPR();
		wdWait("cssSelector", dateField);
		String actPurchase= getText("cssSelector", purchaseLabel);
		if(actPurchase.equalsIgnoreCase(purchaseText)) {
			wdWait("cssSelector", dateField);
			wdWait("cssSelector", continueInOptions);
			enterPurchasedDate(noOfDays);
			wdWait("cssSelector", ratingWidget);
			clickOnObject("cssSelector", ratingWidget);
			System.out.println(getText("cssSelector", continueInOptions));
			scrollDown("cssSelector", continueInOptions);
			clickOnButton("cssSelector", continueInOptions);
			waitOnSpinner();
			
		}else {
			Assert.assertEquals(actPurchase, purchaseText +" is not present , so invalid SerialNumber is given");
		}	
	}
	
		
	
	/**Enter product serialNumber or Reg Code and enter Date of purchase, then continue
	 * @throws Exception **/
	public void verifyRegisteredSerialNumber(String serialOrRegCode) throws Exception {
		logInfo("Enter into verifyRegisteredSerialNumbere() method");		
		wdWait("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		enterText("cssSelector", noSerialNoFieldTitle, serialOrRegCode);
		clickOnButton("xpath", contBtn);		
		wdWait("xpath", serialErr);
		List<WebElement> err = driver.findElements(By.cssSelector(purchaseLabel));
		for(WebElement errMsg :err) {
			String msg = errMsg.getText().trim();
			System.out.println("msg "+msg);
			if(msg.equalsIgnoreCase(purchaseText)){	
				loginWithAnotherUser(mailId, mailPwd);  
				Assert.assertNotEquals(msg,purchaseText );
				break;
			}if(err.size()==0){
				
				String actT = getText("xpath", serialErr);
				System.out.println("Successded" +actT);
				
			}
			
			
			
		}
	
	}
	
	
	
	/**Enter product serialNumber or Reg Code and enter Date of purchase, then continue
	 * @throws Exception **/
	public void validateCalenderDates(String serialOrRegCode) throws Exception {
		logInfo("Enter into validateCalenderDates() method");
		wdWait("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		enterText("cssSelector", noSerialNoFieldTitle, serialOrRegCode);
		clickOnButton("xpath", contBtn);	
		wdWait("cssSelector", dateField);		
		wdWait("cssSelector", continueInOptions);
		clickOnButton("cssSelector", continueInOptions);
		enterPurchasedDate(-2);
		enterPurchasedDate(-4);
			
	}
	
	/**Enter product serialNumber or Reg Code and enter Date of purchase, then continue
	 * @throws Exception **/
	public void serialValidation(String serialOrRegCode) throws Exception {
		logInfo("Enter into validateCalenderDates() method");
		wdWait("cssSelector", noSerialNoFieldTitle);
		clearText("cssSelector", noSerialNoFieldTitle);
		enterText("cssSelector", noSerialNoFieldTitle, serialOrRegCode);
		clickOnButton("xpath", contBtn);
		Thread.sleep(5000);
		
		//waitTillSpinnerDisable(driver, by)
		
		
		wdWait("cssSelector", dateField);		
		wdWait("cssSelector", continueInOptions);
		WebElement firstText = driver.findElement(By.xpath(serialNoVerified));
		
		
		String Acttext= firstText.getText();		
		System.out.println("text"+Acttext);
		softAssert.assertEquals(Acttext, serialNoText);
		enterPurchasedDateForSerial(0);
		
		
//		clickOnButton("cssSelector", continueInOptions);		
//		wdWait("xpath", serialNo2ndVerified);
//		WebElement secondText = driver.findElement(By.xpath(serialNo2ndVerified));
//		
//		
//		String ActSecondText= secondText.getText();
//		//String Acttext1= text.getAttribute(name);
//		System.out.println("text"+ActSecondText);
//		softAssert.assertEquals(ActSecondText, serialNoText);
		
		softAssert.assertAll();
		
			
	}
	
	
	//This method is used to enter pastDate, current Date, Future dates
	public void enterPurchasedDate(int date) throws Exception {
		logInfo("Enter into enterPurchasedDate() method");
		String calDate = getDate(date, "MM/dd/yyyy");	
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("document.getElementById('datetimepicker').value= '"+calDate+"'");		
		wdWait("cssSelector", dateIcon);
		clickOnObject("cssSelector", dateIcon);
		implicityWaits(5);
		wdWait("xpath", dateOpened);
		Actions act = new Actions (driver);
		WebElement calend = driver.findElement(By.xpath(dateOpened));		
		act.doubleClick(calend).build().perform();
		
		
	}
	
	//This method is used to enter pastDate, current Date, Future dates
		public void enterPurchasedDateForSerial(int date) throws Exception {
			logInfo("Enter into enterPurchasedDateForSerial() method");
			String calDate = getDate(date, "MM/dd/yyyy");	
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("document.getElementById('datetimepicker').value= '"+calDate+"'");		
			wdWait("cssSelector", dateIcon);
			clickOnObject("cssSelector", dateIcon);
			implicityWaits(5);
			wdWait("cssSelector", openedDate);
//			clickOnObject("cssSelector", dateIcon);
			Actions act = new Actions (driver);
			WebElement calend = driver.findElement(By.cssSelector(openedDate));
			
			act.doubleClick(calend).build().perform();
			
		
			
		}

	
	/**Add Billing or Shipping address details
	 * @throws Exception **/
	public void addAddress() throws Exception {
		logInfo("Enter into addAddress() method");
		wdWait("id", addFName);
		clearText("id", addFName);
		clearText("id", addLName);
		clearText("id", addCompany);
		clearText("id", addAddress1);		
		clearText("cssSelector", addPhone);
		clearText("id", addAddress2);
		clearText("id", addPostCode);
		clearText("id", addCity);
		enterText("id", addFName, unqName);
		enterText("id", addLName, lastName);
		enterText("id", addCompany, "ZAGG");
		enterText("cssSelector", addPhone,phoneNumber);
		if(driver.getCurrentUrl().contains("/en_us")) {			
			scrollDown("cssSelector", addNewCountry);
			clickOnObject("cssSelector", addNewCountry);
			boolean isCountryPresent =false;
			List<WebElement> cntry= driver.findElements(By.cssSelector(addNewCountryOption));
			int cnrtySize= cntry.size();
			for(int i=2;i<=cnrtySize;i++) {				
				WebElement cntryName=driver.findElement(By.cssSelector(addNewCountryBfr+i+")"));
				String names = cntryName.getText().trim();
				if(names.equalsIgnoreCase(countryUS)) {
					isCountryPresent =true;
					cntryName.click();
					waitOnSpinner();					
					enterText("id", addCity, city);
					clickOnObject("cssSelector", addState);				
					selectFromDropdown("cssSelector", addState, "byVisibleText", StateUS);
					enterText("name", addPostCode, postCode);
					enterText("id", addAddress1, address1);
					enterText("id", addAddress2, address2);
					wdWait("cssSelector", continueInAddress);
					clickOnButton("cssSelector", continueInAddress);
					break;
				}
			
			}if(!isCountryPresent) {
				Assert.assertTrue(isCountryPresent, countryUS+ " is not present.");
			}
			
		}else if(driver.getCurrentUrl().contains("/en_uk")){			
			scrollDown("cssSelector", addNewPostcode);
			clickOnObject("cssSelector", addNewCountry);
			scrollDown("cssSelector", addNewCountry);
			//selectFromDropdown("cssSelector", addNewCountryOption, "byVisibleText", country_uk);
			clickOnObject("cssSelector", addNewCountry);
			boolean isCountryPresent =false;
			List<WebElement> cntry= driver.findElements(By.cssSelector(addNewCountryOption));
			int cnrtySize= cntry.size();
			for(int i=1;i<=cnrtySize;i++) {
				WebElement cntryName=driver.findElement(By.cssSelector(addNewCountryBfr+i+")"));
				String names = cntryName.getText().trim();
				if(names.equalsIgnoreCase(country_uk)) {
					isCountryPresent =true;
					cntryName.click();
					waitOnSpinner();
					enterText("cssSelector", addStateTxtField,State_uk);
					enterText("id", addAddress1, address1_uk);
					enterText("id", addAddress2, address2_uk);
					enterText("id", addCity, city_uk);
					clearText("cssSelector", addNewPostcode);
					enterText("cssSelector", addNewPostcode,postCode_uk);
					wdWait("cssSelector", continueInAddress);
					clickOnButton("cssSelector", continueInAddress);
					scrollDown("cssSelector", continueInAddress);
					clickOnButton("cssSelector", continueInAddress);					
					break;
				}
			}if(!isCountryPresent) {
				Assert.assertTrue(isCountryPresent, country_uk+ " is not present.");
			}			
		}else {
			scrollDown("cssSelector", addNewPostcode);
			enterText("cssSelector", addNewPostcode,postCode_eu);
			clickOnObject("cssSelector", addNewCountry);
			scrollDown("cssSelector", addNewCountry);
			//selectFromDropdown("cssSelector", addNewCountryOption, "byVisibleText", country_eu); //
			clickOnObject("cssSelector", addNewCountry);
			boolean isCountryPresent =false;
			List<WebElement> cntry= driver.findElements(By.cssSelector(addNewCountryOption));
			int cnrtySize= cntry.size();
			for(int i=1;i<=cnrtySize;i++) {
				WebElement cntryName=driver.findElement(By.cssSelector(addNewCountryBfr+i+")"));
				String names = cntryName.getText().trim();
				if(names.equalsIgnoreCase(country_eu)) {
					isCountryPresent =true;
					cntryName.click();
					waitOnSpinner();
					enterText("cssSelector", addStateTxtField,State_eu);
					enterText("id", addAddress1, address1_eu);
					enterText("id", addAddress2, address2_eu);
					enterText("id", addCity, city_eu);
					clearText("cssSelector", addNewPostcode);
					enterText("cssSelector", addNewPostcode,postCode_eu);
					wdWait("cssSelector", continueInAddress);
					clickOnButton("cssSelector", continueInAddress);
					scrollDown("cssSelector", continueInAddress);
					clickOnButton("cssSelector", continueInAddress);
					
					break;
				}
			}if(!isCountryPresent) {
				Assert.assertTrue(isCountryPresent, country_uk+ " is not present.");
			}
			
		}		
		
		
	}
	
	
	public void validateaddAddressMandatories() throws Exception {
		logInfo("Enter into validateaddAddressMandatories() method");
		clearText("id", addFName);
		clearText("id", addLName);
		clearText("id", addCompany);
		clearText("id", addAddress1);
		clearText("id", addAddress2);
		clearText("id", addPostCode);
		clearText("id", addCity);	
		clickOnObject("id", addFName);
		tabbingOut("id", addFName);
		String fnameAlert= getText("cssSelector", fNmaeError);
		softAssert.assertEquals(fnameAlert, exEmailAlertText);
		clickOnObject("id", addAddress1);
		String lNameAlert= getText("cssSelector", lNmaeError);
		softAssert.assertEquals(lNameAlert, exEmailAlertText);		
		tabbingOut("id", addAddress1);
		String Address1alert= getText("cssSelector", add1Error);
		softAssert.assertEquals(Address1alert, exEmailAlertText);		
		softAssert.assertAll();		
	}
	
	/***Review the states of product, asserts for title,address and Serial Number **/
	public void reviewProductAndRegister(String expSerial) throws Exception {
		logInfo("Entered into reviewProductAndRegister() method");
		String actReview = getText("cssSelector", prodReviewTitle);		
		softAssert.assertEquals(actReview, prodReviewTitleText);
		String actRegisteredAdd = getText("cssSelector", regAddress);		
		softAssert.assertEquals(actRegisteredAdd, regAddressText);		
		String actSerialNoText= getText("cssSelector", serialno);		
		softAssert.assertEquals(actSerialNoText, serialnoText);
		String actSerialNo= getText("cssSelector", retrivedserialno);			
		Assert.assertEquals(actSerialNo, expSerial);	
		Thread.sleep(3000);		
		scrollDown("xpath", regBtn);		
		clickOnObject("cssSelector", retrivedserialno);
		clickOnObject("cssSelector", retrivedserialno);
		wdWait("xpath", regBtn);			
		Actions act = new Actions(driver);		
		WebElement regButton = driver.findElement(By.xpath(regBtn));
		act.doubleClick(regButton).build().perform();
		wdWait("cssSelector", recentRegister);			
		
	}
	
	//Once lands on dashboard, validate the successful message, Dates , product details and Warrent options
	public void registeredProducts(int date) throws Exception {
		logInfo("Entered into registeredProducts() method");
		String expectedDate = getDate(date, "MM/dd/yyyy");	
		String expectedLessDate = getDate(date-1, "MM/dd/yyyy");	
		wdWait("cssSelector", recentRegister);	
		validateHomeTitle(dashBrdTitle);	
		String actSuccessMsg = getText("cssSelector", productSuccess);
		System.out.println("actSuccessMsg "+ actSuccessMsg);
		softAssert.assertEquals(actSuccessMsg, productSuccessMsg);
		String actProductDate= getText("cssSelector", prodDate);		
		if(actProductDate.equalsIgnoreCase(expectedDate)) {
			System.out.println("Date is matched");
		}else if(actProductDate.equalsIgnoreCase(expectedLessDate)){
			System.out.println("Date is less than matched in 2nd");
		}else {
			System.out.println("Date is not matched");
			Assert.assertEquals(actProductDate, expectedDate);
		}
		softAssert.assertAll();
		
		
		
	}
	/**Handle Warrant options 
	 * @throws Exception **/
	public boolean validateWarrentOptions() throws Exception {
		logInfo("Entered into validateWarrentOptions() method");
		clickOnObject("cssSelector", warrent);
		selectFromDropdown("cssSelector", warrent, "byVisibleText", "warranty option");
		clickOnObject("cssSelector", recentRegister);
		return false;	
		
	}
	
	
	
	
	
	/****Select left tabs in dashboard page
	 * @throws Exception ****/
	
	public boolean selectLeftTab(String expTabName) throws Exception {
		logInfo("Entered into selectLeftTab() method");
		boolean isPresent= false;
		waitOnSpinner();
		wdWait("cssSelector", signIn);
		getText("cssSelector", signIn);
		clickOnObject("cssSelector", signIn);
		wdWait("cssSelector", dashboardLeftTabs);
		List <WebElement> tabs= driver.findElements(By.cssSelector(dashboardLeftTabs));
		for (WebElement tab: tabs) {
			String tabName= tab.getText().trim();
			if(tabName.equalsIgnoreCase(expTabName)) {
				tab.click();
				waitOnSpinner();
				break;
			}
		}
		return isPresent;
		
		
	}
	
	
	/***Select a register a product Button in account dashboard*/
	public void selectBtnRegisterAProduct() throws Exception {
		logInfo("Entered into selectBtnRegisterAProduct() method");
		wdWait("cssSelector", registerAProdButton);
		clickOnButton("cssSelector", registerAProdButton);
		validatePRTitle(PRTitleText);
		
	}
	
	
	/***Selects Register Here Button
	 * @throws Exception **/
	
	public void selectRegisterHere() throws Exception {
		logInfo("Entered into selectRegister() method");
		wdWait("cssSelector", registerBtn);
		clickOnObject("cssSelector", ratingWidget);
		Thread.sleep(3000);
		//clickOnButton("cssSelector", registerBtn);
		WebElement regBtn= driver.findElement(org.openqa.selenium.By.cssSelector(registerBtn));
		regBtn.click();
		Thread.sleep(10000);
		wdWait("cssSelector", catTitle);
		wdWait("cssSelector", catTitle);
		String title = getText("cssSelector", catTitle);
		Assert.assertEquals(title, catTitleText);	
	}
	
	/**Retrieve Category  list**/
	public void selectCatgeory(String categoryName) throws Exception {
		logInfo("Entered into selectCatgeory() method");
		waitOnSpinner();		
		wdWait("cssSelector", catTitle);
		WebElement catg= driver.findElement(org.openqa.selenium.By.cssSelector(catTitle));
		catg.click();
		//clickOnObject("cssSelector", catTitle);
		String title = getText("cssSelector", catTitle);
		softAssert.assertEquals(title, catTitleText);
		wdWait("xpath", catList);
		List <WebElement> cates = driver.findElements(By.xpath(catList));
		boolean isCatPresent=false;
		for(WebElement category :cates) {
			String catgry = category.getText().trim();	
			if(catgry.equalsIgnoreCase(categoryName.trim())) {
				 isCatPresent=true;
				 category.click();
				 
				 
				 break;
				 
			}
		}if(!isCatPresent) {
			Assert.assertTrue(isCatPresent, categoryName + "- category is not present");
		}
		softAssert.assertAll();
	}	
	
	
	
	
	/***Retrieve and validate All Accordions based on selcted Category like DeviceType, Brand, Product titles
	 * @throws Exception **/
	public void getAccoundiansBasedOnCategory(String[] accordiansTabs ) throws Exception  {
		logInfo("Entered into getAccoundiansBasedOnCategory() method");
		wdWait("xpath", accordianList);
		List<WebElement> accods= driver.findElements(By.xpath(accordianList));
		int actualAccodianSize = accods.size();		
		int expectedArrayAccordians= accordiansTabs.length;		
		if(actualAccodianSize==0) {
			Assert.assertEquals(0, "None of Accordians are displayed like Device, Brand etc.");
		}else if(actualAccodianSize==expectedArrayAccordians) {		
			for(WebElement accodlist :accods) {
				boolean isPresent = false;
				int j;
				for (j=0;j<=expectedArrayAccordians-1;j++) {					
					String actAccodName = accodlist.getText();						
					if(actAccodName.equalsIgnoreCase(accordiansTabs[j])) {						
						isPresent=true;			
						break;
					}					
				} if(isPresent==false) {
					Assert.assertTrue(isPresent, accordiansTabs[j] + " Accordian is not found.");
				}
				
			}
		}else {
			System.out.println(actualAccodianSize + "   "+expectedArrayAccordians);
			Assert.assertEquals(actualAccodianSize, expectedArrayAccordians);
		}
		
		
		
	}
	
	/**This method selects Product tab under STORES left tab**/
	public void openStoresScreen() throws Exception {
		logInfo("Entered into openStoresScreen() method");
		wdWait("cssSelector", productTab);
		clickOnObject("cssSelector", productTab);
		
	}
	
	/**This method selects Product tab under STORES left tab**/
	public void openCatalogProductScreen() throws Exception {
		logInfo("Entered into openStoresScreen() method");
		wdWait("cssSelector", catalogProductTab);
		clickOnObject("cssSelector", catalogProductTab);
		
	}
	
	/***Select back tab to go back to product attribute page**/
	public void backToStores() {
		logInfo("Entered into backToStores() method");
		clickOnObject("cssSelector", backArrow);
		
	}
	
	/**Validate the title of Product Attribute **/
	public void productAttributeTitle(String attributeTitle) throws Exception {
		logInfo("Entered into productAttributeTitle() method");
		Thread.sleep(2000);
		wdWait("cssSelector", productTitle);
		String actTitle = driver.findElement(By.cssSelector(productTitle)).getText().trim();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, attributeTitle);	
	}
	
	/***In product attribute screen, Enter attribute Code , search and select that attribute
	  @throws Exception **/
	public void selectProductAttrubes(String passAttribute) throws Exception  {
		logInfo("Entered into selectProductAttrubes() method");
		clearText("xpath", attributeCodeField);	
		clearText("xpath", attributeCodeField);	
		enterText("xpath", attributeCodeField, passAttribute);		
		clickOnObject("xpath", attributeCodeField);		
		clickOnButton("cssSelector", searchBtn);
		wdWait("cssSelector", attTable);
		List<WebElement> rows= driver.findElements(By.cssSelector(attTable));
		if(rows.size()==0) {
			Assert.assertEquals(null, 1);
		}else {
			for (WebElement row: rows) {
				row.click();
				
			}
		}
		
		
	}
	
	/**This is uses to select left panel tabs by passing string value like Sales, Catalog, Stores etc.
	 * @throws Exception */
	public void selectLeftTabsInAdmin(String tabName) throws Exception {
		logInfo("Entered into selectLeftTabs() method");
		wdWait("cssSelector", leftTabs);
		List<WebElement> tabs = driver.findElements(By.cssSelector(leftTabs));
		boolean isPresent= false;
		for (WebElement tab:tabs) {
			String navTab=tab.getText();
			if(navTab.equalsIgnoreCase(tabName)) {
				isPresent=true;				
				tab.click();
				tab.click();
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, tabName + " is not present to select");
		}	
		
	}
	
	/**Verify title of Manage Options and retrieve all available Options for that attribute and store this option in property file
	 * @throws Exception */
	public void retrieveAllOptionsForAttribute(String propertyFileName) throws Exception {
		logInfo("Entered into retrieveAllOptionsForAttribute() method");
		wdWait("cssSelector", manageOptionsTitle);
		String actManageOpt= getText("cssSelector", manageOptionsTitle);
		Assert.assertEquals(actManageOpt, manageOptionsTitleText);
		List<WebElement> opt= driver.findElements(By.cssSelector(allOptions));
		int optionsSize= opt.size();
		for(int i=1;i<=optionsSize;i++) {
		WebElement options = driver.findElement(By.cssSelector(allOptionsBfr+i+allOptionsAft));
		String option= options.getAttribute("value").trim();			
		setAttributeOptionsInProperty(propertyFileName, setterNamed+i, option);
		}
		
		
		
	}
	
	  
	  
	  
	  /**This method retrieves "DeviceType" attribute Options  which are displayed to user like SmartPhone, Laptops etc. 
	 * @throws Exception **/
	  public void retriveDisplayedAttributeOptions_deviceType(String propertyFileName) throws Exception {
		  logInfo("Entered into retriveDisplayedAttributeOptions_deviceType() method");
		  Thread.sleep(4000);
		  wdWait("xpath", attributeItemsFrstAccord);
		  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
		  int optSize = options.size();		  
		  for(int i=1;i<=optSize;i++) {
			  WebElement option= driver.findElement(By.xpath(attributeItemsFrstBfr+i+attributeItemsAfr));
			  String avaibleOptions = option.getText();	 
			  String expectedOptions = getAttributeOptionsInProperty(propertyFileName, setterNamed+i);			  
			  if(avaibleOptions.equalsIgnoreCase(expectedOptions)) {				  
				  
			  }else {
				  Assert.assertEquals(avaibleOptions, expectedOptions);
			  }
			  
		  }  
		  
	  }
	  
	  
	  /**This method retrieves "DeviceType" attribute Options  which are displayed to user like SmartPhone, Laptops etc. 
		 * @throws Exception **/
		  public void retriveDisplayedAttributeOptions_deviceType_old(String propertyFileName) throws Exception {
			  logInfo("Entered into retriveDisplayedAttributeOptions_deviceType() method");
			  Thread.sleep(4000);
			  wdWait("xpath", attributeItemsFrstAccord);
			  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
			  int optSize = options.size();		  
			  for(int i=1;i<=optSize;i++) {
				  WebElement option= driver.findElement(By.xpath(attributeItemsFrstBfr+i+attributeItemsAfr));
				  String avaibleOptions = option.getText();	
				  
				  
				  
				  
				  String expectedOptions = getAttributeOptionsInProperty(propertyFileName, setterNamed+i);			  
				  if(avaibleOptions.equalsIgnoreCase(expectedOptions)) {				  
					  
				  }else {
					  Assert.assertEquals(avaibleOptions, expectedOptions);
				  }
				  
			  }  
			  
		  }
		  
	  
	  
	  /**This method selects "DeviceType"attribute Options which are displayed to user like SmartPhone, Laptops etc. 
		 * @throws Exception **/
		  public void selectAttributeOptions_deviceType(String expectedOptionsText) throws Exception {
			  logInfo("Entered into selectAttributeOptions_deviceType() method");
			  Thread.sleep(2000);
			  wdWait("xpath", attributeItemsFrstAccord);
			  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
			  int optSize = options.size();	
			  boolean isPresent= false;
			  for(int i=1;i<=optSize;i++) {
				  WebElement option= driver.findElement(By.xpath(attributeItemsFrstBfr+i+attributeItemsAfr));
				  String avaibleOptions = option.getText();						  
				  if(avaibleOptions.equalsIgnoreCase(expectedOptionsText)) {
					  isPresent=true;
					  clickOnObject("xpath",attributeItemsFrstBfr+i+attributeRadioAfr);					  
					  break;					  
				  }
				  
			  } if(isPresent==false) {
				  Assert.assertTrue(isPresent, expectedOptionsText+ "- is not present.");
			  }
			  
		  }
		  
		  
		  
	  /**This method retrieves  attribute Options  which are displayed to user like Amazon Samsung, iPad, products etc. 
		 * @throws Exception **/
		  public void compareDisplayedAttributeOptionsWithAdminAttribute(String propertyFileName) throws Exception {
			  logInfo("Entered into retriveDisplayedAttributeOptions() method");
			  Thread.sleep(2000);
			  wdWait("xpath", attributeItems);
			  List<WebElement> options = driver.findElements(By.xpath(attributeItems));
			  int optSize = options.size();		  
			  for(int i=1;i<=optSize;i++) {
				  WebElement option= driver.findElement(By.xpath(attributeItemsBfr+i+attributeItemsAfr));
				  String avaibleOptions = option.getText();			  
				  String expectedOptions = getAttributeOptionsInProperty(propertyFileName, setterNamed+i);
				  System.out.println(i+"  "+avaibleOptions+ " &&& "+expectedOptions);
				  if(avaibleOptions.equalsIgnoreCase(expectedOptions)) {
					  
					  
				  }else {
					  Assert.assertEquals(avaibleOptions, expectedOptions);
				  }
				  
			  }  
			  
		  }
		  
		  
		  
	  /**This method selects attribute Options which are displayed to user like Amazon Samsung, iPad,etc. 
		 * @throws Exception **/
		  public void selectAttributeOptionsFromSecondLevel(String expectedOptionsText) throws Exception {
			  logInfo("Entered into selectAttributeOptions() method");			  
			  waitOnLoadingSpinner(2);
			  wdWait("xpath", attributeItems);
			  List<WebElement> options = driver.findElements(By.xpath(attributeItems));
			  int optSize = options.size();	
			  boolean isPresent= false;
			  for(int i=1;i<=optSize;i++) {
				  WebElement option= driver.findElement(By.xpath(attributeItemsBfr+i+attributeItemsAfr));
				  String avaibleOptions = option.getText();					  
				  if(avaibleOptions.equalsIgnoreCase(expectedOptionsText)) {
					  isPresent=true;
					  clickOnObject("xpath",attributeItemsBfr+i+attributeRadioAfr);						  
					  break;					  
				  }
				  
			  } if(isPresent==false) {
				  Assert.assertTrue(isPresent, expectedOptionsText+ "- is not present.");
			  }
			  
		  }
		  
		  /***This method selects Product (which is final item ). Hover on Product and select button "Select Item" **/
		
			  public void selectProductFromProductCollection() {
				  logInfo("Entered into selectProductFromProductCollection() method");	 
				  
				  
				  
			  }
			  
			  
		  
	/**Select Continue button of No serial registration flow
	 * @throws Exception */
		  public void selectContinue() throws Exception {
			  logInfo("Entered into selectContinue() method");
			  wdWait("cssSelector", catContinueBtn);
			  clickOnButton("cssSelector", catContinueBtn);
		  }
		  
		  
		  /**This method selects "DeviceType"attribute Options which are displayed to user like SmartPhone, Laptops etc. 
			 * @throws Exception **/
			  public void selectAttributeOptionsFromFirstAccordion() throws Exception {
				  logInfo("Entered into selectAttributeOptions_deviceType() method");
				  Thread.sleep(2000);
				  wdWait("xpath", attributeItemsFrstAccord);
				  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
				  int optSize = options.size();
				  System.out.println("optSize"+ optSize);
				  int genrateRamdom = TestBase.generateRandomNumberInRange(0, optSize);			
				  System.out.println("genrateRamdom"+ genrateRamdom);
				  WebElement option;
				  if(genrateRamdom==0) {
					  option= driver.findElement(By.xpath(attributeItemsFrstBfr+1+attributeItemsAfr));
					  clickOnObject("xpath",attributeItemsFrstBfr+1+attributeRadioAfr);
				  }else {
					  option= driver.findElement(By.xpath(attributeItemsFrstBfr+genrateRamdom+attributeItemsAfr));
					  clickOnObject("xpath",attributeItemsFrstBfr+genrateRamdom+attributeRadioAfr);
				  }
				  
				  String avaibleOptions = option.getText();		
				  System.out.println(optSize + " "+ avaibleOptions);
				  
				  
			  }
		  
		  
		  
		  
	  /**This method selects attribute Options which are displayed to user like Amazon Samsung, iPad,etc. 
		 * @throws Exception **/
		  public void selectAttributeOptionsFromSecondAccordion() throws Exception {
			  logInfo("Entered into selectAttributeOptionsFromSecondAccordion() method");			  
			  Thread.sleep(2000);
			  wdWait("xpath", attributeItems);
			  List<WebElement> options = driver.findElements(By.xpath(attributeItems));
			  int optSize = options.size();				
			  System.out.println(optSize);
			  int genrateRamdom = TestBase.generateRandomNumberInRange(0, optSize);
			  WebElement option;
			  if(genrateRamdom==0) {
				  option= driver.findElement(By.xpath(attributeItemsBfr+1+attributeItemsAfr));				  
			  }else {
				  option= driver.findElement(By.xpath(attributeItemsBfr+genrateRamdom+attributeItemsAfr));
			  		}				   
				  String avaibleOptions = option.getText();	
				  System.out.println(avaibleOptions);
				  clickOnObject("xpath",attributeItemsBfr+genrateRamdom+attributeRadioAfr);				  
			 }
		  
		 public void setRangeToDisplayPerPageInAdminProductScreen() throws Exception {
			 logInfo("Entered into setRangeToDisplayPerPageInAdminProductScreen() method");
			 clickOnButton("cssSelector", noOfProdField);
			 clickOnButton("cssSelector", noOfProdField);
			 clearText("cssSelector", noOfProdField);
			 enterText("cssSelector", noOfProdField, "200");
			 tabbingOut("cssSelector", noOfProdField);
			 
		 }
		 
		 public String selectProductInAdmin() throws Exception {
			 logInfo("Entered into selectProductInAdmin() method");
			 
			 String productName= null;
			 implicityWaits(4);
			 List<WebElement> prods = driver.findElements(By.cssSelector(productList));		
			 int noOfProd = prods.size();
			 if(noOfProd==0) {
				 Assert.assertEquals(0, "product should have more than 1 epxpected");
			 }else {
				 int genrateRamdom = TestBase.generateRandomNumberInRange(1, noOfProd);  
				 WebElement products = driver.findElement(By.cssSelector(productListBfr+genrateRamdom+productListAfr));
				 productName=products.getText().trim();
				 products.click();
				 
			 }
			return productName;
			 
			 
			 
			 	 
		 }
		 
		 
		 
		 
		 
		 
		 public void selectTabUnderSelectedProductInAdmin(String tabName) throws Exception {	
			 logInfo("Entered into selectTabUnderSelectedProductInAdmin() method");
			 implicityWaits(5);
			 List<WebElement> prods = driver.findElements(By.cssSelector(leftTabsInProdItem));
			 int prodSize= prods.size();			 
			 boolean isPresent=false;			 
			 for (int i=10;i<=prodSize;i++) {	
				 String locaters = leftTabsBfr+i+leftTabsAfr;
				 scrollDown("cssSelector", locaters);
				 WebElement prodTabs = driver.findElement(By.cssSelector(locaters));				 
				 if(prodTabs.getText().equalsIgnoreCase(tabName)) {
					 isPresent =true;										 
					 prodTabs.click();					 
					 break;
				 }
				 
			 }if(isPresent==false) {
				 Assert.assertTrue(isPresent, tabName+ " is not present");
			 }	 
			 
		 }
		 
		  
		 
		 public String setProductBrand() throws Exception {
			 logInfo("Entered into setProductBrand() method");
			 String selectedBrand = null;
			 Thread.sleep(4000);
 		     String getValue = retrieveSelectedOption("cssSelector", brandOption);
			 System.out.println(getValue);
			 
			 List<WebElement> val = driver.findElements(By.cssSelector(brandOption));
			 int optionsSize = val.size();
			 if(optionsSize<=1) {
				 Assert.assertEquals(0, "Brand should have more than 1 epxpected");
			 }else {
				 int genrateRamdom = TestBase.generateRandomNumberInRange(2, optionsSize); 
				 System.out.println(genrateRamdom);
				 WebElement values= driver .findElement(By.cssSelector(optSelecBrand+genrateRamdom+")"));
				 selectedBrand= values.getText().trim();
				 values.click();
				 values.click();				 
			 }			 
			return selectedBrand;			 
			 
		 }
		 
		 public String setProductDevices() throws Exception {
			 logInfo("Entered into setProductDevices() method");
			 String selectDevice = null;
			 Thread.sleep(4000); 		     
			 List<WebElement> val = driver.findElements(By.cssSelector(deviceOptions));
			 int optionsSize = val.size();
			 if(optionsSize<=1) {
				 Assert.assertEquals(0, "Devices should have more than 1 epxpected");
			 }else {
				 int genrateRamdom = TestBase.generateRandomNumberInRange(2, optionsSize); 
				 System.out.println(genrateRamdom);
				 WebElement values= driver .findElement(By.cssSelector(optSelectDevice+genrateRamdom+")"));
				 selectDevice= values.getText().trim();
				 values.click();
				 values.click();				 
			 }			 
			return selectDevice;			 
			 
		 }
		 
		 public void productSaveButton() throws Exception {
			 logInfo("Entered into productSaveButton() method");
			 scrollDown("cssSelector", prodSave);
			 clickOnButton("cssSelector", prodSave);
			 waitOnSpinner();
			 Thread.sleep(6000);
			 wdWait("cssSelector", successMsg);
			 String actMsg= getText("cssSelector", successMsg);
			 Assert.assertEquals(actMsg, successMsg);
		 }
		 

		 
		 public String setProductCategory() throws Exception {
			 logInfo("Entered into setProductCategory() method");
			 String selectedCategory= null;
			 Thread.sleep(4000);		 
			 List<WebElement> val = driver.findElements(By.cssSelector(categoryOption));
			 int optionsSize = val.size();
			 if(optionsSize<=1) {
				 Assert.assertEquals(0, "Category should have more than 1 epxpected");
			 }else {
				 int genrateRamdom = TestBase.generateRandomNumberInRange(2, optionsSize); 				 
				 WebElement values= driver .findElement(By.cssSelector(optSelecCategory+genrateRamdom+")"));
				 selectedCategory= values.getText().trim();
				 values.click();
				 values.click();				 
			 }			 
			return selectedCategory;			 
			 
		 }
		 
		 
		 /***Captures confirmation message after register
			 * @throws Exception ***/
			 public void  isRegisteredConfirmed(String msg) throws Exception {
				 logInfo("Entered into isRegisteredConfirmed() method");
				 wdWait("cssSelector", confMsg);			
				 String actText = getText("cssSelector", confMsg);	
				 System.out.println(actText);
				
				
					 
			 }
		 
		 
		
		 
		 /****Once popup modal dialog comes, it tries to enter serial number and selects Continue button
		 * @throws Exception **/
		 public void popupSerialNumber(String serialNumber) throws Exception  {
			 logInfo("Entered into popupSerialNumber() method");
			 Thread.sleep(3000);	
			 WebElement field= driver.findElement(By.cssSelector(dateFieldLabel));
			 String labelName= field.getText();
			 if(labelName.equalsIgnoreCase(dateFieldText)) {				 
				 
			 }else {
				 WebElement pops = driver.findElement(By.cssSelector(modalSerialPopup));			 
				 Actions act= new Actions(driver);
				 act.moveToElement(pops).click().build().perform();	
				 wdWait("cssSelector", modalSerialField);
				 clearText("cssSelector", modalSerialField);
				 enterText("cssSelector", modalSerialField, serialNumber);
				 WebElement continueBtn  = driver.findElement(By.cssSelector(popupContinue));
				 act.moveToElement(continueBtn).click().build().perform();		 
				 
			 }
			 
			 
		 }
		 
		 /**Capture error message once invalid Serial Number is entered. Verifies all title, headers etc.
		 * @throws Exception **/
		 public void serialNumberAlertMsg() throws Exception {
			 logInfo("Entered into serialNumberAlertMsg() method");
			 wdWait("cssSelector", alertMsg);
			 String actAlert= getText("cssSelector", alertMsg);
			 System.out.println("1 "+actAlert);
			 softAssert.assertEquals(actAlert, alertMsgText);
			 String subTitle= getText("cssSelector", subTitlePopup);
			 String serialNoField= getText("cssSelector", fieldName);
			 System.out.println("2 "+subTitle);
			 System.out.println("3 "+serialNoField);
			 softAssert.assertEquals(subTitle, subTitlePopupText);
			 softAssert.assertEquals(serialNoField, fieldNameText);
			 softAssert.assertAll();
		 }
		 
		 
		 /***Selects Continue underDateField and adds existing Shipping or Billing Address then Continue in address section.	
		 * @throws Exception **/
		 public void selectExistingAddress(String shippingOrBilling) throws Exception {
			 logInfo("Entered into selectExistingAddress() method");
			 scrollDown("cssSelector", continueInOptions);
			 clickOnButton("cssSelector", continueInOptions);
			 verifyAddressTitle(addTitleText);
			 
			 switch(shippingOrBilling) {
			 case "shipping":
				 clickOnObject("cssSelector", existShippingAddress);
				 clickOnObject("cssSelector", existShippingAddress);
				 break;
			 case "billing"	:
				 clickOnObject("cssSelector", existBillingAddress);
				 clickOnObject("cssSelector", existBillingAddress);
				 break; 
			 default:
				 Assert.assertEquals(shippingOrBilling,"shipping or billing");			 
			 }
			 scrollDown("cssSelector", continueInAddress);
			 wdWait("cssSelector", continueInAddress);
			 clickOnButton("cssSelector", continueInAddress);
			 wdWait("xpath", regBtn);			 
		 }
		 
		 
		 /***Selects Continue underDateField and adds existing Shipping or Billing Address then Continue in address section.	
			 * @throws Exception **/
			 public void selectExistingFirstAddress() throws Exception {
				 logInfo("Entered into selectExistingAddress() method");
				 scrollDown("cssSelector", continueInOptions);
				 clickOnButton("cssSelector", continueInOptions);
				 verifyAddressTitle(addTitleText);
				 clickOnObject("cssSelector", existFirstAddress);
				 clickOnObject("cssSelector", existFirstAddress);			 
				 scrollDown("cssSelector", continueInAddress);
				 wdWait("cssSelector", continueInAddress);
				 clickOnButton("cssSelector", continueInAddress);
				 wdWait("xpath", regBtn);			 
			 }
		 
		 
		 
		 public void registerProduct() throws Exception {
			 logInfo("Entered into registerProduct() method");			 
			 Actions action = new Actions(driver);	
			 waitOnSpinner();
			 wdWait("xpath", regBtn);			 
			 clickOnButton("xpath", regBtn);
			 waitOnSpinner();
//			 String title = getText("cssSelector", productTitle);
//			 System.out.println(title);
//			 if(title.equalsIgnoreCase("Product Registration")) {
//				 String prtitle = getText("cssSelector", productTitle);
//				 clickOnObject("cssSelector", backToDashLnk);				 
//				 Assert.assertEquals(prtitle, myDasbTitle);
//			 }		 
			 
		 }
		 
		 /***Captures confirmation message after register
		 * @throws Exception ***/
		 public void  isRegisteredConfirmed() throws Exception {
			 logInfo("Entered into isRegisteredConfirmed() method");
			 waitOnSpinner();
			 wdWait("cssSelector", confMsg);
			 Thread.sleep(3000);
			 String actText = getText("cssSelector", confMsg);	
			 Assert.assertEquals(actText, confMsgText);
				 
		 }
		 
			  
		 /**This method selects "DeviceType"attribute Options which are displayed to user like SmartPhone, Laptops etc. 
			 * @throws Exception **/
			  public void verifyBrandToBrand() throws Exception {
				  logInfo("Entered into verifyBrandToBrand() method");
				  Thread.sleep(2000);				 
				  wdWait("xpath", attributeItemsFrstAccord);
				  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
				  int optSize = options.size();
				  if(optSize>=1) {
					  for (int i=1;i<=optSize;i++) {
						  String option = driver.findElement(By.xpath(attributeItemsFrstBfr+i+attributeItemsAfr)).getText();
						  System.out.println(option);
						  //clickOnObject("xpath",attributeItemsFrstBfr+i+attributeRadioAfr);
						  
					  }
					  
				  }
				  				  
				  
			  }
			  
			  /**This method used for back Navigation from Review screen to Options screen
			 * @throws Exception ****/
			  public void validatebackToOptions() throws Exception {
				  logInfo("Entered into validatebackToOptions() method");	
				  waitOnSpinner();
				  wdWait("xpath", backToAddBtn);
				  String Text = getText("xpath", backToAddBtn);
				  clickOnButton("xpath", backToAddBtn);
				  verifyAddressTitle(addTitleText);
				  waitOnSpinner();				  
				  wdWait("id", backToRegBtn);
				  scrollDown("id", backToRegBtn);
				  WebElement button = driver.findElement(org.openqa.selenium.By.id(backToRegBtn));
				  JavascriptExecutor js = (JavascriptExecutor)driver; 
				  js.executeScript("arguments[0].click();", button);	
	
			  
				  wdWait("cssSelector", catTitle);
				  String title = getText("cssSelector", catTitle);					  
				  Assert.assertEquals(title, catTitleText);				  
				  wdWait("id", backToRegHomeBtn);
				  scrollDown("id", backToRegHomeBtn);
				  WebElement backtoReg = driver.findElement(By.id(backToRegHomeBtn));
				  //js.executeScript("arguments[0].click();", backtoReg);	
				  clickOnButton("id", backToRegHomeBtn);
				  waitOnSpinner();
				  wdWait("cssSelector", registerBtn);	
				  String registerText  = getText("cssSelector", registerBtn);		
				  Assert.assertEquals(registerText, registerBtnText);	
				  	  
			  }
			  
			  public void verifyAddressTitle(String expTitle) throws Exception {
				  logInfo("Entered into verifyAddressTitle() method");
				  waitOnSpinner();
				  wdWait("cssSelector", addTitle);
				  wdWait("cssSelector", continueInAddress);
				  boolean isPresent=false;
				  List<WebElement> title = driver.findElements(By.cssSelector(addTitle));
				  for(WebElement titles :title) {
					  String actTitle= titles.getText().trim();
					  if(actTitle.equalsIgnoreCase(expTitle)) {
						  isPresent=true;
						  break;
					  }
				  }
				  if(!isPresent) {
					  Assert.assertEquals(isPresent, expTitle);
				  }
				  
				  
			  }
			  
			  
			  /**This method retrieves "DeviceType" attribute Options  which are displayed to user like SmartPhone, Laptops etc. 
				 * @throws Exception **/
				  public void excelSheet(String propertyFileName) throws Exception {
					  logInfo("Entered into retriveDisplayedAttributeOptions_deviceType() method");
					  Thread.sleep(4000);
					  wdWait("xpath", attributeItemsFrstAccord);
					  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
					  int optSize = options.size();		  
					  for(int i=1;i<=optSize;i++) {
						  WebElement option= driver.findElement(By.xpath(attributeItemsFrstBfr+i+attributeItemsAfr));
						  String avaibleOptions = option.getText();	 
						  String expectedOptions = getAttributeOptionsInProperty(propertyFileName, setterNamed+i);			  
						  if(avaibleOptions.equalsIgnoreCase(expectedOptions)) {				  
							  
						  }else {
							  Assert.assertEquals(avaibleOptions, expectedOptions);
						  }
						  
					  }  
					  
				  }
				  
				  /**This method selects attribute Options which are displayed to user like Amazon Samsung, iPad,etc. 
					 * @throws Exception **/
					  public void selectAttributeOptionsFromProductLine(String expectedOptionsText) throws Exception {
						  logInfo("Entered into selectAttributeOptions() method");						 
						  waitOnLoadingSpinner(2);
						  wdWait("xpath", productLineItems);
						  scrollDown("xpath", productLineItems);
						  List<WebElement> options = driver.findElements(By.xpath(productLineItems));
						  int optSize = options.size();	
						  System.out.println("Size at productline "+optSize);
						  boolean isPresent= false;
						  for(int i=1;i<=optSize;i++) {
							  WebElement option= driver.findElement(By.xpath(attributeProductItemBfr+i+attributeItemsAfr));
							  String avaibleOptions = option.getText();	
							  System.out.println("product line  is "+avaibleOptions);
							  if(avaibleOptions.equalsIgnoreCase(expectedOptionsText)) {
								  isPresent=true;
								  clickOnObject("xpath",attributeProductItemBfr+i+attributeRadioAfr);							  
								  break;					  
							  }
							  
						  } if(isPresent==false) {
							  Assert.assertTrue(isPresent, expectedOptionsText+ "- is not present.");
						  }
						  
					  }		  
			
				  
			  
			  
	 
		 
		 
		 /***Selects the product at ProductLine accordion , if no product is available -tries to verify with No product found message
			 * @throws Exception */
			 public void selectExpectedProductFromProduct(String expProduct) throws Exception {
				 logInfo("Entered into selectExpectedProductFromProductLine() method");				 
				 boolean isPresent= false;
				 
				 scrollDown("xpath", itemList);
				 List<WebElement> noOfProds= driver.findElements(By.xpath(itemList));		
				 int prodsCount = noOfProds.size();	
				 System.out.println("Number of Products @@@@@ "+ prodsCount);
				 
				 for(WebElement prod :noOfProds) {				 				 
					 if(noOfProds.size()==0) {
						 String noProductsAvailable= getText("xpath", noProducts);					
						 Assert.assertEquals(noProductsAvailable, noProductsMessage);
						 
					 }else {
						 for (int i=1;i<=prodsCount;i++) {
						 WebElement name=  driver.findElement(By.xpath(itemListBfr+i+"]//div[@class='caption']"))	;		
						 scrollDown("xpath", itemListBfr+i+"]//div[@class='caption']")	;
						 String prodName = name.getText().trim();
						 System.out.println("i="+i+" "+prodName);
						 
						 if(prodName.equalsIgnoreCase(expProduct.trim())) {
							 isPresent=true;
							 System.out.println("Success matches");
							 name.click();
							 clickOnButton("xpath", itemListBfr+i+"]/div/button");					 
							 break;
						 		} 
						 		 scrollDown("xpath", courselArrow);
								 clickOnObject("xpath", courselArrow);
								 wdWait("xpath", courselArrow);							 
								 
						 	}break;
						}
				 	}if(isPresent==false) {
						 Assert.assertTrue(isPresent, expProduct+" - product is not present");
					 }	 
				 
			 }
		 
			 /***Selects the product at ProductLine accordion , if no product is available -tries to verify with No product found message
				 * @throws Exception */
				 public void selectExpectedProductFromProductOfScreenProt(String expProduct) throws Exception {
					 logInfo("Entered into selectExpectedProductFromProductLine() method");				 
					 boolean isPresent= false;					 
					 waitOnLoadingSpinner(4);
					 wdWait("xpath", itemList);
					 scrollDown("xpath", itemList);
					 List<WebElement> noOfProds= driver.findElements(By.xpath(itemList));		
					 int prodsCount = noOfProds.size();	
					 System.out.println("Number of Products @@@@@ "+ prodsCount);
					 
					 for(WebElement prod :noOfProds) {				 				 
						 if(noOfProds.size()==0) {							 
							 String noProductsAvailable= getText("xpath", noProducts);					
							 Assert.assertEquals(noProductsAvailable, noProductsMessage);
							 
						 }else {
							 for (int i=1;i<=prodsCount;i++) {
							 WebElement name=  driver.findElement(By.xpath(itemListBfr+i+"]//div[@class='caption']"))	;		
							 scrollDown("xpath", itemListBfr+i+"]//div[@class='caption']")	;
							 String prodName = name.getText().trim();
							 System.out.println("i="+i+" "+prodName);
							 
							 if(prodName.equalsIgnoreCase(expProduct.trim())) {
								 isPresent=true;
								 System.out.println("Success matches");
								 name.click();
								 clickOnButton("xpath", itemListBfr+i+"]/div/button");					 
								 break;
							 		} 
							 		 scrollDown("xpath", courselArrow);
									 clickOnObject("xpath", courselArrow);
									 wdWait("xpath", courselArrow);							 
									 
							 	}break;
							}
					 	}if(isPresent==false) {
							 Assert.assertTrue(isPresent, expProduct+" - product is not present");
						 }	 
					 
				 }
		 
		
		 
		 
		  /**This method gets data from property file , selects devices ----> product.
			 * @throws Exception **/
			  public void selectProductFromDevice(String propertyFileName, String value) throws Exception {
				  logInfo("Entered into selectProductFromDevice() method");				  
				  wdWait("xpath", attributeItemsFrstAccord);
				  boolean isDevicePrsnt=false;
				  List<WebElement> options = driver.findElements(By.xpath(attributeItemsFrstAccord));
				  int deviceSize = options.size();
				  System.out.println("1st accordion size is "+deviceSize);
				  String expectedDeviceOptions = null;				  
				  for(int i=1;i<=deviceSize;i++) {
					  String deviceName= driver.findElement(By.xpath(attributeItemsFrstBfr+i+attributeItemsAfr)).getText().trim();
					  System.out.println("deviceName - "+deviceName);
					  expectedDeviceOptions= getAttributeOptionsInProperty(propertyFileName, value+1); 
					  String expectedProductLine = getAttributeOptionsInProperty(propertyFileName, value+2); 
					  String expectedProduct = getAttributeOptionsInProperty(propertyFileName, value+3); 
					  if(deviceName.equalsIgnoreCase(expectedDeviceOptions)) {
						  isDevicePrsnt=true;
						  wdWait("xpath", attributeItemsFrstBfr+i+attributeRadioAfr);
						  selectRadioOrCheckbox("xpath", attributeItemsFrstBfr+i+attributeRadioAfr);
						  
						  selectAttributeOptionsFromProductLine(expectedProductLine)  ;  
						  selectExpectedProductFromProduct(expectedProduct);
						  
									  
						  break;
					  }
					  
				  }if(!isDevicePrsnt) {
					  Assert.assertEquals(isDevicePrsnt, expectedDeviceOptions+" - Device is not present.");
				  }
				  
				  				  
				  
			  }	
			  
			  /**This method gets data from property file , selects All required accordions till ProductLine.
				 * @throws Exception **/
				  public void selectproductUnderCategory(String propertyFileName, String value) throws Exception {
					  logInfo("Entered into selectproductUnderCategory() method");						  
					  int maxSize;
					  if(propertyFileName==catScreenProt) {
						  maxSize=5;
					  }else if((propertyFileName==catCases)||(propertyFileName==catBatteryCases)){
						  maxSize=4; 
					  }else if(propertyFileName==catKeyboard){
						  maxSize=3; 
					  }else {
						  maxSize=2; 
					  }					  
					  for (int i=2;i<=maxSize;i++) {
						   wdWait("xpath", catOptionsBfr+i+catOptionsAfr);  
						  String expectedDeviceTypeOption= getAttributeOptionsInProperty(propertyFileName, value+(i-1)).trim();	
						  List <WebElement> allOpt = driver.findElements(By.xpath(catOptionsBfr+i+catOptionsAfr)); 
						  int optSize= allOpt.size();						  
						  boolean isPresent= false;
						  for (int j=1;j<=optSize;j++) {
							  wdWait("xpath", catOptionsBfr+i+catOptionsMid+j+catListAfr);
							  WebElement accordOption = driver.findElement(By.xpath(catOptionsBfr+i+catOptionsMid+j+catListAfr));
							  String actAccordOpt = accordOption.getText().trim();							  
							  //scrollDown("xpath", catOptionsBfr+i+catOptionsMid+j+catListAfr);
							  if(actAccordOpt.equalsIgnoreCase(expectedDeviceTypeOption)) {
								  isPresent=true;
								  accordOption.click();
								  waitOnSpinner();
								  break;								  
							  }							  
						   }if(isPresent==false) {
							   Assert.assertTrue(isPresent,expectedDeviceTypeOption + " - option is not present");
							  
						  }						  
					  }  
					  String expectedProduct= getAttributeOptionsInProperty(propertyFileName, value+maxSize).trim();
					  selectExpectedProduct(expectedProduct);
					  
					  			  
				  }	
				  
				  /***Selects the product at ProductLine accordion , if no product is available -tries to verify with No product found message
					 * @throws Exception */
					 public void selectExpectedProduct(String expProduct) throws Exception {
						 logInfo("Entered into selectExpectedProductFromProductLine() method");	
						 boolean isPresent= false;						 
						 List<WebElement> countProds= driver.findElements(By.xpath(noOfProd));		
						 int prodsCount = countProds.size();						 
						 scrollDown("xpath", courselArrow);
						 scrollDown("xpath", courselArrow);
						 for(WebElement prod :countProds) {				 				 
							 if(prodsCount==0) {
								 String noProductsAvailable= getText("xpath", noProducts);					
								 Assert.assertEquals(noProductsAvailable, noProductsMessage);
							 }else{
								 	for (int i=1;i<=prodsCount;i++){							 
									 wdWait("cssSelector", courselArrow);
									 clickOnObject("cssSelector", courselArrowBack);
									 wdWait("cssSelector", productBfr+i+productAft);									 
									 WebElement name=  driver.findElement(By.cssSelector(productBfr+i+productAft));
									 String actProdName= name.getText().trim();
									 if(actProdName.equalsIgnoreCase(expProduct.trim())) {
										 isPresent=true;
										 clickOnButton("cssSelector", productBfr+i+prodBtn);					 
										 break;								 			} 
									 	int j=6;
									 	if(j==i) {									
									 		 clickOnObject("cssSelector", courselArrow);									 		 
											 wdWait("cssSelector", courselArrow);
											 clickOnObject("cssSelector", courselArrowBack);
											 j=i+2;
											 									 		
									 	}							 
										 
									 	}break;
									}
							 	}if(isPresent==false) {
									 Assert.assertTrue(isPresent, expProduct+" - product is not present");
								 }	 
							 
					 } 
		  
				 
					 /***Selects the product at ProductLine accordion , if no product is available -tries to verify with No product found message
						 * @throws Exception */
						 public void selectExpectedProduct_old(String expProduct) throws Exception {
							 logInfo("Entered into selectExpectedProductFromProductLine() method");				 
							 boolean isPresent= false;						 
							 List<WebElement> countProds= driver.findElements(By.xpath(noOfProd));						 int prodsCount = countProds.size();						 
							
							 scrollDown("xpath", courselArrow);
							 scrollDown("xpath", courselArrow);
							 for(WebElement prod :countProds) {				 				 
								 if(prodsCount==0) {
									 String noProductsAvailable= getText("xpath", noProducts);					
									 Assert.assertEquals(noProductsAvailable, noProductsMessage);
									 
								 }else {
									 for (int i=1;i<=prodsCount;i++) {
										 wdWait("cssSelector", productBfr+i+productAft);									 
										 WebElement name=  driver.findElement(By.cssSelector(productBfr+i+productAft));
										 String actProdName= name.getText().trim();
										 System.out.println("i="+i+" "+actProdName);									 	
										 if(actProdName.equalsIgnoreCase(expProduct.trim())) {
											 isPresent=true;
											 System.out.println("Success matches");
											 //name.click();
											 clickOnButton("cssSelector", productBfr+i+prodBtn);					 
											 break;
									 			} 
										 	int j=2;
										 	if(j==i) {									
										 		System.out.println("j value before "+ j);
										 		 clickOnObject("cssSelector", courselArrow);									 		 
												 wdWait("cssSelector", courselArrow);
												 clickOnObject("cssSelector", courselArrowBack);
												 j=i+2;
												 System.out.println("j value after "+ j);											 		
										 	}
												 																			 
											 
										 	}break;
										}
								 	}if(isPresent==false) {
										 Assert.assertTrue(isPresent, expProduct+" - product is not present");
									 }	 
								 
						 } 
						 
						 
						 
						 
			  
	
				  
				  /**This method gets data from property file , selects devices ----> product.
					 * @throws Exception **/
					  public void listOfDeviceType() throws Exception {
						  logInfo("Entered into selectProductFromBrand() method");					  
						  wdWait("xpath", catOptionsBfr+2+catOptionsAfr);						  
						  List <WebElement> allOpt = driver.findElements(By.xpath(catOptionsBfr+2+catOptionsAfr)); 
						  int optSize= allOpt.size();	
						  for (WebElement options :allOpt) {
							  String devices = options.getText().trim();
							  
							  switch (devices) {
							  case "Smartphones":
								  System.out.println(devices);
								  Assert.assertEquals(devices, "Smartphones");
								  break;
								
							  case "Tablets":
								  Assert.assertEquals(devices, "Tablets");
								  System.out.println(devices);
								  break;
								  
							  case "Watches":
								  System.out.println(devices);
								  Assert.assertEquals(devices, "Watches");
								  break;
							  case "Laptops":
								  System.out.println(devices);
								  Assert.assertEquals(devices, "Laptops");
								  break;
								  
							  case "Other":
								  System.out.println(devices);
								  Assert.assertEquals(devices, "Other");
								  break;
								  
								default:
									System.out.println(devices);
									Assert.assertNull(devices, " - This Device type should not display");
								  break;
							  
							  
							  }
							  
							  
						  }
						  
					  
					  }
  
		
		/***Logout from current user and relogin with another user
		 * @throws Exception */		  
		public void loginWithAnotherUser(String anotherUser, String password) throws Exception	{
			logInfo("Entered into loginWithAnotherUser() method");
			nav2AccountDashboard();
			logoutAsCustomer();
			homePage();
			homePage();
			selectSignIn(USACountry);
			existingUserLogin(anotherUser, password);
			validateHomeTitle(dashBrdTitle);	
			handleOfferPopUp();
			
		}
		
		
		/***Logout from current user and relogin with another user
		 * @throws Exception */		  
		public void loginWithAnotherUserByLocale(String country ,String anotherUser, String password) throws Exception	{
			logInfo("Entered into loginWithAnotherUserByLocale() method");
			nav2AccountDashboard();
			logoutAsCustomer();
			
			//homePageByCountry(country);
			selectSignIn(country);
			handleOfferPopUp();			
			existingUserLogin(anotherUser, password);
			handleOfferPopUp();
			
		}
		
		
		public void getMsgOfMismatchedSKU() throws Exception {
			String expAlert= "The product associated with this Serial Number or Registration Code could not be found. "
					+ "Please search for your product here or contact Customer Care for assistance.";
			String actErrorMsg= getText("xpath", serialErr);	
			Assert.assertEquals(actErrorMsg, expAlert);
			if(actErrorMsg.equalsIgnoreCase(expAlert)) {
				clickOnObject("xpath", serialErrHere);
				wdWait("cssSelector", catTitle);
				String title = getText("cssSelector", catTitle);		
				softAssert.assertEquals(title, catTitleText);
			}else {
				Assert.assertEquals(actErrorMsg, expAlert);
			}	
			
			softAssert.assertAll();		
		}
		
		
		
		//GetCount of List of address and selects radio button of address then continues
		
		public int  getAllAddressCount() throws Exception {
			logInfo("Entered into getAllAddressCoun() method");
			 scrollDown("cssSelector", continueInOptions);
			 clickOnButton("cssSelector", continueInOptions);
			 verifyAddressTitle(addTitleText);			
			List <WebElement>addList = driver().findElements(By.cssSelector(getAddressCount));
			int getCount= addList.size();
			if(getCount<=3) {
				 clickOnObject("cssSelector", existShippingAddress);
				 clickOnObject("cssSelector", existShippingAddress);
				
			}else {
				int additionalAdressCount = getCount-3;
				int value= TestBase.generateRandomNumberInRange(0, additionalAdressCount);
				clickOnObject("cssSelector", addtionalAddressRadio+value);
			}
			
			System.out.println("getCount "+ getCount);
			scrollDown("cssSelector", continueInAddress);
			wdWait("cssSelector", continueInAddress);
			clickOnButton("cssSelector", continueInAddress);
			wdWait("xpath", regBtn);			
			return getCount;
			
		}
		
		
		/**Selects All Customers tab and verify screen
		 * @throws Exception **/
		public void customerScreen() throws Exception {
			logInfo("Entered into customerScreen() method.");
			wdWait("cssSelector", allCustomers);
			clickOnObject("cssSelector", allCustomers);	
			productAttributeTitle("Customers");
			
			
		}
		
		/**Edit Customers based on passed email.
		 * @throws Exception **/
		public void editCustomer(String custEmail) throws Exception {
			logInfo("Entered into editCustomer() method.");
			waitOnSpinner();
			wdWait("cssSelector", customerRows);
			boolean isPresent=false;
			List<WebElement> rows = driver.findElements(By.cssSelector(customerRows));
			int noOfRows = rows.size();
			System.out.println("sixe is "+noOfRows);
			for (int i=1;i<=noOfRows;i++) {
				String email= driver().findElement(By.cssSelector(emailBfr+i+emailAft)).getText().trim();
				System.out.println("email "+email);
				if(email.equalsIgnoreCase(custEmail)) {
					isPresent=true;
					WebElement editCust = driver().findElement(By.cssSelector(emailBfr+i+editAft));
					editCust.click();
					break;
				}
			}if(!isPresent) {
				Assert.assertTrue(isPresent, custEmail + " email is not present");
			}			
		}
		
		public void loginAsCust() throws Exception {
			logInfo("Entered into loginAsCust() method.");
			waitOnSpinner();
			wdWait("xpath", loginAsCustomerTab);
			String loginCustomer= getText("xpath", loginAsCustomerTab);
			System.out.println("loginCustomer "+loginCustomer);
			waitOnSpinner();
			if(loginCustomer.equalsIgnoreCase("Login as Customer")) {
				WebElement cust = driver().findElement(By.xpath(loginAsCustomerTab));
				Actions act = new Actions(driver());
				act.click(cust).build().perform();
				waitOnSpinner();
				//act.moveToElement(cust).doubleClick().build().perform();
				//driver().navigate().to(appUrl+"default/customer/account/");
				String wndBeforeWindow = driver().getWindowHandle();	
				for(String w : driver().getWindowHandles()){
					if(!w.equalsIgnoreCase(wndBeforeWindow)){
						driver().switchTo().window(w);
						System.out.println(driver.getTitle());
					}
					System.out.println("Same window "+driver.getTitle());
				}				
			}			
		}
		
		
		public void checkPrivacyPolicy() throws Exception {
			logInfo("Entered into checkPrivacyPolicy() method");
			waitOnSpinner();
			wdWait("cssSelector", privacyChkBox);
			scrollDown("cssSelector", privacyChkBox);
			String text = getText("cssSelector", privacyLabel);
			wdWait("cssSelector", privacyChkBox);
			WebElement chkBox= driver().findElement(By.cssSelector(privacyChkBox));
			chkBox.click();			
		}
		
		
		 /***Selects Continue underDateField and adds existing Shipping or Billing Address then Continue in address section.	
		 * @throws Exception **/
		 public void compareAddress(String state) throws Exception {
			 logInfo("Entered into selectExistingAddress() method");
			 scrollDown("cssSelector", continueInOptions);
			 clickOnButton("cssSelector", continueInOptions);
			 //verifyAddressTitle(addTitleText);
			 clickOnObject("cssSelector", existShippingAddress);
			 clickOnObject("cssSelector", existShippingAddress);
			 String address2 = getText("cssSelector", existAddressDetails);
			 clickOnObject("cssSelector", existShippingAddress);
			 String address = getText("cssSelector", existAddressDetails);
			 String split[]= address.split("\\n");
			 String expAddressLine2= split[2];	
			 System.out.println("expAddressLine2 "+expAddressLine2 );
			 String add1 = driver.findElement(org.openqa.selenium.By.cssSelector(addressLine1)).getAttribute("value").trim();
			 System.out.println("addl "+add1);
			 String getState = getAttribute("cssSelector", "input#optshippingState","value");
			 String getAddress2 = getAttribute("cssSelector", addressLine2,"value");
			 System.out.println("getState "+getState);
			 System.out.println("getAddress2 "+getAddress2);
			 Assert.assertEquals(getAddress2, expAddressLine2);
			 Assert.assertEquals(getState, state);
			 
			
		 }
		 
		 /***Selects Continue underDateField and adds existing Shipping or Billing Address then Continue in address section.	
			 * @throws Exception **/
			 public void getStatesOfUSA(String country) throws Exception {
				 logInfo("Entered into selectExistingAddress() method");
				 scrollDown("cssSelector", continueInOptions);
				 clickOnButton("cssSelector", continueInOptions);
				 boolean isCountryPresent =false;
				    scrollDown("cssSelector", addNewCountry);	
				 	clickOnButton("cssSelector", addNewCountry);				 
					List<WebElement> cntry= driver.findElements(By.cssSelector(addNewCountryOption));
					int cnrtySize= cntry.size();
					System.out.println("cnrtySize "+cnrtySize);
					for(int i=1;i<=cnrtySize;i++) {
						WebElement cntryName=driver.findElement(By.cssSelector(addNewCountryBfr+i+")"));
						String names = cntryName.getText().trim();
						System.out.println(names);
						if(names.equalsIgnoreCase(countryUS)) {
							isCountryPresent =true;
							cntryName.click();
							waitOnSpinner();
							List<WebElement> states= driver.findElements(By.cssSelector(addStateOpt));
							System.out.println("states "+states.size());
							for(WebElement state: states) {
								String stateName = state.getText().trim();
								
								if(stateName.equalsIgnoreCase("Aglonas novads")) {
									System.out.println(stateName + " is still present");
									Assert.assertNotEquals(stateName, "Aglonas novads");
									
								}else if(stateName.equalsIgnoreCase("Berlin")) {
									System.out.println(stateName + " is still present");
									Assert.assertNotEquals(stateName, "Berlin");
									
								}
							}						
							break;
						}
					}if(!isCountryPresent) {
						nav2PRScreenInCountry(country);	
						Assert.assertTrue(isCountryPresent, "In "+country+ ", USA country is not present.");
					}			 
				
			 }
			 
		/***Validate States with properly named ex: not expecting dots at end of name
		 * @throws Exception */	 
			 public void states() throws Exception {
				 scrollDown("cssSelector", continueInOptions);
				 clickOnButton("cssSelector", continueInOptions);
				 boolean isCountryPresent =false;
				    scrollDown("cssSelector", addNewCountry);	
				 	clickOnButton("cssSelector", addNewCountry);				 
					List<WebElement> cntry= driver.findElements(By.cssSelector(addNewCountryOption));
					int cnrtySize= cntry.size();
					System.out.println("cnrtySize "+cnrtySize);
					for(int i=1;i<=cnrtySize;i++) {
						WebElement cntryName=driver.findElement(By.cssSelector(addNewCountryBfr+i+")"));
						String names = cntryName.getText().trim();						
						if(names.equalsIgnoreCase(countryUS)) {
							isCountryPresent =true;
							cntryName.click();
							waitOnSpinner();
							List<WebElement> states= driver.findElements(By.cssSelector(addStateOpt));
							System.out.println("states "+states.size());
							for(WebElement state: states) {
								String stateName = state.getText().trim();
								System.out.println(stateName);
								if(stateName.contains("Arkansas")) {
									Assert.assertEquals(stateName, "Arkansas");
									break;
									
								}else if(stateName.equalsIgnoreCase("New Jersey")) {
									Assert.assertEquals(stateName, "New Jersey.");
									break;
									
								}
							}						
							break;
						}
					}if(!isCountryPresent) {
						Assert.assertTrue(isCountryPresent, countryUS+ " is not present.");
					}	
				 
				 
			 }
		
			 
		public void discountPopUp() throws InterruptedException	 {
			Thread.sleep(3000);
			List<WebElement> pop = driver.findElements(By.xpath(disPop2));
			int size = pop.size();
			System.out.println("Size = "+pop.size());
			if(!(size==0)) {
				for(WebElement pops :pop) {
					pops.click();
				}
			}
			
			
		}
		
		
		
	




	
			
}
