package com.experitest.auto;

import com.experitest.appium.SeeTestClient;
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

public class TestCodeDBS {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxOTY0OSwieHAucCI6MSwieHAubSI6MTU5NzkwNzkxODMyOCwiZXhwIjoxOTEzNjkzNTgxLCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.-f3Vnh1J9v5_JFWg14CTLfWjzeoOHP90KuwSOTqgSEY";
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
        dc.setCapability("udid", "269d1f9cdd0d7ece");
        driver = new AndroidDriver<>(new URL("https://ocbc.experitest.com/wd/hub"), dc);
        SeeTestClient seetest = new SeeTestClient(driver);
// push a file to SD storage
//        seetest.run("adb push C:\\Users\\myuser\\Pictures\\myPicture.png /sdcard/Pictures/myPicture.png");
        seetest.run("adb push //Users//nanjappa//Downloads//url.html /sdcard/file2.html");
//        seetest.run("adb push https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png /sdcard/gimg.html");
        System.out.println("Pushed");
    }

    @Test
    public void quickStartAndroidNativeDemo() {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
//        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
//        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
//        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
//        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
//        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
//        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
//        driver.findElement(By.xpath("//*[@text='Switzerland']")).click();
//        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}