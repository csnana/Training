package com.experitest.auto;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
public class SeleniumIEDemoTest {
	private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MTQ3MzMyLCJ4cC5wIjoyLCJ4cC5tIjoxNTk3OTQwOTAxNDk3LCJleHAiOjE5MTMzMDA5MDIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.maonFxpOX2Pb9IsbmwnR8JQgFHlxwTWa6Jwdi2i4wYk";
	private RemoteWebDriver driver;
	private URL url;
	private DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws Exception {

		url = new URL("https://demo.experitest.com/wd/hub");
		dc.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		dc.setCapability(CapabilityType.BROWSER_VERSION, "11");
		dc.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability("testName", "Quick Start IE Browser Demo");
		driver = new RemoteWebDriver(url, dc);
	}

	@Test
	public void browserTestGoogleSearch() throws  InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		WebElement hoverTitle = driver.findElement(By.xpath("//*[text()='Mouse Hover Example']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", hoverTitle);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement hover = driver.findElement(By.id("mousehover"));
		action.moveToElement(hover).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(), 'Top')]")).click();
		WebElement window = driver.findElement(By.id("openwindow"));
		window.click();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}