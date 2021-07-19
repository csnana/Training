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

public class KBCiOS {

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo1NjQzMDIwLCJ4cC5wIjoyLCJ4cC5tIjoxNjEyNDM2MTk0NzMwLCJleHAiOjE5Mjc3OTYxOTUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.yaOqntfmAuAX5wjwKnBg27GnYxCVndym3zpF2RrBOM8";
	protected IOSDriver<IOSElement> driver = null;
	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws MalformedURLException {
		dc.setCapability("testName", "Quick Start iOS Native Demo");
		dc.setCapability("accessKey", accessKey);
		dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
		dc.setCapability("udid", "00008020-00114C943431002E");
//		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.Preferences");
		driver = new IOSDriver<>(new URL("https://kbc.experitest.com/wd/hub"), dc);
	}

	@Test
	public void quickStartiOSNativeDemo() {
		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.findElement(By.xpath("//*[@text='General' and @class='UIAView']")).click();
		driver.findElement(By.xpath("//*[@accessibilityLabel='ManagedConfigurationList']")).click();
		driver.findElement(By.xpath("//*[@accessibilityLabel='iPhone Distribution: DAG 22 BVBA']")).click();
		driver.findElement(By.xpath("//*[@text='Trust “DAG 22 BVBA”']")).click();
		driver.findElement(By.xpath("//*[@text='Trust']")).click();

//		driver.hideKeyboard();
//		driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
//		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
//		driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
//		driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
//		driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
//		driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
//		driver.findElement(By.xpath("//*[@id='countryButton']")).click();
//		driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
//		driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
//		driver.findElement(By.xpath("//*[@id='Yes']")).click();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}
}