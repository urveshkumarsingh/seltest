package zagg.warrantReplacement;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.lib.TestBase;

import zagg.accountGeneral.AccountGeneralMethods;
import zagg.prodRegistration.ProductRegistartionMethods;

public class WarrantReplacementMethods  extends ProductRegistartionMethods {
	
	
	AccountGeneralMethods ag = new AccountGeneralMethods();
	SoftAssert softAssert = new SoftAssert();
		
	
	
	public void selectWarrentForProduct(String productName) throws Exception {
		logInfo("Entered into selectWarrentForProduct() method.");			
		nav2AccountDashboard();
		selectLeftTab(myDash);
		List<WebElement> prods= driver().findElements(By.cssSelector(prodName));
		int prodSize = prods.size();
		boolean isPresent=false;
		int i;
		for( i=1;i<=prodSize;i++) {				
			if(i==4) {
				System.out.println("entered selected");
				clickOnObject("cssSelector", nextArrow);
				Thread.sleep(2000);
				System.out.println(i + " i valive ");
			}
			
			WebElement name = driver().findElement(By.cssSelector(prodNameBfr+i+prodNameAfr));
			String actName= name.getText();
			System.out.println("prods"+actName);
			if(actName.equalsIgnoreCase(productName)) {
				isPresent=true;
				clickOnObject("cssSelector", prodNameBfr+i+replaceOpt);
				selectFromDropdown("cssSelector", prodNameBfr+i+replaceOpt, "byIndex", "1");
//				WebElement replcment = driver().findElement(By.cssSelector(prodNameBfr+1+replaceOpt));
//				replcment.sendKeys(Keys.DOWN);				
//				replcment.click();
				clickOnObject("cssSelector", prodNameBfr+i+replaceOpt);
				break;			
			}			
			
			
		}if(!isPresent) {
			Assert.assertTrue(isPresent,productName + " - is not present." );
		}

		
	}	
	
	
	/** Enter text in Reasons field 
	 * @throws Exception **/
	public void enterReasons() throws Exception {
		logInfo("Entered into enterReasons() method.");
		Thread.sleep(4000);
		clearText("cssSelector", rsnTextBx);
		enterText("cssSelector", rsnTextBx, "Piece has defect.");
		clickOnButton("xpath", rsnCont);
		
		
		
	}
	
	/***Verifies checkout status Bar at top***/
	public void checkOutStatusBar() {
		logInfo("Entered into checkOutStatusBar() method.");
		List <WebElement> status = driver().findElements(By.cssSelector(chkStatus));
		int statusSize = status.size();
		if(statusSize==2) {
			for (WebElement st : status) {
				String statusBarText = st.getText().trim();
				switch(statusBarText) {
				case"Options":
					break;
				case"Checkout":
					break;	
				case"Review":
					break;		
				default:
					Assert.assertNull(statusBarText, " - This is unexpected text");
					break;
				
				}
			
				
			}
		}
		
	}
	
	
	
