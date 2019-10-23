package zagg.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.lib.TestBase;

import zagg.warrantReplacement.WarrantReplacementMethods;

public class AdminMethods extends WarrantReplacementMethods{
	
	/*******     Once select Product Registation in leftside nav, selects PR Manager tab.  ******/
	public void nav2PRInAdmin() throws Exception {
		logInfo("Entered into nav2PRInAdmin() method.");
		wdWait("cssSelector", adProdRegMang);
		clickOnObject("cssSelector", adProdRegMang);
		waitOnSpinner();
	}
	
	/*** Admin - Select filter button to expand**/
	public void adminSelectFilter() throws Exception {
		logInfo("Entered into adminSelectFilter() method.");
		Thread.sleep(4000);
		wdWait("cssSelector", filter);
		String fil = getText("cssSelector", filter);
		System.out.println("fil "+fil);
		clickOnObject("cssSelector", filter);
		wdWait("cssSelector", filterApply);
		String apply = getText("cssSelector", filterApply);
		Assert.assertEquals(apply, "Apply Filters");
		
		
	}
	
	
	public void clearAllFilters() throws Exception {
		logInfo("Entered into adminSelectFilter() method.");
		List<WebElement> fields = driver.findElements(By.cssSelector(admPRFilters));		
		for(WebElement fied : fields) {
			fied.clear();
		}
		wdWait("cssSelector", filterApply);
		clickOnButton("cssSelector", filterApply);
		waitOnSpinner();
	}
	
	public void filterItemsWith(String field, String inputData) throws Exception {
		logInfo("Entered into adminSelectFilter() method.");
		List<WebElement> fields = driver.findElements(By.cssSelector(admPRFilters));
		boolean isFieldPresent=false;
		for(int i=5;i<=fields.size()+4;i++) {
			WebElement fieldNam= driver.findElement(By.cssSelector(admPrFilteBfr+i+filterFieldTitleAfr));
			String fieldName= fieldNam.getText().trim();					
			if(fieldName.equalsIgnoreCase(field)) {
				isFieldPresent=true;
				WebElement fn= driver.findElement(By.cssSelector(admPrFilteBfr+i+fliterFieldTextAft));
				clearText("cssSelector", filterFieldTitleBfr+i+fliterFieldTextAft);
				fn.sendKeys(inputData);
				fn.click();
				wdWait("cssSelector", filterApply);
				clickOnButton("cssSelector", filterApply);
				Thread.sleep(3000);
				break;
			}
			
			
		}if (!isFieldPresent){
			Assert.assertTrue(isFieldPresent ,field+ " is not present in filter section" );
		}
		
	}
	
	
	
	/**Edit Customers based on passed email.
	 * @throws Exception **/
	public void verifyDataFromColumns(String label, String requiredData) throws Exception {
		logInfo("Entered into verifyDataFromColumns() method.");
		wdWait("cssSelector", admPRColNames);
		boolean isPresent=false;
		List<WebElement> rows = driver.findElements(By.cssSelector(admPRColNames));
		int noOfRows = rows.size();
		System.out.println("noOfColumns "+noOfRows);
		for (int i=2;i<=noOfRows;i++) {
			String col= driver.findElement(By.cssSelector(admPRColNamesBfr+i+admPRColNamesAfr)).getText().trim();
			System.out.println("col "+col);
			if(col.equalsIgnoreCase(label)) {
				isPresent=true;
				boolean dataPresent=true;
				List <WebElement> dataRow = driver.findElements(By.cssSelector(admPRRowsBfr+i+admRowsAft));
				int size = dataRow.size();
				System.out.println("No of rows "+ size);
				for(int j=1;j<=size;j++){
					WebElement eachData = driver.findElement(By.cssSelector(eachRowBfr+j+eachRowAft+i+admRowsAft));
					String data = eachData.getText().trim();					
					if(!(data.equalsIgnoreCase(requiredData))) {
						dataPresent=false;
						System.out.println("wrong "+data);
						Assert.assertTrue(dataPresent, data + " is not sorted as per expected");
					}
				waitOnSpinner();
					
				}
				
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, label + " column is not present");
		}			
	}
	
	
	public void createOrder() throws Exception {
		logInfo("Entered into createOrder() method.");
		Thread.sleep(3000);
		String actCreOrder = getText("xpath", creatOrdTab);
		Assert.assertEquals(actCreOrder, createOrdText);
		clickOnObject("xpath", creatOrdTab);
		waitOnSpinner();
	}
	
	
	public void selectStore() throws Exception {
		logInfo("Entered into selectStore() method.");
		Thread.sleep(5000);
		wdWait("cssSelector", storeRadio);	
		clickOnObject("cssSelector", storeRadio);
		Thread.sleep(5000);
		waitOnSpinner();
		int maxSize = driver.findElements(By.cssSelector(addProduct)).size();
		System.out.println("Size is maxSize "+maxSize);
		if(maxSize==0) {
		driver.navigate().refresh();
		waitOnSpinner();
		clickOnObject("xpath", storeRadio);
		Thread.sleep(5000);
		System.out.println("refresed");
			}	
		wdWait("cssSelector", addProduct);
		String prod = getText("cssSelector", addProduct);
		System.out.println(prod);
		Assert.assertEquals(prod, "Add Products");
		
	}
	
	/***********Create Order - Add product in User ********/
	public void addProducts(String idValue) throws Exception {
		logInfo("Entered into addProducts() method.");
		wdWait("cssSelector", addProduct);
		WebElement addPro= driver.findElement(By.cssSelector(addProduct));
		addPro.click();
		Thread.sleep(2000);
		enterText("cssSelector", idTextBox, idValue);
		List<WebElement> btns = driver.findElements(By.cssSelector(searchprod));		
		for(WebElement btn :btns) {
			String btnName= btn.getText().trim();
			System.out.println(btnName);
			if(btnName.equalsIgnoreCase("Search")) {
				btn.click();
				break;
			}
		}
		
		
		
		submitObject("cssSelector", idTextBox);
		submitObject("cssSelector", idTextBox);

		WebElement chk= driver.findElement(By.cssSelector(prodListBfr+1+prodListAft));
		chk.click();
		
		}
	
	

}
