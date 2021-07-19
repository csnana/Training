package com.experitest.auto;

import com.experitest.appium.SeeTestClient;
import com.experitest.client.Client;
import io.appium.java_client.MobileBy;
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

import static java.lang.Thread.sleep;

public class NextGenDemo {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMTY1NDI3LCJ4cC5wIjoyMjMxMDc3LCJ4cC5tIjoxNjE1NDcxMTU3NzkwLCJleHAiOjE5MzQ4ODg5MDksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.2Jb8d-aw7EEAyHgTvaNl_z79hogSFcIUQ2o3GUpCgcU";
    protected IOSDriver<IOSElement> driver = null;
    protected Client client = null;
    protected SeeTestClient seetest = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability("udid", "f58b0eeba77f6e50aeb15d60b420604a94f0dec9");
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.entradahealth.entradamobile");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.entradahealth.entradamobile");
//        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.VoiceMemos");
        driver = new IOSDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
        seetest = new SeeTestClient(driver);
    }
    @Test
    public void quickStartiOSNativeDemo() {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//        Thread.sleep(10000);
//        seetest.startAudioPlay();
//        seetest.install("cloud:com.experitest.ExperiBank",false,true	);
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        seetest.uninstall("com.experitest.ExperiBank");
        driver.removeApp("com.entradahealth.entradamobile");
        driver.installApp("com.entradahealth.entradamobile");

//        driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//		driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//		driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//		driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//		driver.findElement(By.xpath("(//*[@name='OK'])[1]")).click();
//        driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//        driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//        driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//        driver.findElement(By.xpath("(//*[@name='1'])[1]")).click();
//        driver.findElement(By.xpath("(//*[@name='OK'])[1]")).click();
//        String LogIn_Text = "**/XCUIElementTypeNavigationBar[`name == \"Log In\"`]";
//        driver.findElement(MobileBy.iOSClassChain(LogIn_Text)).click();
//		System.out.println((driver.findElement(By.className(LogIn_Text)).getAttribute("type")));
//        String UserIDField =  "**/XCUIElementTypeTextField";
//        String PasswordField = "**/XCUIElementTypeSecureTextField";
//        driver.findElement(MobileBy.iOSClassChain(UserIDField)).sendKeys("patientdetails_ainrt@yopmail.com");
//        driver.findElement(MobileBy.iOSClassChain(PasswordField)).sendKeys("Entrada3!");
//        driver.findElement(By.xpath("(//*[@name='Log In'])[4]")).click();
//        client.launch("com.apple.VoiceMemos", false, true);

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElement(By.xpath("(//*[@name='Log In'])[4]")).click();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}