package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Path to  feature files
        glue = "StepDefinitions",         // Package where your step definition classes are located
        plugin = {"pretty", "html:target/cucumber-html-reports.html" })
public class Run {
    // This class will not contain any code, it serves as an entry point for Cucumber tests
}
