package zagg.accountGeneral;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.lib.TestBase;


public class AccountGeneralMethods extends TestBase{
	
	SoftAssert softAssert = new SoftAssert();	
	int total;
	
	
	public void accountDashboard() throws Exception {
		logInfo("Enter into accountDashborad() method");
		nav2AccountDashboard(USACountry);
		selectSideBarItems("Address Book");
		selectSideBarItems("Account Dashboard");
		
	}
	
	
	/**Validate the title of Screen **/
	public void validateTitlScreen(String screenTitle) throws Exception {
		logInfo("Entered into validateTitlScreen() method");
		Thread.sleep(2000);
		wdWait("cssSelector", productTitle);
		String actTitle = driver().findElement(By.cssSelector(productTitle)).getText().trim();				
		Assert.assertEquals(actTitle, screenTitle);	
		
	}
	
	/**Validate account Information on Dashboard screen at bottom
	 * @throws Exception ***/
	public void accountInfoOnDashboard() throws Exception {
		logInfo("Entered into accountInfoOnDashboard() method");
		String account = getText("cssSelector", acountInfo);
		softAssert.assertEquals(account, accountInfoTitle);
		String accountName = getText("cssSelector", accName);
		System.out.println("accountName "+ accountName);
		
		
	
		softAssert.assertAll();
		
	}
	
	/**Validate Address book Information on Dashboard screen at bottom
	 * @throws Exception ***/
	public void addressBookOnDashboard() throws Exception {
		logInfo("Entered into addressBookOnDashboard() method");
		String address = getText("cssSelector", addressbook);		
		softAssert.assertEquals(address, addressbookTitle);		
		
		
		
		softAssert.assertAll();
		
	}
	
	
	/** Delete all existing address from Address Book**/
	public void handleAddress() throws Exception {
		logInfo("Entered into handleAddress() method");
		wdWait("cssSelector", addressList);
		List<WebElement> countAddress = driver.findElements(org.openqa.selenium.By.cssSelector(addressList));
		int count = countAddress.size();
		System.out.println(count);
		for(int i=count ;i>=1;i--) {
			WebElement dele = driver.findElement(By.cssSelector(addressListOpt+i+addressListOptAfter));
			scrollDown("cssSelector", addressListOpt+i+addressListOptAfter);
			 
			dele.click();
			//implicityWaits(30);
			Thread.sleep(3000);
		   	clickOnButton("xpath", addressDelOkBtn);			
		}	
		
	}
	
	
	/**********  Registered Products     *****/	
	
	/**  Select pagelimter to 100 products to display.     
	 * @throws Exception */
	public void showProdItemsPerPage() throws Exception {
		logInfo("Entered into showProdItemsPerPage() method");
		waitOnSpinner();		
		String curUrl = driver.getCurrentUrl();
		
		driver.navigate().to(curUrl+"index/?limit=100");
		driver.navigate().to(curUrl+"index/?limit=100");
		scrollDown("cssSelector", ratingWidget);
		clickOnObject("cssSelector", ratingWidget);
		waitOnLoadingSpinner(3);	
	}
	
	
	public void paginationOfRegisteredProd() throws Exception {
		logInfo("Entered into paginationOfRegisteredProd() method");
		String items = getText("cssSelector", ItemsInPage);
		String[] split = StringUtils.split(items, " ");
		total= Integer.parseInt(split[5]);
		System.out.println("total "+total);
		selectItemsPerPageInRegProd(total,6);
		selectItemsPerPageInRegProd(total,12);
		selectItemsPerPageInRegProd(total,18);	
		selectItemsPerPageInRegProd(total,24);
		selectItemsPerPageInRegProd(total,50);
		selectItemsPerPageInRegProd(total,100);
	}
	
	
	public void selectItemsPerPageInRegProd(int totalItems, int expPerPage ) throws Exception {
		logInfo("Entered into selectItemsPerPageInRegProd() method");
		scrollDown("cssSelector", pageLimiter);
		clickOnObject("cssSelector", pageLimiter);
		List<WebElement> opt = driver.findElements(By.cssSelector(pageLimiterOptions));
		for(WebElement option: opt) {
			String showItems = option.getText().trim();
			String size= Integer.toString(expPerPage);
			System.out.println(showItems);
			if(showItems.equalsIgnoreCase(size)) {
				option.click();
				waitOnSpinner();
				System.out.println("totalItems "+totalItems);
				if(totalItems >= expPerPage) {
					System.out.println("entered into "+size);
					List<WebElement> orders = driver.findElements(By.xpath(regProductList));
					int ordersSize = orders.size();
					waitOnSpinner();
					if(ordersSize==expPerPage) {
						System.out.println("No of items are matched with count");
						break;
						
					}else {
						Assert.assertEquals(ordersSize, expPerPage);
					}	
					
				}
			}
		}	
		
	}
	
	 
	/****** Select the product for Warranty Replacement**/
	
