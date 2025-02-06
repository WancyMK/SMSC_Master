package smsc_stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class smsc_Login {
    WebDriver driver;

    @Given("I open the browser")
    public void i_open_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser opened and maximized");
    }

    @And("the user has valid login credentials")
    public void the_user_has_valid_login_credentials() {
    }

    @When("the user opens the application")
    public void the_user_opens_the_application() {
        driver.get("https://your-application-url.com");
    }

    @And("the user enters a valid username in the \"Username\" field and a valid password in the \"Password\" field")
    public void the_user_enters_valid_credentials() {
        driver.findElement(By.id("Username")).sendKeys("validUser");
        driver.findElement(By.id("Password")).sendKeys("validPass");
    }

    @And("the user clicks on the \"LOGIN\" button")
    public void the_user_clicks_login_button() {
        driver.findElement(By.id("LOGIN")).click();
    }

    @Then("the user should be successfully logged in and redirected to the dashboard")
    public void user_should_be_logged_in() {
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        assertTrue(dashboard.isDisplayed());
    }

    @And("the login page is accessible")
    public void the_login_page_is_accessible() {
        assertTrue(driver.findElement(By.id("loginPage")).isDisplayed());
    }

    @And("access to the design specifications")
    public void access_to_the_design_specifications() {
    }

    @Then("all visual elements of the login page should be accurately displayed according to the design specifications, with correct branding, labels, text, colors, sizes, and alignment")
    public void validate_visual_elements() {
    }

    @And("the user has invalid login credentials")
    public void the_user_has_invalid_login_credentials() {
    }

    @And("the user enters an invalid username in the \"Username\" field and an invalid password in the \"Password\" field")
    public void the_user_enters_invalid_credentials() {
        driver.findElement(By.id("Username")).sendKeys("invalidUser");
        driver.findElement(By.id("Password")).sendKeys("invalidPass");
    }

    @Then("the user should receive an error message like \"Invalid Username or Password.\"")
    public void user_should_receive_error_message() {
        WebElement error = driver.findElement(By.id("errorMessage"));
        assertEquals("Invalid Username or Password.", error.getText());
    }

    @When("the user leaves both the \"Username\" and \"Password\" fields blank")
    public void the_user_leaves_fields_blank() {
        driver.findElement(By.id("Username")).clear();
        driver.findElement(By.id("Password")).clear();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
