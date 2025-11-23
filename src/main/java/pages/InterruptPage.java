package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import utils.WaitUtil;

public class InterruptPage {
	
	    private AndroidDriver<MobileElement> driver;
	    private WaitUtil waitUtil;

	    public InterruptPage(AndroidDriver<MobileElement> driver) {
	        this.driver = driver;
	        this.waitUtil = new WaitUtil(driver);
	    }
	     By languageMenuIcon = By.xpath("//android.widget.TextView[@content-desc=\"Language\"]");
		
	     @Step("Turning OFF Internet (Mobile Data Disable)")
		    public void turnOffInternetInterruption() throws Exception {
				  
		        System.out.println("=== INTERRUPT TEST: MOBILE DATA STARTED ===");


		        // Turn OFF Mobile Data
		        System.out.println("Turning Mobile Data OFF...");
		        Runtime.getRuntime().exec("adb shell svc data disable");
		        Thread.sleep(5000);
		        System.out.println("Mobile Data is now OFF.");
		  }
	     @Step("Opening Language menu (Internet OFF scenario)")
		    public void InternetInterruption()
			  {
				  MobileElement iconLanguage = waitUtil.waitForClickable(languageMenuIcon);
				  iconLanguage.click();
				  retryButton();
			  }
	     @Step("Turning ON Internet (Mobile Data Enable)")
		    public void turnOnnInternetInterruption() throws Exception
		    {
		        Thread.sleep(4000);

		        // Turn ON Mobile Data
		        System.out.println("Turning Mobile Data ON...");
		        Runtime.getRuntime().exec("adb shell svc data enable");
		        Thread.sleep(6000);
		        System.out.println("Mobile Data is now ON.");

		        System.out.println("=== INTERRUPT TEST COMPLETED ===");
		  }
	     @Step("Selecting Language after Internet Reconnected")
		    public void languageSelection() throws InterruptedException
			  {
				  retryButton();
				  tapLanguageOption();
			  }
	     @Step("Clicking Retry button")
			  public void retryButton()
			  {
				  new TouchAction(driver)
			        .tap(PointOption.point(540,1501))
			        .perform();
				  System.out.println("Retry button clicked!!");

			  }
	     @Step("Selecting language option from list")
			  public void tapLanguageOption() throws InterruptedException {
				    new TouchAction(driver)
				            .tap(PointOption.point(540, 1365))
				            .perform();
				    System.out.println("Langauge clicked!!");
				    Thread.sleep(15000);
				}

}
