package com.lib;

public class Locators {
	
	// Drivers details	
				public  String projectPath = System.getProperty("user.dir");
				public  String filepath = projectPath+"/Downloads/";
				public  String uploadPath = projectPath+"/testdata/files/";
				//public  String gecko_driver = projectPath + "\\browserDrivers\\geckodriver.exe";
				//public  String chrome_driver = projectPath + "\\browserDrivers\\chromedriver.exe";
				public  String ie_driver= projectPath + "/browserDrivers/IEDriverServer";
				public  String safari_driver= projectPath + "/browserDrivers/SafariDriver";
				public  String screenShotsPath = projectPath+"/screenShots";
				public  int DEFAULT_WAIT_TIME = 180;
				public  String chrome_driver = projectPath +"/browserDrivers/chromedriver_mac";
				public  String gecko_driver = projectPath + "/browserDrivers/geckodriver_mac";
				public  String gecko_driver_linux = projectPath + "/browserDrivers/geckodriver_linux";
				public String excelFilePath = projectPath + "/attributeData/productDetails.xls";

				public  String appUrl = "https://staging.zagg.com/";                //"https://mcprod.zagg.com/";  //"https://staging.zagg.com/";   //"http://www.zagg.local/";	
				
				public String adminAccess = "mcadmin/";
				public String admin=  "xelits"  ;        //"selenium14"        xelits
				public String adminPassword="W3vNZ8jvYnx&JXCP"  ;         //"zagg@123";  W3vNZ8jvYnx&JXPC
				public String amzonUser= "amazon.sandbox@zagg.com";
				public String amzonPwd= "Password1";
				
				
				public String adminUserName = "div.admin__field-control > input#username";
				public String adminUserPwd = "div.admin__field-control > input#login";
				public String adminSignIn= "button.action-login.action-primary > span";
				public String adminLoginError = "div.messages > div.message.message-error.error > div";
				public String UKCountry= "uk";
				public String EUCountry= "eu";	
				public String USACountry= "us";
				
				
				/*******         Account  Manager ********/
				
				public String offerPop ="//div[@class='simpleltkmodal-wrap']//div[@id='ltkpopup-wrapper']//div[@id='ltkpopup-close-button']/a";
				public String offerSubject = "//div[@class='simpleltkmodal-wrap']//div[@id='ltkpopup-content']/p";
				public String logInTitle = "//div[@class='page-title']//h1";
				public String logInTitleText = "Log In / Sign Up";
				public String stagUserName= "ravi.tulasi@xelits.com";
				public String stagUserPWd= "xelits@123";
				public String unqName= "zagg.automationtest"; //"zagg."+TestBase.generateRandomNumberInRange(1, 20000);  //
				public String mailId=   unqName+"@gmail.com";       //"panippbuyer12@gmail.com";              
				public String lastName = "ACCEPT" ;        //+TestBase.generateRandomNumberInRange(1, 10);
				public String mailPwd ="zagg@123";		//"panippbuyer12@123"      ;  //
				public String secondUsermailId="ravi.tulasi@xelits.com"; 
				public String zaggUsermailId="ravi.tulasi@zagg.com";
				public String signIn="div.panel.wrapper > div > div.header-right-links > ul > li > a > span";                          //"ul > li.authorization-link > a > span";
				public String createAccLink = "fieldset > div.primary > a > span";
				public String fName = "firstname";
				public String lName = "lastname";
				public String email = "input#email_address";
				public String changePwd= "div.primary > button.action.submit.btn.btn-lg.btn-dark > span";
				public String pwdField = "input#password";
				public String pwdHolder = "span.pass-show-hide-password";
				public String pwdShowText= "Show";
				public String pwdHideText= "Hide";
				public String emailFmtError = "div#email_address-error";
				public String emailFmtErrorText = "Please enter a valid email address (Ex: johndoe@domain.com).";
				public String accountBtn= "#form-validate > div > button > span";
				public String emaillabel = "//label[@for='email_address']/span ";//"#form-validate > fieldset > div.field.required > label.email_address > span";
				public String emaillabelText = "Email Address";
				public String emailAlertText ="\"Email\" is not a valid email address.";
				public String custLoderSpinner  = "//div[@class='loading-mask'][@style='display: none;']";
				public String adminLoderSpinner  = "//div[@class='admin__data-grid-loading-mask'][@style='display: none;']";
				