	/*****Get all optional reasons basedc on selected Product under category
	 * @throws Exception *****/
	public void getReasons(String[] expectedReasons) throws Exception {
		logInfo("Entered into getReasons() method.");
		int rsnSize = expectedReasons.length;
		for( int j=0; j<rsnSize;j++){			
		setAttributeOptionsInProperty(warrantReasons, setterNamed+(j+1), expectedReasons[j]);
		}
		
		List<WebElement>reasonOpt = driver().findElements(By.cssSelector(rsnOptions));
		int arraySize=reasonOpt.size();
		if(arraySize==0) {			
			Assert.assertNull("It should be drop down with reasons");
			}else {
			if(arraySize==rsnSize) {				
				boolean isReasonFound= false;
				String expectedReason=null;
				clickOnObject("cssSelector", rsnSelect);
				wdWait("cssSelector", rsnOptions);				
				for(int i=1;i<=arraySize;i++) {						
				    expectedReason = getAttributeOptionsInProperty(warrantReasons, setterNamed+i);				 
					WebElement options= driver().findElement(By.cssSelector(optresnBfr+i+")"));
        			String optReasons = options.getText().trim();        			
        			if(expectedReason.equalsIgnoreCase(optReasons)) {
        				isReasonFound=true;        				
        			}else {
        				Assert.assertEquals(optReasons,expectedReason);
				}
				
			}
		
			}}	
		
		
		
	}
	
	
	/*****Get all optional reasons basedc on selected Product under category
	 * @throws Exception *****/
	public void selectReasonFromDropdown(String expectedReason) throws Exception {
		logInfo("Entered into getReasons() method.");		
		List<WebElement>reasonOpt = driver().findElements(By.cssSelector(rsnOptions));
		int arraySize=reasonOpt.size();
		if(arraySize==0) {
			Assert.assertNotNull("Its a text box");
			}else {								
				clickOnObject("cssSelector", rsnSelect);
				wdWait("cssSelector", rsnOptions);				
				selectFromDropdown("cssSelector", rsnSelect, "byVisibleText", expectedReason);
				wdWait("xpath", rsnCont);
				clickOnObject("cssSelector", rsnSubTitle1);
				clickOnObject("cssSelector", rsnSelect);
				selectFromDropdown("cssSelector", rsnSelect, "byVisibleText", expectedReason);
				wdWait("xpath", rsnCont);
				clickOnObject("cssSelector", rsnSubTitle1);
				Thread.sleep(5000);
				clickOnButton("xpath", rsnCont);	
				waitOnSpinner();
			}
		
		}


	
	public void shippingMethodDetails(String methodName) throws Exception{
		logInfo("Entered into creditCardDetails() method.");
		Actions act = new Actions (driver);
		
//		scrollDown("cssSelector", continueInAddress);
//		clickOnButton("cssSelector", continueInAddress);
		boolean isPresent= false;
		scrollDown("cssSelector", shipMthdList);
		wdWait("cssSelector", shipMthdList);
		waitOnSpinner();
		implicityWaits(5);
		List<WebElement> shipMethods = driver().findElements(By.cssSelector(shipMthdList));
		for (int i=1; i<=shipMethods.size();i++) {
			WebElement name = driver().findElement(By.cssSelector(shipMthdListBfr+i+shipMthdListAfr));
			scrollDown("cssSelector", shipMthdListBfr+i+shipMthdListAfr);
			String metdName = name.getText().trim();
			System.out.println("metdName "+metdName);
			if(metdName.equalsIgnoreCase(methodName)) {
				isPresent=true;
				WebElement chkBox = driver().findElement(By.cssSelector(shipMthdListBfr+i+shippingRadio));
				JavascriptExecutor js = (JavascriptExecutor)driver; 
				js.executeScript("arguments[0].click();", chkBox);
				//chkBox.click();
				
				
				break;				
			}
					
		}if(!isPresent) {
			Assert.assertTrue(isPresent, methodName+ " - type of shipping method is not present");
		}		
	}
	
	
	/********Shipping Method - based on states like Armed Forces of ...  Should not have shipping method.
	 * @throws Exception ***/
	public void noShippingMethod() throws Exception {
		logInfo("Entered into noShippingMethod() method.");
		wdWait("cssSelector", shippingMtdTtile);
		waitOnSpinner();
		implicityWaits(5);
		List<WebElement> shipMethods = driver.findElements(By.cssSelector(shipMthdList));
		int shipingSize  = shipMethods.size();
		if(shipingSize==0) {
			String noShip = getText("cssSelector", noShipping);	
			System.out.println(noShip);
			Assert.assertEquals(noShip, noShippingText);
			
		}else {
			System.out.println("Entered here this loopp");
			WebElement shipMethod= driver.findElement(By.cssSelector(shipMthdList));
			shipMethod.getText().trim();
			Assert.assertNotSame(shipMethod, "One or more of the items in the cart");
		}
		
		
		
	}
	
