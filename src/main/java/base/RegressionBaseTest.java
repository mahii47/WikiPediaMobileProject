package base;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import config.CapabilitiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.HomePage;

public class RegressionBaseTest {
	public static AndroidDriver<MobileElement> driver;
	private final String UDID = "T49P8X6LTG5DHE7H";
	
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = CapabilitiesManager.getLauncherCapabilities(UDID);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		HomePage home = new HomePage(driver);
		home.swipeUpToOpenAppDrawer();
		home.launchApplication("Wikipedia");	
	}
	@AfterSuite(alwaysRun = true)
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
}
