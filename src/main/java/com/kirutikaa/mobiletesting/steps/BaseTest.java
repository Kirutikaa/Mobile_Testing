package com.kirutikaa.mobiletesting.steps;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public UiAutomator2Options options;

    public AndroidDriver appiumTest() throws MalformedURLException, InterruptedException, URISyntaxException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Sharvesh Muthu//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        options = new UiAutomator2Options();
        options.setDeviceName("Kiru_Mobile");

        options.setApp("C://Users//Workspace//Kirutikaa//Mobile_Testing//src//test//resources//General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;


    }
    public void endTest(){
        if (driver != null) {
            driver.quit();
        }

    }

    public void scroll(){
        boolean canScroll;
        do{
            canScroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile:scrollGesture", ImmutableMap.of("left",100, "top", 100, "width",200,"height",200,"percent",3.0));
        } while(canScroll);

    }

    public void longPress(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
     ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

    }
}