	public void handleCCPaymentInWR() throws Exception{
		logInfo("Entered into handleCCPaymentInWR() method.");
		Actions act = new Actions (driver);
		wdWait("cssSelector", ccRadio);		
		clickOnObject("cssSelector", ccFrame);		
		clickOnObject("cssSelector", ccLabelWR);
		scrollDown("cssSelector", ccText);
		clickOnObject("cssSelector", ccText);
		enterText("cssSelector", ccText, ccNumber);
		clickOnObject("cssSelector", monthDP);
		List<WebElement> mon = driver().findElements(By.cssSelector(month));
		int size = mon.size();		
		for(WebElement months:mon) {
			String montName= months.getText().trim();
			if(montName.equalsIgnoreCase("12 - December")) {				
				months.click();
				break;				
			}			
		}	
		clickOnObject("cssSelector", yearDP);
		List<WebElement> yers = driver().findElements(By.cssSelector(year));
		for(WebElement years:yers) {
			String yearNumb= years.getText().trim();
			if(yearNumb.equalsIgnoreCase("2022")) {				
				years.click();
				break;
				
			}
			
		}
		enterText("cssSelector", cvvNumber, cvvText);	
		clickOnObject("cssSelector", termsInWR);
		
	}
	
	public void verifyTermsText() throws Exception {
		logInfo("Entered into verifyTermsText() method.");
		String termsTitle= getText("cssSelector", termsInWRTitle);		
		Assert.assertEquals(termsTitle, termsText);
		String placeOrderText = getText("cssSelector", placeOrder);
		Assert.assertEquals(placeOrderText, placOrderText);
				
		
	}
	
	public void handleCCPayment() throws Exception{
		logInfo("Entered into creditCardDetails() method.");
		Actions act = new Actions (driver());
		wdWait("cssSelector", ccRadio);
		clickOnObject("cssSelector", total);
		clickOnObject("cssSelector", ccFrame);
		String text = getText("cssSelector", ccLabel);
		clickOnObject("cssSelector", ccLabel);
		WebElement ccRad= driver().findElement(org.openqa.selenium.By.cssSelector(ccRadio));
		act.moveToElement(ccRad).doubleClick().build().perform();
		clickOnObject("cssSelector", ccText);
		enterText("cssSelector", ccText, ccNumber);
		clickOnObject("cssSelector", monthDP);
		List<WebElement> mon = driver().findElements(By.cssSelector(month));
		int size = mon.size();		
		for(WebElement months:mon) {
			String montName= months.getText().trim();
			if(montName.equalsIgnoreCase("12 - December")) {				
				months.click();
				break;				
			}			
		}		
		clickOnObject("cssSelector", yearDP);
		List<WebElement> yers = driver().findElements(By.cssSelector(year));
		for(WebElement years:yers) {
			String yearNumb= years.getText().trim();
			if(yearNumb.equalsIgnoreCase("2022")) {				
				years.click();
				break;				
			}	
		}
		enterText("cssSelector", cvvNumber, cvvText);
						
	}
	
	
	public void completeYourOrder() throws Exception {
		logInfo("Entered into completeYourOrder() method.");
		wdWait("cssSelector", placeOrder);
		clickOnObject("cssSelector", placeOrder);	
		waitOnSpinner();
		
		
	}
	
	
	public String getOrderId() throws Exception {
		logInfo("Entered into getOrderId() method.");
		wdWait("cssSelector", wrFirstOrdId);
		String ordId=getText("cssSelector", wrFirstOrdId);
		System.out.println(ordId);	
		return ordId;		
	}
	
	//Admin methods
	/***Select order tab in SALES in Admin   @throws Exception ***/
	 
	public void selectOrdersInAdmin() throws Exception {
		logInfo("Entered into selectOrdersInAdmin() method.");
		wdWait("cssSelector", salesOrder);
		clickOnObject("cssSelector", salesOrder);
		
	}
	
	
	/***Select Shipping Code Generator  in SALES in Admin   @throws Exception ***/
	 
