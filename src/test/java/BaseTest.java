import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService Service;
    protected UiAutomator2Options options;

    @BeforeClass
    public void AppiumTest() throws MalformedURLException {
        Service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Sharvesh Muthu//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        Service.start();

        options = new UiAutomator2Options();
        options.setDeviceName("Kiru_Mobile");

        options.setApp("C:////Users//Workspace//myFirstProject//MobileTesting//MobileTesting//src//test//resources//ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
    @AfterClass
    public void EndTest(){
        driver.quit();
    }
}
