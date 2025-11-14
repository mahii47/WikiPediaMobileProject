package base;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import config.CapabilitiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	protected static AndroidDriver<MobileElement> driver;
	
	private final String UDID = "T49P8X6LTG5DHE7H";
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities caps = CapabilitiesManager.getLauncherCapabilities(UDID);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	}
	@AfterClass
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}	
	}
}