	public void selectShippingCodeGeneratorInAdmin() throws Exception {
		logInfo("Entered into selectOrdersInAdmin() method.");
		wdWait("xpath", shippingCodeGen);
		clickOnObject("xpath", shippingCodeGen);
		waitOnSpinner();
		
	}
	
	
	
	
	public boolean handleOrderIDInAdmin(String expOrdId) throws Exception {
		logInfo("Entered into handleOrderIDInAdmin() method.");
		wdWait("cssSelector", ordIdList);
		clearText("cssSelector", ordSearch);
		clearText("cssSelector", ordSearch);
		enterText("cssSelector", ordSearch, expOrdId);
		clickOnButton("cssSelector", ordSearchIcon);
		waitOnSpinner();
		Thread.sleep(4000);
		wdWait("cssSelector", ordIdList);
		List<WebElement> ords = driver().findElements(By.cssSelector(ordIdList));
		boolean isOrderPresent= false;
		for(int i=1; i<=ords.size();i++) {
			WebElement order = driver().findElement(By.cssSelector(ordIdBfr+i+ordIdAfr));
			String orderId= order.getText().trim();
			System.out.println("Act orderId "+orderId);
			if(orderId.equalsIgnoreCase(expOrdId)) {
				isOrderPresent=true;				
				String status = driver().findElement(By.cssSelector(ordIdBfr+i+ordStatusAfr)).getText().trim();
				if(!status.equalsIgnoreCase("Suspected Fraud")) {
					order.click();
				}			
				break;
			}
		}
		return isOrderPresent;
		
	}
	
	
	public void orderIdTabsInAdmin(String tabName) {
		logInfo("Entered into orderIdTabsInAdmin() method.");
		List<WebElement> tabs= driver().findElements(By.cssSelector(ordIdTabs));
		boolean isTabPresent= false;
		for(WebElement tabbing :tabs) {
			String name= tabbing.getText().trim();			
			if(name.equalsIgnoreCase(tabName.trim())){
				isTabPresent=true;
				tabbing.click();
				break;
			}
			
		}if(!isTabPresent) {
			Assert.assertTrue(isTabPresent, tabName+ " - tab is not present");
			
		}		
	}
	
	public boolean orderIdTabInAdmin(String tabName) throws Exception {
		logInfo("Entered into orderIdTabInAdmin() method.");
		waitOnSpinner();
		wdWait("cssSelector", ordIdTabs);
		scrollDown("cssSelector", ordIdTabs);
		List<WebElement> tabs= driver().findElements(By.cssSelector(ordIdTabs));
		boolean isTabPresent= false;
		for(WebElement tabbing :tabs) {
			String name= tabbing.getText().trim();			
			if(name.equalsIgnoreCase(tabName.trim())){
				isTabPresent=true;				
				break;
			}			
		}
		return isTabPresent;		
	}
	
	
	
	public void submitShippingInAdmin() throws Exception {
		logInfo("Entered into submitShippingInAdmin() method.");
		wdWait("cssSelector", shipSubmit);
		waitOnSpinner();
		scrollDown("cssSelector", shipSubmit);
		clickOnButton("cssSelector", shipSubmit);
		waitOnSpinner();
		wdWait("cssSelector", msgShip);		
		String confMsg= getText("cssSelector", msgShip);
		System.out.println(confMsg);
		//Assert.assertEquals(confMsg, msgShipText);
	}
	
	public void submitInvoiceInAdmin() throws Exception {
		logInfo("Entered into submitInvoiceInAdmin() method.");
		waitOnSpinner();
		wdWait("cssSelector", invoiceSubmit);
		scrollDown("cssSelector", invoiceSubmit);
		clickOnButton("cssSelector", invoiceSubmit);
		wdWait("cssSelector", msgShip);
		String confMsg= getText("cssSelector", msgShip);
		System.out.println(confMsg);
		//Assert.assertEquals(confMsg, msgInvoiceText);
	}
	
	
	public void returnProduct() throws Exception {
		logInfo("Entered into returnProduct() method.");
		wdWait("cssSelector", prodRtn);
		clickOnObject("cssSelector", prodRtn);
		clickOnObject("cssSelector", prodRtnSubmit);
		
		
	}
	
