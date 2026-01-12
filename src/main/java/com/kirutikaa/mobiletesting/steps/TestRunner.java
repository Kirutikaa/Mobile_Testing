package com.kirutikaa.mobiletesting.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features"
        ,glue={"com/kirutikaa/mobiletesting/steps"})
public class TestRunner extends AbstractTestNGCucumberTests {

}