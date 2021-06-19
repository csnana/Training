package com.experitest.auto;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDemoTest {

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzMxNTEwLCJ4cC5wIjoxNzI0NzA2LCJ4cC5tIjoxNTk2NTQzNTQ1NjI0LCJleHAiOjE5MTE5MDM1NDUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.1aY7Nww0lQoV9d_G45yGaNiX-Hnz8-loU2ZtLmToF2M";
	protected IOSDriver<IOSElement> driver = null;
	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws MalformedURLException {
		System.out.println("iOS test start");
		dc.setCapability("testName", "Quick Start iOS Native Demo");
		dc.setCapability("accessKey", accessKey);
		dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		driver = new IOSDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
	}

	@Test
	public void quickStartiOSNativeDemo() {
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
		driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
		driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
		driver.findElement(By.xpath("//*[@id='Yes']")).click();
		System.out.println("iOS test end");
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}
}