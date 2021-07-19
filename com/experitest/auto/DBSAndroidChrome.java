package com.experitest.auto;

//import com.experitest.appium.SeeTestClient;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.windows.PressesKeyCode;
import org.openqa.selenium.remote.RemoteKeyboard;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.experitest.client.*;


import java.net.MalformedURLException;
import java.net.URL;

public class DBSAndroidChrome {
    protected Client client = null;
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MTQ3MzMyLCJ4cC5wIjoyLCJ4cC5tIjoxNTk3OTQwOTAxNDk3LCJleHAiOjE5MTMzMDA5MDIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.maonFxpOX2Pb9IsbmwnR8JQgFHlxwTWa6Jwdi2i4wYk";
    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private RemoteKeyboard keyboard;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start Android Browser Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='android' ");
        dc.setCapability("udid", "R52NC0E9CXP");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver<>(new URL("https://dbs-sg.experitest.com/wd/hub"), dc);
//        seetest = new SeeTestClient(driver);

    }

    @Test
    public void quickStartAndroidBrowserDemo() throws InterruptedException {
//		driver.rotate(ScreenOrientation.PORTRAIT);
//		driver.closeApp();
//        seetest.launch("https://www.google.com");
//        seetest.launch("chrome:https://uat2-mobile-banking.dbs.com/vandapoc/#/placeorder?sysGenId=P000000004600575&acc=4600575&avlac=S-191966-0", true, false);
//        seetest.waitForElement("WEB", "xpath=//*[@data-testid='test-inputfield']", 0, 60000);
//        seetest.elementSendText("WEB", "xpath=//*[@data-testid='test-inputfield']", 0, "DBS");

//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
//        WebElement searchBar = driver.findElement(By.name("q"));
//        searchBar.sendKeys("Experitest");
//        driver.findElement(By.xpath("//*[@css='BUTTON.Tg7LZd']")).click();
        driver.get("https://uat2-mobile-banking.dbs.com/vandapoc/#/placeorder?sysGenId=P000000004600575&acc=4600575&avlac=S-191966-0");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid='test-inputfield']")));
        WebElement searchBar = driver.findElement(By.xpath("//*[@data-testid='test-inputfield']"));
        searchBar.click();
        driver.getKeyboard().sendKeys("username");
		searchBar.click();
        driver.getKeyboard().sendKeys("password");
//        driver.get("www.dbs.com");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid='test-inputfield']")));
//        WebElement searchBar = driver.findElement(By.xpath("//*[@data-testid='test-inputfield']"));
//        WebElement hamburger = driver.findElement(By.xpath("(//*[@id='btnHamburger']/*[@nodeName='SPAN' and @width>0])[1]"));
//        hamburger.click();
//        WebElement searchDBS = driver.findElement(By.xpath("//*[@nodeName='INPUT' and (./preceding-sibling::* | ./following-sibling::*)[@id='btnMainMobSearch']]"));
//        searchDBS.sendKeys("DBS");
        Thread.sleep(10000);
//        searchBar.sendKeys("DBS");
//        searchBar.click();
//
//        driver.getKeyboard().pressKey(Keys.RETURN);
        ////		driver.getKeyboard().sendKeys("DBS");
//		driver.getKeyboard().sendKeys(Keys.valueOf("S"));
//		driver.isKeyboardShown();

//        Thread.sleep(10000);
//        driver.findElement(By.xpath("(//*[@text='D05'])[1]")).click();
////		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
//		WebElement searchBar = driver.findElement(By.name("q"));
//		searchBar.sendKeys("Experitest");
//		driver.findElement(By.xpath("//*[@css='BUTTON.Tg7LZd']")).click();
    }

    @AfterTest
    public void tearDown() {
//        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}