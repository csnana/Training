package com.experitest.auto;

import java.net.URL;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.experitest.appium.SeeTestClient;
import com.experitest.client.Client;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.internal.thread.ThreadUtil;


public class AndroidDemoTest1 extends BaseTest {
//	protected AndroidDriver<AndroidElement> driver = null;
	SeeTestClient client;
	static String host = "ocbc.experitest.com";
	static String accessKey = "eyJ4cC51Ijo4NzYxLCJ4cC5wIjoxLCJ4cC5tIjoiTVRVNE16TXpOelkwTmpFMU1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4OTg2OTc2NDYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.ZWZBfWCqfrjMpMpPdv0j50ZafKKi_0LvasF5jClcXD4";
	static String proxyHost = "192.168.5.20";
	static int proxyPort = 808;
	static String proxyUser = "user";
	static String proxyPassword = "password";
//	SeeTestClient client;
	AndroidDriver<AndroidElement> driver = null;
	protected DesiredCapabilities dc = new DesiredCapabilities();
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		dc.setCapability("deviceQuery", "@os='Android'");
		dc.setCapability("testName", "AndroidTest"+System.currentTimeMillis());
		dc.setCapability("platformName", "Android");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.dbs.dbspaylah");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Views.Activities.SplashActivity");
		dc.setCapability("newSessionWaitTimeout", 700);
		dc.setCapability("udid", "3ST0219311001688");
		dc.setCapability("accessKey", "xyxyxyxyxyxyx");
		URL url = new URL("https://dbs-sg.experitest.com:443/wd/hub");
		driver = new AndroidDriver<AndroidElement>(SeleniumClientFactory.createExecutor(url, proxyHost, proxyPort , proxyUser, proxyPassword), dc);
		SeeTestClient seetest = new SeeTestClient(driver);
		seetest.setProperty("ios.auto.accept.alerts", "true");
		seetest.simulateCapture("/Users/satheeshnukala/Desktop/InvalidUEN.png");


	}

	@Test (priority = 1)
	public void wrongCredentials() throws InterruptedException{
		System.out.println("Logging in with wrong info");
		driver.findElementByXPath("//*[@id='usernameTextField']").sendKeys("compan");
		driver.findElementByXPath("//*[@id='passwordTextField']").sendKeys("compan");
		driver.findElementByXPath("//*[@text='Login']").click();
		String strText = driver.findElementByXPath("//*[contains(text(),'Invalid')]").getText();
		System.out.println( "Text Displayed: " + strText);
		driver.findElementByXPath("//*[@text='Close']").click();
	 }
	@Test (priority = 2)
	public void correctCredentials() throws InterruptedException{
		System.out.println("Logging in with correct info");
		driver.findElementByXPath("//*[@id='usernameTextField']").sendKeys("company");
		driver.findElementByXPath("//*[@id='passwordTextField']").sendKeys("company");
		driver.findElementByXPath("//*[@text='Login']").click();
		Thread.sleep(3000);
		String strText = driver.findElementByXPath("//*[contains(text(),'balance')]").getText();
		System.out.println( "Text Displayed: " + strText);
		System.out.println("Logged in sucessfully");
		}
	@Test (priority=3)
	public void makePayment() throws InterruptedException{
		driver.findElementByXPath("//*[@id='usernameTextField']").sendKeys("company");
		driver.findElementByXPath("//*[@id='passwordTextField']").sendKeys("company");
		driver.findElementByXPath("//*[@text='Login']").click();
		String strText = driver.findElementByXPath("//*[contains(text(),'balance')]").getText();
		System.out.println( "Current Balance: " + strText);
		driver.findElementByXPath("//*[@text='Make Payment']").click();
		driver.findElementByXPath("//*[@id='phoneTextField']").sendKeys("9845281062");
		driver.findElementByXPath("//*[@id='nameTextField']").sendKeys("Nanjappa");
		driver.findElementByXPath("//*[@id='amountTextField']").sendKeys("10");
		driver.findElementByXPath("//*[@id='countryTextField']").sendKeys("India");
		driver.findElementByXPath("//*[@text='Send Payment']").click();
		System.out.println( "Payment made: 10");
		driver.findElementByXPath("//*[@text='Yes']").click();
		String strText2 = driver.findElementByXPath("//*[contains(text(),'balance')]").getText();
		System.out.println( "New Balance: " + strText2);
		}
	//*[@text='Make Payment']
	//*[@id='phoneTextField']
	//*[@id='nameTextField']
	//*[@id='amountTextField']
	//*[@id='countryTextField']
	//*[@text='Send Payment']
	//*[@text='Yes']

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}