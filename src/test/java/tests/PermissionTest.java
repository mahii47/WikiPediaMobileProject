package tests;
import java.io.IOException;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.PermissionPage;

public class PermissionTest extends BaseTest {
	
	@Test
	public void WikipediaAllowPermissionTest() throws InterruptedException, IOException
	{
		PermissionPage permission = new PermissionPage(driver);
		permission.verifyStoragePermissionAllowed();
	}
	@Test
	public void WikipediaDenyPermissionTest() throws InterruptedException
	{
		PermissionPage permission = new PermissionPage(driver);
		permission.verifyStoragePermissionDenied();
	}
}
