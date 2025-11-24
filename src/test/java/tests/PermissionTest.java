package tests;
import org.testng.annotations.Test;
import base.RegressionBaseTest;
import pages.PermissionPage;

public class PermissionTest extends RegressionBaseTest {
	
	@Test
	public void WikipediaPermissionTest() throws InterruptedException
	{
		PermissionPage permission = new PermissionPage(driver);
		permission.verifyStoragePermissionDenied();
	}
}
