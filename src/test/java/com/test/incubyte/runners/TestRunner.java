package com.test.incubyte.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.test.incubyte.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner {
}
