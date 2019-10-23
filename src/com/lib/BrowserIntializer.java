package com.lib;

import java.net.MalformedURLException;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

public class BrowserIntializer extends ExtentReportNG{
	
	  public static WebDriver driver;
	  public static ExtentReports extent;
	  public DesiredCapabilities capabilities;
	  
	  @Parameters({ "browser", "appUrl" })
	  @BeforeTest

	  public WebDriver openBrowser(String browser, String appUrl) throws MalformedURLException {
		  // launch the specified browser
		  
		  String os = System.getProperty("os.name").toLowerCase();

		    try {
		      if (browser.equalsIgnoreCase("firefox")) {
		    	  System.setProperty("webdriver.gecko.driver",gecko_driver_linux);
		    	FirefoxProfile fprofile = new FirefoxProfile();
		        fprofile.setAcceptUntrustedCertificates(true); 
		        fprofile.setAssumeUntrustedCertificateIssuer(false);
		       
		      
		        // Pass fprofile parameter In webdriver to use preferences to download
		        // file.
		        driver = new FirefoxDriver(fprofile);
		       

		      } else if (browser.equalsIgnoreCase("chrome")) {
		        System.setProperty("webdriver.chrome.driver", chrome_driver);
		        driver = new ChromeDriver();
		        
		      } else if (browser.equalsIgnoreCase("safari")){
		    	  driver = new SafariDriver();
		    	  
		      
		      
		    }else if (browser.equalsIgnoreCase("ie")) {
		        System.setProperty("webdriver.ie.driver", ie_driver);
		        driver = new InternetExplorerDriver();
		        
		      }
		      driver.manage().window().maximize();
		      driver.get(appUrl);
		      return driver;
		      
		      
		    } catch (Exception e) {
		      e.getMessage();
		    }
		    return driver;	  
		  
	  }
	  
	  public static WebDriver driver() {
		    return driver;
		  }
	  
	

}
