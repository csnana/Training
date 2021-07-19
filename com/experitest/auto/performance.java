package com.experitest.auto;

import com.experitest.appium.SeeTestClient;
import com.experitest.appium.SeeTestClient;
import com.experitest.client.Client;
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

public class performance {
    protected Client client = null;
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxODE5ODYwLCJ4cC5wIjoyLCJ4cC5tIjoxNTk4NDM5NTM0MDUwLCJleHAiOjE5MTM3OTk1MzQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.gYJg30EjNnYNvDTFyJn064dTMluiTvpMI5Ss8Yj4rKg";
    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {
        dc.setCapability("testName", "Quick Start Android Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
        dc.setCapability("udid", "RF8MA30SSDA");
//        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity:1.2414");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportId"));
        SeeTestClient seetest = new SeeTestClient(driver);
        System.out.printf(seetest.generateReport());
        seetest.launch("com.sec.android.app.popupcalculator/.Calculator",false,false);
        client.clearDeviceLog();
//        seetest.click("NATIVE", "//*[@text='1']", 0,1);
//        seetest.click("NATIVE", "//*[@text='+']", 0,1);
//        seetest.click("NATIVE", "//*[@text='1']", 0,1);
//        seetest.click("NATIVE", "//*[@text='=']", 0,1);
////        seetest.launch("com.experitest.ExperiBank/.LoginActivity",false,false);
//        seetest.isElementFound("NATIVE", "//*[@id='loginButton']", 0);
////        wait(2000);
//        seetest.launch("com.sec.android.app.popupcalculator/.Calculator",false,false);

        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity:1.2414");
//        seetest.click("WEB", "text= Wikipedia ", 0, 1);
//        seetest.setNetworkConditions("LTE Network", 30000);
    }

    @Test
    public void quickStartAndroidNativeDemo() throws InterruptedException {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
//        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
////        seetest.startPerformanceTransaction("4G-average");
//        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
//        Object o  = driver.findElement(By.xpath("//*[contains(@text,'Your balance is:')] "));
////        seetest.endPerformanceTransaction("Login");
//        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
//        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Text User");
//        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
//        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
//        driver.findElement(By.xpath("//*[@text='Switzerland']")).click();
//        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
////        seetest.startPerformanceTransaction("4G-average");
//        driver.findElement(By.xpath("//*[@text='Yes']")).click();
//        Object obj  = driver.findElement(By.xpath("//*[contains(@text,'Your balance is:')] "));
////        seetest.endPerformanceTransaction("Payment");
        client.addTestProperty("campaign", "1234");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}