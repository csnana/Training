package com.experitest.auto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.Base64;

public class MoonactiveAndroid {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo1MzksInhwLnAiOjEsInhwLm0iOjE2MDg2MzYwMjcwOTAsImV4cCI6MTkyMzk5NjAyNywiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.yfCEifINRV88zmGSwoBm3h3FLTDWZGkzpONN3YJU4yM";
    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start Android Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "04e196bf7d25");
//        dc.setCapability("udid", "03157df3d24be314");
        dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
//        dc.setCapability(MobileCapabilityType.APP, "cloud:com.moonactive.coinmaster/com.moon.coinmaster.android.GameActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.moonactive.coinmaster");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.moon.coinmaster.android.GameActivity");
        driver = new AndroidDriver<>(new URL("https://vpndemo.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartAndroidNativeDemo() throws IOException, InterruptedException {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        driver.pushFile("/storage/emulated/0/Android/data/com.moonactive.coinmaster/files/t2.txt", decodedBytes);
        driver.closeApp();
        Thread.sleep(10000);
        driver.executeScript("seetest:client.launch(\"com.moonactive.coinmaster/com.moon.coinmaster.android.GameActivity\", \"false\", \"false\")");
        Thread.sleep(10000);
//        driver.activateApp("com.moonactive.coinmaster");
//        driver.launchApp("com.moonactive.coinmaster");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
//        driver.quit();
    }
}