	public void selectWarrentForProduct(String expProduct) throws Exception {
		logInfo("Entered into selectWarrentForProduct() method");
		waitOnSpinner();
		boolean isPresent=false;
		List<WebElement> items = driver.findElements(By.xpath(regProductList));
		for(int i=1;i<=items.size();i++) {
			String productName= driver.findElement(By.xpath(regProductListBfr+i+regProductListAfr)).getText().trim();			
			if(productName.equalsIgnoreCase(expProduct)) {
				isPresent=true;
				System.out.println("Matched productName "+ productName);
				List<WebElement>wrOpt= driver.findElements(By.xpath(regProductListBfr+i+regProductWarntOpt));
				int size= wrOpt.size();
				if(size==0) {
					String noOption= driver.findElement(By.xpath(regProductListBfr+i+regProductNoOpt)).getText().trim();
					Assert.assertEquals(noOption, "No Options");					
				}else {
					clickOnObject("cssSelector", ratingWidget);
					scrollDown("xpath", regProductListBfr+i+regProductWarntOpt);
					WebElement opt= driver.findElement(By.xpath(regProductListBfr+i+regProductWarntOpt));
					opt.click();
					Thread.sleep(5000);
				}break;				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProduct + " is not yet Registered");
		}
		
	}
	
	
	/**********  Purchase History    *****/	
	public void verifyColumnName() {
		logInfo("Entered into verifyColumnName() method");
		List<WebElement> col = driver.findElements(By.xpath(regColumns));
		for(WebElement columns :col) {
			String name = columns.getText().trim();
			
			switch(name) {			
			case "Date":				
				break;
			case "Order #":				
				break;
			case "Order Total":				
				break;				
			case "Status":				
				break;
			case "Tracking":				
				break;
				default:
					Assert.assertNotNull(name);
			
			}			
		}		
	}
	
	/****Retrive no of items and validates the items based on selected show count
	 * @throws Exception **/
	public void paginationOfPuchaseHistory() throws Exception {
		logInfo("Entered into paginationOfPuchaseHistory() method");
		String items = getText("cssSelector", ItemsInPage);
		System.out.println(items);
		String[] split = StringUtils.split(items, " ");
		total= Integer.parseInt(split[5]);
		System.out.println(total);	
		selectItemsPerPage(total,50);
		selectItemsPerPage(total,20);
		selectItemsPerPage(total,10);	
	}
	
	
	public void selectItemsPerPage(int totalItems, int expPerPage ) throws Exception {
		logInfo("Entered into selectItemsPerPage() method");
		scrollDown("cssSelector", pageLimiter);
		clickOnObject("cssSelector", pageLimiter);
		List<WebElement> opt = driver.findElements(By.cssSelector(pageLimiterOptions));
		for(WebElement option: opt) {
			String name = option.getText().trim();
			String size= Integer.toString(expPerPage);
			if(name.equalsIgnoreCase(size)) {
				option.click();
				waitOnSpinner();	
				System.out.println(totalItems+" totalItems");
				if(totalItems >= expPerPage) {
					System.out.println("entered into "+size);
					List<WebElement> orders = driver.findElements(By.cssSelector(orderList));
					int ordersSize = orders.size();
					if(ordersSize==expPerPage) {
						System.out.println("No of items are matched with count");
						break;
						
					}else {
						Assert.assertEquals(ordersSize, expPerPage);
					}	
					
				}
			}
		}	
		
	}
	
	public void switchToNewsSubscrip() {
		logInfo("Enter into switchToNewsSubscrip() method");		
		driver.switchTo().frame(newsFrame);
		
	}
	
	
	public void verifyLabels() throws Exception {
		logInfo("Enter into personalInfo() method");		
		String email= driver.findElement(org.openqa.selenium.By.xpath(subtitle)).getText();
		Assert.assertEquals(email, newsSubTitle);
		WebElement emailAddress= driver.findElement(org.openqa.selenium.By.xpath(emailSubtitle));
		String abt= getText("xpath", newsHearAbt);
		Assert.assertEquals(abt, newsHearAbtText);
		String expType= getText("xpath",newsTypeSection);
		Assert.assertEquals(expType, newsTypeText);
		String expCat= getText("xpath",newsCategorySection);
		Assert.assertEquals(expCat, newsCategoryText);
		String expBrand = getText("xpath",newsBrandSection);		
		Assert.assertEquals(expBrand, newsBrandText);
		
	}
	
