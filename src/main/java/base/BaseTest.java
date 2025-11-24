package base;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import config.CapabilitiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.HomePage;

public class BaseTest {
	
	public static AndroidDriver<MobileElement> driver;
	private final String UDID = "T49P8X6LTG5DHE7H";
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception
	{
		DesiredCapabilities caps = CapabilitiesManager.getLauncherCapabilities(UDID);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
		HomePage home = new HomePage(driver);
		home.swipeUpToOpenAppDrawer();
		home.launchApplication("Wikipedia");	
		resetWikipediaApp();
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.terminateApp("org.wikipedia");
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		System.out.println("==================== TEST FINISHED:====================");
		if(driver!=null)
		{
			driver.quit();
		}
	}
	public void resetWikipediaApp() throws Exception {
		Runtime.getRuntime().exec("adb shell pm reset-permissions");
	    Thread.sleep(4000);
	}

}
