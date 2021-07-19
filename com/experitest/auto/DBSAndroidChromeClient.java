package com.experitest.auto;

import com.experitest.client.*;
import org.testng.annotations.*;
/**
 *
 */
public class DBSAndroidChromeClient {
    private String host = "https://dbs-sg.experitest.com";

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MTQ3MzMyLCJ4cC5wIjoyLCJ4cC5tIjoxNTk3OTQwOTAxNDk3LCJleHAiOjE5MTMzMDA5MDIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.maonFxpOX2Pb9IsbmwnR8JQgFHlxwTWa6Jwdi2i4wYk";
    protected Client client = null;
    protected GridClient grid = null;

    @BeforeTest
    public void setUp(){
        // In case your user is assign to a single project you can provide an empty string,
        // otherwise please specify the project name
        grid = new GridClient(accessKey, host);
        client = grid.lockDeviceForExecution("Quick Start seetest Android Web Demo",  "@serialnumber='R52NC0E9CXP'", 10, 50000);
        client.setReporter("xml", "", "Quick Start seetest Android Web Demo");

    }

    @Test
    public void quickStartAndroidWebDemo(){

        // This command "setDevice" is not applicable for GRID execution
//        client.launch("chrome:http://google.com", true, false);
//        if(client.waitForElement("WEB", "name=q", 0, 60000)){
//            // If statement
//        }
//        client.elementSendText("WEB", "name=q", 0, "experitest");
//        client.click("WEB", "name=q", 0, 1);
//        client.sendText("{Enter}");
        client.launch("chrome:https://uat2-mobile-banking.dbs.com/vandapoc/#/placeorder?sysGenId=P000000004600575&acc=4600575&avlac=S-191966-0", true, false);
        client.waitForElement("WEB", "xpath=//*[@data-testid='test-inputfield']", 0, 60000);
        client.elementSendText("WEB", "xpath=//*[@data-testid='test-inputfield']", 0, "DBS");

//*[@nodeName='INPUT' and (./preceding-sibling::* | ./following-sibling::*)[@id='btnMainMobSearch']]
    }

    @AfterTest
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }
}