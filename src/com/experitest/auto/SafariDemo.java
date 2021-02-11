package com.experitest.auto;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.util.Set;


public class SafariDemo {

	private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzMxNTEwLCJ4cC5wIjoxNzI0NzA2LCJ4cC5tIjoxNTk2NTQzNTQ1NjI0LCJleHAiOjE5MTE5MDM1NDUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.1aY7Nww0lQoV9d_G45yGaNiX-Hnz8-loU2ZtLmToF2M";
	private RemoteWebDriver driver;
	private URL url;
	private DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws Exception {
		dc.setCapability("testName", "Quick Start Safari Browser Demo");
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability(CapabilityType.BROWSER_NAME, "safari");
		dc.setCapability(CapabilityType.BROWSER_VERSION, "13.0.4");
		dc.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
		driver = new RemoteWebDriver(new URL("https://uscloud.experitest.com/wd/hub"), dc);
	}


	@Test
	public void browserTestGoogleSearch() throws InterruptedException {
		driver.manage().window().setPosition(new Point(0, 0));
		Dimension targetSize = new Dimension(1800, 960);
		driver.manage().window().setSize(targetSize);
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.getCurrentUrl();
		String currentHandle = driver.getWindowHandle();
		WebElement window = driver.findElement(By.id("openwindow"));
		Thread.sleep(20000);
		window.sendKeys(Keys.TAB);
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}