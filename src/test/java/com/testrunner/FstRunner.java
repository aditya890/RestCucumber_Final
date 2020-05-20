package com.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.serenitybdd.cucumber.CucumberWithSerenity;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/cucumber-reports"}, features = { "src/test/resources" }, glue = {"com.steps"}, tags = { "" }, monochrome = true, dryRun =false,strict=true)

public class FstRunner  {
	
}
//public class FstRunner extends AbstractTestNGCucumberTests {
//
//}
