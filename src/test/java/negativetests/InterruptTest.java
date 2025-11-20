package negativetests;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.RegressionBaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.InterruptPage;
import utils.WaitUtil;

@Listeners({listeners.AllureTestListener.class})
public class InterruptTest  extends RegressionBaseTest{
	
	@Epic("Wikipedia")
	@Feature("Interrupt Testing")
	@Story("Internet interruption during article language selection")
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
