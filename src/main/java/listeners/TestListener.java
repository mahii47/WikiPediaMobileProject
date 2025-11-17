package listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import base.RegressionBaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	
		    @Override
		    public void onTestFailure(ITestResult result) {

		        System.out.println("Test Failed: " + result.getName());
		        AndroidDriver<MobileElement> driver = null;

		        if (RegressionBaseTest.driver != null) {
		            driver = RegressionBaseTest.driver;
		        }
		        else if (BaseTest.driver != null) {
		            driver = BaseTest.driver;
		        }
		        if (driver != null) {
		            ScreenshotUtil.takeScreenshot(driver, result.getName());
		        } else {
		            System.out.println("No driver found, screenshot NOT taken.");
		        }
		    }
}
