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
	 @AfterSuite(alwaysRun = true)
	    public void suiteSummary() {

	        int passed = Reporter.getCurrentTestResult().getTestContext().getPassedTests().size();
	        int failed = Reporter.getCurrentTestResult().getTestContext().getFailedTests().size();
	        int skipped = Reporter.getCurrentTestResult().getTestContext().getSkippedTests().size();
	        int total = passed + failed + skipped;

	        System.out.println("\n===============================================");
	        System.out.println("        STORAGE-PERMISSION-TEST SUITE          ");
	        System.out.println("===============================================");
	        System.out.println("Total Tests Executed : " + total);
	        System.out.println("Tests Passed         : " + passed);
	        System.out.println("Tests Failed         : " + failed);
	        System.out.println("Tests Skipped        : " + skipped);
	        System.out.println("===============================================");
	        System.out.println((failed == 0) ? "            ALL TESTS PASSED "
	                : "            SOME TESTS FAILED ");
	        System.out.println("===============================================\n");
	    }
	public void resetWikipediaApp() throws Exception {
		Runtime.getRuntime().exec("adb shell pm reset-permissions");
	    Thread.sleep(4000);
	}

}
