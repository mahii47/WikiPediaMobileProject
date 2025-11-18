package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import base.RegressionBaseTest;
import io.qameta.allure.Attachment;

public class AllureTestListener extends BaseTest implements ITestListener {

	 @Attachment(value = "Failed Test Screenshot", type = "image/png")
	    public byte[] saveScreenshotPNG(ITestResult result) {
	        Object testClass = result.getInstance();
	        try {
	            TakesScreenshot ts = (TakesScreenshot) result.getTestContext()
	                    .getAttribute("driver");
	            return ts.getScreenshotAs(OutputType.BYTES);
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        saveScreenshotPNG(result);
	    }
}
