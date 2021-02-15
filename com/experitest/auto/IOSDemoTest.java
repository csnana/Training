package com.experitest.auto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class IOSDemoTest {

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MTQ2MzksInhwLnAiOjIsInhwLm0iOjE2MDA5MjI1NjUxMzUsImV4cCI6MTkxNjI4MjU2NSwiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.SSYdt7SGaOzzvTHDyCD7w-knf2Efvdct9EOikIrRyBc";
	protected AndroidDriver<AndroidElement> driver = null;
	DesiredCapabilities dc = new DesiredCapabilities();
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@BeforeTest
	public void setUp() throws MalformedURLException {
		dc.setCapability("testName", "Quick Start Android Native Demo");
		dc.setCapability("accessKey", accessKey);
//		dc.setCapability(MobileCapabilityType.UDID, "ce011821781268020c");
		dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
//		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank/.LoginActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		driver = new AndroidDriver<>(new URL("https://demo.experitest.com/wd/hub"), dc);
	}

	@Test
	public void quickStartAndroidNativeDemo() {
//		driver.rotate(ScreenOrientation.PORTRAIT);
		System.out.println("Launch app " + timestamp);
		driver.findElement(By.xpath("//*[@id='usernameTextFiel']")).sendKeys("company");
		System.out.println(timestamp);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
		driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
		driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
		driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
		driver.findElement(By.xpath("//*[@id='countryButton']")).click();
		driver.findElement(By.xpath("//*[@text='Switzerland']")).click();
		driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
		driver.findElement(By.xpath("//*[@text='Yes']")).click();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}
}