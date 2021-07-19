package com.experitest.auto;

import com.experitest.client.*;
import org.testng.annotations.*;

public class Audio {
    private String host = "https://uscloud.experitest.com";

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxODE5ODYwLCJ4cC5wIjoyLCJ4cC5tIjoxNTk4NDM5NTM0MDUwLCJleHAiOjE5MTM3OTk1MzQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.gYJg30EjNnYNvDTFyJn064dTMluiTvpMI5Ss8Yj4rKg";
    protected Client client = null;
    protected GridClient grid = null;

    @BeforeTest
    public void setUp() {
        grid = new GridClient(accessKey, host);
        client = grid.lockDeviceForExecution("Audio", "@os='ios' and @serialnumber='f58b0eeba77f6e50aeb15d60b420604a94f0dec9'", 10, 50000);
        client.setReporter("xml", "", "Audio Test");

    }

    @Test
    public void quickStartiOSNativeDemo() throws InterruptedException {
        client.launch("com.apple.VoiceMemos", false, true);
//        client.click("NATIVE", "xpath=//*[@text='Voice Memos' and (./preceding-sibling::* | ./following-sibling::*)[@text='FaceTime']]", 0, 1);
//        for (int i = 0; i < 4; i++) {
        Thread.sleep(5000);
        client.click("NATIVE", "xpath=//*[@text='Record']", 0, 1);
        Thread.sleep(2000);
//            client.startAudioPlay("C:\\Users\\hania\\IdeaProjects\\GenericTesting\\src\\test\\java\\BluetoothTests\\DownloadedFiles\\16khz-16bit-mono.wav");
        client.startAudioPlay("/Users/nanjappa/Desktop/preamble10.wav");
//            Thread.sleep(40000);
        client.waitForAudioPlayEnd(60000);
        try {
            client.click("NATIVE", "xpath=//*[@text='Stop']", 0, 1);
        } catch (Exception e) {

        }
//            client.stopAudioPlay();
//        }
//        Thread.sleep(40000);
//        client.click("NATIVE", "xpath=//*[@text='Pause']", 0, 1);
//        client.click("NATIVE", "xpath=//*[@text='Done']", 0, 1);
//        client.stopAudioPlay();

    }

    @AfterTest
    public void tearDown() {
        client.generateReport(false);
        client.releaseClient();
    }
}


