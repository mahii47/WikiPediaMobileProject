package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.WaitUtil;

public class PermissionPage {
	
	By cardTitle =  By.id("org.wikipedia:id/view_card_header_title");
	By downloadButton = By.id("org.wikipedia:id/view_featured_image_card_download_button");
	
	private WaitUtil waitUtil;
	private AndroidDriver<MobileElement> driver;
	//Permission to write to storage on your device is required for saving images.
	
	public PermissionPage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	
	public void verifyStoragePermissionDenied() throws InterruptedException
	{
		Thread.sleep(5000);
		scrolltillCard();
		MobileElement download = waitUtil.waitForClickable(downloadButton);
		download.click();
	}
	public void verifyStoragePermissionAllowed()
	{
		scrolltillCard();
		MobileElement download = waitUtil.waitForClickable(downloadButton);
		download.click();
	}
	public void scrolltillCard()
	{
		 driver.findElementByAndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Picture of the day\")"
			    );
	}
}
