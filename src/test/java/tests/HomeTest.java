package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.HomePage;

public class HomeTest extends BaseTest {
	
	@Test
	public void openApp() throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		
		home.openAppDrawer();
		home.openApp("Wikipedia");
		
	}
	
}
