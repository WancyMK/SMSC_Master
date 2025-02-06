package smsc_stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions; // Use JUnit 5 Assertions

import java.time.Duration;

public class smsc_Logout {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I open the browser")
    public void i_open_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        System.out.println("Browser opened and maximized");
    }

    @Given("the user is logged in to the ABSA Management Application")
    public void the_user_is_logged_in_to_the_absa_management_application() {
        driver.get("https://absa-management-app.com/login");
        driver.findElement(By.name("username")).sendKeys("validUsername");  // Replace with your test data
        driver.findElement(By.name("password")).sendKeys("validPassword");  // Replace with your test data
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // More robust wait: Wait for an element on the dashboard page
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard-element-id"))); // Replace with a real element ID

        System.out.println("User is logged in to the ABSA Management Application");
    }

    @When("the user clicks on the {string} button on the sidebar")
    public void the_user_clicks_on_the_button_on_the_sidebar(String buttonText) {
        try {
            WebElement logoutButton = driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));
            logoutButton.click();
            System.out.println("User clicked on the '" + buttonText + "' button");
        } catch (Exception e) {
            System.err.println("Error clicking the button: " + e.getMessage());
            Assertions.fail("Logout button not found or clickable."); // Fail the test
        }
    }


    @Then("the user should be navigated to the Login page")
    public void the_user_should_be_navigated_to_the_login_page() {
        wait.until(ExpectedConditions.urlContains("login")); //Or wait for a specific element on the login page
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("login"), "User is not on the Login page");
        System.out.println("User is navigated to the Login page");
        driver.quit();
    }

    @When("the screen is inactive for {int} minutes")
    public void the_screen_is_inactive_for_minutes(int minutes) {
        System.out.println("Simulating inactivity for " + minutes + " minutes (REPLACE WITH PROPER INACTIVITY SIMULATION)");

    }

    @Then("the user should be automatically logged out")
    public void the_user_should_be_automatically_logged_out() {
        wait.until(ExpectedConditions.urlContains("login")); //Or wait for a specific element on the login page
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("login"), "User is not automatically logged out");
        System.out.println("User is automatically logged out");
    }
}

