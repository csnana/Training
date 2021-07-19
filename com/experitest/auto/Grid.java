
import com.experitest.client.*;
import org.testng.annotations.*;
/**
 *
 */
public class Grid {
	private String host = "https://foxsports.experitest.com";

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxMDcwOTA4LCJ4cC5wIjoyLCJ4cC5tIjoxNjA0NTYwODk2NjYwLCJleHAiOjE5MTk5MjA4OTYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.QSp_L7bLjus40ZjrEUK9djiX1EDKFPTFTxITujCEOT0";
	protected Client client = null;
	protected GridClient grid = null;

	@BeforeTest
	public void setUp(){
		// In case your user is assign to a single project you can provide an empty string,
		// otherwise please specify the project name
		grid = new GridClient(accessKey, host);
		client = grid.lockDeviceForExecution("Quick Start seetest Android Native Demo", "@os='android' and @category='PHONE'", 10, 50000);
		client.setReporter("xml", "", "Quick Start seetest Android Native Demo");

	}

	@Test
	public void quickStartAndroidNativeDemo(){
//		au.com.kayosports/au.com.foxsports.martian.home.MainActivity
		// This command "setDevice" is not applicable for GRID execution
		client.install("cloud:au.com.kayosport", true, false);
		client.launch("au.com.kayosports/au.com.foxsports.martian.home.MainActivity", true, true);
		client.elementSendText("NATIVE", "hint=Username", 0, "company");
		client.elementSendText("NATIVE", "hint=Password", 0, "company");
		client.click("NATIVE", "text=Login", 0, 1);
		client.click("NATIVE", "text=Make Payment", 0, 1);
		client.elementSendText("NATIVE", "hint=Phone", 0, "1234567");
		client.elementSendText("NATIVE", "hint=Name", 0, "Jon Snow");
		client.elementSendText("NATIVE", "hint=Amount", 0, "50");
		client.click("NATIVE", "hint=Country", 0, 1);
		client.click("NATIVE", "text=Select", 0, 1);
		client.click("NATIVE", "text=Switzerland", 0, 1);
		client.click("NATIVE", "text=Send Payment", 0, 1);
		client.click("NATIVE", "text=Yes", 0, 1);
		client.click("NATIVE", "text=Logout", 0, 1);
	}

	@AfterTest
	public void tearDown(){
		// Generates a report of the test case.
		// For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
		client.generateReport(false);
		// Releases the client so that other clients can approach the agent in the near future.
		client.releaseClient();
	}
}