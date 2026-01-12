package com.kirutikaa.mobiletesting.steps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.time.Instant;

public class GeneralStoreLogin {

    static AppiumDriver driver;

    @BeforeAll
    public static void before_all() throws MalformedURLException, InterruptedException, URISyntaxException {
        BaseTest baseTest = new BaseTest();
        driver = baseTest.appiumTest();
    }
   @AfterAll
    public static void end_all() throws MalformedURLException, InterruptedException {
        BaseTest baseTest = new BaseTest();
        baseTest.endTest();
    }

   @Given ("^the user wants to call the GeneralStore Mobile application$")
    public void the_user_wants_to_call_the_GeneralStore_Mobile_application(){

    }

    @When("^the GeneralStore application is displayed check the title of the page$")
    public void the_general_store_application_is_displayed_check_the_title_of_the_page() {
       WebElement Title = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']"));
       Assert.assertEquals("General Store",Title.getText());
    }
    @Then("^check the country dropdown list is displayed and enable$")
    public void check_the_country_dropdown_list_is_displayed_and_enable() {
        driver.findElement(By.className("android.widget.Spinner")).isDisplayed();
        WebElement function = driver.findElement(By.className("android.widget.Spinner"));
        function.isEnabled();
    }
    @And ("^check the name text box is displayed and enable to enter the text$")
    public void check_the_name_text_box_is_displayed_and_enable_to_enter_the_text(){
        driver.findElement(By.className("android.widget.EditText")).isDisplayed();
        WebElement textbox = driver.findElement(By.className("android.widget.EditText"));
        textbox.isEnabled();
    }

    @Then("^check the gender radio button are enable with options$")
    public void check_the_gender_radio_button_are_enable_with_options(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        driver.findElement(By.className("android.widget.RadioGroup")).isDisplayed();

        List<String> data = dataTable.row(0);
        WebElement male = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]"));
        Assert.assertEquals(data.get(0),male.getText());
        Thread.sleep(1000);

        List<String> data_new = dataTable.row(1);
        WebElement female = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]"));
        Assert.assertEquals(data_new.get(0),female.getText());
        Thread.sleep(1000);
    }

    @Then("^check for Lets Shop button$")
    public void check_for_Lets_Shop_button(){
        WebElement shop_button = driver.findElement(By.className("android.widget.Button"));
        Assert.assertEquals("Let's  Shop",shop_button.getText());

    }

    //Scenario: 2. As a user i want to validate the GeneralStore application error message
    @And("^error message should displayed$")
    public void error_message_should_displayed(){
       String Toast_name = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
       Assert.assertEquals("Please enter your name",Toast_name);

    }

    //Scenario: 3. As a user i want to validate the GeneralStore application LoginAction

    @Then("^select the country in dropdown$")
    public void select_the_country_in_dropdown() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));")).click();
        Thread.sleep(3000);
    }

    @And("^Enter the name in textbox$")
    public void Enter_the_name_in_textbox(){
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kiru");
        //driver.hideKeyboard();

    }
    @And("^select the gender radio button$")
    public void select_the_gender_radio_button() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        Thread.sleep(3000);
    }

    @And("^click the let's shop button$")
    public void click_the_let_shop_button() throws InterruptedException {
        driver.findElement(By.className("android.widget.Button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
}

    public void LogIn() throws InterruptedException {
        WebElement Page_title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        Assert.assertEquals("Products",Page_title.getText());

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));")).click();

        driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"));")).click();
        driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
    }
}