	/**Generate a shipping code and store it 
	 * @throws Exception **/
	public void generatedShippingCode(String price) throws Exception {
		logInfo("Entered into generatedShippingCode() method.");		
		wdWait("cssSelector", addNewShipCodeBtn);
		String addNew= getText("cssSelector", addNewShipCodeBtn);		
		Assert.assertEquals(addNew, codeAddNewText);
		clickOnButton("cssSelector", addNewShipCodeBtn);
		Thread.sleep(3000);
		waitOnSpinner();
		wdWait("cssSelector", codeSave);
		String saveBtn= getText("cssSelector", codeSave);		
		Assert.assertEquals(saveBtn, "Save");
		clickOnObject("cssSelector", codeGenerator);
		
		enterText("cssSelector", codePrice, price);
		enterText("cssSelector", codeEmail, mailId);
		Thread.sleep(2000);
		wdWait("cssSelector", codeSave);
		
		WebElement savBtn= driver.findElement(By.cssSelector(codeSave));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", savBtn);
		Thread.sleep(10000);
		waitOnSpinner();
		wdWait("cssSelector", addNewShipCodeBtn);
		String back2NewAdd= getText("cssSelector", addNewShipCodeBtn);
		//Assert.assertEquals(back2NewAdd, codeAddNewText);	
		
	}
	
	
	public String getShippingCode(String colName, String customerEmail) throws Exception {
		logInfo("Entered into verifyDataFromColumns() method.");
		String shippingCodeIs = null;
		Thread.sleep(4900);
		wdWait("cssSelector", admPRColNames);
		boolean isPresent=false;
		List<WebElement> rows = driver.findElements(By.cssSelector(admPRColNames));
		int noOfRows = rows.size();
		System.out.println("noOfColumns "+noOfRows);
		for (int i=2;i<=noOfRows;i++) {
			String colTitle= driver.findElement(By.cssSelector(admPRColNamesBfr+i+admPRColNamesAfr)).getText().trim();
				if(colTitle.equalsIgnoreCase(colName)) {
				isPresent=true;
				boolean dataPresent=false;
				List <WebElement> dataRow = driver.findElements(By.cssSelector(admPRRowsBfr+i+")"));
				int size = dataRow.size();
				for(int j=1;j<=size;j++){
					WebElement eachCustomer = driver.findElement(By.cssSelector(eachRowBfr+j+eachRowAft+i+")"));
					String actCustomer = eachCustomer.getText().trim();					
					if((actCustomer.equalsIgnoreCase(customerEmail.trim()))) {
						dataPresent=true;
						System.out.println(i+" " + j+ " Customer Matched  "+actCustomer);
						waitOnSpinner();
						WebElement codeInRow = driver.findElement(By.cssSelector(eachRowBfr+j+eachRowAft+2+")"));
						shippingCodeIs=codeInRow.getText().trim();						
						break;
					}
				
					
				}if(dataPresent==false) {
					Assert.assertTrue(dataPresent, customerEmail+" email is not present");
				}
				break;
				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, colName + " column is not present");
		}
		return shippingCodeIs;			
	}
		
		
		
		
		
	
	
	
	
	
/***********************************************************************************/	
	
	/***verify all the ttile and text on Options screen 
	 * @throws Exception ***/
	