				public String promotion  = "#form-validate > fieldset > div.field.choice.newsletter > label";
				public String promText = promotion+ "> span";
				public String promChkBx = promotion+ "> input";
				public String privacyPolicyLnk = "#form-validate > fieldset > div.field.choice.newsletter > p > a";
				public String newAccTitle ="h1.page-title > span";
				public String custLoginText ="Account Login";
				public String newAccTitleText ="Create an Account";   //"Create New Customer Account";
				public String sendConfLinkTxt="Send confirmation link";
				public String resetTitle = "Reset Your Password";
				public String dashBrdTitle = "Account Dashboard";
				public String pwdPolicy ="div.field.password.required > div > span > small";
				public String pwdPolicyText ="6 characters minimum, numbers, letters, and special characters only.";
				public String pwdErr = "div#password-error";
				public String pwdErrText="Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
				public String confChkMail = "div.page.messages > div:nth-child(2) > div > div > div";
				public String confClikHere = "div.page.messages > div:nth-child(2) > div > div > div > a";
				public String confMailMessage = "You must confirm your account. Please check your email for the confirmation link or click here for a new link.";
				public String alertMailMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
				public String confEmailField = "input#email_address";		
				public String sendConfBtn= "#form-validate > div > div > button > span";
				public String confMailMsg = "Please check your email for confirmation key";  // key should not there
				public String finalConfirm = "div#popup-modal > h1";
				public String finalConfirmText = "Account Created";
				public String regText= "p > strong ";
				public String infoUnderCreated = "#popup-modal > p.text-center.regulartext > strong";
				public String infoUnderCreatedText = "Thank you for creating an account with us!";
				public String finalClose= "div.modal-inner-wrap > header > button.action-close > span";
				public String existingUserErrorText = "You did not sign in correctly or your account is temporarily disabled.";
				public String logoutLnk = "div.header-right-links > ul > li > a";    //:nth-child(3);           //a > span.icon.icon-account";
				public String logoutText = "You are signed out";
				public String newEmailAlert ="div#email_address-error";
				
				
				public String existEmail = "input#email";
				public String existEmailHolder = "ex ******@email.com";
				public String existPwd = "input#password";
				public String exEmailAlert = "div#email-error";
				public String newPwdAlert = "Please enter a password with at least 6 characters.";
				public String exEmailAlertText = "This is a required field.";
				public String exSignInBtn = "button#login-send> span";
				public String forgotPwd ="div.secondary > a > span";
				public String forgotPwdText ="Forgot Your Password?";
				public String forgotEmail= "//*[@id='email_address']";
				public String resetBtn= "div.actions-toolbar > div.primary > button > span";//"div > div > button > span";
				public String resetPwdInform = "If there is an account associated with "+mailId +" you will receive an email with a link to reset your password.";
				public String pwdError ="div.message-error.error.message";      // "div#password-error";
				public String pwdMinErrorText = "Minimum length of this field must be equal or greater than 6 symbols. Leading and trailing spaces will be ignored.";
				public String pwdCombErrorText = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
				public String pwdMinCharacters = "Please enter a password with at least 6 characters.";
				public String rePwd = "div.field.email.required > div > input#email_address";
				
				
				
				
				public String gmailPage ="https://accounts.google.com/signup";
				public String gmailFName= "input#firstName";
				public String gmailLName= "input#lastName";
				public String gmailEmailId= "input#username";
				public String gmailPwd= "#passwd > div.aCsJod.oJeWuf > div > div.Xb9hP > input";
				public String gmailConfPwd= "#confirm-passwd > div.aCsJod.oJeWuf > div > div.Xb9hP > input";
				public String gmailNext= "#accountDetailsNext > content > span";
				public String gmailGender= "select#gender";
				public String gmailDay= "input#day";
				public String gmailYear= "input#year";
				public String gmailnext2= "#personalDetailsNext > div.ZFr60d.CeoRYc";
				public String gmailMonth= "select#month";
				//public String gmailLogin ="https://accounts.google.com/signin";
				public String gmailLogin ="https://mail.google.com/mail/";
				public String gmailId = "input#identifierId";
				public String gmailIdNext ="div#identifierNext";
				public String gmailIdPwd = "div#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input";
				public String gmailIdPwdNext ="div#passwordNext > span > span";
				public String forgetPwd = "div#forgotPassword > span > span";
				public String gmailAccess = "https://mail.google.com/mail/#inbox";
				public String gmailsList = "//div[@class='Cp']/div/table/tbody/tr//td[6]";
				public String gmailListBfr = "//div[@class='Cp']/div/table/tbody/tr[";
				public String gmailListAft = "]//td[6]//div[@class='y6']/span/span";
				public String maiLlinkText ="Please confirm your ZAGG account"; //"Please confirm your Main Website Store";
				public String mailPRAccount = "Your ZAGG Product Registration confirmation";
				public String mailLinkInGmail = "div > center > a";
				public String gmailInbox = "//span[starts-with(@class,'nU')]/ a[@title ='Inbox']";
				public String moreGmail = "tr.acZ > td.gH.acX.bAm > div#:80 > img.hA.T-I-J3";
				public String gmailDelete = "div.J-N > div.J-N-Jz > div > div.cj > img";
				public String gmailResetSummary= "Reset your Main Website Store password";
				public String gmailHere = "div.m_-6737070873100140924wrapper > div.m_-6737070873100140924mainwrapper > p:nth-child(6) > a";
				public String dashboardLeftTabs = "div.content.account-nav-content > ul.nav.items > li > a";
				public String prRegisterBtn = "#account-secondary-nav > ul > li > a";
				public String RegisterBtnText = "Register a Product";
				public String PRTitleText = "Product Registration";
				public String PRTitle= "div.page-title-wrapper > p.h1";
				public String title= "div.page-title-wrapper > h1 > span";
				public String purChaseText="Purchase Details";
				
				
				
