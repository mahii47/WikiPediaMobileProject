package config;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {
	
	public static DesiredCapabilities getLauncherCapabilities(String udid)
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName","Android");
		caps.setCapability("deviceName", "AndroidDevice");
		caps.setCapability("udid",udid);
		caps.setCapability("automateName","UiAutomator2");
		caps.setCapability("appPackage","com.android.launcher");
		caps.setCapability("appActivity","com.android.launcher.Launcher");
		caps.setCapability("ignoreHiddenApiPo;icyError",true);
		
		return caps;	
	}
}
