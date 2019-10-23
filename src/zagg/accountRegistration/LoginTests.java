package zagg.accountRegistration;

import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;
@Priority(1)
public class LoginTests extends LoginMethods{
	
	/** Navigates to home page, selects signup and validates fields, title and alert messages etc. 
	 * **/
	@Test(priority=101)
	  public void validateNewAccount() throws Exception{	
		 	logInfo("Entered into validateNewAccount Test");		 	
		 	homePage();
		 	selectSignIn(USACountry);	
		 	validateAccount();		   
	  }
	
	
	@Test(priority=102)
	  public void validatePasswordPolicy() throws Exception{	
		 	logInfo("Entered into validatePasswordPolicy Test");		 	
		 	homePage();
		 	selectSignIn(USACountry);	
		 	passwordValidation();
		 	
		 	
		 	
		 	//validateAccount();		   
	  }
	 
	 //** Selects SignUp and creates new account details with valid details.	  
	@Test(priority=103)
	  public void createNewAccount() throws Exception{	
		 	logInfo("Entered into createNewAccount Test");	
		 	homePage();
		 	selectSignIn(USACountry);	
		 	createAccount(mailId);
		 	validateConfMessage(confMailMessage);		   
	  }
	 
	
	//Login into Gmail account with valid user "zagg.automationtest@gmail.com" and verifies subject to select activation
	// link in Inbox .
	
	 @Test(priority=104)
	  public void activateAccountFromGmail() throws Exception{	
		 	logInfo("Entered into activateAccountFromGmail Test");		 	
		 	gmailLogin(mailId, maiLlinkText);
	  }	
	 
	 // Handles Confirmed Account as well as Different windows after link is selected from personal gmail account.
	 @Test(priority=105)
	  public void confirmUserAccount() throws Exception {
		 logInfo("Entered into confirmUserAccount Test");	
		 confirmedAccount();
		 
	 }
	 //** Verifies existing user details to validate alert message.	  
	 @Test(priority=106)
	  public void validateAlertsForExistingUser() throws Exception{	
		 	logInfo("Entered into validateAlertsForExistingUser() Test");	
		 	homePageByCountry(USACountry);
		 	selectSignIn(USACountry);	
		 	validateAlertsForExtisingUser();	 	
		   
	  }
	 
	 /**Existing User - Enter into Account with invalid credentials
		 * @throws Exception */
		 
		 @Test(priority=107)
		 public void loginWithInvalidCredentials() throws Exception {
			 logInfo("Entered into loginWithInvalidCredentials() Test");	
			 String mailId = "zagg."+TestBase.generateRandomNumberInRange(1, 20000)+"@gmail.com";
			 existingUserLogin(unqName, mailPwd);
			 incorrectFormatMail();
			 existingUserLogin(mailId, mailPwd);
			 confirmationMessage(existingUserErrorText);			 
			 //validateTitle(dashBrdTitle);			 
		 }
	 
	 /**Existing User - Enter into Account with valid credentials
	 * @throws Exception */
	 
	 @Test(priority=108)
	 public void loginWithValidCredentials() throws Exception {
		 logInfo("Entered into loginWithValidCredentials() Test");	
		 homePageByCountry(USACountry);
		 handleOfferPopUp();
		 selectSignIn(USACountry);
		 existingUserLogin(mailId, mailPwd);
		 validateHomeTitle(dashBrdTitle);	
		 handleOfferPopUp();
	 }
	 
	 /**Forgot Password- handle the functionality
	 * @throws Exception **/
	 
	 @Test(priority=109)
	 public void resettingPassword() throws Exception {
		 logInfo("Entered into resettingPassword() Test");	
		 logoutAsCustomer();
		 homePage();
		 selectSignIn(USACountry);
		 handleForgotPassword(mailId);     //"zagg.automationtest123@gmail.com");       
		 confirmationMessage(resetPwdInform);	
		 //gmailLogin(mailId, gmailResetSummary);
//		 
//		 handleForgotPassword(mailId);
//		 	
		 
	//gmailLogin(mailId, gmailResetSummary);
		 gmailPageAccess();		 
		 mailList(gmailResetSummary);
		 newPassword();
		 
		 //to do 
		 
		 
	 }
	 


	  

}
  