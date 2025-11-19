package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.WaitUtil;

public class HomePage {
	
	private final AndroidDriver<MobileElement> driver;
	private WaitUtil waitUtil;
	
	public HomePage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	public void swipeUpToOpenAppDrawer()
	{
	  	int width = driver.manage().window().getSize().width / 2;
        int height = driver.manage().window().getSize().height;

        int startY = (int) (height * 0.90);
        int endY   = (int) (height * 0.30);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(width, startY))
              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
              .moveTo(PointOption.point(width, endY))
              .release()
              .perform();
        System.out.println("====================WIKIPEDIA AUTOMATION RUN====================\n");
        System.out.println(" HOME SCREEN");
        System.out.println("   -App drawer launched");
	}
//	public void launchApplication(String appName) throws InterruptedException
//	{
//		By exact = By.xpath("//*[@text='"+appName+"']");
//		try
//		{
//			 driver.findElement(By.id("com.android.launcher:id/branch_confirm_button")).click();
//			 System.out.println("   -Onboarding popup dismissed\n");
//		}catch(Exception e)
//		{
//			 System.out.println("'Got it' popup not displayed");
//		}
////	        driver.findElementByAndroidUIAutomator(
////	        	    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Wikipedia\")"
////	        	);
//		 try {
//		        driver.findElementByAndroidUIAutomator(
//		            "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + appName + "\")"
//		        );
//		    } catch (Exception ignore) {
//		        // SCROLL FAILS? Ignore silently
//		        // App may already be visible → not an error
//		    }
//	        
//	        
//	        
//	        
//		MobileElement appIcon = waitUtil.waitForVisible(exact);
//		appIcon.click();
//		System.out.println("  WIKIPEDIA APP");
//		System.out.println(appName +"-App opened successfully\n");
//	}
	public void launchApplication(String appName) throws InterruptedException {

	    try {
	        driver.findElement(By.id("com.android.launcher:id/branch_confirm_button")).click();
	        System.out.println("   -Onboarding popup dismissed\n");
	    } catch (Exception ignored) {}

	    System.out.println(" HOME SCREEN");

	    boolean found = scrollToApp(appName);

	    if (!found) {
	        System.out.println("   -App not found even after swiping pages.");
	        return;
	    }

	    MobileElement appIcon = driver.findElement(By.xpath("//*[@text='" + appName + "']"));
	    appIcon.click();

	    System.out.println("\n  WIKIPEDIA APP");
	    System.out.println("  " + appName + " - App opened successfully\n");
	}
	public boolean scrollToApp(String appName) {
	    int maxSwipes = 7;

	    for (int i = 0; i < maxSwipes; i++) {
	        try {
	            driver.findElement(By.xpath("//*[@text='" + appName + "']")).isDisplayed();
	            return true;
	        } catch (Exception e) {
	            swipeUp(); // keep scrolling
	        }
	    }
	    return false; // app not found even after 7 swipes
	}
	public void swipeUp() {
	    int width = driver.manage().window().getSize().width;
	    int height = driver.manage().window().getSize().height;

	    int startX = width / 2;
	    int startY = (int) (height * 0.8);
	    int endY   = (int) (height * 0.3);

	    new TouchAction<>(driver)
	            .press(PointOption.point(startX, startY))
	            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700)))
	            .moveTo(PointOption.point(startX, endY))
	            .release()
	            .perform();
	}
}