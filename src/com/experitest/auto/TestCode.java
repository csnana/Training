package com.experitest.auto;

import com.experitest.appium.SeeTestClient;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCode {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MTQ2MzksInhwLnAiOjIsInhwLm0iOjE2MDA5MjI1NjUxMzUsImV4cCI6MTkxNjI4MjU2NSwiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.SSYdt7SGaOzzvTHDyCD7w-knf2Efvdct9EOikIrRyBc";
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
        dc.setCapability("udid", "03157df3d24be314");
        driver = new AndroidDriver<>(new URL("https://demo.experitest.com/wd/hub"), dc);
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


//    public void pushFileToMobileFromPC(String destFilePath, String srcFilePath) throws IOException {
//        if (getDriver().getPlatformName().toUpperCase().equals("ANDROID")) {
//            ((AndroidDriver) getDriver()).pushFile(destFilePath, new File(srcFilePath));
//        } else if (getDriver().getPlatformName().toUpperCase().equals("IOS")) {
//            ((IOSDriver) getDriver()).pushFile(destFilePath, new File(srcFilePath));
//        }
//        Logger.info("File is uploaded from PC to mobile device successfully");
//    }