package listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import base.RegressionBaseTest;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            TakesScreenshot ts = null;

            // Check BaseTest driver first
            if (BaseTest.driver != null) {
                ts = (TakesScreenshot) BaseTest.driver;
            }
            // Else check Regression driver
            else if (RegressionBaseTest.driver != null) {
                ts = (TakesScreenshot) RegressionBaseTest.driver;
            }

            if (ts == null) {
                System.out.println("No driver available for screenshot.");
                return;
            }

            File src = ts.getScreenshotAs(OutputType.FILE);

            // Create folder if not exists
            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = "screenshots/" + result.getName() + ".png";
            FileUtils.copyFile(src, new File(path));

            System.out.println("Screenshot saved at: " + path);

        } catch (Exception e) {
            System.out.println("Failed to take screenshot.");
        }
    }
}
