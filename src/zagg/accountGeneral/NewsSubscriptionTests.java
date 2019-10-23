package zagg.accountGeneral;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(7)
public class NewsSubscriptionTests extends AccountGeneralMethods{
	
	@Test(priority=701)
	public void newsSubcrp_ValidateLabelAndTitles() throws Exception {
		logInfo("Entered into newsSubcrp_ValidateLabelAndTitles() method");
		nav2AccountDashboard(USACountry);
		selectSideBarItems(newsSubTitle);
		switchToNewsSubscrip();
		verifyLabels();
		
			
	}
	
	@Test(priority=702)
	public void newsSubcrp_ValidateCategories() throws Exception {
		logInfo("Entered into newsSubcrp_ValidateCategories() method");
		nav2AccountDashboard(USACountry);
		selectSideBarItems(newsSubTitle);
		switchToNewsSubscrip();
		typesOfCategories();		
	}
	
	@Test(priority=703)
	public void newsSubcrp_PreferedBrand() throws Exception {
		logInfo("Entered into newsSubcrp_PreferedBrand() method");
		personalInfo();
		selectBrand();
		selectUpdateSubscrip();
		confirmAndBackToPerference();
	}
	
	@Test(priority=704)
	public void newsSubcrp_TypePreferences() throws Exception {
		logInfo("Entered into newsSubcrp_TypePreferences() method");
		nav2AccountDashboard(USACountry);
		selectSideBarItems(newsSubTitle);
		switchToNewsSubscrip();
		personalInfo();
		typeOfSubscription();
		selectUpdateSubscrip();
		confirmAndBackToPerference();
		
	}
	
	@Test(priority=705)
	public void newsSubcrp_PreferedCategory() throws Exception {
		logInfo("Entered into newsSubcrp_PreferedCategory() method");
		personalInfo();
		selectBrand();
		selectCategory();
		selectUpdateSubscrip();
		confirmAndBackToPerference();
	}
	
	
	
	

}
