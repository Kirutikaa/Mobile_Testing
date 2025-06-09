package com.kirutikaa.mobiletesting;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class AppiumBasic extends BaseTest{

    @Test
    public void WifiSetting(){
        driver.findElement(new AppiumBy.ByAccessibilityId("Preference")).click();


    }
}