	public void verifyScreenReasonforReplacement() throws Exception {
		logInfo("Entered into verifyScreenReasonforReplacement() method.");
		wdWait("cssSelector", reasonOptionalTitle);
		String rsnRepTitle = getText("cssSelector", reasonTitle);
		
		String optRepTitle = getText("cssSelector", reasonOptionalTitle);
		softAssert.assertEquals(rsnRepTitle, reasonTitleText);
		softAssert.assertEquals(optRepTitle, reasonOptionalTitleText);	
		
		
		
		//String actHelp = getText("cssSelector", rsnHelp);
		//softAssert.assertEquals(actHelp, rsnHelpText);\		
//		String actHelpTextHolder = getAttribute("id", rsnText,"placeholder");
//		softAssert.assertEquals(actHelpTextHolder, rsnHelpHolderText);
		String actRsnSubtitle = getText("cssSelector", rsnSubTitle1);
		String actRsnSubtitle2 = getText("cssSelector", rsnSubTitle2);
		
		softAssert.assertEquals(actRsnSubtitle, rsnSubTitleText1);
		softAssert.assertEquals(actRsnSubtitle2, rsnSubTitleText2);
		
		
		
		String actContiue = getText("xpath", rsnCont);			
		String actStore= getText("cssSelector", fndStore);
		softAssert.assertEquals(actStore, fndStoreText);		
		softAssert.assertEquals(actContiue, rsnContBfr);		
		String actOptSubtitle = getText("cssSelector", optSubTitle1);
		String actOptSubtitle2 = getText("cssSelector", optSubTitle2);				
		softAssert.assertEquals(actOptSubtitle, optSubTex1);
		softAssert.assertEquals(actOptSubtitle2, optSubTex2);		
		String actAftContiue = getText("xpath", rsnCont);
		softAssert.assertEquals(actAftContiue, rsnContBfr);		
		softAssert.assertAll();
		
		
	}
	
	/***Navigater to 2nd screen in Options , validate all fields
	 * @throws Exception **/
	public void optionsReviewScreen() throws Exception {
		logInfo("Entered into optionsReviewScreen() method.");
		wdWait("xpath", revTitles);
		options2ndScreenTitles(revTitle);
		options2ndScreenTitles(paySummry);
		//options2ndScreenTitles(upgrade);
		
		
		
	}
	
	
	/****In Options 2nd screen , validate titles of each section.*****/
	public void options2ndScreenTitles(String expTitle) {
		logInfo("Entered into options2ndScreenTitles() method.");
		List<WebElement> titles = driver().findElements(By.xpath(revTitles));
		boolean isPresent=false;
		for(WebElement title:titles) {
			String eachTitle = title.getText().trim();
			if(eachTitle.equalsIgnoreCase(expTitle.trim())) {
				isPresent=true;
				break;
				
			}
		}if(!isPresent) {
			Assert.assertEquals(isPresent, expTitle + " is not present");
		}
		
	}
	
	/****In Checkout screen , validate titles of each section.* @throws Exception *****/
	 
	public void validateCheckoutScreen() throws Exception {
		logInfo("Entered into validateCheckoutScreen() method.");
		wdWait("cssSelector", shippingAddTitle);
		String address = getText("cssSelector", shippingAddTitle);
		String shipping = getText("cssSelector", shippingMtdTtile);
		String paymentTitle = getText("cssSelector", paymentMtdTtile);
		softAssert(address, shipAddress);
		softAssert(shipping, shipText);
		softAssert(paymentTitle, paymentText);
		String billing = getText("cssSelector", billAddTitle);
		String sameBillShip = getText("cssSelector", sameBillAdd);		
		softAssert(billing, billAddTitleText);
		softAssert(sameBillShip, sameBillAddText);
		softAssert.assertAll();
		
	}
	
	//In Checkout Screen, compares cost with product review and Payment Summary. 
	public void verifyProductCost() throws Exception {
		logInfo("Entered into verifyProductCost() method.");
		wdWait("cssSelector", prodCost);
		wdWait("cssSelector", paySumSubTotal);
		String prodReviewCost = getText("cssSelector", prodCost);
		String paySummrySubTotal = getText("cssSelector", paySumSubTotal);
		Assert.assertEquals(prodReviewCost, paySummrySubTotal);	
		
	}
	
