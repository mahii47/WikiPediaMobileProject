package pages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.WaitUtil;

public class PermissionPage {
	
	By cardTitle =  By.id("org.wikipedia:id/view_card_header_title");
	By downloadButton = By.id("org.wikipedia:id/view_featured_image_card_download_button");
	By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
	By denyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
	By denytext = By.id("org.wikipedia:id/snackbar_text");
	
	String expectedDenymessage = "Permission to write to storage on your device is required for saving images.";
	
	private WaitUtil waitUtil;
	private AndroidDriver<MobileElement> driver;
	
	public PermissionPage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	public void verifyStoragePermissionDenied() throws InterruptedException
	{
		Thread.sleep(5000);
		scrollTillBothFound(driver);
		System.out.println("Scrolling till Picture of the day card");
		MobileElement download = waitUtil.waitForClickable(downloadButton);
		download.click();
		System.out.println("Download button is clicked!!");
		MobileElement deny = waitUtil.waitForClickable(denyButton);
		deny.click();
		System.out.println("Deny button is clicked!!");
		MobileElement message =  waitUtil.waitForVisible(denytext);
		String actualmessage = message.getText();
		System.out.println("expected message is:"+actualmessage);
		System.out.println("actual message is:"+expectedDenymessage);
		Assert.assertEquals(actualmessage, expectedDenymessage);
	}
	public void verifyStoragePermissionAllowed() throws IOException
	{
		scrollTillBothFound(driver);
		MobileElement download = waitUtil.waitForClickable(downloadButton);
		download.click();
		System.out.println("Download button is clicked!!");
		MobileElement allow = waitUtil.waitForClickable(allowButton);
		allow.click();
		System.out.println("Allow button is clicked!!");
		downloadedFile();
	}
	public void scrollTillBothFound(AndroidDriver<MobileElement> driver) {
	    while (driver.findElements(cardTitle).isEmpty() ||
	           driver.findElements(downloadButton).isEmpty()) {

	        driver.findElementByAndroidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
	        );
	    }
	}
	public void downloadedFile() throws IOException
	{
		Process process = Runtime.getRuntime().exec("adb shell ls /sdcard/Pictures/Wikipedia/");
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String fileName = reader.readLine();

		if (fileName == null || fileName.trim().isEmpty()) {
		    System.out.println("No file downloaded!");
		} else {
		    System.out.println("File downloaded: " + fileName);
		}
	}
}
