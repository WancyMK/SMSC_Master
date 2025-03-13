package smsc_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/smsc_features/smsc_Logout.feature",

        glue = {"smsc_stepDefinitions", "smsc_runner"},

        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","progress","summary","junit:target/CucumberReports/cucumberReport.xml"},

        monochrome = true
)
public class TestRunner {
}
