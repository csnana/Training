package com.experitest.auto;

import com.experitest.appium.SeeTestClient;
import com.experitest.client.Client;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;


public class Browser1 {

	private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxODE5ODYwLCJ4cC5wIjoyLCJ4cC5tIjoxNTk4NDM5NTM0MDUwLCJleHAiOjE5MTM3OTk1MzQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.gYJg30EjNnYNvDTFyJn064dTMluiTvpMI5Ss8Yj4rKg";
	private RemoteWebDriver driver;
	private URL url;
	private DesiredCapabilities dc = new DesiredCapabilities();
	protected SeeTestClient seetest = null;
	protected Client client = null;

	@BeforeTest
	public void setUp() throws Exception {
		dc.setCapability("testName", "Quick Start Safari Browser Demo");
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver = new RemoteWebDriver(new URL("https://uscloud.experitest.com/wd/hub"), dc);
		driver.executeScript(String.valueOf(seetest.addTestProperty("campaign", "1234")));
		seetest = new SeeTestClient(driver);
	}


	@Test
	public void browserTestGoogleSearch() throws  IllegalStateException {
		for (int i = 0; i < 7; i++) {
			driver.get("https://www.bbc.com");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

//			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
//			WebElement searchBar = driver.findElement(By.name("q"));
//			searchBar.click();
//			searchBar.sendKeys("Experitest");
//			searchBar.sendKeys(Keys.ENTER);
			try {
				seetest.addTestProperty("campaign", "1234");
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public void tearDown()  {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}