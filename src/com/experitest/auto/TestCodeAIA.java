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

public class TestCodeAIA {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjozNzQyNSwieHAucCI6MSwieHAubSI6MTU5NzQwNTczODM4MywiZXhwIjoxOTEyNzY1NzM4LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.lqH4GqlGHZBjIQRAxoU4UtGNWOreyrcqkuyFqnJReQg";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
//        dc.setCapability("deviceQuery", "@os='ios' and @version='13.3' and @category='PHONE'");
        dc.setCapability("deviceQuery", "@os='ios' and @version='12.3.1' and @category='PHONE'");
//        dc.setCapability("udid", "35d10e8e53339f91b6fc04a6e3f9b55916377bd2");
//        dc.setCapability("udid", "00008030-00142586223A802E");
//        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.3.1");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.accentuerlab.connect.uat");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.accentuerlab.connect.uat");
        driver = new IOSDriver<>(new URL("https://aia.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() throws InterruptedException {
        String skip_xpath = "//*[@text='SKIP'] | (//*[@text='SKIP'])[15]";
        driver.findElementsByXPath(skip_xpath);
        driver.findElement(By.xpath(skip_xpath)).click();
        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}