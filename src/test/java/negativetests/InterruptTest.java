package negativetests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.RegressionBaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.InterruptPage;
import utils.WaitUtil;

public class InterruptTest  extends RegressionBaseTest{
	
	@Test
	public void InternetInterruption() throws Exception
	{
		 InterruptPage page = new InterruptPage(driver);
		 page.turnOffInternetInterruption();
		 page.InternetInterruption();
		 page.turnOnnInternetInterruption();
		 page.languageSelection();
	}
}
