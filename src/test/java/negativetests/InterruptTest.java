package negativetests;
import org.testng.annotations.Test;
import base.RegressionBaseTest;

public class InterruptTest  extends RegressionBaseTest{
	
	  @Test
	    public void testWifiInterruption() throws Exception {
		  
	        System.out.println("=== INTERRUPT TEST: MOBILE DATA STARTED ===");

	        Thread.sleep(3000);

	        // Turn OFF Mobile Data
	        System.out.println("Turning Mobile Data OFF...");
	        Runtime.getRuntime().exec("adb shell svc data disable");
	        Thread.sleep(5000);
	        System.out.println("Mobile Data is now OFF.");

	        // Add any step here (scroll article / click section) to show the impact in video
	       
	        
	        Thread.sleep(4000);

	        // Turn ON Mobile Data
	        System.out.println("Turning Mobile Data ON...");
	        Runtime.getRuntime().exec("adb shell svc data enable");
	        Thread.sleep(6000);
	        System.out.println("Mobile Data is now ON.");

	        System.out.println("=== INTERRUPT TEST COMPLETED ===");
	  }
}
