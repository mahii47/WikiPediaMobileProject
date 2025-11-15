package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.WaitUtil;

public class ArticlePage {
	
	By content = By.xpath("//*[@text='Contents']");
	By contentOption = By.xpath("//*[@text='History of AI']");
	
	private final AndroidDriver<MobileElement> driver;
	private WaitUtil waitUtil;
	
	public ArticlePage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	public void scrollPage()
	{
		  driver.findElementByAndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Agents\")"
			    );
		  System.out.println("Scrollling till Agent section");
	}
	public void contentsIcon()
	{
		MobileElement contents =  waitUtil.waitForClickable(content);
		contents.click();
		  System.out.println("Clicked on content");
	}
	public void allcontainsOptions()
	{
		 driver.findElementByAndroidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"History of AI\")"
	        	);
		MobileElement contentOptions = waitUtil.waitForVisible(contentOption);
		contentOptions.click();
	}
	
	
}