				/****************************Product Registration*****************************************************************************/
				public String registerAProdButton="div.content.account-secondary-nav-content > ul  > li > a";    //"button#register-send > span"; //"div.content.account-secondary-nav-content > ul  > li > a";
				public String serialNoField= "input#serialnumber";
				public String PRTtitleText= "Product Registration";
				public String serialSecTitle ="div.block:nth-child(3) >p.h4"  ;                 //"div.block:nth-child(3) > div.serialnumberdiv > h4";
				public String serialSecSubTitle ="div.block:nth-child(3) >p:nth-child(2)";
				public String serialSecTitleText = "Enter Your Serial Number or Registration Code";
				public String serialSecSubTitleText= "If you have a serial number or registration code, enter it here to speed up the registration process.";
				public String contBtn ="//button[@id='serialnumberbtn']/span";
				public String contBtnText= "Continue";
				public String serialPlaceholderText="Serial number or registration code";
				public String serialNumber = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689);             //"110119GS6834";      110119GR9532      //99011799999  110419GZ0739
				public String serialNumber2 = "99011799999"; 
				public String serialNumberNotValid = "110119GS6875"; 
				public String serialNumberForEU = "110119GR9"+TestBase.generateRandomNumberInRange(370, 689); 
				public String noSerialNoFieldTitle= "input#serialnumber";
				public String registerBtn ="button#register-send > span";  //"//button[@id='send2']/span";
				public String registerBtnText ="REGISTER HERE";
				public String howFindSerialLnk= "div.block-content.mt-40 > p.mt-30 > a";               //"div > div.block-content > p > a";
				public String findSerialText = "\"How do I find my serial number?\"";
				public String serialErr ="//span[@id='errorcode']";
				public String serialErrHere ="//span[@id='errorcode']/a[1]";
				public String existingNumberError = "That number or code has already been used to register a product.";
				public String serialErrText= "Number or code does not exist.";
				public String serialAlertMsg = "Number or Code must contain at least five characters.";
				public String noSerialSecTitle ="div.block:nth-child(2) >p.h4";
				public String noSerialSecSubTitle ="div.block:nth-child(2) > p:nth-child(2)";
				public String noSerialSecTitleText = "Don't Have A Serial Number or Registration Code?";
				public String noSerialSecSubTitleText= "If your product doesn't require a serial number or registration code, you can search for your product here.";
				public String continueInOptions="button#stepper1setup"  ;       //"button.btn.btn-lg.btn-dark.login.primary";
				public String dateField = "input#datetimepicker";
				public String purchaseLabel = "div#test-l-1 > div.form-group.serrialnumbertab:nth-child(2) >h5";
				public String purchaseText = "Purchase Date";				
				public String statusBarOptions= "button#stepper1trigger1 > span.bs-stepper-label.circle1lab";
				public String optionsText = "Options";
				public String getAddressCount = "div.tab > button.tablinks";
				public String addtionalAddressRadio = "div.tab > button.tablinks > input#addrRad-";
				public String existFirstAddress= "div.tab > button.tablinks > input";
				public String existBillingAddress= "div.tab > button.tablinks > div.box.box-address-billing > div > input";
				public String existShippingAddress= "div.tab > button.tablinks > div.box.box-address-shipping > div > input";
				public String existAddressDetails= "div.tab > button.tablinks > div.box.box-address-shipping > div  > address";
				public String addressLine2= "div.field.field-name-addr2 > div > input#shipping-addr2";  // 
				public String addressLine1 = "input#shipping-addr1";
				public String addFName	= "newaddr-firstname";	
				public String addLName	= "newaddr-lastname";	
				public String addCompany = "newaddr-company";
				public String addPhone="input#newaddr-phone";
				public String addAddress1	= "newaddr-addr1";
				public String addAddress2	= "newaddr-addr2";
				public String addNewCountry = "div.field.field-name.drpdown.required > select#newaddrCountry";
				public String addNewCountryOption = "div.field.field-name.drpdown.required > select#newaddrCountry > option";
				public String addNewCountryBfr = "div.field.field-name.drpdown.required > select#newaddrCountry > option:nth-child(";
				public String addNewPostcode = "input#newaddr-postc2";
				public String addCountry = "select#country";
				public String addCountryOpt	= "select#country > option";
				public String addCity	= "newaddr-city";
				public String addState	= "select#newaddrState";
				public String addStateTxtField= "input#optnewaddrState";
				public String addStateOpt	= "select#newaddrState > option";
				public String addPostCode	= "postc";
				public String address1 ="123 Main";
				public String address2 ="St.Spencer";
				public String countryUS ="United States";
				public String StateUS ="Utah";
				public String postCode = "01562";
				public String city= "Midvale";
				public String address1_uk ="Buckingham Palace";
				public String address2_uk ="Buckingham";
				public String country_uk ="United Kingdom";
				public String State_uk ="London";
				public String phoneNumber="1234567890";
				public String address1_eu ="Áras an Uachtaráin";
				public String address2_eu ="Phoenix Park";
				public String country_eu ="Ireland";
				public String State_eu ="Dublin";
				public String city_eu= "Dublin 8";
				public String postCode_eu = "D08E1W3";
				
				
				
				public String postCode_uk = "SW1A 1AA";
				public String city_uk= "London";
				public String continueInAddress= "button#stepper2setup";
				public String fNmaeError= "#newaddr-firstname-error";
				public String lNmaeError= "#newaddr-lastname-error";
				public String add1Error="#newaddr-addr1-error";
				public String lftTabs = "div.content.account-nav-content > ul > li > a";
				
				public String prodReviewTitle= "div#test-l-3 > div.form-group.serrialnumbertab.serrialnumbertabdivdate > h5";
				public String prodReviewTitleText="Product Review";
				public String regAddress = "div#revi > strong";
				public String regAddressText ="Registered Address";
				public String serialno = "div#serialno > strong";
				public String serialnoText = "Serial Number";
				public String retrivedserialno = "div#serialno > div#serial";
				public String getAddress = "div#tabreview";
				public String backToAddBtn= "//div[@class='form-group serrialnumbertabbtn']//button[@id='stepper3setuppre']"; 
				public String backToRegBtn= "stepper2setuppre"; 
				public String backToRegHomeBtn= "stepper1setuppre";
				public String privacyLabel= "div.gdpr-consent-container > div#amprivacy-checkbox > label";
				public String privacyChkBox= "div.gdpr-consent-container > div#amprivacy-checkbox > input#amgdpr_agree";
				public String regBtn=  "//button[@id='stepper3setup']";                //"//*[@id='stepper3setup']";             // "//button[@class='btn btn-lg btn-dark login primary']";
				public String productSuccess = "div.textmsgsuccess > p";
				public String productSuccessMsg = "You have successfully registered your product!";
				public String productAlrdSuccessMsg = "You have successfully registered your product already !";
				public String recentReg= "Recently Registered";
				public String recentRegister = "div.recently-registered-container.block > div > strong";
				public String prodDate ="div.owl-item.active:nth-child(1)> div.item > div.product-info > p:nth-child(1)";             //"div.owl-stage > div.owl-item.active > div.itemsdashboard > div.textdiv  > p:nth-child(1)";
				public String warrent = "div.itemsdashboard > div > select";
				public String warrentOption = "div.itemsdashboard > div > select > option";
				public String sideList= "div#account-nav > ul > li > a";
				public String addressList="div.block-content > ol.items.addresses > li";
				public String addressListOpt="div.block-content > ol.items.addresses > li:nth-child(";
				public String addressListOptAfter = ") > div.item.actions > a:nth-child(2)";
				public String popMsg="//div[1]/div[contains(text(),'Are you sure you want to delete this address?')]";              //"div.modal-content > div:nth-child(1)";
				public String addressDelOkBtn="//footer[@class='modal-footer']//button[2] /span";//"button.action-primary.action-accept > span";
				public String catTitle="div#guided-registration > div.filter-container > div.collapsibleTab > div > p.h4";
				public String catTitleText = "Select Category";
				public String catList = "//ul[@class='options']/li/span";       //ul[@class='row-display']/li/label
				public String catListBfr =  "//ul[@class='options']/li[";                                      //"//ul[@class='row-display']/li[";
				public String catListAfr ="]/span";
				public String catOptionsBfr= "//div[@class='filter-container'][";
				public String catOptionsAfr= "]/div[@class='collapsibleContent']/ul/li";
				public String catOptionsMid= "]/div[@class='collapsibleContent']/ul/li[";
				public String noOfProd= "//div[@class='owl-stage-outer']/div/div[starts-with(@class,'owl-item')]/div[@class='item product product-item']";
				
				public String productBfr="div.owl-stage-outer > div > div[class^='owl-item']:nth-child(";                     //"//div[starts-with (@class, 'owl-item')][";
				public String productAft=") > div > div > div > div.product.name.product-item-name > strong";     //"]//div[@class='product name product-item-name']/strong";
				public String prodBtn= ") > div > div > div > button";         //"]//div[@class='product details product-item-details']/button";
				public String productActiveBfr="div.owl-stage-outer > div > div.owl-item.active:nth-child("; 
				
				public String confMsg="#attribute-selection > div.message > div > p"; //"#attribute-selection > div.collapsibleTab > div.textmsgsuccess > p";
				public String confMsgText= "You have successfully registered your product!";
				public String wrConfMsg= "Warranty Replacement order placed successfully!";
				public String backToDashLnk = "div.page-wrapper > div.breadcrumbs > ul > li > a";
				public String myDasbTitle = "My Dashboard";
					
				public String catListRadioAfr ="]/input";
				public String accordianList = "//div[@class='filter-container']/div[starts-with(@class, 'collapsibleTab')]//p";
				public String cateEditLnk= "//*[@id='element']/div[1]/div[2]";
				public String itemListSP = "//div[@class='owl-stage-outer']/div/div[@class='owl-item active']/div[@class='item productitms']/div[@class='caption']";
		    	public String itemListBfrSP= "//div[@class='owl-stage-outer']/div/div[@class='owl-item active'][";
				
				public String itemList = "//div[@class='owl-stage-outer']/div/div[@class='owl-item'][@style='visibility: visible; display: block; height: auto; width: 416.667px;']/div[@class='item productitms']/div[@class='caption']";
				
				//public String itemList = "//div[@class='owl-stage-outer']/div/div[@class='owl-item'][@style='visibility: visible; display: block; height: auto; width: 416.667px;']/div[@class='item productitms']/div[@class='caption']";
				public String itemListBfr= "//div[@class='owl-stage-outer']/div/div[@class='owl-item'][@style='visibility: visible; display: block; height: auto; width: 416.667px;'][";
				public String disPop = "//div[@id='ltkpopup-container'][@class='simpleltkmodal-container']/a[@class='modalCloseImg simpleltkmodal-close']";
				public String disPop2 = "//div[@class='simpleltkmodal-wrap']/div[@id='ltkpopup-formcontent']";
				public String attributeItemsFrstAccord= "//div[@class='collapsibleContent table_product_registration'][@aria-hidden='false']/ul/li/label";
				public String attributeItemsFrstBfr= "//div[@class='collapsibleContent table_product_registration'][@aria-hidden='false']/ul/li[";
				public String attributeItemsAfr= "]/label";
				public String attributeRadioAfr= "]/input";
				public String attributeItems= "//div[@class='collapsibleContent table_product_registration'][@aria-hidden='true'][@style='display: block;']/ul/li/label";
				public String productLineItems= "//div[@class='collapsibleContent table_product_registration'][@aria-hidden='true'][@style='display: block;']/ul/li[@style='display: block;']/label";
				public String attributeItemsBfr= "//div[@class='collapsibleContent table_product_registration'][@aria-hidden='true'][@style='display: block;']/ul/li[";
				public String attributeProductItemBfr= "//div[@class='collapsibleContent table_product_registration'][@aria-hidden='true'][@style='display: block;']/ul/li[@style='display: block;'][";
				public String catContinueBtn= "button.myaction.btn.btn-lg.btn-dark > span";
				
				public String [] DeviceTypeAccordion= {"Select Category","Select Device Type", "Select Brand","Select Device","Select Product Line", "Select Product"};
				public String [] brandAccoridon= {"Select Category","Select Brand","Select Device","Select Product Line", "Select Product"};
				public String [] productLineAccordion= {"Select Category","Select Product Line", "Select Product"};
				public String [] deviceAccoridon= {"Select Category","Select Device","Select Product Line", "Select Product"};
				
				
				public String [] audioAccordion= {"Registration: Product Line (Headphones)","Purchase Date"};
				public String [] speakersAccordion= {"Registration: Product Line (Speakers)","Purchase Date"};
				public String [] cablesAndAdaptersAccordion = {"Registration: Product Line (Cables)","Purchase Date"};
				public String [] portablePowerAccordion = {"Registration: Product Line (Portable Batteries)","Purchase Date"};
				
				
				
				
				//public String 
				//                        ADMIN ACCESS
				public String closeIncommingMsg = "aside.modal-popup.modal-system-messages._show > div.modal-inner-wrap >header > button > span";
				public String incomming= "div.modal-inner-wrap > header > h1#modal-title-2";
				public String leftTabs = "ul#nav > li > a > span";
				public String productTab= "li.item-catalog-attributes-attributes.level-2 > a > span";
				public String productTitle ="div.page-title-wrapper > h1.page-title";
				
				public String catalogProductTab = "li.item-catalog-products.level-2 > a >span";
				
				public String attributeCodeField= "//*[@id='attributeGrid_filter_attribute_code']";
				public String attTable="table#attributeGrid_table > tbody > tr > td:nth-child(1)";
				public String searchBtn = "button.action-default.scalable.action-secondary >span";
				public String manageOptionsTitle= "#product_attribute_tabs_main_content > fieldset:nth-child(4) > legend > span";
				public String manageOptionsTitleText= "Manage Options (Values of Your Attribute)";
				public String allOptions="#manage-options-panel > table > tbody > tr > td:nth-child(3) > input";
				public String allOptionsBfr="#manage-options-panel > table > tbody > tr:nth-child(";
				public String allOptionsAft=") > td:nth-child(3) > input";
				public String setterNamed="option";
				public String backArrow ="div.page-actions-buttons > button#back > span";
				public String noOfProdField= "div.col-xs-9 > div.admin__data-grid-pager-wrap > div > div.selectmenu-value > input";
				
				public String productList= "tbody > tr > td:nth-child(4) > div";
				public String productListBfr= "tbody > tr:nth-child(";
				public String productListAfr= ")> td:nth-child(4) > div";
				public String leftTabsInProdItem = "div.entry-edit.form-inline > div.fieldset-wrapper > div.fieldset-wrapper-title > strong > span";
				public String leftTabsBfr = "div.entry-edit.form-inline > div.fieldset-wrapper:nth-child(";	
				public String leftTabsAfr = ") > div.fieldset-wrapper-title > strong > span";
				public String categoryOption = "fieldset.admin__fieldset > div.admin__field:nth-child(1) > div.admin__field-control > select.admin__control-select > option";
				public String optSelecCategory =categoryOption+ ":nth-child(";
				public String brandOption = "fieldset.admin__fieldset > div.admin__field:nth-child(2) > div.admin__field-control > select.admin__control-select > option";
				public String optSelecBrand =brandOption+ ":nth-child(";
				public String deviceOptions= "select.admin__control-multiselect > option";
				public String optSelectDevice = deviceOptions+":nth-child(";
				public String prodSave = "div.page-actions-buttons > div > button#save-button";
				public String saveSuccess = "div.message message-success success > div";
				public String successMsg= "You saved the product.";
				public String salesOrder= "li.item-sales-operation.parent.level-1 > div > ul > li.item-sales-order.level-2 > a > span";
				public String ordIdList = "#container > div > div.admin__data-grid-wrap > table > tbody > tr > td:nth-child(2) > div";
				public String ordIdBfr= "#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(";
				public String ordIdAfr=") > td:nth-child(2) > div";
				public String ordStatusAfr=") > td:nth-child(9) > div";
				public String ordIdTabs= "div.page-actions-buttons > button > span";
				public String shipSubmit ="div.order-history-comments-actions.actions > button > span";
				public String msgShip="#messages > div > div > div";
				public String msgShipText= "The shipment has been created.";
				public String invoiceSubmit ="div.actions > button > span";
				public String msgInvoiceText= "The invoice has been created.";
				public String prodRtn= "section:nth-child(3) > div:nth-child(2) > form > div:nth-child(1) > span:nth-child(2)";
				public String prodRtnSubmit= "#form-submit";
				public String ordSearch = "div.data-grid-search-control-wrap:nth-child(2) > input";
				public String ordSearchIcon= "div.data-grid-search-control-wrap:nth-child(2) > button";
				public String shippingCodeGen = "//li[@class='item-base  parent  level-1']//li[@class='item-shippingcoupon    level-2']/a/span";
				public String shippingCodeGenTitle = "Ship Code Generator";
				public String addNewShipCodeBtn= "div.page-actions-buttons > button#add > span";
				public String codeGenerator = "input#item_generate";
				public String codePrice= "input#item_price";
				public String codeEmail="input#item_email";
				public String codeGenField="input#item_code";
				public String codeSave="button#save > span > span";
				public String codeAddNewText= "Add New Ship Code";
				
				
				
				
				public String catBatteryCases = "Battery Cases";
				public String catCablesAdapters="Cables, Adapters & Accessories";
				public String catCases = "Cases";
				public String catHeadPhones= "Headphones";
				public String catKeyboard = "Keyboards";
				public String catPortablePower = "Portable Power";
				public String catReplacement="Replacement Parts";
				public String catSpeakers = "Speakers";		
				public String catScreenProt = "Screen Protection";
				public String catWireless = "Wireless Docks";
				
				public String catOther = "Other";		
				
				public String prodDeviceTypeCode= "reg_product_device_type";
				public String prodBrandCode= "reg_product_brand";
				public String prodDeviceAllCode= "devices_all";
				public String prodProductLineScreenCode= "reg_product_line_screen";
				public String prodBatteryCasesCode= "reg_product_line_cases";
				public String back2RegBtn= "button.btn.btn-lg.login.primary";
				public String serialNoVerified="//*[@id='test-l-1']/div[1]/p/span"; //"div#test-l-1 > div > p > span > img";
				public String serialNoText = "  "+serialNumber  +" verified!";
				public String serialNo2ndVerified="//*[@id='test-l-1']/div[1]/p/span"; 
				public String allCustomers = "li.item-customer-manage.level-1 > a > span";
				public String custQuickSearch = "li.item-customer-quicksearch.level-1 > a > span";				
				public String customerRows = "table > tbody > tr > td:nth-child(4) > div";
				public String emailBfr = "table > tbody > tr:nth-child(";
				public String emailAft= ") > td:nth-child(4) > div";
				public String editAft= ") > td.data-grid-actions-cell > a";
				public String loginAsCustomerTab= "//div[@class='page-actions-buttons']/button[@id='amastyLoginAsCustomer']/span";//"div.page-actions-buttons > button#amastyLoginAsCustomer > span";
				public String filter = "#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-filters-actions-wrap > div > button";
				public String filterFieldTitle= "div.admin__form-field > label > span";
				public String filterFieldTitleBfr= "div.admin__form-field:nth-child(";
				public String filterFieldTitleAfr= ") > label > span";
				public String fliterFieldTextAft=") > div > input";
				
				public String filterFName= "div.admin__form-field:nth-child(2) > div  > input";
				public String filterLName= "div.admin__form-field:nth-child(3) > div  > input";
				public String filterEmail= "div.admin__form-field:nth-child(4) > div  > input";
				public String filterApply= "div.admin__footer-main-actions > button.action-secondary > span";
				public String adProdReg = "PRODUCT REGISTRATION";
				public String adProdRegMang ="ul > li.item-add-row.level-2 > a > span";
				public String admPRFilters= "fieldset.admin__fieldset.admin__data-grid-filters > div.admin__form-field > div > input";
				public String admPrFilteBfr="fieldset.admin__fieldset.admin__data-grid-filters > div.admin__form-field:nth-child(";
				public String admPRRowsBfr = "table > tbody > tr > td:nth-child(";
				public String admRowsAft= ") > div";
				public String admPRColNames = "table > thead > tr > th > span";
				public String admPRColNamesBfr = "table > thead > tr > th:nth-child(";
				public String admPRColNamesAfr =") > span";
				public String eachRowBfr= "table > tbody > tr:nth-child(";
				public String eachRowAft=") > td:nth-child(";
				
				public String prodNamed = "Product Name";
				public String custName= "Customer Name";
				public String productReg = "juice pack access";
				public String creatOrdTab= "//div[@class='page-actions-buttons']/button[@id='order']/span";
				public String createOrdText= "Create Order";
				public String storeRadio="div.admin__field.field-store_label > div.admin__field-control > div > div > input#store_3";           //"//input[@id='store_3'][@class='admin__control-radio']";
				public String addProduct="button#add_products > span";
				public String addProdBySku=  "button.action-secondary.action-add > span";
				public String prodChk = "td.col-select.col-in_products > label > input";
				public String prodListBfr = "tbody > tr:nth-child(";
				public String prodListAft = ") > td.col-select.col-in_products > label > input";
				public String idTextBox= "input#sales_order_create_search_grid_filter_entity_id";
				public String searchprod = "div.admin__filter-actions > button.action-default.scalable.action-secondary > span";
				public String sellerTitle = "Bestsellers Report";
				
				
				/************************************ Test Cases ID  **********************************************************/
				public String tc= "Tc_";
				public String tc2= "Tc_2";
				public String tc3= "Tc_3";
				public String tc4= "Tc_4";
				public String tc5= "Tc_5";
				public String tc6= "Tc_6";
				public String tc7= "Tc_7";
				
				public String batteryTcId = "Tc_2";
				public String batteryWrId= batteryTcId+4;
				public String speakersTcId = "Tc_2";
				public String speakerWRId= speakersTcId+2;
				public String powerTcId = "Tc_1";
				public String powerWRId= powerTcId+2;
				public String keyBoardTcId = "Tc_1";
				public String keyboardWRId= keyBoardTcId+3;
				public String screenTcId = "Tc_1";
				public String screenTcIdWRId= screenTcId+5;
				public String casesTcId = "Tc_1";
				public String casesWrId= casesTcId+4;
				public String wirelessWrId= tc2+2;
				
				
				/**************Product Line******/
				public String prodIemPartially =  "div.owl-carousel.owl-theme.owl-loaded > div.owl-stage-outer > div.owl-stage > div.owl-item";
				public String prodsItemsButton = prodIemPartially +"> div > button";
				public String prodsItems = prodIemPartially +"> div > div.caption";   //div.owl-carousel.owl-theme.owl-loaded.owl-drag
				public String prodItemBfr =":nth-child(";
				public String prodItemAfr= ") > div > div.caption";
				public String prodBtnAfr= ") > div > button";
				public String selectitemBtn= "div.owl-carousel.owl-theme.owl-loaded > div.owl-stage-outer > div.owl-stage > div.owl-item.active > div > button";
				public String noProducts= "//div[@class= 'collapsibleContent table_product_registration'][@style='display: block;'] //div[@id='noresult']";
				public String noProductsMessage= "No result found";
				public String modalSerialPopup = "div#popup-modal > h1";
				public String modalText= "Serial Number or Registration Code Required";
				public String modalSerialField= "input#serialnumber";
				public String popupContinue= "div.modal-inner-wrap > footer > button.serialValidateBtn > span";
				public String alertMsg = "div > span#errorcode";
				public String alertMsgText= "Resultant SKU doesnt match with selected product SKU";
				public String subTitlePopup = "#popup-mpdal > div.modaldesc";
				public String subTitlePopupText = "This item requires a serial number or registration code to complete the registration process.";
				public String fieldName= "#popup-mpdal > label";
				public String fieldNameText= "Serial Number or Registration Code";
				public String dateIcon= "div[class^=datepurchaseddate] > div > img.ui-datepicker-trigger";
				public String dateOpened="//a[@class='ui-state-default ui-state-active']";             //"//tbody//tr/td[@data-handler='selectDay'][@data-event='click']/a[@class= 'ui-state-default ui-state-active']";
				public String openedDate="td.ui-datepicker-current-day > a.ui-state-default.ui-state-active"; 
				public String dateFieldLabel= "div.collapsibleContent.table_product_registration > div > label";
				public String dateFieldText= "Date Item Was Purchased";
				public String addTitle = "div#test-l-2 > div.form-group.serrialnumbertab.serrialnumbertabdivdate > p.h5";
				public String addTitleText ="Select or Enter Your Address";
				public String courselArrow ="div.collapsibleContent > div > div > div.owl-controls > div.owl-nav > div[class^=owl-next]";
				public String courselArrowBack ="div.collapsibleContent > div > div > div.owl-controls > div.owl-nav > div[class^=owl-prev]";
				
				/***************************Property Files Name ***********************************************/
				public String deviceType= "device_types";
				public String brand= "brand_product";
				public String devicesAll= "devices_all";
				public String screenProtectionProducts= "prod_screenProtection";
				public String batteryCasesProducts= "prod_batteryCases";
				public String warrantReasons = "WRReasons";
				
				
				
				
				
			/****************************************            WARRANT REPLACEMENT                  ***********************************************/
				public String[] audioReasons= {"Select a reason for replacement","Button concern","Sound quality","Charging concern", "Pairing concern","Physical damage", "Other (please specify)"};
				public String[] screenProtReasons= {"Select a reason for replacement","Cracked","Chipped","Fell off","Bubbles","Installation Concern","Other (please specify)"};
				public String[] powerReasons= {"Select a reason for replacement","Not receiving a charge / power","Not providing charge / power","Wireless charging concern","Fit / finish concern", "Physical damage","Other (please specify)"};
				public String[] keyboardReasons= {"Select a reason for replacement","Button / key concern","Charging / power concern","Pairing concern","Fit / finish concern","Physical damage","Other (please specify)"};
				public String keyboardReason= "Button / key concern";
				public String screenProtReason= "Bubbles";
				public String powerReason="Not receiving a charge / power";
				public String prodName= "div.owl-stage-outer > div > div > div > div.product-info > p > strong";   ///"div.item.itemsdashboard > div.textdiv > p > strong";
				public String prodNameBfr= "div.owl-stage-outer > div > div:nth-child(";
				public String prodNameAfr= ") > div > div.product-info > p > strong";
				public String replaceOpt= ") > div > div > select";
				public String options= replaceOpt+" > option";
				public String rsnTextBx = "input#otherInput";
				public String rsnContinue = "stepper1setup";
				public String chkStatus = "div#checkout-progress > ul > li > span:nth-child(2)";
				public String rsnSelect= "select#reasonSelect";
				public String rsnOptions = rsnSelect+ " > option";
				public String optresnBfr= rsnOptions+":nth-child(";
				public String reasonTitle= "#step1 > div:nth-child(1) > p > strong";
				public String reasonTitleText= "Reason for Replacement";
				public String reasonOptionalTitle= "#step1 > div:nth-child(2) > p > strong";
				public String reasonOptionalTitleText= "Optional: In-Store Replacement";
				
				public String rsnHelp = "#step1 > div > div > div.reason > div.input-group.other-reason > label";		
				public String rsnHelpText= "Help Us Understand What's up";
				public String rsnHelpHolderText= "eg. Vision guard burns my eyes";
				public String rsnCont = "//button[@class='btn btn-lg btn-dark reason-btn']";
				public String rsnContBfr ="CONTINUE";
				public String rsnContAfr ="CONTINUE WITH REPLACEMENT";
				public String rsnSubTitle1 = "div.reason > p:nth-child(1) > small";
				public String rsnSubTitle2 = "div.reason > p:nth-child(2) > small";
				public String rsnSubTitleText1= "To help our product team, please answer this question:";
				public String rsnSubTitleText2= "What is your reason for requesting a replacement today?";
				public String optSubTitle1 = "div.border-box.rounded-corners > p:nth-child(1) > small";
				public String optSubTitle2 = "div.border-box.rounded-corners > p:nth-child(3) > small";
				public String optSubTex1 = "Did you know you can get a replacement at participating franchise locations?*";
				public String optSubTex2 = "*small replacement & installation fee may apply, limited to popular inventory (older devices might not be supported-please call ahead)";
				public String fndStore= "button.btn.btn-lg.btn-dark.mt-10.mb-5";
				public String fndStoreText= "FIND A STORE";
				public String revTitles= "//*[@id='step2']//p/strong";
				public String revTitle = "Product Review";
				public String paySummry = "Payment Summary";
				public String upgrade ="Upgrade your replacement or continue below.";                       //"Want to upgrade your replacement?";
				public String subTotal= "div.totals-info > p:nth-child(1)> span";             //"div.wrtotalcalucate.textright > p:nth-child(1)";
				public String tax= "div.totals-info > p:nth-child(3)> span";
				public String shipping= "div.totals-info > p:nth-child(2)> span";
				public String total = "p.total > strong > span";
				public String shippingAddTitle = "div.checkout-block-first > div.step-title";	
				public String shippingMtdTtile ="div.checkout-block-second > div.step-title";            //"div > div.checkout-block-second > h1 > div";
				public String paymentMtdTtile= "div.items.payment-methods > div > div.step-title";
				
				public String noPaymentMtdTtile= "#checkout-payment-method-load > div";
				public String shipCode= "span#block-discount-heading > label > span";
				public String shipCodeChk="span#block-discount-heading > label > input";                    //"div.payment-option-title.field.choice > input[type='checkbox']";
				public String shipCodeLabel= "I have a shipping code";
				public String shipCodeText= "input#shipping-code";
				public String codeApply= "button.action.action-apply > span >span";
				public String codeReq="div#shipping-code-error";
				public String codeError ="div.message.error > div";
				public String codeErrorMsg="Please specify a shipping method.";
				
				
				public String contInOptReveiw  = "button#submitStep2";
				public String billAddTitle = "div.payment-method-billing-address > label > span";
				public String sameBillAdd = "div.billing-address-same-as-shipping-block > label > span";
				public String billAddTitleText = "Billing Address";
				public String sameBillAddText= "My billing and shipping address are the same";
				public String prodCost = "div.product-info > p:nth-child(2)";
				public String paySumSubTotal = "div.totals:nth-child(1) > div.amount > span";
				public String paySumShipping = "div.totals:nth-child(2) > div.amount > span";
				public String paySumTax = "div.totals:nth-child(3) > div.amount > span";
				public String paySumTotal ="div.grand.totals > div.amount > strong > span";
				public String upgradeSection= "div#step2 > div.upgrade > p > strong";
				public String upgradeProdBtn= "//div[@class='product details product-item-details']//button[@class='btnprod btn btn-sm btn-outline-black full-width']";
				public String amazonRadio= "input#amazonlogin";
				public String amzonPayIcon= "div#PayWithAmazon > img";
				public String amzonEmail = "input#ap_email";
				public String amzonPassword = "input#ap_password";
				
				
				
				
				public String ccNumber= "4111111111111111";
				public String cvvText= "123";
				public String shipAddress= "SHIPPING ADDRESS";
				public String shipText= "SHIPPING METHOD";
				public String paymentText= "PAYMENT INFORMATION";
				public String noPayText= "No Payment Methods";
				public String discntError= "#discount-code-error";
				public String errorDiscount= "This is a required field";
				public String shipMthdList = "div.checkout-shipping-method-list > div";
				public String shipMthdListBfr = "div.checkout-shipping-method-list > div:nth-child(";
				public String shipMthdListAfr = ") > div.shipping-method-name > h5";
				public String shippingRadio= ") > div.shipping-method-radio > input";
				public String ccFrame = "#checkout-payment-method-load > div > div > div.checkout-block";
				public String ccRadio= "div.payment-method-title.field.choice > input#chcybersource";
				public String ccLabel= "div.payment-method-title.field.choice > label > span";
				public String ccText= "#payment_form_chcybersource > div.field.number.required > div > input";
				public String cvvNumber = "#chcybersource_cc_type_cvv_div > div >input";
				public String month= "#chcybersource_expiration > option";
				public String monthDP= "#chcybersource_expiration";
				public String year= "#chcybersource_expiration_yr > option";
				public String yearDP= "#chcybersource_expiration_yr";
				public String termsInCheckoutChk= "#agreement_chcybersource_4";
				public String wrPolicy= "div.checkout-agreement.required > p.wptextcheck > input#review-checkbox";
				public String completeOrderBtn= "#stepper4setup";
				public String ccLabelWR= "div.field.number.required > label > span > span";
				public String termsInWR = "div.warranty-agreement > input#warranty_agree_1";
				public String placeOrder= "div.actions-toolbar > div  > button.action.primary.checkout > span";
				public String placOrderText = "Place Order";
				public String termsInWRTitle = "div.warranty-agreement > label";
				public String termsText= "I understand that I may have to provide proof of purchase, and returning my original product will validate my warranty.\n" + 
						"I also agree to the Warranty Policy and Sales Terms, and I accept and acknowledge that my credit card will be charged the full retail value of the replacement product if I fail to return the original product within 60 days of this request.";
				public String noShipping= "div.checkout-shipping-method > div#checkout-step-shipping_method > div.no-quotes-block > span";
				public String noShippingText= "One or more of the items in your cart can not ship to this location. Please contact us for assistance or choose an alternate Shipping address.";
				public String wrTitle= "Warranty Replacement";
				
				
				/**********                Account General                        *****/
				
				public String acountInfo = "div.block.block-dashboard-info > div.block-title > strong";
				public String myDash = "Account Dashboard";
				public String accountInfoTitle= "Account Information";
				public String addressbookTitle= "Address Book";
				public String addressbook = "div.block.block-dashboard-addresses > div.block-title > strong";
				public String accName= "div.block.block-dashboard-info > div.block-content strong:nth-child(1)";
				public String accEmail= "div.block.block-dashboard-info > div.block-content strong:nth-child(3)";
				public String rrProdList = "div.owl-stage-outer > div > div > div > div.textdiv > p > strong";
				public String rrProdListBfr = "div.owl-stage-outer > div > div:nth-child(";
				public String rrProdListAfr = ") > div > div.textdiv > p > strong";
				public String nextArrow = "div.recently-registered-products > div > div.owl-controls > div.owl-nav > div.owl-next";
				public String wrFirstOrdId = "div.orders > div:nth-child(1) > ul > li.col.id > a";
				
				
				/*******************   Registered Products        *******************/
				public String pageLimiter = "select#limiter";
				public String pageLimiterOptions = "select#limiter > option";
				public String pageLimiterOptionsMid = ":nthchild(";
				
			
				public String regProductList="//div[@class='recently-registered-products']//div[@class='item itemsdashboard itemsdashboarditems ']/div[@class='product-info']/p/strong";
				
				//public String regProductList_old = "//div[@class='recently-registered-products']//div[contains(@class,'owl-item')]//div[@class='product-info']/p/strong";  
				public String regProductWarntOpt = "]/div[@class='action-block']/div/select/option[2]";
				public String regProductListBfr ="//div[@class='recently-registered-products']//div[@class='item itemsdashboard itemsdashboarditems ']["; 
				public String regProductListAfr ="]//div[@class='product-info']/p/strong";
				public String regProductWarntOpt_old = "]/div[@class='action-block']/p/span/span";
				public String regProductNoOpt = "]/div[@class='action-block']/p/span/a";
				public String regProductTitle ="Registered Products";
				public String regTooltipInfo="]//div[@class='action-block']/p/span/span";
				public String regExpiredText = "Your warranty has expired for this product.";
				public String regOutOfStock = "This product is currently out of stock.";
				public String regOutOfStockContCustCare= "This product is not available for replacement. For assistance, please contact Customer Care.";
				public String regOrderComplete="Order must be completed before item can be replaced.";
				public String regMustComplete = "Original product must be returned before this product can be replaced.";
				
				
				/*******       Shopping                      ********/
				public String shopTab= "div.header.content > ul > li:nth-child(1) > a";
				public String shopList = "div.by-device.grid-container > div.link-list.apple > ul > li:nth-child(2) > a";
				public String productItem ="//li[2]//div[@class= 'product details-box']/div/a/strong";                  //"#amasty-shopby-product-list > div > ol:nth-child(3) > li:nth-child(1) > div > div > div.product-item-inner > div > div";
				public String addToCart = "button#product-addtocart-button > span.icon.icon-cart.icon-reverse";
				public String checkoutBtn= "button#top-cart-btn-checkout";
				public String ratingWidget= "a._hj-f5b2a1eb-9b07_widget_open_close._hj-f5b2a1eb-9b07_action_toggle_widget > span";
				public String paceOrderBtn="button.action.primary.checkout > span"; //"//*[@id='checkout-payment-method-load']//div[@class='actions-toolbar']/div[@class='primary']/button[@class='action primary checkout']/span";
				public String orderNumber = "//div[@class='success-messages']/p/a/strong";
				public String orderSuccessTilte = "//div[@class='checkout-success']/div[@class='step-title']";
				public String defSubtotal = "div.subtotal > div.amount > span.price";
				public String defShippingl = "div.shipping > div.amount > span.price";
				public String defTax = "div.tax > div.amount > span.price";
				public String defGrandTotal = "div.grand_total > div.amount > strong > span.price";
				public String orderList = "#my-orders > div.orders > div > ul > li.col.id > a";
				public String orderBfr = "#my-orders > div.orders > div:nth-child(";
				public String orderAft = ") > ul > li.col.id > a";
				public String ordStatus = ") > ul > li.col.status";
				public String back2Order = "div.secondary > a.action.back >span";
				public String userFName= "#shipping-new-address-form > div:nth-child(1) > div > input";
				public String userLName= "#shipping-new-address-form > div:nth-child(2) > div > input";
				public String userSTAddress = "#shipping-new-address-form > fieldset > div > div.field._required > div >input";
				public String userCity= "#shipping-new-address-form > div:nth-child(4) > div > input";
				public String userZipCode= "#shipping-new-address-form > div:nth-child(8) > div > input";
				public String userState= "#shipping-new-address-form > div:nth-child(6) > div > div  >select";
				public String userStateOpt= "select > option";
				public String userFirstName = "newUser"+TestBase.generateRandomNumberInRange(1, 100);
				public String userLastName = "test"+TestBase.generateRandomNumberInRange(1, 10);;
				public String usercity= "Lake Michigan";
		        public String userStatePlace ="Chicago";
		        public String useraddress1 ="305 LAKE";
		        public String userZip="51243";
		        public String userEmail= "#customer-email-fieldset > div > div > input";
		        public String userEmailId= userFirstName+"@gmail.com";
		        public String shopAgree= "div.checkout-agreements-block > div > div.checkout-agreements > div.checkout-agreement.required > input";
		        public String pricvacyPolChkBx= "div.checkout-agreements-block > div > div.amasty-gdpr-consent > input";                  //input[@id='amgdpr_agree_2']";  amasty-gdpr-consent
		        public String amzonPayBtn = "div.amazon-button-container > div > div#PayWithAmazon_amazon-pay-button";
		        public String sugg= "header.modal-header > h1";
		        public String allowCookies= "button#btn-cookie-allow";
		        public String gogAddTitle= "aside.modal-popup.iwd-address-validation-popup._show > div.modal-inner-wrap > header > h1";
		        public String gogAddRadio= "aside.modal-popup.iwd-address-validation-popup._show > div.modal-inner-wrap > div#modal-content-14  > div > ul > li >input";	
		        public String gogAddLabel= "aside.modal-popup.iwd-address-validation-popup._show > div.modal-inner-wrap > div#modal-content-14  > div > ul > li >label";
		        public String gogContBtn="aside.modal-popup.iwd-address-validation-popup._show > div.modal-inner-wrap > footer > button > span";
		        
		        
		        /*********       Purchase History               **********************/	
		        public String purOrderNum= "div.order-info-wrapper > div.order-number > p > strong";
		        public String purGrandTotal = "div.amount > strong > span";
		        public String purOrderStatus= "div.order-title > p:nth-child(2)";
		        public String purShippingType= "div.box.box-order-shipping > div.box-content > p";
		        public String regColumns = "//div[@id='my-orders']//ul/li";
		        public String phTitle= "Purchase History";
		        public String ItemsInPage = "div.pager > p > span";
		        public String limiter = "select#limiter";
		        public String limiterOptions = "select#limiter > option";
		        
		        /************     NewsLetter Subscriptions      ******************/
		       public String newsSubTitle = "Newsletter Subscriptions";
		       public String newsFrame= "ltkPrefCenter";
		       public String subtitle= "//div[@class='row ltk-clearfix']/h1";
		       public String emailSubtitle= "//div[@class='row ltk-clearfix']/label";
		       public String emailAdd = "//div[@class='grid row ltk-clearfix']/div[@class='col-1']/div[@class='col-1-2 end']/input[@id='email-field']";
		       public String newsFirstName = "//div[@class='grid row ltk-clearfix']/div[@class='col-1'][2]/div[@class='col-1-2 end']/input[@id='first-name-field']";
		       public String newsDOBMonth ="select.build-date";                       //"//div[@class='grid row ltk-clearfix']/div[@class='col-1'][2]/div[@class='col-1-2 col-1-2-mobile']";
		       public String newsDOBMonthOption ="select.build-date > option";  
		       public String newsDOBDay= "//div[@class='col-1-2 col-1-2-mobile'][2]//select[@class='build-date']";
		       public String newsDOBDayOption= "//div[@class='col-1-2 col-1-2-mobile'][2]//select[@class='build-date']/option";
		       public String newsType="//div[@class='grid row ltk-clearfix'][2]/div[@class='col-1-3'][";
		       public String newsTypeAfter = "]//input";
		       public String newsTypeLabel="//div[@class='grid row ltk-clearfix'][2]/div[@class='col-1-3']//label/span";
		       public String newsUpdate= "//div[@class='row ltk-clearfix'][4]/input";
		       public String newsSavedTitle = "//div[@class='ltk-pref-content ltk-clearfix']//h1";
		       public String newsSavedInfo="//div[@class='row center ltk-clearfix']//h2";
		       public String newsBack2Prefer="//div[@class='row center ltk-clearfix'][2]//a";
		       public String newsSaveInfoText="Your preferences have been saved.";
		       public String backToPreferText= "BACK TO PREFERENCES";
		       public String emailTitleText= "Address Email & Personal Information";
		       public String newsHearAbt= "//div[@class='row ltk-clearfix'][3]/label";
		       public String newsHearAbtText= "What Do You Want to Hear About?";
		       public String newsTypeSection="//div[@class='grid row ltk-clearfix'][2]/div/label";
		       public String newsTypeText = "Type:" ;
		       public String newsCategorySection="//div[@class='grid row ltk-clearfix'][3]/div/label";
		       public String newsCategoryText="Categories:";
		       public String newsBrandSection="//div[@class='grid row ltk-clearfix'][4]/div/label";
		       public String newsBrandText= "Brand:";
		       public String categoriesList="//div[@class='grid row ltk-clearfix'][3]//div[@class='col-1-3']/div[@class='option checkbox ltk-clearfix']/label/span";
		       public String categoriesListBfr="//div[@class='grid row ltk-clearfix'][3]//div[@class='col-1-3'][";
		       public String categoriesListAfr= "]/div[@class='option checkbox ltk-clearfix']/label/span";
		       public String brandList="//div[@class='grid row ltk-clearfix'][4]//div[@class='col-1-3']/div[@class='option checkbox ltk-clearfix']/label/span/img";
		       

}
