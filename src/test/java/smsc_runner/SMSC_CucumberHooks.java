package smsc_runner;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import static smsc_accelerators.SMSC_Base.*;

public class SMSC_CucumberHooks {

//    	Everything that needs to be done before every scenario is run
    @Before
    public void initialize() throws InterruptedException {
        setUp();
//        String url = "https://www.google.com";
//        driver.get(url);

    }

//    	Everything that needs to be done after every scenario is run
    @After
    public void cleanup() {
        tearDown();
    }
}
