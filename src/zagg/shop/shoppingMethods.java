package zagg.shop;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.lib.TestBase;

import zagg.accountRegistration.LoginMethods;
import zagg.prodRegistration.ProductRegistartionMethods;
import zagg.warrantReplacement.WarrantReplacementMethods;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class shoppingMethods extends TestBase{
	
	ProductRegistartionMethods pr = new ProductRegistartionMethods();
	WarrantReplacementMethods wrm = new WarrantReplacementMethods();
	LoginMethods login= new LoginMethods();
	String thanks = "THANK YOU FOR YOUR ORDER";
	String process = "Processing";
	
	
	/**Selects SignIn link and validate CustomerLogin title**/
	public void selectSignIn() throws Exception {
		logInfo("Enter into selectSignIn() method");
		wdWait("cssSelector", signIn);		
		clickOnObject("cssSelector", signIn);
		implicityWaits(5);
		driver.navigate().to(appUrl+"en_us/customer/account/login/");
		wdWait("cssSelector", newAccTitle);		
		validateHomeTitle(custLoginText);	
	}
	
	public void existingUserLogin(String emailId, String password) throws Exception {
		logInfo("Enter into existingUserLogin() method");		
		clearText("cssSelector", existEmail);
		clearText("cssSelector", existPwd);
		enterText("cssSelector", existEmail, emailId);		
		enterText("cssSelector", existPwd, password);
		clickOnButton("cssSelector", exSignInBtn);
		
	}
	
	public void nav2Shop(String country) {
		logInfo("Enter into nav2Shop(String country) method");	
		driver.navigate().to(appUrl+"en_"+country); 
		clickOnObject("cssSelector", shopTab);
		System.out.println(driver.getCurrentUrl());
		
		
	}
	
	public void selectProduct(String country) throws Exception {
		logInfo("Enter into selectProduct() method");	
		clickOnObject("cssSelector", shopTab);
		driver.navigate().to(appUrl+"en_"+country+"/cables-adapters");
		wdWait("xpath", productItem);
		scrollDown("xpath", productItem);
		String text = getText("xpath", productItem);
		System.out.println(text);
		clickOnObject("xpath", productItem);
		waitOnSpinner();
		handleOfferPopUp();
		
		wdWait("cssSelector", addToCart);
		clickOnObject("cssSelector", ratingWidget);
		wdWait("cssSelector", addToCart);
		waitOnSpinner();
		clickOnObject("cssSelector", addToCart);
		wdWait("cssSelector", allowCookies);
		clickOnObject("cssSelector", allowCookies);
		
		wdWait("cssSelector",checkoutBtn);
		wdWait("cssSelector", addToCart);
		handleOfferPopUp();
		clickOnObject("cssSelector", addToCart);
		wdWait("cssSelector",checkoutBtn);
		clickOnObject("cssSelector",checkoutBtn);
		
	}
	
	
	//shop-by-device/apple-watch-series-1?cat=1825
	
	
	//Select place order button at final
	public void defaultPlaceOrder() throws Exception {
		logInfo("Enter into defaultPlaceOrder() method");	
		Thread.sleep(15000);
		waitOnSpinner();
		scrollDown("cssSelector", shopAgree);
		List <WebElement> sizes = driver.findElements(org.openqa.selenium.By.cssSelector(shopAgree));
		System.out.println("checkbox size "+sizes.size());
		WebElement chckBox = driver.findElement(By.cssSelector(shopAgree));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", chckBox);	
		//clickOnObject("cssSelector", shopAgree);	
		selectRadioOrCheckbox("cssSelector", shopAgree);
		String currentUrls= driver.getCurrentUrl();
		if(currentUrls.contains("en_uk")) {
			System.out.println("Entered here");
			WebElement ppchckBox = driver.findElement(By.cssSelector(pricvacyPolChkBx));
			js.executeScript("arguments[0].click();", ppchckBox);	
		}
		
		
		wdWait("cssSelector", paceOrderBtn);		
		WebElement ord = driver.findElement(By.cssSelector(paceOrderBtn));
		WebDriverWait wait = new WebDriverWait(driver, 20); 		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(paceOrderBtn)));	
		String getTest= ord.getText().trim();
		System.out.println(getTest);
		ord.click();;
		waitOnSpinner();
		
	}

	
		
	//After successfull order , capture Order Number and verify in dashboard.
	
	public void verifyOrderStatus() throws Exception {
		logInfo("Enter into verifyOrderStatus() method");	
		Thread.sleep(7000);
		waitOnSpinner();
		wdWait("xpath", orderSuccessTilte);
		String successMsg = getText("xpath", orderSuccessTilte);		
		Assert.assertEquals(successMsg, thanks);		
		String expOrderNumber=getText("xpath", orderNumber);
		System.out.println("ordId "+ expOrderNumber);	
		
		
		/*getDetails of payment summary after Order is placed***/
		String subTotal= getText("cssSelector", defSubtotal);
		String[] splitSubTotal = StringUtils.split(subTotal,"$");
		float expSubTotal = Float.parseFloat(splitSubTotal[0]);
		String shipping= getText("cssSelector", defShippingl);
		String[] splitshipping = StringUtils.split(shipping,"$");
		float expShipping = Float.parseFloat(splitshipping[0]);
		
		String tax= getText("cssSelector", defTax);
		String[] splitTax = StringUtils.split(tax,"$");
		float expTax = Float.parseFloat(splitTax[0]);
		
		String grandTotal= getText("cssSelector", defGrandTotal);
		String[] splitgrandTotal = StringUtils.split(grandTotal,"$");
		float expgrandTotal= Float.parseFloat(splitgrandTotal[0]);
		float calculation = expSubTotal+expShipping+expTax;
		//Assert.assertEquals(expgrandTotal, calculation);
		clickOnObject("xpath", orderNumber);
		waitOnSpinner();
		validateHomeTitle(purChaseText);	
		//verification on Purchase Details screen.
		wdWait("cssSelector", back2Order);
		clickOnObject("cssSelector", back2Order);
	
		
		
		pr.selectLeftTab("Account Dashboard");
		myOrdersDetails(expOrderNumber,process);  
		//myOrdersDetails("M2Z00000579F",process);           
		
		/*getDetails of payment summary from OrderHistory ***/
		wdWait("cssSelector", defSubtotal);
		String OHsubTotal= getText("cssSelector", defSubtotal);
		String OHsplitSubTotal = OHsubTotal.replace("$", "");
		System.out.println("OHsubTotal "+OHsplitSubTotal);
		//String[] OHsplitSubTotal = StringUtils.split(OHsubTotal,"$");
		float OHexpSubTotal = Float.parseFloat(OHsplitSubTotal);	
		System.out.println("OHexpSubTotal "+OHexpSubTotal);		
		
		String OHshipping= getText("cssSelector", defShippingl);
		String OHsplitshipping = OHshipping.replace("$", "");
		float OHexpShipping = Float.parseFloat(OHsplitshipping);
		System.out.println("OHexpShipping "+OHexpShipping);
		String OHtax= getText("cssSelector", defTax);
		String OHsplitTax = OHtax.replace("$", "");
		float OHexpTax = Float.parseFloat(OHsplitTax);
		System.out.println("OHexpTax "+OHexpTax);
		String OHgrandTotal= getText("cssSelector", defGrandTotal);
		String OHsplitgrandTotal = OHgrandTotal.replace("$", "");
		float OHexpgrandTotal= Float.parseFloat(OHsplitgrandTotal);
		System.out.println("OHexpgrandTotal "+OHexpgrandTotal);
		Assert.assertEquals(OHexpSubTotal, expSubTotal);
		Assert.assertEquals(OHexpShipping, expShipping); 
		Assert.assertEquals(expTax, OHexpTax);
		Assert.assertEquals(expgrandTotal, OHexpgrandTotal); 
		
		
		
	}
	
	//getDetails of payment summary after Order is placed
	public void myOrdersDetails(String orderId, String status) throws Exception {
		logInfo("Enter into verifyOrderStatus() method");
		pr.selectLeftTab(phTitle);
		wdWait("cssSelector", orderList);
		List<WebElement> orders = driver.findElements(By.cssSelector(orderList));
		int ordersSize = orders.size();
		boolean isPresent =false;
		for (int i=1; i<=ordersSize;i++){
			WebElement ordId= driver.findElement(By.cssSelector(orderBfr+i+orderAft));
			String 	orderNumb	= ordId.getText().trim();
			System.out.println("DashbOard  ordId "+ orderNumb);
			if(orderNumb.equalsIgnoreCase(orderId)) {
				isPresent=true;
				String actOrdStatus= driver.findElement(By.cssSelector(orderBfr+i+ordStatus)).getText().trim();
				System.out.println("actOrdStatus "+ actOrdStatus);
				Assert.assertEquals(actOrdStatus, status);
				clickOnObject("cssSelector", orderBfr+i+orderAft);				
				break;
				
			}
		}if(!isPresent) {
			Assert.assertEquals(isPresent, orderId+ " is not present");
		}
		
		
	}
	
	public void userAddressDetails() throws Exception {
		logInfo("Enter into userAddressDetails() method");
		scrollDown("cssSelector", userEmail);
		clearText("cssSelector", userFName);
		clearText("cssSelector", userFName);
		clearText("cssSelector", userLName);
		clearText("cssSelector", userSTAddress);
		clearText("cssSelector", userCity);
		clearText("cssSelector", userZipCode);
		enterText("cssSelector", userEmail, userEmailId);
		enterText("cssSelector", userFName, userFirstName);
		enterText("cssSelector", userLName, userLastName);
		enterText("cssSelector", userSTAddress, useraddress1);
		enterText("cssSelector", userCity, usercity);
		enterText("cssSelector", userZipCode, userZip);
		clickOnObject("cssSelector", userState);
		wdWait("cssSelector", userStateOpt);
		selectFromDropdown("cssSelector", userStateOpt, "byVisibleText", countryUS);
		List<WebElement> states = driver.findElements(org.openqa.selenium.By.cssSelector(userStateOpt));		
		for(WebElement state:states) {
		 String stateName= state.getText().trim();
		  if(stateName.equalsIgnoreCase("Colorado")) {
			 state.click();
			 Thread.sleep(5000);
			 break;
		 }
			
		}		
	}
	
	public void addressSuggestion() throws Exception {
		logInfo("Enter into addressSuggestion() method");
		
		wdWait("cssSelector", gogAddTitle);
		
//		WebElement addTitle = driver.findElement(By.cssSelector(gogAddTitle));
//		String title = addTitle.getText().trim();
//		System.out.println("title "+title);		
		WebElement radBlab = driver.findElement(By.cssSelector(gogAddLabel));	
		System.out.println(radBlab.getText());
		WebElement radBtn = driver.findElement(By.cssSelector(gogAddRadio));
		System.out.println("dqedqwehhwehwehwhew");
		String rad = radBtn.getAttribute("value");
		System.out.println("rad "+rad);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", radBtn);
		//radBtn.click();
		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		
//		
//		
//		
		
		//clickOnObject("cssSelector", gogAddRadio);
		WebElement gogCont = driver.findElement(By.cssSelector(gogContBtn));
		System.out.println("button is "+gogCont.getText() );
		gogCont.click();
		
			
//			WebElement sug= driver.findElement(By.cssSelector(sugg));
//			System.out.println("sug"+ sug.getText());
			//driver.switchTo().frame("ModelFrameTitle");
			//popup po 
		
		}
		
		
		
		
	
	
	
	public void addressSuggestion_orig() throws Exception {
		logInfo("Enter into addressSuggestion() method");
			waitOnSpinner();
			String wndBeforeWindow = driver().getWindowHandle();	
			for(String w : driver().getWindowHandles()){
				int win = driver().getWindowHandles().size();
				System.out.println(win+ " size");
				
				System.out.println("Title is "+driver.getTitle());
				if(!w.equalsIgnoreCase(wndBeforeWindow)){
					driver().switchTo().window(w);
					String title = getText("cssSelector", sugg);
					System.out.println(title+" suggestion");
					
				}else {
					//Alert alert = new 
				}
			
		
		}
		
		
		
		
	}
	
	
	public void validateOrderWithoutUser() throws Exception {
		logInfo("Enter into validateOrderWithoutUser() method");
		waitOnSpinner();
		wdWait("xpath", orderSuccessTilte);
		String successMsg = getText("xpath", orderSuccessTilte);
		
		Assert.assertEquals(successMsg, thanks);
		String succUrl = driver.getCurrentUrl();
		if(succUrl.contains("checkout/onepage/success/")) {
			System.out.println("Succed");
		}else {
			Assert.assertNotNull("checkout/onepage/success/");
		}
	}
	
	
	public void selectProductWithoutUser() throws Exception {
		logInfo("Enter into selectProductWithoutUser() method");	
		clickOnObject("cssSelector", shopTab);
		driver.navigate().to(appUrl+"en_us/juice-pack-headphone-extender-and-extender");
		wdWait("xpath", productItem);
		scrollDown("xpath", productItem);
		clickOnObject("xpath", productItem);
		waitOnSpinner();
		
		wdWait("cssSelector", addToCart);
		clickOnObject("cssSelector", ratingWidget);
		handleOfferPopUp();
		wdWait("cssSelector", addToCart);
		Thread.sleep(2000);
		clickOnObject("cssSelector", addToCart);		
		wdWait("cssSelector",checkoutBtn);
		String chk = getText("cssSelector",checkoutBtn);
		
		wdWait("cssSelector", addToCart);
		clickOnObject("cssSelector", addToCart);
		handleOfferPopUp();
		wdWait("cssSelector",checkoutBtn);
		clickOnObject("cssSelector",checkoutBtn);
		driver.navigate().to(appUrl+"en_us/checkout/#");
		Thread.sleep(5000);
		
	}
	
	/***selects amazon pay button and enter all the required detail
	 * @throws Exception **/
	
	public void handleAmazonPayment() throws Exception {
		logInfo("Enter into handleAmazonPayment() method");	
		Actions act = new Actions (driver());
		waitOnSpinner();
		scrollDown("cssSelector", ccRadio);
		wdWait("cssSelector", ccRadio);
		clickOnObject("cssSelector", total);
		
		WebElement ccRad= driver().findElement(org.openqa.selenium.By.cssSelector(ccRadio));
		act.moveToElement(ccRad).doubleClick().build().perform();
		wdWait("cssSelector", amazonRadio);	
		scrollDown("cssSelector", amazonRadio);
		WebElement amzRad= driver().findElement(org.openqa.selenium.By.cssSelector(amazonRadio));
		act.moveToElement(amzRad).doubleClick().build().perform();
		WebElement amzIcon= driver().findElement(org.openqa.selenium.By.cssSelector(amzonPayIcon));
		act.moveToElement(amzIcon).doubleClick().build().perform();
		waitOnSpinner();
		handleAmzonWindow();
		
	
	}
	
	
	public void handleAmzonWindow() throws Exception{
		logInfo("Enter into handleAmzonWindow() method");	
		String wndBeforeWindow = driver().getWindowHandle();	
		for(String w : driver().getWindowHandles()){
			if(!w.equalsIgnoreCase(wndBeforeWindow)){
				driver().switchTo().window(w);
				clickOnObject("cssSelector", amzonEmail);
				enterText("cssSelector", amzonEmail,amzonUser);
				enterText("cssSelector", amzonPassword,amzonPwd);
				submitObject("cssSelector", amzonPassword);
				driver().switchTo().window(wndBeforeWindow);
				System.out.println(driver.getCurrentUrl());
				waitOnSpinner();
				
			}
		}
	
	}
	
	
	
	/******  Purchase History     ******/
	
	public String getOrderNumber() throws Exception {
		logInfo("Enter into getOrderNumber() method");
		waitOnSpinner();
		wdWait("cssSelector", purOrderNum);
		String ord = getText("cssSelector", purOrderNum);
		System.out.println(ord);
		String[] splitOrd= StringUtils.split(ord, ":");
		String orderNum = splitOrd[1];
		System.out.println(orderNum);
		return orderNum;	
		
	}
	
	

}
