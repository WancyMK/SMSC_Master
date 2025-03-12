package smsc_runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import smsc_accelerators.SMSC_Base;
import smsc_utility.Logs;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;
import static smsc_accelerators.SMSC_Base.*;

public class SMSC_CucumberHooks {
//    	Everything that needs to be done before every scenario is run
    @Before
    public void initialize() throws InterruptedException {
        setUp();
        String baseUrl = SMSC_Utils.ConfigReader.getProperty("base_url");
        System.out.println("Base URL from config file: " + baseUrl);
        driver.get(baseUrl);
        Thread.sleep(9000);
    }

//    	Everything that needs to be done after every scenario is run
    @After
    public void cleanup(Scenario scenario) {
        try {
            if(scenario.isFailed()) {
                final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "image");
                System.out.println("After Hook");
            }
            Logs.endTestCase();
            SMSC_Base.tearDown();

        }catch(Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to run After scenario");
        }
    }
}
