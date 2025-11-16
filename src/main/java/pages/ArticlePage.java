package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.WaitUtil;

public class ArticlePage {
	
	By tocButton  = By.xpath("//*[@text='Contents']");
	By tocSectionHistoryAI = By.xpath("//*[@text='History of AI']");
	By themeMenuIcon = By.id("org.wikipedia:id/page_theme");
	By matchSystemThemeToggle = By.id("org.wikipedia:id/theme_chooser_match_system_theme_switch");
	By dimImagesToggle = By.id("org.wikipedia:id/theme_chooser_dark_mode_dim_images_switch");
	By darkThemeButton  = By.id("org.wikipedia:id/button_theme_dark");
	By fontStyleButton = By.id("org.wikipedia:id/button_font_family_serif");
	By readingFocusToggle  = By.id("org.wikipedia:id/theme_chooser_reading_focus_mode_switch");
	
	private final AndroidDriver<MobileElement> driver;
	private WaitUtil waitUtil;
	
	public ArticlePage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	public void scrollToTargetSection()
	{
		  driver.findElementByAndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"GPT\")"
			    );
		  		System.out.println(" ARTICLE VIEW");
		  		System.out.println("   -Scrolled to: GPT");
	}
	public void openTableOfContents()
	{
		MobileElement contents =  waitUtil.waitForClickable(tocButton);
		contents.click();
		System.out.println("   -Opened Table of Contents");
	}
	public void selectSectionFromContents()
	{
		 driver.findElementByAndroidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"History of AI\")"
	        	);
		MobileElement contentOptions = waitUtil.waitForVisible(tocSectionHistoryAI);
		contentOptions.click();
		System.out.println("    -Navigated to selected section\n");
	}
	public void openAndApplyReaderTheme()
	{
		System.out.println("  READING CUSTOMIZATION");
		MobileElement icontheme = waitUtil.waitForClickable(themeMenuIcon );
		icontheme.click();
		System.out.println("    -Opened Theme settings");
		MobileElement themeFirst = waitUtil.waitForClickable(matchSystemThemeToggle );
		themeFirst.click();
		System.out.println("    -Applied Match System theme");
		MobileElement themeSecond = waitUtil.waitForClickable(dimImagesToggle);
		themeSecond.click();	
		System.out.println("    -Enabled image dimming");
		MobileElement buttonTheame = waitUtil.waitForClickable(darkThemeButton);
		buttonTheame.click();
		System.out.println("    -Updated Theme settings");
		MobileElement fontButton = waitUtil.waitForClickable(fontStyleButton);
		fontButton.click();
		System.out.println("    -Updated font settings");
		MobileElement readmode = waitUtil.waitForClickable(readingFocusToggle );
		readmode.click();
		System.out.println("    -Activated reading-focus mode\n");
		driver.navigate().back();
	}
	public void returnToHomeScreen()
	{
		driver.terminateApp("org.wikipedia");
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		System.out.println("==================== TEST FINISHED: ALL PASS ====================");
	}
}
