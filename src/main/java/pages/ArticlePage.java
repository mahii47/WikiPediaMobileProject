package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.WaitUtil;

public class ArticlePage {
	
	By content = By.xpath("//*[@text='Contents']");
	By contentOption = By.xpath("//*[@text='History of AI']");
	By themeicon = By.id("org.wikipedia:id/page_theme");
	By firsttheme = By.id("org.wikipedia:id/theme_chooser_match_system_theme_switch");
	By secondtheme = By.id("org.wikipedia:id/theme_chooser_dark_mode_dim_images_switch");
	By theameButton = By.id("org.wikipedia:id/button_theme_dark");
	By font = By.id("org.wikipedia:id/button_font_family_serif");
	By read = By.id("org.wikipedia:id/theme_chooser_reading_focus_mode_switch");
	
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
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"GPT\")"
			    );
		  		System.out.println(" ARTICLE VIEW");
		  		System.out.println("   -Scrolled to: GPT");
	}
	public void contentsIcon()
	{
		MobileElement contents =  waitUtil.waitForClickable(content);
		contents.click();
		System.out.println("   -Opened Table of Contents");
	}
	public void allcontainsOptions()
	{
		 driver.findElementByAndroidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"History of AI\")"
	        	);
		MobileElement contentOptions = waitUtil.waitForVisible(contentOption);
		contentOptions.click();
		System.out.println("    -Navigated to selected section\n");
	}
	public void theme()
	{
		System.out.println("  READING CUSTOMIZATION");
		MobileElement icontheme = waitUtil.waitForClickable(themeicon);
		icontheme.click();
		System.out.println("    -Opened Theme settings");
		MobileElement themeFirst = waitUtil.waitForClickable(firsttheme);
		themeFirst.click();
		System.out.println("    -Applied Match System theme");
		MobileElement themeSecond = waitUtil.waitForClickable(secondtheme);
		themeSecond.click();	
		System.out.println("    -Enabled image dimming");
		MobileElement buttonTheame = waitUtil.waitForClickable(theameButton);
		buttonTheame.click();
		System.out.println("    -Updated Theme settings");
		MobileElement fontButton = waitUtil.waitForClickable(font);
		fontButton.click();
		System.out.println("    -Updated font settings");
		MobileElement readmode = waitUtil.waitForClickable(read);
		readmode.click();
		System.out.println("    -Activated reading-focus mode\n");
		driver.navigate().back();
	}
	public void backHomeScreen()
	{
		driver.terminateApp("org.wikipedia");
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		System.out.println("==================== TEST FINISHED: ALL PASS ====================");
	}
}
