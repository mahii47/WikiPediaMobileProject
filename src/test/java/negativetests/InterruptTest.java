package negativetests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.RegressionBaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.WaitUtil;

public class InterruptTest  extends RegressionBaseTest{
	
	 By languageMenuIcon = By.xpath("//android.widget.TextView[@content-desc=\"Language\"]");
//	 By retrybutton = Retry;
//	 By language = Marathi;
	 
	 	private WaitUtil waitUtil;
	 
		
	 
	  @Test(priority=0)
	    public void turnOnInternetInterruption() throws Exception {
		  
	        System.out.println("=== INTERRUPT TEST: MOBILE DATA STARTED ===");

	        Thread.sleep(3000);

	        // Turn OFF Mobile Data
	        System.out.println("Turning Mobile Data OFF...");
	        Runtime.getRuntime().exec("adb shell svc data disable");
	        Thread.sleep(5000);
	        System.out.println("Mobile Data is now OFF.");

	        // Add any step here (scroll article / click section) to show the impact in video
	  }
	  
	  @Test(priority=1)
	  public void InternetInterruption()
	  {
		  MobileElement iconLanguage = driver.findElement(languageMenuIcon);
				  //waitUtil.waitForClickable(languageMenuIcon);
		  iconLanguage.click();
	  }
	  
	   
	  
	  @Test(priority = 2)
	    public void turnOffInternetInterruption() throws Exception
	    {
	        Thread.sleep(4000);

	        // Turn ON Mobile Data
	        System.out.println("Turning Mobile Data ON...");
	        Runtime.getRuntime().exec("adb shell svc data enable");
	        Thread.sleep(6000);
	        System.out.println("Mobile Data is now ON.");

	        System.out.println("=== INTERRUPT TEST COMPLETED ===");
	  }
}