	public void personalInfo() throws Exception {
		logInfo("Enter into personalInfo() method");
		clearText("xpath", emailAdd);
		clearText("xpath", newsFirstName);
		enterText("xpath", emailAdd, mailId );
		enterText("xpath", newsFirstName, lastName );
		clickOnObject("cssSelector", newsDOBMonth);
		List <WebElement> monthSize= driver.findElements(org.openqa.selenium.By.cssSelector(newsDOBMonthOption));	
		for (WebElement month : monthSize) {
			String monthName = month.getText().trim();
			if(monthName.equalsIgnoreCase("May")) {
				month.click();
				break;
			}
		  }
		clickOnObject("xpath", newsDOBDay);
		List <WebElement> daySize= driver.findElements(org.openqa.selenium.By.xpath(newsDOBDayOption));
		for(WebElement days:daySize) {
			if(days.getText().equalsIgnoreCase("4")) {
				days.click();
				break;
			}
		}		
	}
	
	/***Select type of checkbox from "What do you want to hear" section **/
	public void typeOfSubscription() {
		logInfo("Enter into typeOfSubscription() method");
		List<WebElement> types = driver.findElements(By.xpath(newsTypeLabel));
		for(WebElement type :types) {
			String typeName = type.getText().trim();			
			switch(typeName) {
			case "Sales & Promotions":
				System.out.println(typeName + " is present");
				break;
			case "Product Launches":
				System.out.println(typeName + " is present");
				type.click();
				break;
			case "News":
				System.out.println(typeName + " is present");
				break;	
			default:
				System.err.println(typeName+ " should not present");
				Assert.assertNull(typeName);
			}
		}
				
	}
	
	public void typesOfCategories() {
		logInfo("Enter into typesOfCategories() method");
		List<WebElement> cat= driver.findElements(By.xpath(categoriesList));
		for(WebElement categ:cat) {
			String categoryName= categ.getText().trim();
			switch(categoryName) {
			case "Battery Cases":
				break;
			case "Cables, Adapters & Accessories":
				break;
			case "Cases":
				break;
			case "Headphones":
				break;
			case "Keyboards":
				break;
			case "Portable Power":
				break;
			case "Replacement Parts":
				break;
			case "Speakers":
				break;
			case "Screen Protection":
				break;
			case "Wireless Docks":
				break;
			default:
				System.err.println(categoryName+ " should not present");
				Assert.assertNull(categoryName);			
			}			
		}	
	}
	
	public void selectCategory() throws Exception {
		logInfo("Enter into selectCategory() method");		
		int i = TestBase.generateRandomNumberInRange(1, 3);
		scrollDown("xpath", categoriesList);
		WebElement category = driver.findElement(By.xpath(categoriesListBfr+i+categoriesListAfr));
		category.click();
		
	}
	
	
	public void selectBrand() throws Exception {
		logInfo("Enter into typesOfbrand() method");
		scrollDown("xpath", brandList);
		List<WebElement> cat= driver.findElements(By.xpath(brandList));
		if(cat.size()==6) {
			for(WebElement categ:cat) {
				String brandName= categ.getText().trim();
				System.out.println(brandName+ " brand");
				categ.click();
			}			
		}else {
			Assert.assertEquals(cat.size(), 6);
		}
	}
	
	public void selectUpdateSubscrip() throws Exception {
		logInfo("Enter into selectUpdateSubscrip() method");
		scrollDown("xpath", newsUpdate);
		wdWait("xpath", newsUpdate);
		WebElement button = driver.findElement(By.xpath(newsUpdate));		
		clickOnObject("xpath", newsUpdate);		
	}
	
	public void confirmAndBackToPerference() throws Exception {
		logInfo("Enter into confirmAndBackToPerference() method");
		String infoTopText = getText("xpath", newsSavedTitle);
		System.out.println(infoTopText);
		Assert.assertEquals(infoTopText, newsSubTitle);
		String infoSavedText = getText("xpath", newsSavedInfo);
		System.out.println(infoSavedText);
		Assert.assertEquals(infoSavedText, newsSaveInfoText);		
		String backPreferText = getText("xpath", newsBack2Prefer);
		System.out.println(backPreferText);
		Assert.assertEquals(backPreferText, backToPreferText);
		clickOnObject("xpath", newsBack2Prefer);
		
	}
	
	
	
}
