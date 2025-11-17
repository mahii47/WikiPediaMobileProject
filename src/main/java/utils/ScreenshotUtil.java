package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

	  public static void takeScreenshot(AndroidDriver<MobileElement> driver, String testName) {
	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            String folderPath = "screenshots/";
	            File folder = new File(folderPath);

	            if (!folder.exists()) {
	                folder.mkdirs();
	            }
	            String filePath = folderPath + testName + "_" + timestamp + ".png";
	            FileUtils.copyFile(src, new File(filePath));

	            System.out.println("Screenshot saved at: " + filePath);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }
}