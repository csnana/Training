package com.experitest.auto;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.util.Set;


public class SeleniumSafariDemoTestDBS {

    private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MTQ3MzMyLCJ4cC5wIjoyLCJ4cC5tIjoxNTk3OTQwOTAxNDk3LCJleHAiOjE5MTMzMDA5MDIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.maonFxpOX2Pb9IsbmwnR8JQgFHlxwTWa6Jwdi2i4wYk";
    private RemoteWebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws Exception {
        dc.setCapability("testName", "Quick Start Safari Browser Demo");
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability(CapabilityType.BROWSER_NAME, "safari");
        dc.setCapability(CapabilityType.BROWSER_VERSION, "13.1");
        dc.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
        driver = new RemoteWebDriver(new URL("https://dbs-sg.experitest.com/wd/hub"), dc);
    }


    @Test
    public void browserTestGoogleSearch() throws InterruptedException {
        driver.manage().window().setPosition(new Point(0, 0));
        Dimension targetSize = new Dimension(1800, 960);
        driver.manage().window().setSize(targetSize);
        driver.get("https://dbsweb-u01-www.dbs.com.sg/insure/web/espring/");
        driver.findElement(By.xpath("//*[contains(text(),'Get Started')]")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[contains(text(),'Go on to the webpage (not recommended)')]")).click();
//        Thread.sleep(10000);
//        driver.getCurrentUrl();
//        String currentHandle = driver.getWindowHandle();
//        WebElement window = driver.findElementByXPath("(//*[contains(@class,'Benefits_Exclusion')])[1]");
//        window.click();
//        Thread.sleep(10000);
//        Set<String> allHandles = driver.getWindowHandles();
//        allHandles.remove(currentHandle);
//        String newHandle = allHandles.stream().findFirst().orElseThrow(() -> new IllegalStateException("didn't find new window"));
//        driver.switchTo().window(newHandle);
//        System.out.println(driver.switchTo().window(newHandle).getTitle());
//        System.out.println(driver.switchTo().window(newHandle).getPageSource());
//        Thread.sleep(30000);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }

}