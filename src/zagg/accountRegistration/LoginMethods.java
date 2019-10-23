package zagg.accountRegistration;

import com.lib.TestBase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginMethods extends TestBase{
	SoftAssert softAssert = new SoftAssert();
	
	/** Navigates to home page*/
	public void homePage() throws Exception {
        logInfo("Enter into homePage method");
        driver.navigate().to(appUrl);
        handleOfferPopUp();
        
	}
	
	
	
	
	/**Selects SignIn link and validate CustomerLogin title**/
	public void selectSignIn(String byCountry) throws Exception {
		logInfo("Enter into selectSignIn() method");
		driver.navigate().to(appUrl+"en_"+byCountry);
		driver.navigate().to(appUrl+"en_"+byCountry+"/customer/account/login/");
		//https://staging.zagg.com/en_eu/customer/account/login/
		wdWait("cssSelector", newAccTitle);	
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("en_"+byCountry)) {
			validateHomeTitle(custLoginText);
			
		}else {
			Assert.assertEquals(currentUrl, appUrl+"en_"+byCountry);
		}
		
		
		
		
	}
	
	
	/** Validates titles of new account, fields , messages, Alert messages etc.**/
	public void validateAccount() throws Exception {
		logInfo("Enter into validateAccount() method");	
		String password = "123abc";
		//String emailInvalidFormat = "123abc@#";
		clickOnObject("cssSelector", createAccLink);
		wdWait("id", fName);
		validateHomeTitle(newAccTitleText);	
		wdWait("id", fName);		
		String actEmailLabel = getText("xpath", emaillabel);		
		softAssert.assertEquals(actEmailLabel, emaillabelText);
		WebElement  pwdHid = driver.findElement(By.cssSelector(pwdHolder));	
		String pwdHide =pwdHid.getText();		
		softAssert.assertEquals(pwdHide, pwdShowText);
		pwdHid.click();
		enterText("id", fName, unqName);
		enterText("id", lName, lastName);
		enterText("cssSelector", email, password);
		enterText("cssSelector", pwdField, mailPwd);
		submitObject("cssSelector", email);		
		wdWait("cssSelector", newEmailAlert);
		String emailAlert= driver.findElement(By.cssSelector(newEmailAlert)).getText();	
		System.out.println(emailAlert);
		softAssert.assertEquals(emailAlert,emailFmtErrorText);		
		WebElement  pwdSho= driver.findElement(By.cssSelector(pwdHolder));	
		String pwdShow =pwdSho.getText();		
		softAssert.assertEquals(pwdShow, pwdHideText);		
		String expPwdText = driver.findElement(By.cssSelector(pwdPolicy)).getText();
		System.out.println(expPwdText);
		softAssert.assertEquals(expPwdText, pwdPolicyText);		
		softAssert.assertAll();
		
	}
	
	/***validates password with minimum characters , error gushing  like only numbers or alpha or special characters
	 * @throws Exception ***/
	public void passwordValidation() throws Exception {
		logInfo("Enter into passwordValidation() method");
		clickOnObject("cssSelector", createAccLink);
		wdWait("id", fName);
		enterText("id", fName, unqName);
		enterText("id", lName, lastName);
		enterText("cssSelector", email, mailId);
		clearText("cssSelector", pwdField);
		submitObject("cssSelector", accountBtn);
		//Blank password field verification
		headerAlertsMsg(newPwdAlert);  		
		wdWait("cssSelector", accountBtn);
		clearText("cssSelector", pwdField);
		clickOnObject("cssSelector", pwdHolder);
		enterText("cssSelector", pwdField, "1234567");
		submitObject("cssSelector", accountBtn);
		//Only one type of characters verification
		//confirmationMessage(pwdCombErrorText);
		headerAlertsMsg(pwdCombErrorText);		
		wdWait("cssSelector", accountBtn);
		clearText("cssSelector", pwdField);
		submitObject("cssSelector", accountBtn);
		//Blank password field verification		
		mandatoryAlert(exEmailAlertText);
		//confirmationMessage(exEmailAlertText);
		//pwdAlerts(exEmailAlertText);  			
		wdWait("cssSelector", accountBtn);
		clearText("cssSelector", pwdField);
		clickOnObject("cssSelector", pwdHolder);
		enterText("cssSelector", pwdField, "abcdefgh");		
		submitObject("cssSelector", accountBtn);
		//Only one type of characters verification
		//pwdAlerts(pwdCombErrorText);
		headerAlertsMsg(pwdCombErrorText);
		
		
		
		

		wdWait("cssSelector", accountBtn);
		clearText("cssSelector", pwdField);
		clickOnObject("cssSelector", pwdHolder);
		enterText("cssSelector", pwdField, "abc");
		submitObject("cssSelector", accountBtn);
		//minium numbers of  characters verification
		headerAlertsMsg(pwdMinCharacters);
		
		
		
		
		
		softAssert.assertAll();
		

		
//		enterText("cssSelector", pwdField, mailPwd);
//		submitObject("cssSelector", email);
		
		
	}
	
	
	// to find alert message under the field.
	
	public void mandatoryAlert(String mandAlert) throws Exception {
		logInfo("Enter into mandatoryAlert() method");
		wdWait("cssSelector",pwdErr);
		String actAlert = driver.findElement(By.cssSelector(pwdErr)).getText().trim();
		System.out.println("actAlert "+actAlert);
		softAssert.assertEquals(actAlert, mandAlert);
		
	}
	
	// Asserts alert at header level 
	
	public void headerAlertsMsg(String alertMsg) throws Exception {
		logInfo("Enter into headerAlertsMsg() method");
		wdWait("cssSelector",pwdError);
		String actAlert = driver.findElement(By.cssSelector(pwdError)).getText().trim();
		System.out.println("actAlert "+actAlert);
		softAssert.assertEquals(actAlert, alertMsg);
		
	}
	
	/**Enter details for new account and then submit**/
	public void createAccount(String emailId) throws Exception {
		logInfo("Enter into createAccount() method");
		clickOnObject("cssSelector", createAccLink);
		wdWait("id", fName);
		enterText("id", fName, unqName);
		enterText("id", lName, lastName);
		enterText("cssSelector", email, emailId);
		enterText("cssSelector", pwdField, mailPwd);
		submitObject("cssSelector", email);
		wdWait("cssSelector", confChkMail);				
	}
	
	
	/**validates either confirmation message  or alert message And Selects that link
	 * @throws Exception **/
	public void validateConfMessage(String message) throws Exception {
		logInfo("Enter into validateConfMessage() method");
		boolean isMsgPresent = false;
		wdWait("cssSelector", confChkMail);
		String confMsg = driver.findElement(By.cssSelector(confChkMail)).getText();		
		if(confMsg.contains(message)) {
			isMsgPresent=true;
			driver.findElement(By.cssSelector(confClikHere)).click();		
		}if (isMsgPresent==false){
			Assert.assertTrue(isMsgPresent, message + " - is not present.");
			
		}	
	}
	
	/**Confirmation Link page - validates Email field placeholder with email and selects button**/
	public void sendConfirmationLink(String expectedEmail) throws Exception {
		logInfo("Enter into sendConfirmationLink() method");
		String emailPlaceHolder = driver.findElement(By.cssSelector(confEmailField)).getAttribute("value");
		//String emailHolder= getText("cssSelector", confEmailField, "attribute");
		System.out.println("emailHolder "+emailPlaceHolder);
		Assert.assertEquals(emailPlaceHolder, expectedEmail);
		clickOnObject("cssSelector", sendConfBtn);
		
		
	}
	
	/**validates confirmation message or Alert Message**/
	public void confirmationMessage(String message) {
		logInfo("Enter into confirmationMessage() method");	    
		String confMsg = driver.findElement(By.cssSelector(confChkMail)).getText();
		System.out.println(confMsg);
		softAssert.assertEquals(confMsg, message);		
	}
	
	/**validates confirmation message or Alert Message**/
	public void confirmationMessage_orgin(String message) {
		logInfo("Enter into confirmationMessage() method");
		boolean isMsgPresent = false;
		String confMsg = driver.findElement(By.cssSelector(confChkMail)).getText();
		System.out.println(confMsg);
		if(confMsg.contains(message)) {
			isMsgPresent=true;
		}if (isMsgPresent==false){
			Assert.assertTrue(isMsgPresent, message + " - is not present.");
		}	
	}
	
	/* verifies  existing User blank email, minimum character password, invalid format EmailId**/
	public void validateAlertsForExtisingUser() throws Exception {
		logInfo("Enter into validateAlertsForExtisingUser() method");
		clickOnButton("cssSelector", exSignInBtn);
		wdWait("cssSelector", exEmailAlert);
		String expEmailError = driver.findElement(By.cssSelector(exEmailAlert)).getText().trim();
		System.out.println(expEmailError);
		boolean isPresent = false;
		if(expEmailError.contains(exEmailAlertText)) {
			isPresent=true;
			clearText("cssSelector", existEmail);
			String emailPlaceHolder = driver.findElement(By.cssSelector(existEmail)).getAttribute("placeholder");
			Assert.assertEquals(emailPlaceHolder, existEmailHolder);
			enterText("cssSelector", existPwd, "abcd");
			clickOnButton("cssSelector", exSignInBtn);
			String expEmailError2 = driver.findElement(By.cssSelector(exEmailAlert)).getText().trim();
			Assert.assertEquals(expEmailError2, exEmailAlertText);
			WebElement pwdShoStatus = driver.findElement(By.cssSelector(pwdHolder));
			String pwdStatus = pwdShoStatus.getText().trim();			
			Assert.assertEquals(pwdStatus, pwdShowText);	
			pwdShoStatus.click();
			String pwdHide = driver.findElement(By.cssSelector(pwdHolder)).getText();				
			Assert.assertEquals(pwdHide, pwdHideText);	
			
			
		}if(isPresent==false) {
			Assert.assertTrue(isPresent, exEmailAlertText + "- msg is not present");
		}
		
	}
	
	/**Enter incorrect format in mailId field and verify alert messages
	 * @throws Exception **/
	public void incorrectFormatMail() throws Exception {
		wdWait("cssSelector", exEmailAlert);
		String emailAlert2 = driver.findElement(By.cssSelector(exEmailAlert)).getText();	
		System.out.println(emailAlert2);
		Assert.assertEquals(emailAlert2,emailFmtErrorText);
	}
	
	public void existingUserLogin(String emailId, String password) throws Exception {
		logInfo("Enter into existingUserLogin() method");		
		waitOnSpinner();
		wdWait("cssSelector", existEmail);
		clearText("cssSelector", existEmail);
		String text = getAttribute("cssSelector", existEmail, "placeholder");
		clearText("cssSelector", existPwd);
		enterText("cssSelector", existEmail, emailId);		
		enterText("cssSelector", existPwd, password);
		clickOnButton("cssSelector", exSignInBtn);
	}
	
	
	/*** verifies forgot password link and navigates to resetting page and enters password.
	 * @throws Exception 
	 * */
	public void handleForgotPassword(String emailId) throws Exception {
		wdWait("cssSelector", forgotPwd);
		WebElement forgot = driver.findElement(By.cssSelector(forgotPwd));
		String actForgotPwd = forgot.getText();		
		if(actForgotPwd.equalsIgnoreCase(forgotPwdText)) {
			forgot.click();
			validateHomeTitle(resetTitle);		
			enterText("xpath", forgotEmail, emailId);
			clickOnObject("cssSelector", resetBtn);
			
			
		} else{
			Assert.assertEquals(actForgotPwd, forgotPwdText);
		}
		
	}
	
	// checks Confirmed Account popup and focus on Home Page
	public void confirmedAccount() throws Exception {
		logInfo("Enter into confirmedAccount() method");
		implicityWaits(30);
		String mainWindow = driver.getWindowHandle();
		ArrayList tabs = new ArrayList (driver.getWindowHandles());			
		if(driver.getTitle().contains("Main Website Store account")) {			
		//	driver.close();
			driver.switchTo().window(mainWindow);
			String inbox = driver.findElement(By.xpath(gmailInbox)).getText();
			clickOnObject("xpath", gmailInbox);
			wdWait("xpath", gmailInbox);	
			openGmail(maiLlinkText);
			wdWait("cssSelector", moreGmail);
			clickOnObject("cssSelector", moreGmail);
			Thread.sleep(4000);
			wdWait("cssSelector", gmailDelete);
			clickOnObject("cssSelector", gmailDelete);
			homePage();
			selectSignIn(USACountry);
	
			
		}else {
			driver.switchTo().window((String) tabs.get(0));
			driver.navigate().refresh();
			homePage();
			selectSignIn(USACountry);
		}
		
		
	}	
	
	
	
	
	public void newPassword() throws Exception {
		
		String mainWindow = driver.getWindowHandle();
		ArrayList tabs = new ArrayList (driver.getWindowHandles());			
		System.out.println("title is "+driver.getTitle());
		if(driver.getTitle().contains("Reset your Main Website Store password")) {			
			driver.switchTo().window(mainWindow);
			String inbox = driver.findElement(By.xpath(gmailInbox)).getText();
			System.out.println("inbox text "+ inbox);
			clickOnObject("xpath", gmailInbox);
			wdWait("xpath", gmailInbox);
			clickOnObject("xpath", gmailInbox);
			wdWait("xpath", gmailInbox);
			Thread.sleep(10000);
			
			driver.switchTo().window((String) tabs.get(1));
			driver.close();
			System.out.println("title"+driver.getTitle());
			driver.switchTo().window(mainWindow);
			System.out.println("Main title"+driver.getTitle());
			driver.switchTo().window((String) tabs.get(1));
			
			System.out.println("title"+driver.getTitle());
			clearText("cssSelector", rePwd);
			enterText("cssSelector", rePwd, mailPwd);
			clearText("cssSelector", rePwd);
			clearText("cssSelector", rePwd);
			enterText("cssSelector", rePwd, mailPwd);
			clickOnObject("cssSelector", resetBtn);
			
	
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	/** Navigates to Gmail home page*/
	public void gmailSignUp() throws Exception {
        logInfo("Enter into gmailSignUp method");
        driver.navigate().to(gmailPage);
        
	}
	
	public void gmailAccountDetails(String userName) throws Exception {
		logInfo("Enter into gmailAccountDetails() method");
		enterText("cssSelector", gmailFName, unqName);
		enterText("cssSelector", gmailLName, lastName);
		enterText("cssSelector", gmailEmailId, userName);
		enterText("cssSelector", gmailPwd, mailPwd);
		enterText("cssSelector", gmailConfPwd, mailPwd);
		clickOnButton("cssSelector", gmailNext);	
		
	}
	
	/** Navigates to home page*/
	public void gmailLogin(String userName, String mailSummary) throws Exception {
        logInfo("Enter into gmailLogin method");
        gmailPageAccess();
        enterText("cssSelector", gmailId, userName);
        clickOnObject("cssSelector", gmailIdNext);
        implicityWaits(5);
        wdWait("cssSelector", gmailIdPwdNext);
        wdWait("cssSelector", forgetPwd);
        String fgPwd = driver.findElement(By.cssSelector(forgetPwd)).getText().trim();
        enterText("cssSelector", gmailIdPwd, mailPwd);
        clickOnObject("cssSelector", gmailIdPwdNext);
        //driver.navigate().to(gmailAccess);
        
        mailList(mailSummary);       
	}
	
	
	 public void gmailPageAccess() {
		 driver.navigate().to(gmailLogin);
	 }
	
	public void mailList(String linkText) throws Exception {
		implicityWaits(10);
		wdWait("xpath", gmailsList);
		List <WebElement> mails = driver.findElements(By.xpath(gmailsList));
		int size = mails.size();
		boolean isPresent = false;		
		for (int i=1; i<=size; i++) {
			WebElement summ = driver.findElement(By.xpath(gmailListBfr+i+gmailListAft));
			String summary = summ.getText();			
			if(summary.contains(linkText)) {
				isPresent = true;
				summ.click();
				wdWait("cssSelector", mailLinkInGmail);
				clickOnObject("cssSelector", mailLinkInGmail);				
				break;				
			}
		}if(isPresent==false) {
			Assert.assertTrue(isPresent, linkText);
		}
		
		
	}
	
	public void openGmail(String linkText) throws Exception {
		implicityWaits(10);
		wdWait("xpath", gmailsList);
		List <WebElement> mails = driver.findElements(By.xpath(gmailsList));
		int size = mails.size();
		boolean isPresent = false;		
		for (int i=1; i<=size; i++) {
			WebElement summ = driver.findElement(By.xpath(gmailListBfr+i+gmailListAft));
			String summary = summ.getText();
			if(summary.contains(linkText)) {
				isPresent = true;
				summ.click();
				wdWait("cssSelector", mailLinkInGmail);								
				break;				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, linkText);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	 
}
