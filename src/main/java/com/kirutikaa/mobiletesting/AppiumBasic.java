package com.kirutikaa.mobiletesting;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.appium.java_client.CommandExecutionHelper.executeScript;

public class AppiumBasic extends BaseTest{

    @Test
    public void WifiSetting() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAccessibilityId("Preference")).click();

        driver.findElement(new AppiumBy.ByAccessibilityId("3. Preference dependencies")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Rahul Wifi");



    }
}
