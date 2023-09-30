package com.application.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue = {"com.application.tests","com.framework.base"}, plugin= {"pretty", "html: Reports/AutomationTestReport.html"})

// @CucumberOptions(features="Features", glue = {"com.application.tests","com.framework.base"}, plugin= {"pretty", "html: Reports/AutomationTestReport.html"}, tags ="@Smoke")

public class TestRunner {

}
