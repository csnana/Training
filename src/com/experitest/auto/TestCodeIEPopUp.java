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


public class TestCodeIEPopUp {

    private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzMxNTEwLCJ4cC5wIjoxNzI0NzA2LCJ4cC5tIjoxNTk2NTQzNTQ1NjI0LCJleHAiOjE5MTE5MDM1NDUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.1aY7Nww0lQoV9d_G45yGaNiX-Hnz8-loU2ZtLmToF2M";
    private RemoteWebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws Exception {

        url = new URL("https://uscloud.experitest.com/wd/hub");
        dc.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
        dc.setCapability(CapabilityType.BROWSER_VERSION, "11");
        dc.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", "Quick Start IE Browser Demo");
        driver = new RemoteWebDriver(url, dc);
    }


    @Test
    public void browserTestGoogleSearch() throws InterruptedException {
        driver.manage().window().setPosition(new Point(0, 0));
        Dimension targetSize = new Dimension(1800, 960);
        driver.manage().window().setSize(targetSize);
        driver.get("https://letskodeit.teachable.com/p/practice");
        driver.getCurrentUrl();
        String currentHandle = driver.getWindowHandle();
        WebElement window = driver.findElement(By.id("openwindow"));
        window.click();
        Thread.sleep(2000);
        Set<String> allHandles = driver.getWindowHandles();
        allHandles.remove(currentHandle);
        String newHandle = allHandles.stream().findFirst().orElseThrow(() -> new IllegalStateException("didn't find new window"));
        driver.switchTo().window(newHandle);
        System.out.println(driver.switchTo().window(newHandle).getPageSource());
        Thread.sleep(30000);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }

}