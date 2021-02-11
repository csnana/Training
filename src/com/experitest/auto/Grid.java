package com.experitest.auto;

import com.experitest.client.*;
import org.testng.annotations.*;
/**
 *
 */
public class Grid {
	private String host = "https://uscloud.experitest.com";

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzMxNTEwLCJ4cC5wIjoxNzI0NzA2LCJ4cC5tIjoxNTk2NTQzNTQ1NjI0LCJleHAiOjE5MTE5MDM1NDUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.1aY7Nww0lQoV9d_G45yGaNiX-Hnz8-loU2ZtLmToF2M";
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
		// This command "setDevice" is not applicable for GRID execution
		client.install("cloud:com.experitest.ExperiBank", true, false);
		client.launch("com.experitest.ExperiBank/.LoginActivity", true, true);
		client.startPerformanceTransaction("4G-average");
		client.elementSendText("NATIVE", "hint=Username", 0, "company");
		client.elementSendText("NATIVE", "hint=Password", 0, "company");
		client.click("NATIVE", "text=Login", 0, 1);
		client.endPerformanceTransaction("Login");
//		client.click("NATIVE", "text=Make Payment", 0, 1);
//		client.elementSendText("NATIVE", "hint=Phone", 0, "1234567");
//		client.elementSendText("NATIVE", "hint=Name", 0, "Jon Snow");
//		client.elementSendText("NATIVE", "hint=Amount", 0, "50");
//		client.click("NATIVE", "hint=Country", 0, 1);
//		client.click("NATIVE", "text=Select", 0, 1);
//		client.click("NATIVE", "text=Switzerland", 0, 1);
//		client.click("NATIVE", "text=Send Payment", 0, 1);
//		client.click("NATIVE", "text=Yes", 0, 1);
//		client.click("NATIVE", "text=Logout", 0, 1);
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