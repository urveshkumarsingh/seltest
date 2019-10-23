package zagg.prodRegistration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PRToolTipsMethod extends ProductRegistartionMethods{
	
	
	/**  Select pagelimter to 6 products to display.     
	 * @throws Exception */
	public void showProdItemsPerPage() throws Exception {
		logInfo("Entered into showProdItemsPerPage() method");
		wdWait("cssSelector", pageLimiter);
		scrollDown("cssSelector", ratingWidget);
		clickOnObject("cssSelector", ratingWidget);
		String curUrl = driver.getCurrentUrl();		
		driver.navigate().to(curUrl+"index/?limit=100");
		scrollDown("cssSelector", ratingWidget);
		clickOnObject("cssSelector", ratingWidget);
		waitOnLoadingSpinner(3);	
	}
	
	
/****** Select the product , if the product status as No option and then find the tool tip of that product **/	
	public void getToolTipOfProduct(String expProduct, String toolTipMsg) throws Exception {
		logInfo("Entered into getToolTipOfProduct() method");
		waitOnSpinner();
		boolean isPresent=false;
		List<WebElement> items = driver.findElements(By.xpath(regProductList));
		for(int i=1;i<=items.size();i++) {
			String productName= driver.findElement(By.xpath(regProductListBfr+i+regProductListAfr)).getText().trim();			
			if(productName.equalsIgnoreCase(expProduct)) {
				isPresent=true;
				List<WebElement>wrOpt= driver.findElements(By.xpath(regProductListBfr+i+regProductNoOpt));
				int size= wrOpt.size();
				System.out.println("Size is "+size);
				if(size==1) {
					WebElement noOpt= driver.findElement(By.xpath(regProductListBfr+i+regProductNoOpt));
					String noOption= noOpt.getText().trim();
					System.out.println("noOption == "+noOption);
					Assert.assertEquals(noOption, "No Options");
					noOpt.click();
					wdWait("xpath", regProductListBfr+i+regTooltipInfo);					
					String acttoolTip= driver.findElement(By.xpath(regProductListBfr+i+regTooltipInfo)).getText().trim();
					System.out.println(acttoolTip + " tool");
					Assert.assertEquals(acttoolTip, toolTipMsg);
					
				}else {
					clickOnObject("cssSelector", ratingWidget);
					scrollDown("xpath", regProductListBfr+i+regProductWarntOpt);
					String  opt= driver.findElement(By.xpath(regProductListBfr+i+regProductWarntOpt)).getText().trim();
					Assert.assertEquals(opt, "No Options");				
				}break;				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProduct + " is not yet Registered");
		}
		
	}
	
	public void toolTipMessage() {
		logInfo("Entered into toolTipMessage() method");
		
		
		
	}
	

}
