package com.experitest.auto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalAndroidTest {

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzMxNTEwLCJ4cC5wIjoxNzI0NzA2LCJ4cC5tIjoxNTk2NTQzNTQ1NjI0LCJleHAiOjE5MTE5MDM1NDUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.1aY7Nww0lQoV9d_G45yGaNiX-Hnz8-loU2ZtLmToF2M";
	protected AndroidDriver<AndroidElement> driver = null;
	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws MalformedURLException {
		dc.setCapability("testName", "Quick Start Android Native Demo");
		dc.setCapability("accessKey", accessKey);
		dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		driver = new AndroidDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
	}

	@Test
	public void quickStartAndroidNativeDemo() {
		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
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