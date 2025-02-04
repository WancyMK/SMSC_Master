package smsc_stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class smsc_Dashboard {
    WebDriver driver;

    @Given("I open the browser")
    public void i_open_the_browser() {

    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
    }

    @Then("The page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
//        String actualTitle = driver.getTitle();
//        Assertions.assertEquals(expectedTitle, actualTitle, "Page title does not match!");
//        driver.quit();
    }
}
