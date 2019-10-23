package com.lib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase extends BrowserIntializer{
protected static final Log logger = LogFactory.getLog(TestBase.class);
    
	WebElement element, toElement;
	WebDriverWait wait;
	String By;
	ExtentTest test;
	JavascriptExecutor js;		
	
	
	private static Properties configProp = new Properties();
	private static String propFilePath;
	private static File file;
	private static FileInputStream fileInput;
	public static String key;
	public static String value;
	public static String[] dataValue;
	public static String[] keyValue;
	
	
	/*webdriver waits for given Seconds*/
	public void implicityWaits(int i ) throws Exception{
	logInfo("Entered into implicityWaits method");
		driver().manage().timeouts().implicitlyWait(i,TimeUnit.SECONDS);
		}
	
	
	// This method is used to get the current date.
	
		public static String getDate(int period,String format){
		     Calendar currentDate = Calendar.getInstance();
		     SimpleDateFormat formatter= new SimpleDateFormat(format);
		     currentDate.add(Calendar.DAY_OF_MONTH, period);
		     String date = formatter.format(currentDate.getTime());
		     return date;
		}
	
	
	/**validates the page title 
	 * @throws Exception **/
	public void validateHomeTitle(String expTitle) throws Exception {
		waitOnSpinner();
		wdWait("cssSelector", newAccTitle);
		String actTitle = driver().findElement(org.openqa.selenium.By.cssSelector(newAccTitle)).getText();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, expTitle);
		wdWait("cssSelector", allowCookies);
		clickOnObject("cssSelector", allowCookies);
		waitOnSpinner();
	}
	
	
	/**validates the page title 
	 * @throws Exception **/
	public void validatePRTitle(String expTitle) throws Exception {
		wdWait("cssSelector", PRTitle);
		String actTitle = driver().findElement(org.openqa.selenium.By.cssSelector(PRTitle)).getText();
		Assert.assertEquals(actTitle, expTitle);
	}
	
		
		
		// This method is used to Wait for a element to present.		
		public void wdWait(String Bytype,String locator) throws Exception{			
			try{
				
				WebDriverWait wait = new WebDriverWait(driver,5);						   			   		 
				switch(Bytype){
				case "xpath":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByXPath.xpath(locator)));
					break;
				case "id":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ById.id(locator)));
					break;
				case "className":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClassName.className(locator)));
					break;
				case "cssSelector":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByCssSelector.cssSelector(locator)));
					break;
				case "linkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLinkText.linkText(locator)));
					break;
				case "partialLinkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByPartialLinkText.partialLinkText(locator)));
					break;
				default :
					System.out.println("Invalid type passed to waitOnElement.");
					break;
				}				
				if(element.isDisplayed()){
	            	logInfo(element.getText() + " element is present");            	
	            }
			}
			catch(Exception e){
				logInfo("Failed!! Unable to wait on this element " + locator);		
			}
			
		}	
		
		
		// This method is used to Wait for a element to present.		
		public void wdWait_original(String Bytype,String locator) throws Exception{			
			try{
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver())
					 .withTimeout(15, TimeUnit.SECONDS)
		    		 .pollingEvery(2, TimeUnit.SECONDS);		   			   		 
				switch(Bytype){
				case "xpath":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByXPath.xpath(locator)));
					break;
				case "id":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ById.id(locator)));
					break;
				case "className":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClassName.className(locator)));
					break;
				case "cssSelector":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByCssSelector.cssSelector(locator)));
					break;
				case "linkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLinkText.linkText(locator)));
					break;
				case "partialLinkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByPartialLinkText.partialLinkText(locator)));
					break;
				default :
					System.out.println("Invalid type passed to waitOnElement.");
					break;
				}				
				if(element.isDisplayed()){
	            	logInfo(element.getText() + " element is present");            	
	            }
			}
			catch(Exception e){
				logInfo("Failed!! Unable to wait on this element " + locator);		
			}
			
		}	

	
	// This method is used to Maximize the browser window.	
	public void maximizeBrowser() throws Exception{		
		try{	
			driver().manage().window().maximize();
		}
		catch(Exception e){
			logInfo("Failed!! unable to maximize the browser window");		
		}
	}
	
	
	// This method is used to Wait for a element to present.		
			public void waitOnLoadingSpinner(int InSeconds) throws Exception{						
				WebDriverWait wait = new WebDriverWait(driver(), InSeconds);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(ByXPath.xpath("//div[@class='loading-mask'][@style='display: block;']//img")));
			}
	
	// This method is used to configure the log4j.xml file and can send the logging information to that file.
	public void logInfo(Object message) {
		try{	
			Logger Log = Logger.getLogger(Logger.class.getName());
			DOMConfigurator.configure("log4j.xml");
		    Log.info(message);
		}
		catch(Exception e){
			logInfo("Failed!! unable to log the information.");		
		}
		
 	} 		

	// This method is used to perform click operation on a specific element.			
	public void clickOnObject(String Bytype, String locator) {		
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));				
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			case "linkText":
				element = driver().findElement(ByLinkText.linkText(locator));
				break;
			default :
				System.out.println("Invalid type passed to clickOnElement."+locator);
				break;
			}
			if(element.isDisplayed() && element.isEnabled()){
				element.click();
			}
			   
		}
		catch(Exception e){
			logInfo("Failed!! Unable to click on an element."+locator);		
		}
		
	}
	
	// This method is used to submit an element.	
	public void submitObject(String Bytype, String locator) {		
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			case "linkText":
				element = driver().findElement(ByLinkText.linkText(locator));
				break;
			default :
				System.out.println("Invalid type passed to submitElement."+locator);
				break;
			}
			if(element.isDisplayed() && element.isEnabled()){
				element.submit();
			}
			   
		}
		catch(Exception e){
			logInfo("Failed!! Unable to submit the element."+locator);		
		}		
	}
	

	// To Get Text of WebElement	
	public String getText(String Bytype, String locator) throws Exception{	
		String acctText = null;			
			try{
				switch(Bytype){			
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to getText."+locator);
				break;
			}				
			acctText =element.getText().trim();	
			}catch(Exception e){
				logInfo("Failed!! Unable to retrive the element."+locator);		
			}
			return acctText;
									
		}	
	
	
	// To Get Text of WebElement	
		public String getAttribute(String Bytype, String locator, String valueOrPlaceholder) throws Exception{	
			String acctAtrribute = null;			
				switch(Bytype){
				case "xpath":
					element = driver().findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver().findElement(ById.id(locator));
					break;
				case "name":
					element = driver().findElement(ByName.name(locator));
					break;
				case "className":
					element = driver().findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver().findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}				
					if(valueOrPlaceholder=="placeholder") {
						acctAtrribute =element.getAttribute("placeholder").trim();							
					}else if(valueOrPlaceholder=="value"){
						acctAtrribute= element.getAttribute("value").trim();
						
					}else {
						System.err.println("You have passed invalid Attribute");
						
					}	return acctAtrribute;				
										
			}	

	
	
	//SoftAssetrs
	
	public void softAssert(String actualValue, String expectedValue) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualValue, expectedValue);	
	}
	
	// To Get attribute of WebElement	
	public String verifyTextPresent(String Bytype, String locator, String expValue) throws Exception{	
		String acctText = null;			
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to getText."+locator);
				break;
			}				
			if(element.isDisplayed() && element.isEnabled()){
				acctText = element.getText().trim();
				System.out.println(acctText);
				Assert.assertEquals(acctText, expValue);					
			}		
		return acctText;
	}
	
	// To tabbing out from the field	
		public void tabbingOut(String Bytype, String locator) throws Exception{	
			
				switch(Bytype){
				case "xpath":
					element = driver().findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver().findElement(ById.id(locator));
					break;
				case "name":
					element = driver().findElement(ByName.name(locator));
					break;
				case "className":
					element = driver().findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver().findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}
				element.sendKeys(Keys.TAB);				
		}
	
	// To Get attribute of WebElement	
	public String verifyAttribute(String Bytype, String locator, String attribute, String expAttbValue) throws Exception{	
		String acctAttrb = null;			
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to getText."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				acctAttrb = element.getAttribute(attribute).trim();				
				Assert.assertEquals(acctAttrb, expAttbValue);				
			}		
		return acctAttrb;
	}
	
	// This method is used to select either a radio buttons or check boxes  and wont click if it is already selected.
	public void selectRadioOrCheckbox(String Bytype, String locator) throws Exception{	
		try{
			switch(Bytype){
			case "xpath":
				element = driver.findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver.findElement(ById.id(locator));
				break;
			case "name":
				element = driver.findElement(ByName.name(locator));
				break;
			case "className":
				element = driver.findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver.findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to selectRadioOrCheckbox."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				if(!element.isSelected()){
					element.click();
		}}}
		catch(Exception e){
			logInfo("Failed!! Unable to select the specified option" + locator);		
		}
	}	

	// This method is used to verify if the specified element is present on the DOM page.	
	public boolean verifyElementPresent(String Bytype,String locator) throws InterruptedException{
		boolean isElementPresent = false;
		try{
			switch(Bytype){
			case "xpath":
				element = (new WebDriverWait(driver(), 20)).until(ExpectedConditions.visibilityOfElementLocated(ByXPath.xpath(locator)));
				break;
			case "id":
				element = (new WebDriverWait(driver(), 20)).until(ExpectedConditions.visibilityOfElementLocated(ById.id(locator)));
				break;
			case "name":
				element = (new WebDriverWait(driver(), 20)).until(ExpectedConditions.visibilityOfElementLocated(ByName.name(locator)));
				break;
			case "className":
				element = (new WebDriverWait(driver(), 20)).until(ExpectedConditions.visibilityOfElementLocated(ByClassName.className(locator)));
				break;
			case "cssSelector":
				element = (new WebDriverWait(driver(), 20)).until(ExpectedConditions.visibilityOfElementLocated(ByCssSelector.cssSelector(locator)));
				break;
			case "linkText":
				element = (new WebDriverWait(driver(), 20)).until(ExpectedConditions.visibilityOfElementLocated(ByLinkText.linkText(locator)));
				break;
			default :
				System.out.println("Invalid type passed to verifyElementPresent."+locator);
				break;
			}
			
			if(element.isDisplayed())
				isElementPresent = true;

		}catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("specified element is not present"+locator);
	    }
		return isElementPresent;
	}
	
	// This method is used to verify if the specified link text is present on the page.	
	public boolean verifyLinkPresent(String expValue) throws Exception{	
		 boolean flag = false;
		try{
		   	List<WebElement> links = driver().findElements(ByTagName.tagName("a"));
	    	for(WebElement x : links){
	    		String actValue = x.getText();
	    		if(actValue.contains(expValue)){
	    			flag = true;
	    			break;
	    		} 
	    	}
	    	 if(flag = false){
	    		 logInfo("The link "+ expValue + " : could not be found.");
	    	 }
	    	
		}catch(Exception e) {
			logInfo("Failed!! Unable to find a link " + expValue);			
		}
		 return flag;
	}
		
   	
	// This method is used to perform click operation on the specified button.	
	public void clickOnButton(String Bytype, String locator) throws Exception{	
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to clickOnButton."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				element.click();
			}
		}
		catch(Exception e){
			logInfo("Failed!! Unable to click on a button."+locator);		
		}
		
	}

	// This method is used to double click on a specified element.	
	public void doubleClick(String Bytype, String locator ) throws Exception{
		try{
			Actions action = new Actions(driver());
			
			switch(Bytype){
			case "xpath":
				action.moveToElement(driver().findElement(ByXPath.xpath(locator))).doubleClick().build().perform();
				break;
			case "id":
				action.moveToElement(driver().findElement(ById.id(locator))).doubleClick().build().perform();
				break;
			case "name":
				action.moveToElement(driver().findElement(ByName.name(locator))).doubleClick().build().perform();
				break;
			case "className":
				action.moveToElement(driver().findElement(ByClassName.className(locator))).doubleClick().build().perform();
				break;
			case "cssSelector":
				action.moveToElement(driver().findElement(ByCssSelector.cssSelector(locator))).doubleClick().build().perform();
				break;
			case "linkText":
				action.moveToElement(driver().findElement(ByLinkText.linkText(locator))).doubleClick().build().perform();
				break;
			case "tagName":
				action.moveToElement(driver().findElement(ByTagName.tagName(locator))).doubleClick().build().perform();
				break;
			case "partialLinkText":
				action.moveToElement(driver().findElement(ByPartialLinkText.partialLinkText(locator))).doubleClick().build().perform();
				break;
			default :
				System.out.println("Invalid type passed to clickOnButton."+locator);
				break;
			}
			
		}
		catch(Exception e){
			logInfo("Failed!! To double click on " + locator);		
		}
			
	}
	
	// This method is used to click on the text area.	
	public void enterInTextArea(String Bytype, String locator, String enterTextArea) throws Exception{	
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			case "tagName":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to clickOnTextArea."+locator);
				break;
			}
			if(element.isDisplayed()){
				element.click();
				element.clear();
				element.sendKeys(enterTextArea);
			}
			
		}
		catch(Exception e){
			logInfo("Failed!! Unable to click and enter text in the text area element."+locator);		
		}
		
	}
	
	// This method is used to enter the values into a text box
	
	public void enterText(String Bytype, String locator, String value) throws Exception{	
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to inputText."+locator);
				break;
			}			
			if(element.isDisplayed() && element.isEnabled()){
				element.sendKeys(value);
			}
		}
		catch(Exception e){
			logInfo("Failed!! Unable to enter a text into a textbox."+locator);		
		}
	}
		
	// This method is used to clear text box values.	
	public void clearText(String Bytype, String locator) throws Exception{	
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to inputTextClear."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				element.clear();
			}
		}
		catch(Exception e){
			logInfo("Failed!! Unable to clear the text from a textbox."+locator);		
		}
	}

	// This method is used to select options from a drop down list. 
	
	public void selectFromDropdown(String Bytype, String locator, String selectType, String value) throws Exception{
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "tagName":
				element = driver().findElement(ByTagName.tagName(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to selectFromDropdown."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				Select select = new Select(element);
				if(selectType == "byVisibleText"){
					select.selectByVisibleText(value);
				} else if (selectType == "byValue"){
					select.selectByValue(value);
				} else if(selectType == "byIndex"){
					Integer ivalue = Integer.valueOf(value);
					select.selectByIndex(ivalue);
					
				}
			  }
		}
		catch(Exception e){
			logInfo("Failed!! Required option is not available or not select drop down list"+locator);		
		}
	}
	
	
	// This method is used to select options from a drop down list. 
	
		public String  retrieveSelectedOption(String Bytype, String locator) throws Exception{
			try{
				switch(Bytype){
				case "xpath":
					element = driver().findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver().findElement(ById.id(locator));
					break;
				case "name":
					element = driver().findElement(ByName.name(locator));
					break;
				case "tagName":
					element = driver().findElement(ByTagName.tagName(locator));
					break;
				case "className":
					element = driver().findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver().findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectFromDropdown."+locator);
					break;
				}
								
					Select select = new Select(element);
					select.getAllSelectedOptions();
						
					
				  
			}
			catch(Exception e){
				logInfo("Failed!! Required option is not available or not select drop down list"+locator);		
			}
			return value;
		}
		

	

	//This method is used to get the current selected item from drop down	
	public String getCurrentSelectionFromDropdown(String Bytype, String locator) throws Exception{
		String value = null;
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "tagName":
				element = driver().findElement(ByTagName.tagName(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to selectFromDropdown."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				Select select = new Select(element);
				value = select.getFirstSelectedOption().getText().trim();
			}
		}
		catch(Exception e){
		logInfo("Failed!! Required option is not available or not select drop down list"+locator);
		}
		return value;
	}
			
	// This method is used to select either a radio buttons or check boxes.
	
	public void deselectRadioOrCheckbox(String Bytype, String locator) throws Exception{	
		try{
			switch(Bytype){
			case "xpath":
				element = driver().findElement(ByXPath.xpath(locator));
				break;
			case "id":
				element = driver().findElement(ById.id(locator));
				break;
			case "name":
				element = driver().findElement(ByName.name(locator));
				break;
			case "className":
				element = driver().findElement(ByClassName.className(locator));
				break;
			case "cssSelector":
				element = driver().findElement(ByCssSelector.cssSelector(locator));
				break;
			default :
				System.out.println("Invalid type passed to selectRadioOrCheckbox."+locator);
				break;
			}
			
			if(element.isDisplayed() && element.isEnabled()){
				if(element.isSelected()){
				element.click();
		}}}
		catch(Exception e){
			logInfo("Failed!! Unable to select the specified option" + locator);		
		}
	}
	
    // This method is used to generate random number in s specified range.    
    public static int generateRandomNumberInRange(int min,int max){
		logger.info("Generating random number in range - "+min+","+max);
		Random r = new Random();
		int num=r.nextInt(max-min) + min;
		logger.info("Generating random number = "+num);
		return num;	
		}

		

    				
	// This method is used to wait until page being loaded.	
	public void waitForPageToLoad()
	  {
	     (new WebDriverWait(driver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
	      public Boolean apply(WebDriver d) {
	        return (((org.openqa.selenium.JavascriptExecutor) driver()).executeScript("return document.readyState").equals("complete"));
	      }
	    });
	 }
	
	
	// Validate text in the webpage.		
	public boolean validateTextPresentInPage(String Bytype, String locator, String expText){
			String value = null;
			boolean isTextFound = false;			
			try{
				switch(Bytype){
				case "xpath":
					element = driver().findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver().findElement(ById.id(locator));
					break;
				case "name":
					element = driver().findElement(ByName.name(locator));
					break;
				case "tagName":
					element = driver().findElement(ByTagName.tagName(locator));
					break;
				case "className":
					element = driver().findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver().findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectFromDropdown."+locator);
					break;
				}				
				if(element.isDisplayed() && element.isEnabled()){
					value = element.getText().trim(); 
					if(value.contains(expText)){
						logInfo(value + " match foud in the page.");
					}
				}
				
			} catch(Exception e){
				logInfo(value + " could not be in the page.");
				logger.error("Failed!! Required option is not available "+locator);		
			}
			return isTextFound;
			
		}		
		 // This method is used to scroll the screen to particular object.
		 public void scrollDown(String Bytype, String locator) throws Exception{
			 try{
				 js = (JavascriptExecutor)driver();        
				 
				switch(Bytype){
					case "xpath":
						element = driver().findElement(ByXPath.xpath(locator));
						break;
					case "id":
						element = driver().findElement(ById.id(locator));
						break;
					case "name":
						element = driver().findElement(ByName.name(locator));
						break;
					case "className":
						element = driver().findElement(ByClassName.className(locator));
						break;
					case "cssSelector":
						element = driver().findElement(ByCssSelector.cssSelector(locator));
						break;
					case "linkText":
						element = driver().findElement(ByLinkText.linkText(locator));
						break;	
					case "partialLinkText":
						element = driver().findElement(ByPartialLinkText.partialLinkText(locator));
						break;	
					default :
						System.out.println("Invalid type passed to clickOnButton."+locator);
						break;
					}
					
					if(element.isDisplayed() && element.isEnabled()){
						 js.executeScript("arguments[0].scrollIntoView(true);", element);
						 int  size = (int) js.executeScript(" return window.innerHeight;",element);
					}
				}
				catch(Exception e){
					logger.error("Failed!! Unable to find element "+locator);		
				}
		 }
		 			
		// This method is being used to accept javascript alerts / confirmations		
		public void confirmAlert(){			
			Alert alert = driver().switchTo().alert();
			alert.accept();
			}
			
			// This method is being used to dismiss javascript alerts / confirmations		
			public void dismissAlert() throws Exception{			
			Alert alert = driver().switchTo().alert();
			alert.dismiss();			
			}
			
			    
		 // This method is used to hover mouse on object.	
	  	 public void hoverOnElementAndClick(String Bytype, String locator) throws Exception{
			 try{				 
				 Actions builder = new Actions(driver());				
				switch(Bytype){
					case "xpath":
						element = driver().findElement(ByXPath.xpath(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "id":
						element = driver().findElement(ById.id(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "name":
						element = driver().findElement(ByName.name(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "className":
						element = driver().findElement(ByClassName.className(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "cssSelector":
						element = driver().findElement(ByCssSelector.cssSelector(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "linkText":
						element = driver().findElement(ByLinkText.linkText(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
					case "partialLinkText":
						element = driver().findElement(ByPartialLinkText.partialLinkText(locator));
						builder.moveToElement(element).build().perform();
						builder.click();	
					default :
						System.out.println("Invalid type passed to clickOnButton."+locator);
						break;
					}
					
			 	}
				catch(Exception e){
					logger.error("Failed!! Unable to click on a button."+locator);		
				}
		 }
	 
	 //This method is used drag and drop the webElement from location another location. 	 
	 public void dragAndDropAction(WebElement from, WebElement to) throws Exception{				
			Actions builder = new Actions(driver());
			Action drag = builder.clickAndHold(from).
					moveToElement(to).
					release(to).
					build();
			drag.perform();			
		}
	 
	 
	 /**Store Attribute or Data in passed property file **/
	 
	 public void setAttributeOptionsInProperty(String propertyFileName, String propertyName, String locatorValue) throws ConfigurationException {
			logInfo("Entered into setAttributeOptionsInProperty() method.");			
			propFilePath = projectPath + "/attributeData/" + propertyFileName + ".properties";			
			PropertiesConfiguration conf = new PropertiesConfiguration(propFilePath);
			conf.setProperty(propertyName, locatorValue);
			conf.save();			
		}
	 
	 public  String getAttributeOptionsInProperty(String propertyFileName, String propertyName)  {
		    logInfo("Entered into setAttributeOptionsInProperty() method.");
			
		    propFilePath = projectPath + "/attributeData/" + propertyFileName + ".properties";
			
			try {
				File file = new File(propFilePath);
				fileInput = new FileInputStream(file);
				configProp.load(fileInput);
				// fileInput.close();

				Enumeration enuKeys = configProp.keys();
				while (enuKeys.hasMoreElements()) {
					key = (String) enuKeys.nextElement();
					if(key.trim().equalsIgnoreCase(propertyName.trim())){
						value = configProp.getProperty(key);			
						break;
					}
				}
			
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
					return value;
		}
	 
	 
	 
	 
	 
	 
	 
	
		
		public void  nav2admin() throws Exception {
			driver().navigate().to(appUrl+"index.php/admin/catalog/product_attribute/"); 
			implicityWaits(3);
		}
		
		
		public void waitOnSpinner() throws Exception {
			 logInfo("Entered into waitOnSpinner() method");
				wdWait("xpath", "//*[@id='spinner-container'][@display='none']");
		 }
		
		public void waitOnSpinnerInPR() throws Exception {
			 logInfo("Entered into waitOnSpinnerInPR() method");
//			 WebElement spin = driver.findElement(ByXPath.xpath(custLoderSpinner));
//			 spin.getText();
			 wdWait("xpath", custLoderSpinner);
			 //System.out.println("spnnewerm "+ spin.getText());
				
		 }
		
		
		public void storeDataInProrpertyFile(String sheetName, String testCaseId) throws IOException, ConfigurationException{
			logInfo("Entered into  storeDataInProrpertyFile() method");
			//Create an object of File class to open xlsx file					
		    File file =    new File(excelFilePath);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook wbook = new HSSFWorkbook(inputStream);
		    //Read sheet inside the workbook by its name
		    Sheet zaggSheet = wbook.getSheet(sheetName);	
		    //Find number of rows in excel file		    
		    Row row = zaggSheet.getRow(0);
		    int totalRows = zaggSheet.getLastRowNum()-zaggSheet.getFirstRowNum();		   
		    int totalCoulmns = row.getLastCellNum();
		    for (int j=0;j<totalCoulmns;j++) {
		    	for(int i=0;i<=totalRows; i++) {
		    		Cell eachCell = zaggSheet.getRow(i).getCell(j);		    		
		    		String actualCell= eachCell.getStringCellValue();		    			
		    		if(actualCell.equalsIgnoreCase(testCaseId)) {		    			
 	    	 		    for(int k=1;k<totalCoulmns;k++) {
 	    	 		    	String eachOption   = zaggSheet.getRow(i).getCell(k).getStringCellValue(); 	
 	    	 		    	setAttributeOptionsInProperty(sheetName, testCaseId+k, eachOption); 
 	    	 		    	
 	    	 		    }
		    			break;
		    		}
		    		
		    	};break;
		    }
		    } 
		
		
		public int getRowsCoutFromSheet(String sheetName) throws IOException, ConfigurationException{

		    //Create an object of File class to open xlsx file			
			String excelFilePath = projectPath + "/attributeData/productDetails.xls";
		    File file =    new File(excelFilePath);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook wbook = new HSSFWorkbook(inputStream);
		    //Read sheet inside the workbook by its name
		    Sheet zaggSheet = wbook.getSheet(sheetName);	
		    //Find number of rows in excel file		    
		    Row row = zaggSheet.getRow(0);
		    int totalRows = zaggSheet.getLastRowNum()-zaggSheet.getFirstRowNum();
			return totalRows;
		   
		    } 
		
		
		
		
		public void logoutAsCustomer() throws Exception {
			logInfo("Enter into logoutAsCustomer() method");
			wdWait("cssSelector", logoutLnk);
			scrollDown("cssSelector", logoutLnk);
			List<WebElement> link = driver.findElements(ByCssSelector.cssSelector(logoutLnk));
			for (WebElement links :link) {	
				String linksName = links.getText().trim();
				if(linksName.equalsIgnoreCase("Log Out")) {
					links.click();
					handleOfferPopUp();	
					break;
					}
				}
				
		}
		
		
		public void myAccount() throws Exception {
			logInfo("Enter into logoutAsCustomer() method");
			wdWait("cssSelector", logoutLnk);
			scrollDown("cssSelector", logoutLnk);
			List<WebElement> link = driver.findElements(ByCssSelector.cssSelector(logoutLnk));
			for (WebElement links :link) {	
				String linksName = links.getText().trim();
				if(linksName.equalsIgnoreCase("My Account")) {
					links.click();
					handleOfferPopUp();
					break;
					}
				}
			
		
		}
		
		/** Navigates to home page*/
		public void homePageByCountry(String country) throws Exception {
	        logInfo("Enter into homePage method");
	        driver.navigate().to(appUrl+"en_"+country);
	        wdWait("cssSelector", allowCookies);
			clickOnObject("cssSelector", allowCookies);
	        
	        
		}
		
		
		/** Navigates to home page*/
		public void homePage() throws Exception {
	        logInfo("Enter into homePage method");
	        driver().navigate().to(appUrl);
	        
		}
		
		/** Navigates to Product Registration Screen*/
		public void nav2AccountDashboard(String country) throws Exception {
	        logInfo("Enter into nav2AccountDashboard() method");
	        driver().navigate().to(appUrl+"en_"+country+"/customer/account/");       
	        
	        
		}
		
		
		/***Select the Sidebar navigations tab 
		 * @throws Exception **/
		public void selectSideBarItems(String tabName) throws Exception {
			logInfo("Entered into selectSideBarItems() method");
			boolean isTabPresent= false;
			implicityWaits(05);
			wdWait("cssSelector", sideList);
			List <WebElement> lis = driver().findElements(ByCssSelector.cssSelector(sideList));
			for(WebElement allTabs:lis) {
				String tab= allTabs.getText().trim();				
				if(tab.equalsIgnoreCase(tabName)) {
					isTabPresent=true;
					allTabs.click();
					waitOnSpinner();
					break;
				}			
			}if(isTabPresent==false) {
				Assert.assertTrue(isTabPresent, tabName+ " - is not present");
			}
			
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
			waitOnSpinner();
		
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
					
				}
			}
		
		}
		
		
		/******   Tries to close Offer popup window****/
		
		public void handleOfferPopUp() throws InterruptedException {
			Thread.sleep(5000);
			List<WebElement> sub = driver.findElements(ByXPath.xpath(offerSubject));
			int size= sub.size();
			if(!(size==0)) {				
				clickOnObject("xpath", offerPop);
			}
			
		}
		
		
		 public static boolean waitTillSpinnerDisable(WebDriver driver, By by)
			{		
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
				fWait.withTimeout(10, TimeUnit.SECONDS);
				fWait.pollingEvery(250, TimeUnit.MILLISECONDS);
				fWait.ignoring(NoSuchElementException.class);
				
				Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() 
				{
					
					@Override
					public Boolean apply(WebDriver driver) {
						WebElement element = driver.findElement(by);
					
						System.out.println(element.getCssValue("display"));			
						
						if(element.getCssValue("display").equalsIgnoreCase("none")){
							return true;}
						
						return false;
					}
				};
				
				
				return fWait.until(func);
			}
		
		
		
	 

}