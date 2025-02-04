package smsc_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/smsc_features/smsc_Login.feature",
//        glue = "smsc_stepDefinitions",
        glue = {"smsc_stepDefinitions", "smsc_runner"},
//        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {
}
