package listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;

public class AllureTestListener implements ITestListener {

    @Attachment(value = "Failed Test Screenshot", type = "image/png")
    public byte[] captureScreenshot(ITestResult result) {

        try {
            Object driverObj = result.getTestContext().getAttribute("driver");

            if (driverObj != null) {
                TakesScreenshot ts = (TakesScreenshot) driverObj;
                return ts.getScreenshotAs(OutputType.BYTES);
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result);
    }
}