	//In Checkout Screen, calculate Payment Summary
		public void paymentSummaryCalculationsInCheckout() throws Exception {
			logInfo("Entered into paymentSummaryCalculationsInCheckout() method.");
			wdWait("cssSelector", paySumTotal);
			String subTotal = getText("cssSelector", paySumSubTotal);
			String shipping = getText("cssSelector", paySumShipping);
			String tax = getText("cssSelector", paySumTax);
			String total = getText("cssSelector", paySumTotal);
			float fsub, fship, ftax, fgrandTotal,calculation;
			
			String[] splitSub= StringUtils.split(subTotal,"$");
			fsub=Float.parseFloat(splitSub[0]);		
			String[] splitShip=StringUtils.split(shipping,"$");
			fship=Float.parseFloat(splitShip[0]);		
			String[] splitTax=StringUtils.split(tax,"$");
			ftax=Float.parseFloat(splitTax[0]);
			String[] splitGrandTotal=StringUtils.split(total,"$");
			fgrandTotal=Float.parseFloat(splitGrandTotal[0]);
			calculation=fsub+fship+ftax;		
			Assert.assertEquals(calculation, fgrandTotal);		
		}
	
	
	//verifies Option Review screen - Payment Summary section and selects Continue
	public void paymentSummary() throws Exception {
		logInfo("Entered into paymentSummary() method.");
		waitOnSpinner();
		String actSubTotal= getText("cssSelector", subTotal);
		String[] splitSubTotal = StringUtils.split(actSubTotal,"$");
		float subTotalAmount = Float.parseFloat(splitSubTotal[0]);
		String actTax= getText("cssSelector", tax);
		float taxAmount = 0;
		float shippingAmt=0;
		if(!actTax.contains("--")) {
			String[] splitTax = StringUtils.split(actTax,"$");
			 taxAmount= Float.parseFloat(splitTax[0]);	
			 }
		String actShipping= getText("cssSelector", shipping);		
		if(!actShipping.contains("--")){
			String[] splitShip = StringUtils.split(actShipping,"$");
			shippingAmt=Float.parseFloat(splitShip[0]);			
		}
		
		String actTotal= getText("cssSelector", total);
		String[] splitTotal = StringUtils.split(actTotal,"$");
		float totalAmount= Float.parseFloat(splitTotal[0]);
		float sum = subTotalAmount+taxAmount+shippingAmt;	
		Assert.assertEquals(totalAmount, sum);
		scrollDown("cssSelector", contInOptReveiw);
		clickOnButton("cssSelector", contInOptReveiw);
		
	
		
	}
	/**Selects All Customers tab and verify screen
	 * @throws Exception **/
	public void customerScreen() throws Exception {
		logInfo("Entered into customerScreen() method.");
		wdWait("cssSelector", allCustomers);
		clickOnObject("cssSelector", allCustomers);	
		productAttributeTitle("Customers");
		
		
	}
	
	
	
	
//	/**Edit Customers based on passed email.
//	 * @throws Exception **/
//	public void editCustomer(String custEmail) throws Exception {
//		logInfo("Entered into editCustomer() method.");
//		wdWait("cssSelector", customerRows);
//		List<WebElement> rows = driver().findElements(By.cssSelector(customerRows));
//		int noOfRows = rows.size();
//		System.out.println("noOfRows "+noOfRows);
//		for (int i=1;i<=noOfRows;i++) {
//			String email= driver().findElement(By.cssSelector(emailBfr+i+emailAft)).getText().trim();
//			System.out.println("email"+email);
//			if(email.equalsIgnoreCase(custEmail)) {
//				WebElement editCust = driver().findElement(By.cssSelector(emailBfr+i+editAft));
//				editCust.click();
//				waitOnSpinner();
//				break;
//			}else {
//				Assert.assertEquals(email, custEmail + " email is not present");
//			}
//			
//		}
//		
//		
//	}
	
	
	public void loginAsCust() throws Exception {
		logInfo("Entered into loginAsCust() method.");
		wdWait("xpath", loginAsCustomerTab);
		String loginCustomer= getText("xpath", loginAsCustomerTab);
		System.out.println("tabs "+loginCustomer);
		if(loginCustomer.equalsIgnoreCase("Login as Customer")) {
			WebElement cust = driver().findElement(By.xpath(loginAsCustomerTab));
			Actions act = new Actions(driver);
			act.click(cust).build().perform();
			System.out.println("suceessasa");
			waitOnSpinner();
			driver.close();
			//act.moveToElement(cust).doubleClick().build().perform();
			//driver().navigate().to(appUrl+"en_"+ +"/customer/account/");			
		}
		
	}
	
	
	/****In Options 2nd screen , Try to identify Upgrade section.
	 * @throws Exception *****/
	public void identifyUgradeSection() throws Exception {
		logInfo("Entered into identifyUgradeSection() method.");
		List<WebElement> up = driver().findElements(By.cssSelector(upgradeSection));
		int size = up.size();
		if(size==0) {
			System.out.println("This product does not have Upgrade section");
			Assert.assertNotNull("This product does not have Upgrade section");
			
		}else {
			boolean isPresent=false;
			for(WebElement title:up) {
				String eachTitle = title.getText().trim();
				System.out.println("upgrade " +eachTitle);
				if(eachTitle.equalsIgnoreCase(upgrade.trim())) {
					isPresent=true;
					scrollDown("xpath", upgradeProdBtn);
					List<WebElement> prodBtn = driver().findElements(By.xpath(upgradeProdBtn));
					for(WebElement button :prodBtn) {
						button.click();
						break;
					}
					break;
					
				}
			}if(!isPresent) {
				Assert.assertEquals(isPresent, upgrade + " is not present");
			}
			
				
			}
		}
		
	
	/**  Shipping Code - validates all labels, texts.
	 * @throws Exception **/
	
