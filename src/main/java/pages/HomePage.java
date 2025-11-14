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
	public void openAppDrawer()
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
        System.out.println("App Drawer Opened Successfully");
        
	}
	public void openApp(String appName) throws InterruptedException
	{
		By exact = By.xpath("//*[@text='"+appName+"']");
		try
		{
			 driver.findElement(By.id("com.android.launcher:id/branch_confirm_button")).click();
			 System.out.println("Clicked 'Got it'");
		}catch(Exception e)
		{
			 System.out.println("'Got it' popup not displayed");
		}
	        driver.findElementByAndroidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Wikipedia\")"
	        	);
		MobileElement appIcon = waitUtil.waitForVisible(exact);
		appIcon.click();
		System.out.println(appName + " App Opened (Exact)");
	}
}