	public void verifyShippingCodeDetails(String code) throws Exception {
		logInfo("Entered into verifyShippingCodeDetails() method.");
		waitOnSpinner();
		wdWait("cssSelector", shipCode);	
		scrollDown("cssSelector", shipCode);		
		String actCodeText= getText("cssSelector", shipCode);
		System.out.println("label name "+actCodeText);
		Assert.assertEquals(actCodeText, shipCodeLabel);
		scrollDown("cssSelector", shipCode);	
		clickOnObject("cssSelector", shipCode);
		WebElement chk = driver.findElement(By.cssSelector(shipCodeChk));
		chk.click();
		//clickOnObject("cssSelector", shipCodeChk);
		selectRadioOrCheckbox("cssSelector", shipCodeChk);
		wdWait("cssSelector", codeApply);
		
		
		clickOnButton("cssSelector", codeApply);
		Thread.sleep(2000);
		wdWait("cssSelector", codeReq);
		String required= getText("cssSelector", codeReq);
		System.out.println("required "+required);
		Assert.assertEquals(required, exEmailAlertText);
		enterText("cssSelector", shipCodeText, code);
		clickOnButton("cssSelector", codeApply);
		String errorMsg = getText("cssSelector", codeError);
		System.out.println("errorMsg"+errorMsg);
		Assert.assertEquals(errorMsg, codeErrorMsg);
		String actAppText = getText("cssSelector", codeApply);
		System.out.println(actAppText);
		Assert.assertEquals(actAppText, "Apply");		
	}
	
	
	public void handleShippingCode(String code) throws Exception {
		logInfo("Entered into handleShippingCode() method.");
		waitOnSpinner();
		wdWait("cssSelector", shipCode);	
		scrollDown("cssSelector", shipMthdList);
		clickOnObject("cssSelector", shipCode);
		clickOnObject("cssSelector", shipCodeChk);
		selectRadioOrCheckbox("cssSelector", shipCodeChk);
		wdWait("cssSelector", codeApply);
		String actAppText = getText("cssSelector", codeApply);
		System.out.println(actAppText);
		Assert.assertEquals(actAppText, "Apply");
		enterText("cssSelector", shipCodeText, code);		
		clickOnButton("cssSelector", codeApply);		
		
	}
	
	//validate  Shipping price after shipping code is applied
	public void validateShippingPrice(String expPrice) throws Exception {
		logInfo("Entered into validateShippingPrice() method.");
		waitOnSpinner();
		String shipping = getText("cssSelector", paySumShipping);
		String[] splitShip=StringUtils.split(shipping,"$");
		
		System.out.println("fship "+splitShip[0]);
		Assert.assertEquals(splitShip[0], expPrice);
		
		
		
	}
	
	
		
	
	
	
	

}
	